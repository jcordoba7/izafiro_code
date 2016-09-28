/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package izafiro;

import java.applet.AudioClip;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Jacc89
 */
public class Animal extends Thread {
    
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
    private JFrame escenario;
    AudioClip hurt;
        
    public Animal(JFrame e,Conversador c, Deposito d, Desplazamiento desp, Obstaculo aba, Obstaculo arr, Obstaculo izq, Obstaculo der, int s, int i, JLabel tahi)
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
    }

    @Override
    public void run()
    {
       int numPasos = 20; 
       int numRandom;
       int cont = 0;

       Random randomGenerator = new Random();
       numRandom = randomGenerator.nextInt(4); 

       while(!GestorJuego.getInstance().isTerminarJuego())
       {        
         if(cont == numPasos)
         {
           numRandom = randomGenerator.nextInt(4);
           cont = 0;
           try {
             sleep(1000);
           } catch (InterruptedException ex) {}
         }
         else
         {  
           while(Teclado.getInstace().isPausa())
           {
             try { sleep(1000); } catch (InterruptedException ex) {}  
           }
           while(escenario != GestorJuego.getInstance().getEscenarioActual()) //Mientras Tahi o Lily no esten en el escenario del animal o aldeano, éste no se moverá.
           {
             try {sleep(1500);} catch (InterruptedException ex) {}  
           }
           
           switch(numRandom)
           {
             case(0): 
                     if(!d.isVentanaAbierta()&&!desplazamiento.obstaculoAba(c.getImagen(),obstaculosAbajo)){
                         c.getImagen().setLocation(c.getImagen().getX(),c.getImagen().getY()+speed);
                         c.getImagen().setIcon(c.getPosiciones().get(0));}else{cont = numPasos-1;}
                     break; 
             case(1): 
                     if(!d.isVentanaAbierta()&&!desplazamiento.obstaculoIzq(c.getImagen(),obstaculosIzquierda)){
                         c.getImagen().setLocation(c.getImagen().getX()-speed,c.getImagen().getY());
                         c.getImagen().setIcon(c.getPosiciones().get(1));}else{cont = numPasos-1;}
                     break; 

             case(2): 
                     if(!d.isVentanaAbierta()&&!desplazamiento.obstaculoDer(c.getImagen(),obstaculosDerecha)){
                         c.getImagen().setLocation(c.getImagen().getX()+speed,c.getImagen().getY());
                         c.getImagen().setIcon(c.getPosiciones().get(2));}else{cont = numPasos-1;}
                     break; 
             case(3): 
                     if(!d.isVentanaAbierta()&&!desplazamiento.obstaculoArr(c.getImagen(),obstaculosArriba)){
                         c.getImagen().setLocation(c.getImagen().getX(),c.getImagen().getY()-speed);
                         c.getImagen().setIcon(c.getPosiciones().get(3));}else{cont = numPasos-1;}
                     break; 
           } 
           cont++;
         }

         try {
            sleep(intervalo);
         } catch (InterruptedException ex) {}         
       }
    }
    
    
}
