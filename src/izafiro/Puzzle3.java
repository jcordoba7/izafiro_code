/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package izafiro;

import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Jonathan
 */
public class Puzzle3 extends javax.swing.JFrame {

    private Icon[] instrucciones;
    private JLabel[] partes;
    private JLabel[] cortados;
    private boolean cronometro = false;
    private boolean enJuego = false;
    private boolean troncoSeleccionado = false;
    private int troncoEscogido;
    private int partesCortadas = 0;
    private int numerador;
    private int denominador;
    private int cont = 1;
    private int numeradorAnterior = 0;
    private int denominadorAnterior = 0;
    private int puntaje = 0;
    private int puntosPorNivel = 7;
    private int vecesPorNivel = 5;
    private int nivelActual = 1;
    private int numNiveles = 3;
    private double calificacionMinima = 0.75;
    
    /**
     * Creates new form Puzzle3
     */
    public Puzzle3() {
        initComponents();
        this.setLocationRelativeTo(null); this.setIconImage(new ImageIcon (getClass().getResource("izafiroicono.png")).getImage()); Sonidos.getInstance().activarCursor(this);
        
        instrucciones = new Icon[9];         
        instrucciones[0] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle3/instrucciones/1.png"));
        instrucciones[1] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle3/instrucciones/2.png"));
        instrucciones[2] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle3/instrucciones/3.png"));
        instrucciones[3] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle3/instrucciones/4.png"));
        instrucciones[4] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle3/instrucciones/5.png"));
        instrucciones[5] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle3/instrucciones/6.png"));
        instrucciones[6] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle3/instrucciones/7.png"));
        instrucciones[7] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle3/instrucciones/8.png"));
        instrucciones[8] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle3/instrucciones/9.png"));
        
        partes = new JLabel[5];
        partes[0] = parte1;
        partes[1] = parte2;
        partes[2] = parte3;
        partes[3] = parte4;
        partes[4] = parte5;
        
        cortados = new JLabel[5];
        cortados[0] = cortado1;
        cortados[1] = cortado2;
        cortados[2] = cortado3;
        cortados[3] = cortado4;
        cortados[4] = cortado5;
        
        this.tahi.setIcon(new ImageIcon (getClass().getResource("imagenes/personajes/tahi/"+GestorJuego.getInstance().getGenero()+"8.png")));
    }
    
    
    public void mostrarInstrucciones()
    {
      this.cuadroDialogo.setSize(cuadroDialogo.getPreferredSize());
      this.cuadroDialogo.setIcon(instrucciones[0]); 
      this.siguiente.setSize(30,30);
      this.anterior.setSize(30,30);
      this.flecha.setSize(0,0);
      this.flecha2.setSize(0,0);
    }
    
    public void ocultarInstrucciones(boolean mostrarFlecha)
    {
      this.cuadroDialogo.setSize(0,0);
      this.siguiente.setSize(0,0);
      this.anterior.setSize(0,0);
      if(mostrarFlecha){this.flecha2.setSize(flecha2.getPreferredSize());}
    }
    
    public void iniciarPuzzle()
    {
      this.flecha.setSize(0,0);  
      this.flecha2.setSize(0,0);
      ocultarTroncos();
      campoNumerador.setText("");
      campoDenominador.setText("");
      
      enJuego = true;
      
      new Nivel().start();
         
      iniciarBtn.setSize(0,0);
      instruccionesBtn.setSize(0,0);
      SalirBtn.setSize(0,0);
    }
    
    public void ocultarTroncos()
    {
       for(int i=0; i<5; i++)
        {
          partes[i].setSize(0,0);
        }  
    }
    
    
    public void generarFraccion1() //solo cambia el numerador, el denominador es 5
    {      
       Random randomGenerator = new Random();
       numerador = 0;
       denominador = 5;
       
       while(numerador == 0 || numerador == numeradorAnterior){
         numerador = randomGenerator.nextInt(6);
       }
       numeradorAnterior = numerador;
       
       this.campoNumerador.setText(numerador+"");
       this.campoDenominador.setText(denominador+""); 
    }
    
    
    public void generarFraccion2()
    {      
       Random randomGenerator = new Random();
       numerador = 0;
       denominador = 0;
       
       while(denominador == 0 || denominador == denominadorAnterior){
         denominador = randomGenerator.nextInt(6);
       }
       while(numerador == 0){ //no es posible evitar numerador repetitivo por q hay posibilidad de un bucle
         numerador = randomGenerator.nextInt(denominador+1);
       }
       denominadorAnterior = denominador;
       
       this.campoNumerador.setText(numerador+"");
       this.campoDenominador.setText(denominador+"");
    }
    
    public void mostrarHacha(int parte)
    {
      hacha.setLocation(hacha.getX(), partes[parte-1].getY()-(hacha.getPreferredSize().height-partes[parte-1].getHeight()));
      new Hachazo(partes[parte-1],cortados[parte-1]).start();      
    }
    
    public void ordenarPartes() //coloca las partes en su sitio despues de haber sido cortadas
    {     
       int x = 156;
       int y = 268; 
       
       for(int i=0; i<partes.length; i++)
       {
          partes[i].setLocation(x, y+(36*i));
       }
       ocultarTroncos();
    }
    
    public void validarNumeros()
    {
       if(troncoEscogido == denominador && partesCortadas == numerador) 
       {
           Sonidos.getInstance().reproducir("success2");
           JOptionPane.showMessageDialog(null, "BIEN!!!\nTienes +"+ puntosPorNivel +" puntos!!", "Correcto", JOptionPane.PLAIN_MESSAGE, new ImageIcon (getClass().getResource("imagenes/objetos/check.png")));         
           aumentarPuntaje();
       }
       else{
           Sonidos.getInstance().reproducir("error");
           JOptionPane.showMessageDialog(null, "Vaya...  :( \nTe has equivocado!","Mensaje",0);
       }
       troncoSeleccionado = false;
       partesCortadas = 0;
    }
    
    public void aumentarPuntaje()
    {
       puntaje += puntosPorNivel;
       this.campoPuntaje.setText(puntaje+"");
    }
    
    public void pasarSiguienteNivel()
    {
       campoNumerador.setText("");
       campoDenominador.setText(""); 
       if(nivelActual == numNiveles)
       {
         if(puntaje >= ((numNiveles*puntosPorNivel)*vecesPorNivel)*calificacionMinima)
         {
           Sonidos.getInstance().reproducir("nuevorecurso");  
           JOptionPane.showMessageDialog(null, "Enhorabuena! ...\nHas completado la prueba con EXITO!!!","Correcto", JOptionPane.PLAIN_MESSAGE, new ImageIcon (getClass().getResource("imagenes/objetos/check.png"))); 
           JOptionPane.showMessageDialog(null, "Haz hecho un puntaje de "+ puntaje + "/" + ((numNiveles*puntosPorNivel)*vecesPorNivel) + " en este juego!! ...");
           PruebaPuzzle.getInstance().cerrarActividad(this,puntaje);
           Sonidos.getInstance().detener("hacha");
         }
         else
         {
           Sonidos.getInstance().reproducir("error");  
           JOptionPane.showMessageDialog(null, "Vaya ... tu puntaje no ha sido muy bueno. "+ puntaje + "/" + ((numNiveles*puntosPorNivel)*vecesPorNivel) + " \nAnimo! ... puedes hacerlo mejor!\nDa click en Iniciar para comenzar el nivel 1!","Mensaje",0);
           nivelActual = 1;
           puntaje = 0;
           this.campoPuntaje.setText(puntaje+"");
           iniciarBtn.setSize(iniciarBtn.getPreferredSize());
           instruccionesBtn.setSize(instruccionesBtn.getPreferredSize());
           SalirBtn.setSize(SalirBtn.getPreferredSize());
         }
       }
       else {
         iniciarBtn.setSize(iniciarBtn.getPreferredSize());
         instruccionesBtn.setSize(instruccionesBtn.getPreferredSize());
         SalirBtn.setSize(SalirBtn.getPreferredSize());
         if(nivelActual < numNiveles){nivelActual++;} //Se aumenta el Nivel ...
         Sonidos.getInstance().reproducir("success1");
         JOptionPane.showMessageDialog(null, "Bien! ...\nAhora puedes pasar al Nivel " + (nivelActual) +" dando\nclick en iniciar.");
         this.flecha2.setSize(flecha2.getPreferredSize());
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

        siguiente = new javax.swing.JLabel();
        anterior = new javax.swing.JLabel();
        cuadroDialogo = new javax.swing.JLabel();
        campoPuntaje = new javax.swing.JTextField();
        SalirBtn = new javax.swing.JToggleButton();
        iniciarBtn = new javax.swing.JToggleButton();
        instruccionesBtn = new javax.swing.JToggleButton();
        flecha = new javax.swing.JLabel();
        flecha2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tronco1 = new javax.swing.JLabel();
        tronco2 = new javax.swing.JLabel();
        tronco3 = new javax.swing.JLabel();
        tronco4 = new javax.swing.JLabel();
        tronco5 = new javax.swing.JLabel();
        hacha = new javax.swing.JLabel();
        tahi = new javax.swing.JLabel();
        parte1 = new javax.swing.JLabel();
        parte2 = new javax.swing.JLabel();
        parte3 = new javax.swing.JLabel();
        parte4 = new javax.swing.JLabel();
        parte5 = new javax.swing.JLabel();
        cortado1 = new javax.swing.JLabel();
        cortado2 = new javax.swing.JLabel();
        cortado3 = new javax.swing.JLabel();
        cortado4 = new javax.swing.JLabel();
        cortado5 = new javax.swing.JLabel();
        campoNumerador = new javax.swing.JTextField();
        campoDenominador = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        reloj = new javax.swing.JTextField();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("iZafiro - Bosque de las Luciérnagas");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        siguiente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        siguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/botones/flecha-siguiente.png"))); // NOI18N
        siguiente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        siguiente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                siguienteMouseClicked(evt);
            }
        });
        getContentPane().add(siguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(456, 220, 0, 0));

        anterior.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        anterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/botones/flecha-anterior.png"))); // NOI18N
        anterior.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        anterior.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                anteriorMouseClicked(evt);
            }
        });
        getContentPane().add(anterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 220, 0, 0));

        cuadroDialogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cuadroDialogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/puzzle/puzzle1/instrucciones/1.png"))); // NOI18N
        getContentPane().add(cuadroDialogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 210, 0, 0));

        campoPuntaje.setEditable(false);
        campoPuntaje.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        campoPuntaje.setForeground(new java.awt.Color(0, 0, 153));
        campoPuntaje.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoPuntaje.setText("0");
        getContentPane().add(campoPuntaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(449, 10, 50, 40));

        SalirBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        SalirBtn.setForeground(new java.awt.Color(0, 102, 0));
        SalirBtn.setText("Salir");
        SalirBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SalirBtn.setPreferredSize(new java.awt.Dimension(110, 23));
        SalirBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirBtnActionPerformed(evt);
            }
        });
        getContentPane().add(SalirBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 110, -1));

        iniciarBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        iniciarBtn.setForeground(new java.awt.Color(0, 102, 0));
        iniciarBtn.setText("Iniciar");
        iniciarBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        iniciarBtn.setPreferredSize(new java.awt.Dimension(110, 23));
        iniciarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iniciarBtnActionPerformed(evt);
            }
        });
        getContentPane().add(iniciarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 110, -1));

        instruccionesBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        instruccionesBtn.setForeground(new java.awt.Color(0, 102, 0));
        instruccionesBtn.setText("Instrucciones");
        instruccionesBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        instruccionesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                instruccionesBtnActionPerformed(evt);
            }
        });
        getContentPane().add(instruccionesBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, -1, -1));

        flecha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/objetos/flechapuzzle.gif"))); // NOI18N
        getContentPane().add(flecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 420, -1, -1));

        flecha2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/objetos/flechapuzzle.gif"))); // NOI18N
        getContentPane().add(flecha2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 390, 0, 0));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Puntaje");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, 90, 20));

        tronco1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tronco1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tronco1MouseClicked(evt);
            }
        });
        getContentPane().add(tronco1, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 220, 36, 20));

        tronco2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tronco2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tronco2MouseClicked(evt);
            }
        });
        getContentPane().add(tronco2, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 192, 72, 20));

        tronco3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tronco3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tronco3MouseClicked(evt);
            }
        });
        getContentPane().add(tronco3, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 164, 108, 20));

        tronco4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tronco4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tronco4MouseClicked(evt);
            }
        });
        getContentPane().add(tronco4, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 136, 144, 20));

        tronco5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tronco5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tronco5MouseClicked(evt);
            }
        });
        getContentPane().add(tronco5, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 108, 180, 20));

        hacha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hacha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/puzzle/puzzle3/hachazo.gif"))); // NOI18N
        hacha.setPreferredSize(new java.awt.Dimension(60, 60));
        getContentPane().add(hacha, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 244, 0, 0));

        tahi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/personajes/tahi/tahi8.png"))); // NOI18N
        getContentPane().add(tahi, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 340, -1, -1));

        parte1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        parte1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/puzzle/puzzle3/pedazotronco.png"))); // NOI18N
        parte1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        parte1.setPreferredSize(new java.awt.Dimension(36, 36));
        parte1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                parte1MouseClicked(evt);
            }
        });
        getContentPane().add(parte1, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 268, -1, -1));

        parte2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        parte2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/puzzle/puzzle3/pedazotronco.png"))); // NOI18N
        parte2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        parte2.setPreferredSize(new java.awt.Dimension(36, 36));
        parte2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                parte2MouseClicked(evt);
            }
        });
        getContentPane().add(parte2, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 304, -1, -1));

        parte3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        parte3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/puzzle/puzzle3/pedazotronco.png"))); // NOI18N
        parte3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        parte3.setPreferredSize(new java.awt.Dimension(36, 36));
        parte3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                parte3MouseClicked(evt);
            }
        });
        getContentPane().add(parte3, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 340, -1, -1));

        parte4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        parte4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/puzzle/puzzle3/pedazotronco.png"))); // NOI18N
        parte4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        parte4.setPreferredSize(new java.awt.Dimension(36, 36));
        parte4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                parte4MouseClicked(evt);
            }
        });
        getContentPane().add(parte4, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 376, -1, -1));

        parte5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        parte5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/puzzle/puzzle3/pedazotronco.png"))); // NOI18N
        parte5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        parte5.setPreferredSize(new java.awt.Dimension(36, 36));
        parte5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                parte5MouseClicked(evt);
            }
        });
        getContentPane().add(parte5, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 412, -1, -1));

        cortado1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cortado1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/puzzle/puzzle3/pedazocortado.gif"))); // NOI18N
        cortado1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cortado1MouseClicked(evt);
            }
        });
        getContentPane().add(cortado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 268, 0, 0));

        cortado2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cortado2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/puzzle/puzzle3/pedazocortado.gif"))); // NOI18N
        cortado2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cortado2MouseClicked(evt);
            }
        });
        getContentPane().add(cortado2, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 304, 0, 0));

        cortado3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cortado3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/puzzle/puzzle3/pedazocortado.gif"))); // NOI18N
        cortado3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cortado3MouseClicked(evt);
            }
        });
        getContentPane().add(cortado3, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 340, 0, 0));

        cortado4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cortado4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/puzzle/puzzle3/pedazocortado.gif"))); // NOI18N
        cortado4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cortado4MouseClicked(evt);
            }
        });
        getContentPane().add(cortado4, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 376, 0, 0));

        cortado5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cortado5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/puzzle/puzzle3/pedazocortado.gif"))); // NOI18N
        cortado5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cortado5MouseClicked(evt);
            }
        });
        getContentPane().add(cortado5, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 412, 0, 0));

        campoNumerador.setEditable(false);
        campoNumerador.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        campoNumerador.setForeground(new java.awt.Color(0, 102, 0));
        campoNumerador.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(campoNumerador, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 380, 50, 40));

        campoDenominador.setEditable(false);
        campoDenominador.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        campoDenominador.setForeground(new java.awt.Color(0, 102, 0));
        campoDenominador.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(campoDenominador, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 440, 50, 40));

        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 153), 3));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 428, 80, 6));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Numerador");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 390, 90, 20));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Denominador");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 450, 100, 20));

        reloj.setEditable(false);
        reloj.setBackground(new java.awt.Color(0, 0, 0));
        reloj.setFont(new java.awt.Font("Arial", 1, 40)); // NOI18N
        reloj.setForeground(new java.awt.Color(255, 0, 0));
        reloj.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        reloj.setText("0");
        getContentPane().add(reloj, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 80, 60));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/puzzle/puzzle3/p1.png"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void iniciarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iniciarBtnActionPerformed
        // TODO add your handling code here:
        if(cuadroDialogo.getSize().width == 0){iniciarPuzzle();}
        else{JOptionPane.showMessageDialog(null, "Termina de leer las instrucciones.");}
    }//GEN-LAST:event_iniciarBtnActionPerformed

    private void instruccionesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_instruccionesBtnActionPerformed
        // TODO add your handling code here:
        mostrarInstrucciones();
    }//GEN-LAST:event_instruccionesBtnActionPerformed

    private void tronco5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tronco5MouseClicked
        // TODO add your handling code here:
        if(troncoSeleccionado){return;}
        for(int i=0; i<5; i++)
        {            
          partes[i].setSize(partes[i].getPreferredSize());
        }
        ocultarInstrucciones(false);
        troncoEscogido = 5;
        troncoSeleccionado = true;
    }//GEN-LAST:event_tronco5MouseClicked

    private void tronco4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tronco4MouseClicked
        // TODO add your handling code here:
        if(troncoSeleccionado){return;}
        for(int i=0; i<4; i++)
        {
          partes[i].setSize(partes[i].getPreferredSize());
        }
        ocultarInstrucciones(false);
        troncoEscogido = 4;
        troncoSeleccionado = true;
    }//GEN-LAST:event_tronco4MouseClicked

    private void tronco3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tronco3MouseClicked
        // TODO add your handling code here:
        if(troncoSeleccionado){return;}
        for(int i=0; i<3; i++)
        {
          partes[i].setSize(partes[i].getPreferredSize());
        }
        ocultarInstrucciones(false);
        troncoEscogido = 3;
        troncoSeleccionado = true;
    }//GEN-LAST:event_tronco3MouseClicked

    private void tronco2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tronco2MouseClicked
        // TODO add your handling code here:
        if(troncoSeleccionado){return;}
        for(int i=0; i<2; i++)
        {
          partes[i].setSize(partes[i].getPreferredSize());
        }
        ocultarInstrucciones(false);
        troncoEscogido = 2;
        troncoSeleccionado = true;
    }//GEN-LAST:event_tronco2MouseClicked

    private void tronco1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tronco1MouseClicked
        // TODO add your handling code here:
        if(troncoSeleccionado){return;}
        for(int i=0; i<1; i++)
        {
          partes[i].setSize(partes[i].getPreferredSize());
        }
        ocultarInstrucciones(false);
        troncoEscogido = 1;
        troncoSeleccionado = true;
    }//GEN-LAST:event_tronco1MouseClicked

    private void parte1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_parte1MouseClicked
        // TODO add your handling code here:
        if(hacha.getHeight() == 0 && enJuego){mostrarHacha(1);}        
    }//GEN-LAST:event_parte1MouseClicked

    private void parte2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_parte2MouseClicked
        // TODO add your handling code here:
        if(hacha.getHeight() == 0 && enJuego){mostrarHacha(2);}
    }//GEN-LAST:event_parte2MouseClicked

    private void parte3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_parte3MouseClicked
        // TODO add your handling code here:
        if(hacha.getHeight() == 0 && enJuego){mostrarHacha(3);}
    }//GEN-LAST:event_parte3MouseClicked

    private void parte4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_parte4MouseClicked
        // TODO add your handling code here:
        if(hacha.getHeight() == 0 && enJuego){mostrarHacha(4);}
    }//GEN-LAST:event_parte4MouseClicked

    private void parte5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_parte5MouseClicked
        // TODO add your handling code here:
        if(hacha.getHeight() == 0 && enJuego){mostrarHacha(5);}
    }//GEN-LAST:event_parte5MouseClicked

    private void cortado1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cortado1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cortado1MouseClicked

    private void cortado2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cortado2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cortado2MouseClicked

    private void cortado3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cortado3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cortado3MouseClicked

    private void cortado4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cortado4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cortado4MouseClicked

    private void cortado5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cortado5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cortado5MouseClicked

    private void siguienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_siguienteMouseClicked
        // TODO add your handling code here:
        if(cont < instrucciones.length){
            cont++;
            this.cuadroDialogo.setIcon(instrucciones[cont-1]);
        }
        else{
            cont = 1;
            ocultarInstrucciones(true);
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

    private void SalirBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirBtnActionPerformed
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
            } catch (SQLException ex) {
              Logger.getLogger(Puzzle3.class.getName()).log(Level.SEVERE, null, ex);
            } 
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Puzzle3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Puzzle3().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton SalirBtn;
    private javax.swing.JLabel anterior;
    private javax.swing.JTextField campoDenominador;
    private javax.swing.JTextField campoNumerador;
    private javax.swing.JTextField campoPuntaje;
    private javax.swing.JLabel cortado1;
    private javax.swing.JLabel cortado2;
    private javax.swing.JLabel cortado3;
    private javax.swing.JLabel cortado4;
    private javax.swing.JLabel cortado5;
    private javax.swing.JLabel cuadroDialogo;
    private javax.swing.JLabel flecha;
    private javax.swing.JLabel flecha2;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel hacha;
    private javax.swing.JToggleButton iniciarBtn;
    private javax.swing.JToggleButton instruccionesBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel parte1;
    private javax.swing.JLabel parte2;
    private javax.swing.JLabel parte3;
    private javax.swing.JLabel parte4;
    private javax.swing.JLabel parte5;
    private javax.swing.JTextField reloj;
    private javax.swing.JLabel siguiente;
    private javax.swing.JLabel tahi;
    private javax.swing.JLabel tronco1;
    private javax.swing.JLabel tronco2;
    private javax.swing.JLabel tronco3;
    private javax.swing.JLabel tronco4;
    private javax.swing.JLabel tronco5;
    // End of variables declaration//GEN-END:variables

   
    public class Hachazo extends Thread
    {
       JLabel tronco;
       JLabel cortado;
       
       public Hachazo (JLabel parte, JLabel cortado)
       { 
         this.tronco = parte;
         this.cortado = cortado;
       }       
        
       @Override
       public void run()
       {   
         hacha.setSize(hacha.getPreferredSize()); 
         partesCortadas++;
         try {
             Thread.sleep(800);
         } catch (InterruptedException ex) {}           
         new DesprenderTronco(tronco,cortado).start();
         hacha.setSize(0,0);
       }
    }
    
    public class DesprenderTronco extends Thread
    {
       JLabel tronco;
       JLabel cortado;
       
       public DesprenderTronco(JLabel parte,JLabel cortado)
       { 
         this.tronco = parte;
         this.cortado = cortado;
       }
        
       @Override
       public void run()
       {
         int x = this.tronco.getX();
         int y;          
         
         this.tronco.setSize(0,0);
         this.cortado.setSize(cortado.getPreferredSize());
         
         Sonidos.getInstance().reproducir("hacha");
         
         for(int i=0; i<100; i++)
         {
           y = x*2;
           this.cortado.setLocation(x,y);
           this.tronco.setLocation(x,y);
           x++;           
           try {
               Thread.sleep(10);
           } catch (InterruptedException ex) {}
         }
         this.cortado.setSize(0,0);         
       } 
    }
    
    
    public class Cronometro extends Thread
    {  
       @Override
       public void run()
       {
         for(int i=((numerador*1000*2+2000)/1000); i>=0; i--)
         {  
           try {
             Thread.sleep(1000);
           } catch (InterruptedException ex) {}
           reloj.setText(i+"");
         }
         cronometro = true;
       } 
    }
    
    
    public class Nivel extends Thread
    {
       @Override
       public void run()
       {
         cronometro = false;  
         JOptionPane.showMessageDialog(null, "... NIVEL "+ nivelActual +" ...");          
         for(int j=0; j<vecesPorNivel; j++)  
         {
           switch(nivelActual)
           {
             case(1): generarFraccion1();break;
             case(2): generarFraccion2();break;
             case(3): generarFraccion2();break;
           }
           flecha2.setSize(0,0);
           new Cronometro().start();           
           while(!cronometro){try {Thread.sleep(100);} catch (InterruptedException ex) {}}           
           cronometro = false;
           validarNumeros();
           ordenarPartes();
         } 
         enJuego = false;
         pasarSiguienteNivel();         
       }
    } 
}
