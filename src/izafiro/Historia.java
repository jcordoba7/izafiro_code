/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package izafiro;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Jacc89
 */
public class Historia extends javax.swing.JFrame {

    Icon[] efectoCierre;
    Icon[] escenas;
    Icon[] titulo;
    Icon paracaidas;
    
    private boolean cambioPista = false;
    //private boolean cambioEscena = false; 
    private int cont = 1;
    
    /**
     * Creates new form Historia
     */
    public Historia() {
        initComponents();
        this.setLocationRelativeTo(null); this.setIconImage(new ImageIcon (getClass().getResource("izafiroicono.png")).getImage()); Sonidos.getInstance().activarCursor(this);
                
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
                
        titulo = new Icon[11];         
        titulo[0] = new ImageIcon (getClass().getResource("imagenes/creditos/efectotitulo/0.png"));
        titulo[1] = new ImageIcon (getClass().getResource("imagenes/creditos/efectotitulo/1.png")); 
        titulo[2] = new ImageIcon (getClass().getResource("imagenes/creditos/efectotitulo/2.png")); 
        titulo[3] = new ImageIcon (getClass().getResource("imagenes/creditos/efectotitulo/3.png")); 
        titulo[4] = new ImageIcon (getClass().getResource("imagenes/creditos/efectotitulo/4.png")); 
        titulo[5] = new ImageIcon (getClass().getResource("imagenes/creditos/efectotitulo/5.png")); 
        titulo[6] = new ImageIcon (getClass().getResource("imagenes/creditos/efectotitulo/6.png")); 
        titulo[7] = new ImageIcon (getClass().getResource("imagenes/creditos/efectotitulo/7.png")); 
        titulo[8] = new ImageIcon (getClass().getResource("imagenes/creditos/efectotitulo/8.png")); 
        titulo[9] = new ImageIcon (getClass().getResource("imagenes/creditos/efectotitulo/9.png"));
        titulo[10] = new ImageIcon (getClass().getResource("imagenes/creditos/efectotitulo/10.png"));
        
        
        escenas = new Icon[15];         
        escenas[0] = new ImageIcon (getClass().getResource("imagenes/historia/1.png"));
        escenas[1] = new ImageIcon (getClass().getResource("imagenes/historia/2.png"));
        escenas[2] = new ImageIcon (getClass().getResource("imagenes/historia/3.png"));
        escenas[3] = new ImageIcon (getClass().getResource("imagenes/historia/4.png"));
        escenas[4] = new ImageIcon (getClass().getResource("imagenes/historia/5.png"));
        escenas[5] = new ImageIcon (getClass().getResource("imagenes/historia/6.png"));
        escenas[6] = new ImageIcon (getClass().getResource("imagenes/historia/7.png"));
        escenas[7] = new ImageIcon (getClass().getResource("imagenes/historia/8.png"));
        escenas[8] = new ImageIcon (getClass().getResource("imagenes/historia/9.png"));
        escenas[9] = new ImageIcon (getClass().getResource("imagenes/historia/10.png"));
        escenas[10] = new ImageIcon (getClass().getResource("imagenes/historia/11.png"));
        escenas[11] = new ImageIcon (getClass().getResource("imagenes/historia/12.png"));
        escenas[12] = new ImageIcon (getClass().getResource("imagenes/historia/13.png"));
        escenas[13] = new ImageIcon (getClass().getResource("imagenes/historia/14.png"));
        escenas[14] = new ImageIcon (getClass().getResource("imagenes/historia/16.png"));
        
        paracaidas = new ImageIcon (getClass().getResource("imagenes/historia/15.png"));
        
        new SecuenciaInicio().start();        
    }
    
    public void aclararPantalla(int intervalo)
       {
         for(int i = efectoCierre.length-1; i>=0; i--)
         {
           pantallaNegra.setIcon(efectoCierre[i]); 
           pantallaNegra1.setIcon(efectoCierre[i]);
           try { Thread.sleep(intervalo); } catch (InterruptedException ex) {}
         }
       }
    
    public void oscurecerPantalla(int intervalo)
       {
         for(int i = 0; i<efectoCierre.length; i++)
         {
           pantallaNegra.setIcon(efectoCierre[i]); 
           pantallaNegra1.setIcon(efectoCierre[i]);
           try { Thread.sleep(intervalo); } catch (InterruptedException ex) {}
         }
       }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        izafiro = new javax.swing.JLabel();
        siguiente = new javax.swing.JLabel();
        anterior = new javax.swing.JLabel();
        iniciar = new javax.swing.JLabel();
        pantallaNegra1 = new javax.swing.JLabel();
        pantallaNegra = new javax.swing.JLabel();
        rayo = new javax.swing.JLabel();
        llama1 = new javax.swing.JLabel();
        llama2 = new javax.swing.JLabel();
        llama3 = new javax.swing.JLabel();
        llama4 = new javax.swing.JLabel();
        paracaidas1 = new javax.swing.JLabel();
        paracaidas2 = new javax.swing.JLabel();
        paracaidas3 = new javax.swing.JLabel();
        paracaidas4 = new javax.swing.JLabel();
        globo = new javax.swing.JLabel();
        globo1 = new javax.swing.JLabel();
        contenido = new javax.swing.JLabel();
        volver = new javax.swing.JToggleButton();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("iZafiro Game");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        izafiro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/creditos/efectotitulo/0.png"))); // NOI18N
        getContentPane().add(izafiro, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, -1, -1));

        siguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/botones/flecha-siguiente.png"))); // NOI18N
        siguiente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        siguiente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                siguienteMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                siguienteMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                siguienteMouseEntered(evt);
            }
        });
        getContentPane().add(siguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 470, 0, 0));

        anterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/botones/flecha-anterior.png"))); // NOI18N
        anterior.setText("jLabel1");
        anterior.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        anterior.setPreferredSize(new java.awt.Dimension(50, 50));
        anterior.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                anteriorMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                anteriorMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                anteriorMouseEntered(evt);
            }
        });
        getContentPane().add(anterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 470, 0, 0));

        iniciar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iniciar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/texto/portada/iniciar-partida.png"))); // NOI18N
        iniciar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        getContentPane().add(iniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 470, 0, 0));

        pantallaNegra1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/objetos/secuenciacierre/10.png"))); // NOI18N
        pantallaNegra1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(pantallaNegra1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, -1, 260));

        pantallaNegra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/objetos/secuenciacierre/10.png"))); // NOI18N
        pantallaNegra.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(pantallaNegra, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 270));

        rayo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/objetos/rayo.png"))); // NOI18N
        getContentPane().add(rayo, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, 0, 0));

        llama1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/objetos/flama.gif"))); // NOI18N
        llama1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        llama1.setPreferredSize(new java.awt.Dimension(33, 30));
        getContentPane().add(llama1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, 0, 0));

        llama2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/objetos/flama.gif"))); // NOI18N
        llama2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        llama2.setPreferredSize(new java.awt.Dimension(33, 30));
        getContentPane().add(llama2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 0, 0));

        llama3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/objetos/flama.gif"))); // NOI18N
        llama3.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        llama3.setPreferredSize(new java.awt.Dimension(33, 30));
        getContentPane().add(llama3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 0, 0));

        llama4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/objetos/flama.gif"))); // NOI18N
        llama4.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        llama4.setPreferredSize(new java.awt.Dimension(33, 30));
        getContentPane().add(llama4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 0, 0));

        paracaidas1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/objetos/paracaidasslily.png"))); // NOI18N
        getContentPane().add(paracaidas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 150, 0, 0));

        paracaidas2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/objetos/paracaidastahi.png"))); // NOI18N
        getContentPane().add(paracaidas2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 150, 0, 0));

        paracaidas3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/objetos/paracaidasslily.png"))); // NOI18N
        getContentPane().add(paracaidas3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 40, 0, 0));

        paracaidas4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/objetos/paracaidastahi.png"))); // NOI18N
        getContentPane().add(paracaidas4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 0, 0));

        globo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/objetos/globo.png"))); // NOI18N
        getContentPane().add(globo, new org.netbeans.lib.awtextra.AbsoluteConstraints(458, 39, 0, 0));

        globo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/objetos/globo2.png"))); // NOI18N
        getContentPane().add(globo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(458, 39, 0, 0));

        contenido.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        contenido.setForeground(new java.awt.Color(255, 255, 255));
        contenido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        contenido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/historia/1.png"))); // NOI18N
        contenido.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        contenido.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(contenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 35, 610, 415));

        volver.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        volver.setForeground(new java.awt.Color(0, 102, 0));
        volver.setText("Menú Principal");
        volver.setFocusable(false);
        volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverActionPerformed(evt);
            }
        });
        getContentPane().add(volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 500, -1, -1));

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
                case (1): this.contenido.setIcon(escenas[cont-1]);break;
                case (2): this.contenido.setIcon(escenas[cont-1]);break;  
                case (3): new CambiarEscena(100,cont).start();break;
                case (4): this.contenido.setIcon(escenas[cont-1]);break;
                case (5): this.contenido.setIcon(escenas[cont-1]);break;
                case (6): new CambiarEscena(100,cont).start();break;
                case (7): this.contenido.setIcon(escenas[cont-1]);new Globo1().start();break;
                case (8): this.contenido.setIcon(escenas[cont-1]);new Globo2().start();break;
                case (9): new CambiarEscena(150,cont).start();new Globo3().start();break;
                case (10): new CambiarEscena(100,cont).start();new Globo4().start();break;
                case (11): this.contenido.setIcon(escenas[cont-1]);new Rayo().start();break;
                case (12): this.contenido.setIcon(escenas[cont-1]);break;
                case (13): this.contenido.setIcon(escenas[cont-1]);new Globo5().start();break;
                case (14): this.contenido.setIcon(escenas[cont-1]);new Final().start();break;
                case (15): new CambiarEscena(100,cont).start();new Espera().start();break;    
            }
        }
        else
        {
            this.iniciar.setSize(iniciar.getPreferredSize());
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

    private void anteriorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_anteriorMouseClicked
        // TODO add your handling code here:        
        /*if(cont != 1)
        {            
            cont--;
            this.contenido.setIcon(escenas[cont-1]);
            
            switch(cont)
            {                 
                case (7): new Globo1().start();break;
                case (8): new Globo2().start();break;
                case (9): new Globo3().start();break;
                case (10): new Globo4().start();break;
                case (11): new Rayo().start();break;
                case (13): new Globo5().start();break;
                case (14): new Final().start();break;
            }
        }*/
        
        if(cont != 1)
        {            
            if( cont<8 || cont>10 ){ cont--; }
            
            switch(cont)
            {                 
                case (1): this.contenido.setIcon(escenas[cont-1]);break;
                case (2): this.contenido.setIcon(escenas[cont-1]);break;  
                case (3): this.contenido.setIcon(escenas[cont-1]);new CambiarEscena(100,cont).start();break;
                case (4): this.contenido.setIcon(escenas[cont-1]);break;
                case (5): this.contenido.setIcon(escenas[cont-1]);break;
                case (6): this.contenido.setIcon(escenas[cont-1]);new CambiarEscena(100,cont).start();break;
                case (7): this.contenido.setIcon(escenas[cont-1]);new Globo1().start();break;
                case (8): /*this.contenido.setIcon(escenas[cont-1]);
                          try { Thread.sleep(1000); } catch (InterruptedException ex) {}            
                          Sonidos.getInstance().detener("portada");
                          Sonidos.getInstance().reproducirLoop("historia"); 
                          cambioPista = false;
                          new Globo2().start();*/break;
                case (9): /*new CambiarEscena(100,cont).start();new Globo3().start()*/;break;
                case (10): /*new CambiarEscena(100,cont).start();new Globo4().start()*/;break;
                case (11): this.contenido.setIcon(escenas[cont-1]);new Rayo().start();break;
                case (12): this.contenido.setIcon(escenas[cont-1]);break;
                case (13): this.contenido.setIcon(escenas[cont-1]);new Globo5().start();break;
                case (14): this.contenido.setIcon(escenas[cont-1]);new Final().start();break;
                case (15): this.contenido.setIcon(escenas[cont-1]);new CambiarEscena(150,cont).start();new Espera().start();break;  
            }
        }
    }//GEN-LAST:event_anteriorMouseClicked

    private void anteriorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_anteriorMouseEntered
        // TODO add your handling code here:
        this.anterior.setIcon(new ImageIcon (getClass().getResource("imagenes/botones/flecha-anterior-over.png")));
    }//GEN-LAST:event_anteriorMouseEntered

    private void anteriorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_anteriorMouseExited
        // TODO add your handling code here:
        this.anterior.setIcon(new ImageIcon (getClass().getResource("imagenes/botones/flecha-anterior.png")));
    }//GEN-LAST:event_anteriorMouseExited

    private void iniciarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iniciarMouseClicked
        // TODO add your handling code here:
        Sonidos.getInstance().reproducirLoop("sonidosbosque");
        
        this.setVisible(false);
        this.dispose();
        
        new CrearPartida().setVisible(true);        
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

    private void volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverActionPerformed
        // TODO add your handling code here:
        if(!cambioPista){ 
            Sonidos.getInstance().detener("historia"); 
            Sonidos.getInstance().reproducirLoop("portada");
        }        
        
        Sonidos.getInstance().reproducirLoop("sonidosbosque");
        this.setVisible(false);
        this.dispose();
        
        try {
            new MainMenu().setVisible(true);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            Logger.getLogger(ContinuarPartida.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_volverActionPerformed

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
            java.util.logging.Logger.getLogger(Historia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Historia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Historia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Historia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Historia().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel anterior;
    private javax.swing.JLabel contenido;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel globo;
    private javax.swing.JLabel globo1;
    private javax.swing.JLabel iniciar;
    private javax.swing.JLabel izafiro;
    private javax.swing.JLabel llama1;
    private javax.swing.JLabel llama2;
    private javax.swing.JLabel llama3;
    private javax.swing.JLabel llama4;
    private javax.swing.JLabel pantallaNegra;
    private javax.swing.JLabel pantallaNegra1;
    private javax.swing.JLabel paracaidas1;
    private javax.swing.JLabel paracaidas2;
    private javax.swing.JLabel paracaidas3;
    private javax.swing.JLabel paracaidas4;
    private javax.swing.JLabel rayo;
    private javax.swing.JLabel siguiente;
    private javax.swing.JToggleButton volver;
    // End of variables declaration//GEN-END:variables
    
    
    public class Globo1 extends Thread{
        
        @Override
        public void run()
        {
          globo.setLocation(458,39);
          globo.setSize(globo.getPreferredSize()); 
          anterior.setSize(0,0);
          siguiente.setSize(0,0);
          volver.setSize(0,0);
          
          for(int i=0; i<300; i++)
          {
             globo.setLocation(globo.getX(),globo.getY()-1); 
             try {
               Thread.sleep(17);
             } catch (InterruptedException ex) {}
          }
          globo.setSize(0,0);
          anterior.setSize(anterior.getPreferredSize());
          siguiente.setSize(anterior.getPreferredSize());  
          volver.setSize(volver.getPreferredSize()); 
        }
    }
    
    public class Globo2 extends Thread{
        
        @Override
        public void run()
        {               
            
          globo.setSize(globo.getPreferredSize()); 
          anterior.setSize(0,0);
          siguiente.setSize(0,0);
          volver.setSize(0,0);
          
          try { Thread.sleep(1000); } catch (InterruptedException ex) {} 
          
          globo.setLocation(164+600,-223);
          
          for(int i=0; i<800; i++)
          {
             globo.setLocation(globo.getX()-1,globo.getY()+1); 
             try {
               Thread.sleep(18);
             } catch (InterruptedException ex) {}
          }
          globo.setSize(0,0);
          anterior.setSize(anterior.getPreferredSize());
          siguiente.setSize(anterior.getPreferredSize()); 
          volver.setSize(volver.getPreferredSize());
        }
    } 
    
    public class Globo3 extends Thread{
        
        @Override
        public void run()
        {
          globo.setSize(globo.getPreferredSize()); 
          anterior.setSize(0,0);
          siguiente.setSize(0,0);
          volver.setSize(0,0);  
          globo.setLocation(800,50);
          
          try { Thread.sleep(8000); } catch (InterruptedException ex) {}                 
          
          for(int i=0; i<960; i++)
          {
             globo.setLocation(globo.getX()-1,globo.getY()); 
             try {
               Thread.sleep(12);
             } catch (InterruptedException ex) {}
          }
          globo.setSize(0,0);
          anterior.setSize(anterior.getPreferredSize());
          siguiente.setSize(anterior.getPreferredSize());
          volver.setSize(volver.getPreferredSize());
        }
    }
    
    public class Globo4 extends Thread{
        
        @Override
        public void run()
        {          
          globo.setSize(globo.getPreferredSize()); 
          anterior.setSize(0,0);
          siguiente.setSize(0,0);
          volver.setSize(0,0);
          globo.setLocation(-164,50);
          
          try { Thread.sleep(2500); } catch (InterruptedException ex) {}          
          
          anterior.setSize(0,0);
          siguiente.setSize(0,0);
          
          for(int i=0; i<315; i++)
          {
             globo.setLocation(globo.getX()+1,globo.getY()); 
             try {
               Thread.sleep(18);
             } catch (InterruptedException ex) {}
          }          
          anterior.setSize(anterior.getPreferredSize());
          siguiente.setSize(anterior.getPreferredSize());
          volver.setSize(volver.getPreferredSize());
        }
    }
    
    public class Globo5 extends Thread{
        
        @Override
        public void run()
        { 
          anterior.setSize(0,0);
          siguiente.setSize(0,0);
          volver.setSize(0,0);
                     
          globo.setSize(globo.getPreferredSize());
          llama1.setSize(llama1.getPreferredSize());
          llama2.setSize(llama2.getPreferredSize());
          llama3.setSize(llama3.getPreferredSize());
          llama4.setSize(llama4.getPreferredSize());
          paracaidas1.setSize(0,0);
          paracaidas2.setSize(0,0);
          
          globo.setLocation(400-(164/2),-223);
          globo1.setLocation(400-(164/2),-223);
          paracaidas1.setLocation(300,150);
          paracaidas2.setLocation(350,150);
          
          int x = 160;
          int y = -270;
          
          llama1.setLocation(280+x,80+y);
          llama2.setLocation(160+x,90+y);
          llama3.setLocation(230+x,140+y);
          llama4.setLocation(200+x,40+y);
          
          for(int i=0; i<800; i++)
          {
             globo.setLocation(globo.getX(),globo.getY()+1);
             globo1.setLocation(globo1.getX(),globo1.getY()+1);
             llama1.setLocation(llama1.getX(),llama1.getY()+1);
             llama2.setLocation(llama2.getX(),llama2.getY()+1);
             llama3.setLocation(llama3.getX(),llama3.getY()+1);
             llama4.setLocation(llama4.getX(),llama4.getY()+1);
             try {
               Thread.sleep(18);
             } catch (InterruptedException ex) {}
             
             if(i >= 300)
             {
               if(i == 300)
               { 
                 globo.setSize(0,0);
                 globo1.setSize(globo1.getPreferredSize());
                 paracaidas1.setSize(paracaidas1.getPreferredSize());
                 paracaidas2.setSize(paracaidas2.getPreferredSize());
               }               
               paracaidas1.setLocation(paracaidas1.getX()-2,paracaidas1.getY()+1);
               paracaidas2.setLocation(paracaidas2.getX()+2,paracaidas2.getY()+1);
             }
          }
          globo.setSize(0,0);
          llama1.setSize(0,0);
          llama2.setSize(0,0);
          llama3.setSize(0,0);
          llama4.setSize(0,0);
          
          anterior.setSize(anterior.getPreferredSize());
          siguiente.setSize(anterior.getPreferredSize());
          volver.setSize(volver.getPreferredSize());
        }
    }
    
    public class Rayo extends Thread{
        
        @Override
        public void run()
        { 
          Sonidos.getInstance().reproducir("rayo");
            
          anterior.setSize(0,0);
          siguiente.setSize(0,0);
          volver.setSize(0,0);
          
          globo.setLocation(151,50);
          globo.setSize(globo.getPreferredSize());           
          llama1.setLocation(280,80);
          llama2.setLocation(160,90);
          llama3.setLocation(230,140);
          llama4.setLocation(200,40);
          
          for(int i=0; i<2; i++)
          {
             rayo.setSize(rayo.getPreferredSize()); 
             try {
               Thread.sleep(700);
             } catch (InterruptedException ex) {}
             rayo.setSize(0,0);
             try {
               Thread.sleep(600);
             } catch (InterruptedException ex) {}
          }
          
          llama1.setSize(llama1.getPreferredSize()); // Se incenda el globo
          llama2.setSize(llama2.getPreferredSize());
          llama3.setSize(llama3.getPreferredSize());
          llama4.setSize(llama4.getPreferredSize());
          
          for(int i=0; i<500; i++)
          {
             globo.setLocation(globo.getX()+1,globo.getY()+1); 
             llama1.setLocation(llama1.getX()+1,llama1.getY()+1);
             llama2.setLocation(llama2.getX()+1,llama2.getY()+1);
             llama3.setLocation(llama3.getX()+1,llama3.getY()+1);
             llama4.setLocation(llama4.getX()+1,llama4.getY()+1);
             try {
               Thread.sleep(18);
             } catch (InterruptedException ex) {}
          }
          
          globo.setSize(0,0);
          llama1.setSize(0,0);
          llama2.setSize(0,0);
          llama3.setSize(0,0);
          llama4.setSize(0,0);
          
          anterior.setSize(anterior.getPreferredSize());
          siguiente.setSize(anterior.getPreferredSize()); 
          volver.setSize(volver.getPreferredSize());
        }
    }
    
    public class Final extends Thread{
        
        @Override
        public void run()
        {             
          anterior.setSize(0,0);
          siguiente.setSize(0,0);
          volver.setSize(0,0);
          
          paracaidas1.setSize(paracaidas1.getPreferredSize());
          paracaidas1.setLocation(480,40);
          
          for(int i=0; i<500; i++)
          {
             paracaidas1.setLocation(paracaidas1.getX()-1,paracaidas1.getY()+1); 
             try {
               Thread.sleep(18);
             } catch (InterruptedException ex) {}
          }         
          
          paracaidas1.setSize(0,0);
          paracaidas1.setLocation(700,0);
          
          //----------
          
          contenido.setIcon(paracaidas);
          
          paracaidas2.setSize(paracaidas2.getPreferredSize());
          paracaidas2.setLocation(170,40);
                    
          for(int i=0; i<500; i++)
          {
             paracaidas2.setLocation(paracaidas2.getX()+1,paracaidas2.getY()+1); 
             try {
               Thread.sleep(18);
             } catch (InterruptedException ex) {}
          } 
          
          paracaidas2.setSize(0,0);
          paracaidas2.setLocation(0,0);
                    
          anterior.setSize(anterior.getPreferredSize());
          siguiente.setSize(anterior.getPreferredSize());
        }
    }
    
    public class Espera extends Thread{
        
        @Override
        public void run()
        {
          anterior.setSize(0,0);
          siguiente.setSize(0,0);  
            
          try {
             Thread.sleep(4000);
          } catch (InterruptedException ex) {}
          
          anterior.setSize(anterior.getPreferredSize());
          siguiente.setSize(anterior.getPreferredSize());
        }    
    }
    
    public class SecuenciaInicio extends Thread
    {
       @Override
       public void run()
       { 
         try {Thread.sleep(3500);} catch (InterruptedException ex) {}  
           
         Sonidos.getInstance().reproducirLoop("historia");  
         
         try {Thread.sleep(3500);} catch (InterruptedException ex) {}         
         efectoTitulo();
         
         try {Thread.sleep(6000);} catch (InterruptedException ex) {}    
         efectoTitulo2();
         
         try {Thread.sleep(2000);} catch (InterruptedException ex) {}
         
         efectosCierre(230);
         
         anterior.setSize(anterior.getPreferredSize());
         siguiente.setSize(anterior.getPreferredSize());
       }
    
       public void efectoTitulo()
       {
         for(int i = 0; i<titulo.length; i++)
         {
           izafiro.setIcon(titulo[i]); 
           try { Thread.sleep(150); } catch (InterruptedException ex) {}
         }  
       }
       
       public void efectoTitulo2()
       {
         for(int i = titulo.length-1; i>=0; i--)
         {
           izafiro.setIcon(titulo[i]); 
           try { Thread.sleep(150); } catch (InterruptedException ex) {}
         }  
       }
       
       public void efectosApertura(int intervalo)
       {
         for(int i = 0; i<efectoCierre.length; i++)
         {
           pantallaNegra.setIcon(efectoCierre[i]); 
           pantallaNegra1.setIcon(efectoCierre[i]);
           try { Thread.sleep(intervalo); } catch (InterruptedException ex) {}
         }
       }
       
       public void efectosCierre(int intervalo)
       {
         for(int i = efectoCierre.length-1; i>=0; i--)
         {
           pantallaNegra.setIcon(efectoCierre[i]); 
           pantallaNegra1.setIcon(efectoCierre[i]);
           try { Thread.sleep(intervalo); } catch (InterruptedException ex) {}
         }
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
          anterior.setSize(0,0);
          siguiente.setSize(0,0); 
          
          for(int i = 0; i<efectoCierre.length; i++)
          {
            pantallaNegra.setIcon(efectoCierre[i]); 
            pantallaNegra1.setIcon(efectoCierre[i]);
            try { Thread.sleep(intervalo); } catch (InterruptedException ex) {}
          }
          
          if(contImg == 9)
          {
             try { Thread.sleep(1500); } catch (InterruptedException ex) {}
             Sonidos.getInstance().detener("historia");
             try { Thread.sleep(1500); } catch (InterruptedException ex) {}
             Sonidos.getInstance().reproducirLoop("portada"); 
             cambioPista = true;
             try { Thread.sleep(2000); } catch (InterruptedException ex) {}
          }                          
          
          contenido.setIcon(escenas[contImg-1]);
          
          for(int i = efectoCierre.length-1; i>=0; i--)
          {
            pantallaNegra.setIcon(efectoCierre[i]); 
            pantallaNegra1.setIcon(efectoCierre[i]);
            try { Thread.sleep(intervalo); } catch (InterruptedException ex) {}
          }
          if(contImg != 9 && contImg != 15)
          {
            anterior.setSize(anterior.getPreferredSize());
            siguiente.setSize(anterior.getPreferredSize());
          }
       }
    }
    
}
