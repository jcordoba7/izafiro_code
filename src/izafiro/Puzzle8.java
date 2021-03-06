/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package izafiro;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Jonathan
 */
public class Puzzle8 extends javax.swing.JFrame {

    private Icon[] instrucciones;
    private int cont = 1;
    private String clip1;    
    
    /**
     * Creates new form Puzzle8
     */
    public Puzzle8() {
        initComponents();
        this.setLocationRelativeTo(null); this.setIconImage(new ImageIcon (getClass().getResource("izafiroicono.png")).getImage()); Sonidos.getInstance().activarCursor(this);
        
        instrucciones = new Icon[7];         
        instrucciones[0] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle8/instrucciones/1.png"));
        instrucciones[1] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle8/instrucciones/2.png"));
        instrucciones[2] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle8/instrucciones/3.png"));
        instrucciones[3] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle8/instrucciones/4.png"));
        instrucciones[4] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle8/instrucciones/5.png"));
        instrucciones[5] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle8/instrucciones/6.png"));
        instrucciones[6] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle8/instrucciones/7.png"));
        
        Sonidos.getInstance().reproducirLoop("rio");
        
        if(Tiempo.getInstance(null).getEstado().equals("tarde")) 
        {
            Sonidos.getInstance().reproducirLoop("refugiopatriarca");
        }
        
        clip1 = Tiempo.getInstance(null).getSonidoActual();
        Sonidos.getInstance().reproducirLoop(clip1);
        
        salud.setIcon(new ImageIcon (getClass().getResource("imagenes/barra/salud"+GestorJuego.getInstance().getSalud()+".PNG")));
        
        if(GestorJuego.getInstance().getRecursos()[0]){recurso1.setIcon(new ImageIcon (getClass().getResource("imagenes/barra/recursos/recurso1.png")));}
        if(GestorJuego.getInstance().getRecursos()[1]){recurso2.setIcon(new ImageIcon (getClass().getResource("imagenes/barra/recursos/recurso2.png")));}
        if(GestorJuego.getInstance().getRecursos()[2]){recurso3.setIcon(new ImageIcon (getClass().getResource("imagenes/barra/recursos/recurso3.png")));}
        if(GestorJuego.getInstance().getRecursos()[3]){recurso4.setIcon(new ImageIcon (getClass().getResource("imagenes/barra/recursos/recurso4.png")));}
        if(GestorJuego.getInstance().getRecursos()[4]){recurso5.setIcon(new ImageIcon (getClass().getResource("imagenes/barra/recursos/recurso5.png")));}
        if(GestorJuego.getInstance().getRecursos()[5]){recurso6.setIcon(new ImageIcon (getClass().getResource("imagenes/barra/recursos/recurso6.png")));}
                
        tahi.setIcon(new ImageIcon (getClass().getResource("imagenes/personajes/tahi/"+GestorJuego.getInstance().getGenero()+"11.png")));
        new Iniciar().start();      
    }
    
    
    public void mostrarInstrucciones()
    {
      this.cuadroDialogo.setSize(cuadroDialogo.getPreferredSize());
      this.cuadroDialogo.setIcon(instrucciones[0]); 
      this.siguiente.setSize(30,30);   
      this.anterior.setSize(30,30);
    }
    
    
    public void ocultarInstrucciones()
    {  
      this.cuadroDialogo.setSize(0,0);
      this.siguiente.setSize(0,0);
      this.anterior.setSize(0,0); 
      new MoverPersonaje().start();      
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        salud = new javax.swing.JLabel();
        energia = new javax.swing.JLabel();
        n1 = new javax.swing.JLabel();
        n2 = new javax.swing.JLabel();
        n3 = new javax.swing.JLabel();
        n4 = new javax.swing.JLabel();
        hora = new javax.swing.JLabel();
        recurso1 = new javax.swing.JLabel();
        recurso2 = new javax.swing.JLabel();
        recurso3 = new javax.swing.JLabel();
        recurso6 = new javax.swing.JLabel();
        recurso5 = new javax.swing.JLabel();
        recurso4 = new javax.swing.JLabel();
        recursos = new javax.swing.JLabel();
        barra = new javax.swing.JLabel();
        siguiente = new javax.swing.JLabel();
        anterior = new javax.swing.JLabel();
        cuadroDialogo = new javax.swing.JLabel();
        tahi = new javax.swing.JLabel();
        patriarca = new javax.swing.JLabel();
        tiomelvin = new javax.swing.JLabel();
        bote = new javax.swing.JLabel();
        bote1 = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("iZafiro - Bosque de Las Luciérnagas");
        setMaximumSize(new java.awt.Dimension(800, 600));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        salud.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        salud.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/barra/salud5.PNG"))); // NOI18N
        getContentPane().add(salud, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 530, -1, -1));

        energia.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        energia.setForeground(new java.awt.Color(255, 255, 255));
        energia.setText("Salud");
        getContentPane().add(energia, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 510, -1, -1));

        n1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        n1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/barra/numeros/-.png"))); // NOI18N
        getContentPane().add(n1, new org.netbeans.lib.awtextra.AbsoluteConstraints(372, 535, 14, 29));

        n2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        n2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/barra/numeros/-.png"))); // NOI18N
        getContentPane().add(n2, new org.netbeans.lib.awtextra.AbsoluteConstraints(385, 535, 14, 29));

        n3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        n3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/barra/numeros/-.png"))); // NOI18N
        getContentPane().add(n3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 535, 14, 29));

        n4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        n4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/barra/numeros/-.png"))); // NOI18N
        getContentPane().add(n4, new org.netbeans.lib.awtextra.AbsoluteConstraints(433, 535, 14, 29));

        hora.setBackground(new java.awt.Color(0, 0, 0));
        hora.setFont(new java.awt.Font("DS-Digital", 1, 18)); // NOI18N
        hora.setForeground(new java.awt.Color(204, 0, 0));
        hora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hora.setText(":");
        hora.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        hora.setOpaque(true);
        getContentPane().add(hora, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 530, 100, 40));

        recurso1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/barra/recursos/recurso0.png"))); // NOI18N
        getContentPane().add(recurso1, new org.netbeans.lib.awtextra.AbsoluteConstraints(601, 515, 28, 28));

        recurso2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/barra/recursos/recurso0.png"))); // NOI18N
        getContentPane().add(recurso2, new org.netbeans.lib.awtextra.AbsoluteConstraints(646, 515, 28, 28));

        recurso3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/barra/recursos/recurso0.png"))); // NOI18N
        getContentPane().add(recurso3, new org.netbeans.lib.awtextra.AbsoluteConstraints(691, 515, 28, 28));

        recurso6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/barra/recursos/recurso0.png"))); // NOI18N
        getContentPane().add(recurso6, new org.netbeans.lib.awtextra.AbsoluteConstraints(691, 550, 28, 28));

        recurso5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/barra/recursos/recurso0.png"))); // NOI18N
        getContentPane().add(recurso5, new org.netbeans.lib.awtextra.AbsoluteConstraints(646, 550, 28, 28));

        recurso4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/barra/recursos/recurso0.png"))); // NOI18N
        getContentPane().add(recurso4, new org.netbeans.lib.awtextra.AbsoluteConstraints(601, 550, 28, 28));

        recursos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/barra/recursos.png"))); // NOI18N
        getContentPane().add(recursos, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 508, -1, -1));

        barra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/barra.png"))); // NOI18N
        barra.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        barra.setMaximumSize(new java.awt.Dimension(800, 110));
        barra.setMinimumSize(new java.awt.Dimension(800, 110));
        barra.setPreferredSize(new java.awt.Dimension(800, 110));
        getContentPane().add(barra, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 490, -1, -1));

        siguiente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        siguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/botones/flecha-siguiente.png"))); // NOI18N
        siguiente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        siguiente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                siguienteMouseClicked(evt);
            }
        });
        getContentPane().add(siguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(665, 220, 0, 0));

        anterior.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        anterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/botones/flecha-anterior.png"))); // NOI18N
        anterior.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        anterior.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                anteriorMouseClicked(evt);
            }
        });
        getContentPane().add(anterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 220, 0, 0));

        cuadroDialogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cuadroDialogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/puzzle/puzzle8/instrucciones/1.png"))); // NOI18N
        getContentPane().add(cuadroDialogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, 0, 0));

        tahi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/personajes/tahi/tahi11.png"))); // NOI18N
        getContentPane().add(tahi, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 420, -1, -1));

        patriarca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/objetos/patriarca.png"))); // NOI18N
        getContentPane().add(patriarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 380, -1, -1));

        tiomelvin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/objetos/tiomelvin.png"))); // NOI18N
        getContentPane().add(tiomelvin, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 380, -1, -1));

        bote.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/objetos/bote.png"))); // NOI18N
        getContentPane().add(bote, new org.netbeans.lib.awtextra.AbsoluteConstraints(555, 390, -1, -1));

        bote1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/objetos/bote.png"))); // NOI18N
        getContentPane().add(bote1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 390, -1, -1));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/puzzle/puzzle8/fondo.png"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void siguienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_siguienteMouseClicked
        // TODO add your handling code here:
        if(cont < instrucciones.length){
            cont++;
            this.cuadroDialogo.setIcon(instrucciones[cont-1]);
        }
        else{
            cont = 1;
            ocultarInstrucciones();
        }
    }//GEN-LAST:event_siguienteMouseClicked

    private void anteriorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_anteriorMouseClicked
        // TODO add your handling code here:
        if(cont > 1){
            cont--;
            this.cuadroDialogo.setIcon(instrucciones[cont-1]);
        }
        else{
            cont = 1;
        }
    }//GEN-LAST:event_anteriorMouseClicked

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
            java.util.logging.Logger.getLogger(Puzzle8.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Puzzle8.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Puzzle8.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Puzzle8.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Puzzle8().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel anterior;
    private javax.swing.JLabel barra;
    private javax.swing.JLabel bote;
    private javax.swing.JLabel bote1;
    private javax.swing.JLabel cuadroDialogo;
    private javax.swing.JLabel energia;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel hora;
    private javax.swing.JLabel n1;
    private javax.swing.JLabel n2;
    private javax.swing.JLabel n3;
    private javax.swing.JLabel n4;
    private javax.swing.JLabel patriarca;
    private javax.swing.JLabel recurso1;
    private javax.swing.JLabel recurso2;
    private javax.swing.JLabel recurso3;
    private javax.swing.JLabel recurso4;
    private javax.swing.JLabel recurso5;
    private javax.swing.JLabel recurso6;
    private javax.swing.JLabel recursos;
    private javax.swing.JLabel salud;
    private javax.swing.JLabel siguiente;
    private javax.swing.JLabel tahi;
    private javax.swing.JLabel tiomelvin;
    // End of variables declaration//GEN-END:variables

    public class Iniciar extends Thread
    {
       @Override
       public void run()
       {
          try { Thread.sleep(2000); } catch (InterruptedException ex) {} 
          mostrarInstrucciones();
       }
    }
    
    public class MoverPersonaje extends Thread
    {
       @Override
       public void run()
       {
          try { Thread.sleep(1000); } catch (InterruptedException ex) {}   
          
          tahi.setIcon(new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle2/"+GestorJuego.getInstance().getGenero()+"/3.gif")));
          
          while(tahi.getX() < 560) 
          {
            tahi.setLocation(tahi.getX() + 2, tahi.getY());  
            try { Thread.sleep(20); } catch (InterruptedException ex) {}
          }  
          tahi.setIcon(new ImageIcon (getClass().getResource("imagenes/personajes/tahi/"+GestorJuego.getInstance().getGenero()+"11.png")));
          
          try { Thread.sleep(400); } catch (InterruptedException ex) {}
          new MoverBote().start();
       }
    }
    
    public class MoverBote extends Thread
    {
       @Override
       public void run()
       {
          try { Thread.sleep(1000); } catch (InterruptedException ex) {}   
          
          while(bote.getY() > 290) 
          {
            tahi.setLocation(tahi.getX(), tahi.getY()-2);  
            bote.setLocation(bote.getX(), bote.getY()-2); 
            try { Thread.sleep(20); } catch (InterruptedException ex) {}
          }
          
          while(bote.getX() > 390) 
          {
            tahi.setLocation(tahi.getX()-2, tahi.getY()-2);  
            bote.setLocation(bote.getX()-2, bote.getY()-2); 
            try { Thread.sleep(20); } catch (InterruptedException ex) {}
          }
          
          try { Thread.sleep(500); } catch (InterruptedException ex) {}
          
          while(bote.getY() > -100) 
          {
            tahi.setLocation(tahi.getX(), tahi.getY()-2);  
            bote.setLocation(bote.getX(), bote.getY()-2); 
            try { Thread.sleep(10); } catch (InterruptedException ex) {}
          }
          
          try { Thread.sleep(1500); } catch (InterruptedException ex) {}
          
          setVisible(false);
          
          if(Tiempo.getInstance(null).getEstado().equals("tarde")) 
          {
            Sonidos.getInstance().detener("refugiopatriarca");
          }
          
          Sonidos.getInstance().detener(clip1);
          dispose();
          
          new Puzzle8_1().setVisible(true);
       }
    }

}
