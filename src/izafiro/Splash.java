/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package izafiro;

import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author smarttown
 */
public class Splash extends Thread
{
    @Override
    public void run()
    {
       SplashWindow sw = new SplashWindow();
       sw.setVisible(true);
       try { Thread.sleep(4000); } catch (InterruptedException ex) {}
       sw.setVisible(false);
       sw.dispose();
               
       Sonidos.getInstance().reproducirLoop("portada");
       Sonidos.getInstance().reproducirLoop("sonidosbosque");

        try {
            new MainMenu().setVisible(true);
        } catch (UnsupportedAudioFileException ex) {
        } catch (IOException ex) {
        } catch (LineUnavailableException ex) {
        }
    }
}
