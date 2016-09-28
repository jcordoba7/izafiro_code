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
public class Puzzle2 extends javax.swing.JFrame {

    private Icon[] instrucciones;
    private Icon[] posiciones;
    private Icon dano;
    private JTextField[] camposNumerador;
    private JTextField[] camposDenominador;
    private JLabel[][] cuadros;
    private JLabel[] truenos;
    private boolean corriendo = false;
    private boolean cronometro;
    private boolean movimientoRealizado = false;
    private int cont = 1;
    private int numNiveles = 4;
    private int nivelActual = 1;
    private int vecesPorNivel = 4;
    private int numerador;
    private int denominador;
    private int numeradorAnterior = 0;
    private int denominadorAnterior = 0;
    private int respCorrecta = 2;
    private int respCorrectaAnterior = 2;
    private int zonaActual = 3;
    private int puntaje = 0;
    private int puntosPorNivel = 5;
    private double calificacionMinima = 0.75;
    
    /**
     * Creates new form Puzzle2
     */
    public Puzzle2() {
        initComponents();
        this.setLocationRelativeTo(null); this.setIconImage(new ImageIcon (getClass().getResource("izafiroicono.png")).getImage()); Sonidos.getInstance().activarCursor(this);      
        
        instrucciones = new Icon[12];
        instrucciones[0] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle2/instrucciones/1.png"));
        instrucciones[1] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle2/instrucciones/2.png"));
        instrucciones[2] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle2/instrucciones/3.png"));
        instrucciones[3] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle2/instrucciones/4.png"));
        instrucciones[4] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle2/instrucciones/5.png"));
        instrucciones[5] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle2/instrucciones/6.png"));
        instrucciones[6] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle2/instrucciones/7.png"));
        instrucciones[7] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle2/instrucciones/8.png"));
        instrucciones[8] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle2/instrucciones/9.png"));
        instrucciones[9] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle2/instrucciones/10.png"));
        instrucciones[10] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle2/instrucciones/11.png"));
        instrucciones[11] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle2/instrucciones/12.png"));
        
        String personaje = GestorJuego.getInstance().getGenero();
        dano = new ImageIcon (getClass().getResource("imagenes/personajes/tahi/"+personaje+"0.png"));
         
        posiciones = new Icon[5];
        posiciones[0] = new ImageIcon (getClass().getResource("imagenes/personajes/tahi/"+personaje+"11.png"));
        posiciones[1] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle2/"+personaje+"/1.gif"));
        posiciones[2] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle2/"+personaje+"/2.gif"));
        posiciones[3] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle2/"+personaje+"/3.gif"));
        posiciones[4] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle2/"+personaje+"/4.gif"));
        
        tahi.setIcon(posiciones[0]);        
        
        camposNumerador = new JTextField[5];
        camposNumerador[0] = cn1;
        camposNumerador[1] = cn2;
        camposNumerador[2] = cn3;
        camposNumerador[3] = cn4;
        camposNumerador[4] = cn5;
        
        camposDenominador = new JTextField[5];
        camposDenominador[0] = cd1;
        camposDenominador[1] = cd2;
        camposDenominador[2] = cd3;
        camposDenominador[3] = cd4;
        camposDenominador[4] = cd5;   
        
        truenos = new JLabel[5];
        truenos[0] = trueno1;
        truenos[1] = trueno2;
        truenos[2] = trueno3;
        truenos[3] = trueno4;
        truenos[4] = trueno5;
        
        cuadros = new JLabel[2][6];        
        cuadros[0][0] = c1;
        cuadros[0][1] = c2;
        cuadros[0][2] = c3;
        cuadros[0][3] = c4;
        cuadros[0][4] = c5;
        cuadros[0][5] = c6;
        cuadros[1][0] = c7;
        cuadros[1][1] = c8;
        cuadros[1][2] = c9;
        cuadros[1][3] = c10;
        cuadros[1][4] = c11;
        cuadros[1][5] = c12;
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
      for(int i=0; i<camposNumerador.length; i++)
      {
        camposNumerador[i].setText("");
        camposDenominador[i].setText("");     
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
       numerador = 0;
       denominador = 8;
       
       while(numerador == 0 || numerador == numeradorAnterior){
         numerador = randomGenerator.nextInt(denominador);
       }
       numeradorAnterior = numerador;   
       
       mostrarRepGrafica();
    }
    
    public void generarFraccion2() //solo cambia el numerador, el denominador es 6
    {      
       Random randomGenerator = new Random();
       numerador = 0;
       denominador = 8;
       
       while(numerador == 0 || numerador == numeradorAnterior){
         numerador = randomGenerator.nextInt(denominador);
       }
       numeradorAnterior = numerador;
              
       mostrarRepGrafica2();
    }
    
    public void generarFraccion3()
    {
       Random randomGenerator = new Random();
       numerador = 0;
       denominador = 0;
       
       while(denominador == 0 || denominador%2 != 0 || denominador == denominadorAnterior){
         denominador = randomGenerator.nextInt(13);
       }
       while(numerador == 0){ //no es posible evitar numerador repetitivo por q hay posibilidad de un bucle
         numerador = randomGenerator.nextInt(denominador+1);
       }
       denominadorAnterior = denominador;     
       mostrarRepGrafica2();
    }
    
    public void mostrarRepGrafica()
    {
       Random randomGenerator = new Random();
       int color = randomGenerator.nextInt(7);
       
       int contador = 0;
       
       for(int i=0; i<cuadros.length; i++)
       {
         for(int j = 0; j<denominador/2; j++)
         {
            cuadros[i][j].setSize(cuadros[i][j].getPreferredSize()); 
            
            if(contador <numerador)
            {
              switch(color)
              {
                case 0: cuadros[i][j].setBackground(Color.lightGray);break;
                case 1: cuadros[i][j].setBackground(Color.blue);break;
                case 2: cuadros[i][j].setBackground(Color.green);break;
                case 3: cuadros[i][j].setBackground(Color.magenta);break;
                case 4: cuadros[i][j].setBackground(Color.orange);break;
                case 5: cuadros[i][j].setBackground(Color.yellow);break;
                case 6: cuadros[i][j].setBackground(Color.red);break;
              }
            }
            contador++;
         }
       }
       generarOpciones();
    }
    
    public void mostrarRepGrafica2()
    {
       Random randomGenerator = new Random();
       int color = randomGenerator.nextInt(7);
              
       for(int i=0; i<cuadros.length; i++)
       {
         for(int j = 0; j<denominador/2; j++)
         {
            cuadros[i][j].setSize(cuadros[i][j].getPreferredSize());            
         }
       }
       
       switch(color)
       {
         case 0: elegirCuadros(Color.lightGray);break;
         case 1: elegirCuadros(Color.blue);break;
         case 2: elegirCuadros(Color.green);break;
         case 3: elegirCuadros(Color.magenta);break;
         case 4: elegirCuadros(Color.orange);break;
         case 5: elegirCuadros(Color.yellow);break;
         case 6: elegirCuadros(Color.red);break;
       }        
       generarOpciones();
    }
    
    public void elegirCuadros(Color c)
    {
       Random randomGenerator = new Random();
       int fila1 = randomGenerator.nextInt((denominador/2)+1);
       int fila2 = randomGenerator.nextInt((denominador/2)+1);
       
       while(fila1 + fila2 != numerador)
       {
         fila1 = randomGenerator.nextInt((denominador/2)+1);  
         fila2 = randomGenerator.nextInt((denominador/2)+1);
       }
       
       int[] cuadrosFila1 = new int [fila1];
       int[] cuadrosFila2 = new int [fila2];
       for(int i=0; i<cuadrosFila1.length; i++){cuadrosFila1[i] = -1;}
       for(int i=0; i<cuadrosFila2.length; i++){cuadrosFila2[i] = -1;}
       
       
       for(int i=0; i<cuadrosFila1.length; i++)
       {
          int pos = randomGenerator.nextInt(denominador/2);
          while(esRepetido(cuadrosFila1,pos))
          {
             pos = randomGenerator.nextInt(denominador/2); 
          }
          cuadrosFila1[i] = pos;
          cuadros[0][pos].setBackground(c);
       }
       
       for(int i=0; i<cuadrosFila2.length; i++)
       {
          int pos = randomGenerator.nextInt(denominador/2);
          while(esRepetido(cuadrosFila2,pos))
          {
             pos = randomGenerator.nextInt(denominador/2); 
          }
          cuadrosFila2[i] = pos;
          cuadros[1][pos].setBackground(c);
       }
    }
    
    public void generarOpciones()
    {
        int numeradores[] = new int[5];
        int denominadores[] = new int[5];
        
        for (int i = 0; i < numeradores.length; i++) {numeradores[i] = -1;denominadores[i] = -1;} //Inicializo el vector en -1 para evitar problemas con el indice 0.
       
        Random randomGenerator = new Random(); 
           
        respCorrectaAnterior = respCorrecta;
        
        respCorrecta = randomGenerator.nextInt(numeradores.length);
        
        while(respCorrecta == respCorrectaAnterior)
        {
          respCorrecta = randomGenerator.nextInt(numeradores.length); 
        }      
        
        numeradores[respCorrecta] = numerador;
        denominadores[respCorrecta] = denominador;
        
        int den;
        int num;
        
        for(int i=0; i<numeradores.length; i++)
        {           
           if(numeradores[i] == -1)
           {
             den = randomGenerator.nextInt(12);
             while(den < 3)
             {
               den = randomGenerator.nextInt(12);   
             }
             num = randomGenerator.nextInt(den);  
             while( num == 0)
             {
               num = randomGenerator.nextInt(den); 
             }
             
             while(fraccionRepetida(num,den,numeradores,denominadores))
             {
                den = randomGenerator.nextInt(12);
                while(den < 3)
                {
                  den = randomGenerator.nextInt(12);   
                }
                num = randomGenerator.nextInt(den);  
                while( num == 0)
                {
                  num = randomGenerator.nextInt(den); 
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
    
    public void limpiarCuadros()
    {
       for(int i=0; i<cuadros.length; i++)
       {
         for(int j = 0; j<denominador/2; j++)
         {
            cuadros[i][j].setSize(0,0);
            cuadros[i][j].setBackground(Color.white);
         }
       }
    }
    
    public void mostrarTruenos()
    {
       reloj.setSize(0,0);
        
       Sonidos.getInstance().reproducir("trueno");
       for(int i=0; i<truenos.length; i++)
       {
         if(i != respCorrecta)
         {
           truenos[i].setSize(truenos[i].getPreferredSize());
         }
       } 
       if( zonaActual-1 != respCorrecta){new Dano().start();}
    }
    
    public void esconderTruenos()
    {
       for(int i=0; i<truenos.length; i++)
       {
         if(i != respCorrecta)
         {
           truenos[i].setSize(0,0);
         }
       }   
       reloj.setSize(reloj.getPreferredSize());
    }
    
    public void desplazarPersonaje(int zona)
    {    
       if(!corriendo)
       {       
        new Movimiento(zona).start(); 
       }       
    }
    
    public void validarNumeros()
    {
        if( zonaActual-1 == respCorrecta)
        {
            Sonidos.getInstance().reproducir("success1"); 
            JOptionPane.showMessageDialog(null, "BIEN!!!\nTienes +"+ puntosPorNivel +" puntos!!", "Correcto", JOptionPane.PLAIN_MESSAGE, new ImageIcon (getClass().getResource("imagenes/objetos/check.png")));         
            aumentarPuntaje(); 
        }
        else
        {
            //new Dano().start();
            Sonidos.getInstance().reproducir("error");
            JOptionPane.showMessageDialog(null, "Vaya...  :( \nTe has equivocado o no has\nsido lo suficientemente rápido!","Mensaje",0);
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
                PruebaPuzzle.getInstance().cerrarActividad(this,puntaje);
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
        else
        {
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
        jLabel6 = new javax.swing.JLabel();
        reloj = new javax.swing.JTextField();
        campoPuntaje = new javax.swing.JTextField();
        trueno5 = new javax.swing.JLabel();
        trueno4 = new javax.swing.JLabel();
        trueno3 = new javax.swing.JLabel();
        trueno2 = new javax.swing.JLabel();
        trueno1 = new javax.swing.JLabel();
        opcion5 = new javax.swing.JToggleButton();
        opcion4 = new javax.swing.JToggleButton();
        opcion3 = new javax.swing.JToggleButton();
        opcion2 = new javax.swing.JToggleButton();
        opcion1 = new javax.swing.JToggleButton();
        cn1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cd1 = new javax.swing.JTextField();
        cn5 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cd5 = new javax.swing.JTextField();
        cn4 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cd4 = new javax.swing.JTextField();
        cn3 = new javax.swing.JTextField();
        cd3 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cn2 = new javax.swing.JTextField();
        cd2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        c1 = new javax.swing.JLabel();
        c2 = new javax.swing.JLabel();
        c3 = new javax.swing.JLabel();
        c4 = new javax.swing.JLabel();
        c5 = new javax.swing.JLabel();
        c6 = new javax.swing.JLabel();
        c7 = new javax.swing.JLabel();
        c8 = new javax.swing.JLabel();
        c9 = new javax.swing.JLabel();
        c10 = new javax.swing.JLabel();
        c11 = new javax.swing.JLabel();
        c12 = new javax.swing.JLabel();
        SalirBtn = new javax.swing.JToggleButton();
        iniciarBtn = new javax.swing.JToggleButton();
        instruccionesBtn = new javax.swing.JToggleButton();
        tahi = new javax.swing.JLabel();
        flecha = new javax.swing.JLabel();
        flecha2 = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("iZafiro - Cima del Trueno");
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

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Puntaje");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 20, 90, 20));

        reloj.setEditable(false);
        reloj.setBackground(new java.awt.Color(0, 0, 0));
        reloj.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        reloj.setForeground(new java.awt.Color(255, 0, 0));
        reloj.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        reloj.setText("0");
        reloj.setPreferredSize(new java.awt.Dimension(100, 70));
        getContentPane().add(reloj, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 0, 0));

        campoPuntaje.setEditable(false);
        campoPuntaje.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        campoPuntaje.setForeground(new java.awt.Color(0, 0, 153));
        campoPuntaje.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoPuntaje.setText("0");
        getContentPane().add(campoPuntaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 10, 50, 40));

        trueno5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/puzzle/puzzle2/trueno.png"))); // NOI18N
        getContentPane().add(trueno5, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, -40, 0, 0));

        trueno4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/puzzle/puzzle2/trueno.png"))); // NOI18N
        getContentPane().add(trueno4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, -20, 0, 0));

        trueno3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/puzzle/puzzle2/trueno.png"))); // NOI18N
        getContentPane().add(trueno3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, -10, 0, 0));

        trueno2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/puzzle/puzzle2/trueno.png"))); // NOI18N
        getContentPane().add(trueno2, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, -10, 0, 0));

        trueno1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/puzzle/puzzle2/trueno.png"))); // NOI18N
        getContentPane().add(trueno1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, -90, 0, 0));

        opcion5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        opcion5.setForeground(new java.awt.Color(0, 0, 204));
        opcion5.setText("^");
        opcion5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        opcion5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcion5ActionPerformed(evt);
            }
        });
        getContentPane().add(opcion5, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 450, -1, 40));

        opcion4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        opcion4.setForeground(new java.awt.Color(0, 0, 204));
        opcion4.setText("^");
        opcion4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        opcion4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcion4ActionPerformed(evt);
            }
        });
        getContentPane().add(opcion4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 450, -1, 40));

        opcion3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        opcion3.setForeground(new java.awt.Color(0, 0, 204));
        opcion3.setText("^");
        opcion3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        opcion3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcion3ActionPerformed(evt);
            }
        });
        getContentPane().add(opcion3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 450, -1, 40));

        opcion2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        opcion2.setForeground(new java.awt.Color(0, 0, 204));
        opcion2.setText("^");
        opcion2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        opcion2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcion2ActionPerformed(evt);
            }
        });
        getContentPane().add(opcion2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 450, -1, 40));

        opcion1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        opcion1.setForeground(new java.awt.Color(0, 0, 204));
        opcion1.setText("^");
        opcion1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        opcion1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcion1ActionPerformed(evt);
            }
        });
        getContentPane().add(opcion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, -1, 40));

        cn1.setEditable(false);
        cn1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        cn1.setForeground(new java.awt.Color(0, 102, 0));
        cn1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(cn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 50, 40));

        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 153), 3));
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 177, 65, 6));

        cd1.setEditable(false);
        cd1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        cd1.setForeground(new java.awt.Color(0, 102, 0));
        cd1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(cd1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 50, 40));

        cn5.setEditable(false);
        cn5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        cn5.setForeground(new java.awt.Color(0, 102, 0));
        cn5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(cn5, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 200, 50, 40));

        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 153), 3));
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(472, 247, 65, 6));

        cd5.setEditable(false);
        cd5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        cd5.setForeground(new java.awt.Color(0, 102, 0));
        cd5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(cd5, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 260, 50, 40));

        cn4.setEditable(false);
        cn4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        cn4.setForeground(new java.awt.Color(0, 102, 0));
        cn4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(cn4, new org.netbeans.lib.awtextra.AbsoluteConstraints(363, 240, 50, 40));

        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 153), 3));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 287, 65, 6));

        cd4.setEditable(false);
        cd4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        cd4.setForeground(new java.awt.Color(0, 102, 0));
        cd4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(cd4, new org.netbeans.lib.awtextra.AbsoluteConstraints(363, 300, 50, 40));

        cn3.setEditable(false);
        cn3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        cn3.setForeground(new java.awt.Color(0, 102, 0));
        cn3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(cn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 240, 50, 40));

        cd3.setEditable(false);
        cd3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        cd3.setForeground(new java.awt.Color(0, 102, 0));
        cd3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(cd3, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 300, 50, 40));

        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 153), 3));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(247, 287, 65, 6));

        cn2.setEditable(false);
        cn2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        cn2.setForeground(new java.awt.Color(0, 102, 0));
        cn2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(cn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, 50, 40));

        cd2.setEditable(false);
        cd2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        cd2.setForeground(new java.awt.Color(0, 102, 0));
        cd2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(cd2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 300, 50, 40));

        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 153), 3));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 287, 65, 6));

        c1.setBackground(new java.awt.Color(255, 255, 255));
        c1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        c1.setOpaque(true);
        c1.setPreferredSize(new java.awt.Dimension(42, 42));
        getContentPane().add(c1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 0, 0));

        c2.setBackground(new java.awt.Color(255, 255, 255));
        c2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        c2.setOpaque(true);
        c2.setPreferredSize(new java.awt.Dimension(42, 42));
        getContentPane().add(c2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, 0, 0));

        c3.setBackground(new java.awt.Color(255, 255, 255));
        c3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        c3.setOpaque(true);
        c3.setPreferredSize(new java.awt.Dimension(42, 42));
        getContentPane().add(c3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 0, 0));

        c4.setBackground(new java.awt.Color(255, 255, 255));
        c4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        c4.setOpaque(true);
        c4.setPreferredSize(new java.awt.Dimension(42, 42));
        getContentPane().add(c4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, 0, 0));

        c5.setBackground(new java.awt.Color(255, 255, 255));
        c5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        c5.setOpaque(true);
        c5.setPreferredSize(new java.awt.Dimension(42, 42));
        getContentPane().add(c5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, 0, 0));

        c6.setBackground(new java.awt.Color(255, 255, 255));
        c6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        c6.setOpaque(true);
        c6.setPreferredSize(new java.awt.Dimension(42, 42));
        getContentPane().add(c6, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 0, 0));

        c7.setBackground(new java.awt.Color(255, 255, 255));
        c7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        c7.setOpaque(true);
        c7.setPreferredSize(new java.awt.Dimension(42, 42));
        getContentPane().add(c7, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, 0, 0));

        c8.setBackground(new java.awt.Color(255, 255, 255));
        c8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        c8.setOpaque(true);
        c8.setPreferredSize(new java.awt.Dimension(42, 42));
        getContentPane().add(c8, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, 0, 0));

        c9.setBackground(new java.awt.Color(255, 255, 255));
        c9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        c9.setOpaque(true);
        c9.setPreferredSize(new java.awt.Dimension(42, 42));
        getContentPane().add(c9, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, 0, 0));

        c10.setBackground(new java.awt.Color(255, 255, 255));
        c10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        c10.setOpaque(true);
        c10.setPreferredSize(new java.awt.Dimension(42, 42));
        getContentPane().add(c10, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 50, 0, 0));

        c11.setBackground(new java.awt.Color(255, 255, 255));
        c11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        c11.setOpaque(true);
        c11.setPreferredSize(new java.awt.Dimension(42, 42));
        getContentPane().add(c11, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 50, 0, 0));

        c12.setBackground(new java.awt.Color(255, 255, 255));
        c12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        c12.setOpaque(true);
        c12.setPreferredSize(new java.awt.Dimension(42, 42));
        getContentPane().add(c12, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 50, 0, 0));

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
        getContentPane().add(SalirBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 110, -1));

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
        getContentPane().add(iniciarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 110, -1));

        instruccionesBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        instruccionesBtn.setForeground(new java.awt.Color(0, 102, 0));
        instruccionesBtn.setText("Instrucciones");
        instruccionesBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        instruccionesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                instruccionesBtnActionPerformed(evt);
            }
        });
        getContentPane().add(instruccionesBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        tahi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/personajes/tahi/tahi11.png"))); // NOI18N
        getContentPane().add(tahi, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 350, -1, -1));

        flecha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/objetos/flechapuzzle.gif"))); // NOI18N
        getContentPane().add(flecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, -1, -1));

        flecha2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/objetos/flechapuzzle.gif"))); // NOI18N
        getContentPane().add(flecha2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 0, 0));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/puzzle/puzzle2/fondo.png"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void opcion1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcion1ActionPerformed
        // TODO add your handling code here:
        desplazarPersonaje(1);
    }//GEN-LAST:event_opcion1ActionPerformed

    private void opcion2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcion2ActionPerformed
        // TODO add your handling code here:
        desplazarPersonaje(2);
    }//GEN-LAST:event_opcion2ActionPerformed

    private void opcion3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcion3ActionPerformed
        // TODO add your handling code here:
        desplazarPersonaje(3);
    }//GEN-LAST:event_opcion3ActionPerformed

    private void opcion4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcion4ActionPerformed
        // TODO add your handling code here:
        desplazarPersonaje(4);
    }//GEN-LAST:event_opcion4ActionPerformed

    private void opcion5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcion5ActionPerformed
        // TODO add your handling code here:
        desplazarPersonaje(5);
    }//GEN-LAST:event_opcion5ActionPerformed

    private void iniciarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iniciarBtnActionPerformed
        // TODO add your handling code here:        
        if(cuadroDialogo.getSize().width == 0){this.flecha.setSize(0,0);iniciarPuzzle();}
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
            this.setVisible(false);
            this.dispose();
            
            AdministradorConsultasSQL ad = new AdministradorConsultasSQL();  
            ad.guardarPartida();
            
            if(GestorJuego.getInstance().getvJF() != null)
            {
              Teclado.getInstace().setPausa(false);
              GestorJuego.getInstance().cerrarPartida();
            }
          
            try {
              new TablaPuntaje3().setVisible(true);  
            } catch (SQLException ex) {
              Logger.getLogger(Puzzle2.class.getName()).log(Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(Puzzle2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Puzzle2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Puzzle2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Puzzle2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Puzzle2().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton SalirBtn;
    private javax.swing.JLabel anterior;
    private javax.swing.JLabel c1;
    private javax.swing.JLabel c10;
    private javax.swing.JLabel c11;
    private javax.swing.JLabel c12;
    private javax.swing.JLabel c2;
    private javax.swing.JLabel c3;
    private javax.swing.JLabel c4;
    private javax.swing.JLabel c5;
    private javax.swing.JLabel c6;
    private javax.swing.JLabel c7;
    private javax.swing.JLabel c8;
    private javax.swing.JLabel c9;
    private javax.swing.JTextField campoPuntaje;
    private javax.swing.JTextField cd1;
    private javax.swing.JTextField cd2;
    private javax.swing.JTextField cd3;
    private javax.swing.JTextField cd4;
    private javax.swing.JTextField cd5;
    private javax.swing.JTextField cn1;
    private javax.swing.JTextField cn2;
    private javax.swing.JTextField cn3;
    private javax.swing.JTextField cn4;
    private javax.swing.JTextField cn5;
    private javax.swing.JLabel cuadroDialogo;
    private javax.swing.JLabel flecha;
    private javax.swing.JLabel flecha2;
    private javax.swing.JLabel fondo;
    private javax.swing.JToggleButton iniciarBtn;
    private javax.swing.JToggleButton instruccionesBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JToggleButton opcion1;
    private javax.swing.JToggleButton opcion2;
    private javax.swing.JToggleButton opcion3;
    private javax.swing.JToggleButton opcion4;
    private javax.swing.JToggleButton opcion5;
    private javax.swing.JTextField reloj;
    private javax.swing.JLabel siguiente;
    private javax.swing.JLabel tahi;
    private javax.swing.JLabel trueno1;
    private javax.swing.JLabel trueno2;
    private javax.swing.JLabel trueno3;
    private javax.swing.JLabel trueno4;
    private javax.swing.JLabel trueno5;
    // End of variables declaration//GEN-END:variables
    
    
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
             case(3): generarFraccion3();break;
             case(4): generarFraccion3();break;    
           }
           reloj.setSize(reloj.getPreferredSize());
           new Cronometro().start();   
           
           while(!cronometro)
           {
              try { Thread.sleep(50); } catch (InterruptedException ex) {}
           }  
           
           cronometro = false;
           
           mostrarTruenos();
           
           try { Thread.sleep(900); } catch (InterruptedException ex) {}
           
           esconderTruenos();
           validarNumeros();          
           limpiarCuadros();
           reloj.setSize(0,0);
         }        
         pasarSiguienteNivel();
       }
    } 
    
    public class Cronometro extends Thread
    {  
       @Override
       public void run()
       {         
         for(int i=15; i>=0; i--)
         {  
           try { Thread.sleep(1000); } catch (InterruptedException ex) {}
           reloj.setText(i+"");
           if(movimientoRealizado){break;}
         } 
         
         while(corriendo)
         {
             try { Thread.sleep(50); } catch (InterruptedException ex) {}
         }
         
         cronometro = true;
         movimientoRealizado = false;
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
          moverAbajo(400);
          tahi.setIcon(posiciones[0]);      
          int zonaAnt = zonaActual;
          zonaActual = -1;
          
          switch(zona)
          {              
            case 1: zona1(zonaAnt); break;
            case 2: zona2(zonaAnt); break;
            case 3: zona3(zonaAnt); break;
            case 4: zona4(zonaAnt); break;
            case 5: zona5(zonaAnt); break;  
          }        
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
               Thread.sleep(30);
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
                Thread.sleep(30);
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
               Thread.sleep(30);
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
               Thread.sleep(30);
              } catch (InterruptedException ex) {}            
            }
          } 
       }
       
       public void zona1(int zonaAnt)
       {
         moverIzquierda(20); 
         moverArriba(270);         
         tahi.setIcon(posiciones[0]);
       }
       
       public void zona2(int zonaAnt)
       {
         if(zonaAnt < 2){ moverDerecha(130); }
         else{ moverIzquierda(130); }
         moverArriba(340);
         tahi.setIcon(posiciones[0]);
       }
       
       public void zona3(int zonaAnt)
       {
         if(zonaAnt < 3){ moverDerecha(260); }
         else{ moverIzquierda(260); }
         moverArriba(350);
         tahi.setIcon(posiciones[0]);
       }
       
       public void zona4(int zonaAnt)
       {
         if(zonaAnt < 4){ moverDerecha(370); }
         else{ moverIzquierda(370); }
         moverArriba(340);
         tahi.setIcon(posiciones[0]);
       }
       
       public void zona5(int zonaAnt)
       {   
         moverDerecha(490);         
         moverArriba(320);
         tahi.setIcon(posiciones[0]);
       }
    }
    
    public class Dano extends Thread
    {
       @Override
       public void run()
       {
          Icon icon = tahi.getIcon();
          tahi.setIcon(dano);  
          Sonidos.getInstance().reproducir("dano");
          try { Thread.sleep(1200); } catch (InterruptedException ex) {}
          tahi.setIcon(icon);
       }
    }

}
