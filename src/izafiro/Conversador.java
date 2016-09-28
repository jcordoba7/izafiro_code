/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package izafiro;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author WINDOWS
 */
public class Conversador {
    
    
    private int dialogoActual;
    private int mensajeActual;
    private JLabel imagen;     
    private ArrayList <Conversacion> dialogos;
    private ArrayList<ImageIcon> posiciones;
    
    public Conversador(int id, JLabel imagen, ArrayList <Conversacion> dialogos)
    {
        this.dialogoActual = 0;
        this.mensajeActual = 0;
        this.imagen = imagen;
        this.dialogos = dialogos;
        this.posiciones = new ArrayList<>();
    }
    
    /**
     * @return the mensajeActual
     */
    public int getMensajeActual() {
        return mensajeActual;
    }

    /**
     * @param mensajeActual the mensajeActual to set
     */
    public void setMensajeActual(int mensajeActual) {
        this.mensajeActual = mensajeActual;
    }

    /**
     * @return the imagen
     */
    public JLabel getImagen() {
        return imagen;
    }

    /**
     * @param imagen the imagen to set
     */
    public void setImagen(JLabel imagen) {
        this.imagen = imagen;
    }  

    /**
     * @return the dialogoActual
     */
    public int getDialogoActual() {
        return dialogoActual;
    }

    /**
     * @param dialogoActual the dialogoActual to set
     */
    public void setDialogoActual(int dialogoActual) {
        this.dialogoActual = dialogoActual;
    }

    /**
     * @return the dialogos
     */
    public ArrayList <Conversacion> getDialogos() {
        return dialogos;
    }

    /**
     * @param dialogos the dialogos to set
     */
    public void setDialogos(ArrayList <Conversacion> dialogos) {
        this.dialogos = dialogos;
    }

    /**
     * @return the posiciones
     */
    public ArrayList<ImageIcon> getPosiciones() {
        return posiciones;
    }

    /**
     * @param posiciones the posiciones to set
     */
    public void setPosiciones(ArrayList<ImageIcon> posiciones) {
        this.posiciones = posiciones;
    }
    
}
