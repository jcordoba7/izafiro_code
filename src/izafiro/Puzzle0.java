/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package izafiro;

import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Jonathan
 */
public class Puzzle0 extends javax.swing.JFrame {

    private JLabel[] cuadros;
    private int[] secuencia;
    private Icon[] cuadrosNormal;
    private Icon[] cuadrosOver;
    private boolean habilitado = false;
    private boolean correcto = true;
    private int ordenSecuencia;
    private JLabel cerca;
    private JLabel obstaculo; 
    private SenalVentana sv;
    private Deposito d;
    
    private Obstaculo oAbajo;
    private Obstaculo oIzquierda;
    private Obstaculo oDerecha;
    private Obstaculo oArriba;
    
    /** 
     * Creates new form Puzzle0
     */
    public Puzzle0(int longSecuencia,SenalVentana sv,JLabel cerca,JLabel obstaculo,Obstaculo oAb,Obstaculo oIz,Obstaculo oDe,Obstaculo oAr,Deposito d) {
        
        initComponents();
        this.setLocationRelativeTo(null); this.setIconImage(new ImageIcon (getClass().getResource("izafiroicono.png")).getImage()); Sonidos.getInstance().activarCursor(this);
        
        this.d = d;
        this.sv = sv;
        this.cerca = cerca;
        this.obstaculo = obstaculo;
        this.oAbajo = oAb;
        this.oIzquierda = oIz;
        this.oDerecha = oDe;
        this.oArriba = oAr;
        
        this.cuadros = new JLabel[4];
        this.cuadros[0] = cuadro1;
        this.cuadros[1] = cuadro2;
        this.cuadros[2] = cuadro3;
        this.cuadros[3] = cuadro4;        
        
        this.cuadrosNormal = new Icon[4];
        this.cuadrosNormal[0] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle0/cuadro1.png"));
        this.cuadrosNormal[1] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle0/cuadro2.png"));
        this.cuadrosNormal[2] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle0/cuadro3.png"));
        this.cuadrosNormal[3] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle0/cuadro4.png"));
        
        this.cuadrosOver = new Icon[4];
        this.cuadrosOver[0] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle0/cuadro1over.png"));
        this.cuadrosOver[1] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle0/cuadro2over.png"));
        this.cuadrosOver[2] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle0/cuadro3over.png"));
        this.cuadrosOver[3] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle0/cuadro4over.png"));
        
        this.secuencia = new int[longSecuencia];
        
        for (int i = 0; i < secuencia.length ; i++) { secuencia[i] = -1; }
        
        new Nivel(longSecuencia).start();
    }
    
    
    
     public Puzzle0() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon (getClass().getResource("izafiroicono.png")).getImage()); Sonidos.getInstance().activarCursor(this);
        
        int longSecuencia = 6;
        
        this.cuadros = new JLabel[4];
        this.cuadros[0] = cuadro1;
        this.cuadros[1] = cuadro2;
        this.cuadros[2] = cuadro3;
        this.cuadros[3] = cuadro4;        
        
        this.cuadrosNormal = new Icon[4];
        this.cuadrosNormal[0] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle0/cuadro1.png"));
        this.cuadrosNormal[1] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle0/cuadro2.png"));
        this.cuadrosNormal[2] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle0/cuadro3.png"));
        this.cuadrosNormal[3] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle0/cuadro4.png"));
        
        this.cuadrosOver = new Icon[4];
        this.cuadrosOver[0] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle0/cuadro1over.png"));
        this.cuadrosOver[1] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle0/cuadro2over.png"));
        this.cuadrosOver[2] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle0/cuadro3over.png"));
        this.cuadrosOver[3] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle0/cuadro4over.png"));
        
        this.secuencia = new int[longSecuencia];
        
        for (int i = 0; i < secuencia.length ; i++) { secuencia[i] = -1; }
        
        new Nivel(longSecuencia).start();
    }
    
    public void crearSecuencia(int pos)
    {
        Random randomGenerator = new Random();
                  
        secuencia[pos] = randomGenerator.nextInt(4);
    }
    
    public void validarSecuencia(int cuadro)
    {
        if(secuencia[ordenSecuencia] != cuadro)
        {
          mostrarError("Vaya ...\nTe has equivocado ...");
        }
        else if(ordenSecuencia+1 == secuencia.length && correcto)
        {
          Sonidos.getInstance().reproducir("success1");
          ordenSecuencia++;
          /*
          setAlwaysOnTop(false);
          
          if(GestorJuego.getInstance().getGenero().equals("tahi"))
          { 
            JOptionPane.showMessageDialog(null, "Bien, lo haz logrado!!\nQue listo! ...");
          }
          else
          {
            JOptionPane.showMessageDialog(null, "Bien, lo haz logrado!!\nQue lista! ...");  
          }
          
          setAlwaysOnTop(true);
          */
          Obstaculo o = new Obstaculo();
          o.quitarObstaculo(obstaculo, oArriba, oAbajo, oDerecha, oIzquierda, GestorJuego.getInstance().getSpeed());
          cerca.setSize(0,0);
          sv.i = 1;
          d.setVentanaAbierta(false);
          this.setVisible(false);
          this.dispose();
        }
    }
    
    public void mostrarError(String mensaje)
    {
        Sonidos.getInstance().reproducir("error");
        correcto = false;
        setAlwaysOnTop(false);
        JOptionPane.showMessageDialog(null, mensaje, "Error", 0);
        setAlwaysOnTop(true);
        d.setVentanaAbierta(false);
        this.setVisible(false);
        this.dispose();
    }
    
    public void imprimirSecuencia()
    {
        for (int i = 0; i < secuencia.length ; i++) 
        { 
          if(secuencia[i] != -1)
          {
            System.out.print(secuencia[i]);  
          }
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

        cuadro1 = new javax.swing.JLabel();
        cuadro2 = new javax.swing.JLabel();
        cuadro4 = new javax.swing.JLabel();
        cuadro3 = new javax.swing.JLabel();
        reloj = new javax.swing.JTextField();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("iZafiro - \"Simón Dice\"");
        setAlwaysOnTop(true);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cuadro1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/puzzle/puzzle0/cuadro1.png"))); // NOI18N
        cuadro1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cuadro1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cuadro1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cuadro1MouseReleased(evt);
            }
        });
        getContentPane().add(cuadro1, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 58, -1, -1));

        cuadro2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/puzzle/puzzle0/cuadro2.png"))); // NOI18N
        cuadro2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cuadro2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cuadro2MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cuadro2MouseReleased(evt);
            }
        });
        getContentPane().add(cuadro2, new org.netbeans.lib.awtextra.AbsoluteConstraints(262, 58, -1, -1));

        cuadro4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/puzzle/puzzle0/cuadro4.png"))); // NOI18N
        cuadro4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cuadro4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cuadro4MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cuadro4MouseReleased(evt);
            }
        });
        getContentPane().add(cuadro4, new org.netbeans.lib.awtextra.AbsoluteConstraints(262, 181, -1, -1));

        cuadro3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/puzzle/puzzle0/cuadro3.png"))); // NOI18N
        cuadro3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cuadro3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cuadro3MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cuadro3MouseReleased(evt);
            }
        });
        getContentPane().add(cuadro3, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 181, -1, -1));

        reloj.setEditable(false);
        reloj.setBackground(new java.awt.Color(0, 0, 0));
        reloj.setFont(new java.awt.Font("Arial", 1, 40)); // NOI18N
        reloj.setForeground(new java.awt.Color(255, 0, 0));
        reloj.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        reloj.setText("0");
        getContentPane().add(reloj, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 70, 60));

        fondo.setBackground(new java.awt.Color(0, 0, 0));
        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/puzzle/puzzle0/fondo.png"))); // NOI18N
        fondo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 4));
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cuadro1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cuadro1MousePressed
        // TODO add your handling code here:
        if(!habilitado){return;}
        Sonidos.getInstance().reproducir("abrirpuerta");
        cuadros[0].setIcon(cuadrosOver[0]);
        validarSecuencia(0);
        ordenSecuencia++;
    }//GEN-LAST:event_cuadro1MousePressed

    private void cuadro2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cuadro2MousePressed
        // TODO add your handling code here:
        if(!habilitado){return;}
        Sonidos.getInstance().reproducir("abrirpuerta");
        cuadros[1].setIcon(cuadrosOver[1]);
        validarSecuencia(1);
        ordenSecuencia++;
    }//GEN-LAST:event_cuadro2MousePressed

    private void cuadro3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cuadro3MousePressed
        // TODO add your handling code here:
        if(!habilitado){return;}
        Sonidos.getInstance().reproducir("abrirpuerta");
        cuadros[2].setIcon(cuadrosOver[2]);
        validarSecuencia(2);
        ordenSecuencia++;
    }//GEN-LAST:event_cuadro3MousePressed

    private void cuadro4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cuadro4MousePressed
        // TODO add your handling code here:
        if(!habilitado){return;}
        Sonidos.getInstance().reproducir("abrirpuerta");
        cuadros[3].setIcon(cuadrosOver[3]);
        validarSecuencia(3);
        ordenSecuencia++;
    }//GEN-LAST:event_cuadro4MousePressed

    private void cuadro1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cuadro1MouseReleased
        // TODO add your handling code here:
         cuadros[0].setIcon(cuadrosNormal[0]);
    }//GEN-LAST:event_cuadro1MouseReleased

    private void cuadro2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cuadro2MouseReleased
        // TODO add your handling code here:
        cuadros[1].setIcon(cuadrosNormal[1]);
    }//GEN-LAST:event_cuadro2MouseReleased

    private void cuadro3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cuadro3MouseReleased
        // TODO add your handling code here:
        cuadros[2].setIcon(cuadrosNormal[2]);
    }//GEN-LAST:event_cuadro3MouseReleased

    private void cuadro4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cuadro4MouseReleased
        // TODO add your handling code here:
        cuadros[3].setIcon(cuadrosNormal[3]);
    }//GEN-LAST:event_cuadro4MouseReleased

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
            java.util.logging.Logger.getLogger(Puzzle0.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Puzzle0.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Puzzle0.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Puzzle0.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run(int longSecuencia,SenalVentana sv, JLabel cerca, JLabel obstaculo,Obstaculo oAb,Obstaculo oIz,Obstaculo oDe,Obstaculo oAr,Deposito d) {
                new Puzzle0(longSecuencia,sv,cerca,obstaculo,oAb,oIz,oDe,oAr,d).setVisible(true);
            }

            @Override
            public void run() {
                new Puzzle0().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cuadro1;
    private javax.swing.JLabel cuadro2;
    private javax.swing.JLabel cuadro3;
    private javax.swing.JLabel cuadro4;
    private javax.swing.JLabel fondo;
    private javax.swing.JTextField reloj;
    // End of variables declaration//GEN-END:variables

     public class Nivel extends Thread
    {
       private int tamSecuencia;
        
       public Nivel(int ts)
       {
         this.tamSecuencia = ts;  
       }
       
       @Override
       public void run()
       {
          setAlwaysOnTop(false);
          
          JOptionPane.showMessageDialog(null, "Repite las Secuencias que verás a continuación,\nsólo así lograrás pasar ...");           
          JOptionPane.showMessageDialog(null, "Haz click sobre los cuadros que se iluminan en el mismo orden ...");   
          
          setAlwaysOnTop(true);
          
          try {sleep(1000);} catch (InterruptedException ex) {}
          
          int pos = 0;
          
          for (int i = 0; i < this.tamSecuencia; i++) 
          {
             crearSecuencia(pos);
             mostrarSecuencia(pos+1);
             cronometro(pos+1);
             if(!correcto){break;}
             try {sleep(1000);} catch (InterruptedException ex) {}
             pos++;
          }        
       }
       
       public void mostrarSecuencia(int pos)
       {
          for (int i = 0; i < pos ; i++) 
          {
             Sonidos.getInstance().reproducir("abrirpuerta"); 
             cuadros[secuencia[i]].setIcon(cuadrosOver[secuencia[i]]);
             try {sleep(400);} catch (InterruptedException ex) {}
             cuadros[secuencia[i]].setIcon(cuadrosNormal[secuencia[i]]);
             try {sleep(400);} catch (InterruptedException ex) {}
          } 
       }
       
       public void cronometro(int limite)
       {
          habilitado = true; 
          ordenSecuencia = 0;
          for(int i=limite; i>=0; i--)
          {  
            reloj.setText(i+"");  
            try { Thread.sleep(500); } catch (InterruptedException ex) {}
            if(!correcto){return;}
            try { Thread.sleep(400); } catch (InterruptedException ex) {}
          }  
          if(ordenSecuencia < limite){correcto = false;mostrarError("Vaya ...\nTe demoraste demasiado ...");}
          habilitado = false;          
       }
     }

}
