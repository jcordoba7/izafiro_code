/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package izafiro;

import java.sql.SQLException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Jacc89
 */
public class Historia2 extends javax.swing.JFrame {

    Icon[] efectoCierre;
    Icon[] escenas;
    Icon brillonar;
    Icon poderencierro;
    private int cont = 1;
    
    /**
     * Creates new form Historia
     */
    public Historia2() {
        initComponents();
        this.setLocationRelativeTo(null); 
        this.setIconImage(new ImageIcon (getClass().getResource("izafiroicono.png")).getImage()); Sonidos.getInstance().activarCursor(this);
                
        efectoCierre = new Icon[11];         
        efectoCierre[0] = new ImageIcon (getClass().getResource("imagenes/objetos/secuenciacierre/0.png"));
        efectoCierre[1] = new ImageIcon (getClass().getResource("imagenes/objetos/secuenciacierre/1.png"));
        efectoCierre[2] = new ImageIcon (getClass().getResource("imagenes/objetos/secuenciacierre/2.png"));
        efectoCierre[3] = new ImageIcon (getClass().getResource("imagenes/objetos/secuenciacierre/3.png"));
        efectoCierre[4] = new ImageIcon (getClass().getResource("imagenes/objetos/secuenciacierre/4.png"));
        efectoCierre[5] = new ImageIcon (getClass().getResource("imagenes/objetos/secuenciacierre/5.png"));
        efectoCierre[6] = new ImageIcon (getClass().getResource("imagenes/objetos/secuenciacierre/6.png"));
        efectoCierre[7] = new ImageIcon (getClass().getResource("imagenes/objetos/secuenciacierre/7.png"));
        efectoCierre[8] = new ImageIcon (getClass().getResource("imagenes/objetos/secuenciacierre/8.png"));
        efectoCierre[9] = new ImageIcon (getClass().getResource("imagenes/objetos/secuenciacierre/9.png"));
        efectoCierre[10] = new ImageIcon (getClass().getResource("imagenes/objetos/secuenciacierre/10.png"));
        
        
        escenas = new Icon[22];         
        escenas[0] = new ImageIcon (getClass().getResource("imagenes/historia2/1.png"));
        escenas[1] = new ImageIcon (getClass().getResource("imagenes/historia2/2.png"));
        escenas[2] = new ImageIcon (getClass().getResource("imagenes/historia2/3.png"));
        escenas[3] = new ImageIcon (getClass().getResource("imagenes/historia2/4.png"));
        escenas[4] = new ImageIcon (getClass().getResource("imagenes/historia2/5.png"));
        escenas[5] = new ImageIcon (getClass().getResource("imagenes/historia2/6.png"));
        escenas[6] = new ImageIcon (getClass().getResource("imagenes/historia2/7.png"));
        escenas[7] = new ImageIcon (getClass().getResource("imagenes/historia2/8.gif"));
        escenas[8] = new ImageIcon (getClass().getResource("imagenes/historia2/9.gif"));
        escenas[9] = new ImageIcon (getClass().getResource("imagenes/historia2/10.png"));
        escenas[10] = new ImageIcon (getClass().getResource("imagenes/historia2/11.gif"));
        escenas[11] = new ImageIcon (getClass().getResource("imagenes/historia2/12.png"));
        escenas[12] = new ImageIcon (getClass().getResource("imagenes/historia2/13.png"));
        escenas[13] = new ImageIcon (getClass().getResource("imagenes/historia2/14.png"));
        escenas[14] = new ImageIcon (getClass().getResource("imagenes/historia2/15.gif"));
        escenas[15] = new ImageIcon (getClass().getResource("imagenes/historia2/16.png"));
        escenas[16] = new ImageIcon (getClass().getResource("imagenes/historia2/17.png"));
        escenas[17] = new ImageIcon (getClass().getResource("imagenes/historia2/18.gif"));
        escenas[18] = new ImageIcon (getClass().getResource("imagenes/historia2/19.png"));
        escenas[19] = new ImageIcon (getClass().getResource("imagenes/historia2/20.gif"));
        escenas[20] = new ImageIcon (getClass().getResource("imagenes/historia2/21.png"));
        escenas[21] = new ImageIcon (getClass().getResource("imagenes/historia2/22.png"));
     
        brillonar = new ImageIcon (getClass().getResource("imagenes/historia2/brillonar.gif"));
        brillonar = new ImageIcon (getClass().getResource("imagenes/historia2/poderencierro.gif"));
        
        Sonidos.getInstance().detener(Tiempo.getInstance(null).getSonidoActual());
        
        Sonidos.getInstance().reproducirLoop("refugiopatriarca");        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        siguiente = new javax.swing.JLabel();
        continuar = new javax.swing.JLabel();
        pantallaNegra1 = new javax.swing.JLabel();
        pantallaNegra = new javax.swing.JLabel();
        salir = new javax.swing.JToggleButton();
        labelPiedraNar = new javax.swing.JLabel();
        labelPoderEncierro = new javax.swing.JLabel();
        contenido = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("iZafiro Game");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        siguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/botones/flecha-siguiente.png"))); // NOI18N
        siguiente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        siguiente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                siguienteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                siguienteMouseExited(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                siguienteMouseClicked(evt);
            }
        });
        getContentPane().add(siguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 470, -1, -1));

        continuar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        continuar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/texto/portada/continuar-partida.png"))); // NOI18N
        continuar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        continuar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                continuarMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                continuarMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                continuarMouseEntered(evt);
            }
        });
        getContentPane().add(continuar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 480, 0, 0));

        pantallaNegra1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/objetos/secuenciacierre/0.png"))); // NOI18N
        pantallaNegra1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(pantallaNegra1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, -1, 260));

        pantallaNegra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/objetos/secuenciacierre/0.png"))); // NOI18N
        pantallaNegra.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(pantallaNegra, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 270));

        salir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        salir.setForeground(new java.awt.Color(0, 102, 0));
        salir.setText("Salir del Juego");
        salir.setFocusable(false);
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        getContentPane().add(salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 485, -1, -1));

        labelPiedraNar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/historia2/brillonar.gif"))); // NOI18N
        getContentPane().add(labelPiedraNar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 190, 0, 0));

        labelPoderEncierro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/historia2/poderencierro.gif"))); // NOI18N
        getContentPane().add(labelPoderEncierro, new org.netbeans.lib.awtextra.AbsoluteConstraints(305, 210, 0, 0));

        contenido.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        contenido.setForeground(new java.awt.Color(255, 255, 255));
        contenido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        contenido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/historia2/1.png"))); // NOI18N
        contenido.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        contenido.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(contenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 35, 610, 415));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/fondo2-historia.jpg"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void siguienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_siguienteMouseClicked
        // TODO add your handling code here:
        if(cont != escenas.length)
        {
            cont++;            
            
            switch(cont)
            {
                case (2): new EsconderBoton(5000).start(); 
                          this.contenido.setIcon(escenas[cont-1]); 
                          break;
                case (3): new CambiarEscena(100,cont).start();
                          new EsconderBoton(2500).start();
                          break;
                case (4): new EsconderBoton(5000).start(); 
                          this.contenido.setIcon(escenas[cont-1]); 
                          break;
                case (6): new CambiarEscena(100,cont).start();
                          new EsconderBoton(2500).start();
                          break;
                case (7): new EsconderBoton(4000).start(); 
                          this.contenido.setIcon(escenas[cont-1]); 
                          break;
                case (8): new EsconderBoton(8000).start(); 
                          this.contenido.setIcon(escenas[cont-1]); 
                          new PoderEncierro().start(); 
                          break;                    
                case (9): new CambiarEscena(100,cont).start(); 
                          new EsconderBoton(6000).start();                          
                          break;
                case (10): new CambiarEscena(100,cont).start();
                           new EsconderBoton(2500).start(); 
                           labelPoderEncierro.setSize(0,0); 
                           break;
                case (11): new EsconderBoton(7000).start(); 
                           this.contenido.setIcon(escenas[cont-1]);
                           new ReproducirSonido(4000,"trueno").start();
                           break;
                case (12): new EsconderBoton(4000).start(); 
                           this.contenido.setIcon(escenas[cont-1]); 
                           break;
                case (13): new CambiarEscena(100,cont).start();
                           new EsconderBoton(2500).start();
                           new PiedraNar().start();
                           break;
                case (14): new EsconderBoton(5000).start();
                           this.contenido.setIcon(escenas[cont-1]); 
                           break;
                case (15): new EsconderBoton(4000).start();
                           this.contenido.setIcon(escenas[cont-1]); 
                           break;
                case (16): new EsconderBoton(4000).start();
                           this.contenido.setIcon(escenas[cont-1]); 
                           break;
                case (17): new CambiarEscena(100,cont).start();
                           new EsconderBoton(8000).start();
                           labelPiedraNar.setSize(0,0);
                           break;
                case (18): new EsconderBoton(8000).start();
                           this.contenido.setIcon(escenas[cont-1]);
                           break;
                case (19): new CambiarEscena(100,cont).start();
                           new EsconderBoton(8000).start();
                           break;
                case (20): new EsconderBoton(8000).start();
                           this.contenido.setIcon(escenas[cont-1]);
                           new ReproducirSonido(4500,"trueno").start();
                           break;
                case (21): new CambiarEscena(100,cont).start();
                           new EsconderBoton(8000).start();
                           break;
                case (22): new EsconderBoton(4000).start();
                           this.contenido.setIcon(escenas[cont-1]);
                           break;
                default: this.contenido.setIcon(escenas[cont-1]); 
                         break;
            }
        }
        else
        {
            this.continuar.setSize(continuar.getPreferredSize());
        }
    }//GEN-LAST:event_siguienteMouseClicked

    private void siguienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_siguienteMouseEntered
        // TODO add your handling code here:
        this.siguiente.setIcon(new ImageIcon (getClass().getResource("imagenes/botones/flecha-siguiente-over.png")));
    }//GEN-LAST:event_siguienteMouseEntered

    private void siguienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_siguienteMouseExited
        // TODO add your handling code here:
        this.siguiente.setIcon(new ImageIcon (getClass().getResource("imagenes/botones/flecha-siguiente.png")));
    }//GEN-LAST:event_siguienteMouseExited

    private void continuarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_continuarMouseClicked
        // TODO add your handling code here:
        Sonidos.getInstance().detener("refugiopatriarca");
        
        this.setVisible(false);
        this.dispose();
        
        GestorJuego.getInstance().getEscenarioActual().setVisible(true);
        PruebaPuzzle.getInstance().setActivado(false);
        
        JLabel cuadro;
        
        for(int i = 0; i<GestorJuego.getInstance().getEscenarioActual().getContentPane().getComponents().length; i++)
        {        
           if(GestorJuego.getInstance().getEscenarioActual().getContentPane().getComponent(i).getAccessibleContext().getAccessibleName().equals("cuadroDialogo"))
           {
              cuadro = (JLabel)GestorJuego.getInstance().getEscenarioActual().getContentPane().getComponent(i);    
              cuadro.setSize(cuadro.getPreferredSize());
           }
        }
        PruebaPuzzle.getInstance().setActivado(false);
        
        Sonidos.getInstance().reproducirLoop(Tiempo.getInstance(null).getSonidoActual());
    }//GEN-LAST:event_continuarMouseClicked

    private void continuarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_continuarMouseEntered
        // TODO add your handling code here:
        this.continuar.setIcon(new ImageIcon (getClass().getResource("texto/portada/continuar-partida-over.png")));
        Sonidos.getInstance().reproducir("boton");
    }//GEN-LAST:event_continuarMouseEntered

    private void continuarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_continuarMouseExited
        // TODO add your handling code here:
        this.continuar.setIcon(new ImageIcon (getClass().getResource("texto/portada/continuar-partida.png")));
    }//GEN-LAST:event_continuarMouseExited

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        // TODO add your handling code here:
        if(JOptionPane.showConfirmDialog(null, "¿Seguro que deseas salir del Juego?", "Seleccionar una Opción", JOptionPane.YES_NO_OPTION) == 0)
        {
          AdministradorConsultasSQL ad = new AdministradorConsultasSQL();  
          ad.guardarPartida();  
          
          this.setVisible(false);
          this.dispose();
          
          if(GestorJuego.getInstance().getvJF() != null)
          {
            Teclado.getInstace().setPausa(false);
            GestorJuego.getInstance().cerrarPartida();
          }      
          
          try {
              new TablaPuntaje3().setVisible(true);  
          } catch (SQLException ex) {}        
        }
    }//GEN-LAST:event_salirActionPerformed

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
            java.util.logging.Logger.getLogger(Historia2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Historia2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Historia2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Historia2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Historia2().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel contenido;
    private javax.swing.JLabel continuar;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel labelPiedraNar;
    private javax.swing.JLabel labelPoderEncierro;
    private javax.swing.JLabel pantallaNegra;
    private javax.swing.JLabel pantallaNegra1;
    private javax.swing.JToggleButton salir;
    private javax.swing.JLabel siguiente;
    // End of variables declaration//GEN-END:variables
    
    
    public class EsconderBoton extends Thread
    {
        int segundos;
        
        public EsconderBoton(int segundos)
        {
            this.segundos = segundos;
        }
        
        @Override
        public void run()
        {
            siguiente.setSize(0,0);
            try { Thread.sleep(segundos); } catch (InterruptedException ex) {}
            siguiente.setSize(siguiente.getPreferredSize());
        }
    }
    
    public class PoderEncierro extends Thread
    {
        @Override
        public void run()
        {
            try { Thread.sleep(6900); } catch (InterruptedException ex) {}
            Sonidos.getInstance().reproducir("trueno");
            try { Thread.sleep(600); } catch (InterruptedException ex) {}
            labelPoderEncierro.setSize(labelPoderEncierro.getPreferredSize());
        }
    }
    
    public class PiedraNar extends Thread
    {
        @Override
        public void run()
        {
            try { Thread.sleep(1000); } catch (InterruptedException ex) {}
            labelPiedraNar.setSize(labelPoderEncierro.getPreferredSize());
        }
    }
    
    public class ReproducirSonido extends Thread 
    {
        int segundos;
        String pista;
        
        public ReproducirSonido(int segundos, String pista)
        {
            this.segundos = segundos;
            this.pista = pista;
        }
        
        @Override
        public void run()
        {
            try { Thread.sleep(segundos); } catch (InterruptedException ex) {}
            Sonidos.getInstance().reproducir(pista);
        }
    }    
    
    
    public class CambiarEscena extends Thread
    {
       private int intervalo;
       private int contImg;
       
       public CambiarEscena(int inrv, int cont)
       {
         this.intervalo = inrv;
         this.contImg = cont;
       }
       
       @Override
       public void run()
       {
          siguiente.setSize(0,0); 
          
          for(int i = 0; i<efectoCierre.length; i++)
          {
            pantallaNegra.setIcon(efectoCierre[i]); 
            pantallaNegra1.setIcon(efectoCierre[i]);
            try { Thread.sleep(intervalo); } catch (InterruptedException ex) {}
          }                      
          
          contenido.setIcon(escenas[contImg-1]);
          
          for(int i = efectoCierre.length-1; i>=0; i--)
          {
            pantallaNegra.setIcon(efectoCierre[i]); 
            pantallaNegra1.setIcon(efectoCierre[i]);
            try { Thread.sleep(intervalo); } catch (InterruptedException ex) {}
          }
          //siguiente.setSize(siguiente.getPreferredSize());
          
       }
    }
    
}
