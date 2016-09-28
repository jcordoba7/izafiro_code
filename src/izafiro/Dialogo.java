/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package izafiro;

import java.util.ArrayList;
import javax.swing.JLabel;

/**
 *
 * @author WINDOWS
 */
public class Dialogo {
    
    public Dialogo(){}
        
    public boolean validarPosicionConversadora(JLabel posActual, JLabel cuadroActual, ArrayList<Conversador> conversadores,
                                               Deposito d, int RADIO, int hidden)
    {
        int x1 = posActual.getX();
        int y1 = posActual.getY();
        int x2 = posActual.getX() + posActual.getWidth();
        int y2 = posActual.getY() + posActual.getHeight(); 
        
        for(int i = 0; i<conversadores.size(); i++)
        {
           int limiteArriba = conversadores.get(i).getImagen().getY()-RADIO;
           int limiteDerecha = conversadores.get(i).getImagen().getX()+conversadores.get(i).getImagen().getWidth()+RADIO;
           int limiteIzquierda = conversadores.get(i).getImagen().getX()-RADIO;
           int limiteAbajo = conversadores.get(i).getImagen().getY()+conversadores.get(i).getImagen().getHeight()+RADIO;
           
           if( x1 > limiteIzquierda && x1 < limiteDerecha && y1 > limiteArriba && y1 < limiteAbajo )
           { 
              //buscar mensaje.
               d.setNumConv(i); 
               imprimirMensaje(conversadores.get(i),cuadroActual,d,hidden);
               return true;
           }
           else
           {
             if( x2 > limiteIzquierda && x2 < limiteDerecha && y1 > limiteArriba && y1 < limiteAbajo )
             {
                //buscar mensaje. 
                d.setNumConv(i);  
                imprimirMensaje(conversadores.get(i),cuadroActual,d,hidden);
                return true;
             }
             else
             {
                if( x1 > limiteIzquierda && x1 < limiteDerecha && y2 > limiteArriba && y2 < limiteAbajo )
                {
                   //buscar mensaje.
                   d.setNumConv(i); 
                   imprimirMensaje(conversadores.get(i),cuadroActual,d,hidden);
                   return true;
                }
                else
                {
                   if( x2 > limiteIzquierda && x2 < limiteDerecha && y2 > limiteArriba && y2 < limiteAbajo )
                   {
                      //buscar mensaje. 
                      d.setNumConv(i); 
                      imprimirMensaje(conversadores.get(i),cuadroActual,d,hidden);                       
                      return true;
                   }    
                }
             }
           }
        }
        return false;
    }     
    
    public void imprimirMensaje(Conversador c, JLabel cuadroActual, Deposito d, int hidden)
    {        
       if(c.getMensajeActual() != 0)
       {
         c.getDialogos().get(c.getDialogoActual()).getMensajes().get(c.getMensajeActual()-1).setLocation(hidden,hidden);  
       }       
       c.getDialogos().get(c.getDialogoActual()).getMensajes().get(c.getMensajeActual()).setLocation(110, 110);
       cuadroActual = c.getDialogos().get(c.getDialogoActual()).getMensajes().get(c.getMensajeActual());
       if(c.getMensajeActual() < c.getDialogos().get(c.getDialogoActual()).getMensajes().size()-1)
       {
         c.setMensajeActual(c.getMensajeActual()+1); 
         d.setUltimoMensaje(false);
       }
       else
       {
         if(c.getDialogoActual() < c.getDialogos().size()-1)
         {
            c.setDialogoActual(c.getDialogoActual()+1); 
         }
         c.setMensajeActual(0);
         d.setUltimoMensaje(true);
       }
    }
    
}
