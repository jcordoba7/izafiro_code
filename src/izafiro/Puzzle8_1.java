/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package izafiro;

import java.awt.Color;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Jonathan
 */
public class Puzzle8_1 extends javax.swing.JFrame {

    private Icon[] dialogo;
    private int cont = 1;
    private String clip1;
    private String clip2;
    private Icon dano;
    private Icon ataque;
    private Icon noAtaque;
    private Icon[] posicionesSaron;
    private Icon[] posicionesPersonaje;
    private JTextField[] camposUnidades;
    private JTextField[] camposNumerador;    
    private JTextField[] camposDenominador;
    private JLabel[] rayas;
    private JLabel[][] cuadros1;
    private JLabel[][] cuadros2;
    private JLabel[] truenos;
    private int unidad;
    private int unidadAnterior;
    private int numerador;
    private int denominador;
    private int tipoAnterior = -1;
    private int numeradorAnterior = 0;
    private int denominadorAnterior = 0;
    private int respCorrecta = 1;
    private int respCorrectaAnterior = 1;
    private int zonaActual = 2;
    private int numNiveles = 4;
    private int nivelActual = 1;
    private int nivelAnterior = numNiveles;
    private int vecesPorNivel = 3;  
    private int saludSirena = 6;
    private boolean corriendo = false;
    private boolean cronometro;
    private boolean atacando = false;
    private boolean movimientoRealizado = false;
    
    /**
     * Creates new form Puzzle8
     */
    public Puzzle8_1() {
        initComponents();
        this.setLocationRelativeTo(null); this.setIconImage(new ImageIcon (getClass().getResource("izafiroicono.png")).getImage()); Sonidos.getInstance().activarCursor(this);
        
        dialogo = new Icon[10];         
        dialogo[0] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle8/dialogobatalla/1.png"));
        dialogo[1] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle8/dialogobatalla/2.png"));
        dialogo[2] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle8/dialogobatalla/3.png"));
        dialogo[3] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle8/dialogobatalla/4.png"));
        dialogo[4] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle8/dialogobatalla/5.png"));
        dialogo[5] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle8/dialogobatalla/6.png"));
        dialogo[6] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle8/dialogobatalla/7.png"));
        dialogo[7] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle8/dialogobatalla/8.png"));
        dialogo[8] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle8/dialogobatalla/9.png"));
        dialogo[9] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle8/dialogobatalla/10.png"));
        
        clip1 = "rio";
        Sonidos.getInstance().reproducirLoop(clip1);
        
        clip2 = "boss";
        Sonidos.getInstance().reproducirLoop(clip2);
        
        GestorJuego.getInstance().setSalud2(5);
        salud.setIcon(new ImageIcon (getClass().getResource("imagenes/barra/salud"+GestorJuego.getInstance().getSalud()+".PNG")));
        
        if(GestorJuego.getInstance().getRecursos()[0]){recurso1.setIcon(new ImageIcon (getClass().getResource("imagenes/barra/recursos/recurso1.png")));}
        if(GestorJuego.getInstance().getRecursos()[1]){recurso2.setIcon(new ImageIcon (getClass().getResource("imagenes/barra/recursos/recurso2.png")));}
        if(GestorJuego.getInstance().getRecursos()[2]){recurso3.setIcon(new ImageIcon (getClass().getResource("imagenes/barra/recursos/recurso3.png")));}
        if(GestorJuego.getInstance().getRecursos()[3]){recurso4.setIcon(new ImageIcon (getClass().getResource("imagenes/barra/recursos/recurso4.png")));}
        if(GestorJuego.getInstance().getRecursos()[4]){recurso5.setIcon(new ImageIcon (getClass().getResource("imagenes/barra/recursos/recurso5.png")));}
        if(GestorJuego.getInstance().getRecursos()[5]){recurso6.setIcon(new ImageIcon (getClass().getResource("imagenes/barra/recursos/recurso6.png")));}
        
        
        posicionesSaron = new Icon[9];         
        posicionesSaron[0] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle8/saron0.png"));
        posicionesSaron[1] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle8/saron1.gif"));  
        posicionesSaron[2] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle8/saron2.gif"));  
        posicionesSaron[3] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle8/saron3.gif"));
        posicionesSaron[4] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle8/saron4.gif"));  
        posicionesSaron[5] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle8/saron5.gif"));  
        posicionesSaron[6] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle8/saron6.gif"));
        posicionesSaron[7] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle8/saron7.gif"));  
        posicionesSaron[8] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle8/saron8.gif"));
        
        posicionesPersonaje = new Icon[3];
        posicionesPersonaje[0] = new ImageIcon (getClass().getResource("imagenes/personajes/tahi/"+GestorJuego.getInstance().getGenero()+"11.png"));
        posicionesPersonaje[1] = new ImageIcon (getClass().getResource("imagenes/personajes/tahi/"+GestorJuego.getInstance().getGenero()+"10.png"));
        
        dano = new ImageIcon (getClass().getResource("imagenes/personajes/tahi/"+GestorJuego.getInstance().getGenero()+"0.png"));
        ataque = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle8/ataquesaron.gif"));
        noAtaque = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle8/noataque.png"));
        
        truenos = new JLabel[3];
        truenos[0] = rayo1;
        truenos[1] = rayo2;
        truenos[2] = rayo3;
        
        //---------------------------------------
        
        camposUnidades = new JTextField[3];
        camposUnidades[0] = unidades1;
        camposUnidades[1] = unidades2;
        camposUnidades[2] = unidades3;
        
        camposNumerador = new JTextField[3];
        camposNumerador[0] = campoNumerador1;
        camposNumerador[1] = campoNumerador2;
        camposNumerador[2] = campoNumerador3;
                
        camposDenominador = new JTextField[3];
        camposDenominador[0] = campoDenominador1;
        camposDenominador[1] = campoDenominador2;
        camposDenominador[2] = campoDenominador3;
        
        rayas = new JLabel[3];
        rayas[0] = raya1;
        rayas[1] = raya2;
        rayas[2] = raya3;
        
        //-----------------------------------------
        
        cuadros1 = new JLabel[2][6];        
        cuadros1[0][0] = c1;
        cuadros1[0][1] = c2;
        cuadros1[0][2] = c3;
        cuadros1[0][3] = c4;
        cuadros1[0][4] = c5;
        cuadros1[0][5] = c6;
        cuadros1[1][0] = c7;
        cuadros1[1][1] = c8;
        cuadros1[1][2] = c9;
        cuadros1[1][3] = c10;
        cuadros1[1][4] = c11;
        cuadros1[1][5] = c12;
        
        //------------------------------------------
        
        cuadros2 = new JLabel[2][12];        
        cuadros2[0][0] = cc1;
        cuadros2[0][1] = cc2;
        cuadros2[0][2] = cc3;
        cuadros2[0][3] = cc4;
        cuadros2[0][4] = cc5;
        cuadros2[0][5] = cc6;
        cuadros2[0][6] = cc7;
        cuadros2[0][7] = cc8;
        cuadros2[0][8] = cc9;
        cuadros2[0][9] = cc10;
        cuadros2[0][10] = cc11;
        cuadros2[0][11] = cc12;        
        cuadros2[1][0] = cc13;
        cuadros2[1][1] = cc14;
        cuadros2[1][2] = cc15;
        cuadros2[1][3] = cc16;
        cuadros2[1][4] = cc17;
        cuadros2[1][5] = cc18;
        cuadros2[1][6] = cc19;
        cuadros2[1][7] = cc20;
        cuadros2[1][8] = cc21;
        cuadros2[1][9] = cc22;
        cuadros2[1][10] = cc23;
        cuadros2[1][11] = cc24; 
        
        
        tahi.setIcon(new ImageIcon (getClass().getResource("imagenes/personajes/tahi/"+GestorJuego.getInstance().getGenero()+"11.png")));
        new Iniciar().start();        
    }
    
    
    public void mostrarInstrucciones()
    {
      this.cuadroDialogo.setSize(cuadroDialogo.getPreferredSize());
      this.cuadroDialogo.setIcon(dialogo[0]); 
      this.siguiente.setSize(30,30);   
    }
    
    
    public void ocultarInstrucciones()
    {  
      this.cuadroDialogo.setSize(0,0);
      this.siguiente.setSize(0,0);  
      new AparicionSirena().start();
    }
    
    
    public boolean esRepetido(int[] vector, int numero) //dado un vector y un numero se determina si ese numero se encuentra en el vector
    { 
      for(int i=0; i<vector.length; i++)
      {
        if(vector[i] == numero){return true;} 
      }
      return false;
    } 
    
    public void mostrarOpciones( boolean unidades)
    {
       for(int i=0; i<camposNumerador.length ; i++)
       {
          camposNumerador[i].setSize(camposNumerador[i].getPreferredSize());  
          camposDenominador[i].setSize(camposDenominador[i].getPreferredSize()); 
          rayas[i].setSize(rayas[i].getPreferredSize());  
          if(unidades){ camposUnidades[i].setSize(camposUnidades[i].getPreferredSize()); }
       }  
    }
    
    public void esconderOpciones()
    {
       for(int i=0; i<camposNumerador.length ; i++)
       {
          camposUnidades[i].setSize(0,0); 
          camposNumerador[i].setSize(0,0);  
          camposDenominador[i].setSize(0,0); 
          rayas[i].setSize(0,0);            
       }  
    }
    
    
    public void limpiarCuadros1()
    {
       for(int i=0; i<cuadros1.length; i++)
       {
         for(int j = 0; j<denominador/2; j++)
         {
            cuadros1[i][j].setSize(0,0);
            cuadros1[i][j].setBackground(Color.white);
         }
       }
    }
    
    
    public void limpiarCuadros2()
    {
      int cont1 = 0;  
      for(int j = 0; j<cuadros2[0].length; j++)
      {
        cuadros2[1][j].setBackground(Color.white);
        cuadros2[0][j].setBackground(Color.white);
        cuadros2[0][j].setSize(0,0);
        cuadros2[1][j].setSize(0,0);
        cont1++;
      }
    }
    
    
    public void limpiarFracciones()
    {
      for(int i=0; i<camposNumerador.length; i++)
      {
        camposUnidades[i].setText("");  
        camposNumerador[i].setText("");
        camposDenominador[i].setText("");     
      }      
    }
    
    
    public void generarFraccion1()
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
       mostrarRepGrafica1();     
    }
    
    public void mostrarRepGrafica1()
    {
       Random randomGenerator = new Random();
       int color = randomGenerator.nextInt(7);
              
       for(int i=0; i<cuadros1.length; i++)
       {
         for(int j = 0; j<denominador/2; j++)
         {
            cuadros1[i][j].setSize(cuadros1[i][j].getPreferredSize());            
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
       generarOpciones1();
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
          cuadros1[0][pos].setBackground(c);
       }
       
       for(int i=0; i<cuadrosFila2.length; i++)
       {
          int pos = randomGenerator.nextInt(denominador/2);
          while(esRepetido(cuadrosFila2,pos))
          {
             pos = randomGenerator.nextInt(denominador/2); 
          }
          cuadrosFila2[i] = pos;
          cuadros1[1][pos].setBackground(c);
       }
    }
    
    public void generarOpciones1()
    {
        int numeradores[] = new int[3];
        int denominadores[] = new int[3];
        
        for (int i = 0; i < numeradores.length; i++) {numeradores[i] = -1;denominadores[i] = -1;} //Inicializo el vector en -1 para evitar problemas con el indice 0.
       
        Random randomGenerator = new Random(); 
                     
        respCorrecta = randomGenerator.nextInt(numeradores.length);
        
        while(respCorrecta == respCorrectaAnterior)
        {
          respCorrecta = randomGenerator.nextInt(numeradores.length); 
        }    
        respCorrectaAnterior = respCorrecta;
        
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
        mostrarOpciones(false);
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
    
    
    public void generarFraccion2()
    {
        
       Random randomGenerator = new Random();
       
       unidad = randomGenerator.nextInt(7);
       
       while(unidad < 2 || unidad == unidadAnterior)
       {
          unidad = randomGenerator.nextInt(7); 
       }    
       unidadAnterior = unidad;
       
       
       numerador = 0;
       denominador = randomGenerator.nextInt(((12 - unidad)/unidad)+1);
       
       while(denominador == 0)
       {
          denominador = randomGenerator.nextInt(((12 - unidad)/unidad)+1);
       }
       denominador = denominador * 2; //Para tomar en cuenta las 2 filas.
       
       
       numerador = randomGenerator.nextInt(denominador);
       
       while(numerador == 0){
         numerador = randomGenerator.nextInt(denominador);         
       }
       
       mostrarUnidades();
       mostrarOpciones(true);
    }
    
       
    public void mostrarUnidades()
    {   
       Random randomGenerator = new Random();
       int color = randomGenerator.nextInt(7); 
        
       JLabel[][] ultimaUnidad = new JLabel[2][denominador/2];
       int posVec = 0;
       
       int contUnidades = 1;
       int cont1 = 1;
       for (int i = 0; i < cuadros2[0].length; i++) 
       {           
          if(cont1 <= (denominador/2) && contUnidades <= unidad)
          {               
            cuadros2[0][i].setSize(cuadros2[0][i].getPreferredSize());
            cuadros2[1][i].setSize(cuadros2[1][i].getPreferredSize());          
            cont1++; 
            if(contUnidades < unidad)
            {
              switch(color)
              {
                case 0: cuadros2[0][i].setBackground(Color.lightGray);
                        cuadros2[1][i].setBackground(Color.lightGray);
                        break;
                case 1: cuadros2[0][i].setBackground(Color.blue);
                        cuadros2[1][i].setBackground(Color.blue);
                        break;
                case 2: cuadros2[0][i].setBackground(Color.green);
                        cuadros2[1][i].setBackground(Color.green);
                        break;
                case 3: cuadros2[0][i].setBackground(Color.magenta);
                        cuadros2[1][i].setBackground(Color.magenta);
                        break;
                case 4: cuadros2[0][i].setBackground(Color.orange);
                        cuadros2[1][i].setBackground(Color.orange);
                        break;
                case 5: cuadros2[0][i].setBackground(Color.yellow);
                        cuadros2[1][i].setBackground(Color.yellow);
                        break;
                case 6: cuadros2[0][i].setBackground(Color.red);
                        cuadros2[1][i].setBackground(Color.red);
                        break;
              } 
            }
            else if(contUnidades == unidad)
            {                
              ultimaUnidad[0][posVec] = cuadros2[0][i];
              ultimaUnidad[1][posVec] = cuadros2[1][i];
              posVec++;
            }
          }else{cont1 = 1;contUnidades ++;}
       } 
       pintarNumerador(color,ultimaUnidad);
       generarOpciones2();
    }  
    
    public void pintarNumerador(int color, JLabel[][] uL)
    {
        int cont1 = 0;
        for (int i = 0; i < uL.length; i++)
        {
          for (int j = 0; j < uL[i].length; j++) 
          {
             if(cont1 < numerador)
             {
               switch(color)
               {
                 case 0: uL[i][j].setBackground(Color.lightGray);
                         break;
                 case 1: uL[i][j].setBackground(Color.blue);
                         break;
                 case 2: uL[i][j].setBackground(Color.green);
                         break;
                 case 3: uL[i][j].setBackground(Color.magenta);
                         break;
                 case 4: uL[i][j].setBackground(Color.orange);
                         break;
                 case 5: uL[i][j].setBackground(Color.yellow);
                         break;
                 case 6: uL[i][j].setBackground(Color.red);
                         break;
               }
               cont1++;
             }
          }  
        }
 
    }
    
    public void generarOpciones2()
    {
        int numeradores[] = new int[3];
        int denominadores[] = new int[3];
        int unidades[] = new int[3];
        
        for (int i = 0; i < numeradores.length; i++) {unidades[i] = -1;numeradores[i] = -1;denominadores[i] = -1;} //Inicializo el vector en -1 para evitar problemas con el indice 0.
       
        Random randomGenerator = new Random(); 
        
        respCorrecta = randomGenerator.nextInt(numeradores.length);
        
        while(respCorrecta == respCorrectaAnterior)
        {
          respCorrecta = randomGenerator.nextInt(numeradores.length); 
        }  
        respCorrectaAnterior = respCorrecta;
        
        unidades[respCorrecta] = unidad-1;
        numeradores[respCorrecta] = numerador;
        denominadores[respCorrecta] = denominador;
                
        int uni;
        int den;
        int num;
        
        for(int i=0; i<numeradores.length; i++)
        {           
           if(numeradores[i] == -1)
           {
             uni = randomGenerator.nextInt(7);
             while(uni == 0)
             {
               uni = randomGenerator.nextInt(7);   
             }             
             den = randomGenerator.nextInt(8);
             while(den < 3)
             {
               den = randomGenerator.nextInt(8);   
             }
             num = randomGenerator.nextInt(den);  
             while( num == 0)
             {
               num = randomGenerator.nextInt(den); 
             }
             
             while(fraccionRepetida(num,den,numeradores,denominadores))
             {
                //Unidad si se puede repetir 
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
             unidades[i] = uni;
             numeradores[i] = num;
             denominadores[i] = den;
           }
        }
        
        for(int i=0; i<numeradores.length; i++)
        {
           camposUnidades[i].setText(unidades[i]+""); 
           camposNumerador[i].setText(numeradores[i]+""); 
           camposDenominador[i].setText(denominadores[i]+"");
        }
    }
    
    
    public void generarFraccion3()
    {
       int numeradores[] = new int[3];
       int denominadores[] = new int[3];
       
       int num1,num2,num3;
       int den1,den2,den3;
       
       for (int i = 0; i < numeradores.length; i++) {numeradores[i] = -1;denominadores[i] = -1;} //Inicializo el vector en -1 para evitar problemas con el indice 0.
         
       Random randomGenerator = new Random();
       
       
       //------------------------------------------------------
       num1 = randomGenerator.nextInt(15);
       num1++; //para evitar que sea cero (mejor q el while)
                 
       den1 = randomGenerator.nextInt(20);
       while(den1 <= num1){den1 = randomGenerator.nextInt(20);} 
       //------------------------------------------------------
       
       //------------------------------------------------------
       num2 = randomGenerator.nextInt(15);
       num2 += 2; //para evitar que sea cero (mejor q el while)
                 
       den2 = randomGenerator.nextInt(num2);
       while(den2 >= num2 || den2 == 0){den2 = randomGenerator.nextInt(num2);} 
       //------------------------------------------------------
       
       //------------------------------------------------------
       num3 = randomGenerator.nextInt(15);
       num3++; //para evitar que sea cero (mejor q el while)
                 
       den3 = num3; 
       //------------------------------------------------------
       
       int tipo = randomGenerator.nextInt(3);
       
       while(tipo == tipoAnterior)
       {
         tipo = randomGenerator.nextInt(3);  
       }
       
       tipoAnterior = tipo;    
       
        
       respCorrecta = randomGenerator.nextInt(numeradores.length);
        
       while(respCorrecta == respCorrectaAnterior)
       {
         respCorrecta = randomGenerator.nextInt(numeradores.length); 
       }
       respCorrectaAnterior = respCorrecta;
       
       int posRestante = randomGenerator.nextInt(numeradores.length);
       
       switch(tipo)
       {
         case 0: texto2.setText("Fraccion Propia");  
                 
                 numeradores[respCorrecta] = num1;
                 denominadores[respCorrecta] = den1;
                 
                                  
                 while(numeradores[posRestante] != -1)
                 {
                   posRestante = randomGenerator.nextInt(numeradores.length); 
                 }
                 numeradores[posRestante] = num2;
                 denominadores[posRestante] = den2;
                 
                 posRestante = randomGenerator.nextInt(numeradores.length);
                 
                 while(numeradores[posRestante] != -1)
                 {
                   posRestante = randomGenerator.nextInt(numeradores.length); 
                 }
                 numeradores[posRestante] = num3;
                 denominadores[posRestante] = den3;
                 
                 break;
             
         case 1: texto2.setText("Fraccion Impropia"); 
                 
                 numeradores[respCorrecta] = num2;
                 denominadores[respCorrecta] = den2;  
                 
                                  
                 while(numeradores[posRestante] != -1)
                 {
                   posRestante = randomGenerator.nextInt(numeradores.length); 
                 }
                 numeradores[posRestante] = num1;
                 denominadores[posRestante] = den1;
                 
                 posRestante = randomGenerator.nextInt(numeradores.length);
                 
                 while(numeradores[posRestante] != -1)
                 {
                   posRestante = randomGenerator.nextInt(numeradores.length); 
                 }
                 numeradores[posRestante] = num3;
                 denominadores[posRestante] = den3;
                 
                 break;
             
         case 2: texto2.setText("Igual a la Unidad");
                 
                 numeradores[respCorrecta] = num3;
                 denominadores[respCorrecta] = den3;
                 
                 
                 while(numeradores[posRestante] != -1)
                 {
                   posRestante = randomGenerator.nextInt(numeradores.length); 
                 }
                 numeradores[posRestante] = num1;
                 denominadores[posRestante] = den1;
                 
                 posRestante = randomGenerator.nextInt(numeradores.length);
                 
                 while(numeradores[posRestante] != -1)
                 {
                   posRestante = randomGenerator.nextInt(numeradores.length); 
                 }
                 numeradores[posRestante] = num2;
                 denominadores[posRestante] = den2;
                 
                 break;
       }
       
       new EfectoCambio().start();
       
       for(int i=0; i<numeradores.length; i++)
       {
          camposNumerador[i].setText(numeradores[i]+""); 
          camposDenominador[i].setText(denominadores[i]+"");
       }
       mostrarOpciones(false);
       
    }
      
    
    public void limpiarCuadros3()
    {
       this.texto2.setSize(0,0); 
    }
    
    
    public void generarFraccion4()
    {
       int numeradores[] = new int[3];
       int denominadores[] = new int[3]; 
       Random randomGenerator = new Random();
       
       for (int i = 0; i < numeradores.length; i++) {numeradores[i] = -1;denominadores[i] = -1;} //Inicializo el vector en -1 para evitar problemas con el indice 0.
               
       int tipo = randomGenerator.nextInt(4);
        
       respCorrecta = randomGenerator.nextInt(numeradores.length);
        
       while(respCorrecta == respCorrectaAnterior)
       {
         respCorrecta = randomGenerator.nextInt(numeradores.length); 
       }
       respCorrectaAnterior = respCorrecta;
       
       
       int num1,num2,den1,den2;
       
       num1 = randomGenerator.nextInt(8);
       num1++;
       num2 = randomGenerator.nextInt(num1);
       num2++;
       den1 = randomGenerator.nextInt(8);
       den1++;
       den2 = randomGenerator.nextInt(8);
       den2++;
       
       
       switch(tipo)
       {
         case 0: operacion.setText("+");
                 operacionNumerador1.setText(num1+"");
                 operacionNumerador2.setText(num2+"");
                 operacionDenominador1.setText(den1+"");
                 operacionDenominador2.setText(den1+"");
                 
                 numeradores[respCorrecta] = num1 + num2;
                 denominadores[respCorrecta] = den1;
                 
                 break;  
             
         case 1: operacion.setText("-");
                 operacionNumerador1.setText(num1+"");
                 operacionNumerador2.setText(num2+"");
                 operacionDenominador1.setText(den1+"");
                 operacionDenominador2.setText(den1+"");
                 
                 numeradores[respCorrecta] = num1 - num2;
                 denominadores[respCorrecta] = den1;
                 
                 break;
             
         case 2: operacion.setText("x");
                 operacionNumerador1.setText(num1+"");
                 operacionNumerador2.setText(num2+"");
                 operacionDenominador1.setText(den1+"");
                 operacionDenominador2.setText(den2+"");
                 
                 numeradores[respCorrecta] = num1 * num2;
                 denominadores[respCorrecta] = den1 * den2;
                                  
                 break;
             
         case 3: operacion.setText("/");
                 operacionNumerador1.setText(num1+"");
                 operacionNumerador2.setText(num2+"");
                 operacionDenominador1.setText(den1+"");
                 operacionDenominador2.setText(den2+"");
                 
                 numeradores[respCorrecta] = num1 * den2;
                 denominadores[respCorrecta] = num2 * den1;
                 
                 break;
       }
       
       int den;
       int num;
        
       for(int i=0; i<numeradores.length; i++)
       {           
          if(numeradores[i] == -1)
          {
            den = randomGenerator.nextInt(12);
            den++;
            num = randomGenerator.nextInt(12);  
            num++;
            
            while(fraccionRepetida(num,den,numeradores,denominadores))
            {
               den = randomGenerator.nextInt(12);
               den++;
               num = randomGenerator.nextInt(12);  
               num++;
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
       mostrarOperacion();
       mostrarOpciones(false);
    }
    
    public void mostrarOperacion()
    {
       operacionNumerador1.setSize(operacionNumerador1.getPreferredSize()); 
       operacionNumerador2.setSize(operacionNumerador2.getPreferredSize());
       operacionDenominador1.setSize(operacionDenominador1.getPreferredSize());
       operacionDenominador2.setSize(operacionDenominador2.getPreferredSize());
       
       operacionRaya1.setSize(operacionRaya1.getPreferredSize());
       operacionRaya2.setSize(operacionRaya2.getPreferredSize());
       operacion.setSize(operacion.getPreferredSize());
    }
    
    
    public void limpiarCuadros4()
    {
       operacionNumerador1.setSize(0,0); 
       operacionNumerador2.setSize(0,0);
       operacionDenominador1.setSize(0,0);
       operacionDenominador2.setSize(0,0);
       
       operacionRaya1.setSize(0,0);
       operacionRaya2.setSize(0,0);
       operacion.setSize(0,0);
    }
    
    
    public void mostrarAcciones()
    {
       accion1.setSize(accion1.getPreferredSize()); 
       accion2.setSize(accion2.getPreferredSize()); 
       accion3.setSize(accion3.getPreferredSize()); 
    }
    
    
    public void ocultarAcciones()
    {
       accion1.setSize(0,0); 
       accion2.setSize(0,0); 
       accion3.setSize(0,0); 
    }
    
    
    public void mostrarTruenos()
    {
        reloj.setSize(0,0);
        //trueno.play(); 
        for(int i=0; i<truenos.length; i++)
        {
            if(i != respCorrecta)
            {
                truenos[i].setIcon(ataque);  
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
           truenos[i].setIcon(noAtaque);  
           truenos[i].setSize(0,0);
         }
       }
       reloj.setSize(reloj.getPreferredSize());
    }
    
    
    public void ataquePersonaje()
    {
       reloj.setSize(reloj.getPreferredSize());
       
       switch(nivelActual)
       {
         case(1): generarFraccion1();new Cronometro(7).start();break;
         case(2): generarFraccion2();new Cronometro(7).start();break;
         case(3): generarFraccion3();new Cronometro(7).start();break;
         case(4): generarFraccion4();new Cronometro(15).start();break;
       }
       
       mostrarAcciones();
             
       while(!cronometro){try {Thread.sleep(100);} catch (InterruptedException ex) {}}           
       cronometro = false;
       
       reloj.setSize(0,0);
             
       ocultarAcciones();
       
       switch(nivelActual)
       { 
         case(1): limpiarCuadros1();break; 
         case(2): limpiarCuadros2();break;
         case(3): limpiarCuadros3();break;
         case(4): limpiarCuadros4();break;
       }
       esconderOpciones(); 
       
       atacando = true;
       
       new MovimientoSirena().start();
       
       while(atacando){try {Thread.sleep(100);} catch (InterruptedException ex) {}}       
    }
    
    
    public void muerteSirena()
    {
      soria.setIcon(posicionesSaron[7]); 
      try { Thread.sleep(3000); } catch (InterruptedException ex) {}
      soria.setIcon(posicionesSaron[8]); 
      try { Thread.sleep(1000); } catch (InterruptedException ex) {}
      explosion.setLocation(soria.getX()-10, soria.getY()-10);
      explosion.setSize(explosion.getPreferredSize());
      Sonidos.getInstance().reproducirLoop("trueno");
      try { Thread.sleep(7200); } catch (InterruptedException ex) {}  
      soria.setSize(0,0);
      explosion.setSize(0,0);
      Sonidos.getInstance().detener("trueno");
    }
    
    
    public boolean muertePersonaje() throws UnsupportedAudioFileException, IOException, LineUnavailableException 
    {
        if(GestorJuego.getInstance().getSalud() == 0)
        {
            JOptionPane.showMessageDialog(null, "Vaya... \nSória ha logrado vencérte ...","Mensaje",0);       
            setVisible(false);
            dispose();
            Sonidos.getInstance().detener(clip1);
            Sonidos.getInstance().detener(clip2);
            new Puzzle8_1().setVisible(true);
        
            return true;
        } 
        return false;
    }
    
    
    public void desplazarPersonaje(int zona)
    {    
       if(!corriendo)
       {       
        new Movimiento(zona).start(); 
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
        barra = new javax.swing.JLabel();
        siguiente = new javax.swing.JLabel();
        cuadroDialogo = new javax.swing.JLabel();
        accion1 = new javax.swing.JLabel();
        accion2 = new javax.swing.JLabel();
        accion3 = new javax.swing.JLabel();
        rayo1 = new javax.swing.JLabel();
        rayo2 = new javax.swing.JLabel();
        rayo3 = new javax.swing.JLabel();
        explosion = new javax.swing.JLabel();
        espadazo = new javax.swing.JLabel();
        tahi = new javax.swing.JLabel();
        soria = new javax.swing.JLabel();
        bote = new javax.swing.JLabel();
        unidades1 = new javax.swing.JTextField();
        unidades2 = new javax.swing.JTextField();
        unidades3 = new javax.swing.JTextField();
        campoNumerador3 = new javax.swing.JTextField();
        raya3 = new javax.swing.JLabel();
        campoDenominador3 = new javax.swing.JTextField();
        campoNumerador1 = new javax.swing.JTextField();
        raya1 = new javax.swing.JLabel();
        campoDenominador1 = new javax.swing.JTextField();
        campoNumerador2 = new javax.swing.JTextField();
        raya2 = new javax.swing.JLabel();
        campoDenominador2 = new javax.swing.JTextField();
        c12 = new javax.swing.JLabel();
        c11 = new javax.swing.JLabel();
        c10 = new javax.swing.JLabel();
        c9 = new javax.swing.JLabel();
        c8 = new javax.swing.JLabel();
        c7 = new javax.swing.JLabel();
        c6 = new javax.swing.JLabel();
        c5 = new javax.swing.JLabel();
        c4 = new javax.swing.JLabel();
        c3 = new javax.swing.JLabel();
        c2 = new javax.swing.JLabel();
        c1 = new javax.swing.JLabel();
        cc24 = new javax.swing.JLabel();
        cc23 = new javax.swing.JLabel();
        cc22 = new javax.swing.JLabel();
        cc21 = new javax.swing.JLabel();
        cc20 = new javax.swing.JLabel();
        cc19 = new javax.swing.JLabel();
        cc18 = new javax.swing.JLabel();
        cc17 = new javax.swing.JLabel();
        cc16 = new javax.swing.JLabel();
        cc15 = new javax.swing.JLabel();
        cc14 = new javax.swing.JLabel();
        cc13 = new javax.swing.JLabel();
        cc12 = new javax.swing.JLabel();
        cc11 = new javax.swing.JLabel();
        cc10 = new javax.swing.JLabel();
        cc9 = new javax.swing.JLabel();
        cc8 = new javax.swing.JLabel();
        cc7 = new javax.swing.JLabel();
        cc6 = new javax.swing.JLabel();
        cc5 = new javax.swing.JLabel();
        cc4 = new javax.swing.JLabel();
        cc3 = new javax.swing.JLabel();
        cc2 = new javax.swing.JLabel();
        cc1 = new javax.swing.JLabel();
        operacion = new javax.swing.JTextField();
        operacionNumerador1 = new javax.swing.JTextField();
        operacionRaya1 = new javax.swing.JLabel();
        operacionDenominador1 = new javax.swing.JTextField();
        operacionNumerador2 = new javax.swing.JTextField();
        operacionRaya2 = new javax.swing.JLabel();
        operacionDenominador2 = new javax.swing.JTextField();
        texto2 = new javax.swing.JTextField();
        reloj = new javax.swing.JTextField();
        SalirBtn = new javax.swing.JToggleButton();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("iZafiro - Bosque de Las Luciérnagas");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        barra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/barra.png"))); // NOI18N
        barra.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        barra.setMaximumSize(new java.awt.Dimension(800, 110));
        barra.setMinimumSize(new java.awt.Dimension(800, 110));
        barra.setPreferredSize(new java.awt.Dimension(800, 110));
        getContentPane().add(barra, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 490, -1, -1));

        siguiente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        siguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/botones/flecha-siguiente.png"))); // NOI18N
        siguiente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        siguiente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                siguienteMouseClicked(evt);
            }
        });
        getContentPane().add(siguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(665, 220, 0, 0));

        cuadroDialogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cuadroDialogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/puzzle/puzzle8/instrucciones/1.png"))); // NOI18N
        getContentPane().add(cuadroDialogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, 0, 0));

        accion1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        accion1.setPreferredSize(new java.awt.Dimension(130, 120));
        accion1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accion1MouseClicked(evt);
            }
        });
        getContentPane().add(accion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, -1, -1));

        accion2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        accion2.setPreferredSize(new java.awt.Dimension(130, 120));
        accion2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accion2MouseClicked(evt);
            }
        });
        getContentPane().add(accion2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 200, -1, -1));

        accion3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        accion3.setPreferredSize(new java.awt.Dimension(130, 120));
        accion3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accion3MouseClicked(evt);
            }
        });
        getContentPane().add(accion3, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 200, -1, -1));

        rayo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rayo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/puzzle/puzzle8/noataque.png"))); // NOI18N
        rayo1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(rayo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, -1, 500));

        rayo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rayo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/puzzle/puzzle8/noataque.png"))); // NOI18N
        rayo2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(rayo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 70, -1, 500));

        rayo3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rayo3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/puzzle/puzzle8/noataque.png"))); // NOI18N
        rayo3.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(rayo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 70, -1, 500));

        explosion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/puzzle/puzzle8/explosion.gif"))); // NOI18N
        getContentPane().add(explosion, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 190, 0, 0));

        espadazo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        espadazo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/objetos/espadazo.gif"))); // NOI18N
        getContentPane().add(espadazo, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, -21, 0, 0));

        tahi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/personajes/tahi/tahi11.png"))); // NOI18N
        getContentPane().add(tahi, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 520, -1, -1));

        soria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/puzzle/puzzle8/saron0.png"))); // NOI18N
        getContentPane().add(soria, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, -100, -1, -1));

        bote.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/objetos/bote.png"))); // NOI18N
        getContentPane().add(bote, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 500, -1, -1));

        unidades1.setEditable(false);
        unidades1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        unidades1.setForeground(new java.awt.Color(0, 102, 0));
        unidades1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        unidades1.setPreferredSize(new java.awt.Dimension(50, 40));
        getContentPane().add(unidades1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, 0, 0));

        unidades2.setEditable(false);
        unidades2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        unidades2.setForeground(new java.awt.Color(0, 102, 0));
        unidades2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        unidades2.setPreferredSize(new java.awt.Dimension(50, 40));
        getContentPane().add(unidades2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 240, 0, 0));

        unidades3.setEditable(false);
        unidades3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        unidades3.setForeground(new java.awt.Color(0, 102, 0));
        unidades3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        unidades3.setPreferredSize(new java.awt.Dimension(50, 40));
        getContentPane().add(unidades3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 240, 0, 0));

        campoNumerador3.setEditable(false);
        campoNumerador3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        campoNumerador3.setForeground(new java.awt.Color(0, 102, 0));
        campoNumerador3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoNumerador3.setPreferredSize(new java.awt.Dimension(50, 40));
        getContentPane().add(campoNumerador3, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 210, 0, 0));

        raya3.setBackground(new java.awt.Color(204, 0, 0));
        raya3.setOpaque(true);
        raya3.setPreferredSize(new java.awt.Dimension(50, 7));
        getContentPane().add(raya3, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 256, 0, 0));

        campoDenominador3.setEditable(false);
        campoDenominador3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        campoDenominador3.setForeground(new java.awt.Color(0, 102, 0));
        campoDenominador3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoDenominador3.setPreferredSize(new java.awt.Dimension(50, 40));
        getContentPane().add(campoDenominador3, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 270, 0, 0));

        campoNumerador1.setEditable(false);
        campoNumerador1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        campoNumerador1.setForeground(new java.awt.Color(0, 102, 0));
        campoNumerador1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoNumerador1.setPreferredSize(new java.awt.Dimension(50, 40));
        getContentPane().add(campoNumerador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 210, 0, 0));

        raya1.setBackground(new java.awt.Color(204, 0, 0));
        raya1.setOpaque(true);
        raya1.setPreferredSize(new java.awt.Dimension(50, 7));
        getContentPane().add(raya1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 256, 0, 0));

        campoDenominador1.setEditable(false);
        campoDenominador1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        campoDenominador1.setForeground(new java.awt.Color(0, 102, 0));
        campoDenominador1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoDenominador1.setPreferredSize(new java.awt.Dimension(50, 40));
        getContentPane().add(campoDenominador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 270, 0, 0));

        campoNumerador2.setEditable(false);
        campoNumerador2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        campoNumerador2.setForeground(new java.awt.Color(0, 102, 0));
        campoNumerador2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoNumerador2.setPreferredSize(new java.awt.Dimension(50, 40));
        getContentPane().add(campoNumerador2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 210, 0, 0));

        raya2.setBackground(new java.awt.Color(204, 0, 0));
        raya2.setOpaque(true);
        raya2.setPreferredSize(new java.awt.Dimension(50, 7));
        getContentPane().add(raya2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 256, 0, 0));

        campoDenominador2.setEditable(false);
        campoDenominador2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        campoDenominador2.setForeground(new java.awt.Color(0, 102, 0));
        campoDenominador2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoDenominador2.setPreferredSize(new java.awt.Dimension(50, 40));
        getContentPane().add(campoDenominador2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 270, 0, 0));

        c12.setBackground(new java.awt.Color(255, 255, 255));
        c12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        c12.setOpaque(true);
        c12.setPreferredSize(new java.awt.Dimension(42, 42));
        getContentPane().add(c12, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 50, 0, 0));

        c11.setBackground(new java.awt.Color(255, 255, 255));
        c11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        c11.setOpaque(true);
        c11.setPreferredSize(new java.awt.Dimension(42, 42));
        getContentPane().add(c11, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 50, 0, 0));

        c10.setBackground(new java.awt.Color(255, 255, 255));
        c10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        c10.setOpaque(true);
        c10.setPreferredSize(new java.awt.Dimension(42, 42));
        getContentPane().add(c10, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 50, 0, 0));

        c9.setBackground(new java.awt.Color(255, 255, 255));
        c9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        c9.setOpaque(true);
        c9.setPreferredSize(new java.awt.Dimension(42, 42));
        getContentPane().add(c9, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 50, 0, 0));

        c8.setBackground(new java.awt.Color(255, 255, 255));
        c8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        c8.setOpaque(true);
        c8.setPreferredSize(new java.awt.Dimension(42, 42));
        getContentPane().add(c8, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 50, 0, 0));

        c7.setBackground(new java.awt.Color(255, 255, 255));
        c7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        c7.setOpaque(true);
        c7.setPreferredSize(new java.awt.Dimension(42, 42));
        getContentPane().add(c7, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, 0, 0));

        c6.setBackground(new java.awt.Color(255, 255, 255));
        c6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        c6.setOpaque(true);
        c6.setPreferredSize(new java.awt.Dimension(42, 42));
        getContentPane().add(c6, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 10, 0, 0));

        c5.setBackground(new java.awt.Color(255, 255, 255));
        c5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        c5.setOpaque(true);
        c5.setPreferredSize(new java.awt.Dimension(42, 42));
        getContentPane().add(c5, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, 0, 0));

        c4.setBackground(new java.awt.Color(255, 255, 255));
        c4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        c4.setOpaque(true);
        c4.setPreferredSize(new java.awt.Dimension(42, 42));
        getContentPane().add(c4, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 0, 0));

        c3.setBackground(new java.awt.Color(255, 255, 255));
        c3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        c3.setOpaque(true);
        c3.setPreferredSize(new java.awt.Dimension(42, 42));
        getContentPane().add(c3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, 0, 0));

        c2.setBackground(new java.awt.Color(255, 255, 255));
        c2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        c2.setOpaque(true);
        c2.setPreferredSize(new java.awt.Dimension(42, 42));
        getContentPane().add(c2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, 0, 0));

        c1.setBackground(new java.awt.Color(255, 255, 255));
        c1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        c1.setOpaque(true);
        c1.setPreferredSize(new java.awt.Dimension(42, 42));
        getContentPane().add(c1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 0, 0));

        cc24.setBackground(new java.awt.Color(255, 255, 255));
        cc24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        cc24.setOpaque(true);
        cc24.setPreferredSize(new java.awt.Dimension(42, 42));
        getContentPane().add(cc24, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 50, 0, 0));

        cc23.setBackground(new java.awt.Color(255, 255, 255));
        cc23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        cc23.setOpaque(true);
        cc23.setPreferredSize(new java.awt.Dimension(42, 42));
        getContentPane().add(cc23, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 50, 0, 0));

        cc22.setBackground(new java.awt.Color(255, 255, 255));
        cc22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        cc22.setOpaque(true);
        cc22.setPreferredSize(new java.awt.Dimension(42, 42));
        getContentPane().add(cc22, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 50, 0, 0));

        cc21.setBackground(new java.awt.Color(255, 255, 255));
        cc21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        cc21.setOpaque(true);
        cc21.setPreferredSize(new java.awt.Dimension(42, 42));
        getContentPane().add(cc21, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 50, 0, 0));

        cc20.setBackground(new java.awt.Color(255, 255, 255));
        cc20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        cc20.setOpaque(true);
        cc20.setPreferredSize(new java.awt.Dimension(42, 42));
        getContentPane().add(cc20, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 50, 0, 0));

        cc19.setBackground(new java.awt.Color(255, 255, 255));
        cc19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        cc19.setOpaque(true);
        cc19.setPreferredSize(new java.awt.Dimension(42, 42));
        getContentPane().add(cc19, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 50, 0, 0));

        cc18.setBackground(new java.awt.Color(255, 255, 255));
        cc18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        cc18.setOpaque(true);
        cc18.setPreferredSize(new java.awt.Dimension(42, 42));
        getContentPane().add(cc18, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 50, 0, 0));

        cc17.setBackground(new java.awt.Color(255, 255, 255));
        cc17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        cc17.setOpaque(true);
        cc17.setPreferredSize(new java.awt.Dimension(42, 42));
        getContentPane().add(cc17, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 50, 0, 0));

        cc16.setBackground(new java.awt.Color(255, 255, 255));
        cc16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        cc16.setOpaque(true);
        cc16.setPreferredSize(new java.awt.Dimension(42, 42));
        getContentPane().add(cc16, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, 0, 0));

        cc15.setBackground(new java.awt.Color(255, 255, 255));
        cc15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        cc15.setOpaque(true);
        cc15.setPreferredSize(new java.awt.Dimension(42, 42));
        getContentPane().add(cc15, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, 0, 0));

        cc14.setBackground(new java.awt.Color(255, 255, 255));
        cc14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        cc14.setOpaque(true);
        cc14.setPreferredSize(new java.awt.Dimension(42, 42));
        getContentPane().add(cc14, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, 0, 0));

        cc13.setBackground(new java.awt.Color(255, 255, 255));
        cc13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        cc13.setOpaque(true);
        cc13.setPreferredSize(new java.awt.Dimension(42, 42));
        getContentPane().add(cc13, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 0, 0));

        cc12.setBackground(new java.awt.Color(255, 255, 255));
        cc12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        cc12.setOpaque(true);
        cc12.setPreferredSize(new java.awt.Dimension(42, 42));
        getContentPane().add(cc12, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 10, 0, 0));

        cc11.setBackground(new java.awt.Color(255, 255, 255));
        cc11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        cc11.setOpaque(true);
        cc11.setPreferredSize(new java.awt.Dimension(42, 42));
        getContentPane().add(cc11, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 10, 0, 0));

        cc10.setBackground(new java.awt.Color(255, 255, 255));
        cc10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        cc10.setOpaque(true);
        cc10.setPreferredSize(new java.awt.Dimension(42, 42));
        getContentPane().add(cc10, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 10, 0, 0));

        cc9.setBackground(new java.awt.Color(255, 255, 255));
        cc9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        cc9.setOpaque(true);
        cc9.setPreferredSize(new java.awt.Dimension(42, 42));
        getContentPane().add(cc9, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 10, 0, 0));

        cc8.setBackground(new java.awt.Color(255, 255, 255));
        cc8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        cc8.setOpaque(true);
        cc8.setPreferredSize(new java.awt.Dimension(42, 42));
        getContentPane().add(cc8, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, 0, 0));

        cc7.setBackground(new java.awt.Color(255, 255, 255));
        cc7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        cc7.setOpaque(true);
        cc7.setPreferredSize(new java.awt.Dimension(42, 42));
        getContentPane().add(cc7, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 0, 0));

        cc6.setBackground(new java.awt.Color(255, 255, 255));
        cc6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        cc6.setOpaque(true);
        cc6.setPreferredSize(new java.awt.Dimension(42, 42));
        getContentPane().add(cc6, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, 0, 0));

        cc5.setBackground(new java.awt.Color(255, 255, 255));
        cc5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        cc5.setOpaque(true);
        cc5.setPreferredSize(new java.awt.Dimension(42, 42));
        getContentPane().add(cc5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, 0, 0));

        cc4.setBackground(new java.awt.Color(255, 255, 255));
        cc4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        cc4.setOpaque(true);
        cc4.setPreferredSize(new java.awt.Dimension(42, 42));
        getContentPane().add(cc4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 0, 0));

        cc3.setBackground(new java.awt.Color(255, 255, 255));
        cc3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        cc3.setOpaque(true);
        cc3.setPreferredSize(new java.awt.Dimension(42, 42));
        getContentPane().add(cc3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, 0, 0));

        cc2.setBackground(new java.awt.Color(255, 255, 255));
        cc2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        cc2.setOpaque(true);
        cc2.setPreferredSize(new java.awt.Dimension(42, 42));
        getContentPane().add(cc2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 0, 0));

        cc1.setBackground(new java.awt.Color(255, 255, 255));
        cc1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        cc1.setOpaque(true);
        cc1.setPreferredSize(new java.awt.Dimension(42, 42));
        getContentPane().add(cc1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 0, 0));

        operacion.setEditable(false);
        operacion.setBackground(new java.awt.Color(0, 0, 0));
        operacion.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        operacion.setForeground(new java.awt.Color(255, 255, 255));
        operacion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        operacion.setText("+");
        operacion.setToolTipText("");
        operacion.setBorder(null);
        operacion.setPreferredSize(new java.awt.Dimension(40, 50));
        getContentPane().add(operacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(415, 30, 0, 0));

        operacionNumerador1.setEditable(false);
        operacionNumerador1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        operacionNumerador1.setForeground(new java.awt.Color(0, 102, 0));
        operacionNumerador1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        operacionNumerador1.setText("0");
        operacionNumerador1.setPreferredSize(new java.awt.Dimension(50, 40));
        getContentPane().add(operacionNumerador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, 0, 0));

        operacionRaya1.setBackground(new java.awt.Color(204, 0, 0));
        operacionRaya1.setOpaque(true);
        operacionRaya1.setPreferredSize(new java.awt.Dimension(50, 7));
        getContentPane().add(operacionRaya1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 56, 0, 0));

        operacionDenominador1.setEditable(false);
        operacionDenominador1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        operacionDenominador1.setForeground(new java.awt.Color(0, 102, 0));
        operacionDenominador1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        operacionDenominador1.setText("0");
        operacionDenominador1.setPreferredSize(new java.awt.Dimension(50, 40));
        getContentPane().add(operacionDenominador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 70, 0, 0));

        operacionNumerador2.setEditable(false);
        operacionNumerador2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        operacionNumerador2.setForeground(new java.awt.Color(0, 102, 0));
        operacionNumerador2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        operacionNumerador2.setText("0");
        operacionNumerador2.setPreferredSize(new java.awt.Dimension(50, 40));
        getContentPane().add(operacionNumerador2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, 0, 0));

        operacionRaya2.setBackground(new java.awt.Color(204, 0, 0));
        operacionRaya2.setOpaque(true);
        operacionRaya2.setPreferredSize(new java.awt.Dimension(50, 7));
        getContentPane().add(operacionRaya2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 56, 0, 0));

        operacionDenominador2.setEditable(false);
        operacionDenominador2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        operacionDenominador2.setForeground(new java.awt.Color(0, 102, 0));
        operacionDenominador2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        operacionDenominador2.setText("0");
        operacionDenominador2.setPreferredSize(new java.awt.Dimension(50, 40));
        getContentPane().add(operacionDenominador2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 70, 0, 0));

        texto2.setEditable(false);
        texto2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        texto2.setForeground(new java.awt.Color(0, 102, 0));
        texto2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        texto2.setPreferredSize(new java.awt.Dimension(200, 40));
        getContentPane().add(texto2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, 0, 0));

        reloj.setEditable(false);
        reloj.setBackground(new java.awt.Color(0, 0, 0));
        reloj.setFont(new java.awt.Font("Arial", 1, 55)); // NOI18N
        reloj.setForeground(new java.awt.Color(255, 0, 0));
        reloj.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        reloj.setText("0");
        reloj.setPreferredSize(new java.awt.Dimension(100, 80));
        getContentPane().add(reloj, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 20, 0, 0));

        SalirBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        SalirBtn.setForeground(new java.awt.Color(0, 102, 0));
        SalirBtn.setText("Salir");
        SalirBtn.setPreferredSize(new java.awt.Dimension(110, 23));
        SalirBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirBtnActionPerformed(evt);
            }
        });
        getContentPane().add(SalirBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 10, 110, -1));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/puzzle/puzzle8/fondo.gif"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void siguienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_siguienteMouseClicked
        // TODO add your handling code here:
        if(cont < dialogo.length){
            cont++;
            this.cuadroDialogo.setIcon(dialogo[cont-1]);
        }
        else{
            cont = 1;
            ocultarInstrucciones();
        }
    }//GEN-LAST:event_siguienteMouseClicked

    private void accion1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accion1MouseClicked
        // TODO add your handling code here:
        desplazarPersonaje(1);
    }//GEN-LAST:event_accion1MouseClicked

    private void accion2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accion2MouseClicked
        // TODO add your handling code here:
        desplazarPersonaje(2);
    }//GEN-LAST:event_accion2MouseClicked

    private void accion3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accion3MouseClicked
        // TODO add your handling code here:
        desplazarPersonaje(3);
    }//GEN-LAST:event_accion3MouseClicked

    private void SalirBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirBtnActionPerformed
        // TODO add your handling code here:
        if(JOptionPane.showConfirmDialog(null, "¿Seguro que deseas salir del Juego?", "Seleccionar una Opción", JOptionPane.YES_NO_OPTION) == 0)
        {
            AdministradorConsultasSQL ad = new AdministradorConsultasSQL();  
            ad.guardarPartida();
            
            this.setVisible(false);
            this.dispose();
            
            Teclado.getInstace().setPausa(false);
            GestorJuego.getInstance().cerrarPartida();

            try {
              new TablaPuntaje3().setVisible(true);  
            } catch (SQLException ex) {
              Logger.getLogger(Puzzle8.class.getName()).log(Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(Puzzle8_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Puzzle8_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Puzzle8_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Puzzle8_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Puzzle8_1().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton SalirBtn;
    private javax.swing.JLabel accion1;
    private javax.swing.JLabel accion2;
    private javax.swing.JLabel accion3;
    private javax.swing.JLabel barra;
    private javax.swing.JLabel bote;
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
    private javax.swing.JTextField campoDenominador1;
    private javax.swing.JTextField campoDenominador2;
    private javax.swing.JTextField campoDenominador3;
    private javax.swing.JTextField campoNumerador1;
    private javax.swing.JTextField campoNumerador2;
    private javax.swing.JTextField campoNumerador3;
    private javax.swing.JLabel cc1;
    private javax.swing.JLabel cc10;
    private javax.swing.JLabel cc11;
    private javax.swing.JLabel cc12;
    private javax.swing.JLabel cc13;
    private javax.swing.JLabel cc14;
    private javax.swing.JLabel cc15;
    private javax.swing.JLabel cc16;
    private javax.swing.JLabel cc17;
    private javax.swing.JLabel cc18;
    private javax.swing.JLabel cc19;
    private javax.swing.JLabel cc2;
    private javax.swing.JLabel cc20;
    private javax.swing.JLabel cc21;
    private javax.swing.JLabel cc22;
    private javax.swing.JLabel cc23;
    private javax.swing.JLabel cc24;
    private javax.swing.JLabel cc3;
    private javax.swing.JLabel cc4;
    private javax.swing.JLabel cc5;
    private javax.swing.JLabel cc6;
    private javax.swing.JLabel cc7;
    private javax.swing.JLabel cc8;
    private javax.swing.JLabel cc9;
    private javax.swing.JLabel cuadroDialogo;
    private javax.swing.JLabel energia;
    private javax.swing.JLabel espadazo;
    private javax.swing.JLabel explosion;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel hora;
    private javax.swing.JLabel n1;
    private javax.swing.JLabel n2;
    private javax.swing.JLabel n3;
    private javax.swing.JLabel n4;
    private javax.swing.JTextField operacion;
    private javax.swing.JTextField operacionDenominador1;
    private javax.swing.JTextField operacionDenominador2;
    private javax.swing.JTextField operacionNumerador1;
    private javax.swing.JTextField operacionNumerador2;
    private javax.swing.JLabel operacionRaya1;
    private javax.swing.JLabel operacionRaya2;
    private javax.swing.JLabel raya1;
    private javax.swing.JLabel raya2;
    private javax.swing.JLabel raya3;
    private javax.swing.JLabel rayo1;
    private javax.swing.JLabel rayo2;
    private javax.swing.JLabel rayo3;
    private javax.swing.JLabel recurso1;
    private javax.swing.JLabel recurso2;
    private javax.swing.JLabel recurso3;
    private javax.swing.JLabel recurso4;
    private javax.swing.JLabel recurso5;
    private javax.swing.JLabel recurso6;
    private javax.swing.JLabel recursos;
    private javax.swing.JTextField reloj;
    private javax.swing.JLabel salud;
    private javax.swing.JLabel siguiente;
    private javax.swing.JLabel soria;
    private javax.swing.JLabel tahi;
    private javax.swing.JTextField texto2;
    private javax.swing.JTextField unidades1;
    private javax.swing.JTextField unidades2;
    private javax.swing.JTextField unidades3;
    // End of variables declaration//GEN-END:variables

    public class Iniciar extends Thread
    {
       @Override
       public void run()
       {
          try { Thread.sleep(2000); } catch (InterruptedException ex) {} 
          
          while(bote.getY() > 350) 
          {
            tahi.setLocation(tahi.getX(), tahi.getY()-2);  
            bote.setLocation(bote.getX(), bote.getY()-2); 
            try { Thread.sleep(20); } catch (InterruptedException ex) {}
          }
          try { Thread.sleep(2000); } catch (InterruptedException ex) {}
          JOptionPane.showMessageDialog(null, "En esta ocasión usa SOLO el MOUSE","Espíritu de Zafiro:", 2, new ImageIcon (getClass().getResource("imagenes/barra/recursos/recurso1.png")));
          try { Thread.sleep(2000); } catch (InterruptedException ex) {}
          mostrarInstrucciones();
       }
    }
    
    public class AparicionSirena extends Thread
    {
       @Override
       public void run()
       {
          try { Thread.sleep(2000); } catch (InterruptedException ex) {} 
          
          while(soria.getY() < 80) 
          {
            soria.setLocation(soria.getX(), soria.getY()+2);
            try { Thread.sleep(20); } catch (InterruptedException ex) {}
          }
          soria.setIcon(posicionesSaron[1]);
          try { Thread.sleep(2000); } catch (InterruptedException ex) {} 
          
          new Nivel().start();
       }
    } 
    
    
    public class Cronometro extends Thread
    {  
       int limite;
       
       public Cronometro(int limite)
       {
         this.limite = limite;  
       }
       
       @Override
       public void run()
       {
         for(int i=limite; i>=0; i--)
         {  
           try {
             Thread.sleep(1000);
           } catch (InterruptedException ex) {}
           reloj.setText(i+"");
           if(movimientoRealizado){break;}
         }
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
         int cont = nivelActual;
         
         JOptionPane.showMessageDialog(null, "Espíritu de Zafiro:\n... ¡Ánimo "+GestorJuego.getInstance().getGenero()+"! ¡La batalla comienza! ...","Mensaje", 2, new ImageIcon (getClass().getResource("imagenes/barra/recursos/recurso1.png")));
         
         JOptionPane.showMessageDialog(null, "Espíritu de Zafiro:\n¡Haz doble click sobre la FRACCIÓN que creas correcta! ...","Mensaje", 2);
                
         while(saludSirena > 0 && GestorJuego.getInstance().getSalud() > 0)
         {         
           boolean murio = false;  
           if(cont > numNiveles)
           {  
                Random randomGenerator = new Random();         
                nivelActual = randomGenerator.nextInt(numNiveles);
                nivelActual++;

                while(nivelActual == nivelAnterior)
                {
                  nivelActual = randomGenerator.nextInt(numNiveles);
                  nivelActual++; 
                }
                nivelAnterior = nivelActual;
           }
           
           for(int j=0; j<vecesPorNivel; j++)  
           {                
                switch(nivelActual)
                {
                    case(1): generarFraccion1();new Cronometro(10).start();break;
                    case(2): generarFraccion2();new Cronometro(10).start();break;
                    case(3): generarFraccion3();new Cronometro(10).start();break;
                    case(4): generarFraccion4();new Cronometro(20).start();break;
                }

                mostrarAcciones();

                reloj.setSize(reloj.getPreferredSize());

                while(!cronometro){try {Thread.sleep(100);} catch (InterruptedException ex) {}}           
                cronometro = false;

                ocultarAcciones();

                switch(nivelActual)
                {
                    case(1): limpiarCuadros1();break; 
                    case(2): limpiarCuadros2();break;
                    case(3): limpiarCuadros3();break;
                    case(4): limpiarCuadros4();break;
                }

                esconderOpciones();
                soria.setIcon(posicionesSaron[2]);
                mostrarTruenos();
                try { Thread.sleep(900); } catch (InterruptedException ex) {}
                Sonidos.getInstance().reproducir("trueno");
                try { Thread.sleep(2100); } catch (InterruptedException ex) {}
                esconderTruenos();
                soria.setIcon(posicionesSaron[1]);

                reloj.setSize(0,0);

                try {
                    murio = muertePersonaje();
                } catch (       UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                    Logger.getLogger(Puzzle8_1.class.getName()).log(Level.SEVERE, null, ex);
                }
                if(murio){return;}
           }    
           
           if(!murio){ataquePersonaje();}  
                      
           try { Thread.sleep(1500); } catch (InterruptedException ex) {} 
           esconderOpciones();           
           nivelActual++;
           cont++;
         }
         
         if(saludSirena < 1)
         {
           Sonidos.getInstance().reproducir("nuevorecurso");
           JOptionPane.showMessageDialog(null, "Espíritu de Zafiro:\n'Lo has logrado "+GestorJuego.getInstance().getGenero()+", has vencido a Sória! ...' ","Mensaje", 2, new ImageIcon (getClass().getResource("imagenes/barra/recursos/recurso1.png")));
           try { Thread.sleep(2500); } catch (InterruptedException ex) {} 
         
           while(tahi.getY() > -200)
           {   
             tahi.setLocation(tahi.getX(),tahi.getY()-3);
             bote.setLocation(bote.getX(),bote.getY()-3);
             try { Thread.sleep(25); } catch (InterruptedException ex) {}                 
           }
         }
         
         Sonidos.getInstance().detener(clip1);
         Sonidos.getInstance().detener(clip2);
         setVisible(false);
         dispose();
         
         try { Thread.sleep(3000); } catch (InterruptedException ex) {}      
         
         new Puzzle8_2().setVisible(true);
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
          int zonaAnt = zonaActual;
          moverAbajo(350);
          zonaActual = -1;
          
          switch(zona)
          {              
            case 1: zona1(zonaAnt); break;
            case 2: zona2(zonaAnt); break;
            case 3: zona3(zonaAnt); break;  
          }       
          moverArriba(340);
          movimientoRealizado = true;
          //try { Thread.sleep(5000); } catch (InterruptedException ex) {} 
          corriendo = false;
       }
       
       public void moverIzquierda(int limite)
       {  
          while(tahi.getX() > limite)
          { 
            if(tahi.getIcon() != dano)
            {   
              tahi.setLocation(tahi.getX()-3,tahi.getY());
              bote.setLocation(bote.getX()-3,bote.getY());
              try {
               Thread.sleep(25);
              } catch (InterruptedException ex) {}     
            } 
          }
       }
       
       public void moverDerecha(int limite)
       {    
          while(tahi.getX() < limite)
          {
            if(tahi.getIcon() != dano)
            {          
              tahi.setLocation(tahi.getX()+3,tahi.getY());
              bote.setLocation(bote.getX()+3,bote.getY());
              try {
                Thread.sleep(25);
              } catch (InterruptedException ex) {}             
            }
          } 
       }
       
       public void moverArriba(int limite)
       {
          zonaActual = this.zona;
         
          while(tahi.getY() > limite)
          { 
            if(tahi.getIcon() != dano)
            { 
              tahi.setLocation(tahi.getX(),tahi.getY()-3);
              bote.setLocation(bote.getX(),bote.getY()-3);
              try {
               Thread.sleep(25);
              } catch (InterruptedException ex) {} 
            }
          }
       }
       
       
       public void moverAbajo(int limite)
       {
          while(tahi.getY() < limite)
          {
            if(tahi.getIcon() != dano)
            {   
              tahi.setLocation(tahi.getX(),tahi.getY()+3);
              bote.setLocation(bote.getX(),bote.getY()+3);
              try {
               Thread.sleep(25);
              } catch (InterruptedException ex) {}            
            }
          } 
       }
       
       public void zona1(int zonaAnt)
       {
         moverIzquierda(210);         
       }
       
       public void zona2(int zonaAnt)
       {
         if(zonaAnt == 1){ moverDerecha(390); }
         else{ moverIzquierda(390); }
       }    
       
       public void zona3(int zonaAnt)
       {   
         moverDerecha(590);  
       }
    } 
    
    
    public class MovimientoSirena extends Thread
    {     
       @Override
       public void run()
       { 
          int zonaAnt = zonaActual;
          //moverAbajo(350);
          
          soria.setIcon(posicionesSaron[5]);
                    
          switch(respCorrecta)
          {              
            case 0: zona1(zonaAnt); break;
            case 2: zona3(zonaAnt); break;  
          }          
          
          moverAbajo(290);
          
          soria.setIcon(posicionesSaron[4]);
          Sonidos.getInstance().reproducir("espadazo");
          
          tahi.setIcon(posicionesPersonaje[1]);
          
          for(int i=0; i<10; i++) //Se esquiva el ataque de la sirena
          {
             tahi.setLocation(tahi.getX(),tahi.getY()+3);
             try { Thread.sleep(35); } catch (InterruptedException ex) {}   
          }
          tahi.setIcon(posicionesPersonaje[0]);
          try { Thread.sleep(300); } catch (InterruptedException ex) {}
          
          tahi.setIcon(posicionesPersonaje[1]);
          
          for(int i=0; i<10; i++) // Se aproxima a la sirena para lastimarla
          {
             tahi.setLocation(tahi.getX(),tahi.getY()-3);
             try { Thread.sleep(10); } catch (InterruptedException ex) {}   
          }
                    
          new Espadazo(new ArrayList<Enemigo>(),espadazo,tahi).start();
          
          if(zonaActual-1 == respCorrecta) //Se valida si el personaje lastimo a la sirena
          {
            soria.setIcon(posicionesSaron[8]); 
            try { Thread.sleep(600); } catch (InterruptedException ex) {}
              
            saludSirena--;
            
            if(saludSirena == 0)
            {
              muerteSirena();
              atacando = false;
              return;
            }
          }              
          
          try { Thread.sleep(100); } catch (InterruptedException ex) {}
          
          tahi.setIcon(posicionesPersonaje[0]);
          
          soria.setIcon(posicionesSaron[6]);
          
          moverArriba(80);
          if(soria.getX() < 390){moverDerecha(390);}else{moverIzquierda(390);}
          
          soria.setIcon(posicionesSaron[1]);
          
          atacando = false;
       }
       
       public void moverIzquierda(int limite)
       {  
          while(soria.getX() > limite)
          {  
            soria.setLocation(soria.getX()-3,soria.getY());
            try { Thread.sleep(15); } catch (InterruptedException ex) {}           
          }
       }
       
       public void moverDerecha(int limite)
       {    
          while(soria.getX() < limite)
          {
            soria.setLocation(soria.getX()+3,soria.getY());
            try { Thread.sleep(15); } catch (InterruptedException ex) {}
          } 
       }
       
       public void moverArriba(int limite)
       {         
          while(soria.getY() > limite)
          { 
            soria.setLocation(soria.getX(),soria.getY()-3);
            try { Thread.sleep(15); } catch (InterruptedException ex) {}
          }
       }
       
       
       public void moverAbajo(int limite)
       {
          while(soria.getY() < limite)
          {
            soria.setLocation(soria.getX(),soria.getY()+3);
            try { Thread.sleep(15); } catch (InterruptedException ex) {}
          } 
       }
       
       public void zona1(int zonaAnt)
       {
         moverIzquierda(210);         
       }  
       
       public void zona3(int zonaAnt)
       {   
         moverDerecha(590);  
       }
    }  
    
    
    public class Dano extends Thread
    {
       @Override
       public void run()
       {
          Icon icon = tahi.getIcon();
          tahi.setIcon(dano);  
          try { Thread.sleep(900); } catch (InterruptedException ex) {}
          Sonidos.getInstance().reproducir("dano");
          try { Thread.sleep(300); } catch (InterruptedException ex) {}
          tahi.setIcon(icon);  
          
          GestorJuego.getInstance().setSalud2(GestorJuego.getInstance().getSalud()-1);
          salud.setIcon(new ImageIcon (getClass().getResource("imagenes/barra/salud"+GestorJuego.getInstance().getSalud()+".PNG")));
                              
       }
    }
    
    
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

}
