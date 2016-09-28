/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package izafiro;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Jacc89
 */
public final class Ventana27_s1 extends javax.swing.JFrame {

    String clip1;
    
    //Variables del cambio de Ventana
    private JFrame[][] vJF;
    private int numVentanaFila ;
    private int numVentanaColm;
    
    // Variables del Movimiento
    private static final int SPEED = GestorJuego.getInstance().getSpeed(); //Velocidad de Tahi
    private static final int FRECUENCIA = GestorJuego.getInstance().getFrecuencia(); //Frecuencia del movimiento de pies de Tahi
    private static final int RADIO = 15; //Distancia para conversar con otros personajes
    private Desplazamiento desplazamiento = Desplazamiento.getInstance(); //Invocador de metodos relacionados con el desplazamiento
    private Deposito d; //Clase deposito que guerada las variables primitivas del JFrame
    
    //Variables de Interaccion con el escenario (obstaculos y conversaciones)
    private ArrayList<Conversador> conversadores;
    private ArrayList<JLabel> obstaculos;
    private Obstaculo obstaculosAbajo;
    private Obstaculo obstaculosIzquierda;
    private Obstaculo obstaculosDerecha;
    private Obstaculo obstaculosArriba;
    private ArrayList<Enemigo> enemigos;
    
    //Variable sobre el estado de Tahi
    GestorJuego t = GestorJuego.getInstance();
    
    
    /**
     * Creates new form Ventana00_s1
     */
    public Ventana27_s1() {
        initComponents();
        this.setLocationRelativeTo(null); this.setIconImage(new ImageIcon (getClass().getResource("izafiroicono.png")).getImage()); Sonidos.getInstance().activarCursor(this);
        this.d = new Deposito(tahi.getX(),tahi.getY(),this);
        cargarObstaculos();
        cargarPersonajes();
        this.addKeyListener(Teclado.getInstace());//ActionListener para deneter la musica de fodndo 
        this.addKeyListener(new Ventana27_s1.AL());//ActionListener para el movimiento del personaje   
        
        clip1 = "rio";
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        numPuntaje1 = new javax.swing.JLabel();
        numPuntaje2 = new javax.swing.JLabel();
        numPuntaje3 = new javax.swing.JLabel();
        numPuntaje4 = new javax.swing.JLabel();
        marcoPuntaje = new javax.swing.JLabel();
        pausa = new javax.swing.JLabel();
        sound = new javax.swing.JLabel();
        ayuda = new javax.swing.JLabel();
        puntaje = new javax.swing.JLabel();
        titulo = new javax.swing.JLabel();
        recurso1 = new javax.swing.JLabel();
        recurso2 = new javax.swing.JLabel();
        recurso3 = new javax.swing.JLabel();
        recurso4 = new javax.swing.JLabel();
        recurso5 = new javax.swing.JLabel();
        recurso6 = new javax.swing.JLabel();
        recursos = new javax.swing.JLabel();
        energia = new javax.swing.JLabel();
        salud = new javax.swing.JLabel();
        n1 = new javax.swing.JLabel();
        n2 = new javax.swing.JLabel();
        n3 = new javax.swing.JLabel();
        n4 = new javax.swing.JLabel();
        hora = new javax.swing.JLabel();
        barra = new javax.swing.JLabel();
        cuadroDialogo = new javax.swing.JLabel();
        tiempo = new javax.swing.JLabel();
        roca3 = new javax.swing.JLabel();
        roca4 = new javax.swing.JLabel();
        roca1 = new javax.swing.JLabel();
        roca2 = new javax.swing.JLabel();
        cascada = new javax.swing.JLabel();
        cascada2 = new javax.swing.JLabel();
        cascada4 = new javax.swing.JLabel();
        cascada3 = new javax.swing.JLabel();
        espadazo = new javax.swing.JLabel();
        tahi = new javax.swing.JLabel();
        obstaculo1 = new javax.swing.JLabel();
        obstaculo2 = new javax.swing.JLabel();
        obstaculo3 = new javax.swing.JLabel();
        obstaculo4 = new javax.swing.JLabel();
        obstaculo5 = new javax.swing.JLabel();
        obstaculo6 = new javax.swing.JLabel();
        obstaculo7 = new javax.swing.JLabel();
        obstaculo8 = new javax.swing.JLabel();
        obstaculo9 = new javax.swing.JLabel();
        obstaculo10 = new javax.swing.JLabel();
        obstaculo11 = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("iZafiro - Bosque de las Luciérnagas");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        numPuntaje1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        numPuntaje1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/barra/numerospuntaje/0.png"))); // NOI18N
        getContentPane().add(numPuntaje1, new org.netbeans.lib.awtextra.AbsoluteConstraints(388, 35, 14, 29));
        numPuntaje1.getAccessibleContext().setAccessibleName("numPuntaje1");

        numPuntaje2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        numPuntaje2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/barra/numerospuntaje/0.png"))); // NOI18N
        getContentPane().add(numPuntaje2, new org.netbeans.lib.awtextra.AbsoluteConstraints(403, 35, 14, 29));
        numPuntaje2.getAccessibleContext().setAccessibleName("numPuntaje2");

        numPuntaje3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        numPuntaje3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/barra/numerospuntaje/0.png"))); // NOI18N
        getContentPane().add(numPuntaje3, new org.netbeans.lib.awtextra.AbsoluteConstraints(418, 35, 14, 29));
        numPuntaje3.getAccessibleContext().setAccessibleName("numPuntaje3");

        numPuntaje4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        numPuntaje4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/barra/numerospuntaje/0.png"))); // NOI18N
        getContentPane().add(numPuntaje4, new org.netbeans.lib.awtextra.AbsoluteConstraints(433, 35, 14, 29));
        numPuntaje4.getAccessibleContext().setAccessibleName("numPuntaje4");

        marcoPuntaje.setBackground(new java.awt.Color(239, 255, 239));
        marcoPuntaje.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        marcoPuntaje.setOpaque(true);
        getContentPane().add(marcoPuntaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(382, 30, 70, 35));

        pausa.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        pausa.setForeground(new java.awt.Color(255, 255, 255));
        pausa.setText("Pausa: Tecla P");
        getContentPane().add(pausa, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 10, -1, -1));

        sound.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        sound.setForeground(new java.awt.Color(255, 255, 255));
        sound.setText("On/Off Música: Tecla S");
        getContentPane().add(sound, new org.netbeans.lib.awtextra.AbsoluteConstraints(615, 30, -1, -1));

        ayuda.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        ayuda.setForeground(new java.awt.Color(255, 255, 255));
        ayuda.setText("Ayuda: Tecla A");
        getContentPane().add(ayuda, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 50, -1, -1));

        puntaje.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        puntaje.setForeground(new java.awt.Color(255, 255, 255));
        puntaje.setText("Puntaje");
        getContentPane().add(puntaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, -1, -1));

        titulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/izafitotittlepequeno.png"))); // NOI18N
        getContentPane().add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        recurso1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/barra/recursos/recurso0.png"))); // NOI18N
        getContentPane().add(recurso1, new org.netbeans.lib.awtextra.AbsoluteConstraints(601, 515, 28, 28));
        recurso1.getAccessibleContext().setAccessibleName("recurso1");

        recurso2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/barra/recursos/recurso0.png"))); // NOI18N
        getContentPane().add(recurso2, new org.netbeans.lib.awtextra.AbsoluteConstraints(646, 515, 28, 28));
        recurso2.getAccessibleContext().setAccessibleName("recurso2");

        recurso3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/barra/recursos/recurso0.png"))); // NOI18N
        getContentPane().add(recurso3, new org.netbeans.lib.awtextra.AbsoluteConstraints(691, 515, 28, 28));
        recurso3.getAccessibleContext().setAccessibleName("recurso3");

        recurso4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/barra/recursos/recurso0.png"))); // NOI18N
        getContentPane().add(recurso4, new org.netbeans.lib.awtextra.AbsoluteConstraints(601, 550, 28, 28));
        recurso4.getAccessibleContext().setAccessibleName("recurso4");

        recurso5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/barra/recursos/recurso0.png"))); // NOI18N
        getContentPane().add(recurso5, new org.netbeans.lib.awtextra.AbsoluteConstraints(646, 550, 28, 28));
        recurso5.getAccessibleContext().setAccessibleName("recurso5");

        recurso6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/barra/recursos/recurso0.png"))); // NOI18N
        getContentPane().add(recurso6, new org.netbeans.lib.awtextra.AbsoluteConstraints(691, 550, 28, 28));
        recurso6.getAccessibleContext().setAccessibleName("recurso6");

        recursos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/barra/recursos.png"))); // NOI18N
        getContentPane().add(recursos, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 508, -1, -1));

        energia.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        energia.setForeground(new java.awt.Color(255, 255, 255));
        energia.setText("Salud");
        getContentPane().add(energia, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 510, -1, -1));
        energia.getAccessibleContext().setAccessibleName("");

        salud.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        salud.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/barra/salud5.PNG"))); // NOI18N
        getContentPane().add(salud, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 530, -1, -1));
        salud.getAccessibleContext().setAccessibleName("salud");

        n1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        n1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/barra/numeros/-.png"))); // NOI18N
        getContentPane().add(n1, new org.netbeans.lib.awtextra.AbsoluteConstraints(372, 535, 14, 29));
        n1.getAccessibleContext().setAccessibleName("n1");

        n2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        n2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/barra/numeros/-.png"))); // NOI18N
        getContentPane().add(n2, new org.netbeans.lib.awtextra.AbsoluteConstraints(385, 535, 14, 29));
        n2.getAccessibleContext().setAccessibleName("n2");

        n3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        n3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/barra/numeros/-.png"))); // NOI18N
        getContentPane().add(n3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 535, 14, 29));
        n3.getAccessibleContext().setAccessibleName("n3");

        n4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        n4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/barra/numeros/-.png"))); // NOI18N
        getContentPane().add(n4, new org.netbeans.lib.awtextra.AbsoluteConstraints(433, 535, 14, 29));
        n4.getAccessibleContext().setAccessibleName("n4");

        hora.setBackground(new java.awt.Color(0, 0, 0));
        hora.setFont(new java.awt.Font("DS-Digital", 1, 18)); // NOI18N
        hora.setForeground(new java.awt.Color(204, 0, 0));
        hora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hora.setText(":");
        hora.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        hora.setOpaque(true);
        getContentPane().add(hora, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 530, 100, 40));
        hora.getAccessibleContext().setAccessibleName("hora");

        barra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/barra.png"))); // NOI18N
        barra.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        barra.setMaximumSize(new java.awt.Dimension(800, 110));
        barra.setMinimumSize(new java.awt.Dimension(800, 110));
        barra.setPreferredSize(new java.awt.Dimension(800, 110));
        getContentPane().add(barra, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 490, -1, -1));

        cuadroDialogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/dialogos/escenario1/ventana[0,2]/conversador1/dialogo1/1.png"))); // NOI18N
        getContentPane().add(cuadroDialogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 340, 0, 0));

        tiempo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/tiempo/dia1.png"))); // NOI18N
        getContentPane().add(tiempo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 490));
        tiempo.getAccessibleContext().setAccessibleName("tiempo");

        roca3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/objetos/rocaaba.gif"))); // NOI18N
        getContentPane().add(roca3, new org.netbeans.lib.awtextra.AbsoluteConstraints(455, 370, -1, -1));

        roca4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/objetos/rocaaba.gif"))); // NOI18N
        getContentPane().add(roca4, new org.netbeans.lib.awtextra.AbsoluteConstraints(455, 90, -1, -1));

        roca1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/objetos/rocaaba.gif"))); // NOI18N
        getContentPane().add(roca1, new org.netbeans.lib.awtextra.AbsoluteConstraints(295, 370, -1, -1));

        roca2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/objetos/rocaaba.gif"))); // NOI18N
        getContentPane().add(roca2, new org.netbeans.lib.awtextra.AbsoluteConstraints(295, 90, -1, -1));

        cascada.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        cascada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/objetos/cascada.gif"))); // NOI18N
        cascada.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(cascada, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, -50, 85, 88));

        cascada2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        cascada2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/objetos/cascada.gif"))); // NOI18N
        cascada2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(cascada2, new org.netbeans.lib.awtextra.AbsoluteConstraints(433, -50, -1, 88));

        cascada4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        cascada4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/objetos/cascada.gif"))); // NOI18N
        cascada4.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(cascada4, new org.netbeans.lib.awtextra.AbsoluteConstraints(307, -50, -1, 88));

        cascada3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        cascada3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/objetos/cascada.gif"))); // NOI18N
        cascada3.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(cascada3, new org.netbeans.lib.awtextra.AbsoluteConstraints(628, -50, 81, 88));

        espadazo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        espadazo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/objetos/espadazo.gif"))); // NOI18N
        getContentPane().add(espadazo, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, -21, 0, 0));

        tahi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/personajes/tahi/tahi2.png"))); // NOI18N
        getContentPane().add(tahi, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, -1, -1));
        tahi.getAccessibleContext().setAccessibleName("tahi");

        getContentPane().add(obstaculo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 195, 66, 290));
        getContentPane().add(obstaculo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 720, 70));
        getContentPane().add(obstaculo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 177, 540, 32));
        getContentPane().add(obstaculo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 50));
        getContentPane().add(obstaculo5, new org.netbeans.lib.awtextra.AbsoluteConstraints(197, 155, 430, 10));
        getContentPane().add(obstaculo6, new org.netbeans.lib.awtextra.AbsoluteConstraints(199, 291, 430, 62));
        getContentPane().add(obstaculo7, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 439, 430, 20));
        getContentPane().add(obstaculo8, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 460, 660, 130));
        getContentPane().add(obstaculo9, new org.netbeans.lib.awtextra.AbsoluteConstraints(693, 58, 35, 295));
        getContentPane().add(obstaculo10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 422, 90, 170));
        getContentPane().add(obstaculo11, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 335, 80, 18));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/escenarios/escenario1/v27.png"))); // NOI18N
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana27_s1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Ventana27_s1().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ayuda;
    private javax.swing.JLabel barra;
    private javax.swing.JLabel cascada;
    private javax.swing.JLabel cascada2;
    private javax.swing.JLabel cascada3;
    private javax.swing.JLabel cascada4;
    private javax.swing.JLabel cuadroDialogo;
    private javax.swing.JLabel energia;
    private javax.swing.JLabel espadazo;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel hora;
    private javax.swing.JLabel marcoPuntaje;
    private javax.swing.JLabel n1;
    private javax.swing.JLabel n2;
    private javax.swing.JLabel n3;
    private javax.swing.JLabel n4;
    private javax.swing.JLabel numPuntaje1;
    private javax.swing.JLabel numPuntaje2;
    private javax.swing.JLabel numPuntaje3;
    private javax.swing.JLabel numPuntaje4;
    private javax.swing.JLabel obstaculo1;
    private javax.swing.JLabel obstaculo10;
    private javax.swing.JLabel obstaculo11;
    private javax.swing.JLabel obstaculo2;
    private javax.swing.JLabel obstaculo3;
    private javax.swing.JLabel obstaculo4;
    private javax.swing.JLabel obstaculo5;
    private javax.swing.JLabel obstaculo6;
    private javax.swing.JLabel obstaculo7;
    private javax.swing.JLabel obstaculo8;
    private javax.swing.JLabel obstaculo9;
    private javax.swing.JLabel pausa;
    private javax.swing.JLabel puntaje;
    private javax.swing.JLabel recurso1;
    private javax.swing.JLabel recurso2;
    private javax.swing.JLabel recurso3;
    private javax.swing.JLabel recurso4;
    private javax.swing.JLabel recurso5;
    private javax.swing.JLabel recurso6;
    private javax.swing.JLabel recursos;
    private javax.swing.JLabel roca1;
    private javax.swing.JLabel roca2;
    private javax.swing.JLabel roca3;
    private javax.swing.JLabel roca4;
    private javax.swing.JLabel salud;
    private javax.swing.JLabel sound;
    private javax.swing.JLabel tahi;
    private javax.swing.JLabel tiempo;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the vJF
     */
    public JFrame[][] getvJF() {
        return vJF;
    }

    /**
     * @param vJF the vJF to set
     */
    public void setvJF(JFrame[][] vJF) {
        this.vJF = vJF;
    }

    /**
     * @return the numVentanaFila
     */
    public int getNumVentanaFila() {
        return numVentanaFila;
    }

    /**
     * @param numVentanaFila the numVentanaFila to set
     */
    public void setNumVentanaFila(int numVentanaFila) {
        this.numVentanaFila = numVentanaFila;
    }


    void setPosicionVentana(int fila, int columna) {
        this.numVentanaFila = fila;
        this.setNumVentanaColm(columna);
    }

    /**
     * @return the numVentanaColm
     */
    public int getNumVentanaColm() {
        return numVentanaColm;
    }

    /**
     * @param numVentanaColm the numVentanaColm to set
     */
    public void setNumVentanaColm(int numVentanaColm) {
        this.numVentanaColm = numVentanaColm;
    }

    private void cargarPersonajes() {
        
       conversadores = new ArrayList<>();       
       enemigos = new ArrayList<>(); 
       
       Icon i1 = new ImageIcon (getClass().getResource("imagenes/objetos/rocaarr.gif"));
       Icon i2 = new ImageIcon (getClass().getResource("imagenes/objetos/rocaaba.gif"));
       
       new Rodante(this,tahi,"vertical",90,370,roca1,i1,i2,3,40,5,10).start();
       new Rodante(this,tahi,"vertical",90,370,roca2,i1,i2,3,40,5,10).start();
       new Rodante(this,tahi,"vertical",90,370,roca3,i1,i2,3,40,5,10).start();
       new Rodante(this,tahi,"vertical",90,370,roca4,i1,i2,3,40,5,10).start();
    }

    private void cargarObstaculos() {
        
        int p1;
        int p2;
        int p3;
        int p4;  
        
        this.obstaculos = new ArrayList<>();
        this.obstaculosAbajo = new Obstaculo();
        this.obstaculosIzquierda = new Obstaculo();
        this.obstaculosDerecha = new Obstaculo();
        this.obstaculosArriba = new Obstaculo();
        
        //------------ Definicion de los obstaculos del escenario --------------      
        this.obstaculos.add(this.obstaculo1);
        this.obstaculos.add(this.obstaculo2);
        this.obstaculos.add(this.obstaculo3);
        this.obstaculos.add(this.obstaculo4);
        this.obstaculos.add(this.obstaculo5);
        this.obstaculos.add(this.obstaculo6);
        this.obstaculos.add(this.obstaculo7);
        this.obstaculos.add(this.obstaculo8);
        this.obstaculos.add(this.obstaculo9);
        this.obstaculos.add(this.obstaculo10);
        this.obstaculos.add(this.obstaculo11);
        //----------------------------------------------------------------------
        
        for(int i = 0; i<this.obstaculos.size(); i++)
        {
           p1 = this.obstaculos.get(i).getX();
           p2 = this.obstaculos.get(i).getY();
           p3 = this.obstaculos.get(i).getX()+this.obstaculos.get(i).getWidth();
           p4 = this.obstaculos.get(i).getY()+this.obstaculos.get(i).getHeight();           
            
           this.obstaculosAbajo.getLineas().add(new Linea(p1,p2,p3,p2,SPEED)); //Obstaculos hacia Abajo...
           this.obstaculosIzquierda.getLineas().add(new Linea(p3,p2,p3,p4,SPEED)); //Obstaculos a la Izquierda...
           this.obstaculosDerecha.getLineas().add(new Linea(p1,p2,p1,p4,SPEED)); //Obstaculos a la Derecha...
           this.obstaculosArriba.getLineas().add(new Linea(p1,p4,p3,p4,SPEED)); //Obstaculos hacia Arriba...                   
        }  
    }
    
    
    public boolean validarPosicionConversadora()
    {
        int x1 = tahi.getX();
        int y1 = tahi.getY();
        int x2 = tahi.getX() + tahi.getWidth();
        int y2 = tahi.getY() + tahi.getHeight(); 
        
        
        for(int i = 0; i<this.conversadores.size(); i++)
        {
          if(this.conversadores.get(i).getDialogos() != null && conversadores.get(i).getImagen() != null)
          {            
           int limiteArriba = conversadores.get(i).getImagen().getY()-RADIO;
           int limiteDerecha = conversadores.get(i).getImagen().getX()+conversadores.get(i).getImagen().getWidth()+RADIO;
           int limiteIzquierda = conversadores.get(i).getImagen().getX()-RADIO;
           int limiteAbajo = conversadores.get(i).getImagen().getY()+conversadores.get(i).getImagen().getHeight()+RADIO;
           
           if( x1 > limiteIzquierda && x1 < limiteDerecha && y1 > limiteArriba && y1 < limiteAbajo )
           { 
              //buscar mensaje.
               d.setNumConv(i); 
               imprimirMensaje(conversadores.get(i));
               return true;
           }
           else
           {
             if( x2 > limiteIzquierda && x2 < limiteDerecha && y1 > limiteArriba && y1 < limiteAbajo )
             {
                //buscar mensaje. 
                d.setNumConv(i);  
                imprimirMensaje(conversadores.get(i));
                return true;
             }
             else
             {
                if( x1 > limiteIzquierda && x1 < limiteDerecha && y2 > limiteArriba && y2 < limiteAbajo )
                {
                   //buscar mensaje.
                   d.setNumConv(i); 
                   imprimirMensaje(conversadores.get(i));
                   return true;
                }
                else
                {
                   if( x2 > limiteIzquierda && x2 < limiteDerecha && y2 > limiteArriba && y2 < limiteAbajo )
                   {
                      //buscar mensaje. 
                      d.setNumConv(i); 
                      imprimirMensaje(conversadores.get(i));                       
                      return true;
                   }    
                }
             }
           }
         }
        }
        return false;
    }
    
    
    public void imprimirMensaje(Conversador c)
    {  
       if(c.getMensajeActual() == 0)
       {
         cuadroDialogo.setSize(cuadroDialogo.getPreferredSize());
       }
       this.cuadroDialogo.setIcon(c.getDialogos().get(c.getDialogoActual()).getMensajes2().get(c.getMensajeActual()));
              
       if(c.getMensajeActual() < c.getDialogos().get(c.getDialogoActual()).getMensajes2().size()-1)
       {
         c.setMensajeActual(c.getMensajeActual()+1); 
         d.setUltimoMensaje(false);
       }
       else
       {
         if(c.getDialogoActual() < c.getDialogos().size()-1)
         {
            c.setDialogoActual(c.getDialogoActual()+1); 
         }
         c.setMensajeActual(0);
         d.setUltimoMensaje(true);
       }
    }
    
    
    public void mensajeApertura() //Hablan Tahi o Lily luego de haber aterrizado!
    {
       d.setVentanaAbierta(true);        
       imprimirMensaje(conversadores.get(0));
    }
    
    
    public class AL extends KeyAdapter
    {       
         int i = 0;
        
        @Override
        public void keyPressed(KeyEvent e)
        {
            int keyCode = e.getKeyCode();   
            if(i==0){Sonidos.getInstance().reproducirLoop(clip1);i++;}
            
            switch(keyCode)
            {
                case (KeyEvent.VK_DOWN): if(!desplazamiento.obstaculoAba(tahi, obstaculosAbajo) && !d.isVentanaAbierta())//Se valida si hay obstaculo
                                         {
                                            tahi.setLocation(tahi.getX(),tahi.getY()+SPEED);
                                         }
                                         desplazamiento.avanzar(tahi, 1, 3, FRECUENCIA, d); //Movimiento de los pies
                                         if(tahi.getY() > fondo.getHeight()-5)  //Se valida si tahi sale de la ventana
                                         {
                                            desplazamiento.cambiarPantalla(GestorJuego.getInstance().getvJF()[getNumVentanaFila()][getNumVentanaColm()],GestorJuego.getInstance().getvJF()[getNumVentanaFila()+1][getNumVentanaColm()],tahi,tahi.getX(),0,SPEED);                                            
                                            Sonidos.getInstance().detener(clip1);;i=0;
                                         }
                                         break;
                    
                case (KeyEvent.VK_RIGHT): if(!desplazamiento.obstaculoDer(tahi, obstaculosDerecha) && !d.isVentanaAbierta())//Se valida si hay obstaculo
                                          {
                                            tahi.setLocation(tahi.getX()+SPEED,tahi.getY());
                                          }  
                                          desplazamiento.avanzar(tahi, 7, 9, FRECUENCIA, d); //Movimiento de los pies
                                          if(tahi.getX() > fondo.getWidth()-5) //Se valida si tahi sale de la ventana
                                          {                                                      
                                            desplazamiento.cambiarPantalla(GestorJuego.getInstance().getvJF()[getNumVentanaFila()][getNumVentanaColm()],GestorJuego.getInstance().getvJF()[getNumVentanaFila()][getNumVentanaColm()+1],tahi,0,tahi.getY(),SPEED);    
                                            Sonidos.getInstance().detener(clip1);;i=0;
                                          }
                                          break;  
                    
                case (KeyEvent.VK_UP): if(!desplazamiento.obstaculoArr(tahi, obstaculosArriba) && !d.isVentanaAbierta())//Se valida si hay obstaculo
                                       {
                                         tahi.setLocation(tahi.getX(),tahi.getY()-SPEED);
                                       } 
                                       desplazamiento.avanzar(tahi, 10, 12, FRECUENCIA, d); //Movimiento de los pies
                                       if(tahi.getY()+tahi.getHeight() < 5) //Se valida si tahi sale de la ventana
                                       {
                                          desplazamiento.cambiarPantalla(GestorJuego.getInstance().getvJF()[getNumVentanaFila()][getNumVentanaColm()],GestorJuego.getInstance().getvJF()[getNumVentanaFila()-1][getNumVentanaColm()],tahi,tahi.getX(),fondo.getHeight()-tahi.getHeight(),SPEED);    
                                          Sonidos.getInstance().detener(clip1);;i=0;
                                       }
                                       break;
                    
                case (KeyEvent.VK_LEFT): if(!desplazamiento.obstaculoIzq(tahi, obstaculosIzquierda) && !d.isVentanaAbierta())//Se valida si hay obstaculo
                                         {
                                           tahi.setLocation(tahi.getX()-SPEED,tahi.getY());
                                         }
                                         desplazamiento.avanzar(tahi, 4, 6, FRECUENCIA, d); //Movimiento de los pies
                                         if(tahi.getX()+tahi.getWidth() < 5) //Se valida si tahi sale de la ventana
                                         {
                                            desplazamiento.cambiarPantalla(GestorJuego.getInstance().getvJF()[getNumVentanaFila()][getNumVentanaColm()],GestorJuego.getInstance().getvJF()[getNumVentanaFila()][getNumVentanaColm()-1],tahi,fondo.getWidth() - tahi.getWidth(),tahi.getY(),SPEED);    
                                            Sonidos.getInstance().detener(clip1);;i=0;
                                         }
                                         break;
                    
                case (KeyEvent.VK_SPACE): if(GestorJuego.getInstance().getRecursos()[0]){new Espadazo(enemigos,espadazo,tahi).start();}                                        
                                          break;
                    
                case (KeyEvent.VK_ENTER): if( !d.isVentanaAbierta() )
                                          {
                                             if(validarPosicionConversadora())
                                             { 
                                                d.setVentanaAbierta(true); 
                                             }
                                          }
                                          else
                                          {
                                             if(d.isUltimoMensaje())
                                             {                                                
                                                cuadroDialogo.setSize(0,0);
                                                d.setVentanaAbierta(false);
                                             }
                                             else
                                             {
                                               //dialogo.imprimirMensaje(conversadores.get(d.getNumConv()), cuadroActual, d, HIDDEN);
                                               imprimirMensaje(conversadores.get(d.getNumConv()));
                                             }
                                          }
                                          break;
            }
        }
        
        @Override
        public void keyReleased(KeyEvent e) //Cambio de imagen a estatica sobre Tahi (hacia adelante o hacia atras)
        {
            int keyCode = e.getKeyCode();            
                       
            switch(keyCode)
            {
                case (KeyEvent.VK_DOWN): desplazamiento.detenerse(tahi, 0);break; //Se detiene hacia adelante.     
                case (KeyEvent.VK_UP): desplazamiento.detenerse(tahi, 1);break; //Se detiene hacia atras. 
            }
        }
     }   
}
