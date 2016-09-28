/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package izafiro;

import java.applet.AudioClip;
import java.awt.Point;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Jonathan
 */
public final class Puzzle7_1 extends javax.swing.JFrame {

    private Icon[] posiciones;
    private Icon[] posicionesSoldado;
    private Icon dano;
    private JTextField[] camposNumerador;
    private JTextField[] camposDenominador;
    private MovimientoSoldado[] ms;
    private boolean corriendo = false;
    private boolean cronometro;
    private boolean descubierto = false;
    private boolean poderMover = true;
    private int numerador;
    private int denominador;
    private int numeradorEquivalente;
    private int denominadorEquivalente;
    private int numeradorAnterior = 0;
    private int denominadorAnterior = 0;
    private int respCorrecta = -1;
    private int respCorrectaAnterior = -1;
    private int zonaActual = -1;
    
    AudioClip rio;
    
    //private static Puzzle7_1 p = null;
    
    
    /**
     * Creates new form Puzzle7
     */
    public Puzzle7_1() {
        initComponents();
        this.setLocationRelativeTo(null); this.setIconImage(new ImageIcon (getClass().getResource("izafiroicono.png")).getImage()); Sonidos.getInstance().activarCursor(this);
        
        String personaje = GestorJuego.getInstance().getGenero();
        dano = new ImageIcon (getClass().getResource("imagenes/personajes/tahi/"+personaje+"0.png"));
         
        posiciones = new Icon[5];
        posiciones[0] = new ImageIcon (getClass().getResource("imagenes/personajes/tahi/"+personaje+"2.png"));
        posiciones[1] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle2/"+personaje+"/1.gif"));
        posiciones[2] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle2/"+personaje+"/2.gif"));
        posiciones[3] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle2/"+personaje+"/3.gif"));
        posiciones[4] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle2/"+personaje+"/4.gif"));
        
        tahi.setIcon(posiciones[0]);         
        
        posicionesSoldado = new Icon[8];
        posicionesSoldado[0] = new ImageIcon (getClass().getResource("imagenes/personajes/soldado/soldado1.gif"));
        posicionesSoldado[1] = new ImageIcon (getClass().getResource("imagenes/personajes/soldado/soldado2.gif"));
        posicionesSoldado[2] = new ImageIcon (getClass().getResource("imagenes/personajes/soldado/soldado3.gif"));
        posicionesSoldado[3] = new ImageIcon (getClass().getResource("imagenes/personajes/soldado/soldado4.gif"));
        posicionesSoldado[4] = new ImageIcon (getClass().getResource("imagenes/personajes/soldado/detenido1.png"));
        posicionesSoldado[5] = new ImageIcon (getClass().getResource("imagenes/personajes/soldado/detenido2.png"));
        posicionesSoldado[6] = new ImageIcon (getClass().getResource("imagenes/personajes/soldado/detenido3.png"));
        posicionesSoldado[7] = new ImageIcon (getClass().getResource("imagenes/personajes/soldado/detenido4.png"));
        
        camposNumerador = new JTextField[3];
        camposNumerador[0] = numerador1;
        camposNumerador[1] = numerador2;
        camposNumerador[2] = numerador3;
        
        camposDenominador = new JTextField[3];
        camposDenominador[0] = denominador1;
        camposDenominador[1] = denominador2;
        camposDenominador[2] = denominador3;      
        
         
        ms = new MovimientoSoldado[3];  
        ms[0] = new MovimientoSoldado("horizontal",-40,280,soldado1);
        ms[1] = new MovimientoSoldado("horizontal",-40,280,soldado2);        
        ms[2] = new MovimientoSoldado("horizontal",-40,280,soldado3);       
        
        
        for (int i = 0; i < ms.length; i++) {ms[i].start();} 
        new Nivel().start();        
    }
    
    /*public static Puzzle7_1 getInstance()
    {
      if(p == null) { p = new Puzzle7_1(); }
      return p;
    }*/
    
    
    public boolean esRepetido(int[] vector, int numero) //dado un vector y un numero se determina si ese numero se encuentra en el vector
    { 
      for(int i=0; i<vector.length; i++)
      {
        if(vector[i] == numero){return true;} 
      }
      return false;
    }  
    
    public void generarFraccion1()
    {        
       Random randomGenerator = new Random();
                  
       denominador = randomGenerator.nextInt(7);
       
       while(denominador < 2)
       {
          denominador = randomGenerator.nextInt(7);
       }    
       denominadorAnterior = denominador;
       
       numerador = randomGenerator.nextInt(7);
       
       while(numerador == 0)
       {
         numerador = randomGenerator.nextInt(7);         
       } 
       numeradorAnterior = numerador;
       
       
       while(!generarFraccionEquivalente())
       {
          denominador = randomGenerator.nextInt(7); 
          while(denominador < 2)
          {
            denominador = randomGenerator.nextInt(7);
          }    
          denominadorAnterior = denominador;
       
          numerador = randomGenerator.nextInt(7);
          while(numerador == 0)
          {
            numerador = randomGenerator.nextInt(7);         
          } 
          numeradorAnterior = numerador; 
       }       
       
       campoNumerador.setText(numerador+"");
       campoDenominador.setText(denominador+""); 
       
       generarOpciones();
    }
    
    
    public boolean generarFraccionEquivalente()
    {
       Random randomGenerator = new Random();
       int con = 0;
       
       numeradorEquivalente = randomGenerator.nextInt(7);
       denominadorEquivalente = randomGenerator.nextInt(7);
       
       while( (numeradorEquivalente == 0 || denominadorEquivalente == 0) 
             || (numerador == numeradorEquivalente || denominador == denominadorEquivalente) 
             || (numerador * denominadorEquivalente != denominador * numeradorEquivalente) )
       {
         numeradorEquivalente = randomGenerator.nextInt(7);
         denominadorEquivalente = randomGenerator.nextInt(7); 
         con++;       
         
         if(con == 10)
         {
            return false; 
         }
       }
       return true;
    }
    
    
    public boolean esFraccionEq(int num, int den)
    {
       if((numerador * den) == (denominador * num))
       {
         return true;  
       }        
       return false; 
    }
    
    
    public void generarOpciones()
    {
        int numeradores[] = new int[3];
        int denominadores[] = new int[3];
        
        for (int i = 0; i < numeradores.length; i++) {numeradores[i] = -1;denominadores[i] = -1;} //Inicializo el vector en -1 para evitar problemas con el indice 0.
       
        Random randomGenerator = new Random(); 
           
        respCorrectaAnterior = respCorrecta;
        
        respCorrecta = randomGenerator.nextInt(numeradores.length);
        
        while(respCorrecta == respCorrectaAnterior)
        {
          respCorrecta = randomGenerator.nextInt(numeradores.length); 
        }      
        
        numeradores[respCorrecta] = numeradorEquivalente;
        denominadores[respCorrecta] = denominadorEquivalente;
        
        int den;
        int num;
        
        for(int i=0; i<numeradores.length; i++)
        {           
           if(numeradores[i] == -1)
           {                          
             den = randomGenerator.nextInt(7);
             while(den < 2)
             {
               den = randomGenerator.nextInt(7);   
             }
             num = randomGenerator.nextInt(7);  
             while( num == 0)
             {
               num = randomGenerator.nextInt(7); 
             }
             
             while(fraccionRepetida(num,den,numeradores,denominadores) || esFraccionEq(num,den))
             {
                den = randomGenerator.nextInt(7);
                while(den < 2)
                {
                  den = randomGenerator.nextInt(7);   
                }
                num = randomGenerator.nextInt(7);  
                while( num == 0)
                {
                  num = randomGenerator.nextInt(7); 
                } 
             } 
             numeradores[i] = num;
             denominadores[i] = den;
           }
        }
        
        for(int i=0; i<numeradores.length; i++)
        {
           camposNumerador[i].setText(numeradores[i]+""); 
           camposDenominador[i].setText(denominadores[i]+"");
        }
    }
    
    public boolean fraccionRepetida(int n1, int d1, int[]nums, int[]dens)
    {
        for(int i=0; i<nums.length; i++)
        { 
          if(n1 == nums[i] && d1 == dens[i])
          { 
            return true;  
          }
        }
        return false;
    }
    
    public void moverSoldados()
    {   
        poderMover = false;
        
        if(zonaActual == -1)
        {
           ms[0].setCorrer(true); ms[1].setCorrer(true); ms[2].setCorrer(true); 
           return; 
        }
        
        switch(respCorrecta)
        {
          case 0: ms[1].setCorrer(true); ms[2].setCorrer(true);
                  break;  
              
          case 1: ms[0].setCorrer(true); ms[2].setCorrer(true);
                  break; 
              
          case 2: ms[0].setCorrer(true); ms[1].setCorrer(true);
                  break; 
        }
    }
    
    
    public void desplazarPersonaje(int zona)
    {          
       if(!corriendo && poderMover)
       {
        zonaActual = 0;   
        new Movimiento(zona).start(); 
       }       
    }
    
    
    public void validarNumeros()
    {
       poderMover = true;
       if(!descubierto && zonaActual-1 == respCorrecta)
       {
          descubierto = true; 
          Sonidos.getInstance().reproducir("success2");
          JOptionPane.showMessageDialog(null, "BIEEEN!!!\nHaz logrado pasar sin ser visto!!"); 
          this.setVisible(false);
          this.dispose();
          try { Thread.sleep(1200); } catch (InterruptedException ex) {}
          Puzzle7_2.getInstance().setVisible(true); 
          Puzzle7_2.getInstance().comenzar();
          ms = null;
       }
       else{
          Sonidos.getInstance().reproducir("error");
          JOptionPane.showMessageDialog(null, "Vaya...  :( \nLos guardias te han atrapado!","Mensaje",0);
          this.setVisible(false);
          this.dispose();
          try { Thread.sleep(1200); } catch (InterruptedException ex) {}
          new Puzzle7_1().setVisible(true);
          ms = null;           
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

        campoNumerador = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        campoDenominador = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        reloj = new javax.swing.JTextField();
        objeto1 = new javax.swing.JLabel();
        objeto2 = new javax.swing.JLabel();
        objeto3 = new javax.swing.JLabel();
        soldado1 = new javax.swing.JLabel();
        soldado2 = new javax.swing.JLabel();
        soldado3 = new javax.swing.JLabel();
        tahi = new javax.swing.JLabel();
        f1 = new javax.swing.JLabel();
        f2 = new javax.swing.JLabel();
        f3 = new javax.swing.JLabel();
        numerador1 = new javax.swing.JTextField();
        numerador2 = new javax.swing.JTextField();
        numerador3 = new javax.swing.JTextField();
        denominador1 = new javax.swing.JTextField();
        denominador2 = new javax.swing.JTextField();
        denominador3 = new javax.swing.JTextField();
        raya1 = new javax.swing.JLabel();
        raya2 = new javax.swing.JLabel();
        raya3 = new javax.swing.JLabel();
        SalirBtn = new javax.swing.JToggleButton();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("iZafiro - Jardín de Las Fuentes");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        campoNumerador.setEditable(false);
        campoNumerador.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        campoNumerador.setForeground(new java.awt.Color(0, 102, 0));
        campoNumerador.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(campoNumerador, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 10, 40, 33));

        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 153), 3));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(635, 48, 50, -1));

        campoDenominador.setEditable(false);
        campoDenominador.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        campoDenominador.setForeground(new java.awt.Color(0, 102, 0));
        campoDenominador.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(campoDenominador, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 60, 40, 33));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Denominador");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 60, 100, 20));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Numerador");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 10, 90, 20));

        reloj.setEditable(false);
        reloj.setBackground(new java.awt.Color(0, 0, 0));
        reloj.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        reloj.setForeground(new java.awt.Color(255, 0, 0));
        reloj.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        reloj.setText("0");
        getContentPane().add(reloj, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 40));

        objeto1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/objetos/arbol1.png"))); // NOI18N
        getContentPane().add(objeto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 333, -1, -1));

        objeto2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/objetos/arbol1.png"))); // NOI18N
        getContentPane().add(objeto2, new org.netbeans.lib.awtextra.AbsoluteConstraints(209, 333, -1, -1));

        objeto3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/objetos/arbol1.png"))); // NOI18N
        getContentPane().add(objeto3, new org.netbeans.lib.awtextra.AbsoluteConstraints(369, 333, -1, -1));

        soldado1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/personajes/soldado/detenido2.png"))); // NOI18N
        getContentPane().add(soldado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-50, 170, -1, -1));

        soldado2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/personajes/soldado/detenido4.png"))); // NOI18N
        getContentPane().add(soldado2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-50, 240, -1, -1));

        soldado3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/personajes/soldado/detenido1.png"))); // NOI18N
        getContentPane().add(soldado3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-50, 320, -1, -1));

        tahi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/personajes/tahi/tahi5.png"))); // NOI18N
        getContentPane().add(tahi, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 240, -1, -1));

        f1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        f1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f1MouseClicked(evt);
            }
        });
        getContentPane().add(f1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 130, 50, 80));

        f2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        f2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f2MouseClicked(evt);
            }
        });
        getContentPane().add(f2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 220, 50, 80));

        f3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        f3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f3MouseClicked(evt);
            }
        });
        getContentPane().add(f3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 320, 50, 80));

        numerador1.setEditable(false);
        numerador1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        numerador1.setForeground(new java.awt.Color(204, 0, 0));
        numerador1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        numerador1.setBorder(null);
        getContentPane().add(numerador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 140, 30, 30));

        numerador2.setEditable(false);
        numerador2.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        numerador2.setForeground(new java.awt.Color(204, 0, 0));
        numerador2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        numerador2.setBorder(null);
        getContentPane().add(numerador2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 230, 30, 30));

        numerador3.setEditable(false);
        numerador3.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        numerador3.setForeground(new java.awt.Color(204, 0, 0));
        numerador3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        numerador3.setBorder(null);
        getContentPane().add(numerador3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 330, 30, 30));

        denominador1.setEditable(false);
        denominador1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        denominador1.setForeground(new java.awt.Color(204, 0, 0));
        denominador1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        denominador1.setBorder(null);
        getContentPane().add(denominador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 180, 30, 30));

        denominador2.setEditable(false);
        denominador2.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        denominador2.setForeground(new java.awt.Color(204, 0, 0));
        denominador2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        denominador2.setBorder(null);
        getContentPane().add(denominador2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 270, 30, 30));

        denominador3.setEditable(false);
        denominador3.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        denominador3.setForeground(new java.awt.Color(204, 0, 0));
        denominador3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        denominador3.setBorder(null);
        getContentPane().add(denominador3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 370, 30, 30));

        raya1.setBackground(new java.awt.Color(0, 0, 204));
        raya1.setOpaque(true);
        getContentPane().add(raya1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 170, 30, 5));

        raya2.setBackground(new java.awt.Color(0, 0, 204));
        raya2.setOpaque(true);
        getContentPane().add(raya2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 260, 30, 5));

        raya3.setBackground(new java.awt.Color(0, 0, 204));
        raya3.setOpaque(true);
        getContentPane().add(raya3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 360, 30, 5));

        SalirBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        SalirBtn.setForeground(new java.awt.Color(0, 102, 0));
        SalirBtn.setText("Salir");
        SalirBtn.setPreferredSize(new java.awt.Dimension(110, 23));
        SalirBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirBtnActionPerformed(evt);
            }
        });
        getContentPane().add(SalirBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 450, 110, -1));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/puzzle/puzzle7/7-1.png"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void f1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f1MouseClicked
        // TODO add your handling code here:
        desplazarPersonaje(1);
    }//GEN-LAST:event_f1MouseClicked

    private void f2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f2MouseClicked
        // TODO add your handling code here:
        desplazarPersonaje(2);
    }//GEN-LAST:event_f2MouseClicked

    private void f3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f3MouseClicked
        // TODO add your handling code here:
        desplazarPersonaje(3);
    }//GEN-LAST:event_f3MouseClicked

    private void SalirBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirBtnActionPerformed
        // TODO add your handling code here:
        
        if(JOptionPane.showConfirmDialog(null, "¿Seguro que deseas salir del Juego?\nAún no has conseguido la Gema Azul.", "Seleccionar una Opción", JOptionPane.YES_NO_OPTION) == 0)
        {
            AdministradorConsultasSQL ad = new AdministradorConsultasSQL();  
            ad.guardarPartida();
            
            this.setVisible(false);
            this.dispose();

            System.exit(0);
        }
    }//GEN-LAST:event_SalirBtnActionPerformed

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
            java.util.logging.Logger.getLogger(Puzzle7_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Puzzle7_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Puzzle7_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Puzzle7_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Puzzle7_1().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton SalirBtn;
    private javax.swing.JTextField campoDenominador;
    private javax.swing.JTextField campoNumerador;
    private javax.swing.JTextField denominador1;
    private javax.swing.JTextField denominador2;
    private javax.swing.JTextField denominador3;
    private javax.swing.JLabel f1;
    private javax.swing.JLabel f2;
    private javax.swing.JLabel f3;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField numerador1;
    private javax.swing.JTextField numerador2;
    private javax.swing.JTextField numerador3;
    private javax.swing.JLabel objeto1;
    private javax.swing.JLabel objeto2;
    private javax.swing.JLabel objeto3;
    private javax.swing.JLabel raya1;
    private javax.swing.JLabel raya2;
    private javax.swing.JLabel raya3;
    private javax.swing.JTextField reloj;
    private javax.swing.JLabel soldado1;
    private javax.swing.JLabel soldado2;
    private javax.swing.JLabel soldado3;
    private javax.swing.JLabel tahi;
    // End of variables declaration//GEN-END:variables

    public class Cronometro extends Thread
    {  
       @Override
       public void run()
       {
         for(int i=15; i>=0; i--)
         { 
           if(descubierto){cronometro = true;return;} //Cuando un guardia descubre al personaje
           if(zonaActual != -1){return;} //Cuando el usuario ya tomó una desicion
           try { Thread.sleep(500); } catch (InterruptedException ex) {}           
           if(descubierto){cronometro = true;return;} //Cuando un guardia descubre al personaje
           if(zonaActual != -1){return;} //Cuando el usuario ya tomó una desicion
           try { Thread.sleep(500); } catch (InterruptedException ex) {}
           reloj.setText(i+"");
         }
         cronometro = true;
         if(zonaActual == -1){new Movimiento(2).start();}
       } 
    }
    
    public class Nivel extends Thread
    {
       @Override
       public void run()
       {
         cronometro = false;
         
         try { Thread.sleep(1200); } catch (InterruptedException ex) {}
         
         JOptionPane.showMessageDialog(null, "Ve por el camino de la Fracción equivalente del fraccionario que ves\nen la parte superior derecha ... ");  
         
         JOptionPane.showMessageDialog(null, "Haz doble click sobre la fracción que creas que sea la equivalente.");
         
         generarFraccion1();
           
         new Cronometro().start();           
         while(!cronometro){try {Thread.sleep(100);} catch (InterruptedException ex) {}}           
         cronometro = false;          
         
         if(!descubierto){moverSoldados();}  
       }
    }
    
    
    public class Movimiento extends Thread
    {
       private int zona;
       
       public Movimiento(int zona)
       {
         this.zona = zona;  
       }
       
       @Override
       public void run()
       {               
          int zonaAnt = zonaActual;
          zonaActual = -1;
          zonaActual = this.zona;
          corriendo = true; 
          tahi.setIcon(posiciones[0]); 
          
          cronometro = true;
          
          switch(zona)
          {              
            case 1: zona1(zonaAnt); break;
            case 2: zona2(zonaAnt); break;
            case 3: zona3(zonaAnt); break;
          }          
          validarNumeros();
          corriendo = false;
       }
       
       public void moverIzquierda(int limite)
       {
          tahi.setIcon(posiciones[2]);    
          while(tahi.getX() > limite && !descubierto)
          { 
            if(tahi.getIcon() != dano)
            {   
              tahi.setLocation(tahi.getX()-3,tahi.getY());
              try {
               Thread.sleep(20);
              } catch (InterruptedException ex) {}     
            } 
          }
       }
       
       public void moverDerecha(int limite)
       {
          tahi.setIcon(posiciones[3]);    
          while(tahi.getX() < limite)
          {
            if(tahi.getIcon() != dano)
            {          
              tahi.setLocation(tahi.getX()+3,tahi.getY());
              try {
                Thread.sleep(20);
              } catch (InterruptedException ex) {}             
            }
          } 
       }
       
       public void moverArriba(int limite)
       {
          tahi.setIcon(posiciones[4]);
          zonaActual = this.zona;
         
          while(tahi.getY() > limite)
          { 
            if(tahi.getIcon() != dano)
            { 
              tahi.setLocation(tahi.getX(),tahi.getY()-3);
              try {
               Thread.sleep(20);
              } catch (InterruptedException ex) {} 
            }
          }
       } 
       
       
       public void moverAbajo(int limite)
       {
          tahi.setIcon(posiciones[1]); 
          while(tahi.getY() < limite)
          {
            if(tahi.getIcon() != dano)
            {   
              tahi.setLocation(tahi.getX(),tahi.getY()+3);
              try {
               Thread.sleep(20);
              } catch (InterruptedException ex) {}            
            }
          } 
       }
       
       public void zona1(int zonaAnt)
       {
         moverIzquierda(390); 
         moverArriba(170);
         moverIzquierda(-40);
       }
       
       public void zona2(int zonaAnt)
       {
         moverIzquierda(390);
         moverIzquierda(-40);
       }
       
       public void zona3(int zonaAnt)
       { 
         moverIzquierda(390);        
         moverAbajo(320);
         moverIzquierda(-40);
       }
    }
    
    
    
    public class MovimientoSoldado extends Thread
    {
       private String sentido; 
       private int limite1;
       private int limite2;
       private int speed;
       private int intervalo;
       private JLabel imagen;
       private boolean correr;
       private boolean yaDescubrio;
       
       public MovimientoSoldado(String s,int l1,int l2,JLabel jl)
       {
         this.sentido = s;  
         this.imagen = jl;
         this.limite1 = l1;
         this.limite2 = l2;
         this.speed = 2;
         this.intervalo = 20;
         this.correr = false;        
       }
       
       @Override
       public void run()
       {        
         while(!this.correr){try { Thread.sleep(1500); } catch (InterruptedException ex) {} }
         this.correr = false;
         
         if(sentido.equals("horizontal"))
         {
            if(imagen.getX() == limite2)
            {
               moverIzquierda(limite1);
               imagen.setIcon(posicionesSoldado[5]);
            }else{ 
               moverDerecha(limite2);
               imagen.setIcon(posicionesSoldado[6]); 
            }
         }
         else
         {
            if(imagen.getY() == limite2)
            { 
               moverArriba(limite1);
               imagen.setIcon(posicionesSoldado[7]);
            }else{
               moverAbajo(limite2);
               imagen.setIcon(posicionesSoldado[4]);
            }
         } 
       }
       
       public void moverAbajo(int limite)
        {
           imagen.setIcon(posicionesSoldado[0]); 
           while(imagen.getY() < limite)
           {   
             imagen.setLocation(imagen.getX(),imagen.getY()+speed);
             try { Thread.sleep(intervalo); } catch (InterruptedException ex) {}
             if(Desplazamiento.getInstance().contiene(imagen,tahi.getLocation())
                || Desplazamiento.getInstance().contiene(imagen,new Point(tahi.getLocation().x+tahi.getWidth(),tahi.getLocation().y+tahi.getHeight()))) //pregunta si ve al personaje abajo
             {
               descubrir();          
             }
           } 
        }
       
        public void moverIzquierda(int limite)
        {
           imagen.setIcon(posicionesSoldado[1]);    
           while(imagen.getX() > limite)
           {  
             imagen.setLocation(imagen.getX()-speed,imagen.getY());
             try { Thread.sleep(intervalo); } catch (InterruptedException ex) {} 
             if(Desplazamiento.getInstance().contiene(imagen,tahi.getLocation())
                || Desplazamiento.getInstance().contiene(imagen,new Point(tahi.getLocation().x+tahi.getWidth(),tahi.getLocation().y+tahi.getHeight()))) //pregunta si ve al personaje abajo
             {
               descubrir();          
             }
           }
        }

        public void moverDerecha(int limite)
        {
           imagen.setIcon(posicionesSoldado[2]);    
           while(imagen.getX() < limite)
           {        
             imagen.setLocation(imagen.getX()+speed,imagen.getY());
             try { Thread.sleep(intervalo); } catch (InterruptedException ex) {}    
             if(Desplazamiento.getInstance().contiene(imagen,tahi.getLocation())
                || Desplazamiento.getInstance().contiene(imagen,new Point(tahi.getLocation().x+tahi.getWidth(),tahi.getLocation().y+tahi.getHeight()))) //pregunta si ve al personaje abajo
             { 
               descubrir();       
               return;
             }
           } 
        }

        public void moverArriba(int limite)
        {
           imagen.setIcon(posicionesSoldado[3]);

           while(imagen.getY() > limite)
           { 
             imagen.setLocation(imagen.getX(),imagen.getY()-speed);
             try { Thread.sleep(intervalo); } catch (InterruptedException ex) {}
             if(Desplazamiento.getInstance().contiene(imagen,tahi.getLocation())
                || Desplazamiento.getInstance().contiene(imagen,new Point(tahi.getLocation().x+tahi.getWidth(),tahi.getLocation().y+tahi.getHeight()))) //pregunta si ve al personaje abajo
             {
               descubrir();          
             }
           }
        }
        
        
        public void descubrir()
        {
           if(!yaDescubrio)
           { 
             Sonidos.getInstance().reproducir("dano");  
             
             tahi.setIcon(dano);
           
             yaDescubrio = true; // variable local (del soldado)
             descubierto = true; // variable global (para el puntaje)
           }
        }
        
        
        public void setCorrer(boolean c)
        {
           this.correr = c; 
        }
    }
}
