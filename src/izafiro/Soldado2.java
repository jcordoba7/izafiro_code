/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package izafiro;

import java.applet.AudioClip;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Jonathan
 */
public class Soldado2 extends Thread{
    
    private JLabel imagen;
    private JLabel tahi;
    private Point[] coordenadas; //limites de posicion del soldado
    private Icon[] posiciones; //posiciones del soldado (gifs)
    private Obstaculo obstaculosAbajo;
    private Obstaculo obstaculosArriba;
    private Obstaculo obstaculosIzquierda;
    private Obstaculo obstaculosDerecha;
    private int speed;
    private int sentido; //0 manecillas de reloj. 1 al contrario de las manecillas del reloj
    private int puntoInicio;// 0 para la ventana [3,3] .... 1 para la ventana [6,3] ... 2 para la ventana [6,6]
    private int[] zonaJardin; //Ventana en la que se encuentra el soldado
    private int visionLateral;
    private boolean termino;//acaba el hilo cuando tahi es expulsado
    private SenalVentana senal;//es para poder cerrar la ventana desde la clase soldado. sera la señal en el KeyListener (la i)
    private AudioClip agua;//Desactiva el sonido de agua de la ventana (si hay fuentes)
    private ArrayList<Soldado2> otrosSoldados;
    
    private static boolean moverSoldado = true;
        
    
    public Soldado2(JLabel imagen,JLabel tahi,Point[] coordenadas,int speed,int sentido,
                   Obstaculo oAba, Obstaculo oArr, Obstaculo oIzq, Obstaculo oDer, int puntoInicio, 
                   int[] vec, SenalVentana sv,AudioClip ac,ArrayList<Soldado2> oS, int vL)
    {
      this.imagen = imagen;
      this.tahi = tahi;
      this.coordenadas = coordenadas;
      this.speed = speed;
      this.sentido = sentido;
      this.puntoInicio = puntoInicio;
      this.zonaJardin = vec;
      this.termino = false;
      this.senal = sv;
      this.agua = ac;
      this.visionLateral = vL;
      
      this.obstaculosAbajo = oAba;
      this.obstaculosArriba = oArr;
      this.obstaculosIzquierda = oIzq;
      this.obstaculosDerecha = oDer;
      this.otrosSoldados = oS;
      
      posiciones = new Icon[8];
      posiciones[0] = new ImageIcon (getClass().getResource("imagenes/personajes/soldado/soldado1.gif"));
      posiciones[1] = new ImageIcon (getClass().getResource("imagenes/personajes/soldado/soldado2.gif"));
      posiciones[2] = new ImageIcon (getClass().getResource("imagenes/personajes/soldado/soldado3.gif"));
      posiciones[3] = new ImageIcon (getClass().getResource("imagenes/personajes/soldado/soldado4.gif"));
      posiciones[4] = new ImageIcon (getClass().getResource("imagenes/personajes/soldado/detenido1.png"));
      posiciones[5] = new ImageIcon (getClass().getResource("imagenes/personajes/soldado/detenido2.png"));
      posiciones[6] = new ImageIcon (getClass().getResource("imagenes/personajes/soldado/detenido3.png"));
      posiciones[7] = new ImageIcon (getClass().getResource("imagenes/personajes/soldado/detenido4.png"));
    }
    
    @Override
    public void run()
    {
      int xInicial = imagen.getX();
      int yInicial = imagen.getY();
      
      switch(sentido)
      {
        case (0): while(!isTermino() && senal.i != 0){ moverSoldado1();}break; 
        case (1): while(!isTermino() && senal.i != 0){ moverSoldado2();}break; 
      }
      imagen.setLocation(xInicial,yInicial); //el soldado vuelve a su lugar
    }
    
    public void moverSoldado1() //A favor de las manecillas del reloj
    {
       Random randomGenerator = new Random();
       
       moverDerecha(coordenadas[1].x);
       imagen.setIcon(posiciones[2]);
       if(senal.i == 0){speed = 0;}
       else{ try {Thread.sleep(randomGenerator.nextInt(3500));} catch (InterruptedException ex) {}}
       moverAbajo(coordenadas[2].y);
       imagen.setIcon(posiciones[0]);
       if(senal.i == 0){speed = 0;}
       else{ try {Thread.sleep(randomGenerator.nextInt(3500));} catch (InterruptedException ex) {}}
       moverIzquierda(coordenadas[3].x);
       imagen.setIcon(posiciones[1]);
       if(senal.i == 0){speed = 0;}
       else{ try {Thread.sleep(randomGenerator.nextInt(3500));} catch (InterruptedException ex) {}}
       moverArriba(coordenadas[0].y);
       imagen.setIcon(posiciones[4]);
       if(senal.i == 0){speed = 0;}
       else{ try {Thread.sleep(randomGenerator.nextInt(3500));} catch (InterruptedException ex) {}}
    }
    
    public void moverSoldado2() //En contra de las manecillas del reloj
    {
       Random randomGenerator = new Random();
       
       moverAbajo(coordenadas[2].y); 
       imagen.setIcon(posiciones[0]);
       if(senal.i == 0){speed = 0;}
       else{ try {Thread.sleep(randomGenerator.nextInt(3500));} catch (InterruptedException ex) {}}
       moverDerecha(coordenadas[1].x); 
       imagen.setIcon(posiciones[2]);
       if(senal.i == 0){speed = 0;}
       else{ try {Thread.sleep(randomGenerator.nextInt(3500));} catch (InterruptedException ex) {}}
       moverArriba(coordenadas[0].y);
       imagen.setIcon(posiciones[4]);
       if(senal.i == 0){speed = 0;}
       else{ try {Thread.sleep(randomGenerator.nextInt(3500));} catch (InterruptedException ex) {}}
       moverIzquierda(coordenadas[3].x);
       imagen.setIcon(posiciones[1]);
       if(senal.i == 0){speed = 0;}
       else{ try {Thread.sleep(randomGenerator.nextInt(3500));} catch (InterruptedException ex) {}}
    }          
    
    public void moverIzquierda(int limite)
    {
       imagen.setIcon(posiciones[1]);  
       
       int x1 = hallarLimiteIzq();
       int y1 = imagen.getY()-visionLateral;
       int y2 = imagen.getY()+tahi.getHeight()+ visionLateral;
       
       while(imagen.getX() > limite)
       {  
         if(senal.i == 0){speed = 0;}  
         
         while(Teclado.getInstace().isPausa())
         {
             try { sleep(1000); } catch (InterruptedException ex) {}  
         }
         
         while(!moverSoldado){ try { sleep(1000); } catch (InterruptedException ex) {} } //Si un soldado descubrio al personaje, los otros se detienen
         
         imagen.setLocation(imagen.getX()-3,imagen.getY());
         try {Thread.sleep(getSpeed());} catch (InterruptedException ex) {} 
         if(contiene(x1,imagen.getX(),y1,y2,tahi)) //pregunta si ve al personaje a su izquierda
         {
            expulsar();          
         }
       }
       imagen.setIcon(posiciones[4]);
    }    
    

    public void moverDerecha(int limite)
    {
       imagen.setIcon(posiciones[2]);  
              
       int x2 = hallarLimiteDer();
       int y1 = imagen.getY()-visionLateral;
       int y2 = imagen.getY()+tahi.getHeight()+ visionLateral;
              
       while(imagen.getX() < limite)
       {
         if(senal.i == 0){speed = 0;}  
         
         while(Teclado.getInstace().isPausa())
         {
             try { sleep(1000); } catch (InterruptedException ex) {}  
         }
         
         while(!moverSoldado){ try { sleep(1000); } catch (InterruptedException ex) {} } //Si un soldado descubrio al personaje, los otros se detienen
         
         imagen.setLocation(imagen.getX()+3,imagen.getY());
         try {Thread.sleep(getSpeed());} catch (InterruptedException ex) {} 
         if(contiene(imagen.getX()+imagen.getWidth(),x2,y1,y2,tahi)) //pregunta si ve al personaje a su derecha
         {
            expulsar();          
         }
       } 
       imagen.setIcon(posiciones[4]);
    }

    public void moverArriba(int limite)
    {
       imagen.setIcon(posiciones[3]);
       
       int x1 = imagen.getX()-visionLateral;
       int x2 = imagen.getX()+imagen.getWidth()+visionLateral;
       int y1 = hallarLimiteArr();
       
       while(imagen.getY() > limite)
       {
         if(senal.i == 0){speed = 0;}  
         
         while(Teclado.getInstace().isPausa())
         {
             try { sleep(1000); } catch (InterruptedException ex) {}  
         }
         
         while(!moverSoldado){ try { sleep(1000); } catch (InterruptedException ex) {} } //Si un soldado descubrio al personaje, los otros se detienen
         
         imagen.setLocation(imagen.getX(),imagen.getY()-3);
         try {Thread.sleep(getSpeed());} catch (InterruptedException ex) {} 
         if(contiene(x1,x2,y1,imagen.getY(),tahi)) //pregunta si ve al personaje arriba
         {
           expulsar();           
         }
       }
       imagen.setIcon(posiciones[4]);
    } 


    public void moverAbajo(int limite)
    {
       imagen.setIcon(posiciones[0]);
       
       int x1 = imagen.getX()-visionLateral;
       int x2 = imagen.getX()+imagen.getWidth()+visionLateral;
       int y2 = hallarLimiteAba();
       
       while(imagen.getY() < limite)
       {
         if(senal.i == 0){speed = 0;}  
         
         while(Teclado.getInstace().isPausa())
         {
             try { sleep(1000); } catch (InterruptedException ex) {}  
         }
         
         while(!moverSoldado){ try { sleep(1000); } catch (InterruptedException ex) {} } //Si un soldado descubrio al personaje, los otros se detienen
         
         imagen.setLocation(imagen.getX(),imagen.getY()+3);
         try {Thread.sleep(getSpeed());} catch (InterruptedException ex) {} 
         if(contiene(x1,x2,imagen.getY()+imagen.getHeight(),y2,tahi)) //pregunta si ve al personaje abajo
         {
            expulsar();          
         }
       }
       imagen.setIcon(posiciones[4]);
    }  
    
    public int hallarLimiteIzq()
    {
       int finalIzq = imagen.getX()+imagen.getWidth(); 
        
       boolean limite = false;
       while(!limite)
       {
         for(int i=0; i<obstaculosIzquierda.getLineas().size(); i++)
         {
           if(obstaculosIzquierda.getLineas().get(i).getX1() == finalIzq){
              if(puntoEntre(obstaculosIzquierda.getLineas().get(i).getY1(),obstaculosIzquierda.getLineas().get(i).getY2(),imagen.getY())
                || puntoEntre(obstaculosIzquierda.getLineas().get(i).getY1(),obstaculosIzquierda.getLineas().get(i).getY2(),imagen.getY()+imagen.getHeight()))
             {
                limite = true;
             }
           }
         }         
         finalIzq--; //el limite disminuye
         if(finalIzq == 0){limite = true;}
       } 
       return finalIzq;
    }
    
    public int hallarLimiteDer()
    {
       int finalDer = imagen.getX();
        
       boolean limite = false;
       while(!limite)
       {            
         for(int i=0; i<obstaculosDerecha.getLineas().size(); i++)
         {
           if(obstaculosDerecha.getLineas().get(i).getX1() == finalDer){
              if(puntoEntre(obstaculosDerecha.getLineas().get(i).getY1(),obstaculosDerecha.getLineas().get(i).getY2(),imagen.getY())
                || puntoEntre(obstaculosDerecha.getLineas().get(i).getY1(),obstaculosDerecha.getLineas().get(i).getY2(),imagen.getY()+imagen.getHeight()))
             {
                limite = true;
             }
           }
         }
         finalDer++; //el limite aumenta
         if(finalDer == 800){limite = true;}
       } 
       return finalDer;
    }
    
    public int hallarLimiteArr()
    {
       int finalArr = imagen.getY()+imagen.getHeight(); 
        
       boolean limite = false;
       while(!limite)
       {
         for(int i=0; i<obstaculosArriba.getLineas().size(); i++)
         { 
           if(obstaculosArriba.getLineas().get(i).getY1() == finalArr){
              if(puntoEntre(obstaculosArriba.getLineas().get(i).getX1(),obstaculosArriba.getLineas().get(i).getX2(),imagen.getX())
                || puntoEntre(obstaculosArriba.getLineas().get(i).getX1(),obstaculosArriba.getLineas().get(i).getX2(),imagen.getX()+imagen.getWidth()))
             {
                limite = true;
             }
           }
         }
         finalArr--; //el limite sube
         if(finalArr == 0){limite = true;}
       } 
       return finalArr;
    }
    
    public int hallarLimiteAba()
    {
       int finalAba = imagen.getY();
        
       boolean limite = false;
       while(!limite)
       {
         for(int i=0; i<obstaculosAbajo.getLineas().size(); i++)
         {
           if(obstaculosAbajo.getLineas().get(i).getY1() == finalAba)
           {
             if(puntoEntre(obstaculosAbajo.getLineas().get(i).getX1(),obstaculosAbajo.getLineas().get(i).getX2(),imagen.getX())
                || puntoEntre(obstaculosAbajo.getLineas().get(i).getX1(),obstaculosAbajo.getLineas().get(i).getX2(),imagen.getX()+imagen.getWidth()))
             {
                limite = true;
             }
           }           
         }
         finalAba++; //el limite baja
         if(finalAba == 490){limite = true;}
       } 
       return finalAba;
    }
           
    
    public void expulsar()
    {
      moverSoldado = false;
        
      if(GestorJuego.getInstance().getvJF()[zonaJardin[0]][zonaJardin[1]] == GestorJuego.getInstance().getEscenarioActual())
      {
        Sonidos.getInstance().reproducir("error");
        Sonidos.getInstance().reproducir("guardia");
        new AlertaSoldado().start();
        
        Random randomGenerator = new Random();
        int aviso = randomGenerator.nextInt(5);
        
        switch(aviso)
        {
            case 1: JOptionPane.showMessageDialog(null,"HEY!!! \nQUÉ HACES MELODEANDO POR AQUÍ? ... \n¡VETE!","Alerta",2);
                    break;
            
            case 2: JOptionPane.showMessageDialog(null,"HEY!!! \nALTO AHÍ !! ... \n¡VAMOS AFUERA!","Alerta",2);
                    break;
                
            default: JOptionPane.showMessageDialog(null,"HEY!!! \nNO PUEDES ESTAR AQUÍ !! ... \n¡VETE!","Alerta",2);
                     break;
        }
              
        int fila = 0;
        int columna = 0;  
      
        switch(puntoInicio)
        {
          case 0: fila=3; columna=3;
                  break;  
          case 1: fila=6; columna=3;
                  break;
          case 2: fila=6; columna=6; 
        }
      
        GestorJuego.getInstance().getEscenarioActual().setVisible(false); //Se cierra la ventana en donde se encuentra el personaje
        Desplazamiento.getInstance().cambiarPantalla(GestorJuego.getInstance().getvJF()[zonaJardin[0]][zonaJardin[1]],GestorJuego.getInstance().getvJF()[fila][columna], tahi, 390, 240, GestorJuego.getInstance().getSpeed());
      }  
      
      for (int i = 0; i < otrosSoldados.size(); i++)
      {   
        otrosSoldados.get(i).setTermino(true);
        otrosSoldados.get(i).setSpeed(0);
        otrosSoldados.get(i).getSenal().i = 0;
        if(otrosSoldados.get(i).getAgua() != null){otrosSoldados.get(i).getAgua().stop();}
      }
      
      tahi.setLocation(0,0);
      
      moverSoldado = true;
    }     
     
    public boolean contiene(int x1, int x2, int y1, int y2, JLabel label)
    {        
       if(puntoEntre(x1,x2,label.getX()) && puntoEntre(y1,y2,label.getY()))
       {
          return true;
       }
       if(puntoEntre(x1,x2,label.getX()+label.getWidth()) && puntoEntre(y1,y2,label.getY()))
       {
          return true;
       }
       if(puntoEntre(x1,x2,label.getX()) && puntoEntre(y1,y2,label.getY()+label.getHeight()))
       {
          return true;
       }       
       if(puntoEntre(x1,x2,label.getX()+label.getWidth()) && puntoEntre(y1,y2,label.getY()+label.getHeight()))
       {
          return true;
       }      
       return false;    
    }  
    
    public boolean puntoEntre(int lim1, int lim2, int punto)
    {
       if(lim1 < punto)
       {
          if(punto < lim2)
          {
             return true; 
          }
       }
       return false;      
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
     * @return the termino
     */
    public boolean isTermino() {
        return termino;
    }

    /**
     * @param termino the termino to set
     */
    public void setTermino(boolean termino) {
        this.termino = termino;
    }

    /**
     * @return the senal
     */
    public SenalVentana getSenal() {
        return senal;
    }

    /**
     * @param senal the senal to set
     */
    public void setSenal(SenalVentana senal) {
        this.senal = senal;
    }

    /**
     * @return the agua
     */
    public AudioClip getAgua() {
        return agua;
    }

    /**
     * @param agua the agua to set
     */
    public void setAgua(AudioClip agua) {
        this.agua = agua;
    }   
    
    
    public class AlertaSoldado extends Thread
    {
        @Override
        public void run()
        {
           for(int i = 0; i<6; i++ )
           { 
             imagen.setOpaque(true);
             try { sleep(500); } catch (InterruptedException ex) {};
             imagen.setOpaque(false);
             try { sleep(500); } catch (InterruptedException ex) {};           
           }
        }        
    }
     
}
