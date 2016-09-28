/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package izafiro;

import java.awt.Point;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Jonathan
 */
public class PruebaPuzzle {
    
    private static PruebaPuzzle prueba = null;
    private String musicaFondo1;
    private String musicaFondo2;
    private boolean activado = false;

    /**
     */
    
    public PruebaPuzzle(){    
        musicaFondo1 = "puzzle1";
        musicaFondo2 = "puzzle2";
    }
    
    public static PruebaPuzzle getPrueba() {
        return prueba;
    }

    /**
     * @param aPrueba the prueba to set
     */
    public static void setPrueba(PruebaPuzzle aPrueba) {
        prueba = aPrueba;
    }
    private JFrame jfActual;
    private Point puntoPersonaje;
    
      
    public static PruebaPuzzle getInstance()
    {
      if(getPrueba() == null) { setPrueba(new PruebaPuzzle()); }
      return getPrueba();
    }  
    
    public void abrirActividad(int numPuzzle, JFrame jf, Point punto)
    {
      setActivado(true);  
      setJfActual(jf);
      setPuntoPersonaje(punto);
      
      if(getJfActual() != null)
      {
        jf.setVisible(false);  
        Sonidos.getInstance().detener(Tiempo.getInstance(null).getSonidoActual());
      }
      
      switch(numPuzzle)
      {
          case 1: JOptionPane.showMessageDialog(null, "En esta ocasión usa SOLO el MOUSE");
                  new Puzzle1().setVisible(true);Sonidos.getInstance().reproducirLoop(musicaFondo1);        
                  break;
              
          case 2: JOptionPane.showMessageDialog(null, "En esta ocasión usa SOLO el MOUSE");
                  new Puzzle2().setVisible(true);Sonidos.getInstance().reproducirLoop(musicaFondo2);        
                  break;
              
          case 3: JOptionPane.showMessageDialog(null, "En esta ocasión usa SOLO el MOUSE","Espíritu de Zafiro:", 2, new ImageIcon (getClass().getResource("imagenes/barra/recursos/recurso1.png")));
                  new Puzzle3().setVisible(true);Sonidos.getInstance().reproducirLoop(musicaFondo1);      
                  break;
              
          case 4: JOptionPane.showMessageDialog(null, "En esta ocasión usa SOLO el MOUSE","Espíritu de Zafiro:", 2, new ImageIcon (getClass().getResource("imagenes/barra/recursos/recurso1.png")));
                  new Puzzle4().setVisible(true);Sonidos.getInstance().reproducirLoop(musicaFondo1);        
                  break;
              
          case 5: JOptionPane.showMessageDialog(null, "En esta ocasión usa SOLO el MOUSE","Espíritu de Zafiro:", 2, new ImageIcon (getClass().getResource("imagenes/barra/recursos/recurso1.png")));
                  new Puzzle5().setVisible(true);Sonidos.getInstance().reproducirLoop(musicaFondo1);        
                  break;
          
          case 6: JOptionPane.showMessageDialog(null, "En esta ocasión usa SOLO el MOUSE","Espíritu de Zafiro:", 2, new ImageIcon (getClass().getResource("imagenes/barra/recursos/recurso1.png")));
                  new Puzzle6().setVisible(true);Sonidos.getInstance().reproducirLoop(musicaFondo2);        
                  break;
              
          case 7: JOptionPane.showMessageDialog(null, "En esta ocasión usa SOLO el MOUSE","Espíritu de Zafiro:", 2, new ImageIcon (getClass().getResource("imagenes/barra/recursos/recurso1.png")));
                  new Puzzle7().setVisible(true);Sonidos.getInstance().reproducirLoop(musicaFondo1);        
                  break;
      }
    }
    
    public void cerrarActividad(JFrame jf, int nuevoPuntaje)
    { 
      setActivado(false);  
      jf.dispose(); 
      Sonidos.getInstance().detener(musicaFondo1);
      Sonidos.getInstance().detener(musicaFondo2);
      
      if(getJfActual() != null) //Llamado desde la Partida
      {    
        getJfActual().setVisible(true);
        GestorJuego.getInstance().actualizarPuntaje(nuevoPuntaje);
        ubicarPersonaje(getJfActual(),getPuntoPersonaje());
        
        if(Teclado.getInstace().isMusica())
        {
            Sonidos.getInstance().reproducirLoop(Tiempo.getInstance(null).getSonidoActual()); 
        }
        Sonidos.getInstance().reproducir("nuevorecurso");
        
        Teclado.getInstace().setPausa(true);
        JOptionPane.showMessageDialog(null, "¡Aumentaste tu puntaje +"+nuevoPuntaje+"!");
        Teclado.getInstace().setPausa(false);
      }
      else //Llamado desde la ventana de Puzzles
      {
        GestorJuego.getInstance().setPuntaje(GestorJuego.getInstance().getPuntaje()+nuevoPuntaje);  
        Sonidos.getInstance().reproducirLoop("portada");
        Sonidos.getInstance().reproducirLoop("sonidosbosque");
        
        AdministradorConsultasSQL ac = new AdministradorConsultasSQL();
        ac.guardarPartida();
        
        new JuegosPuzzle().setVisible(true);   
      }
      
      System.gc();
    }
    
    public void cerrarActividad2(JFrame jf, int nuevoPuntaje) //Solo aplica para el Puzzle 7 (gema Azul)
    { 
      jf.setVisible(false);  
      jf.dispose();
      Sonidos.getInstance().detener(musicaFondo1);
      Sonidos.getInstance().detener(musicaFondo2);
      
      if(getJfActual() != null) //Llamado desde la Partida
      {
        GestorJuego.getInstance().actualizarPuntaje(nuevoPuntaje);             
        Sonidos.getInstance().reproducirLoop(Tiempo.getInstance(null).getSonidoActual()); 
        new Puzzle7_1().setVisible(true);
      }
      else //Llamado desde la ventana de Puzzles
      {
        GestorJuego.getInstance().setPuntaje(GestorJuego.getInstance().getPuntaje()+nuevoPuntaje);  
        Sonidos.getInstance().reproducirLoop("portada");
        Sonidos.getInstance().reproducirLoop("sonidosbosque");
        
        AdministradorConsultasSQL ac = new AdministradorConsultasSQL();
        ac.guardarPartida();
        
        new JuegosPuzzle().setVisible(true); 
      }
      System.gc();
    }
    
    public void ubicarPersonaje(JFrame jf, Point p)
    {
        for(int i = 0; i<jf.getContentPane().getComponents().length;i++)
        {        
            if(jf.getContentPane().getComponent(i).getAccessibleContext().getAccessibleName().equalsIgnoreCase("tahi"))
            {
                jf.getContentPane().getComponent(i).setLocation(p);
                break;
            }            
        }
    }

    /**
     * @return the jfActual
     */
    public JFrame getJfActual() {
        return jfActual;
    }

    /**
     * @param jfActual the jfActual to set
     */
    public void setJfActual(JFrame jfActual) {
        this.jfActual = jfActual;
    }

    /**
     * @return the puntoPersonaje
     */
    public Point getPuntoPersonaje() {
        return puntoPersonaje;
    }

    /**
     * @param puntoPersonaje the puntoPersonaje to set
     */
    public void setPuntoPersonaje(Point puntoPersonaje) {
        this.puntoPersonaje = puntoPersonaje;
    }

    /**
     * @return the activado
     */
    public boolean isActivado() {
        return activado;
    }

    /**
     * @param activado the activado to set
     */
    public void setActivado(boolean activado) {
        this.activado = activado;
    }
    
}
