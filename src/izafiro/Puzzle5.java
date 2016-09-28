/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package izafiro;

import java.awt.Color;
import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Jonathan
 */
public class Puzzle5 extends javax.swing.JFrame {

    private Icon[] instrucciones;
    private JTextField[] camposNumeradores;
    private JTextField[] camposDenominadores;
    private JLabel[] mayas; 
    private JLabel[] ranas;
    private Icon maya;
    private Icon mayaNo;
    private String tipoFraccion;
    private boolean cronometro = false;
    private int numerador;
    private int denominador;
    private int cont = 1;
    private int numeradorAnterior = 0;
    private int denominadorAnterior = 0;
    private int tipoAnterior = -1;
    private int puntaje = 0;
    private int vecesPorNivel = 3;
    private int nivelActual = 0;
    private int numNiveles = 2;
    private int total = 10;
    private double calificacionMinima = 0.75;
    
    /**
     * Creates new form Puzzle5
     */
    public Puzzle5() {
        initComponents();
        this.setLocationRelativeTo(null); this.setIconImage(new ImageIcon (getClass().getResource("izafiroicono.png")).getImage()); Sonidos.getInstance().activarCursor(this);
        
        instrucciones = new Icon[19];
        instrucciones[0] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle5/instrucciones/1.png"));
        instrucciones[1] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle5/instrucciones/2.png"));
        instrucciones[2] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle5/instrucciones/2-1.png"));
        instrucciones[3] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle5/instrucciones/3.png"));
        instrucciones[4] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle5/instrucciones/4.png"));
        instrucciones[5] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle5/instrucciones/5.png"));
        instrucciones[6] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle5/instrucciones/6.png"));
        instrucciones[7] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle5/instrucciones/7.png"));
        instrucciones[8] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle5/instrucciones/8.png"));
        instrucciones[9] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle5/instrucciones/9.png"));
        instrucciones[10] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle5/instrucciones/10.png"));
        instrucciones[11] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle5/instrucciones/11.png"));
        instrucciones[12] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle5/instrucciones/12.png"));
        instrucciones[13] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle5/instrucciones/12-1.png"));
        instrucciones[14] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle5/instrucciones/13.png"));
        instrucciones[15] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle5/instrucciones/14.png"));
        instrucciones[16] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle5/instrucciones/15.png"));
        instrucciones[17] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle5/instrucciones/16.png"));
        instrucciones[18] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle5/instrucciones/17.png"));
        
        camposNumeradores = new JTextField[9];
        camposNumeradores[0] = num1;
        camposNumeradores[1] = num2;
        camposNumeradores[2] = num3;
        camposNumeradores[3] = num4;
        camposNumeradores[4] = num5;
        camposNumeradores[5] = num6;
        camposNumeradores[6] = num7;
        camposNumeradores[7] = num8;
        camposNumeradores[8] = num9;
        
        camposDenominadores = new JTextField[9];
        camposDenominadores[0] = den1;
        camposDenominadores[1] = den2;
        camposDenominadores[2] = den3;
        camposDenominadores[3] = den4;
        camposDenominadores[4] = den5;
        camposDenominadores[5] = den6;
        camposDenominadores[6] = den7;
        camposDenominadores[7] = den8;
        camposDenominadores[8] = den9;   
        
        mayas = new JLabel[9];
        mayas[0] = red1;
        mayas[1] = red2;
        mayas[2] = red3;
        mayas[3] = red4;
        mayas[4] = red5;
        mayas[5] = red6;
        mayas[6] = red7;
        mayas[7] = red8;
        mayas[8] = red9;    
        
        ranas = new JLabel[9];
        ranas[0] = rana1;
        ranas[1] = rana2;
        ranas[2] = rana3;
        ranas[3] = rana4;
        ranas[4] = rana5;
        ranas[5] = rana6;
        ranas[6] = rana7;
        ranas[7] = rana8;
        ranas[8] = rana9; 
        
        maya = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle5/red.png"));
        mayaNo = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle5/redno.png"));
        
        String personaje = GestorJuego.getInstance().getGenero();
        tahi.setIcon(new ImageIcon (getClass().getResource("imagenes/personajes/tahi/"+personaje+"2.png")));
    }
    
    public void mostrarInstrucciones()
    {
      this.cuadroDialogo.setSize(cuadroDialogo.getPreferredSize());
      this.cuadroDialogo.setIcon(instrucciones[0]); 
      this.cuadrito.setSize(cuadrito.getPreferredSize());
      this.siguiente.setSize(30,30); 
      this.anterior.setSize(30,30);
      this.flecha.setSize(0,0);
      this.flecha2.setSize(0,0);
      
    }
    
    public void ocultarInstrucciones()
    {
      this.cuadroDialogo.setSize(0,0);
      this.cuadrito.setSize(0,0);
      this.siguiente.setSize(0,0);  
      this.anterior.setSize(0,0);
      this.flecha2.setSize(flecha2.getPreferredSize());
    }
    
    public void limpiarFraccionarios()
    {
       for(int i=0; i<camposNumeradores.length; i++)
       {
         camposNumeradores[i].setText("");         
         camposDenominadores[i].setText("");
       }
    }
    
    public void limpiarMayas()
    {
       for(int i=0; i<mayas.length; i++)
       {
         mayas[i].setIcon(mayaNo);
         ranas[i].setSize(0,0);
       }
       Sonidos.getInstance().detener("rana");
    }
    
    public void iniciarPuzzle()
    {  
      this.flecha.setSize(0,0);  
      this.flecha2.setSize(0,0);
      limpiarMayas();
      if(nivelActual == 0){new Nivel0().start();}
      else{new Nivel().start();}
         
      iniciarBtn.setSize(0,0);
      instruccionesBtn.setSize(0,0);
      SalirBtn.setSize(0,0);
    }
    
    public void generarFraccion1()
    {
       Random randomGenerator = new Random();
       numerador = 0;
       denominador = 5;
       
       while(numerador == 0 || numerador == numeradorAnterior){
         numerador = randomGenerator.nextInt(11);
       }
       numeradorAnterior = numerador;
       
       while(denominador == 0 || denominador == denominadorAnterior){
         denominador = randomGenerator.nextInt(11);
       }
       denominadorAnterior = denominador;
       
       this.campoNumerador.setText(numerador+"");
       this.campoDenominador.setText(denominador+"");  
    }
    
    public void construirEscenario()
    {
       Random randomGenerator = new Random();
       
       int tipo = randomGenerator.nextInt(3);
       
       while(tipo == tipoAnterior)
       {
         tipo = randomGenerator.nextInt(3);  
       }
       
       tipoAnterior = tipo;     
       
       switch(tipo)
       {
         case 0: tipoFraccion = "propia"; if(nivelActual != 2){texto2.setText("Fracciones Propias (< 1)");}else{texto2.setText("Fracciones Propias");} break;
         case 1: tipoFraccion = "impropia"; if(nivelActual != 2){texto2.setText("Fracciones Impropias (> 1)");}else{texto2.setText("Fracciones Impropias");} break;
         case 2: tipoFraccion = "unidad"; if(nivelActual != 2){texto2.setText("Iguales a la Unidad (= 1)");}else{texto2.setText("Iguales a la Unidad");} break;
       }
       
       new EfectoCambio().start();
       
       int numeradores[] = new int[9];
       int denominadores[] = new int[9];
       
       for (int i = 0; i < numeradores.length; i++) {numeradores[i] = -1;denominadores[i] = -1;}
       
       int den;
       int num;
        
       for(int i=0; i<numeradores.length; i++)
       {           
          if(numeradores[i] == -1)
          {
            den = randomGenerator.nextInt(15);
            while(den < 3)
            {
              den = randomGenerator.nextInt(15);   
            }
            num = randomGenerator.nextInt(15);  
            while( num == 0)
            {
              num = randomGenerator.nextInt(15); 
            }
           
            while(fraccionRepetida(num,den,numeradores,denominadores))
            {
               den = randomGenerator.nextInt(15);
               while(den < 3)
               {
                 den = randomGenerator.nextInt(15);   
               }
               num = randomGenerator.nextInt(15);  
               while( num == 0)
               {
                 num = randomGenerator.nextInt(15); 
               } 
            } 
            
            numeradores[i] = num;
            denominadores[i] = den;
          }
       }
       
       for(int i=0; i<numeradores.length; i++)
       {
          camposNumeradores[i].setText(numeradores[i]+""); 
          camposDenominadores[i].setText(denominadores[i]+"");
       }
       
       int numUnidad = randomGenerator.nextInt(15); 
       while(numUnidad == 0){numUnidad = randomGenerator.nextInt(15);}
       int pos = randomGenerator.nextInt(9);       
       camposNumeradores[pos].setText(numUnidad+""); 
       camposDenominadores[pos].setText(numUnidad+"");
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
    
    public void colocarMaya(int i)
    {
       if(mayas[i-1].getIcon().toString().contains("no"))
       {
         mayas[i-1].setIcon(maya);  
       }
       else
       {
         mayas[i-1].setIcon(mayaNo);  
       }
    }
    
    public int validarPropias()
    {
       int correctas = 0; 
       int sonido = 0;
       
       for(int i=0; i<mayas.length; i++)
       {
          if(Integer.parseInt(camposNumeradores[i].getText()) < Integer.parseInt(camposDenominadores[i].getText()))
          {
            if(sonido == 0){Sonidos.getInstance().reproducirLoop("rana");sonido++;}  
            ranas[i].setSize(ranas[i].getPreferredSize());  
            total += vecesPorNivel;
          } 
       }
       
       for(int i=0; i<mayas.length; i++)
       {
          if(Integer.parseInt(camposNumeradores[i].getText()) < Integer.parseInt(camposDenominadores[i].getText())
           && !mayas[i].getIcon().toString().contains("no"))
          {
            aumentarPuntaje(vecesPorNivel);
            correctas++;
          }else if(Integer.parseInt(camposNumeradores[i].getText()) < Integer.parseInt(camposDenominadores[i].getText())
           && mayas[i].getIcon().toString().contains("no"))
          {  
            aumentarPuntaje(-5);  
          }else if(!(Integer.parseInt(camposNumeradores[i].getText()) < Integer.parseInt(camposDenominadores[i].getText()))
           && !mayas[i].getIcon().toString().contains("no"))
          { 
            aumentarPuntaje(-5);  
          } 
       }
       return correctas;
    }
    
    public int validarImpropias()
    {
       int correctas = 0; 
       int sonido = 0;
       
       for(int i=0; i<mayas.length; i++)
       {
          if(Integer.parseInt(camposNumeradores[i].getText()) > Integer.parseInt(camposDenominadores[i].getText()))
          {
            if(sonido == 0){Sonidos.getInstance().reproducirLoop("rana");;sonido++;}  
            ranas[i].setSize(ranas[i].getPreferredSize());  
            total += vecesPorNivel;
          } 
       }
       
       for(int i=0; i<mayas.length; i++)
       {
          if(Integer.parseInt(camposNumeradores[i].getText()) > Integer.parseInt(camposDenominadores[i].getText())
           && !mayas[i].getIcon().toString().contains("no"))
          {
            aumentarPuntaje(vecesPorNivel);
            correctas++;
          }else if(Integer.parseInt(camposNumeradores[i].getText()) > Integer.parseInt(camposDenominadores[i].getText())
           && mayas[i].getIcon().toString().contains("no"))
          {   
            aumentarPuntaje(-5);  
          }else if(!(Integer.parseInt(camposNumeradores[i].getText()) > Integer.parseInt(camposDenominadores[i].getText()))
           && !mayas[i].getIcon().toString().contains("no"))
          {  
            aumentarPuntaje(-5);  
          } 
       }
       return correctas;
    }
    
    public int validarUnidad()
    {
       int correctas = 0; 
       int sonido =0;
       
       for(int i=0; i<mayas.length; i++)
       {
          if(Integer.parseInt(camposNumeradores[i].getText()) == Integer.parseInt(camposDenominadores[i].getText()))
          {
            if(sonido == 0){Sonidos.getInstance().reproducirLoop("rana");sonido++;}  
            ranas[i].setSize(ranas[i].getPreferredSize());  
            total += vecesPorNivel;
          } 
       }
       
       for(int i=0; i<mayas.length; i++)
       {
          if(Integer.parseInt(camposNumeradores[i].getText()) == Integer.parseInt(camposDenominadores[i].getText())
           && !mayas[i].getIcon().toString().contains("no"))
          {
            aumentarPuntaje(vecesPorNivel);
            correctas++;
          }else if(Integer.parseInt(camposNumeradores[i].getText()) == Integer.parseInt(camposDenominadores[i].getText())
           && mayas[i].getIcon().toString().contains("no"))
          {  
            aumentarPuntaje(-5);  
          }else if(!(Integer.parseInt(camposNumeradores[i].getText()) == Integer.parseInt(camposDenominadores[i].getText()))
           && !mayas[i].getIcon().toString().contains("no"))
          {
            aumentarPuntaje(-5);  
          }  
       }
       return correctas;
    }
    
    public void validarNumeros()            
    {
       int correctas = 0; 
       switch(tipoFraccion)
       {
          case "propia": correctas = validarPropias(); break;
          case "impropia": correctas = validarImpropias(); break;
          case "unidad": correctas = validarUnidad(); break;
       }
       try {Thread.sleep(3000);} catch (InterruptedException ex) {}
       Sonidos.getInstance().reproducir("success2"); 
       JOptionPane.showMessageDialog(null, "Has tenido " + correctas + " jugada(s) correcta(s).");
       limpiarMayas();
    }
    
    public void aumentarPuntaje(int cant)
    {
       puntaje += cant;
       this.campoPuntaje.setText(puntaje+"");
    }
    
    public void pasarSiguienteNivel()
    {
       limpiarFraccionarios();
       if(nivelActual == numNiveles)
       {
         if(puntaje >= total*calificacionMinima)
         {
           Sonidos.getInstance().reproducir("nuevorecurso");   
           JOptionPane.showMessageDialog(null, "Enhorabuena! ...\nHas completado la prueba con EXITO!!!","Correcto", JOptionPane.PLAIN_MESSAGE, new ImageIcon (getClass().getResource("imagenes/objetos/check.png"))); 
           JOptionPane.showMessageDialog(null, "Haz hecho un puntaje de "+ puntaje + "/" + total + " en este juego!! ...");
           PruebaPuzzle.getInstance().cerrarActividad(this,puntaje);
         }
         else
         {
           Sonidos.getInstance().reproducir("error");   
           JOptionPane.showMessageDialog(null, "Vaya ... tu puntaje no ha sido muy bueno. "+ puntaje + "/" + total + " \nAnimo! ... puedes hacerlo mejor!\nDa click en Iniciar para comenzar el nivel 1!","Mensaje",0);
           nivelActual = 0;
           puntaje = 0;
           total = 10;
           this.campoPuntaje.setText(puntaje+"");
           iniciarBtn.setSize(iniciarBtn.getPreferredSize());
           instruccionesBtn.setSize(instruccionesBtn.getPreferredSize());
           SalirBtn.setSize(SalirBtn.getPreferredSize());
           texto2.setSize(0,0);
           this.flecha2.setSize(flecha2.getPreferredSize());
         }
       }
       else {
         texto2.setSize(0,0);
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
        cuadrito = new javax.swing.JLabel();
        SalirBtn = new javax.swing.JToggleButton();
        iniciarBtn = new javax.swing.JToggleButton();
        instruccionesBtn = new javax.swing.JToggleButton();
        jLabel4 = new javax.swing.JLabel();
        campoPuntaje = new javax.swing.JTextField();
        reloj = new javax.swing.JTextField();
        campoNumerador = new javax.swing.JTextField();
        barra = new javax.swing.JLabel();
        campoDenominador = new javax.swing.JTextField();
        flecha2 = new javax.swing.JLabel();
        cascada9 = new javax.swing.JLabel();
        cascada6 = new javax.swing.JLabel();
        cascada7 = new javax.swing.JLabel();
        cascada1 = new javax.swing.JLabel();
        cascada8 = new javax.swing.JLabel();
        texto2 = new javax.swing.JTextField();
        campoResp0 = new javax.swing.JTextField();
        unidad = new javax.swing.JTextField();
        num9 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        den9 = new javax.swing.JTextField();
        num8 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        den8 = new javax.swing.JTextField();
        num7 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        den7 = new javax.swing.JTextField();
        num6 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        den6 = new javax.swing.JTextField();
        num5 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        den5 = new javax.swing.JTextField();
        num4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        den4 = new javax.swing.JTextField();
        num3 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        den3 = new javax.swing.JTextField();
        num2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        den2 = new javax.swing.JTextField();
        num1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        den1 = new javax.swing.JTextField();
        rana9 = new javax.swing.JLabel();
        rana8 = new javax.swing.JLabel();
        rana7 = new javax.swing.JLabel();
        rana6 = new javax.swing.JLabel();
        rana5 = new javax.swing.JLabel();
        rana4 = new javax.swing.JLabel();
        rana3 = new javax.swing.JLabel();
        rana2 = new javax.swing.JLabel();
        rana1 = new javax.swing.JLabel();
        red9 = new javax.swing.JLabel();
        red8 = new javax.swing.JLabel();
        red7 = new javax.swing.JLabel();
        red6 = new javax.swing.JLabel();
        red5 = new javax.swing.JLabel();
        red4 = new javax.swing.JLabel();
        red3 = new javax.swing.JLabel();
        red2 = new javax.swing.JLabel();
        red1 = new javax.swing.JLabel();
        tahi = new javax.swing.JLabel();
        flecha = new javax.swing.JLabel();
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
        getContentPane().add(siguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 70, 0, 0));

        anterior.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        anterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/botones/flecha-anterior.png"))); // NOI18N
        anterior.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        anterior.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                anteriorMouseClicked(evt);
            }
        });
        getContentPane().add(anterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 70, 0, 0));

        cuadroDialogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cuadroDialogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/puzzle/puzzle2/instrucciones/1.png"))); // NOI18N
        cuadroDialogo.setRequestFocusEnabled(false);
        getContentPane().add(cuadroDialogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 0, 0));

        cuadrito.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cuadrito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/objetos/cuadrito.png"))); // NOI18N
        cuadrito.setRequestFocusEnabled(false);
        getContentPane().add(cuadrito, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 0, 0));

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

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Puntaje");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 80, 90, 20));

        campoPuntaje.setEditable(false);
        campoPuntaje.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        campoPuntaje.setForeground(new java.awt.Color(0, 0, 153));
        campoPuntaje.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoPuntaje.setText("0");
        getContentPane().add(campoPuntaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 70, 80, 40));

        reloj.setEditable(false);
        reloj.setBackground(new java.awt.Color(0, 0, 0));
        reloj.setFont(new java.awt.Font("Arial", 1, 50)); // NOI18N
        reloj.setForeground(new java.awt.Color(255, 0, 0));
        reloj.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        reloj.setText("0");
        getContentPane().add(reloj, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 90, 70));

        campoNumerador.setEditable(false);
        campoNumerador.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        campoNumerador.setForeground(new java.awt.Color(0, 102, 0));
        campoNumerador.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoNumerador.setPreferredSize(new java.awt.Dimension(50, 40));
        getContentPane().add(campoNumerador, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 50, 0, 0));

        barra.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 153), 3));
        barra.setPreferredSize(new java.awt.Dimension(80, 6));
        getContentPane().add(barra, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 97, 0, 0));

        campoDenominador.setEditable(false);
        campoDenominador.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        campoDenominador.setForeground(new java.awt.Color(0, 102, 0));
        campoDenominador.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoDenominador.setPreferredSize(new java.awt.Dimension(50, 40));
        getContentPane().add(campoDenominador, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 110, 0, 0));

        flecha2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/objetos/flechapuzzle.gif"))); // NOI18N
        getContentPane().add(flecha2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 390, 0, 0));

        cascada9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/objetos/cascada.gif"))); // NOI18N
        cascada9.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(cascada9, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, -61, 121, 88));

        cascada6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/objetos/cascada.gif"))); // NOI18N
        cascada6.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(cascada6, new org.netbeans.lib.awtextra.AbsoluteConstraints(176, -61, 121, 88));

        cascada7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/objetos/cascada.gif"))); // NOI18N
        cascada7.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(cascada7, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, -61, 121, 88));

        cascada1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/objetos/cascada.gif"))); // NOI18N
        cascada1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(cascada1, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, -61, 121, 88));

        cascada8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/objetos/cascada.gif"))); // NOI18N
        cascada8.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(cascada8, new org.netbeans.lib.awtextra.AbsoluteConstraints(632, -61, 61, 88));

        texto2.setEditable(false);
        texto2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        texto2.setForeground(new java.awt.Color(0, 102, 0));
        texto2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        texto2.setPreferredSize(new java.awt.Dimension(200, 40));
        getContentPane().add(texto2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, 0, 0));

        campoResp0.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        campoResp0.setForeground(new java.awt.Color(0, 0, 204));
        campoResp0.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoResp0.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(campoResp0, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, 0, 0));

        unidad.setEditable(false);
        unidad.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        unidad.setForeground(new java.awt.Color(204, 0, 0));
        unidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        unidad.setText("1");
        unidad.setPreferredSize(new java.awt.Dimension(60, 90));
        getContentPane().add(unidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 50, 0, 0));

        num9.setEditable(false);
        num9.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        num9.setForeground(new java.awt.Color(0, 0, 153));
        num9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num9.setPreferredSize(new java.awt.Dimension(26, 20));
        getContentPane().add(num9, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 410, 35, 25));

        jLabel10.setBackground(new java.awt.Color(255, 0, 0));
        jLabel10.setOpaque(true);
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(577, 438, 41, 4));

        den9.setEditable(false);
        den9.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        den9.setForeground(new java.awt.Color(0, 0, 153));
        den9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        den9.setPreferredSize(new java.awt.Dimension(26, 20));
        getContentPane().add(den9, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 445, 35, 25));

        num8.setEditable(false);
        num8.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        num8.setForeground(new java.awt.Color(0, 0, 153));
        num8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num8.setPreferredSize(new java.awt.Dimension(26, 20));
        getContentPane().add(num8, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 310, 35, 25));

        jLabel9.setBackground(new java.awt.Color(255, 0, 0));
        jLabel9.setOpaque(true);
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(577, 338, 41, 4));

        den8.setEditable(false);
        den8.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        den8.setForeground(new java.awt.Color(0, 0, 153));
        den8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        den8.setPreferredSize(new java.awt.Dimension(26, 20));
        getContentPane().add(den8, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 345, 35, 25));

        num7.setEditable(false);
        num7.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        num7.setForeground(new java.awt.Color(0, 0, 153));
        num7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num7.setPreferredSize(new java.awt.Dimension(26, 20));
        getContentPane().add(num7, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 210, 35, 25));

        jLabel8.setBackground(new java.awt.Color(255, 0, 0));
        jLabel8.setOpaque(true);
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(577, 238, 41, 4));

        den7.setEditable(false);
        den7.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        den7.setForeground(new java.awt.Color(0, 0, 153));
        den7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        den7.setPreferredSize(new java.awt.Dimension(26, 20));
        getContentPane().add(den7, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 245, 35, 25));

        num6.setEditable(false);
        num6.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        num6.setForeground(new java.awt.Color(0, 0, 153));
        num6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num6.setPreferredSize(new java.awt.Dimension(26, 20));
        getContentPane().add(num6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 410, 35, 25));

        jLabel7.setBackground(new java.awt.Color(255, 0, 0));
        jLabel7.setOpaque(true);
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(387, 438, 41, 4));

        den6.setEditable(false);
        den6.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        den6.setForeground(new java.awt.Color(0, 0, 153));
        den6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        den6.setPreferredSize(new java.awt.Dimension(26, 20));
        getContentPane().add(den6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 445, 35, 25));

        num5.setEditable(false);
        num5.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        num5.setForeground(new java.awt.Color(0, 0, 153));
        num5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num5.setPreferredSize(new java.awt.Dimension(26, 20));
        getContentPane().add(num5, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 310, 35, 25));

        jLabel6.setBackground(new java.awt.Color(255, 0, 0));
        jLabel6.setOpaque(true);
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(387, 338, 41, 4));

        den5.setEditable(false);
        den5.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        den5.setForeground(new java.awt.Color(0, 0, 153));
        den5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        den5.setPreferredSize(new java.awt.Dimension(26, 20));
        getContentPane().add(den5, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 345, 35, 25));

        num4.setEditable(false);
        num4.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        num4.setForeground(new java.awt.Color(0, 0, 153));
        num4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num4.setPreferredSize(new java.awt.Dimension(26, 20));
        getContentPane().add(num4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 210, 35, 25));

        jLabel5.setBackground(new java.awt.Color(255, 0, 0));
        jLabel5.setOpaque(true);
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(387, 238, 41, 4));

        den4.setEditable(false);
        den4.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        den4.setForeground(new java.awt.Color(0, 0, 153));
        den4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        den4.setPreferredSize(new java.awt.Dimension(26, 20));
        getContentPane().add(den4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 245, 35, 25));

        num3.setEditable(false);
        num3.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        num3.setForeground(new java.awt.Color(0, 0, 153));
        num3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num3.setPreferredSize(new java.awt.Dimension(26, 20));
        getContentPane().add(num3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 410, 35, 25));

        jLabel3.setBackground(new java.awt.Color(255, 0, 0));
        jLabel3.setOpaque(true);
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(197, 438, 41, 4));

        den3.setEditable(false);
        den3.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        den3.setForeground(new java.awt.Color(0, 0, 153));
        den3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        den3.setPreferredSize(new java.awt.Dimension(26, 20));
        getContentPane().add(den3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 445, 35, 25));

        num2.setEditable(false);
        num2.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        num2.setForeground(new java.awt.Color(0, 0, 153));
        num2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num2.setPreferredSize(new java.awt.Dimension(26, 20));
        getContentPane().add(num2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 310, 35, 25));

        jLabel2.setBackground(new java.awt.Color(255, 0, 0));
        jLabel2.setOpaque(true);
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(197, 338, 41, 4));

        den2.setEditable(false);
        den2.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        den2.setForeground(new java.awt.Color(0, 0, 153));
        den2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        den2.setPreferredSize(new java.awt.Dimension(26, 20));
        getContentPane().add(den2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 345, 35, 25));

        num1.setEditable(false);
        num1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        num1.setForeground(new java.awt.Color(0, 0, 153));
        num1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num1.setPreferredSize(new java.awt.Dimension(26, 20));
        getContentPane().add(num1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 210, 35, 25));

        jLabel1.setBackground(new java.awt.Color(255, 0, 0));
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(197, 238, 41, 4));

        den1.setEditable(false);
        den1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        den1.setForeground(new java.awt.Color(0, 0, 153));
        den1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        den1.setPreferredSize(new java.awt.Dimension(26, 20));
        getContentPane().add(den1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 245, 35, 25));

        rana9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/puzzle/puzzle5/rana.gif"))); // NOI18N
        getContentPane().add(rana9, new org.netbeans.lib.awtextra.AbsoluteConstraints(539, 360, 0, 0));

        rana8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/puzzle/puzzle5/rana.gif"))); // NOI18N
        getContentPane().add(rana8, new org.netbeans.lib.awtextra.AbsoluteConstraints(539, 265, 0, 0));

        rana7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/puzzle/puzzle5/rana.gif"))); // NOI18N
        getContentPane().add(rana7, new org.netbeans.lib.awtextra.AbsoluteConstraints(539, 170, 0, 0));

        rana6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/puzzle/puzzle5/rana.gif"))); // NOI18N
        getContentPane().add(rana6, new org.netbeans.lib.awtextra.AbsoluteConstraints(347, 360, 0, 0));

        rana5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/puzzle/puzzle5/rana.gif"))); // NOI18N
        getContentPane().add(rana5, new org.netbeans.lib.awtextra.AbsoluteConstraints(347, 265, 0, 0));

        rana4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/puzzle/puzzle5/rana.gif"))); // NOI18N
        getContentPane().add(rana4, new org.netbeans.lib.awtextra.AbsoluteConstraints(347, 170, 0, 0));

        rana3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/puzzle/puzzle5/rana.gif"))); // NOI18N
        getContentPane().add(rana3, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 360, 0, 0));

        rana2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/puzzle/puzzle5/rana.gif"))); // NOI18N
        getContentPane().add(rana2, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 265, 0, 0));

        rana1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/puzzle/puzzle5/rana.gif"))); // NOI18N
        getContentPane().add(rana1, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 170, 0, 0));

        red9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/puzzle/puzzle5/redno.png"))); // NOI18N
        red9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        red9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                red9MouseClicked(evt);
            }
        });
        getContentPane().add(red9, new org.netbeans.lib.awtextra.AbsoluteConstraints(531, 408, 40, 40));

        red8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/puzzle/puzzle5/redno.png"))); // NOI18N
        red8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        red8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                red8MouseClicked(evt);
            }
        });
        getContentPane().add(red8, new org.netbeans.lib.awtextra.AbsoluteConstraints(531, 311, 40, 40));

        red7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/puzzle/puzzle5/redno.png"))); // NOI18N
        red7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        red7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                red7MouseClicked(evt);
            }
        });
        getContentPane().add(red7, new org.netbeans.lib.awtextra.AbsoluteConstraints(531, 215, 40, 40));

        red6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/puzzle/puzzle5/redno.png"))); // NOI18N
        red6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        red6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                red6MouseClicked(evt);
            }
        });
        getContentPane().add(red6, new org.netbeans.lib.awtextra.AbsoluteConstraints(339, 408, 40, 40));

        red5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/puzzle/puzzle5/redno.png"))); // NOI18N
        red5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        red5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                red5MouseClicked(evt);
            }
        });
        getContentPane().add(red5, new org.netbeans.lib.awtextra.AbsoluteConstraints(339, 311, 40, 40));

        red4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/puzzle/puzzle5/redno.png"))); // NOI18N
        red4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        red4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                red4MouseClicked(evt);
            }
        });
        getContentPane().add(red4, new org.netbeans.lib.awtextra.AbsoluteConstraints(339, 215, 40, 40));

        red3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/puzzle/puzzle5/redno.png"))); // NOI18N
        red3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        red3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                red3MouseClicked(evt);
            }
        });
        getContentPane().add(red3, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 407, 40, 40));

        red2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/puzzle/puzzle5/redno.png"))); // NOI18N
        red2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        red2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                red2MouseClicked(evt);
            }
        });
        getContentPane().add(red2, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 311, 40, 40));

        red1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/puzzle/puzzle5/redno.png"))); // NOI18N
        red1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        red1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                red1MouseClicked(evt);
            }
        });
        getContentPane().add(red1, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 215, 40, 40));

        tahi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/personajes/tahi/tahi2.png"))); // NOI18N
        getContentPane().add(tahi, new org.netbeans.lib.awtextra.AbsoluteConstraints(342, 125, -1, -1));

        flecha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/objetos/flechapuzzle.gif"))); // NOI18N
        getContentPane().add(flecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 420, -1, -1));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/puzzle/puzzle5/p5.png"))); // NOI18N
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

    private void red1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_red1MouseClicked
        // TODO add your handling code here:
        colocarMaya(1);
    }//GEN-LAST:event_red1MouseClicked

    private void red2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_red2MouseClicked
        // TODO add your handling code here:
        colocarMaya(2);
    }//GEN-LAST:event_red2MouseClicked

    private void red3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_red3MouseClicked
        // TODO add your handling code here:
        colocarMaya(3);
    }//GEN-LAST:event_red3MouseClicked

    private void red4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_red4MouseClicked
        // TODO add your handling code here:
        colocarMaya(4);
    }//GEN-LAST:event_red4MouseClicked

    private void red7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_red7MouseClicked
        // TODO add your handling code here:
        colocarMaya(7);
    }//GEN-LAST:event_red7MouseClicked

    private void red5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_red5MouseClicked
        // TODO add your handling code here:
        colocarMaya(5);
    }//GEN-LAST:event_red5MouseClicked

    private void red6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_red6MouseClicked
        // TODO add your handling code here:
        colocarMaya(6);
    }//GEN-LAST:event_red6MouseClicked

    private void red8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_red8MouseClicked
        // TODO add your handling code here:
        colocarMaya(8);
    }//GEN-LAST:event_red8MouseClicked

    private void red9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_red9MouseClicked
        // TODO add your handling code here:
        colocarMaya(9);
    }//GEN-LAST:event_red9MouseClicked

    private void siguienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_siguienteMouseClicked
        // TODO add your handling code here:
        if(nivelActual == 0)
        {
          if(cont < instrucciones.length){
            cont++;
            this.cuadroDialogo.setIcon(instrucciones[cont-1]);
          }
          else{
            cont = 1;
            ocultarInstrucciones();
          }
        }else
        {
          if(cont < instrucciones.length-1){
             cont++;
             this.cuadroDialogo.setIcon(instrucciones[cont-1]);
          }
          else{
            cont = 1;
            ocultarInstrucciones();
          }
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
              Logger.getLogger(Puzzle5.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Puzzle5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Puzzle5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Puzzle5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Puzzle5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Puzzle5().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton SalirBtn;
    private javax.swing.JLabel anterior;
    private javax.swing.JLabel barra;
    private javax.swing.JTextField campoDenominador;
    private javax.swing.JTextField campoNumerador;
    private javax.swing.JTextField campoPuntaje;
    private javax.swing.JTextField campoResp0;
    private javax.swing.JLabel cascada1;
    private javax.swing.JLabel cascada6;
    private javax.swing.JLabel cascada7;
    private javax.swing.JLabel cascada8;
    private javax.swing.JLabel cascada9;
    private javax.swing.JLabel cuadrito;
    private javax.swing.JLabel cuadroDialogo;
    private javax.swing.JTextField den1;
    private javax.swing.JTextField den2;
    private javax.swing.JTextField den3;
    private javax.swing.JTextField den4;
    private javax.swing.JTextField den5;
    private javax.swing.JTextField den6;
    private javax.swing.JTextField den7;
    private javax.swing.JTextField den8;
    private javax.swing.JTextField den9;
    private javax.swing.JLabel flecha;
    private javax.swing.JLabel flecha2;
    private javax.swing.JLabel fondo;
    private javax.swing.JToggleButton iniciarBtn;
    private javax.swing.JToggleButton instruccionesBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField num1;
    private javax.swing.JTextField num2;
    private javax.swing.JTextField num3;
    private javax.swing.JTextField num4;
    private javax.swing.JTextField num5;
    private javax.swing.JTextField num6;
    private javax.swing.JTextField num7;
    private javax.swing.JTextField num8;
    private javax.swing.JTextField num9;
    private javax.swing.JLabel rana1;
    private javax.swing.JLabel rana2;
    private javax.swing.JLabel rana3;
    private javax.swing.JLabel rana4;
    private javax.swing.JLabel rana5;
    private javax.swing.JLabel rana6;
    private javax.swing.JLabel rana7;
    private javax.swing.JLabel rana8;
    private javax.swing.JLabel rana9;
    private javax.swing.JLabel red1;
    private javax.swing.JLabel red2;
    private javax.swing.JLabel red3;
    private javax.swing.JLabel red4;
    private javax.swing.JLabel red5;
    private javax.swing.JLabel red6;
    private javax.swing.JLabel red7;
    private javax.swing.JLabel red8;
    private javax.swing.JLabel red9;
    private javax.swing.JTextField reloj;
    private javax.swing.JLabel siguiente;
    private javax.swing.JLabel tahi;
    private javax.swing.JTextField texto2;
    private javax.swing.JTextField unidad;
    // End of variables declaration//GEN-END:variables

    
    public class EfectoCambio extends Thread
    {
       @Override
       public void run()
       {
          Color c = texto2.getBackground(); 
          texto2.setSize(texto2.getPreferredSize());
          texto2.setBackground(Color.cyan);   
          try {Thread.sleep(2000);} catch (InterruptedException ex) {}
          texto2.setBackground(c);
       }
    }
    
    public class Cronometro extends Thread
    {  
       int inicio;
       
       public Cronometro(int inicio)
       {
         this.inicio = inicio;  
       }
       
       @Override
       public void run()
       {
         for(int i=inicio; i>=0; i--)
         {  
           try {
             Thread.sleep(1000);
           } catch (InterruptedException ex) {}
           reloj.setText(i+"");
         }
         cronometro = true;
       } 
    }
    
    
    public class Nivel0 extends Thread
    {
       @Override
       public void run()
       {   
         campoNumerador.setSize(campoNumerador.getPreferredSize());
         campoDenominador.setSize(campoDenominador.getPreferredSize());
         barra.setSize(barra.getPreferredSize());
         unidad.setSize(unidad.getPreferredSize());
         campoResp0.setSize(campoResp0.getPreferredSize()); 
         
         JOptionPane.showMessageDialog(null, "Escribe dentro del cuadro de la mitad el signo \n= (igual) \n< (menor) o \n> (mayor) \ndependiendo de la fracción que te aparezca.\nTienes 6 segundos para ello.");
         
         while(puntaje < 8)
         {
           for(int i=0; i<5; i++)
           {
             generarFraccion1();
             
             new Cronometro(6).start();           
             while(!cronometro){ try {Thread.sleep(200);} catch (InterruptedException ex) {} }           
             cronometro = false;
             
             validarRespuesta();
           }
           if(puntaje < 8)
           {
             Sonidos.getInstance().reproducir("error");   
             JOptionPane.showMessageDialog(null, "Vaya, parece que no ha quedado muy claro.\nIntentémoslo de nuevo :D","Mensaje",0);
             puntaje = 0;
             campoPuntaje.setText(puntaje+"");
           }
         }
         Sonidos.getInstance().reproducir("success1"); 
         JOptionPane.showMessageDialog(null, "Muy Bien!, parece que has entendido.\nComencemos con el juego!! :D");
         
         campoNumerador.setSize(0,0);
         campoDenominador.setSize(0,0);
         barra.setSize(0,0);
         unidad.setSize(0,0);
         campoResp0.setSize(0,0);
         
         pasarSiguienteNivel();
       }
       
       public void validarRespuesta()
       {
          boolean correcto = false; 
          
          if(numerador < denominador && campoResp0.getText().equalsIgnoreCase("<"))
          {
            correcto = true; 
          }
          else if(numerador > denominador && campoResp0.getText().equalsIgnoreCase(">"))
          {
            correcto = true;  
          }          
          else if(numerador == denominador && campoResp0.getText().equalsIgnoreCase("="))
          {
            correcto = true;  
          }
          
          if(correcto)
          {
            puntaje += 2; 
            campoPuntaje.setText(puntaje+"");
            Sonidos.getInstance().reproducir("success2"); 
            JOptionPane.showMessageDialog(null, "Muy Bien! :D sigue así!!");            
          }
          else
          {
            Sonidos.getInstance().reproducir("error");   
            JOptionPane.showMessageDialog(null, "Vaya, te has equivocado ...","Mensaje",0);  
          }
          campoResp0.setText("");          
       }
    }
    
    public class Nivel extends Thread
    {
       @Override
       public void run()
       {
         cronometro = false;  
         JOptionPane.showMessageDialog(null, "... NIVEL "+ nivelActual +" ...");  
         texto2.setSize(texto2.getPreferredSize());
         for(int j=0; j<vecesPorNivel; j++)  
         {
           switch(nivelActual)
           {
             case(1): construirEscenario();break;
             case(2): construirEscenario();break;
           }
           new Cronometro(20).start();           
           while(!cronometro){try {Thread.sleep(200);} catch (InterruptedException ex) {}}           
           cronometro = false;
           validarNumeros();
         }        
         pasarSiguienteNivel();
       }
    } 
}
