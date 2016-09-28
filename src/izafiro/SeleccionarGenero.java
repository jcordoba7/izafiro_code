/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package izafiro;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Jonathan
 */
public class SeleccionarGenero extends javax.swing.JFrame {

    
    /**
     * Creates new form SeleccionarGenero
     */
    public SeleccionarGenero() {
        initComponents();
        this.setLocationRelativeTo(null); this.setIconImage(new ImageIcon (getClass().getResource("izafiroicono.png")).getImage()); Sonidos.getInstance().activarCursor(this);   
        grupoBotones.add(lily);
        grupoBotones.add(tahi);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoBotones = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        iniciar = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        imgTahi = new javax.swing.JLabel();
        imgLily = new javax.swing.JLabel();
        lily = new javax.swing.JRadioButton();
        tahi = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("iZafiro - Selección de Género");
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/iZafito-Tittle-80.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 330, 102));

        iniciar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iniciar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/texto/portada/iniciar-partida.png"))); // NOI18N
        iniciar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                iniciarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                iniciarMouseExited(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iniciarMouseClicked(evt);
            }
        });
        getContentPane().add(iniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 280, 170, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("¿Eres niña o niño?");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 200, 30));

        imgTahi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/personajes/tahi/lily2.png"))); // NOI18N
        getContentPane().add(imgTahi, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 33, 33));

        imgLily.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/personajes/tahi/tahi2.png"))); // NOI18N
        getContentPane().add(imgLily, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 170, 33, 33));

        lily.setBackground(new java.awt.Color(0, 0, 0));
        lily.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lily.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lily.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lily, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, -1, -1));

        tahi.setBackground(new java.awt.Color(0, 0, 0));
        tahi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(tahi, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 180, -1, -1));

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Tahi");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 210, -1, 30));

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Lily");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, -1, 30));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/creditos/efectodescripcion/fondocreditosmusica.png"))); // NOI18N
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 420, 140));

        fondo.setBackground(new java.awt.Color(0, 0, 0));
        fondo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/fondoportada.png"))); // NOI18N
        fondo.setOpaque(true);
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 320));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void iniciarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iniciarMouseClicked
        // TODO add your handling code here:
        if(!this.tahi.isSelected() && !this.lily.isSelected())
        {
          Sonidos.getInstance().reproducir("error");  
          JOptionPane.showMessageDialog(null, "Debes elegir una de las dos opciones!"); 
        }
        else{         
           
          AdministradorBDLocal adL = new AdministradorBDLocal();
            
          if(this.tahi.isSelected()){ GestorJuego.getInstance().setGenero("tahi"); }  
          else{ GestorJuego.getInstance().setGenero("lily"); }
          
          adL.actualizarGenero(GestorJuego.getInstance().getUsuario(),GestorJuego.getInstance().getGenero());
          
          if(GestorJuego.getInstance().getUbicacionBD() == 0)//si la conexion con la BD es remota
          {
            AdministradorConsultasSQL ad = new AdministradorConsultasSQL();  
            ad.actualizarGenero(GestorJuego.getInstance().getUsuario(),GestorJuego.getInstance().getGenero());  
          }
          
          //Sonidos.getInstance().setDano();
          Sonidos.getInstance().reproducir("boton");
            
          try {
             new TablaPuntaje().setVisible(true);
          } catch (SQLException ex) {
             Logger.getLogger(SeleccionarGenero.class.getName()).log(Level.SEVERE, null, ex);
          }
          
          this.dispose();
        }
    }//GEN-LAST:event_iniciarMouseClicked

    private void iniciarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iniciarMouseEntered
        // TODO add your handling code here:
        this.iniciar.setIcon(new ImageIcon (getClass().getResource("texto/portada/iniciar-partida-over.png")));
        Sonidos.getInstance().reproducir("boton");
    }//GEN-LAST:event_iniciarMouseEntered

    private void iniciarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iniciarMouseExited
        // TODO add your handling code here:
        this.iniciar.setIcon(new ImageIcon (getClass().getResource("texto/portada/iniciar-partida.png")));
    }//GEN-LAST:event_iniciarMouseExited

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
            java.util.logging.Logger.getLogger(SeleccionarGenero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SeleccionarGenero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SeleccionarGenero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SeleccionarGenero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SeleccionarGenero().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel fondo;
    private javax.swing.ButtonGroup grupoBotones;
    private javax.swing.JLabel imgLily;
    private javax.swing.JLabel imgTahi;
    private javax.swing.JLabel iniciar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JRadioButton lily;
    private javax.swing.JRadioButton tahi;
    // End of variables declaration//GEN-END:variables
}