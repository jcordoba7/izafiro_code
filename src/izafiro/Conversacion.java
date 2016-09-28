/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package izafiro;

import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.JLabel;

/**
 *
 * @author WINDOWS
 */
public class Conversacion {
    
    private ArrayList<JLabel> mensajes; 
    private ArrayList<Icon>mensajes2;
    
    public Conversacion()
    {
       this.mensajes = new ArrayList<>();  
       this.mensajes2 = new ArrayList<>();
    }
    
    public Conversacion(ArrayList<JLabel> mensajes)
    {
       this.mensajes = mensajes;  
    }

    /**
     * @return the mensajes
     */
    public ArrayList<JLabel> getMensajes() {
        return mensajes;
    }

    /**
     * @param mensajes the mensajes to set
     */
    public void setMensajes(ArrayList<JLabel> mensajes) {
        this.mensajes = mensajes;
    }

    /**
     * @return the mensajes2
     */
    public ArrayList<Icon> getMensajes2() {
        return mensajes2;
    }
    
}
