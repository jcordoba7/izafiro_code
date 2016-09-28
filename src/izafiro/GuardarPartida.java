/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package izafiro;

import java.awt.Point;
import javax.swing.JOptionPane;

/**
 *
 * @author Jonathan
 */
public class GuardarPartida { //Se encarga de avisar de una nueva conexion con la base de datos
    
    private static GuardarPartida gp = null;
    
    public GuardarPartida(){}
    
    public static GuardarPartida getInstance()
    {
      if(gp == null) { gp = new GuardarPartida(); }
      return gp;
    }
    
    public void guardarPartida(int i, int j, Point p) //recibe posicion de la ventana donde se ha guardado
    {
        Teclado.getInstace().setPausa(true);
        if(JOptionPane.showConfirmDialog(null, "¿Deseas guardar lo que has jugado hasta aquí?") == 0)
        {  
            GestorJuego.getInstance().setEscenarioInicial(i, j);
            GestorJuego.getInstance().setUbicacionInicial(p);
            GestorJuego.getInstance().setSalud(5);
            // ... Se invocará la clase encargada de la conexion con la BD.
            Sonidos.getInstance().reproducir("nuevorecurso");           
            JOptionPane.showMessageDialog(null, "Tu Partida se ha guardado Correctamente!");            
        }
        Teclado.getInstace().setPausa(false);
    }
}
