/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package izafiro;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Jonathan
 */
public final class Ayuda extends javax.swing.JFrame {

    private static Ayuda ayuda = null;
    
    private final String[] mensajes;
    private int mensajeActual = 0;
    
    /**
     * Creates new form Ayuda
     */
    public Ayuda() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon (getClass().getResource("izafiroicono.png")).getImage()); Sonidos.getInstance().activarCursor(this);

        mensajes = new String[33];
        mensajes[0] = "Utiliza las teclas de desplazamiento para que puedas moverte.\n\n";
        mensajes[1] = "Cuando necesites pausar el juego, presiona la tecla P.\n\n";
        mensajes[2] = "Cuando necesites ayuda del juego, presiona la tecla A.";

        mensajes[3] = "Cuando necesites pausar el juego, presiona la tecla P.\n\n";
        mensajes[4] = "Busca a alguien para que te diga en dónde te encuentras (sigue las flechas blancas).\n\n";
        mensajes[5] = "No te acérques a los muerciélagos, aún no tienes con qué combatirlos.";

        mensajes[6] = "Consigue agua y llévasela al ermitaño del pozo.\n\n";
        mensajes[7] = "Debes acercárte a la orilla del río o de la cascada y presionar ENTER\n\n";
        mensajes[8] = "Busca al campesino de la cosecha. Háblale para que te dé lo que tiene para tí.";

        mensajes[9] = "Utiliza la llave donde hayas visto alguna puerta o reja.\n\n";
        mensajes[10] = "Sería bueno que guardes tu partida si aún no lo has hecho.\n\n";
        mensajes[11] = "Para utilizar algún recurso, presiona la tecla ENTER en el lugar correcto.";

        mensajes[12] = "Para usar la Espada de Zafiro, presiona la tecla ESPACIO.\n\n";
        mensajes[13] = "Con ayuda de la Espada, puedes llegar más lejos que antes.\n\n";
        mensajes[14] = "Siempre que creas que hay algo especial en algún sitio, presiona la tecla ENTER.";

        mensajes[15] = "Acomoda los bloques negros en las posiciones correctas.\n\n";
        mensajes[16] = "Descubre cómo desplazar los bloques.\n\n";
        mensajes[17] = "Si has hecho algún movimiento erróneo, devuélvete un escenario y vuelve a entrar.";

        mensajes[18] = "Consigue la Gema Roja, en el 'Valle de La Roca'.\n\n";
        mensajes[19] = "Siempre que creas que hay algo especial en algún sitio, presiona la tecla ENTER.\n\n";
        mensajes[20] = "Recuerda guardar tu partida cuando puedas.";

        mensajes[21] = "Vuelve a la gran entrada para colocar la Gema Roja en su lugar.\n\n";
        mensajes[22] = "Ten cuidado con las rocas rodantes.\n\n";
        mensajes[23] = "Recuerda guardar tu partida cuando puedas.";

        mensajes[24] = "Consigue la Gema Azul en el 'Jardín de las Fuentes'.\n\n";
        mensajes[25] = "No dejes que los guardias te descubran.\n\n";
        mensajes[26] = "Recuerda guardar tu partida cuando puedas.";            

        mensajes[27] = "Vuelve a la gran entrada para colocar la Gema Azul en su lugar.\n\n";
        mensajes[28] = "Recuerda guardar tu partida cuando puedas.";
        mensajes[29] = "";

        mensajes[30] = "Encuentra al Gran Patriarca en su refigio.\n\n";
        mensajes[31] = "Recuerda guardar tu partida cuando puedas.\n\n";
        mensajes[32] = "Siempre que creas que hay algo especial en algún sitio, presiona la tecla ENTER.";

        setMensajeActual();

        //this.addKeyListener(new Ayuda.AL());
    }
    
    public static Ayuda getInstance()
    {
        if(ayuda == null) { ayuda = new Ayuda(); }
        return ayuda;
    }
    
    public static void setInstance(Ayuda a)
    {
        ayuda = a;
    }
    
    public void mostrarMensajes()
    {        
        if(GestorJuego.getInstance().getEscenarioActual() == GestorJuego.getInstance().getvJF()[0][8]
           || GestorJuego.getInstance().getEscenarioActual() == GestorJuego.getInstance().getvJF()[6][6]) //Caso especial para el minipuzzle de acomodar las piedras negras.
        {
            int aux = this.mensajeActual;  
            mensajeActual = 15;
            this.ayuda1.setText(mensajes[getMensajeActual()]+mensajes[getMensajeActual()+1]+mensajes[getMensajeActual()+2]);
            mensajeActual = aux;
        }
        else
        {
            setMensajeActual();
            this.ayuda1.setText(mensajes[getMensajeActual()]+mensajes[getMensajeActual()+1]+mensajes[getMensajeActual()+2]);
        }
    }
    
    public void resaltarTeclas()
    {
        if(GestorJuego.getInstance().isJuegoIniciado()){ return; } // Si el juego ya habia iniciado, no es necesario resaltar otra vez las teclas.
        
        GestorJuego.getInstance().setJuegoIniciado(true);
        
        JLabel pausa = null;
        JLabel sound = null;
        JLabel ayuda2 = null;   
        
        for(int k = 0; k<GestorJuego.getInstance().getEscenarioActual().getContentPane().getComponents().length;k++)
        {        
            if(GestorJuego.getInstance().getEscenarioActual().getContentPane().getComponent(k).getAccessibleContext().getAccessibleName().equalsIgnoreCase("Pausa: Tecla P"))
            {
                pausa = (JLabel)GestorJuego.getInstance().getEscenarioActual().getContentPane().getComponent(k);                
            }
            else if(GestorJuego.getInstance().getEscenarioActual().getContentPane().getComponent(k).getAccessibleContext().getAccessibleName().equalsIgnoreCase("On/Off Música: Tecla S"))
            {
                sound = (JLabel)GestorJuego.getInstance().getEscenarioActual().getContentPane().getComponent(k);                
            }
            else if(GestorJuego.getInstance().getEscenarioActual().getContentPane().getComponent(k).getAccessibleContext().getAccessibleName().equalsIgnoreCase("Ayuda: Tecla A"))
            {
                ayuda2 = (JLabel)GestorJuego.getInstance().getEscenarioActual().getContentPane().getComponent(k);                
            }
        }
        new ResaltarTeclasEspeciales(pausa, sound, ayuda2,false).start();
    }   
    
    public void resaltarTeclaAyuda(boolean sonido)
    {
        JLabel ayuda2 = null;   
        
        for(int k = 0; k<GestorJuego.getInstance().getEscenarioActual().getContentPane().getComponents().length;k++)
        {
            if(GestorJuego.getInstance().getEscenarioActual().getContentPane().getComponent(k).getAccessibleContext().getAccessibleName().equalsIgnoreCase("Ayuda: Tecla A"))
            {
                ayuda2 = (JLabel)GestorJuego.getInstance().getEscenarioActual().getContentPane().getComponent(k);            
            }
        }
        new ResaltarTeclasEspeciales(null, null, ayuda2,sonido).start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textoGuiones = new javax.swing.JTextArea();
        ayuda1 = new javax.swing.JTextArea();
        ReanudarButton = new javax.swing.JButton();
        reanudarLabel = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Ayuda");
        setAlwaysOnTop(true);
        setUndecorated(true);
        setResizable(false);
        setType(java.awt.Window.Type.POPUP);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        textoGuiones.setEditable(false);
        textoGuiones.setBackground(new java.awt.Color(0, 255, 51));
        textoGuiones.setColumns(20);
        textoGuiones.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        textoGuiones.setForeground(new java.awt.Color(255, 255, 255));
        textoGuiones.setLineWrap(true);
        textoGuiones.setRows(10);
        textoGuiones.setText("-      -      -");
        textoGuiones.setWrapStyleWord(true);
        textoGuiones.setAlignmentX(3.0F);
        textoGuiones.setAlignmentY(3.0F);
        textoGuiones.setAutoscrolls(false);
        textoGuiones.setBorder(null);
        textoGuiones.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        textoGuiones.setEnabled(false);
        textoGuiones.setFocusable(false);
        textoGuiones.setInheritsPopupMenu(true);
        textoGuiones.setOpaque(false);
        textoGuiones.setRequestFocusEnabled(false);
        textoGuiones.setSelectionColor(new java.awt.Color(255, 255, 255));
        textoGuiones.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(textoGuiones, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 10, 160));

        ayuda1.setEditable(false);
        ayuda1.setBackground(new java.awt.Color(0, 0, 102));
        ayuda1.setColumns(20);
        ayuda1.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        ayuda1.setForeground(new java.awt.Color(255, 255, 255));
        ayuda1.setLineWrap(true);
        ayuda1.setRows(10);
        ayuda1.setText("Hola");
        ayuda1.setWrapStyleWord(true);
        ayuda1.setAlignmentX(3.0F);
        ayuda1.setAlignmentY(3.0F);
        ayuda1.setAutoscrolls(false);
        ayuda1.setBorder(null);
        ayuda1.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        ayuda1.setEnabled(false);
        ayuda1.setFocusable(false);
        ayuda1.setInheritsPopupMenu(true);
        ayuda1.setOpaque(false);
        ayuda1.setPreferredSize(null);
        ayuda1.setRequestFocusEnabled(false);
        ayuda1.setSelectionColor(new java.awt.Color(255, 255, 255));
        ayuda1.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(ayuda1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 320, -1));

        ReanudarButton.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        ReanudarButton.setForeground(new java.awt.Color(0, 0, 153));
        ReanudarButton.setText("Ok");
        ReanudarButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ReanudarButtonMouseClicked(evt);
            }
        });
        getContentPane().add(ReanudarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 266, -1, 25));

        reanudarLabel.setFont(new java.awt.Font("Tekton Pro", 1, 22)); // NOI18N
        reanudarLabel.setForeground(new java.awt.Color(255, 255, 0));
        reanudarLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        reanudarLabel.setText("OK");
        reanudarLabel.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(reanudarLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 266, 0, 0));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/ayuda.png"))); // NOI18N
        fondo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ReanudarButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ReanudarButtonMouseClicked
        Teclado.getInstace().setPausa(false);  
        dispose();
        setLocationRelativeTo(null);
        resaltarTeclas();
    }//GEN-LAST:event_ReanudarButtonMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ayuda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ayuda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ayuda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ayuda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Ayuda().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ReanudarButton;
    private javax.swing.JTextArea ayuda1;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel reanudarLabel;
    private javax.swing.JTextArea textoGuiones;
    // End of variables declaration//GEN-END:variables
        
    /**
     * @return the mensajeActual
     */
    public int getMensajeActual() {
        return mensajeActual;
    }

    /**
     */
    public void setMensajeActual()
    {
        textoGuiones.setText("-\n\n\n-\n\n\n-");
        if(GestorJuego.getInstance().getMsnApertura()[0]) //Si ya comenzo el juego
        {
            mensajeActual = 3;
        } 
        if(GestorJuego.getInstance().getMsnApertura()[2]) //
        {
            mensajeActual = 6;
        }
        if(!GestorJuego.getInstance().getRecursos()[0] && GestorJuego.getInstance().getRecursos()[2]) //
        {
            mensajeActual = 9;
        }
        if(GestorJuego.getInstance().getRecursos()[0]) //Si acaba de ocnseguir la espada
        {
            mensajeActual = 12;
        } 
        if(GestorJuego.getInstance().getMsnApertura()[8]) //Si ya hablo con el anciano
        {
            mensajeActual = 18;
        }
        if(GestorJuego.getInstance().getRecursos()[4]) //Si ya consiguió la Gema Roja
        {
            mensajeActual = 21;
            textoGuiones.setText("-\n\n\n-\n\n-");
        }
        if(GestorJuego.getInstance().getPuertas()[6]) //Si ya desbloqueó la entrada al Jardin de las Fuentes
        {
            mensajeActual = 24;
            textoGuiones.setText("-\n\n-\n\n\n-");
        }
        if(GestorJuego.getInstance().getRecursos()[5]) //Si ya consiguió la Gema Azul
        {
            mensajeActual = 27;
            textoGuiones.setText("-\n\n\n-");
        }
        if(GestorJuego.getInstance().getPuertas()[2]) //Si ya desbloqueó la entrada al Refugio del Patriarca      
        {
            mensajeActual = 30;
            textoGuiones.setText("-\n\n-\n\n-");
        }
    }
    
    public void setMensajeActual(int grupoMensajes)
    {
        mensajeActual = grupoMensajes;
    }
    
    /*public class AL extends KeyAdapter
    {
        @Override
        public void keyPressed(KeyEvent e)
        {
            int keyCode = e.getKeyCode();
            
            switch(keyCode)
            {
                case (KeyEvent.VK_ENTER):
                    Teclado.getInstace().setPausa(false);  
                    dispose();
                    setLocationRelativeTo(null);
                    resaltarTeclas();
                    break;
            }
        }
    }*/
}
