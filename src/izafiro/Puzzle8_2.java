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
public class Puzzle8_2 extends javax.swing.JFrame {

    private Icon[] instrucciones;
    private Icon[] efectoCierre;
    private Icon[] efectoContinuara;
    private int cont = 1;
    private String clip1;
    private String clip2;
    
    
    /**
     * Creates new form Puzzle8
     */
    public Puzzle8_2() {
        initComponents();
        this.setLocationRelativeTo(null); this.setIconImage(new ImageIcon (getClass().getResource("izafiroicono.png")).getImage()); Sonidos.getInstance().activarCursor(this);
        
        instrucciones = new Icon[9];         
        instrucciones[0] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle8/postbatalla/1.png"));
        instrucciones[1] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle8/postbatalla/2.png"));
        if(GestorJuego.getInstance().getGenero().equals("lily")){
          instrucciones[2] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle8/postbatalla/3-1.png"));  
        }
        else{
          instrucciones[2] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle8/postbatalla/3-2.png"));
        }
        if(GestorJuego.getInstance().getGenero().equals("lily")){
          instrucciones[3] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle8/postbatalla/4-1.png"));
        }
        else{
          instrucciones[3] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle8/postbatalla/4-2.png"));
        }
        instrucciones[4] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle8/postbatalla/5.png"));
        instrucciones[5] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle8/postbatalla/6.png"));
        instrucciones[6] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle8/postbatalla/7.png"));
        instrucciones[7] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle8/postbatalla/8.png"));
        instrucciones[8] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle8/postbatalla/9.png"));
        
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
        
        efectoContinuara = new Icon[11];         
        efectoContinuara[0] = new ImageIcon (getClass().getResource("imagenes/objetos/secuenciacierre/continuara0.png"));
        efectoContinuara[1] = new ImageIcon (getClass().getResource("imagenes/objetos/secuenciacierre/continuara1.png"));
        efectoContinuara[2] = new ImageIcon (getClass().getResource("imagenes/objetos/secuenciacierre/continuara2.png"));
        efectoContinuara[3] = new ImageIcon (getClass().getResource("imagenes/objetos/secuenciacierre/continuara3.png"));
        efectoContinuara[4] = new ImageIcon (getClass().getResource("imagenes/objetos/secuenciacierre/continuara4.png"));
        efectoContinuara[5] = new ImageIcon (getClass().getResource("imagenes/objetos/secuenciacierre/continuara5.png"));
        efectoContinuara[6] = new ImageIcon (getClass().getResource("imagenes/objetos/secuenciacierre/continuara6.png"));
        efectoContinuara[7] = new ImageIcon (getClass().getResource("imagenes/objetos/secuenciacierre/continuara7.png"));
        efectoContinuara[8] = new ImageIcon (getClass().getResource("imagenes/objetos/secuenciacierre/continuara8.png"));
        efectoContinuara[9] = new ImageIcon (getClass().getResource("imagenes/objetos/secuenciacierre/continuara9.png"));
        efectoContinuara[10] = new ImageIcon (getClass().getResource("imagenes/objetos/secuenciacierre/continuara10.png"));
        
        clip1 = "rio";
        Sonidos.getInstance().reproducirLoop(clip1);
        
        clip2 = "entradaaldea";
        Sonidos.getInstance().reproducirLoop(clip2);
        
        salud.setIcon(new ImageIcon (getClass().getResource("imagenes/barra/salud"+GestorJuego.getInstance().getSalud()+".PNG")));
        
        if(GestorJuego.getInstance().getRecursos()[0]){recurso1.setIcon(new ImageIcon (getClass().getResource("imagenes/barra/recursos/recurso1.png")));}
        if(GestorJuego.getInstance().getRecursos()[1]){recurso2.setIcon(new ImageIcon (getClass().getResource("imagenes/barra/recursos/recurso2.png")));}
        if(GestorJuego.getInstance().getRecursos()[2]){recurso3.setIcon(new ImageIcon (getClass().getResource("imagenes/barra/recursos/recurso3.png")));}
        if(GestorJuego.getInstance().getRecursos()[3]){recurso4.setIcon(new ImageIcon (getClass().getResource("imagenes/barra/recursos/recurso4.png")));}
        if(GestorJuego.getInstance().getRecursos()[4]){recurso5.setIcon(new ImageIcon (getClass().getResource("imagenes/barra/recursos/recurso5.png")));}
        if(GestorJuego.getInstance().getRecursos()[5]){recurso6.setIcon(new ImageIcon (getClass().getResource("imagenes/barra/recursos/recurso6.png")));}
        
        
        tahi.setIcon(new ImageIcon (getClass().getResource("imagenes/personajes/tahi/"+GestorJuego.getInstance().getGenero()+"11.png")));
        
        new MoverPersonajes1().start();      
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
      new MoverPersonajes2().start();      
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        continuara = new javax.swing.JLabel();
        siguiente = new javax.swing.JLabel();
        anterior = new javax.swing.JLabel();
        pantallaNegra = new javax.swing.JLabel();
        pantallaNegra1 = new javax.swing.JLabel();
        barra = new javax.swing.JLabel();
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
        letrero = new javax.swing.JLabel();
        cuadroDialogo = new javax.swing.JLabel();
        puerta = new javax.swing.JLabel();
        tahi = new javax.swing.JLabel();
        patriarca = new javax.swing.JLabel();
        tiomelvin = new javax.swing.JLabel();
        bote = new javax.swing.JLabel();
        bote2 = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("iZafiro - Aldea Luz de Luna");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        continuara.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/objetos/secuenciacierre/continuara0.png"))); // NOI18N
        getContentPane().add(continuara, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 280, -1, -1));

        siguiente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        siguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/botones/flecha-siguiente.png"))); // NOI18N
        siguiente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        siguiente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                siguienteMouseClicked(evt);
            }
        });
        getContentPane().add(siguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(665, 340, 0, 0));

        anterior.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        anterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/botones/flecha-anterior.png"))); // NOI18N
        anterior.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        anterior.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                anteriorMouseClicked(evt);
            }
        });
        getContentPane().add(anterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 340, 0, 0));

        pantallaNegra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/objetos/secuenciacierre/0.png"))); // NOI18N
        getContentPane().add(pantallaNegra, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pantallaNegra1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/objetos/secuenciacierre/0.png"))); // NOI18N
        getContentPane().add(pantallaNegra1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 480, -1, 120));

        barra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/barra.png"))); // NOI18N
        barra.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        barra.setMaximumSize(new java.awt.Dimension(800, 110));
        barra.setMinimumSize(new java.awt.Dimension(800, 110));
        barra.setPreferredSize(new java.awt.Dimension(800, 110));
        getContentPane().add(barra, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 490, -1, -1));

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

        letrero.setBackground(new java.awt.Color(0, 0, 153));
        letrero.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        letrero.setForeground(new java.awt.Color(255, 255, 255));
        letrero.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        letrero.setText("Entrada a la Aldea Luz de Luna");
        letrero.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        letrero.setOpaque(true);
        letrero.setPreferredSize(new java.awt.Dimension(350, 90));
        getContentPane().add(letrero, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 200, 0, 0));

        cuadroDialogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cuadroDialogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/puzzle/puzzle8/instrucciones/1.png"))); // NOI18N
        getContentPane().add(cuadroDialogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 340, 0, 0));

        puerta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/objetos/puerta2.png"))); // NOI18N
        getContentPane().add(puerta, new org.netbeans.lib.awtextra.AbsoluteConstraints(353, 18, -1, -1));

        tahi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/personajes/tahi/tahi11.png"))); // NOI18N
        getContentPane().add(tahi, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 530, -1, -1));

        patriarca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/objetos/patriarca2.png"))); // NOI18N
        getContentPane().add(patriarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 510, -1, -1));

        tiomelvin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/objetos/tiomelvin2.png"))); // NOI18N
        getContentPane().add(tiomelvin, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 540, -1, -1));

        bote.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/objetos/bote.png"))); // NOI18N
        getContentPane().add(bote, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 500, -1, -1));

        bote2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/objetos/bote.png"))); // NOI18N
        getContentPane().add(bote2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 500, -1, -1));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/puzzle/puzzle8/fondo2.png"))); // NOI18N
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
            java.util.logging.Logger.getLogger(Puzzle8_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Puzzle8_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Puzzle8_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Puzzle8_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Puzzle8_2().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel anterior;
    private javax.swing.JLabel barra;
    private javax.swing.JLabel bote;
    private javax.swing.JLabel bote2;
    private javax.swing.JLabel continuara;
    private javax.swing.JLabel cuadroDialogo;
    private javax.swing.JLabel energia;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel hora;
    private javax.swing.JLabel letrero;
    private javax.swing.JLabel n1;
    private javax.swing.JLabel n2;
    private javax.swing.JLabel n3;
    private javax.swing.JLabel n4;
    private javax.swing.JLabel pantallaNegra;
    private javax.swing.JLabel pantallaNegra1;
    private javax.swing.JLabel patriarca;
    private javax.swing.JLabel puerta;
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

       
    
    public class MoverPersonajes1 extends Thread
    {
       @Override
       public void run()
       {
          try { Thread.sleep(3000); } catch (InterruptedException ex) {}  
           
          letrero.setSize(letrero.getPreferredSize()); 
           
          try { Thread.sleep(4000); } catch (InterruptedException ex) {}  
          
          letrero.setSize(0,0);
          
          try { Thread.sleep(2000); } catch (InterruptedException ex) {}  
          
          while(bote.getY() > 260) 
          {
            tahi.setLocation(tahi.getX(), tahi.getY()-2);  
            bote.setLocation(bote.getX(), bote.getY()-2); 
            try { Thread.sleep(30); } catch (InterruptedException ex) {}
          }
                    
          try { Thread.sleep(1000); } catch (InterruptedException ex) {}
          
          tahi.setIcon(new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle2/"+GestorJuego.getInstance().getGenero()+"/4.gif")));
          while(tahi.getY() > 200) 
          {
            tahi.setLocation(tahi.getX(), tahi.getY()-2);  
            try { Thread.sleep(40); } catch (InterruptedException ex) {}
          }
          
          tahi.setIcon(new ImageIcon (getClass().getResource("imagenes/personajes/tahi/"+GestorJuego.getInstance().getGenero()+"8.png")));
                  
          try { Thread.sleep(1500); } catch (InterruptedException ex) {}
          
          while(bote2.getY() > 260) 
          {
            patriarca.setLocation(patriarca.getX(), patriarca.getY()-2);  
            tiomelvin.setLocation(tiomelvin.getX(), tiomelvin.getY()-2); 
            bote2.setLocation(bote2.getX(), bote2.getY()-2); 
            try { Thread.sleep(30); } catch (InterruptedException ex) {}
          }
          
          try { Thread.sleep(1500); } catch (InterruptedException ex) {}
          
          tiomelvin.setIcon(new ImageIcon (getClass().getResource("imagenes/objetos/tiomelvin3.gif")));
           
          while(patriarca.getY() > 190) 
          {
            patriarca.setLocation(patriarca.getX(), patriarca.getY()-2);  
            tiomelvin.setLocation(tiomelvin.getX(), tiomelvin.getY()-2); 
            try { Thread.sleep(50); } catch (InterruptedException ex) {}
          }
          
          patriarca.setIcon(new ImageIcon (getClass().getResource("imagenes/objetos/patriarca3.png"))); 
          tiomelvin.setIcon(new ImageIcon (getClass().getResource("imagenes/objetos/tiomelvin4.png")));
          
          try { Thread.sleep(1500); } catch (InterruptedException ex) {}
          
          mostrarInstrucciones();        
       }
    }
    
    
    public class MoverPersonajes2 extends Thread
    {
       @Override
       public void run()
       {
         try { Thread.sleep(1500); } catch (InterruptedException ex) {}  
         
         puerta.setSize(0,0);
         Sonidos.getInstance().reproducir("success1");
         
         try { Thread.sleep(1500); } catch (InterruptedException ex) {}  
         
         while(patriarca.getX() < 470) 
         {
           patriarca.setLocation(patriarca.getX()+2, patriarca.getY());  
           try { Thread.sleep(55); } catch (InterruptedException ex) {}
         }
           
         tahi.setIcon(new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle2/"+GestorJuego.getInstance().getGenero()+"/4.gif")));
         tiomelvin.setIcon(new ImageIcon (getClass().getResource("imagenes/objetos/tiomelvin3.gif")));
         
         while(tiomelvin.getY() > -100) 
         {
           tahi.setLocation(tahi.getX(), tahi.getY()-2);  
           tiomelvin.setLocation(tiomelvin.getX(), tiomelvin.getY()-2);
           try { Thread.sleep(60); } catch (InterruptedException ex) {}
         } 
         
         try { Thread.sleep(2000); } catch (InterruptedException ex) {}
         
         efectosCierre();                 
         
         try { Thread.sleep(3000); } catch (InterruptedException ex) {}
         
         
         GestorJuego.getInstance().setTerminarJuego(true);
         GestorJuego.getInstance().cerrarPartida();
         setVisible(false);
         Sonidos.getInstance().detener(clip1);
         Sonidos.getInstance().detener(clip2);
         dispose();
         GestorJuego.setPartida(null);
         System.gc();
         
         new Creditos().setVisible(true);        
       }
       
       public void efectosCierre()
       {
         for(int i = 0; i<efectoCierre.length; i++)
         {
           pantallaNegra.setIcon(efectoCierre[i]); 
           pantallaNegra1.setIcon(efectoCierre[i]);
           try { Thread.sleep(200); } catch (InterruptedException ex) {}
         }
         
         for(int i = 0; i<efectoCierre.length; i++)
         {
           continuara.setIcon(efectoContinuara[i]);  
           try { Thread.sleep(200); } catch (InterruptedException ex) {}
         }
         
         try { Thread.sleep(5000); } catch (InterruptedException ex) {}
         
         for(int i = efectoCierre.length-1; i>=0; i--)
         {
           continuara.setIcon(efectoContinuara[i]);  
           try { Thread.sleep(200); } catch (InterruptedException ex) {}
         }
       }
    }
}
