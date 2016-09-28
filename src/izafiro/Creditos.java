/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package izafiro;

import java.sql.SQLException;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Jonathan
 */
public class Creditos extends javax.swing.JFrame {

    private JLabel[] cred;
    private Icon[] descripcion;
    private Icon[] efectoCierre;
    private Icon[] fondos;
    private Icon[] tiemp;
    private Icon[] titulo;
    private int pos;
    private int filaAnterior = 2;

    /**
     * Creates new form Creditos
     */
    public Creditos() {
        initComponents();
        this.setLocationRelativeTo(null); 
        this.setIconImage(new ImageIcon (getClass().getResource("izafiroicono.png")).getImage()); Sonidos.getInstance().activarCursor(this);
        
        cred = new JLabel[8];
        cred[0] = credito1; 
        cred[1] = credito2;
        cred[2] = credito3;
        cred[3] = credito4;
        cred[4] = credito5;
        cred[5] = credito6;
        cred[6] = credito7;
        cred[7] = credito8;  
        
        descripcion = new Icon[10];
        descripcion[0] = new ImageIcon (getClass().getResource("imagenes/creditos/efectodescripcion/descripcion1.png"));
        descripcion[1] = new ImageIcon (getClass().getResource("imagenes/creditos/efectodescripcion/descripcion2.png"));
        descripcion[2] = new ImageIcon (getClass().getResource("imagenes/creditos/efectodescripcion/descripcion3.png"));
        descripcion[3] = new ImageIcon (getClass().getResource("imagenes/creditos/efectodescripcion/descripcion4.png"));
        descripcion[4] = new ImageIcon (getClass().getResource("imagenes/creditos/efectodescripcion/descripcion5.png"));
        descripcion[5] = new ImageIcon (getClass().getResource("imagenes/creditos/efectodescripcion/descripcion6.png"));
        descripcion[6] = new ImageIcon (getClass().getResource("imagenes/creditos/efectodescripcion/descripcion7.png"));
        descripcion[7] = new ImageIcon (getClass().getResource("imagenes/creditos/efectodescripcion/descripcion8.png"));
        descripcion[8] = new ImageIcon (getClass().getResource("imagenes/creditos/efectodescripcion/descripcion9.png"));
        descripcion[9] = new ImageIcon (getClass().getResource("imagenes/creditos/efectodescripcion/descripcion10.png"));
        
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
        
        
        
        fondos = new Icon[17];
        fondos[0] = new ImageIcon (getClass().getResource("imagenes/escenarios/escenario1/v00.png"));
        fondos[1] = new ImageIcon (getClass().getResource("imagenes/escenarios/escenario1/v01.png"));
        fondos[2] = new ImageIcon (getClass().getResource("imagenes/escenarios/escenario1/v02.png"));
        fondos[3] = new ImageIcon (getClass().getResource("imagenes/escenarios/escenario1/v03.png"));
        fondos[4] = new ImageIcon (getClass().getResource("imagenes/escenarios/escenario1/v10.png"));
        fondos[5] = new ImageIcon (getClass().getResource("imagenes/escenarios/escenario1/v11.png"));
        fondos[6] = new ImageIcon (getClass().getResource("imagenes/escenarios/escenario1/v12.png"));
        fondos[7] = new ImageIcon (getClass().getResource("imagenes/escenarios/escenario1/v13.png"));
        fondos[8] = new ImageIcon (getClass().getResource("imagenes/escenarios/escenario1/v20.png"));
        fondos[9] = new ImageIcon (getClass().getResource("imagenes/escenarios/escenario1/v22.png"));
        fondos[10] = new ImageIcon (getClass().getResource("imagenes/escenarios/escenario1/v24.png"));
        fondos[11] = new ImageIcon (getClass().getResource("imagenes/escenarios/escenario1/v33.png"));
        fondos[12] = new ImageIcon (getClass().getResource("imagenes/escenarios/escenario1/v63.png"));
        fondos[13] = new ImageIcon (getClass().getResource("imagenes/escenarios/escenario1/v18.png"));
        fondos[14] = new ImageIcon (getClass().getResource("imagenes/escenarios/escenario1/v25.png"));
        fondos[15] = new ImageIcon (getClass().getResource("imagenes/escenarios/escenario1/v06.png"));
        fondos[16] = new ImageIcon (getClass().getResource("imagenes/escenarios/escenario1/v65.png"));
        
        tiemp = new Icon[3];
        tiemp[0] = new ImageIcon (getClass().getResource("imagenes/tiempo/dia1.png"));
        tiemp[1] = new ImageIcon (getClass().getResource("imagenes/tiempo/atardecer1.png"));
        tiemp[2] = new ImageIcon (getClass().getResource("imagenes/tiempo/noche1.png"));
        
        
        Sonidos.getInstance().reproducir("creditos");
                
        //try {Thread.sleep(2500);} catch (InterruptedException ex) {}
        
        new SecuenciaDescripcion().start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        autor = new javax.swing.JLabel();
        borde = new javax.swing.JLabel();
        descripcionLabel = new javax.swing.JLabel();
        credito1 = new javax.swing.JLabel();
        credito2 = new javax.swing.JLabel();
        credito3 = new javax.swing.JLabel();
        credito4 = new javax.swing.JLabel();
        credito5 = new javax.swing.JLabel();
        credito6 = new javax.swing.JLabel();
        credito7 = new javax.swing.JLabel();
        credito8 = new javax.swing.JLabel();
        credito9 = new javax.swing.JLabel();
        credito10 = new javax.swing.JLabel();
        pantallaNegra = new javax.swing.JLabel();
        tiempo = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("iZafiro - Créditos");
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        autor.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        autor.setForeground(new java.awt.Color(255, 255, 255));
        autor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        autor.setText("Por Jonathan Córdoba");
        getContentPane().add(autor, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 310, 0, 0));

        borde.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        getContentPane().add(borde, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 490));

        descripcionLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/creditos/efectodescripcion/descripcion11.png"))); // NOI18N
        getContentPane().add(descripcionLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        credito1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/creditos/0.png"))); // NOI18N
        getContentPane().add(credito1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 0, 0));

        credito2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/creditos/1.png"))); // NOI18N
        getContentPane().add(credito2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 330, 0, 0));

        credito3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/creditos/2.png"))); // NOI18N
        getContentPane().add(credito3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, 0, 0));

        credito4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/creditos/3.png"))); // NOI18N
        getContentPane().add(credito4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 0, 0));

        credito5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/creditos/4.png"))); // NOI18N
        getContentPane().add(credito5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 160, 0, 0));

        credito6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/creditos/5.png"))); // NOI18N
        getContentPane().add(credito6, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 0, 0, 0));

        credito7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/creditos/6.png"))); // NOI18N
        getContentPane().add(credito7, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 340, 0, 0));

        credito8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/creditos/7.png"))); // NOI18N
        getContentPane().add(credito8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 0, 0));

        credito9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/creditos/8.png"))); // NOI18N
        getContentPane().add(credito9, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, 0, 0));

        credito10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/creditos/efectotitulo/0.png"))); // NOI18N
        getContentPane().add(credito10, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, -1, -1));

        pantallaNegra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/objetos/secuenciacierre/10.png"))); // NOI18N
        getContentPane().add(pantallaNegra, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        tiempo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/tiempo/dia1.png"))); // NOI18N
        getContentPane().add(tiempo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/escenarios/escenario1/v23.png"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Creditos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Creditos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Creditos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Creditos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Creditos().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel autor;
    private javax.swing.JLabel borde;
    private javax.swing.JLabel credito1;
    private javax.swing.JLabel credito10;
    private javax.swing.JLabel credito2;
    private javax.swing.JLabel credito3;
    private javax.swing.JLabel credito4;
    private javax.swing.JLabel credito5;
    private javax.swing.JLabel credito6;
    private javax.swing.JLabel credito7;
    private javax.swing.JLabel credito8;
    private javax.swing.JLabel credito9;
    private javax.swing.JLabel descripcionLabel;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel pantallaNegra;
    private javax.swing.JLabel tiempo;
    // End of variables declaration//GEN-END:variables

    
    class SecuenciaDescripcion extends Thread
    {
      @Override
      public void run()
      {
        try { Thread.sleep(6500); } catch (InterruptedException ex) {}
          
        descripcionLabel.setSize(descripcionLabel.getPreferredSize());  
        for(int i = 0; i<descripcion.length; i++)
        {
          descripcionLabel.setIcon(descripcion[i]); 
          try { Thread.sleep(180); } catch (InterruptedException ex) {}
        } 
        
        try { Thread.sleep(9000); } catch (InterruptedException ex) {}
        
        for(int i = descripcion.length-1; i>=0; i--)
        {
          descripcionLabel.setIcon(descripcion[i]); 
          try { Thread.sleep(180); } catch (InterruptedException ex) {}
        } 
        descripcionLabel.setSize(0,0);
        
        try { Thread.sleep(1200); } catch (InterruptedException ex) {}
        
        new SecuenciaFondo().start();
      }
    }
    
    class SecuenciaFondo extends Thread
    {
      @Override
      public void run()
      {
         Random randomGenerator = new Random();         
         int t;
         
         try {Thread.sleep(2000);} catch (InterruptedException ex) {}
         
         efectosCierre1();
         
         try {Thread.sleep(2000);} catch (InterruptedException ex) {}
         
         new SecuenciaCreditos().start();
         
         for(int i=0; i<5; i++)
         {         
           pos = randomGenerator.nextInt(17);
           t = randomGenerator.nextInt(3);  
           
           while(pos == filaAnterior)
           {
             pos = randomGenerator.nextInt(17);
           }
           filaAnterior = pos;
           
           try {Thread.sleep(12000);} catch (InterruptedException ex) {}           
           
           efectosCierre2();
           fondo.setIcon(fondos[pos]);
           tiempo.setIcon(tiemp[t]);
           if(tiempo.getIcon() == tiemp[0] && i==4){tiempo.setIcon(tiemp[1]);}
           efectosCierre1();
         }         
         
         try {Thread.sleep(7000);} catch (InterruptedException ex) {}
         
         efectosCierre2();
         
         try {Thread.sleep(4000);} catch (InterruptedException ex) {}
         autor.setSize(160,17);
         try {Thread.sleep(15000);} catch (InterruptedException ex) {}
                  
         setVisible(false);
         dispose();
         
         Sonidos.getInstance().detener("creditos");
         
         try 
         {
             if(!GestorJuego.getInstance().isSesionIniciada())
             {
                new TablaPuntaje2().setVisible(true);
             }
             else
             {
                new TablaPuntaje3().setVisible(true);
             }
         } catch (SQLException ex) { }         
      }      
      
      public void efectosCierre1()
      {
        for(int i = efectoCierre.length-1; i>=0; i--)
        {
          pantallaNegra.setIcon(efectoCierre[i]); 
          try { Thread.sleep(200); } catch (InterruptedException ex) {}
        }
      }
      
      public void efectosCierre2()
      {
        for(int i = 0; i<efectoCierre.length; i++)
        {
          pantallaNegra.setIcon(efectoCierre[i]); 
          try { Thread.sleep(200); } catch (InterruptedException ex) {}
        }
      }    
    }
    
    
    class SecuenciaCreditos extends Thread
    {
       @Override
       public void run()
       {
         int cont = 0;  
         for(int i=0; i<8; i++)
         {
            cont++;          
            
            cred[i].setSize(cred[i].getPreferredSize());
            
            try {Thread.sleep(3500);} catch (InterruptedException ex) {}
            
            cred[i].setSize(0,0);
            
            if(cont == 2){try {Thread.sleep(6200);} catch (InterruptedException ex) {} cont = 0;}
            else{try {Thread.sleep(3500);} catch (InterruptedException ex) {}}
         } 
         
         credito9.setSize(credito9.getPreferredSize());
            
         try {Thread.sleep(7000);} catch (InterruptedException ex) {}
            
         credito9.setSize(0,0);
         
         try {Thread.sleep(10000);} catch (InterruptedException ex) {}         
         
         efectoTitulo();
         
         try {Thread.sleep(16000);} catch (InterruptedException ex) {}
         
         efectoTitulo2();
         
       } 
       
        public void efectoTitulo()
        {
            for(int i = 0; i<titulo.length; i++)
            {
                credito10.setIcon(titulo[i]); 
                try { Thread.sleep(150); } catch (InterruptedException ex) {}
            }  
        }
       
        public void efectoTitulo2()
        {           
            for(int i = titulo.length-1; i>=0; i--)
            {
                credito10.setIcon(titulo[i]); 
                try { Thread.sleep(150); } catch (InterruptedException ex) {}
            }
            autor.setSize(0,0);
        }
    }
}