/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package izafiro;

import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Jacc89
 */
public final class Ventana65_s1 extends javax.swing.JFrame {

    
    //Variables del cambio de Ventana
    private JFrame[][] vJF;
    private int numVentanaFila ;
    private int numVentanaColm;
    
    // Variables del Movimiento
    private static final int SPEED = GestorJuego.getInstance().getSpeed(); //Velocidad de Tahi
    private static final int FRECUENCIA = GestorJuego.getInstance().getFrecuencia(); //Frecuencia del movimiento de pies de Tahi
    private static final int RADIO = 15; //Distancia para conversar con otros personajes
    private Desplazamiento desplazamiento = Desplazamiento.getInstance(); //Invocador de metodos relacionados con el desplazamiento
    private Deposito d; //Clase deposito que guarda las variables primitivas del JFrame
    
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
    public Ventana65_s1() {
        initComponents();
        this.setLocationRelativeTo(null); 
        this.setIconImage(new ImageIcon (getClass().getResource("izafiroicono.png")).getImage()); Sonidos.getInstance().activarCursor(this);
        this.d = new Deposito(tahi.getX(),tahi.getY(),this);
        cargarObstaculos();
        cargarPersonajes();
        this.addKeyListener(Teclado.getInstace());//ActionListener para deneter la musica de fodndo 
        this.addKeyListener(new Ventana65_s1.AL());//ActionListener para el movimiento del personaje 
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
        letrero = new javax.swing.JLabel();
        cuadroDialogo = new javax.swing.JLabel();
        tiempo = new javax.swing.JLabel();
        fuente1 = new javax.swing.JLabel();
        fuente2 = new javax.swing.JLabel();
        fuente3 = new javax.swing.JLabel();
        objeto4 = new javax.swing.JLabel();
        objeto3 = new javax.swing.JLabel();
        objeto1 = new javax.swing.JLabel();
        objeto2 = new javax.swing.JLabel();
        soldado3 = new javax.swing.JLabel();
        soldado2 = new javax.swing.JLabel();
        soldado1 = new javax.swing.JLabel();
        espadazo = new javax.swing.JLabel();
        tahi = new javax.swing.JLabel();
        pilares = new javax.swing.JLabel();
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
        obstaculo12 = new javax.swing.JLabel();
        guardado = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("iZafiro - Bosque de las Luciérnagas");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        numPuntaje1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        numPuntaje1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/barra/numerospuntaje/0.png"))); // NOI18N
        getContentPane().add(numPuntaje1, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 443, 14, 29));
        numPuntaje1.getAccessibleContext().setAccessibleName("numPuntaje1");

        numPuntaje2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        numPuntaje2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/barra/numerospuntaje/0.png"))); // NOI18N
        getContentPane().add(numPuntaje2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 443, 14, 29));
        numPuntaje2.getAccessibleContext().setAccessibleName("numPuntaje2");

        numPuntaje3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        numPuntaje3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/barra/numerospuntaje/0.png"))); // NOI18N
        getContentPane().add(numPuntaje3, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 443, 14, 29));
        numPuntaje3.getAccessibleContext().setAccessibleName("numPuntaje3");

        numPuntaje4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        numPuntaje4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/barra/numerospuntaje/0.png"))); // NOI18N
        getContentPane().add(numPuntaje4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 443, 14, 29));
        numPuntaje4.getAccessibleContext().setAccessibleName("numPuntaje4");

        marcoPuntaje.setBackground(new java.awt.Color(239, 255, 239));
        marcoPuntaje.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        marcoPuntaje.setOpaque(true);
        getContentPane().add(marcoPuntaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 70, 35));

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
        getContentPane().add(puntaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, -1, -1));

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

        letrero.setBackground(new java.awt.Color(0, 0, 153));
        letrero.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        letrero.setForeground(new java.awt.Color(255, 255, 255));
        letrero.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        letrero.setText("Jardín de Las Fuentes");
        letrero.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        letrero.setOpaque(true);
        letrero.setPreferredSize(new java.awt.Dimension(310, 170));
        getContentPane().add(letrero, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, 0, 0));

        cuadroDialogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/dialogos/escenario1/ventana[0,2]/conversador1/dialogo1/1.png"))); // NOI18N
        getContentPane().add(cuadroDialogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 340, 0, 0));

        tiempo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/tiempo/dia1.png"))); // NOI18N
        getContentPane().add(tiempo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 490));
        tiempo.getAccessibleContext().setAccessibleName("tiempo");

        fuente1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/objetos/fuente.gif"))); // NOI18N
        getContentPane().add(fuente1, new org.netbeans.lib.awtextra.AbsoluteConstraints(266, 165, -1, -1));

        fuente2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/objetos/fuente.gif"))); // NOI18N
        getContentPane().add(fuente2, new org.netbeans.lib.awtextra.AbsoluteConstraints(362, 165, -1, -1));

        fuente3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/objetos/fuente.gif"))); // NOI18N
        getContentPane().add(fuente3, new org.netbeans.lib.awtextra.AbsoluteConstraints(458, 165, -1, -1));

        objeto4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/objetos/estatua2.png"))); // NOI18N
        getContentPane().add(objeto4, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 40, -1, -1));

        objeto3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/objetos/estatua2.png"))); // NOI18N
        getContentPane().add(objeto3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 40, -1, -1));

        objeto1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/objetos/estatua1.png"))); // NOI18N
        getContentPane().add(objeto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, -1, -1));

        objeto2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/objetos/estatua1.png"))); // NOI18N
        getContentPane().add(objeto2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 40, -1, -1));

        soldado3.setBackground(new java.awt.Color(255, 0, 0));
        soldado3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/personajes/soldado/detenido1.png"))); // NOI18N
        getContentPane().add(soldado3, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 320, -1, -1));

        soldado2.setBackground(new java.awt.Color(255, 0, 0));
        soldado2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/personajes/soldado/detenido1.png"))); // NOI18N
        getContentPane().add(soldado2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 320, -1, -1));

        soldado1.setBackground(new java.awt.Color(255, 0, 0));
        soldado1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/personajes/soldado/detenido1.png"))); // NOI18N
        getContentPane().add(soldado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 150, -1, -1));

        espadazo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        espadazo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/objetos/espadazo.gif"))); // NOI18N
        getContentPane().add(espadazo, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, -21, 0, 0));

        tahi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/personajes/tahi/tahi2.png"))); // NOI18N
        getContentPane().add(tahi, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, -1, -1));
        tahi.getAccessibleContext().setAccessibleName("tahi");

        pilares.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/objetos/pilares2.png"))); // NOI18N
        getContentPane().add(pilares, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, -1, -1));
        getContentPane().add(obstaculo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 295));
        getContentPane().add(obstaculo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 0, 640, 45));
        getContentPane().add(obstaculo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 185, 175));
        getContentPane().add(obstaculo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 0, 20, 295));
        getContentPane().add(obstaculo5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 397, 800, 190));
        getContentPane().add(obstaculo6, new org.netbeans.lib.awtextra.AbsoluteConstraints(164, 0, 20, 310));
        getContentPane().add(obstaculo7, new org.netbeans.lib.awtextra.AbsoluteConstraints(197, 110, 20, 170));
        getContentPane().add(obstaculo8, new org.netbeans.lib.awtextra.AbsoluteConstraints(302, 200, 280, 75));
        getContentPane().add(obstaculo9, new org.netbeans.lib.awtextra.AbsoluteConstraints(667, 110, 30, 170));
        getContentPane().add(obstaculo10, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 0, 80, 175));
        getContentPane().add(obstaculo11, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 132, 440, 10));
        getContentPane().add(obstaculo12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 192, 90, 40));
        getContentPane().add(guardado, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 165, 120, 110));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/escenarios/escenario1/v65.png"))); // NOI18N
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
            java.util.logging.Logger.getLogger(Ventana65_s1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Ventana65_s1().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ayuda;
    private javax.swing.JLabel barra;
    private javax.swing.JLabel cuadroDialogo;
    private javax.swing.JLabel energia;
    private javax.swing.JLabel espadazo;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel fuente1;
    private javax.swing.JLabel fuente2;
    private javax.swing.JLabel fuente3;
    private javax.swing.JLabel guardado;
    private javax.swing.JLabel hora;
    private javax.swing.JLabel letrero;
    private javax.swing.JLabel marcoPuntaje;
    private javax.swing.JLabel n1;
    private javax.swing.JLabel n2;
    private javax.swing.JLabel n3;
    private javax.swing.JLabel n4;
    private javax.swing.JLabel numPuntaje1;
    private javax.swing.JLabel numPuntaje2;
    private javax.swing.JLabel numPuntaje3;
    private javax.swing.JLabel numPuntaje4;
    private javax.swing.JLabel objeto1;
    private javax.swing.JLabel objeto2;
    private javax.swing.JLabel objeto3;
    private javax.swing.JLabel objeto4;
    private javax.swing.JLabel obstaculo1;
    private javax.swing.JLabel obstaculo10;
    private javax.swing.JLabel obstaculo11;
    private javax.swing.JLabel obstaculo12;
    private javax.swing.JLabel obstaculo2;
    private javax.swing.JLabel obstaculo3;
    private javax.swing.JLabel obstaculo4;
    private javax.swing.JLabel obstaculo5;
    private javax.swing.JLabel obstaculo6;
    private javax.swing.JLabel obstaculo7;
    private javax.swing.JLabel obstaculo8;
    private javax.swing.JLabel obstaculo9;
    private javax.swing.JLabel pausa;
    private javax.swing.JLabel pilares;
    private javax.swing.JLabel puntaje;
    private javax.swing.JLabel recurso1;
    private javax.swing.JLabel recurso2;
    private javax.swing.JLabel recurso3;
    private javax.swing.JLabel recurso4;
    private javax.swing.JLabel recurso5;
    private javax.swing.JLabel recurso6;
    private javax.swing.JLabel recursos;
    private javax.swing.JLabel salud;
    private javax.swing.JLabel soldado1;
    private javax.swing.JLabel soldado2;
    private javax.swing.JLabel soldado3;
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
        this.obstaculos.add(this.obstaculo12);
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
        SenalVentana senal = new SenalVentana();
        
        @Override
        public void keyPressed(KeyEvent e)
        {            
            int keyCode = e.getKeyCode();
            
            if(Ayuda.getInstance().isVisible() || Pausa.getInstance().isVisible() || (keyCode == KeyEvent.VK_S))
            {
                return;
            }
            
            if(senal.i == 0)
            {              
              ArrayList<Soldado> soldados = new ArrayList<>();
              
              // ------ soldados ----------
              
              Point[] puntos = new Point[4];
              puntos [0] = new Point(250,150);
              puntos [1] = new Point(600,150);
              puntos [2] = new Point(600,320);
              puntos [3] = new Point(250,320);
              
              int[] vec = new int[3];
              vec[0] = 6; vec[1] = 5;
             
              soldados.add(new Soldado(soldado1,tahi,puntos,60,1,obstaculosAbajo,obstaculosArriba,obstaculosIzquierda,obstaculosDerecha,1,vec,senal,null,soldados,30));
              soldados.add(new Soldado(soldado2,tahi,puntos,35,1,obstaculosAbajo,obstaculosArriba,obstaculosIzquierda,obstaculosDerecha,1,vec,senal,null,soldados,30));
              soldados.add(new Soldado(soldado3,tahi,puntos,40,1,obstaculosAbajo,obstaculosArriba,obstaculosIzquierda,obstaculosDerecha,1,vec,senal,null,soldados,30));
                            
              senal.i++;
              
              for (int j = 0; j<soldados.size() ; j++) {soldados.get(j).start();}             
            }
            
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
                                             else if(desplazamiento.contiene(guardado, tahi.getLocation()))// Cerca a los pilares de salvado.
                                             {       
                                                GuardarPartida.getInstance().guardarPartida(numVentanaFila, numVentanaColm, tahi.getLocation());
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
