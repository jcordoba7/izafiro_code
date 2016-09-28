/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package izafiro;

import java.awt.Point;
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
public class Puzzle7 extends javax.swing.JFrame {

    private Icon[] instrucciones;
    private Icon[] posiciones;
    private Icon[] posicionesSoldado;
    private Icon dano;
    private JTextField[] camposNumerador1;
    private JTextField[] camposDenominador1;
    private JTextField[] camposNumerador2;
    private JTextField[] camposDenominador2;
    private MovimientoSoldado[] ms;
    private boolean corriendo = false;
    private boolean siguienteFr = false;
    private boolean cronometro;
    private boolean descubierto = false;
    private boolean poderMover = true;
    private boolean movimientoRealizado = false;
    private int cont = 1;
    private int numNiveles = 2;
    private int nivelActual = 1;
    private int vecesPorNivel = 4;
    private int numerador;
    private int denominador;
    private int numeradorEquivalente;
    private int denominadorEquivalente;
    private int numeradorAnterior = 0;
    private int denominadorAnterior = 0;
    private int respCorrecta = 0;
    private int respCorrectaAnterior = 0;
    private int zonaActual = 1;
    private int puntaje = 0;
    private int puntosPorNivel = 5;
    private double calificacionMinima = 0.75;
    
    //AudioClip rio;
    
    
    /**
     * Creates new form Puzzle7
     */
    public Puzzle7() {
        initComponents();
        this.setLocationRelativeTo(null); this.setIconImage(new ImageIcon (getClass().getResource("izafiroicono.png")).getImage()); Sonidos.getInstance().activarCursor(this);
        
        instrucciones = new Icon[17];
        instrucciones[0] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle7/instrucciones/1.png"));
        instrucciones[1] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle7/instrucciones/2.png"));
        instrucciones[2] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle7/instrucciones/3.png"));
        instrucciones[3] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle7/instrucciones/4.png"));
        instrucciones[4] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle7/instrucciones/5.png"));
        instrucciones[5] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle7/instrucciones/6.png"));
        instrucciones[6] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle7/instrucciones/7.png"));
        instrucciones[7] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle7/instrucciones/8.png"));
        instrucciones[8] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle7/instrucciones/9.png"));
        instrucciones[9] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle7/instrucciones/10.png"));
        instrucciones[10] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle7/instrucciones/11.png"));
        instrucciones[11] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle7/instrucciones/12.png"));
        instrucciones[12] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle7/instrucciones/13.png"));
        instrucciones[13] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle7/instrucciones/14.png"));
        instrucciones[14] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle7/instrucciones/15.png"));
        instrucciones[15] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle7/instrucciones/16.png"));
        instrucciones[16] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle7/instrucciones/17.png"));
        
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
        
        camposNumerador1 = new JTextField[4];
        camposNumerador1[0] = numerador1;
        camposNumerador1[1] = numerador2;
        camposNumerador1[2] = numerador3;
        camposNumerador1[3] = numerador4;
        
        camposDenominador1 = new JTextField[4];
        camposDenominador1[0] = denominador1;
        camposDenominador1[1] = denominador2;
        camposDenominador1[2] = denominador3;
        camposDenominador1[3] = denominador4;  
        
        camposNumerador2 = new JTextField[4];
        camposNumerador2[0] = numerador5;
        camposNumerador2[1] = numerador6;
        camposNumerador2[2] = numerador7;
        camposNumerador2[3] = numerador8;
        
        camposDenominador2 = new JTextField[4];
        camposDenominador2[0] = denominador5;
        camposDenominador2[1] = denominador6;
        camposDenominador2[2] = denominador7;
        camposDenominador2[3] = denominador8;  
         
        
        //rio = Sonidos.getInstance().getRio();
        Sonidos.getInstance().reproducirLoop("rio");
        
        
        ms = new MovimientoSoldado[4];  
        ms[0] = new MovimientoSoldado("horizontal",0,560,soldado1);
        ms[1] = new MovimientoSoldado("vertical",0,466,soldado2);        
        ms[2] = new MovimientoSoldado("vertical",0,466,soldado3);
        ms[3] = new MovimientoSoldado("horizontal",0,560,soldado4);
        
        for (int i = 0; i < ms.length; i++) {ms[i].start();}
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
    
    public void ocultarInstrucciones()
    {
      this.cuadroDialogo.setSize(0,0);
      this.siguiente.setSize(0,0); 
      this.anterior.setSize(0,0);
      this.flecha2.setSize(flecha2.getPreferredSize());
    }
    
    public void iniciarPuzzle()
    { 
      this.flecha.setSize(0,0); 
      this.flecha2.setSize(0,0);
      new Nivel().start();
         
      iniciarBtn.setSize(0,0);
      instruccionesBtn.setSize(0,0);
      SalirBtn.setSize(0,0);
    }
    
    public void limpiarFracciones()
    {
      for(int i=0; i<camposNumerador1.length; i++)
      {  
        camposNumerador1[i].setText("");
        camposDenominador1[i].setText("");
        camposNumerador2[i].setText("");
        camposDenominador2[i].setText(""); 
      }      
    }
    
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
        int numeradores[] = new int[4];
        int denominadores[] = new int[4];
        
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
           camposNumerador1[i].setText(numeradores[i]+""); 
           camposDenominador1[i].setText(denominadores[i]+"");
        }
        
        for(int i=0; i<numeradores.length; i++)
        {
           camposNumerador2[i].setText(numerador+""); 
           camposDenominador2[i].setText(denominador+"");
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
        switch(respCorrecta)
        {
          case 0: ms[1].setCorrer(true); ms[3].setCorrer(true);
                  break;  
              
          case 1: ms[2].setCorrer(true); ms[3].setCorrer(true);
                  break; 
              
          case 2: ms[0].setCorrer(true); ms[1].setCorrer(true);
                  break; 
              
          case 3: ms[0].setCorrer(true); ms[2].setCorrer(true);
                  break; 
        }
    }
    
    
    public void desplazarPersonaje(int zona)
    {    
       if(!corriendo && poderMover)
       {       
         new Movimiento(zona).start(); 
       }       
    }
    
    
    public void validarNumeros()
    {
       poderMover = true;
       if( zonaActual-1 == respCorrecta && !descubierto)
       {
          Sonidos.getInstance().reproducir("success2");
          JOptionPane.showMessageDialog(null, "BIEN!!!\nTienes +"+ puntosPorNivel +" puntos!!", "Correcto", JOptionPane.PLAIN_MESSAGE, new ImageIcon (getClass().getResource("imagenes/objetos/check.png")));   
          aumentarPuntaje(); 
       }
       else{
          Sonidos.getInstance().reproducir("error");
          JOptionPane.showMessageDialog(null, "Vaya...  :( \nTe has equivocado o no has sido\nlo suficientemente rápido!","Mensaje",0);
       }       
    }
    
    public void aumentarPuntaje()
    {
       puntaje += puntosPorNivel;
       this.campoPuntaje.setText(puntaje+"");
    }  
    
    public void pasarSiguienteNivel()
    {
       if(nivelActual == numNiveles)
       {
         if(puntaje >= ((numNiveles*puntosPorNivel)*vecesPorNivel)*calificacionMinima)
         {
           Sonidos.getInstance().reproducir("nuevorecurso"); 
           JOptionPane.showMessageDialog(null, "Enhorabuena! ...\nHas completado la prueba con EXITO!!!","Correcto", JOptionPane.PLAIN_MESSAGE, new ImageIcon (getClass().getResource("imagenes/objetos/check.png"))); 
           JOptionPane.showMessageDialog(null, "Haz hecho un puntaje de "+ puntaje + "/" + ((numNiveles*puntosPorNivel)*vecesPorNivel) + " en este juego!! ...");
           Sonidos.getInstance().detener("rio");
           PruebaPuzzle.getInstance().cerrarActividad2(this,puntaje);
         }
         else
         {
           Sonidos.getInstance().reproducir("error");  
           JOptionPane.showMessageDialog(null, "Vaya ... tu puntaje no ha sido muy bueno. "+ puntaje + "/" + ((numNiveles*puntosPorNivel)*vecesPorNivel) + " \nAnimo! ... puedes hacerlo mejor!\nDa click en Iniciar para comenzar el nivel 1!");
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
         limpiarFracciones();
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
        SalirBtn = new javax.swing.JToggleButton();
        iniciarBtn = new javax.swing.JToggleButton();
        instruccionesBtn = new javax.swing.JToggleButton();
        jLabel4 = new javax.swing.JLabel();
        campoPuntaje = new javax.swing.JTextField();
        reloj = new javax.swing.JTextField();
        objeto4 = new javax.swing.JLabel();
        objeto3 = new javax.swing.JLabel();
        objeto1 = new javax.swing.JLabel();
        objeto2 = new javax.swing.JLabel();
        fuente1 = new javax.swing.JLabel();
        f1 = new javax.swing.JLabel();
        f2 = new javax.swing.JLabel();
        f3 = new javax.swing.JLabel();
        f4 = new javax.swing.JLabel();
        flecha = new javax.swing.JLabel();
        flecha2 = new javax.swing.JLabel();
        arboles = new javax.swing.JLabel();
        soldado1 = new javax.swing.JLabel();
        soldado2 = new javax.swing.JLabel();
        soldado3 = new javax.swing.JLabel();
        soldado4 = new javax.swing.JLabel();
        tahi = new javax.swing.JLabel();
        numerador1 = new javax.swing.JTextField();
        numerador2 = new javax.swing.JTextField();
        numerador3 = new javax.swing.JTextField();
        numerador4 = new javax.swing.JTextField();
        numerador5 = new javax.swing.JTextField();
        numerador6 = new javax.swing.JTextField();
        numerador7 = new javax.swing.JTextField();
        numerador8 = new javax.swing.JTextField();
        denominador1 = new javax.swing.JTextField();
        denominador2 = new javax.swing.JTextField();
        denominador3 = new javax.swing.JTextField();
        denominador4 = new javax.swing.JTextField();
        denominador5 = new javax.swing.JTextField();
        denominador6 = new javax.swing.JTextField();
        denominador7 = new javax.swing.JTextField();
        denominador8 = new javax.swing.JTextField();
        raya1 = new javax.swing.JLabel();
        raya2 = new javax.swing.JLabel();
        raya3 = new javax.swing.JLabel();
        raya4 = new javax.swing.JLabel();
        raya5 = new javax.swing.JLabel();
        raya6 = new javax.swing.JLabel();
        raya7 = new javax.swing.JLabel();
        raya8 = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("iZafiro - Jardín de Las Fuentes");
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
        getContentPane().add(siguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 70, 0, 0));

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
        getContentPane().add(cuadroDialogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 0, 0));

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
        getContentPane().add(SalirBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 110, -1));

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
        getContentPane().add(iniciarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 110, -1));

        instruccionesBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        instruccionesBtn.setForeground(new java.awt.Color(0, 102, 0));
        instruccionesBtn.setText("Instrucciones");
        instruccionesBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        instruccionesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                instruccionesBtnActionPerformed(evt);
            }
        });
        getContentPane().add(instruccionesBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Puntaje");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 20, 90, 20));

        campoPuntaje.setEditable(false);
        campoPuntaje.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        campoPuntaje.setForeground(new java.awt.Color(0, 0, 153));
        campoPuntaje.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoPuntaje.setText("0");
        getContentPane().add(campoPuntaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 10, 50, 40));

        reloj.setEditable(false);
        reloj.setBackground(new java.awt.Color(0, 0, 0));
        reloj.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        reloj.setForeground(new java.awt.Color(255, 0, 0));
        reloj.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        reloj.setText("0");
        getContentPane().add(reloj, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, 60));

        objeto4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/objetos/estatua1.png"))); // NOI18N
        objeto4.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(objeto4, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 50, 40, 70));

        objeto3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/objetos/estatua2.png"))); // NOI18N
        objeto3.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(objeto3, new org.netbeans.lib.awtextra.AbsoluteConstraints(478, 50, 40, 70));

        objeto1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/objetos/estatua1.png"))); // NOI18N
        getContentPane().add(objeto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 370, -1, -1));

        objeto2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/objetos/estatua2.png"))); // NOI18N
        getContentPane().add(objeto2, new org.netbeans.lib.awtextra.AbsoluteConstraints(478, 370, -1, -1));

        fuente1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/objetos/fuente.gif"))); // NOI18N
        getContentPane().add(fuente1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, -1, -1));

        f1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        f1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f1MouseClicked(evt);
            }
        });
        getContentPane().add(f1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 60, 70));

        f2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        f2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f2MouseClicked(evt);
            }
        });
        getContentPane().add(f2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 150, 60, 70));

        f3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        f3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f3MouseClicked(evt);
            }
        });
        getContentPane().add(f3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 320, 60, 70));

        f4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        f4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f4MouseClicked(evt);
            }
        });
        getContentPane().add(f4, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 320, 60, 70));

        flecha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/objetos/flechapuzzle.gif"))); // NOI18N
        getContentPane().add(flecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 430, -1, -1));

        flecha2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/objetos/flechapuzzle.gif"))); // NOI18N
        getContentPane().add(flecha2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 400, 0, 0));

        arboles.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/puzzle/puzzle7/arboles.png"))); // NOI18N
        getContentPane().add(arboles, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        soldado1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/personajes/soldado/detenido2.png"))); // NOI18N
        getContentPane().add(soldado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, -1, -1));

        soldado2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/personajes/soldado/detenido4.png"))); // NOI18N
        getContentPane().add(soldado2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, -1, -1));

        soldado3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/personajes/soldado/detenido1.png"))); // NOI18N
        getContentPane().add(soldado3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 466, -1, -1));

        soldado4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/personajes/soldado/detenido3.png"))); // NOI18N
        getContentPane().add(soldado4, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 370, -1, -1));

        tahi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/personajes/tahi/tahi2.png"))); // NOI18N
        getContentPane().add(tahi, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, -1, -1));

        numerador1.setEditable(false);
        numerador1.setBackground(new java.awt.Color(230, 230, 230));
        numerador1.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        numerador1.setForeground(new java.awt.Color(204, 0, 0));
        numerador1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        numerador1.setBorder(null);
        getContentPane().add(numerador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, 30, 30));

        numerador2.setEditable(false);
        numerador2.setBackground(new java.awt.Color(230, 230, 230));
        numerador2.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        numerador2.setForeground(new java.awt.Color(204, 0, 0));
        numerador2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        numerador2.setBorder(null);
        getContentPane().add(numerador2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 150, 30, 30));

        numerador3.setEditable(false);
        numerador3.setBackground(new java.awt.Color(230, 230, 230));
        numerador3.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        numerador3.setForeground(new java.awt.Color(204, 0, 0));
        numerador3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        numerador3.setBorder(null);
        getContentPane().add(numerador3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 320, 30, 30));

        numerador4.setEditable(false);
        numerador4.setBackground(new java.awt.Color(230, 230, 230));
        numerador4.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        numerador4.setForeground(new java.awt.Color(204, 0, 0));
        numerador4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        numerador4.setBorder(null);
        getContentPane().add(numerador4, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 320, 30, 30));

        numerador5.setEditable(false);
        numerador5.setBackground(new java.awt.Color(230, 230, 230));
        numerador5.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        numerador5.setForeground(new java.awt.Color(204, 0, 0));
        numerador5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        numerador5.setBorder(null);
        getContentPane().add(numerador5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 30, 30));

        numerador6.setEditable(false);
        numerador6.setBackground(new java.awt.Color(230, 230, 230));
        numerador6.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        numerador6.setForeground(new java.awt.Color(204, 0, 0));
        numerador6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        numerador6.setBorder(null);
        getContentPane().add(numerador6, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 150, 30, 30));

        numerador7.setEditable(false);
        numerador7.setBackground(new java.awt.Color(230, 230, 230));
        numerador7.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        numerador7.setForeground(new java.awt.Color(204, 0, 0));
        numerador7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        numerador7.setBorder(null);
        getContentPane().add(numerador7, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 320, 30, 30));

        numerador8.setEditable(false);
        numerador8.setBackground(new java.awt.Color(230, 230, 230));
        numerador8.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        numerador8.setForeground(new java.awt.Color(204, 0, 0));
        numerador8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        numerador8.setBorder(null);
        getContentPane().add(numerador8, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 320, 30, 30));

        denominador1.setEditable(false);
        denominador1.setBackground(new java.awt.Color(230, 230, 230));
        denominador1.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        denominador1.setForeground(new java.awt.Color(204, 0, 0));
        denominador1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        denominador1.setBorder(null);
        getContentPane().add(denominador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, 30, 30));

        denominador2.setEditable(false);
        denominador2.setBackground(new java.awt.Color(230, 230, 230));
        denominador2.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        denominador2.setForeground(new java.awt.Color(204, 0, 0));
        denominador2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        denominador2.setBorder(null);
        getContentPane().add(denominador2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 190, 30, 30));

        denominador3.setEditable(false);
        denominador3.setBackground(new java.awt.Color(230, 230, 230));
        denominador3.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        denominador3.setForeground(new java.awt.Color(204, 0, 0));
        denominador3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        denominador3.setBorder(null);
        getContentPane().add(denominador3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 360, 30, 30));

        denominador4.setEditable(false);
        denominador4.setBackground(new java.awt.Color(230, 230, 230));
        denominador4.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        denominador4.setForeground(new java.awt.Color(204, 0, 0));
        denominador4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        denominador4.setBorder(null);
        getContentPane().add(denominador4, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 360, 30, 30));

        denominador5.setEditable(false);
        denominador5.setBackground(new java.awt.Color(230, 230, 230));
        denominador5.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        denominador5.setForeground(new java.awt.Color(204, 0, 0));
        denominador5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        denominador5.setBorder(null);
        getContentPane().add(denominador5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 30, 30));

        denominador6.setEditable(false);
        denominador6.setBackground(new java.awt.Color(230, 230, 230));
        denominador6.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        denominador6.setForeground(new java.awt.Color(204, 0, 0));
        denominador6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        denominador6.setBorder(null);
        getContentPane().add(denominador6, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 190, 30, 30));

        denominador7.setEditable(false);
        denominador7.setBackground(new java.awt.Color(230, 230, 230));
        denominador7.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        denominador7.setForeground(new java.awt.Color(204, 0, 0));
        denominador7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        denominador7.setBorder(null);
        getContentPane().add(denominador7, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 360, 30, 30));

        denominador8.setEditable(false);
        denominador8.setBackground(new java.awt.Color(230, 230, 230));
        denominador8.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        denominador8.setForeground(new java.awt.Color(204, 0, 0));
        denominador8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        denominador8.setBorder(null);
        getContentPane().add(denominador8, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 360, 30, 30));

        raya1.setBackground(new java.awt.Color(0, 0, 204));
        raya1.setOpaque(true);
        getContentPane().add(raya1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 182, 30, 5));

        raya2.setBackground(new java.awt.Color(0, 0, 204));
        raya2.setOpaque(true);
        getContentPane().add(raya2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 182, 30, 5));

        raya3.setBackground(new java.awt.Color(0, 0, 204));
        raya3.setOpaque(true);
        getContentPane().add(raya3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 352, 30, 5));

        raya4.setBackground(new java.awt.Color(0, 0, 204));
        raya4.setOpaque(true);
        getContentPane().add(raya4, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 352, 30, 5));

        raya5.setBackground(new java.awt.Color(0, 0, 204));
        raya5.setOpaque(true);
        getContentPane().add(raya5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 182, 30, 5));

        raya6.setBackground(new java.awt.Color(0, 0, 204));
        raya6.setOpaque(true);
        getContentPane().add(raya6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 352, 30, 5));

        raya7.setBackground(new java.awt.Color(0, 0, 204));
        raya7.setOpaque(true);
        getContentPane().add(raya7, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 182, 30, 5));

        raya8.setBackground(new java.awt.Color(0, 0, 204));
        raya8.setOpaque(true);
        getContentPane().add(raya8, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 352, 30, 5));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/puzzle/puzzle7/fondo.png"))); // NOI18N
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

    private void f4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f4MouseClicked
        // TODO add your handling code here:
        desplazarPersonaje(4);
    }//GEN-LAST:event_f4MouseClicked

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
              Logger.getLogger(Puzzle7.class.getName()).log(Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(Puzzle7.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Puzzle7.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Puzzle7.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Puzzle7.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Puzzle7().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton SalirBtn;
    private javax.swing.JLabel anterior;
    private javax.swing.JLabel arboles;
    private javax.swing.JTextField campoPuntaje;
    private javax.swing.JLabel cuadroDialogo;
    private javax.swing.JTextField denominador1;
    private javax.swing.JTextField denominador2;
    private javax.swing.JTextField denominador3;
    private javax.swing.JTextField denominador4;
    private javax.swing.JTextField denominador5;
    private javax.swing.JTextField denominador6;
    private javax.swing.JTextField denominador7;
    private javax.swing.JTextField denominador8;
    private javax.swing.JLabel f1;
    private javax.swing.JLabel f2;
    private javax.swing.JLabel f3;
    private javax.swing.JLabel f4;
    private javax.swing.JLabel flecha;
    private javax.swing.JLabel flecha2;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel fuente1;
    private javax.swing.JToggleButton iniciarBtn;
    private javax.swing.JToggleButton instruccionesBtn;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField numerador1;
    private javax.swing.JTextField numerador2;
    private javax.swing.JTextField numerador3;
    private javax.swing.JTextField numerador4;
    private javax.swing.JTextField numerador5;
    private javax.swing.JTextField numerador6;
    private javax.swing.JTextField numerador7;
    private javax.swing.JTextField numerador8;
    private javax.swing.JLabel objeto1;
    private javax.swing.JLabel objeto2;
    private javax.swing.JLabel objeto3;
    private javax.swing.JLabel objeto4;
    private javax.swing.JLabel raya1;
    private javax.swing.JLabel raya2;
    private javax.swing.JLabel raya3;
    private javax.swing.JLabel raya4;
    private javax.swing.JLabel raya5;
    private javax.swing.JLabel raya6;
    private javax.swing.JLabel raya7;
    private javax.swing.JLabel raya8;
    private javax.swing.JTextField reloj;
    private javax.swing.JLabel siguiente;
    private javax.swing.JLabel soldado1;
    private javax.swing.JLabel soldado2;
    private javax.swing.JLabel soldado3;
    private javax.swing.JLabel soldado4;
    private javax.swing.JLabel tahi;
    // End of variables declaration//GEN-END:variables

    public class Cronometro extends Thread
    {  
       @Override
       public void run()
       {
         for(int i=30; i>=0; i--)
         {  
           try {
             Thread.sleep(1000);
           } catch (InterruptedException ex) {}
           reloj.setText(i+"");
           if(movimientoRealizado){break;}
         }
         while(corriendo){}
         cronometro = true;
         movimientoRealizado = false;
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
             case(2): generarFraccion1();break; 
           }
           
           new Cronometro().start();           
           while(!cronometro){try {Thread.sleep(100);} catch (InterruptedException ex) {}}           
           cronometro = false;          
           
           moverSoldados();
           
           while(!siguienteFr){}
           siguienteFr = false;
           
           //limpiarCuadros();
           validarNumeros();
           descubierto = false;
         }          
         pasarSiguienteNivel();
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
          corriendo = true; 
          tahi.setIcon(posiciones[0]);      
          int zonaAnt = zonaActual;
          zonaActual = -1;
          zonaActual = this.zona;
          
          switch(zona)
          {              
            case 1: zona1(zonaAnt); break;
            case 2: zona2(zonaAnt); break;
            case 3: zona3(zonaAnt); break;
            case 4: zona4(zonaAnt); break;  
          }
          tahi.setIcon(posiciones[0]);
          movimientoRealizado = true;
          corriendo = false;
       }
       
       public void moverIzquierda(int limite)
       {
          tahi.setIcon(posiciones[2]);    
          while(tahi.getX() > limite)
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
         moverIzquierda(160); 
         moverArriba(130);
       }
       
       public void zona2(int zonaAnt)
       {
         moverDerecha(430); 
         moverArriba(130);
       }
       
       public void zona3(int zonaAnt)
       {        
         moverIzquierda(160);
         moverAbajo(370);
       }
       
       public void zona4(int zonaAnt)
       {   
         moverDerecha(430);         
         moverAbajo(370);
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
        while(true)
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
            siguienteFr = true;
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
         yaDescubrio = false;        
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
             Icon icon = tahi.getIcon(); 
            
             Sonidos.getInstance().reproducir("dano");
           
             tahi.setIcon(dano);
             try { Thread.sleep(500); } catch (InterruptedException ex) {}
             tahi.setIcon(icon);
           
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
