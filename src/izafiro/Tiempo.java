/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package izafiro;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author WINDOWS
 */
public class Tiempo extends Thread {
    
    private static Tiempo t = null;
    private String estado;

    /**
     * @return the t
     */
    public static Tiempo getT() {
        return t;
    }

    /**
     * @param aT the t to set
     */
    public static void setT(Tiempo aT) {
        t = aT;
    }
    
    JFrame [][] escenarios;
    private Icon[] tiempo;
    private Icon[] nocheLu; //noche con luciernagas
    private int segundos;
    private int minutos;
    private int horas;
    private int cancionDia = 0;
    
    private String musicaDia;
    private String musicaDia2; //La que sonara en el Jardin de las Fuentes
    private String musicaDia3; //La que sonara en el refugio del patriarca
    private String musicaTarde;
    private String musicaNoche;
    private String sonidoActual; //Es cualquiera de los tres anteriores dependiendo de la hora.
    
    boolean mostrarHora;
    
    Tiempo(JFrame[][] escenarios)
    {
       this.escenarios = escenarios;
       
       this.tiempo = new Icon[3];
       this.tiempo[0] = new ImageIcon (getClass().getResource("imagenes/tiempo/dia1.png"));
       this.tiempo[1] = new ImageIcon (getClass().getResource("imagenes/tiempo/atardecer1.png"));
       this.tiempo[2] = new ImageIcon (getClass().getResource("imagenes/tiempo/noche1.png"));
       
       this.nocheLu = new Icon[5];
       this.nocheLu[0] = new ImageIcon (getClass().getResource("imagenes/tiempo/nochel1.png"));
       this.nocheLu[1] = new ImageIcon (getClass().getResource("imagenes/tiempo/nochel2.png"));
       this.nocheLu[2] = new ImageIcon (getClass().getResource("imagenes/tiempo/nochel3.png"));
       this.nocheLu[3] = new ImageIcon (getClass().getResource("imagenes/tiempo/nochel3.png"));
       this.nocheLu[4] = new ImageIcon (getClass().getResource("imagenes/tiempo/nochel2.png"));
       
       musicaDia = "bosque";
       musicaDia2 = "jardinfuentes";
       musicaDia3 = "refugiopatriarca";
       musicaTarde = "sonidosbosque";
       musicaNoche = "noche";
       
       estado = "dia";
    }
    
    public static Tiempo getInstance(JFrame[][] escenarios )
    {
      if(getT() == null) { setT(new Tiempo(escenarios)); }
      return getT();
    }
    
    @Override
    public void run()
    {
        int inicio = 11;
        
        if(GestorJuego.getInstance().getEscenarioInicial()[0] == 6 && GestorJuego.getInstance().getEscenarioInicial()[1] == 5)
        {
           cancionDia = 1; 
           setSonidoActual(getMusicaDia2());     
        }
        else if(GestorJuego.getInstance().getEscenarioInicial()[0] == 1 && GestorJuego.getInstance().getEscenarioInicial()[1] == 4)
        {
           cancionDia = 2; 
           setSonidoActual(getMusicaDia3());     
        }
        else
        {  
           cancionDia = 0; 
           setSonidoActual(getMusicaDia());
        }        
                
        Sonidos.getInstance().reproducirLoop(getSonidoActual());
        
        while(GestorJuego.getInstance().isTerminarJuego() == false)
        {
           for(setHoras(inicio); getHoras() < 23; setHoras(getHoras() + 1)  )
           {                  
              inicio = 0;
              setSegundos(0);
              setMinutos(0);
              for(setMinutos(0); getMinutos() < 59; setMinutos(getMinutos() + 1)  )
              {                  
                 if(GestorJuego.getInstance().isTerminarJuego()){return;} 
                 for(setSegundos(0); getSegundos() < 59; setSegundos(getSegundos() + 1)  )
                 {
                    while(Teclado.getInstace().isPausa()) // si el juego esta en pausa, el tiempo se detiene
                    {
                      try { sleep(1000); } catch (InterruptedException ex) {}  
                    }
                    
                    while(PruebaPuzzle.getInstance().isActivado())//Si hay una actividad Puzzle en juego, el tiempo se detiene
                    {
                      try { sleep(5000); } catch (InterruptedException ex) {}
                    }
                    
                    if(18 <= getHoras() || getHoras() < 5) // si es de noche, la velocidad del reloj aumenta.
                    {
                      try { sleep(5);} catch (InterruptedException ex) {}  
                    }
                    else 
                    {
                      try { sleep(10);} catch (InterruptedException ex) {}  
                    }
                 }                     
              }              
              switch(getHoras())
              {
                 case(16): actualizarTiempo(getTiempo()[1]); //Atardecer
                           estado = "tarde";
                           
                           detenerTodoSonido();
                           
                           setSonidoActual(getMusicaTarde());                            
                               
                           if(Teclado.getInstace().isMusica())
                           {             
                              try{sleep(2000);}catch(InterruptedException ex){} 
                              Sonidos.getInstance().reproducirLoop(getSonidoActual());
                           }                                                   
                           break;
                     
                 case(18): actualizarTiempo(getTiempo()[2]); //Anochecer
                           estado = "noche";
                           
                           if(GestorJuego.getInstance().getRecursos()[4]){new NocheIluminada().start();}
                           
                           detenerTodoSonido();                           
                           if(cancionDia != 2){setSonidoActual(getMusicaNoche());}else{setSonidoActual(getMusicaDia3());}
                                                      
                           if(Teclado.getInstace().isMusica())
                           {
                              try{sleep(1000);}catch(InterruptedException ex){} 
                              Sonidos.getInstance().reproducir(getSonidoActual());                           
                           }
                           break;
                     
                 case(5): actualizarTiempo(getTiempo()[0]); //Amanecer
                          estado = "dia";
                          
                          try{sleep(1500);}catch(InterruptedException ex){} Sonidos.getInstance().reproducir("gallo");
                          
                          detenerTodoSonido();
                          if(cancionDia == 0){setSonidoActual(getMusicaDia());}else if(cancionDia == 1){setSonidoActual(getMusicaDia2());}else{setSonidoActual(getMusicaDia3());}
                                                    
                          if(Teclado.getInstace().isMusica())
                          {
                              try {sleep(2000);}catch (InterruptedException ex){}
                              Sonidos.getInstance().reproducirLoop(getSonidoActual());
                          }
                          break;    
              }                                    
           }
        }
        this.escenarios = null;
    }
        
    public void actualizarTiempo(Icon imagen) //Se actualiza la capa del tiempo de los tableros
    {
        JLabel jl;
        
        if(escenarios == null){return;}
        
        for (int i = 0; i < escenarios.length; i++) 
        {
            for (int j = 0; j < escenarios[i].length; j++)
            {
               if(escenarios[i][j] != null){
                  for(int k = 0; k<escenarios[i][j].getContentPane().getComponents().length;k++)
                  {        
                    if(escenarios[i][j].getContentPane().getComponent(k).getAccessibleContext().getAccessibleName().equalsIgnoreCase("tiempo"))
                    {
                       jl = (JLabel)escenarios[i][j].getContentPane().getComponent(k);
                       jl.setIcon(imagen);                       
                    }         
                  }
               }
            }
        }        
    }
    
    public void actualizarTiempoUnEscenario(Icon imagen) //Se actualiza la capa del tiempo en un soloe scenario
    {
        JLabel jl;
        
        if(GestorJuego.getPartida() == null){return;}
        
        JFrame jf = GestorJuego.getInstance().getEscenarioActual();
        
        for(int k = 0; k<jf.getContentPane().getComponents().length;k++)
        {        
          if(jf.getContentPane().getComponent(k).getAccessibleContext().getAccessibleName().equalsIgnoreCase("tiempo"))
          {
            jl = (JLabel)jf.getContentPane().getComponent(k);
            jl.setIcon(imagen);                       
          }         
        }     
    }
    
    public void espera() // Solo es para dar un espacio entre el final de una cancion y el comienzo de otra
    {
        try {
          sleep(6000);
       } catch (InterruptedException ex) {}
    }
     
    // la variable cambiar indica si hay q hacer el cambio de cancion o no
    public void actualizarCambio(boolean cambiar) //Cuando hay cambio de sonido de musicaDia
    {
       if(cambiar){detenerTodoSonido();}    
       
       switch (estado) 
       {
            case "tarde":
                setSonidoActual(getMusicaTarde());
                break;
                
             case "noche":
                if(cancionDia == 2)
                {
                    setSonidoActual(getMusicaDia3());
                }
                else
                {
                    setSonidoActual(getMusicaNoche());
                }      
                break;
                 
             case "dia":
                switch(getCancionDia())
                {
                    case 0: setSonidoActual(getMusicaDia()); break;
                    case 1: setSonidoActual(getMusicaDia2()); break;
                    case 2: setSonidoActual(getMusicaDia3()); break;    
                }
                break;     
       } 
       if(Teclado.getInstace().isMusica() && cambiar)
       {  
           Sonidos.getInstance().reproducirLoop(getSonidoActual()); 
       }                
    }
    
    public void detenerTodoSonido()
    {
        Sonidos.getInstance().detener(getSonidoActual());
        /*Sonidos.getInstance().detener(musicaDia);
        Sonidos.getInstance().detener(musicaDia2);
        Sonidos.getInstance().detener(musicaDia3);
        Sonidos.getInstance().detener(musicaTarde);
        Sonidos.getInstance().detener(musicaNoche);*/
    }
    
    public void reanudarMusica()
    {
        if(GestorJuego.getInstance().getEscenarioInicial()[0] == 6 && GestorJuego.getInstance().getEscenarioInicial()[1] == 5)
        {
           cancionDia = 1; 
           setSonidoActual(getMusicaDia2());     
        }
        else if(GestorJuego.getInstance().getEscenarioInicial()[0] == 1 && GestorJuego.getInstance().getEscenarioInicial()[1] == 4)
        {
           cancionDia = 2; 
           setSonidoActual(getMusicaDia3());     
        }
        else
        {  
           cancionDia = 0; 
           setSonidoActual(getMusicaDia());
        }
    }
    
    
    /**
     * @return the segundos
     */
    public int getSegundos() {
        return segundos;
    }

    /**
     * @param segundos the segundos to set
     */
    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }

    /**
     * @return the minutos
     */
    public int getMinutos() {
        return minutos;
    }

    /**
     * @param minutos the minutos to set
     */
    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    /**
     * @return the horas
     */
    public int getHoras() {
        return horas;
    }

    /**
     * @param horas the horas to set
     */
    public void setHoras(int horas) {
        this.horas = horas;
    }

    /**
     * @return the sonidoActual
     */
    public String getSonidoActual() {
        return sonidoActual;
    }

    /**
     * @return the musicaDia
     */
    public String getMusicaDia() {
        return musicaDia;
    }

    /**
     * @return the musicaTarde
     */
    public String getMusicaTarde() {
        return musicaTarde;
    }

    /**
     * @return the musicaNoche
     */
    public String getMusicaNoche() {
        return musicaNoche;
    }

    /**
     * @param sonidoActual the sonidoActual to set
     */
    public void setSonidoActual(String sonidoActual) {
        this.sonidoActual = sonidoActual;
    }

    /**
     * @return the tiempo
     */
    public Icon[] getTiempo() {
        return tiempo;
    }

    /**
     * @param tiempo the tiempo to set
     */
    public void setTiempo(Icon[] tiempo) {
        this.tiempo = tiempo;
    }

    /**
     * @return the cancionDia
     */
    public int getCancionDia() {
        return cancionDia;
    }

    /**
     * @param cancionDia the cancionDia to set
     */
    public void setCancionDia(int cancionDia) {
        this.cancionDia = cancionDia;
    }

    /**
     * @return the musicaDia2
     */
    public String getMusicaDia2() {
        return musicaDia2;
    }

    /**
     * @param musicaDia2 the musicaDia2 to set
     */
    public void setMusicaDia2(String musicaDia2) {
        this.musicaDia2 = musicaDia2;
    }

    /**
     * @return the musicaDia3
     */
    public String getMusicaDia3() {
        return musicaDia3;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }
    
    
    public class NocheIluminada extends Thread
    {
       @Override
       public void run()
       { 
         while(18 <= getHoras() || getHoras() < 5)
         {
           for(int i=0;i<nocheLu.length;i++)
           {               
             actualizarTiempoUnEscenario(nocheLu[i]);
             try {sleep(270);} catch (InterruptedException ex) {}  
           }
         }
       }
    }
   
}
