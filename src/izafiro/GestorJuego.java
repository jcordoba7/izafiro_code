/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package izafiro;

import java.awt.Point;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Jacc89
 */
public class GestorJuego {
    
    private static GestorJuego partida = null;

    /**
     * @return the tahi
     */
    public static GestorJuego getPartida() {
        return partida;
    }

    /**
     * @param nuevaPartida the tahi to set
     */
    public static void setPartida(GestorJuego nuevaPartida) {
        partida = nuevaPartida;
    }
    
    private boolean[] recursos;
    private int salud;
    private JFrame[][] vJF;//Es necesario para actualizar la salud de tahi en todos los escenarios
    private int[] escenarioInicial; 
    private JFrame escenarioActual;
    private Point ubicacionInicial;
    private int puntaje;
    private boolean[] puertas;//Indica que puertas se han abierto con las diferentes llaves
    private boolean[] msnApertura;//Indica que mensajes de apertura se han mostrado
    
    private Icon[] imagenesSalud;
    private Icon[] numerosPuntaje;
    
    private String genero; //Las unicas opciones son lily o tahi, dependiendo de si el jugador es niño o niña
    private String usuario;
    private String password;
    private int ubicacionBD; //0 si la BD  es remota, 1 si la BD es local.
    private int speed; //velocidad del desplazamiento del jugador
    private int frecuencia; //Frecuencia del movimiento de pies de Tahi
    private boolean terminarJuego;  
    
    private boolean juegoIniciado = false; //Utilizado como bandera para resaltar las teclas especiales solo una vez
    private boolean sesionIniciada = false; //Utilizado com bandera para cerrar o no la aplicacion despues de que los creditos sean mostrados    
    
    private GestorJuego()
    { 
       recursos = new boolean[6];
       for(int i=0; i<recursos.length; i++){ recursos[i] = false; }
       
       puertas = new boolean[8];
       for(int i=0; i<puertas.length; i++){ puertas[i] = false; }
       
       msnApertura = new boolean[9];
       for(int i=0; i<msnApertura.length; i++){ msnApertura[i] = false; }
       
       //----- Edicion del Juegoooo ------
       //recursos[3] = true;
       /*recursos[0] = true;
       recursos[2] = true;
       recursos[4] = true;
       recursos[5] = true;*/
       
       //puertas[2] = true;
       //puertas[4] = true;
       //puertas[6] = true;
       //---------------------------------      
       
       salud = 5;  
       puntaje = 0;
       speed = 5;
       frecuencia = 3;
       escenarioInicial = new int[2];
       genero = "tahi";
       usuario = "";
       password = "";
       terminarJuego = false;
       vJF = null;
       
       imagenesSalud = new Icon[6];
       imagenesSalud[0] = new ImageIcon (getClass().getResource("imagenes/barra/salud0.PNG"));
       imagenesSalud[1] = new ImageIcon (getClass().getResource("imagenes/barra/salud1.PNG"));
       imagenesSalud[2] = new ImageIcon (getClass().getResource("imagenes/barra/salud2.PNG"));
       imagenesSalud[3] = new ImageIcon (getClass().getResource("imagenes/barra/salud3.PNG"));
       imagenesSalud[4] = new ImageIcon (getClass().getResource("imagenes/barra/salud4.PNG"));
       imagenesSalud[5] = new ImageIcon (getClass().getResource("imagenes/barra/salud5.PNG"));
       
       numerosPuntaje = new Icon[10];
       numerosPuntaje[0] = new ImageIcon (getClass().getResource("imagenes/barra/numerospuntaje/0.png"));
       numerosPuntaje[1] = new ImageIcon (getClass().getResource("imagenes/barra/numerospuntaje/1.png"));
       numerosPuntaje[2] = new ImageIcon (getClass().getResource("imagenes/barra/numerospuntaje/2.png"));
       numerosPuntaje[3] = new ImageIcon (getClass().getResource("imagenes/barra/numerospuntaje/3.png"));
       numerosPuntaje[4] = new ImageIcon (getClass().getResource("imagenes/barra/numerospuntaje/4.png"));
       numerosPuntaje[5] = new ImageIcon (getClass().getResource("imagenes/barra/numerospuntaje/5.png"));
       numerosPuntaje[6] = new ImageIcon (getClass().getResource("imagenes/barra/numerospuntaje/6.png"));
       numerosPuntaje[7] = new ImageIcon (getClass().getResource("imagenes/barra/numerospuntaje/7.png"));
       numerosPuntaje[8] = new ImageIcon (getClass().getResource("imagenes/barra/numerospuntaje/8.png"));
       numerosPuntaje[9] = new ImageIcon (getClass().getResource("imagenes/barra/numerospuntaje/9.png"));    
            
    }
    
    public static GestorJuego getInstance()
    {
      if(getPartida() == null) { setPartida(new GestorJuego()); }
      return getPartida();
    }
    
    /**
     * @return the salud
     */
    public int getSalud() {
        return salud;
    }

    /**
     * @param salud the salud to set
     */
    public void setSalud(int salud) {
        
        if(this.salud > 0){this.salud = salud;}
        
        if(this.salud == 0 )
        {
           Sonidos.getInstance().reproducir("error"); 
           switch(genero)
           {
               case ("tahi"):                       
                   JOptionPane.showMessageDialog(null, "Vaya!\nhas sido derrotado ...\nInténtalo de nuevo!", "Game Over", 0);
                   break;

               case ("lily"):
                   JOptionPane.showMessageDialog(null, "Vaya!\nhas sido derrotada ...\nInténtalo de nuevo!", "Game Over", 0);
                   break;
           }
           reiniciarModulo();
           this.salud = 5; //se completa la salud del jugador nuevamente.
        }
        
        actualizarSalud();
    }
    
    public void setSalud2(int salud) { //Solo para la batalla con la Sirena!!
        this.salud = salud;       
    }
    
    public void actualizarSalud() //Se actualiza la salud en los tableros de las pantallas!
    {
        JLabel jl;
        
        for (int i = 0; i < vJF.length; i++) 
        {
            for (int j = 0; j < vJF[i].length; j++)
            {
               if(vJF[i][j] != null){
                  for(int k = 0; k<vJF[i][j].getContentPane().getComponents().length;k++)
                  {        
                    if(vJF[i][j].getContentPane().getComponent(k).getAccessibleContext().getAccessibleName().equals("salud"))
                    {
                       jl = (JLabel)vJF[i][j].getContentPane().getComponent(k);
                       jl.setIcon(imagenesSalud[salud]);                       
                    }                     
                  }
               }
            }
        }        
    }
    
    public void reiniciarModulo() //Al morir el personaje, se reinicia el juego
    {
       Sonidos.getInstance().detener("rio");       
       escenarioActual.setVisible(false);
       
       JLabel jl;
       int i = getEscenarioInicial()[0];
       int j = getEscenarioInicial()[1];
       
       vJF[i][j].setVisible(true); //El judador es llevado al inicio del juego ...
       setEscenarioActual(vJF[i][j]);
       
       for(int k = 0; k<vJF[i][j].getContentPane().getComponents().length;k++)
       {        
         if(vJF[i][j].getContentPane().getComponent(k).getAccessibleContext().getAccessibleName().equalsIgnoreCase("tahi"))
         {
           jl = (JLabel)vJF[i][j].getContentPane().getComponent(k);
           jl.setLocation(getUbicacionInicial().x,getUbicacionInicial().y);                       
         }                     
       }
       Sonidos.getInstance().detener(Tiempo.getInstance(null).getSonidoActual());
       Tiempo.getInstance(null).reanudarMusica();
       Tiempo.getInstance(null).actualizarCambio(true);
       
    }
    
    public void actualizarPuntaje(int nuevoPuntaje)
    { 
       if((getPuntaje()+nuevoPuntaje) < 9999)
       {
         setPuntaje(getPuntaje()+nuevoPuntaje);
       }
       else
       {
         setPuntaje(9999); 
         Sonidos.getInstance().reproducir("nuevorecurso");
         JOptionPane.showMessageDialog(null, "Vaya!! ... ya has llegado al Puntaje máximo (9999)");  
       }
       int puntajeActual = getPuntaje();
       
       int numVector[] = new int[4]; // El puntaje obtenido por el jugador no puede ser mayor que 9999 (solo hay 4 digitos)
             
       int cociente = 1;
       int dividendo = puntajeActual;
       int residuo;
       int i = numVector.length - 1; //el indice empieza desde el final hacia el inicio del vetor.
       
       while(cociente != 0)
       {
         cociente = dividendo/10;
         residuo = dividendo%10;
         dividendo = cociente;
         numVector[i] = residuo;i--;
       }
       verPuntaje(numVector);      
    }
    
    public void verPuntaje(int[] numVector)
    {
       JLabel jl;
        
       for (int i = 0; i < vJF.length; i++) 
       {
           for (int j = 0; j < vJF[i].length; j++)
           {
              if(vJF[i][j] != null){
                 for(int k = 0; k<vJF[i][j].getContentPane().getComponents().length;k++)
                 {        
                   if(vJF[i][j].getContentPane().getComponent(k).getAccessibleContext().getAccessibleName().equalsIgnoreCase("numPuntaje1"))
                   {
                      jl = (JLabel)vJF[i][j].getContentPane().getComponent(k);
                      jl.setIcon(numerosPuntaje[numVector[0]]);                       
                   }
                   if(vJF[i][j].getContentPane().getComponent(k).getAccessibleContext().getAccessibleName().equalsIgnoreCase("numPuntaje2"))
                   {
                      jl = (JLabel)vJF[i][j].getContentPane().getComponent(k);
                      jl.setIcon(numerosPuntaje[numVector[1]]);                       
                   }
                   if(vJF[i][j].getContentPane().getComponent(k).getAccessibleContext().getAccessibleName().equalsIgnoreCase("numPuntaje3"))
                   {
                      jl = (JLabel)vJF[i][j].getContentPane().getComponent(k);
                      jl.setIcon(numerosPuntaje[numVector[2]]);                       
                   }
                   if(vJF[i][j].getContentPane().getComponent(k).getAccessibleContext().getAccessibleName().equalsIgnoreCase("numPuntaje4"))
                   {
                      jl = (JLabel)vJF[i][j].getContentPane().getComponent(k);
                      jl.setIcon(numerosPuntaje[numVector[3]]);                       
                   }
                 }
              }
           }
       }      
    }
    
    public void abrirPuerta(int i)
    {
      puertas[i] = true; 
      Sonidos.getInstance().reproducir("abrirpuerta");
      try { Thread.sleep(5); } catch (InterruptedException ex) {}
      Sonidos.getInstance().reproducir("success2");
    }
    
    public void agregarRecurso(int recurso)
    {
      this.getRecursos()[recurso-1] = true;
      Sonidos.getInstance().reproducir("nuevorecurso");
      actualizarRecurso(recurso,true);
      
      String s = "";  
      
      switch(recurso)
      {
        case 1: s = "LA ESPADA DE ZAFIRO! ... podrás atacar\na tus enemigos con la tecla ESPACIO."; Ayuda.getInstance().resaltarTeclaAyuda(false); break;  
        case 2: s = "UNA CANTIMPLORA! ... podrás recoger\nagua acercándote a un rio\ny presionar ENTER."; break; 
        case 3: s = "UNA LLAVE! ... podrás abrir alguna\nreja o puerta acercándote a ella\ny presionando ENTER."; break; 
        case 4: s = "AGUA! ... "; break; 
        case 5: s = "LA GEMA ROJA! ... ahora las\nLuciérnagas han sido liberadas\ny vuelven al bosque."; Ayuda.getInstance().resaltarTeclaAyuda(false); break; 
        case 6: s = "LA GEMA AZUL! ..."; break; 
      }
      
      Teclado.getInstace().setPausa(true); 
      JOptionPane.showMessageDialog(null, "HAS CONSEGUIDO:\n"+s, "¡Nuevo Recurso!", 2, new ImageIcon (getClass().getResource("imagenes/barra/recursos/recurso"+recurso+".png")));
      
      if(s.equalsIgnoreCase("LA GEMA AZUL! ..."))
      {
        JOptionPane.showMessageDialog(null, "!La espada de Zafiro ha sido mejorada!","¡Nueva Mejora!", 2, new ImageIcon (getClass().getResource("imagenes/objetos/espada.png")));
      }
      Teclado.getInstace().setPausa(false); 
    }
    
    public void quitarRecurso(int recurso)
    {
      this.getRecursos()[recurso-1] = false;
      actualizarRecurso(recurso,false);
    }
    
    public void actualizarRecursos()
    {
        for(int i=1; i<=6; i++)
        {
            if(recursos[i-1])
            {
              actualizarRecurso(i,true);
            }
        }
    }    
    
    
    public void actualizarRecurso(int r, boolean loPosee)
    {
        JLabel jl;

        for (int i = 0; i < vJF.length; i++) 
        {
            for (int j = 0; j < vJF[i].length; j++)
            {
               if(vJF[i][j] != null){
                  for(int k = 0; k<vJF[i][j].getContentPane().getComponents().length;k++)
                  {        
                    if(vJF[i][j].getContentPane().getComponent(k).getAccessibleContext().getAccessibleName().equalsIgnoreCase("recurso"+r))
                    {
                       jl = (JLabel)vJF[i][j].getContentPane().getComponent(k);
                       if(loPosee)
                       {                    
                         jl.setIcon(new ImageIcon (getClass().getResource("imagenes/barra/recursos/recurso"+r+".png")));   
                       }
                       else
                       {
                         jl.setIcon(new ImageIcon (getClass().getResource("imagenes/barra/recursos/recurso0.png")));            
                       }
                    }                     
                  }
               }
            }
        } 
    }
    
    
    public boolean mayorPuntajeRemoto(String[] datosLocal)
    {    
        if(datosLocal == null){return true;}

        if(getPuntaje() > Integer.parseInt(datosLocal[2]))
        {         
           return true; 
        }
        else if(getPuntaje() < Integer.parseInt(datosLocal[2]))
        {
           return false; 
        }
        else
        {
            int avanceRemoto = 0;
            int avanceLocal = 0;

            avanceRemoto += puntajeRemoto(getRecursos());
            avanceRemoto += puntajeRemoto(getPuertas());
            avanceRemoto += puntajeRemoto(getMsnApertura());

            avanceLocal += puntajeLocal(datosLocal[4]);//Se suman los recursos!
            avanceLocal += puntajeLocal(datosLocal[5]);//Se suman las puertas desbloqueadas!
            avanceLocal += puntajeLocal(datosLocal[7]);//Se suman los mensajes!

            if(avanceRemoto >= avanceLocal)
            {
               return true; 
            }
        }
        return false;
    }
    
    
    public int puntajeRemoto(boolean[] vector)
    {
       int avanceRemoto = 0; 
       for(int i=0; i<vector.length; i++)
       { 
          if(vector[i]){
            avanceRemoto++;
          }
       } 
       return avanceRemoto; 
    }
    
    
    public int puntajeLocal(String vector)
    {
       int avanceLocal = 0; 
       for(int i=0; i<vector.length(); i++)
       {
            String senal = vector.charAt(i)+"";  
            if(1 == Integer.parseInt(senal)){
              avanceLocal++;
            }
       } 
       return avanceLocal;
    }
    
    
    public void cerrarPartida()
    {      
      Sonidos.getInstance().detener("rio");
      Sonidos.getInstance().detener(Tiempo.getInstance(null).getSonidoActual());      
      
      for (int i = 0; i < vJF.length; i++) 
      {
        for (int j = 0; j < vJF[i].length; j++)
        {
          if(vJF[i][j] != null)
          {
             vJF[i][j].setVisible(false);
             vJF[i][j].dispose();
             vJF[i][j].removeAll();
          }
        }
      }      
      vJF = null;
      
      Tiempo.setT(null);
      //GestorJuego.partida = null;
      Ayuda.getInstance().setMensajeActual(0); // Hay que restaurar el grupo de instrucciones para que en la proxima partida se resetee.
      
      System.gc();
    }
    
    
    /**
     * @return the vJF
     */
    public JFrame[][] getvJF() {
        return vJF;
    } 

    /**
     * @return the genero
     */
    public String getGenero() {
        return genero;
    }

    /**
     * @param genero the genero to set
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * @return the puntaje
     */
    public int getPuntaje() {
        return puntaje;
    }

    /**
     * @param puntaje the puntaje to set
     */
    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    /**
     * @return the recursos
     */
    public boolean[] getRecursos() {
        return recursos;
    }

    /**
     * @param recursos the recursos to set
     */
    public void setRecursos(boolean[] recursos) {
        this.recursos = recursos;
    }

    /**
     * @param vJF the vJF to set
     */
    public void setvJF(JFrame[][] vJF) {
        this.vJF = vJF;
    }

    /**
     * @return the escenarioInicial
     */
    public int[] getEscenarioInicial() {
        return escenarioInicial;
    }

    /**
     * @param i
     * @param j
     */
    public void setEscenarioInicial(int i, int j) {
        this.escenarioInicial[0] = i;
        this.escenarioInicial[1] = j;
        this.escenarioActual = this.vJF[i][j];
    }

    /**
     * @return the ubicacionInicial
     */
    public Point getUbicacionInicial() {
        return ubicacionInicial;
    }

    /**
     * @param ubicacionInicial the ubicacionInicial to set
     */
    public void setUbicacionInicial(Point ubicacionInicial) {
        this.ubicacionInicial = ubicacionInicial;
    }

    /**
     * @return the puertas
     */
    public boolean[] getPuertas() {
        return puertas;
    }

    /**
     * @param puertas the puertas to set
     */
    public void setPuertas(boolean[] puertas) {
        this.puertas = puertas;
    }

    /**
     * @return the speed
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * @param speed the speed to set
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    /**
     * @return the frecuencia
     */
    public int getFrecuencia() {
        return frecuencia;
    }

    /**
     * @param frecuencia the frecuencia to set
     */
    public void setFrecuencia(int frecuencia) {
        this.frecuencia = frecuencia;
    }   

    /**
     * @return the escenarioActual
     */
    public JFrame getEscenarioActual() {
        return escenarioActual;
    }

    /**
     * @param escenarioActual the escenarioActual to set
     */
    public void setEscenarioActual(JFrame escenarioActual) {
        this.escenarioActual = escenarioActual;
    }

    /**
     * @return the terminarJuego
     */
    public boolean isTerminarJuego() {
        return terminarJuego;
    }

    /**
     * @param terminarJuego the terminarJuego to set
     */
    public void setTerminarJuego(boolean terminarJuego) {
        this.terminarJuego = terminarJuego;
    }

    /**
     * @return the msnApertura
     */
    public boolean[] getMsnApertura() {
        return msnApertura;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the ubicacionBD
     */
    public int getUbicacionBD() {
        return ubicacionBD;
    }

    /**
     * @param ubicacionBD the ubicacionBD to set
     */
    public void setUbicacionBD(int ubicacionBD) {
        this.ubicacionBD = ubicacionBD;
    }    

    /**
     * @return the juegoIniciado
     */
    public boolean isJuegoIniciado() {
        return juegoIniciado;
    }

    /**
     * @param juegoIniciado the juegoIniciado to set
     */
    public void setJuegoIniciado(boolean juegoIniciado) {
        this.juegoIniciado = juegoIniciado;
    }

    /**
     * @return the sesionIniciada
     */
    public boolean isSesionIniciada() {
        return sesionIniciada;
    }

    /**
     * @param sesionIniciada the sesionIniciada to set
     */
    public void setSesionIniciada(boolean sesionIniciada) {
        this.sesionIniciada = sesionIniciada;
    }
}
