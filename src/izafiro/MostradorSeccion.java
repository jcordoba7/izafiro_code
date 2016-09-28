/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package izafiro;

import javax.swing.JLabel;

/**
 *
 * @author Jonathan
 */
public class MostradorSeccion extends Thread {
    
    private JLabel letrero;
    
    public MostradorSeccion(JLabel letrero)
    {
       this.letrero = letrero; 
    }
    
    @Override
    public void run()
    {
       letrero.setSize(letrero.getPreferredSize());
       try {sleep(3000);} catch (InterruptedException ex) {}
       letrero.setSize(0,0);
    }
    
}
