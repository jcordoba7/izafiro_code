/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package izafiro;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
public final class Puzzle1 extends javax.swing.JFrame {

    private Icon[] instrucciones;
    private JLabel[] partes;
    private JLabel[] topos;
    private Icon adelanteTopo;
    private Icon atrasTopo;
    private int cont = 1;
    private int numerador;
    private int denominador;
    private int numeradorAnterior = 0;
    private int denominadorAnterior = 0;
    private int puntaje = 0;
    private int puntosPorNivel = 5;
    private int vecesPorNivel = 5;
    private int nivelActual = 1;
    private int numNiveles = 3;
    private double calificacionMinima = 0.75;
    
    /**
     * Creates new form Puzzle1
     */
    public Puzzle1() {
        initComponents();
        this.setLocationRelativeTo(null); this.setIconImage(new ImageIcon (getClass().getResource("izafiroicono.png")).getImage()); Sonidos.getInstance().activarCursor(this);
        
        instrucciones = new Icon[6];         
        instrucciones[0] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle1/instrucciones/1.png"));
        instrucciones[1] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle1/instrucciones/2.png"));
        instrucciones[2] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle1/instrucciones/3.png"));
        instrucciones[3] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle1/instrucciones/4.png"));
        instrucciones[4] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle1/instrucciones/5.png"));
        instrucciones[5] = new ImageIcon (getClass().getResource("imagenes/puzzle/puzzle1/instrucciones/6.png"));
                
        partes = new JLabel[6];
        partes[0] = this.parte1;
        partes[1] = this.parte2;
        partes[2] = this.parte3;
        partes[3] = this.parte4;
        partes[4] = this.parte5;
        partes[5] = this.parte6;
        
        topos = new JLabel[6];
        topos[0] = this.topo1;
        topos[1] = this.topo2;
        topos[2] = this.topo3;
        topos[3] = this.topo4;
        topos[4] = this.topo5;
        topos[5] = this.topo6;
        
        adelanteTopo = new ImageIcon (getClass().getResource("imagenes/personajes/topo/topo1.gif"));
        atrasTopo = new ImageIcon (getClass().getResource("imagenes/personajes/topo/topo2.gif"));
        
        this.tahi.setIcon(new ImageIcon (getClass().getResource("imagenes/personajes/tahi/"+GestorJuego.getInstance().getGenero()+"11.png")));
        this.addKeyListener(new Puzzle1.AL());
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
    
    public void mostrarPartes()
    {
      for(int i = 0; i<partes.length; i++){ partes[i].setSize(partes[i].getPreferredSize()); }  
    }
    
    public void ocultarTopos()
    {
      for(int i = 0; i<topos.length; i++){ topos[i].setSize(0,0); }  
    }
    
    public void ocultarPartes()
    {
      for(int i = 0; i<partes.length; i++){ partes[i].setSize(0,0); }  
    }
    
    public void iniciarPuzzle()
    {
      this.flecha.setSize(0,0);
      this.flecha2.setSize(0,0);
      ocultarTopos();
      mostrarPartes();
      campoNumerador.setText("");
      campoDenominador.setText("");
      
      new Nivel().start();               
      
      iniciarBtn.setSize(0,0);
      instruccionesBtn.setSize(0,0);
      SalirBtn.setSize(0,0);
    }    
    
    public boolean esRepetido(int[] vector, int numero) //dado un vector y un numero se determina si ese numero se encuentra en el vector
    { 
      for(int i=0; i<vector.length; i++)
      {
        if(vector[i] == numero){return true;} 
      }
      return false;
    }   
    
    
    public void generarFraccion1() //solo cambia el numerador, el denominador es 6
    {      
       Random randomGenerator = new Random();
       numerador = 0;
       denominador = 6;
       
       while(numerador == 0 || numerador == numeradorAnterior){
         numerador = randomGenerator.nextInt(7);
       }
       numeradorAnterior = numerador;
       escogerTopos1();
    }
    
    public void generarFraccion2() //solo cambia el numerador, el denominador es 6
    {      
       Random randomGenerator = new Random();
       numerador = 0;
       denominador = 6;
       
       while(numerador == 0 || numerador == numeradorAnterior){
         numerador = randomGenerator.nextInt(7);
       }
       numeradorAnterior = numerador;
       escogerTopos2();
    }
    
    public void generarFraccion3()
    {      
       Random randomGenerator = new Random();
       numerador = 0;
       denominador = 0;
       
       while(denominador == 0 || denominador == denominadorAnterior){
         denominador = randomGenerator.nextInt(7);
       }
       while(numerador == 0){ //no es posible evitar numerador repetitivo por q hay posibilidad de un bucle
         numerador = randomGenerator.nextInt(denominador+1);
       }
       denominadorAnterior = denominador;
       escogerTopos3();       
    }
    
    public void escogerTopos1() //Los topos salen de manera secuencial
    {    
       ocultarTopos(); 
       for(int i=0; i< numerador; i++)
       {
         topos[i].setSize(topos[i].getPreferredSize());
         new MovimientoTopo(topos[i]).start();
       }
       //new Cronometro().start();
    }
    
    public void escogerTopos2() //Los topos salen de manera desordenada (mas dificil para el usuario)
    {
       ocultarTopos(); 
       int numTopos = 0; //numeros irrepetibles 
       int aleatorio;
       int toposQueSeVen[] = new int[numerador]; //Los topos que se verán de manera desordenada
       
       for(int i=0; i<toposQueSeVen.length; i++){toposQueSeVen[i] = -1;} //Inicializo el vector en -1 para evitar problemas con el indice 0.
       
       while(numTopos != numerador)
       {
         Random randomGenerator = new Random();         
         aleatorio = randomGenerator.nextInt(denominador);
         
         if(!esRepetido(toposQueSeVen,aleatorio))
         {
             toposQueSeVen[numTopos]=aleatorio;
             numTopos++;
         }  
       }
        
       for(int i=0; i< toposQueSeVen.length; i++)
       {
         topos[toposQueSeVen[i]].setSize(topos[i].getPreferredSize());  
         new MovimientoTopo(topos[toposQueSeVen[i]]).start();          
       }
    }
    
    public void escogerTopos3() //Los topos salen de manera desordenada y ya varia el denominador (mas dificil para el usuario)
    {
       ocultarTopos();
       ocultarPartes();
       
       int numTopos = 0; //numeros irrepetibles 
       int aleatorio;
       int toposQueSeVen[] = new int[numerador]; //Los topos que se verán de manera desordenada
       
       for(int i=0; i<toposQueSeVen.length; i++){toposQueSeVen[i] = -1;} //Inicializo el vector en -1 para evitar problemas con el indice 0.
       
       while(numTopos != numerador)
       {
         Random randomGenerator = new Random();         
         aleatorio = randomGenerator.nextInt(denominador);
         
         if(!esRepetido(toposQueSeVen,aleatorio))
         {
             toposQueSeVen[numTopos]=aleatorio;
             numTopos++;
         }  
       }
        
       for(int i=0; i< denominador; i++)
       {
         partes[i].setSize(partes[i].getPreferredSize());         
       }
       
       for(int i=0; i< toposQueSeVen.length; i++)
       {
         topos[toposQueSeVen[i]].setSize(topos[i].getPreferredSize());  
         new MovimientoTopo(topos[toposQueSeVen[i]]).start();          
       }
       //new Cronometro().start();
    }
    
    public void validarNumeros()
    {
       int num;
       int den;
       
       if(this.campoNumerador.getText().equals("") || this.campoDenominador.getText().equals("")){
          num=0; den=0;
       }
       else{
         try{
           num = Integer.parseInt(this.campoNumerador.getText());
           den = Integer.parseInt(this.campoDenominador.getText());    }
         catch(NumberFormatException e){
           num = 0;
           den = 0;
         }
       }
       
       if(num == this.numerador && den == this.denominador){
           Sonidos.getInstance().reproducir("success2");
           JOptionPane.showMessageDialog(null, "BIEN!!!\nTienes +"+ puntosPorNivel +" puntos!!", "Correcto", JOptionPane.PLAIN_MESSAGE, new ImageIcon (getClass().getResource("imagenes/objetos/check.png"))); 
           aumentarPuntaje();
       }
       else{
           Sonidos.getInstance().reproducir("error");
           JOptionPane.showMessageDialog(null, "Vaya...  :( \nTe has equivocado!","Incorrecto",0);
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
    
    public class AL extends KeyAdapter
    {    
        //Icon noImage = new ImageIcon (getClass().getResource("imagenes/noimage.png"));
        //int cont = 0; //bandera para mostrar los mensajes que abren e juego.
        
        @Override
        public void keyPressed(KeyEvent e)
        {
            int keyCode = e.getKeyCode();            
                       
            switch(keyCode)
            {
                case (KeyEvent.VK_SPACE):                                       
                                            break;
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

        siguiente = new javax.swing.JLabel();
        anterior = new javax.swing.JLabel();
        cuadroDialogo = new javax.swing.JLabel();
        SalirBtn = new javax.swing.JToggleButton();
        iniciarBtn = new javax.swing.JToggleButton();
        instruccionesBtn = new javax.swing.JToggleButton();
        campoNumerador = new javax.swing.JTextField();
        campoDenominador = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tahi = new javax.swing.JLabel();
        topo1 = new javax.swing.JLabel();
        topo2 = new javax.swing.JLabel();
        topo3 = new javax.swing.JLabel();
        topo4 = new javax.swing.JLabel();
        topo5 = new javax.swing.JLabel();
        topo6 = new javax.swing.JLabel();
        parte1 = new javax.swing.JLabel();
        parte2 = new javax.swing.JLabel();
        parte3 = new javax.swing.JLabel();
        parte4 = new javax.swing.JLabel();
        parte5 = new javax.swing.JLabel();
        parte6 = new javax.swing.JLabel();
        campoPuntaje = new javax.swing.JTextField();
        flecha2 = new javax.swing.JLabel();
        flecha = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("iZafiro - Bosque de las Luciérnagas");
        setMaximumSize(new java.awt.Dimension(504, 489));
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

        campoNumerador.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        campoNumerador.setForeground(new java.awt.Color(0, 102, 0));
        campoNumerador.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(campoNumerador, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 360, 50, 40));

        campoDenominador.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        campoDenominador.setForeground(new java.awt.Color(0, 102, 0));
        campoDenominador.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(campoDenominador, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 420, 50, 40));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Puntaje");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, 90, 20));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Denominador");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 430, 100, 20));

        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 153), 3));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(215, 407, 80, 6));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Numerador");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 370, 90, 20));

        tahi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/personajes/tahi/tahi11.png"))); // NOI18N
        getContentPane().add(tahi, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 350, -1, -1));

        topo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/personajes/topo/topo1.gif"))); // NOI18N
        getContentPane().add(topo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, -1, -1));

        topo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/personajes/topo/topo1.gif"))); // NOI18N
        getContentPane().add(topo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, -1, -1));

        topo3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/personajes/topo/topo1.gif"))); // NOI18N
        getContentPane().add(topo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(215, 110, -1, -1));

        topo4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/personajes/topo/topo1.gif"))); // NOI18N
        getContentPane().add(topo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(247, 110, -1, -1));

        topo5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/personajes/topo/topo1.gif"))); // NOI18N
        getContentPane().add(topo5, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 110, -1, -1));

        topo6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/personajes/topo/topo1.gif"))); // NOI18N
        getContentPane().add(topo6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 110, -1, -1));

        parte1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/puzzle/puzzle1/cosecha1.png"))); // NOI18N
        getContentPane().add(parte1, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 110, -1, -1));

        parte2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/puzzle/puzzle1/cosecha2.png"))); // NOI18N
        getContentPane().add(parte2, new org.netbeans.lib.awtextra.AbsoluteConstraints(179, 110, -1, -1));

        parte3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/puzzle/puzzle1/cosecha3.png"))); // NOI18N
        getContentPane().add(parte3, new org.netbeans.lib.awtextra.AbsoluteConstraints(211, 110, -1, -1));

        parte4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/puzzle/puzzle1/cosecha4.png"))); // NOI18N
        getContentPane().add(parte4, new org.netbeans.lib.awtextra.AbsoluteConstraints(243, 110, -1, -1));

        parte5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/puzzle/puzzle1/cosecha5.png"))); // NOI18N
        getContentPane().add(parte5, new org.netbeans.lib.awtextra.AbsoluteConstraints(275, 110, -1, -1));

        parte6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/puzzle/puzzle1/cosecha6.png"))); // NOI18N
        getContentPane().add(parte6, new org.netbeans.lib.awtextra.AbsoluteConstraints(307, 110, -1, -1));

        campoPuntaje.setEditable(false);
        campoPuntaje.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        campoPuntaje.setForeground(new java.awt.Color(0, 0, 153));
        campoPuntaje.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoPuntaje.setText("0");
        getContentPane().add(campoPuntaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(449, 10, 50, 40));

        flecha2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/objetos/flechapuzzle.gif"))); // NOI18N
        getContentPane().add(flecha2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 400, 0, 0));

        flecha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/objetos/flechapuzzle.gif"))); // NOI18N
        getContentPane().add(flecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 430, -1, -1));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/izafiro/imagenes/puzzle/puzzle1/p1.png"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void instruccionesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_instruccionesBtnActionPerformed
        // TODO add your handling code here:
        mostrarInstrucciones();
    }//GEN-LAST:event_instruccionesBtnActionPerformed

    private void iniciarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iniciarBtnActionPerformed
        // TODO add your handling code here:
        if(cuadroDialogo.getSize().width == 0){iniciarPuzzle();}
        else{JOptionPane.showMessageDialog(null, "Termina de leer las instrucciones.");}
    }//GEN-LAST:event_iniciarBtnActionPerformed

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
              Logger.getLogger(Puzzle1.class.getName()).log(Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(Puzzle1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Puzzle1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Puzzle1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Puzzle1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Puzzle1().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton SalirBtn;
    private javax.swing.JLabel anterior;
    private javax.swing.JTextField campoDenominador;
    private javax.swing.JTextField campoNumerador;
    private javax.swing.JTextField campoPuntaje;
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
    private javax.swing.JLabel parte1;
    private javax.swing.JLabel parte2;
    private javax.swing.JLabel parte3;
    private javax.swing.JLabel parte4;
    private javax.swing.JLabel parte5;
    private javax.swing.JLabel parte6;
    private javax.swing.JLabel siguiente;
    private javax.swing.JLabel tahi;
    private javax.swing.JLabel topo1;
    private javax.swing.JLabel topo2;
    private javax.swing.JLabel topo3;
    private javax.swing.JLabel topo4;
    private javax.swing.JLabel topo5;
    private javax.swing.JLabel topo6;
    // End of variables declaration//GEN-END:variables
   
        
        
    public class Nivel extends Thread
    {
      @Override
      public void run()
      {
        JOptionPane.showMessageDialog(null, "... NIVEL "+ nivelActual +" ...");  
        for(int j=0; j<vecesPorNivel; j++)  
        {
          switch(nivelActual)
          {
            case(1): generarFraccion1();break;
            case(2): generarFraccion2();break;
            case(3): generarFraccion3();break;
          }
            
          try { Thread.sleep(5800); } catch (InterruptedException ex) {}
          validarNumeros();
        }
        pasarSiguienteNivel();        
      }
    }
    
    
    public class MovimientoTopo extends Thread
    {
       JLabel topo; 
    
       public MovimientoTopo(JLabel topo)
       {
         this.topo = topo;  
       }
       
       @Override
       public void run()
       { 
         for(int j=0; j<1; j++)
         {
           topo.setIcon(adelanteTopo);
           for(int i=0; i < 200; i++)
           {
             topo.setLocation(topo.getX(),topo.getY()+1); 
             try {
               Thread.sleep(14);
             } catch (InterruptedException ex) {}
           }
           topo.setIcon(atrasTopo);
           for(int i=0; i < 200; i++)
           {
             topo.setLocation(topo.getX(),topo.getY()-1); 
             try {
               Thread.sleep(15);
             } catch (InterruptedException ex) {}
           }
         }
         topo.setIcon(adelanteTopo);         
       }
    }
}


