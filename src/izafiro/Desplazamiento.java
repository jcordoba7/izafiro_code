package izafiro;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Point;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author WINDOWS
 */
public class Desplazamiento {
    
   private static Desplazamiento desp = null;
    
   public Desplazamiento(){}
   
   public static Desplazamiento getInstance()
   {
     if(desp == null) { desp = new Desplazamiento(); }
     return desp;
   }
   
   public int multiploDeN(int num,int speed)
   {
       int a = num;
       int b = num;       
       while(a%speed != 0){a--;}
       while(b%speed != 0){b++;}
       if(num-a > b-num){return b;}else{return a;}
   }
     
   public void avanzar(JLabel tahi, int izquierda, int derecha, int FRECUENCIA, Deposito d)
    {
       if( d.getPaso() == FRECUENCIA )       
       {
          if( d.getPie() == 0 )          
          {
             tahi.setIcon(new ImageIcon (getClass().getResource("imagenes/personajes/tahi/"+GestorJuego.getInstance().getGenero()+izquierda+".png")));
             d.setPie(1);
          }
          else
          {
             tahi.setIcon(new ImageIcon (getClass().getResource("imagenes/personajes/tahi/"+GestorJuego.getInstance().getGenero()+derecha+".png")));
             d.setPie(0);
          }   
          d.setPaso(0);
       }
       else 
       {
          d.setPaso(d.getPaso()+1); 
          if( d.getPie() == 0 )
          {
             tahi.setIcon(new ImageIcon (getClass().getResource("imagenes/personajes/tahi/"+GestorJuego.getInstance().getGenero()+izquierda+".png"))); 
          }
          else
          {
             tahi.setIcon(new ImageIcon (getClass().getResource("imagenes/personajes/tahi/"+GestorJuego.getInstance().getGenero()+derecha+".png")));
          }
       }       
   } 
   
   public void detenerse(JLabel tahi, int direccion)
   {
       switch(direccion)
       {
          case(0): tahi.setIcon(new ImageIcon (getClass().getResource("imagenes/personajes/tahi/"+GestorJuego.getInstance().getGenero()+"2.png"))); 
                   break;
          case(1): tahi.setIcon(new ImageIcon (getClass().getResource("imagenes/personajes/tahi/"+GestorJuego.getInstance().getGenero()+"11.png")));
                   break;
       }
   } 
   
   
   public void cambiarPantalla(JFrame origen, JFrame destino, JLabel tahi, int x, int y, int speed)
   {  
       destino.setVisible(true);
       origen.setVisible(false);
       origen.setLocationRelativeTo(null);  
       
       GestorJuego.getInstance().setEscenarioActual(destino);
                     
       for(int i = 0; i<destino.getContentPane().getComponents().length;i++)
       {        
          if(destino.getContentPane().getComponent(i).getAccessibleContext().getAccessibleName().equalsIgnoreCase("tahi"))
          {             
             destino.getContentPane().getComponent(i).setLocation(multiploDeN(x,speed),multiploDeN(y,speed));
             break;
          }            
       }
   }
      
   
   public boolean contiene(JLabel campo, Point punto)
    {
       if(punto.x >= campo.getX() && punto.x <= campo.getX()+campo.getWidth())
       {
          if(punto.y >= campo.getY() && punto.y <= campo.getY()+campo.getHeight())
          {
             return true; 
          }
       }
       
       return false;    
    }
   
   
   public boolean obstaculoAba(JLabel posActual, Obstaculo obstaculosAbajo)
    {           
       if(Teclado.getInstace().isPausa()) //no debe estar en pausa para poder moverse
       {
          return true;
       }      
        
       int tam = multiploDeN(posActual.getWidth(),GestorJuego.getInstance().getSpeed());
        
       for(int i = 0; i<obstaculosAbajo.getLineas().size(); i++)
       {
         if(posActual.getX() >= obstaculosAbajo.getLineas().get(i).getX1() //Choca con todo el cuerpo
            && posActual.getX()+tam <= obstaculosAbajo.getLineas().get(i).getX2() )
         {
            if( posActual.getY()+tam == obstaculosAbajo.getLineas().get(i).getY1() )
            {
              return true;  
            }
         }
         else
         {
            if(posActual.getX() <= obstaculosAbajo.getLineas().get(i).getX2() //Choca con hombro izq
               && posActual.getX()+tam > obstaculosAbajo.getLineas().get(i).getX2() )
            { 
               if( posActual.getY()+tam == obstaculosAbajo.getLineas().get(i).getY1() )
              {
                return true;  
              } 
            }
            else
            {
              if(posActual.getX() < obstaculosAbajo.getLineas().get(i).getX1() //Choca con hombro der
               && posActual.getX()+tam > obstaculosAbajo.getLineas().get(i).getX1() )
              { 
                 if( posActual.getY()+tam == obstaculosAbajo.getLineas().get(i).getY1() )
                 {
                   return true;  
                 } 
              }
              else
              {
                 if(posActual.getX() < obstaculosAbajo.getLineas().get(i).getX1() //Choca con el estomago
                    && posActual.getX()+tam > obstaculosAbajo.getLineas().get(i).getX2() )
                 { 
                    if( posActual.getY()+tam == obstaculosAbajo.getLineas().get(i).getY1() )
                    {
                      return true;  
                    } 
                 }    
              }
            }
         }
       }
       return false; 
    }
   
   public boolean obstaculoIzq(JLabel posActual, Obstaculo obstaculosIzquierda)
    { 
       if(Teclado.getInstace().isPausa()) //no debe estar en pausa para poder moverse
       {
          return true;
       }    
        
       int tam = multiploDeN(posActual.getWidth(),GestorJuego.getInstance().getSpeed());
       
       for(int i = 0; i<obstaculosIzquierda.getLineas().size(); i++)
       {  
         if(posActual.getY() >= obstaculosIzquierda.getLineas().get(i).getY1()
            && posActual.getY()+tam <= obstaculosIzquierda.getLineas().get(i).getY2() ) //Choca con todo el cuerpo
         {
            if( posActual.getX() == obstaculosIzquierda.getLineas().get(i).getX1() )
            {
              return true;  
            }
         }
         else
         {
           if(posActual.getY() <= obstaculosIzquierda.getLineas().get(i).getY2() //Choca con la cabeza
              && posActual.getY()+tam > obstaculosIzquierda.getLineas().get(i).getY2() )
           {
              if( posActual.getX() == obstaculosIzquierda.getLineas().get(i).getX1() )
              {
                return true;  
              } 
           }
           else
           {
             if(posActual.getY() < obstaculosIzquierda.getLineas().get(i).getY1() //Choca con los pies
                && posActual.getY()+tam >= obstaculosIzquierda.getLineas().get(i).getY1() )
             {
                if( posActual.getX() == obstaculosIzquierda.getLineas().get(i).getX1() )
                {
                  return true;  
                } 
             }
             else
             {
                if(posActual.getY() < obstaculosIzquierda.getLineas().get(i).getY1() //Choca con el estomago
                   && posActual.getY()+tam > obstaculosIzquierda.getLineas().get(i).getY2() )
                { 
                    if( posActual.getX() == obstaculosIzquierda.getLineas().get(i).getX1() )
                    {
                      return true;  
                    } 
                }
             }
           }
         }    
       }
       return false;     
    }
    
    public boolean obstaculoDer(JLabel posActual, Obstaculo obstaculosDerecha)
    {
       if(Teclado.getInstace().isPausa()) //no debe estar en pausa para poder moverse
       {
          return true;
       }   
        
       int tam = multiploDeN(posActual.getWidth(),GestorJuego.getInstance().getSpeed());
       
       for(int i = 0; i<obstaculosDerecha.getLineas().size(); i++)
       {  
         if(posActual.getY() >= obstaculosDerecha.getLineas().get(i).getY1()
            && posActual.getY()+tam <= obstaculosDerecha.getLineas().get(i).getY2() ) //Choca con todo el cuerpo
         {
            if( posActual.getX()+tam == obstaculosDerecha.getLineas().get(i).getX1() )
            {
              return true;  
            }
         }
         else
         {
           if(posActual.getY() <= obstaculosDerecha.getLineas().get(i).getY2() //Choca con la cabeza
              && posActual.getY()+tam > obstaculosDerecha.getLineas().get(i).getY2() )
           {
              if( posActual.getX()+tam == obstaculosDerecha.getLineas().get(i).getX1() )
              {
                return true;  
              } 
           }
           else
           {
             if(posActual.getY() < obstaculosDerecha.getLineas().get(i).getY1() //Choca con los pies
                && posActual.getY()+tam >= obstaculosDerecha.getLineas().get(i).getY1() )
             {
                if( posActual.getX()+tam == obstaculosDerecha.getLineas().get(i).getX1() )
                {
                  return true;  
                } 
             }
             else
             {
                if(posActual.getY() < obstaculosDerecha.getLineas().get(i).getY1() //Choca con el estomago
                   && posActual.getY()+tam > obstaculosDerecha.getLineas().get(i).getY2() )
                { 
                    if( posActual.getX()+tam == obstaculosDerecha.getLineas().get(i).getX1() )
                    {
                      return true;  
                    } 
                }
             }
           }
         }    
       }
       return false; 
    }
    
    public boolean obstaculoArr(JLabel posActual, Obstaculo obstaculosArriba)
    {
       if(Teclado.getInstace().isPausa()) //no debe estar en pausa para poder moverse
       {
          return true;
       }    
        
       int tam = multiploDeN(posActual.getWidth(),GestorJuego.getInstance().getSpeed());
       
       for(int i = 0; i<obstaculosArriba.getLineas().size(); i++)
       {
         if(posActual.getX() >= obstaculosArriba.getLineas().get(i).getX1() //Choca con todo el cuerpo
            && posActual.getX()+tam <= obstaculosArriba.getLineas().get(i).getX2() )
         {
            if( posActual.getY() == obstaculosArriba.getLineas().get(i).getY1() )
            {
              return true;  
            }
         }
         else
         {
            if(posActual.getX() <= obstaculosArriba.getLineas().get(i).getX2() //Choca con hombro izq
               && posActual.getX()+tam > obstaculosArriba.getLineas().get(i).getX2() )
            { 
               if( posActual.getY() == obstaculosArriba.getLineas().get(i).getY1() )
              {
                return true;  
              } 
            }
            else
            {
              if(posActual.getX() < obstaculosArriba.getLineas().get(i).getX1() //Choca con hombro der
               && posActual.getX()+tam > obstaculosArriba.getLineas().get(i).getX1() )
              { 
                 if( posActual.getY() == obstaculosArriba.getLineas().get(i).getY1() )
                 {
                   return true;  
                 } 
              }
              else
              {
                 if(posActual.getX() < obstaculosArriba.getLineas().get(i).getX1() //Choca con el estomago
                    && posActual.getX()+tam > obstaculosArriba.getLineas().get(i).getX2() )
                 { 
                    if( posActual.getY() == obstaculosArriba.getLineas().get(i).getY1() )
                    {
                      return true;  
                    } 
                 }    
              }
            }
         }
       }
       return false; 
    }
}
