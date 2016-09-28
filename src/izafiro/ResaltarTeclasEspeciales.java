/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package izafiro;

import java.awt.Color;
import javax.swing.JLabel;

/**
 *
 * @author Jonathan
 */
public class ResaltarTeclasEspeciales extends Thread {
    
    private JLabel labelPausa = null;
    private JLabel labelSound = null;
    private JLabel labelAyuda = null;
    private boolean sonido = false;

    public ResaltarTeclasEspeciales(JLabel labelPausa, JLabel labelSound, JLabel labelAyuda, boolean sonido)
    {
        this.labelPausa = labelPausa;
        this.labelSound = labelSound;
        this.labelAyuda = labelAyuda;
        this.sonido = sonido;
    }        

    @Override
    public void run()
    {   
        if(labelSound == null && labelPausa == null) //En este caso solo se resalta el boton A, ya que hay nuevas tareas.
        {
            if(sonido) { Sonidos.getInstance().reproducir("success2"); }
            
            for(int i=0; i<10; i++)
            {
                try { labelAyuda.setForeground(Color.red); } catch (Exception e) {}
                
                try { Thread.sleep(500); } catch (InterruptedException ex) {}
                
                try { labelAyuda.setForeground(Color.white); } catch (Exception e) {}

                try { Thread.sleep(500); } catch (InterruptedException ex) {}
            }
        }
        else
        {
            for(int i=0; i<7; i++)
            {
                labelPausa.setSize(0,0);
                labelSound.setSize(0,0);
                try { labelAyuda.setSize(0,0); } catch (Exception e) {}

                try { Thread.sleep(800); } catch (InterruptedException ex) {}

                labelPausa.setSize(labelPausa.getPreferredSize());
                labelSound.setSize(labelSound.getPreferredSize());
                try { labelAyuda.setSize(labelAyuda.getPreferredSize()); } catch (Exception e) {}

                try { Thread.sleep(800); } catch (InterruptedException ex) {}
            }
        }       
    }
}