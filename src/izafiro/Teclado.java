/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package izafiro;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author Jonathan
 */
public class Teclado extends KeyAdapter //Con la tecla S se pausa y se reanuda la musica de fondo
{  
    private static Teclado al = null;
    private boolean musica = true; //Determina si la musica esta sonando o ha sido detenida.
    private boolean pausa = false;
        
    public static Teclado getInstace()
    {
      if(al == null) { al = new Teclado(); }
      return al;
    }
        
    @Override
    public void keyPressed(KeyEvent e)
    {
        int keyCode = e.getKeyCode();         

        switch(keyCode)
        {                 
            case (KeyEvent.VK_S):   if(isMusica())
                                    {
                                        Tiempo.getInstance(null).detenerTodoSonido();
                                        setMusica(false);
                                    }
                                    else
                                    {                             
                                       Sonidos.getInstance().reproducirLoop(Tiempo.getInstance(null).getSonidoActual());
                                       setMusica(true);
                                    }
                                  
                                  break;
                
            case (KeyEvent.VK_P): Sonidos.getInstance().detener(Tiempo.getInstance(null).getSonidoActual());
                                  setPausa(true); 
                                  Pausa.getInstance().setVisible(true);
                                  break;
            
            case (KeyEvent.VK_A): setPausa(true); 
                                  Ayuda.getInstance().setVisible(true);
                                  Ayuda.getInstance().mostrarMensajes();
                                  break;
        }
    } 

    /**
     * @return the musica
     */
    public boolean isMusica() {
        return musica;
    }

    /**
     * @param musica the musica to set
     */
    public void setMusica(boolean musica) {
        this.musica = musica;
    }

    /**
     * @return the pausa
     */
    public boolean isPausa() {
        return pausa;
    }

    /**
     * @param pausa the pausa to set
     */
    public void setPausa(boolean pausa) {
        this.pausa = pausa;
    }
    
    
}
