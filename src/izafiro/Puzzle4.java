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

/**
 *
 * @author Jonathan
 */
public final class Puzzle4 extends javax.swing.JFrame {

    private Icon[] instrucciones;
    private int cont = 1;
    private int numCuadros;
    private int[] imagenes;
    private int[] posiciones;
    private int[] pareja;
    private String[] carpeta;
    private String[] posicionesCarpeta;
    private boolean[] disponible;
    private JLabel[] cuadros;
    private int segundos;
    private int puntaje = 0;   
    private int nivelActual = 1;
    private int numNiveles = 3;
    
    /**
     * Creates new form Puzzle4
     */
    public Puzzle4() {
        initComponents();
        this.setLocationRelativeTo(null); this.setIconImage(new ImageIcon (getClass().getResource("izafiroicono.png")).getImage()); Sonidos.getInstance().activarCursor(this);
        
        instrucciones = new Icon[11];         
        instrucciones[0] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle4/instrucciones/1.png"));
        instrucciones[1] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle4/instrucciones/2.png"));
        instrucciones[2] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle4/instrucciones/3.png"));
        instrucciones[3] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle4/instrucciones/4.png"));
        instrucciones[4] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle4/instrucciones/5.png"));
        instrucciones[5] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle4/instrucciones/6.png"));
        instrucciones[6] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle4/instrucciones/7.png"));
        instrucciones[7] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle4/instrucciones/8.png"));
        instrucciones[8] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle4/instrucciones/9.png"));
        instrucciones[9] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle4/instrucciones/10.png"));
        instrucciones[10] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle4/instrucciones/11.png"));
          
        numCuadros = 16;
        
        imagenes = new int[numCuadros];
        posiciones = new int[numCuadros];
        pareja = new int[2];
        carpeta = new String[numCuadros];
        posicionesCarpeta = new String[numCuadros];
        disponible = new boolean[numCuadros];
        cuadros = new JLabel[numCuadros];// toca de a 20 por que hay 20 JLabels
        
        inicializarArreglos();
        
        pareja[0] = -1;
        pareja[1] = -1; 
        
        cuadros[0] = c1;cuadros[1] = c2;cuadros[2] = c3;cuadros[3] = c4;
        cuadros[4] = c5;cuadros[5] = c6;cuadros[6] = c7;cuadros[7] = c8;
        cuadros[8] = c9;cuadros[9] = c10;cuadros[10] = c11;cuadros[11] = c12;
        cuadros[12] = c13;cuadros[13] = c14;cuadros[14] = c15;cuadros[15] = c16;      
        
        this.tahi.setIcon(new ImageIcon (getClass().getResource("imagenes/personajes/tahi/"+GestorJuego.getInstance().getGenero()+"11.png")));
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
      bloqueo.setSize(0,0);
      this.flecha.setSize(0,0);
      this.flecha2.setSize(0,0);
        
      JOptionPane.showMessageDialog(null, "... NIVEL "+ nivelActual +" ...");
          
      switch(nivelActual)
      {
          case 1: llenarMatriz(numCuadros/2);mostrarCuadros();
                  break; 
          case 2: llenarMatriz(numCuadros);mostrarCuadros();
                  break; 
          case 3: llenarMatriz(numCuadros);//vaciarCuadro();
                  break;
      }
      
      new Cronometro(nivelActual).start();
      
      iniciarBtn.setSize(0,0);
      instruccionesBtn.setSize(0,0);
      SalirBtn.setSize(0,0);
    }
    
    
    public void inicializarArreglos()
    {
        for( int i=0; i<imagenes.length; i++ ){ imagenes[i] = -1; }
        
        for( int i=0; i<posiciones.length; i++ ){ posiciones[i] = -1; }
        
        for( int i=0; i<disponible.length; i++ ){ disponible[i] = true; }
    }
    
    public void llenarMatriz(int num)
    {
        repartirImagenes(num);
        ubicarImagenes();
    }
    
    public void repartirImagenes(int num)
    {    
        Random randomGenerator = new Random();
        int numRandom = randomGenerator.nextInt(num);  
               
        int i = 0;
        while( i != numCuadros/2 )
        {
           boolean repetido = false;
           for( int j = 0; j<numCuadros/2; j++ )
           {
              if( imagenes[j] == numRandom )
              {
                repetido = true;  
              }
           }
           if( repetido == false )
           {
              imagenes[i] = numRandom;  
              carpeta[i] = "operaciones/";
              i ++;
           }           
           numRandom = randomGenerator.nextInt(num);         
        }
        
        for( int j=0; j<numCuadros/2; j++ )
        {
           imagenes[(numCuadros/2)+j] = imagenes[j];
           carpeta[(numCuadros/2)+j] = "resultados/";
        }        
    }
    
    public void ubicarImagenes()
    {
        Random randomGenerator = new Random();
        int numRandom = randomGenerator.nextInt(numCuadros);
        
        for( int i=0; i<numCuadros; i++ )
        {
           boolean asignado = false;
           while( asignado == false )
           {
             if( posiciones[numRandom] == -1 )
             {
                 posiciones[numRandom] = imagenes[i]; 
                 posicionesCarpeta[numRandom] = carpeta[i];
                 
                 asignado = true;             
             }             
             numRandom = randomGenerator.nextInt(numCuadros);             
           }
        }       
    }
    
    
    public void vaciarCuadro()
    {
        for(int i=0; i<numCuadros; i++)
        {
          if( posiciones[i] != -1  )
          {              
             cuadros[i].setIcon(new ImageIcon(getClass().getResource("imagenes/puzzle/puzzle4/interrogacion.png"))); 
          }          
        }        
    }
    
    
    public void esconderCuadros()
    {
        for(int i=0; i<numCuadros; i++)
        {
          cuadros[i].setSize(cuadros[i].getPreferredSize()); 
          cuadros[i].setIcon(new ImageIcon(getClass().getResource("imagenes/puzzle/puzzle4/interrogacion.png"))); 
        }
    }
    
    
    public void mostrarCuadros()
    {
        for(int i=0; i<numCuadros; i++)
        {
          cuadros[i].setSize(cuadros[i].getPreferredSize());  
          cuadros[i].setIcon(new ImageIcon(getClass().getResource("imagenes/puzzle/puzzle4/"+posicionesCarpeta[i]+posiciones[i] + ".png")));
        }        
    }
    
    
    public boolean parejaCompleta()
    {
        boolean completa = false;
        
        if( (pareja[0] != -1) && (pareja[1] != -1) )
        {
           completa = true; 
        }        
        return completa;
    }
    
    
    public void desabilitarFotos()
    {        
       for(int i=0; i<posiciones.length; i++)
       {
         if( (posiciones[i] == pareja[0]) || (posiciones[i] == pareja[1]) )
         {   
           if(nivelActual != numNiveles){cuadros[i].setSize(0,0);cuadros[i].setBackground(Color.WHITE);}  //se esconden los cuadros
           posiciones[i] = -1;
         }     
       }  
    }
    
    public void limpiarPareja()
    {        
        for( int i=0; i<numCuadros; i++  )
        {
          disponible[i] = true;
          if(nivelActual != numNiveles){cuadros[i].setBackground(Color.white);}               
        }        
        pareja[0] = -1;
        pareja[1] = -1;       
    }
    
    
    public void validarJugada(int i)
    {
        if(bloqueo.getSize().getHeight() == 0) //no hay bloqueo
        { 
            if( disponible[i] == true )
            {
                disponible[i] = false;    
                cuadros[i].setIcon(new ImageIcon(getClass().getResource("imagenes/puzzle/puzzle4/"+posicionesCarpeta[i]+posiciones[i] + ".png")));
                if(nivelActual != numNiveles){cuadros[i].setBackground(Color.lightGray);}
        
                if( pareja[0] == -1 )
                {
                    pareja[0] = posiciones[i]; 
                }
                else
                {
                    pareja[1] = posiciones[i];

                    if( pareja[0] == pareja[1] )  // Se encontró una Pareja.
                    {
                        Sonidos.getInstance().reproducir("success2");   
                        JOptionPane.showMessageDialog(null, "Bien! ...\nHas encontrado una nueva pareja!");
                        desabilitarFotos();
                        limpiarPareja();
                        pasarSiguienteNivel();
                    }
                    else
                    {
                        Sonidos.getInstance().reproducir("error");  
                        JOptionPane.showMessageDialog(null, "Ops ...\nInténtalo de nuevo.","Mensaje",0);                
                        if(nivelActual == 3){vaciarCuadro();}
                        limpiarPareja();
                    }
                }
            } 
        }
    }
    
    public void aumentarPuntaje()
    {
       if(segundos < 60)
       {
          puntaje += 30; 
       }
       else if(segundos < 120)
       {
          puntaje += 20; 
       }
       else if(segundos < 180)
       {
          puntaje += 10; 
       }
       
       this.campoPuntaje.setText(puntaje+"");
    }
    
    public void pasarSiguienteNivel()
    {
        boolean finNivel = true;
        
        for( int i=0; i<numCuadros; i++ )
        {
           if( posiciones[i] != -1 )
           {
              finNivel = false;               
           }
        }
        
        if( finNivel )
        {
           if(nivelActual == numNiveles) 
           {
              esconderCuadros();              
              JOptionPane.showMessageDialog(null, "Has terminado el nivel " + (nivelActual) +" \ncon un tiempo de "+segundos+" segundos!");
              Sonidos.getInstance().reproducir("nuevorecurso"); 
              JOptionPane.showMessageDialog(null, "Enhorabuena! ...\nHas completado la prueba con EXITO!!!","Correcto", JOptionPane.PLAIN_MESSAGE, new ImageIcon (getClass().getResource("imagenes/objetos/check.png"))); 
              aumentarPuntaje();              
              JOptionPane.showMessageDialog(null, "Haz hecho un puntaje de "+ puntaje + "/" + (30*3) + " en este juego!! ...");
              this.dispose(); 
              PruebaPuzzle.getInstance().cerrarActividad(this,puntaje);
           }
           else
           {               
              iniciarBtn.setSize(iniciarBtn.getPreferredSize());
              instruccionesBtn.setSize(instruccionesBtn.getPreferredSize()); 
              SalirBtn.setSize(SalirBtn.getPreferredSize());
              bloqueo.setSize(bloqueo.getPreferredSize());
              nivelActual++;
              inicializarArreglos();
              esconderCuadros();
              JOptionPane.showMessageDialog(null, "Has terminado el nivel " + (nivelActual-1) +" \ncon un tiempo de "+segundos+" segundos!");
              aumentarPuntaje();
              Sonidos.getInstance().reproducir("success1"); 
              JOptionPane.showMessageDialog(null, "Bien! ...\nAhora puedes pasar al Nivel " + (nivelActual) +" dando\nclick en iniciar.");
              this.flecha2.setSize(flecha2.getPreferredSize());
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

        jLabel4 = new javax.swing.JLabel();
        siguiente = new javax.swing.JLabel();
        anterior = new javax.swing.JLabel();
        cuadroDialogo = new javax.swing.JLabel();
        campoPuntaje = new javax.swing.JTextField();
        flecha2 = new javax.swing.JLabel();
        bloqueo = new javax.swing.JLabel();
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
        c13 = new javax.swing.JLabel();
        c14 = new javax.swing.JLabel();
        c15 = new javax.swing.JLabel();
        c16 = new javax.swing.JLabel();
        tahi = new javax.swing.JLabel();
        SalirBtn = new javax.swing.JToggleButton();
        iniciarBtn = new javax.swing.JToggleButton();
        instruccionesBtn = new javax.swing.JToggleButton();
        flecha = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("iZafiro - Bosque de las Luciérnagas");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Puntaje");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 20));

        siguiente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        siguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/botones/flecha-siguiente.png"))); // NOI18N
        siguiente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        siguiente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                siguienteMouseClicked(evt);
            }
        });
        getContentPane().add(siguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(489, 220, 0, 0));

        anterior.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        anterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/botones/flecha-anterior.png"))); // NOI18N
        anterior.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        anterior.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                anteriorMouseClicked(evt);
            }
        });
        getContentPane().add(anterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 220, 0, 0));

        cuadroDialogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cuadroDialogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/puzzle/puzzle1/instrucciones/1.png"))); // NOI18N
        getContentPane().add(cuadroDialogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 0, 0));

        campoPuntaje.setEditable(false);
        campoPuntaje.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        campoPuntaje.setForeground(new java.awt.Color(0, 0, 153));
        campoPuntaje.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoPuntaje.setText("0");
        getContentPane().add(campoPuntaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 50, 40));

        flecha2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/objetos/flechapuzzle.gif"))); // NOI18N
        getContentPane().add(flecha2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 380, 0, 0));

        bloqueo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/tiempo/dia1.png"))); // NOI18N
        getContentPane().add(bloqueo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 440, 400));

        c1.setBackground(new java.awt.Color(255, 255, 255));
        c1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        c1.setForeground(new java.awt.Color(204, 0, 0));
        c1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/puzzle/puzzle4/interrogacion.png"))); // NOI18N
        c1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 3));
        c1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        c1.setOpaque(true);
        c1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                c1MouseClicked(evt);
            }
        });
        getContentPane().add(c1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 80, 80));

        c2.setBackground(new java.awt.Color(255, 255, 255));
        c2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        c2.setForeground(new java.awt.Color(0, 0, 153));
        c2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/puzzle/puzzle4/interrogacion.png"))); // NOI18N
        c2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 3));
        c2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        c2.setOpaque(true);
        c2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                c2MouseClicked(evt);
            }
        });
        getContentPane().add(c2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, 80, 80));

        c3.setBackground(new java.awt.Color(255, 255, 255));
        c3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        c3.setForeground(new java.awt.Color(0, 102, 0));
        c3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/puzzle/puzzle4/interrogacion.png"))); // NOI18N
        c3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 3));
        c3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        c3.setOpaque(true);
        c3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                c3MouseClicked(evt);
            }
        });
        getContentPane().add(c3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, 80, 80));

        c4.setBackground(new java.awt.Color(255, 255, 255));
        c4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        c4.setForeground(new java.awt.Color(0, 0, 153));
        c4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/puzzle/puzzle4/interrogacion.png"))); // NOI18N
        c4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 3));
        c4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        c4.setOpaque(true);
        c4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                c4MouseClicked(evt);
            }
        });
        getContentPane().add(c4, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, 80, 80));

        c5.setBackground(new java.awt.Color(255, 255, 255));
        c5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        c5.setForeground(new java.awt.Color(0, 102, 0));
        c5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/puzzle/puzzle4/interrogacion.png"))); // NOI18N
        c5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 3));
        c5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        c5.setOpaque(true);
        c5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                c5MouseClicked(evt);
            }
        });
        getContentPane().add(c5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 80, 80));

        c6.setBackground(new java.awt.Color(255, 255, 255));
        c6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        c6.setForeground(new java.awt.Color(0, 0, 153));
        c6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/puzzle/puzzle4/interrogacion.png"))); // NOI18N
        c6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 3));
        c6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        c6.setOpaque(true);
        c6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                c6MouseClicked(evt);
            }
        });
        getContentPane().add(c6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, 80, 80));

        c7.setBackground(new java.awt.Color(255, 255, 255));
        c7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        c7.setForeground(new java.awt.Color(204, 0, 0));
        c7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/puzzle/puzzle4/interrogacion.png"))); // NOI18N
        c7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 3));
        c7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        c7.setOpaque(true);
        c7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                c7MouseClicked(evt);
            }
        });
        getContentPane().add(c7, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 120, 80, 80));

        c8.setBackground(new java.awt.Color(255, 255, 255));
        c8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        c8.setForeground(new java.awt.Color(0, 0, 153));
        c8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/puzzle/puzzle4/interrogacion.png"))); // NOI18N
        c8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 3));
        c8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        c8.setOpaque(true);
        c8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                c8MouseClicked(evt);
            }
        });
        getContentPane().add(c8, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 120, 80, 80));

        c9.setBackground(new java.awt.Color(255, 255, 255));
        c9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        c9.setForeground(new java.awt.Color(204, 0, 0));
        c9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/puzzle/puzzle4/interrogacion.png"))); // NOI18N
        c9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 3));
        c9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        c9.setOpaque(true);
        c9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                c9MouseClicked(evt);
            }
        });
        getContentPane().add(c9, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, 80, 80));

        c10.setBackground(new java.awt.Color(255, 255, 255));
        c10.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        c10.setForeground(new java.awt.Color(0, 0, 153));
        c10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/puzzle/puzzle4/interrogacion.png"))); // NOI18N
        c10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 3));
        c10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        c10.setOpaque(true);
        c10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                c10MouseClicked(evt);
            }
        });
        getContentPane().add(c10, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 220, 80, 80));

        c11.setBackground(new java.awt.Color(255, 255, 255));
        c11.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        c11.setForeground(new java.awt.Color(0, 0, 153));
        c11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/puzzle/puzzle4/interrogacion.png"))); // NOI18N
        c11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 3));
        c11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        c11.setOpaque(true);
        c11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                c11MouseClicked(evt);
            }
        });
        getContentPane().add(c11, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 220, 80, 80));

        c12.setBackground(new java.awt.Color(255, 255, 255));
        c12.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        c12.setForeground(new java.awt.Color(204, 0, 0));
        c12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/puzzle/puzzle4/interrogacion.png"))); // NOI18N
        c12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 3));
        c12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        c12.setOpaque(true);
        c12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                c12MouseClicked(evt);
            }
        });
        getContentPane().add(c12, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 220, 80, 80));

        c13.setBackground(new java.awt.Color(255, 255, 255));
        c13.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        c13.setForeground(new java.awt.Color(0, 0, 153));
        c13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/puzzle/puzzle4/interrogacion.png"))); // NOI18N
        c13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 3));
        c13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        c13.setOpaque(true);
        c13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                c13MouseClicked(evt);
            }
        });
        getContentPane().add(c13, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 320, 80, 80));

        c14.setBackground(new java.awt.Color(255, 255, 255));
        c14.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        c14.setForeground(new java.awt.Color(204, 0, 0));
        c14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/puzzle/puzzle4/interrogacion.png"))); // NOI18N
        c14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 3));
        c14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        c14.setOpaque(true);
        c14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                c14MouseClicked(evt);
            }
        });
        getContentPane().add(c14, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 320, 80, 80));

        c15.setBackground(new java.awt.Color(255, 255, 255));
        c15.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        c15.setForeground(new java.awt.Color(0, 0, 153));
        c15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/puzzle/puzzle4/interrogacion.png"))); // NOI18N
        c15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 3));
        c15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        c15.setOpaque(true);
        c15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                c15MouseClicked(evt);
            }
        });
        getContentPane().add(c15, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 320, 80, 80));

        c16.setBackground(new java.awt.Color(255, 255, 255));
        c16.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        c16.setForeground(new java.awt.Color(0, 102, 0));
        c16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/puzzle/puzzle4/interrogacion.png"))); // NOI18N
        c16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 3));
        c16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        c16.setOpaque(true);
        c16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                c16MouseClicked(evt);
            }
        });
        getContentPane().add(c16, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 320, 80, 80));

        tahi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/personajes/tahi/tahi11.png"))); // NOI18N
        getContentPane().add(tahi, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 420, -1, -1));

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
        getContentPane().add(SalirBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, 110, -1));

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
        getContentPane().add(iniciarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 110, -1));

        instruccionesBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        instruccionesBtn.setForeground(new java.awt.Color(0, 102, 0));
        instruccionesBtn.setText("Instrucciones");
        instruccionesBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        instruccionesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                instruccionesBtnActionPerformed(evt);
            }
        });
        getContentPane().add(instruccionesBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, -1, -1));

        flecha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/objetos/flechapuzzle.gif"))); // NOI18N
        getContentPane().add(flecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 410, -1, -1));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/puzzle/puzzle4/fondo.png"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void c1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c1MouseClicked
        // TODO add your handling code here:
        validarJugada(0);
    }//GEN-LAST:event_c1MouseClicked

    private void c2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c2MouseClicked
        // TODO add your handling code here:
        validarJugada(1);
    }//GEN-LAST:event_c2MouseClicked

    private void c3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c3MouseClicked
        // TODO add your handling code here:
        validarJugada(2);
    }//GEN-LAST:event_c3MouseClicked

    private void c4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c4MouseClicked
        // TODO add your handling code here:
        validarJugada(3);
    }//GEN-LAST:event_c4MouseClicked

    private void c5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c5MouseClicked
        // TODO add your handling code here:
        validarJugada(4);
    }//GEN-LAST:event_c5MouseClicked

    private void c8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c8MouseClicked
        // TODO add your handling code here:
        validarJugada(7);
    }//GEN-LAST:event_c8MouseClicked

    private void c6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c6MouseClicked
        // TODO add your handling code here:
        validarJugada(5);
    }//GEN-LAST:event_c6MouseClicked

    private void c7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c7MouseClicked
        // TODO add your handling code here:
        validarJugada(6);
    }//GEN-LAST:event_c7MouseClicked

    private void c9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c9MouseClicked
        // TODO add your handling code here:
        validarJugada(8);
    }//GEN-LAST:event_c9MouseClicked

    private void c10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c10MouseClicked
        // TODO add your handling code here:
        validarJugada(9);
    }//GEN-LAST:event_c10MouseClicked

    private void c11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c11MouseClicked
        // TODO add your handling code here:
        validarJugada(10);
    }//GEN-LAST:event_c11MouseClicked

    private void c12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c12MouseClicked
        // TODO add your handling code here:
        validarJugada(11);
    }//GEN-LAST:event_c12MouseClicked

    private void c13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c13MouseClicked
        // TODO add your handling code here:
        validarJugada(12);
    }//GEN-LAST:event_c13MouseClicked

    private void c14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c14MouseClicked
        // TODO add your handling code here:
        validarJugada(13);
    }//GEN-LAST:event_c14MouseClicked

    private void c15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c15MouseClicked
        // TODO add your handling code here:
        validarJugada(14);
    }//GEN-LAST:event_c15MouseClicked

    private void c16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c16MouseClicked
        // TODO add your handling code here:
        validarJugada(15);
    }//GEN-LAST:event_c16MouseClicked

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
              Logger.getLogger(Puzzle4.class.getName()).log(Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(Puzzle4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Puzzle4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Puzzle4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Puzzle4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Puzzle4().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton SalirBtn;
    private javax.swing.JLabel anterior;
    private javax.swing.JLabel bloqueo;
    private javax.swing.JLabel c1;
    private javax.swing.JLabel c10;
    private javax.swing.JLabel c11;
    private javax.swing.JLabel c12;
    private javax.swing.JLabel c13;
    private javax.swing.JLabel c14;
    private javax.swing.JLabel c15;
    private javax.swing.JLabel c16;
    private javax.swing.JLabel c2;
    private javax.swing.JLabel c3;
    private javax.swing.JLabel c4;
    private javax.swing.JLabel c5;
    private javax.swing.JLabel c6;
    private javax.swing.JLabel c7;
    private javax.swing.JLabel c8;
    private javax.swing.JLabel c9;
    private javax.swing.JTextField campoPuntaje;
    private javax.swing.JLabel cuadroDialogo;
    private javax.swing.JLabel flecha;
    private javax.swing.JLabel flecha2;
    private javax.swing.JLabel fondo;
    private javax.swing.JToggleButton iniciarBtn;
    private javax.swing.JToggleButton instruccionesBtn;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel siguiente;
    private javax.swing.JLabel tahi;
    // End of variables declaration//GEN-END:variables

    public class Cronometro extends Thread
    {
       private int nivel; 
       
       public Cronometro(int nivel)
       {
         this.nivel = nivel;  
       }
       
       @Override
       public void run()
       {
          segundos = 0; 
          while(nivel == nivelActual)
          {
            try {
              Thread.sleep(1000);
            } catch (InterruptedException ex) {}  
            segundos++; 
          }
       }
    }

}
