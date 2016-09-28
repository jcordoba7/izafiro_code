package izafiro;

import javax.swing.JFrame;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author WINDOWS
 */
public class Deposito {
    
     private int x; //coordenada en x
     private int y; //coordenada en y
     private int paso; //numero de paso del personaje
     private int pie; //pie izquier o derecho del personaje
     private int numConv;//numero del conversador actual
     private boolean ventanaAbierta; //ventana de dialogo abierta en la escena
     private boolean ultimoMensaje; //se ha abierto el ultimo mensaje d eun dialogo
     private JFrame jFrameMostrado; //Se necesita la variable isShowing() para determinar si la ventana esta visible o no
     
     public Deposito(){}
     
     public Deposito( int x, int y, JFrame jFrameMostrado )
     {
        this.x = x;
        this.y = y;
        this.paso = 0;
        this.numConv = 0;
        this.ventanaAbierta = false;
        this.ultimoMensaje = false;
        this.jFrameMostrado = jFrameMostrado;
     }
     
     public Deposito( int x, int y )
     {
        this.x = x;
        this.y = y;
        this.paso = 0;
        this.numConv = 0;
        this.ventanaAbierta = false;
        this.ultimoMensaje = false;
        this.jFrameMostrado = null;
     }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @return the paso
     */
    public int getPaso() {
        return paso;
    }

    /**
     * @param paso the paso to set
     */
    public void setPaso(int paso) {
        this.paso = paso;
    }

    /**
     * @return the pie
     */
    public int getPie() {
        return pie;
    }

    /**
     * @param pie the pie to set
     */
    public void setPie(int pie) {
        this.pie = pie;
    }

    /**
     * @return the numConv
     */
    public int getNumConv() {
        return numConv;
    }

    /**
     * @param numConv the numConv to set
     */
    public void setNumConv(int numConv) {
        this.numConv = numConv;
    }

    /**
     * @return the ventanaAbierta
     */
    public boolean isVentanaAbierta() {
        return ventanaAbierta;
    }

    /**
     * @param ventanaAbierta the ventanaAbierta to set
     */
    public void setVentanaAbierta(boolean ventanaAbierta) {
        this.ventanaAbierta = ventanaAbierta;
    }

    /**
     * @return the ultimoMensaje
     */
    public boolean isUltimoMensaje() {
        return ultimoMensaje;
    }

    /**
     * @param ultimoMensaje the ultimoMensaje to set
     */
    public void setUltimoMensaje(boolean ultimoMensaje) {
        this.ultimoMensaje = ultimoMensaje;
    }

    /**
     * @return the jFrameMostrado
     */
    public JFrame jFrameMostrado() {
        return jFrameMostrado;
    }

    /**
     * @param jFrameMostrado the jFrameMostrado to set
     */
    public void setjFrameMostrado(JFrame jFrameMostrado) {
        this.jFrameMostrado = jFrameMostrado;
    }
    
}
