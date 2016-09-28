/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package izafiro;

import java.awt.Point;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Jonathan
 */
public class Rodante extends Thread {
    
    private String sentido;
    private int limite1;
    private int limite2;
    private JLabel imagen;
    private Icon[] posiciones;
    private int speed;
    private int intervalo;
    private int costadoHor;
    private int costadoVer;
    private JLabel tahi;
    private Icon imHurt; //Imagen de dano a Tahi
    private boolean poderHacerDano;
    private JFrame escenario;
    private int intervaloEsperaEscenario = 1300;
    
    public Rodante(JFrame e, JLabel t, String sentido, int limite1, int limite2, JLabel imagen, Icon pos1, Icon pos2, int speed, int intervalo, int cH, int cV)
    {
      this.escenario = e;  
      this.tahi = t;  
      this.sentido = sentido;
      this.limite1 = limite1;
      this.limite2 = limite2;
      this.imagen = imagen;
      this.speed = speed;
      this.intervalo = intervalo;
      this.costadoHor = cH;
      this.costadoVer = cV;
      this.poderHacerDano = true;
      posiciones = new Icon[2];
      posiciones[0] = pos1;
      posiciones[1] = pos2;
      
      imHurt = new ImageIcon (getClass().getResource("imagenes/personajes/tahi/"+GestorJuego.getInstance().getGenero()+"0.png"));
    }
    
    @Override
    public void run()
    {
      if(sentido.equals("horizontal"))
      {
        while(!GestorJuego.getInstance().isTerminarJuego())
        {
           moverDerecha(limite1);
           moverIzquierda(limite2);
        }
      }
      else
      {
        while(!GestorJuego.getInstance().isTerminarJuego())
        {           
           moverArriba(limite1);
           moverAbajo(limite2);
        }  
      }
    }
    
    public void moverIzquierda(int limite)
    {
       imagen.setIcon(posiciones[1]);    
       while(imagen.getX() > limite)
       {  
         while(Teclado.getInstace().isPausa())
         {
           try { sleep(1000); } catch (InterruptedException ex) {}  
         }
         while(escenario != GestorJuego.getInstance().getEscenarioActual()) //Mientras Tahi o Lily no esten en el escenario del animal o aldeano, éste no se moverá.
         {
           try {sleep(intervaloEsperaEscenario);} catch (InterruptedException ex) {}  
         }
         
         imagen.setLocation(imagen.getX()-speed,imagen.getY());
         contactoTahi();
         try { Thread.sleep(intervalo); } catch (InterruptedException ex) {}           
       }
    }

    public void moverDerecha(int limite)
    {
       imagen.setIcon(posiciones[0]);    
       while(imagen.getX() < limite)
       {
         while(Teclado.getInstace().isPausa())
         {
           try { sleep(1000); } catch (InterruptedException ex) {}  
         }
         while(escenario != GestorJuego.getInstance().getEscenarioActual()) //Mientras Tahi o Lily no esten en el escenario del animal o aldeano, éste no se moverá.
         {
           try {sleep(intervaloEsperaEscenario);} catch (InterruptedException ex) {}  
         }
         
         imagen.setLocation(imagen.getX()+speed,imagen.getY());
         contactoTahi();
         try { Thread.sleep(intervalo); } catch (InterruptedException ex) {}          
       } 
    }

    public void moverArriba(int limite)
    {
       imagen.setIcon(posiciones[0]);

       while(imagen.getY() > limite)
       {
         while(Teclado.getInstace().isPausa())
         {
           try { sleep(1000); } catch (InterruptedException ex) {}  
         }
         while(escenario != GestorJuego.getInstance().getEscenarioActual()) //Mientras Tahi o Lily no esten en el escenario del animal o aldeano, éste no se moverá.
         {
           try {sleep(intervaloEsperaEscenario);} catch (InterruptedException ex) {}  
         }
         
         imagen.setLocation(imagen.getX(),imagen.getY()-speed);
         contactoTahi();
         try { Thread.sleep(intervalo); } catch (InterruptedException ex) {}
       }
    } 


    public void moverAbajo(int limite)
    {
       imagen.setIcon(posiciones[1]); 
       while(imagen.getY() < limite)
       {
         while(Teclado.getInstace().isPausa())
         {
           try { sleep(1000); } catch (InterruptedException ex) {}  
         }
         while(escenario != GestorJuego.getInstance().getEscenarioActual()) //Mientras Tahi o Lily no esten en el escenario del animal o aldeano, éste no se moverá.
         {
           try {sleep(intervaloEsperaEscenario);} catch (InterruptedException ex) {}  
         }
         
         imagen.setLocation(imagen.getX(),imagen.getY()+speed);
         contactoTahi();
         try { Thread.sleep(intervalo); } catch (InterruptedException ex) {}
       } 
    }

    public void contactoTahi()
    {
      if(hacerDano() && poderHacerDano)
      {
        Sonidos.getInstance().reproducir("dano");
        if(GestorJuego.getInstance().getSalud()-1 == 0){tahi.setLocation(0,0);}
        GestorJuego.getInstance().setSalud(GestorJuego.getInstance().getSalud()-1);
        tahi.setIcon(imHurt);
        new Dano().start();
      }         
    }
    
    public boolean hacerDano()
    {
       Point p1 = new Point(tahi.getX(),tahi.getY());
       Point p2 = new Point(tahi.getX()+tahi.getWidth(),tahi.getY());
       Point p3 = new Point(tahi.getX(),tahi.getY()+tahi.getHeight());
       Point p4 = new Point(tahi.getX()+tahi.getWidth(),tahi.getY()+tahi.getHeight()); 
       
       
       if(p1.x >= imagen.getX()+costadoHor && p1.x <= imagen.getX()+imagen.getWidth()-costadoHor
          && p1.y >= imagen.getY()+costadoVer && p1.y <= imagen.getY()+imagen.getHeight()-costadoVer){return true;}
       
       if(p2.x >= imagen.getX()+costadoHor && p2.x <= imagen.getX()+imagen.getWidth()-costadoHor
          && p2.y >= imagen.getY()+costadoVer && p2.y <= imagen.getY()+imagen.getHeight()-costadoVer){return true;}
       
       if(p3.x >= imagen.getX()+costadoHor && p3.x <= imagen.getX()+imagen.getWidth()-costadoHor
          && p3.y >= imagen.getY()+costadoVer && p3.y <= imagen.getY()+imagen.getHeight()-costadoVer){return true;}
       
       if(p4.x >= imagen.getX()+costadoHor && p4.x <= imagen.getX()+imagen.getWidth()-costadoHor
          && p4.y >= imagen.getY()+costadoVer && p4.y <= imagen.getY()+imagen.getHeight()-costadoVer){return true;} 
       
        
       if(imagen.getX()+costadoHor >= p1.x && imagen.getX()+costadoHor <= p2.x
          && imagen.getY()+costadoVer >= p1.y && imagen.getY()+costadoVer <= p3.y){return true;}
       
       if(imagen.getX()+ imagen.getWidth()-costadoHor >= p1.x && imagen.getX()+ imagen.getWidth()-costadoHor <= p2.x
          && imagen.getY()+ imagen.getHeight()-costadoVer >= p1.y && imagen.getY()+ imagen.getHeight()-costadoVer <= p3.y){return true;}
       
        
       return false;
    }
    
    public class Dano extends Thread
    {
       @Override
       public void run()
       {
         poderHacerDano = false;  
         try { Thread.sleep(3000); } catch (InterruptedException ex) {}
         poderHacerDano = true;
       }
    }
    
}
