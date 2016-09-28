/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package izafiro;

import java.applet.Applet;
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
public class Puzzle6 extends javax.swing.JFrame {

    private Icon[] instrucciones;
    private Icon[] posiciones;
    private Icon dano;
    private JTextField[] camposUnidades;
    private JTextField[] camposNumerador;
    private JTextField[] camposDenominador;
    private JLabel[][] cuadros;
    private JLabel[] truenos;
    private boolean corriendo = false;
    private boolean siguienteFr = false;
    private boolean cronometro;
    private boolean movimientoRealizado = false;
    private int cont = 1;
    private int numNiveles = 3;
    private int nivelActual = 1;
    private int vecesPorNivel = 5;
    private int unidad;
    private int numerador;
    private int denominador;
    private int unidadAnterior = 0;
    private int respCorrecta = 2;
    private int respCorrectaAnterior = 2;
    private int zonaActual = 3;
    private int puntaje = 0;
    private int puntosPorNivel = 5;
    private double calificacionMinima = 0.75;
    
    /**
     * Creates new form Puzzle2
     */
    public Puzzle6() {
        initComponents();
        this.setLocationRelativeTo(null); this.setIconImage(new ImageIcon (getClass().getResource("izafiroicono.png")).getImage()); Sonidos.getInstance().activarCursor(this);      
        
        instrucciones = new Icon[14];
        instrucciones[0] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle6/instrucciones/1.png"));
        instrucciones[1] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle6/instrucciones/2.png"));
        instrucciones[2] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle6/instrucciones/3.png"));
        instrucciones[3] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle6/instrucciones/4.png"));
        instrucciones[4] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle6/instrucciones/5.png"));
        instrucciones[5] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle6/instrucciones/6.png"));
        instrucciones[6] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle6/instrucciones/7.png"));
        instrucciones[7] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle6/instrucciones/8.png"));
        instrucciones[8] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle6/instrucciones/9.png"));
        instrucciones[9] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle6/instrucciones/10.png"));
        instrucciones[10] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle6/instrucciones/11.png"));
        instrucciones[11] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle6/instrucciones/12.png"));
        instrucciones[12] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle6/instrucciones/13.png"));
        instrucciones[13] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle6/instrucciones/14.png"));
        
        String personaje = GestorJuego.getInstance().getGenero();
        dano = new ImageIcon (getClass().getResource("imagenes/personajes/tahi/"+personaje+"0.png"));
         
        posiciones = new Icon[5];
        posiciones[0] = new ImageIcon (getClass().getResource("imagenes/personajes/tahi/"+personaje+"11.png"));
        posiciones[1] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle2/"+personaje+"/1.gif"));
        posiciones[2] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle2/"+personaje+"/2.gif"));
        posiciones[3] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle2/"+personaje+"/3.gif"));
        posiciones[4] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle2/"+personaje+"/4.gif"));
        
        tahi.setIcon(posiciones[0]); 
        
        camposUnidades = new JTextField[4];
        camposUnidades[0] = unidades1;
        camposUnidades[1] = unidades2;
        camposUnidades[2] = unidades3;
        camposUnidades[3] = unidades4;        
        
        camposNumerador = new JTextField[4];
        camposNumerador[0] = cn1;
        camposNumerador[1] = cn2;
        camposNumerador[2] = cn3;
        camposNumerador[3] = cn4;
        
        camposDenominador = new JTextField[4];
        camposDenominador[0] = cd1;
        camposDenominador[1] = cd2;
        camposDenominador[2] = cd3;
        camposDenominador[3] = cd4;  
        
        truenos = new JLabel[4];
        truenos[0] = roca1;
        truenos[1] = roca2;
        truenos[2] = roca3;
        truenos[3] = roca4;
        
        cuadros = new JLabel[2][12];        
        cuadros[0][0] = cc1;
        cuadros[0][1] = cc2;
        cuadros[0][2] = cc3;
        cuadros[0][3] = cc4;
        cuadros[0][4] = cc5;
        cuadros[0][5] = cc6;
        cuadros[0][6] = cc7;
        cuadros[0][7] = cc8;
        cuadros[0][8] = cc9;
        cuadros[0][9] = cc10;
        cuadros[0][10] = cc11;
        cuadros[0][11] = cc12;        
        cuadros[1][0] = cc13;
        cuadros[1][1] = cc14;
        cuadros[1][2] = cc15;
        cuadros[1][3] = cc16;
        cuadros[1][4] = cc17;
        cuadros[1][5] = cc18;
        cuadros[1][6] = cc19;
        cuadros[1][7] = cc20;
        cuadros[1][8] = cc21;
        cuadros[1][9] = cc22;
        cuadros[1][10] = cc23;
        cuadros[1][11] = cc24;   
        
        Sonidos.getInstance().reproducirLoop("rio");
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
        camposUnidades[i].setText("");  
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
    }
    
       
    public void mostrarUnidades()
    {   
       Random randomGenerator = new Random();
       int color = randomGenerator.nextInt(7); 
        
       JLabel[][] ultimaUnidad = new JLabel[2][denominador/2];
       int posVec = 0;
       
       int contUnidades = 1;
       int cont1 = 1;
       for (int i = 0; i < cuadros[0].length; i++) 
       {           
          if(cont1 <= (denominador/2) && contUnidades <= unidad)
          {               
            cuadros[0][i].setSize(cuadros[0][i].getPreferredSize());
            cuadros[1][i].setSize(cuadros[1][i].getPreferredSize());          
            cont1++; 
            if(contUnidades < unidad)
            {
              switch(color)
              {
                case 0: cuadros[0][i].setBackground(Color.lightGray);
                        cuadros[1][i].setBackground(Color.lightGray);
                        break;
                case 1: cuadros[0][i].setBackground(Color.blue);
                        cuadros[1][i].setBackground(Color.blue);
                        break;
                case 2: cuadros[0][i].setBackground(Color.green);
                        cuadros[1][i].setBackground(Color.green);
                        break;
                case 3: cuadros[0][i].setBackground(Color.magenta);
                        cuadros[1][i].setBackground(Color.magenta);
                        break;
                case 4: cuadros[0][i].setBackground(Color.orange);
                        cuadros[1][i].setBackground(Color.orange);
                        break;
                case 5: cuadros[0][i].setBackground(Color.yellow);
                        cuadros[1][i].setBackground(Color.yellow);
                        break;
                case 6: cuadros[0][i].setBackground(Color.red);
                        cuadros[1][i].setBackground(Color.red);
                        break;
              } 
            }
            else if(contUnidades == unidad)
            {                
              ultimaUnidad[0][posVec] = cuadros[0][i];
              ultimaUnidad[1][posVec] = cuadros[1][i];
              posVec++;
            }
          }else{cont1 = 1;contUnidades ++;}
       } 
       pintarNumerador(color,ultimaUnidad);
       generarOpciones();
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
    
    public void generarOpciones()
    {
        int numeradores[] = new int[4];
        int denominadores[] = new int[4];
        int unidades[] = new int[4];
        
        for (int i = 0; i < numeradores.length; i++) {unidades[i] = -1;numeradores[i] = -1;denominadores[i] = -1;} //Inicializo el vector en -1 para evitar problemas con el indice 0.
       
        Random randomGenerator = new Random(); 
           
        respCorrectaAnterior = respCorrecta;
        
        respCorrecta = randomGenerator.nextInt(numeradores.length);
        
        while(respCorrecta == respCorrectaAnterior)
        {
          respCorrecta = randomGenerator.nextInt(numeradores.length); 
        }      
        
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
      for(int j = 0; j<cuadros[0].length; j++)
      {
        cuadros[1][j].setBackground(Color.white);
        cuadros[0][j].setBackground(Color.white);
        cuadros[0][j].setSize(0,0);
        cuadros[1][j].setSize(0,0);
      }
    }
    
    public void mostrarRocas()
    {       
       reloj.setSize(0,0);
       
       for(int i=0; i<truenos.length; i++)
       {
         if(i != respCorrecta)
         {
           if(i == 0 || i == 3)
           {
             new MovimientoRoca(truenos[i], 210, i).start();
           }
           else
           {
             new MovimientoRoca(truenos[i], 300, i).start(); 
           }
         }
       } 
       if( zonaActual-1 != respCorrecta){new Dano().start();}
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
       //reloj.setSize(reloj.getPreferredSize());
       if( zonaActual-1 == respCorrecta)
       {
          Sonidos.getInstance().reproducir("success2");  
          JOptionPane.showMessageDialog(null, "BIEN!!!\nTienes +"+ puntosPorNivel +" puntos!!", "Correcto", JOptionPane.PLAIN_MESSAGE, new ImageIcon (getClass().getResource("imagenes/objetos/check.png")));         
          aumentarPuntaje(); 
       }
       else{
          Sonidos.getInstance().reproducir("error");  
          Sonidos.getInstance().reproducir("dano");
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
          Sonidos.getInstance().detener("rio");
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
        cuadrito = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        reloj = new javax.swing.JTextField();
        campoPuntaje = new javax.swing.JTextField();
        roca4 = new javax.swing.JLabel();
        roca3 = new javax.swing.JLabel();
        roca2 = new javax.swing.JLabel();
        roca1 = new javax.swing.JLabel();
        opcion4 = new javax.swing.JToggleButton();
        opcion3 = new javax.swing.JToggleButton();
        opcion2 = new javax.swing.JToggleButton();
        opcion1 = new javax.swing.JToggleButton();
        cn1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cd1 = new javax.swing.JTextField();
        cn4 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cd4 = new javax.swing.JTextField();
        cn3 = new javax.swing.JTextField();
        cd3 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cn2 = new javax.swing.JTextField();
        cd2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
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
        SalirBtn = new javax.swing.JToggleButton();
        iniciarBtn = new javax.swing.JToggleButton();
        instruccionesBtn = new javax.swing.JToggleButton();
        tahi = new javax.swing.JLabel();
        unidades4 = new javax.swing.JTextField();
        unidades3 = new javax.swing.JTextField();
        unidades2 = new javax.swing.JTextField();
        unidades1 = new javax.swing.JTextField();
        cascada2 = new javax.swing.JLabel();
        cascada1 = new javax.swing.JLabel();
        cascada3 = new javax.swing.JLabel();
        cascada4 = new javax.swing.JLabel();
        cascada5 = new javax.swing.JLabel();
        cascada6 = new javax.swing.JLabel();
        cascada7 = new javax.swing.JLabel();
        cascada8 = new javax.swing.JLabel();
        flecha2 = new javax.swing.JLabel();
        flecha = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("iZafiro - Valle de La Roca");
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
        getContentPane().add(siguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 60, 0, 0));

        anterior.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        anterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/botones/flecha-anterior.png"))); // NOI18N
        anterior.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        anterior.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                anteriorMouseClicked(evt);
            }
        });
        getContentPane().add(anterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 60, 0, 0));

        cuadroDialogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cuadroDialogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/puzzle/puzzle2/instrucciones/1.png"))); // NOI18N
        cuadroDialogo.setRequestFocusEnabled(false);
        getContentPane().add(cuadroDialogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 0, 0));

        cuadrito.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cuadrito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/objetos/cuadrito.png"))); // NOI18N
        cuadrito.setRequestFocusEnabled(false);
        getContentPane().add(cuadrito, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 0, 0));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Puntaje");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 20, 90, 20));

        reloj.setEditable(false);
        reloj.setBackground(new java.awt.Color(0, 0, 0));
        reloj.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        reloj.setForeground(new java.awt.Color(255, 0, 0));
        reloj.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        reloj.setText("0");
        reloj.setPreferredSize(new java.awt.Dimension(90, 70));
        getContentPane().add(reloj, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 0, 0));

        campoPuntaje.setEditable(false);
        campoPuntaje.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        campoPuntaje.setForeground(new java.awt.Color(0, 0, 153));
        campoPuntaje.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoPuntaje.setText("0");
        getContentPane().add(campoPuntaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 10, 50, 40));

        roca4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/objetos/rocaaba.gif"))); // NOI18N
        getContentPane().add(roca4, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, -90, -1, -1));

        roca3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/objetos/rocaaba.gif"))); // NOI18N
        getContentPane().add(roca3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, -90, -1, -1));

        roca2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/objetos/rocaaba.gif"))); // NOI18N
        getContentPane().add(roca2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, -90, -1, -1));

        roca1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/objetos/rocaaba.gif"))); // NOI18N
        getContentPane().add(roca1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, -90, -1, -1));

        opcion4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        opcion4.setForeground(new java.awt.Color(0, 0, 204));
        opcion4.setText("^");
        opcion4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        opcion4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcion4ActionPerformed(evt);
            }
        });
        getContentPane().add(opcion4, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 450, -1, 40));

        opcion3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        opcion3.setForeground(new java.awt.Color(0, 0, 204));
        opcion3.setText("^");
        opcion3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        opcion3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcion3ActionPerformed(evt);
            }
        });
        getContentPane().add(opcion3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 450, -1, 40));

        opcion2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        opcion2.setForeground(new java.awt.Color(0, 0, 204));
        opcion2.setText("^");
        opcion2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        opcion2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcion2ActionPerformed(evt);
            }
        });
        getContentPane().add(opcion2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 450, -1, 40));

        opcion1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        opcion1.setForeground(new java.awt.Color(0, 0, 204));
        opcion1.setText("^");
        opcion1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        opcion1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcion1ActionPerformed(evt);
            }
        });
        getContentPane().add(opcion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, -1, 40));

        cn1.setEditable(false);
        cn1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cn1.setForeground(new java.awt.Color(0, 102, 0));
        cn1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(cn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 35, 35));

        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 153), 3));
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 165, 40, 6));

        cd1.setEditable(false);
        cd1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cd1.setForeground(new java.awt.Color(0, 102, 0));
        cd1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(cd1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 35, 35));

        cn4.setEditable(false);
        cn4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cn4.setForeground(new java.awt.Color(0, 102, 0));
        cn4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(cn4, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 150, 35, 35));

        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 153), 3));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(747, 195, 40, 6));

        cd4.setEditable(false);
        cd4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cd4.setForeground(new java.awt.Color(0, 102, 0));
        cd4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(cd4, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 210, 35, 35));

        cn3.setEditable(false);
        cn3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cn3.setForeground(new java.awt.Color(0, 102, 0));
        cn3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(cn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 200, 35, 35));

        cd3.setEditable(false);
        cd3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cd3.setForeground(new java.awt.Color(0, 102, 0));
        cd3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(cd3, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 260, 35, 35));

        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 153), 3));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(547, 245, 40, 6));

        cn2.setEditable(false);
        cn2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cn2.setForeground(new java.awt.Color(0, 102, 0));
        cn2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(cn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 200, 35, 35));

        cd2.setEditable(false);
        cd2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cd2.setForeground(new java.awt.Color(0, 102, 0));
        cd2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(cd2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 260, 35, 35));

        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 153), 3));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(277, 245, 40, 6));

        cc24.setBackground(new java.awt.Color(255, 255, 255));
        cc24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        cc24.setOpaque(true);
        cc24.setPreferredSize(new java.awt.Dimension(42, 42));
        getContentPane().add(cc24, new org.netbeans.lib.awtextra.AbsoluteConstraints(589, 50, 0, 0));

        cc23.setBackground(new java.awt.Color(255, 255, 255));
        cc23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        cc23.setOpaque(true);
        cc23.setPreferredSize(new java.awt.Dimension(42, 42));
        getContentPane().add(cc23, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 50, 0, 0));

        cc22.setBackground(new java.awt.Color(255, 255, 255));
        cc22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        cc22.setOpaque(true);
        cc22.setPreferredSize(new java.awt.Dimension(42, 42));
        getContentPane().add(cc22, new org.netbeans.lib.awtextra.AbsoluteConstraints(511, 50, 0, 0));

        cc21.setBackground(new java.awt.Color(255, 255, 255));
        cc21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        cc21.setOpaque(true);
        cc21.setPreferredSize(new java.awt.Dimension(42, 42));
        getContentPane().add(cc21, new org.netbeans.lib.awtextra.AbsoluteConstraints(472, 50, 0, 0));

        cc20.setBackground(new java.awt.Color(255, 255, 255));
        cc20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        cc20.setOpaque(true);
        cc20.setPreferredSize(new java.awt.Dimension(42, 42));
        getContentPane().add(cc20, new org.netbeans.lib.awtextra.AbsoluteConstraints(433, 50, 0, 0));

        cc19.setBackground(new java.awt.Color(255, 255, 255));
        cc19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        cc19.setOpaque(true);
        cc19.setPreferredSize(new java.awt.Dimension(42, 42));
        getContentPane().add(cc19, new org.netbeans.lib.awtextra.AbsoluteConstraints(394, 50, 0, 0));

        cc18.setBackground(new java.awt.Color(255, 255, 255));
        cc18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        cc18.setOpaque(true);
        cc18.setPreferredSize(new java.awt.Dimension(42, 42));
        getContentPane().add(cc18, new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 50, 0, 0));

        cc17.setBackground(new java.awt.Color(255, 255, 255));
        cc17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        cc17.setOpaque(true);
        cc17.setPreferredSize(new java.awt.Dimension(42, 42));
        getContentPane().add(cc17, new org.netbeans.lib.awtextra.AbsoluteConstraints(316, 50, 0, 0));

        cc16.setBackground(new java.awt.Color(255, 255, 255));
        cc16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        cc16.setOpaque(true);
        cc16.setPreferredSize(new java.awt.Dimension(42, 42));
        getContentPane().add(cc16, new org.netbeans.lib.awtextra.AbsoluteConstraints(277, 50, 0, 0));

        cc15.setBackground(new java.awt.Color(255, 255, 255));
        cc15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        cc15.setOpaque(true);
        cc15.setPreferredSize(new java.awt.Dimension(42, 42));
        getContentPane().add(cc15, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 50, 0, 0));

        cc14.setBackground(new java.awt.Color(255, 255, 255));
        cc14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        cc14.setOpaque(true);
        cc14.setPreferredSize(new java.awt.Dimension(42, 42));
        getContentPane().add(cc14, new org.netbeans.lib.awtextra.AbsoluteConstraints(199, 50, 0, 0));

        cc13.setBackground(new java.awt.Color(255, 255, 255));
        cc13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        cc13.setOpaque(true);
        cc13.setPreferredSize(new java.awt.Dimension(42, 42));
        getContentPane().add(cc13, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 0, 0));

        cc12.setBackground(new java.awt.Color(255, 255, 255));
        cc12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        cc12.setOpaque(true);
        cc12.setPreferredSize(new java.awt.Dimension(42, 42));
        getContentPane().add(cc12, new org.netbeans.lib.awtextra.AbsoluteConstraints(589, 11, 0, 0));

        cc11.setBackground(new java.awt.Color(255, 255, 255));
        cc11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        cc11.setOpaque(true);
        cc11.setPreferredSize(new java.awt.Dimension(42, 42));
        getContentPane().add(cc11, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 11, 0, 0));

        cc10.setBackground(new java.awt.Color(255, 255, 255));
        cc10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        cc10.setOpaque(true);
        cc10.setPreferredSize(new java.awt.Dimension(42, 42));
        getContentPane().add(cc10, new org.netbeans.lib.awtextra.AbsoluteConstraints(511, 11, 0, 0));

        cc9.setBackground(new java.awt.Color(255, 255, 255));
        cc9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        cc9.setOpaque(true);
        cc9.setPreferredSize(new java.awt.Dimension(42, 42));
        getContentPane().add(cc9, new org.netbeans.lib.awtextra.AbsoluteConstraints(472, 11, 0, 0));

        cc8.setBackground(new java.awt.Color(255, 255, 255));
        cc8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        cc8.setOpaque(true);
        cc8.setPreferredSize(new java.awt.Dimension(42, 42));
        getContentPane().add(cc8, new org.netbeans.lib.awtextra.AbsoluteConstraints(433, 11, 0, 0));

        cc7.setBackground(new java.awt.Color(255, 255, 255));
        cc7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        cc7.setOpaque(true);
        cc7.setPreferredSize(new java.awt.Dimension(42, 42));
        getContentPane().add(cc7, new org.netbeans.lib.awtextra.AbsoluteConstraints(394, 11, 0, 0));

        cc6.setBackground(new java.awt.Color(255, 255, 255));
        cc6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        cc6.setOpaque(true);
        cc6.setPreferredSize(new java.awt.Dimension(42, 42));
        getContentPane().add(cc6, new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 11, 0, 0));

        cc5.setBackground(new java.awt.Color(255, 255, 255));
        cc5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        cc5.setOpaque(true);
        cc5.setPreferredSize(new java.awt.Dimension(42, 42));
        getContentPane().add(cc5, new org.netbeans.lib.awtextra.AbsoluteConstraints(316, 11, 0, 0));

        cc4.setBackground(new java.awt.Color(255, 255, 255));
        cc4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        cc4.setOpaque(true);
        cc4.setPreferredSize(new java.awt.Dimension(42, 42));
        getContentPane().add(cc4, new org.netbeans.lib.awtextra.AbsoluteConstraints(277, 11, 0, 0));

        cc3.setBackground(new java.awt.Color(255, 255, 255));
        cc3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        cc3.setOpaque(true);
        cc3.setPreferredSize(new java.awt.Dimension(42, 42));
        getContentPane().add(cc3, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 11, 0, 0));

        cc2.setBackground(new java.awt.Color(255, 255, 255));
        cc2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        cc2.setOpaque(true);
        cc2.setPreferredSize(new java.awt.Dimension(42, 42));
        getContentPane().add(cc2, new org.netbeans.lib.awtextra.AbsoluteConstraints(199, 11, 0, 0));

        cc1.setBackground(new java.awt.Color(255, 255, 255));
        cc1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        cc1.setOpaque(true);
        cc1.setPreferredSize(new java.awt.Dimension(42, 42));
        getContentPane().add(cc1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 11, 0, 0));

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
        getContentPane().add(tahi, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 330, -1, -1));

        unidades4.setEditable(false);
        unidades4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        unidades4.setForeground(new java.awt.Color(255, 0, 0));
        unidades4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(unidades4, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 180, 40, 40));

        unidades3.setEditable(false);
        unidades3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        unidades3.setForeground(new java.awt.Color(255, 0, 0));
        unidades3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(unidades3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 230, 40, 40));

        unidades2.setEditable(false);
        unidades2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        unidades2.setForeground(new java.awt.Color(255, 0, 0));
        unidades2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(unidades2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, 40, 40));

        unidades1.setEditable(false);
        unidades1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        unidades1.setForeground(new java.awt.Color(255, 0, 0));
        unidades1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(unidades1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 40, 40));

        cascada2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/objetos/cascada.gif"))); // NOI18N
        cascada2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(cascada2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 147, -1, 105));

        cascada1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/objetos/cascada.gif"))); // NOI18N
        cascada1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(cascada1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 29, -1, -1));

        cascada3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/objetos/cascada.gif"))); // NOI18N
        cascada3.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(cascada3, new org.netbeans.lib.awtextra.AbsoluteConstraints(332, 147, -1, 105));

        cascada4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/objetos/cascada.gif"))); // NOI18N
        cascada4.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(cascada4, new org.netbeans.lib.awtextra.AbsoluteConstraints(332, 29, -1, -1));

        cascada5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/objetos/cascada.gif"))); // NOI18N
        cascada5.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(cascada5, new org.netbeans.lib.awtextra.AbsoluteConstraints(454, 147, -1, 105));

        cascada6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/objetos/cascada.gif"))); // NOI18N
        cascada6.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(cascada6, new org.netbeans.lib.awtextra.AbsoluteConstraints(454, 29, -1, -1));

        cascada7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/objetos/cascada.gif"))); // NOI18N
        cascada7.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(cascada7, new org.netbeans.lib.awtextra.AbsoluteConstraints(576, 29, 17, -1));

        cascada8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/objetos/cascada.gif"))); // NOI18N
        cascada8.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(cascada8, new org.netbeans.lib.awtextra.AbsoluteConstraints(576, 148, 17, 105));

        flecha2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/objetos/flechapuzzle.gif"))); // NOI18N
        getContentPane().add(flecha2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 0, 0));

        flecha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/objetos/flechapuzzle.gif"))); // NOI18N
        getContentPane().add(flecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, -1, -1));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/puzzle/puzzle6/fondo.png"))); // NOI18N
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
              Logger.getLogger(Puzzle6.class.getName()).log(Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(Puzzle6.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Puzzle6.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Puzzle6.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Puzzle6.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Puzzle6().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton SalirBtn;
    private javax.swing.JLabel anterior;
    private javax.swing.JTextField campoPuntaje;
    private javax.swing.JLabel cascada1;
    private javax.swing.JLabel cascada2;
    private javax.swing.JLabel cascada3;
    private javax.swing.JLabel cascada4;
    private javax.swing.JLabel cascada5;
    private javax.swing.JLabel cascada6;
    private javax.swing.JLabel cascada7;
    private javax.swing.JLabel cascada8;
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
    private javax.swing.JTextField cd1;
    private javax.swing.JTextField cd2;
    private javax.swing.JTextField cd3;
    private javax.swing.JTextField cd4;
    private javax.swing.JTextField cn1;
    private javax.swing.JTextField cn2;
    private javax.swing.JTextField cn3;
    private javax.swing.JTextField cn4;
    private javax.swing.JLabel cuadrito;
    private javax.swing.JLabel cuadroDialogo;
    private javax.swing.JLabel flecha;
    private javax.swing.JLabel flecha2;
    private javax.swing.JLabel fondo;
    private javax.swing.JToggleButton iniciarBtn;
    private javax.swing.JToggleButton instruccionesBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JToggleButton opcion1;
    private javax.swing.JToggleButton opcion2;
    private javax.swing.JToggleButton opcion3;
    private javax.swing.JToggleButton opcion4;
    private javax.swing.JTextField reloj;
    private javax.swing.JLabel roca1;
    private javax.swing.JLabel roca2;
    private javax.swing.JLabel roca3;
    private javax.swing.JLabel roca4;
    private javax.swing.JLabel siguiente;
    private javax.swing.JLabel tahi;
    private javax.swing.JTextField unidades1;
    private javax.swing.JTextField unidades2;
    private javax.swing.JTextField unidades3;
    private javax.swing.JTextField unidades4;
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
             case(2): generarFraccion1();break;
             case(3): generarFraccion1();break;   
           }
           
           reloj.setSize(reloj.getPreferredSize());
           new Cronometro().start();    
           
           while(!cronometro)
           {
               try { Thread.sleep(50); } catch (InterruptedException ex) {}
           }           
           cronometro = false;
           
           mostrarRocas();
           
           while(!siguienteFr)
           {
               try { Thread.sleep(50); } catch (InterruptedException ex) {}
           }           
           
           siguienteFr = false;
                              
           limpiarCuadros();
           validarNumeros();
           //reloj.setSize(0,0);
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
           try {
             Thread.sleep(1000);
           } catch (InterruptedException ex) {}
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
          moverAbajo(410);
          tahi.setIcon(posiciones[0]);      
          int zonaAnt = zonaActual;
          zonaActual = -1;
          
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
         moverIzquierda(30); 
         moverArriba(270);
       }
       
       public void zona2(int zonaAnt)
       {
         if(zonaAnt < 2){ moverDerecha(240); }
         else{ moverIzquierda(240); }
         moverArriba(330);
       }
       
       public void zona3(int zonaAnt)
       {
         if(zonaAnt < 3){ moverDerecha(520); }
         else{ moverIzquierda(520); }
         moverArriba(330);
       }
       
       public void zona4(int zonaAnt)
       {   
         moverDerecha(730);         
         moverArriba(270);
       }
    }
    
    public class Dano extends Thread
    {
       @Override
       public void run()
       {
          Icon icon = tahi.getIcon();
          tahi.setIcon(dano);  
          try { Thread.sleep(1200); } catch (InterruptedException ex) {}
          tahi.setIcon(icon);
       }
    }
    
    
    
    public class MovimientoRoca extends Thread
    {
       private JLabel roca;
       private int limite;
       private int sound;
       
       public MovimientoRoca(JLabel roca, int limite, int sound)
       {
         this.roca = roca;
         this.limite = limite;
         this.sound = sound;
       }
       
       @Override
       public void run()
       {
          moverAbajo(limite,2);
          Sonidos.getInstance().reproducir("trueno");
          moverArriba(limite-40,9);
          moverAbajo(490,5);
          roca.setLocation(roca.getX(), -90);
          siguienteFr = true;
       }
       
       public void moverAbajo(int limite, int intervalo)
       {           
          while(roca.getY() < limite)
          { 
            roca.setLocation(roca.getX(),roca.getY()+5);
            try { Thread.sleep(intervalo); } catch (InterruptedException ex) {}           
          } 
       }
       public void moverArriba(int limite, int intervalo)
       {         
          while(roca.getY() > limite)
          {  
            roca.setLocation(roca.getX(),roca.getY()-1);
            try { Thread.sleep(intervalo); } catch (InterruptedException ex) {}            
          }
       } 
    }

}
