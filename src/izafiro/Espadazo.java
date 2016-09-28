/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package izafiro;

import java.awt.Point;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Jonathan
 */
public class Espadazo extends Thread {
    
    private ArrayList<Enemigo> enemigos;
    private JLabel espada;
    private JLabel tahi;
    private Icon destello;
    private Icon destelloSpider;
    
    public Espadazo(ArrayList<Enemigo> enemigos, JLabel espada, JLabel tahi)
    {
      this.enemigos = enemigos;
      this.espada = espada;
      this.tahi = tahi;
      this.destello = new ImageIcon (getClass().getResource("imagenes/objetos/destello.gif"));
      this.destelloSpider = new ImageIcon (getClass().getResource("imagenes/objetos/destellospider.gif"));
    }
  
    @Override
    public void run()
    {     
        espada.setLocation(tahi.getX()-((espada.getPreferredSize().width - tahi.getWidth())/2), tahi.getY()-((espada.getPreferredSize().height - tahi.getHeight())/2));
        if(espada.getSize().width == 0)
         {
            if(GestorJuego.getInstance().getRecursos()[5])
            {
                espada.setIcon(new ImageIcon (getClass().getResource("imagenes/objetos/espadazo2.gif")));
            }
            else
            {
                espada.setIcon(new ImageIcon (getClass().getResource("imagenes/objetos/espadazo.gif")));
            }
            espada.setSize(espada.getPreferredSize());
      
            Sonidos.getInstance().reproducir("espadazo");
            try {
            Thread.sleep(330);
            } catch (InterruptedException ex) {} 
      
            atacarEnemigo();
      
            espada.setSize(0,0);
            Sonidos.getInstance().detener("espadazo");            
        }
    }
    
    public void atacarEnemigo()
    {
      Icon icon;  
      for(int i=0; i<enemigos.size(); i++)
      { 
        if(contactoEnemigo(enemigos.get(i)))
        {
          icon = enemigos.get(i).getC().getImagen().getIcon(); 
          
          if(enemigos.get(i).getC().getImagen().getIcon().getIconWidth() != 40){
            enemigos.get(i).getC().getImagen().setIcon(destello);  
          }else{
            enemigos.get(i).getC().getImagen().setIcon(destelloSpider);  
          }
           
          try { Thread.sleep(400); } catch (InterruptedException ex) {}
          enemigos.get(i).getC().getImagen().setLocation(2000,2000);
          enemigos.get(i).getC().getImagen().setIcon(icon);
          GestorJuego.getInstance().actualizarPuntaje(1);
        }
      }
    }
    
    public boolean contactoEnemigo(Enemigo e)
    {
       Point p1 = new Point(espada.getX(),espada.getY());
       Point p2 = new Point(espada.getX()+espada.getWidth(),espada.getY());
       Point p3 = new Point(espada.getX(),espada.getY()+espada.getHeight());
              
       Conversador c = e.getC();
              
       Point e1 = new Point(c.getImagen().getX(),c.getImagen().getY());
       Point e2 = new Point(c.getImagen().getX()+c.getImagen().getWidth(),c.getImagen().getY());
       Point e3 = new Point(c.getImagen().getX(),c.getImagen().getY()+c.getImagen().getHeight());
       Point e4 = new Point(c.getImagen().getX()+c.getImagen().getWidth(),c.getImagen().getY()+c.getImagen().getHeight());       
       
       if(e1.x >= p1.x && e1.x <= p2.x && e1.y >= p1.y && e1.y <= p3.y){return true;}
       if(e2.x >= p1.x && e2.x <= p2.x && e2.y >= p1.y && e2.y <= p3.y){return true;}
       if(e3.x >= p1.x && e3.x <= p2.x && e3.y >= p1.y && e3.y <= p3.y){return true;}
       if(e4.x >= p1.x && e4.x <= p2.x && e4.y >= p1.y && e4.y <= p3.y){return true;}
       
       return false;
    }
    
}
