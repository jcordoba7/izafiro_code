/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package izafiro;

import java.applet.AudioClip;
import java.awt.Point;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Jacc89
 */
public class Enemigo extends Thread {
    
    private Conversador c; 
    private Deposito d;
    private Desplazamiento desplazamiento;
    private Obstaculo obstaculosAbajo;
    private Obstaculo obstaculosArriba;
    private Obstaculo obstaculosIzquierda;
    private Obstaculo obstaculosDerecha;
    private int speed;
    private int intervalo;
    private JLabel tahi;
    private GestorJuego t;
    private AudioClip hurt;
    private Icon imHurt; //Imagen de dano a Tahi  
    private JFrame escenario;
    
    
    public Enemigo(JFrame e, Conversador c, Deposito d, Desplazamiento desp, Obstaculo aba, Obstaculo arr, Obstaculo izq, Obstaculo der, int s, int i, JLabel tahi)
    {
       this.escenario = e; 
       this.c = c; 
       this.d = d;
       this.desplazamiento = desp;
       this.obstaculosAbajo = aba;
       this.obstaculosArriba = arr;
       this.obstaculosIzquierda = izq;
       this.obstaculosDerecha = der;
       this.speed = s;
       this.intervalo = i;
       this.tahi = tahi;//Label de Tahi
       this.t = GestorJuego.getInstance();//Se necesita a Tahi para validar su estado (salud)
       
       //hurt = Sonidos.getInstance().getDano();
       imHurt = new ImageIcon (getClass().getResource("imagenes/personajes/tahi/"+GestorJuego.getInstance().getGenero()+"0.png"));
    }

    @Override
    public void run()
    {
       int numPasos = 20; 
       int numRandom;
       int cont = 0;
       int espera = 2000;

       Random randomGenerator = new Random();
       numRandom = randomGenerator.nextInt(4); 

       while(!GestorJuego.getInstance().isTerminarJuego())
       {       
         if(cont == numPasos)
         {
           numRandom = randomGenerator.nextInt(4);
           cont = 0;
           try {
             sleep(300);
           } catch (InterruptedException ex) {}
         }
         else
         {   
           while(Teclado.getInstace().isPausa())
           {
             try { sleep(1000); } catch (InterruptedException ex) {}  
           }
           while(escenario != GestorJuego.getInstance().getEscenarioActual()) //Mientras Tahi o Lily no esten en el escenario del enemigo, éste no se moverá.
           {
             try {sleep(1500);} catch (InterruptedException ex) {}  
           }
           
           switch(numRandom)
           {
             case(0): 
                     if(!d.isVentanaAbierta()&&!desplazamiento.obstaculoAba(c.getImagen(),obstaculosAbajo)&&!getC().getImagen().getIcon().toString().contains("destello")){
                         getC().getImagen().setLocation(getC().getImagen().getX(),getC().getImagen().getY()+speed);
                         contactoTahi(espera);                           
                         getC().getImagen().setIcon(getC().getPosiciones().get(0));}else{cont = numPasos-1;}
                     break; 
             case(1): 
                     if(!d.isVentanaAbierta()&&!desplazamiento.obstaculoIzq(c.getImagen(),obstaculosIzquierda)&&!getC().getImagen().getIcon().toString().contains("destello")){
                         getC().getImagen().setLocation(getC().getImagen().getX()-speed,getC().getImagen().getY());
                         contactoTahi(espera);
                         getC().getImagen().setIcon(getC().getPosiciones().get(1));}else{cont = numPasos-1;}
                     break; 

             case(2): 
                     if(!d.isVentanaAbierta()&&!desplazamiento.obstaculoDer(c.getImagen(),obstaculosDerecha)&&!getC().getImagen().getIcon().toString().contains("destello")){
                         getC().getImagen().setLocation(getC().getImagen().getX()+speed,getC().getImagen().getY());
                         contactoTahi(espera);
                         getC().getImagen().setIcon(getC().getPosiciones().get(2));}else{cont = numPasos-1;}
                     break; 
             case(3): 
                     if(!d.isVentanaAbierta()&&!desplazamiento.obstaculoArr(c.getImagen(),obstaculosArriba)&&!getC().getImagen().getIcon().toString().contains("destello")){
                         getC().getImagen().setLocation(getC().getImagen().getX(),getC().getImagen().getY()-speed);
                         contactoTahi(espera);
                         getC().getImagen().setIcon(getC().getPosiciones().get(3));}else{cont = numPasos-1;}
                     break; 
           } 
           cont++;
         }

         try {
            sleep(intervalo);
         } catch (InterruptedException ex) {}         
       }
    }
    
    public void contactoTahi(int espera)
    {
       while(Teclado.getInstace().isPausa()){} 
       if(hacerDano())
       {
         Sonidos.getInstance().reproducir("dano");  
         //hurt.play();
         if(t.getSalud()-1 == 0){tahi.setLocation(0,0);}
         t.setSalud(t.getSalud()-1);
         tahi.setIcon(imHurt);         
         try {
             sleep(espera);
         } catch (InterruptedException ex) {}
       } 
    }
    
    public boolean hacerDano()
    {
       Point p1 = new Point(tahi.getX(),tahi.getY());
       Point p2 = new Point(tahi.getX()+tahi.getWidth(),tahi.getY());
       Point p3 = new Point(tahi.getX(),tahi.getY()+tahi.getHeight());
       Point p4 = new Point(tahi.getX()+tahi.getWidth(),tahi.getY()+tahi.getHeight()); 
       
       int costado = 10;
       double inferior = 0.7;
       
       if(p1.x >= getC().getImagen().getX()+costado && p1.x <= getC().getImagen().getX()+getC().getImagen().getWidth()-costado
          && p1.y >= getC().getImagen().getY() && p1.y <= getC().getImagen().getY()+getC().getImagen().getHeight()*inferior){return true;}
       
       if(p2.x >= getC().getImagen().getX()+costado && p2.x <= getC().getImagen().getX()+getC().getImagen().getWidth()-costado
          && p2.y >= getC().getImagen().getY() && p2.y <= getC().getImagen().getY()+getC().getImagen().getHeight()*inferior){return true;}
       
       if(p3.x >= getC().getImagen().getX()+costado && p3.x <= getC().getImagen().getX()+getC().getImagen().getWidth()-costado
          && p3.y >= getC().getImagen().getY() && p3.y <= getC().getImagen().getY()+getC().getImagen().getHeight()*inferior){return true;}
       
       if(p4.x >= getC().getImagen().getX()+costado && p4.x <= getC().getImagen().getX()+getC().getImagen().getWidth()-costado
          && p4.y >= getC().getImagen().getY() && p4.y <= getC().getImagen().getY()+getC().getImagen().getHeight()*inferior){return true;} 
       
        
       if(getC().getImagen().getX()+costado >= p1.x && getC().getImagen().getX()+costado <= p2.x
          && getC().getImagen().getY() >= p1.y && getC().getImagen().getY() <= p3.y){return true;}
       
       if(getC().getImagen().getX()+ getC().getImagen().getWidth()-costado >= p1.x && getC().getImagen().getX()+ getC().getImagen().getWidth()-costado <= p2.x
          && getC().getImagen().getY()+ getC().getImagen().getHeight()*inferior >= p1.y && getC().getImagen().getY()+ getC().getImagen().getHeight()*inferior <= p3.y){return true;}
       
        
       return false;
    }

    /**
     * @return the c
     */
    public Conversador getC() {
        return c;
    }
    
}
