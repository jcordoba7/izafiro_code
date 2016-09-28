/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package izafiro;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 *
 * @author Jonathan
 */
public final class Sonidos {
    
    private static Sonidos s = null;    
   
    private Player boton;
    private Player espada;
    private Player dano;
    private Player rio;
    private Player nuevoRecurso;
    private Player abrirPuerta;
    private Player error;
    private Player sonidoCaja;
    private Player success1;
    private Player success2;
    private Player hacha;
    private Player rana;
    private Player guardia;
    private Player boss;
    private Player rayo;
    private Player trueno;
    private Player entradaAldea;
    private Player portada;
    private Player creditos;
    private Player bosque;
    private Player jardinFuentes;
    private Player refugioPatriarca;
    private Player sonidosBosque;
    private Player noche;
    private Player puzzle1;
    private Player puzzle2;
    private Player gallo;
    private Player historia;
    private Player reloj;
    
    private boolean loopboton;
    private boolean loopespada;
    private boolean loopdano;
    private boolean looprio;
    private boolean loopnuevoRecurso;
    private boolean loopabrirPuerta;
    private boolean looperror;
    private boolean loopsonidoCaja;
    private boolean loopsuccess1;
    private boolean loopsuccess2;
    private boolean loophacha;
    private boolean looprana;
    private boolean loopguardia;
    private boolean loopboss;
    private boolean looprayo;
    private boolean looptrueno;
    private boolean loopentradaAldea;
    private boolean loopportada;
    private boolean loopcreditos;
    private boolean loopbosque;
    private boolean loopjardinFuentes;
    private boolean looprefugioPatriarca;
    private boolean loopsonidosBosque;
    private boolean loopnoche;
    private boolean looppuzzle1;
    private boolean looppuzzle2;
    private boolean loopgallo;
    private boolean loophistoria;
    private boolean loopreloj;
    
    public Player instanciarPista(String nombre)
    {
        try {            
            FileInputStream fis;
            BufferedInputStream bis;
            Player pista;       
                                    
            String ruta = new File("sources/sonidos/"+nombre).getAbsolutePath().replace("\\", "/");
            
            fis = new FileInputStream(ruta);
            bis = new BufferedInputStream(fis);      
            
            try {
                pista = new Player(bis);
                return pista;
            } catch (JavaLayerException ex) { JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage()); }
            
        } catch (FileNotFoundException ex) {
        }
        return null;
    }
    
    public static Sonidos getInstance()
    {
      if(s == null) { s = new Sonidos(); }
      return s;
    }

    
    public void elegirPista(String nombre)
    {
        //nombre = ""; //Desactivar sonido para pruebas.
        switch(nombre) 
        {
           case "portada": 
               portada = instanciarPista("cancion-portada1.mp3");
               try { portada.play(); } catch (JavaLayerException ex) {};
               portada.close();
               break;

           case "boton": 
               boton = instanciarPista("boton_sound6.mp3");
               try { boton.play(); } catch (JavaLayerException ex) {};
               boton.close();
               break;
               
           case "espadazo": 
               espada = instanciarPista("espadazo.mp3");
               try { espada.play(); } catch (JavaLayerException ex) {};
               espada.close();
               break;

           case "dano": 
               dano = instanciarPista("hurt"+GestorJuego.getInstance().getGenero()+".mp3"); 
               try { dano.play(); } catch (JavaLayerException ex) {};
               dano.close();
               break;

           case "rio":             
               rio = instanciarPista("rio.mp3"); 
               try { rio.play(); } catch (JavaLayerException ex) {};
               rio.close();
               break;

           case "nuevorecurso": 
               nuevoRecurso = instanciarPista("nuevorecurso.mp3"); 
               try { nuevoRecurso.play(); } catch (JavaLayerException ex) {};
               nuevoRecurso.close();
               break;

           case "abrirpuerta": 
               abrirPuerta = instanciarPista("abrirpuerta.mp3"); 
               try { abrirPuerta.play(); } catch (JavaLayerException ex) {};
               abrirPuerta.close();
               break;

           case "error": 
               error = instanciarPista("error.mp3"); 
               try { error.play(); } catch (JavaLayerException ex) {};
               error.close();
               break;

           case "bosque": 
               bosque = instanciarPista("bosque.mp3"); 
               try { bosque.play(); } catch (JavaLayerException ex) {};
               bosque.close();
               break;

           case "boss": 
               boss = instanciarPista("boss.mp3");
               try { boss.play(); } catch (JavaLayerException ex) {};
               boss.close();
               break;

           case "creditos": 
               creditos = instanciarPista("creditos.mp3"); 
               try { creditos.play(); } catch (JavaLayerException ex) {};
               creditos.close();
               break;

           case "entradaaldea": 
               entradaAldea = instanciarPista("entradaaldea.mp3"); 
               try { entradaAldea.play(); } catch (JavaLayerException ex) {};
               entradaAldea.close();
               break;

           case "guardia": 
               guardia = instanciarPista("guardia.mp3");
               try { guardia.play(); } catch (JavaLayerException ex) {};
               guardia.close();
               break;

           case "hacha": 
               hacha = instanciarPista("hacha.mp3"); 
               try { hacha.play(); } catch (JavaLayerException ex) {};
               hacha.close();
               break;

           case "jardinfuentes": 
               jardinFuentes = instanciarPista("jardinfuentes.mp3"); 
               try { jardinFuentes.play(); } catch (JavaLayerException ex) {};
               jardinFuentes.close();
               break;

           case "noche": 
               noche = instanciarPista("noche.mp3"); 
               try { noche.play(); } catch (JavaLayerException ex) {};
               noche.close();
               break;

           case "refugiopatriarca": 
               refugioPatriarca = instanciarPista("refugiopatriarca.mp3"); 
               try { refugioPatriarca.play(); } catch (JavaLayerException ex) {};
               refugioPatriarca.close();
               break;

           case "rana": 
               rana = instanciarPista("rana.mp3");
               try { rana.play(); } catch (JavaLayerException ex) {};
               rana.close();
               break;

           case "sonidocaja": 
               sonidoCaja = instanciarPista("sonidocaja.mp3"); 
               try { sonidoCaja.play(); } catch (JavaLayerException ex) {};
               sonidoCaja.close();
               break;

           case "sonidosbosque": 
               sonidosBosque = instanciarPista("sonido-bosque.mp3"); 
               try { sonidosBosque.play(); } catch (JavaLayerException ex) {};
               sonidosBosque.close();
               break;

           case "success1": 
               success1 = instanciarPista("success.mp3"); 
               try { success1.play(); } catch (JavaLayerException ex) {};
               success1.close();
               break;

           case "success2": 
               success2 = instanciarPista("success2.mp3"); 
               try { success2.play(); } catch (JavaLayerException ex) {};
               success2.close();
               break;

           case "trueno": 
               trueno = instanciarPista("trueno.mp3"); 
               try { trueno.play(); } catch (JavaLayerException ex) {};
               trueno.close();
               break;
               
           case "rayo": 
               rayo = instanciarPista("rayo.mp3"); 
               try { rayo.play(); } catch (JavaLayerException ex) {};
               rayo.close();
               break;
               
           case "puzzle1": 
               puzzle1 = instanciarPista("puzzle1.mp3"); 
               try { puzzle1.play(); } catch (JavaLayerException ex) {};
               puzzle1.close();
               break;
               
           case "puzzle2": 
               puzzle2 = instanciarPista("puzzle2.mp3"); 
               try { puzzle2.play(); } catch (JavaLayerException ex) {};
               puzzle2.close();
               break;
               
           case "gallo": 
               gallo = instanciarPista("gallo.mp3"); 
               try { gallo.play(); } catch (JavaLayerException ex) {};
               gallo.close();
               break;
               
           case "historia": 
               historia = instanciarPista("historia.mp3"); 
               try { historia.play(); } catch (JavaLayerException ex) {};
               historia.close();
               break;
               
           case "reloj": 
               reloj = instanciarPista("reloj.mp3"); 
               try { reloj.play(); } catch (JavaLayerException ex) {};
               reloj.close();
               break;
        }
    }
    
    
    public void reproducir(String nombre)
    {
        new Play(nombre).start();
    }
    
    public void reproducirLoop(String nombre)
    {       
       switch(nombre)
       {
          case "portada": 
                loopportada = true; 
                break;
          case "boton": 
                loopboton = true; 
                break;
          case "espadazo":
                loopespada = true; 
                break;
          case "dano":
                loopdano = true; 
                break;
          case "rio": 
                looprio = true; 
                break;
          case "nuevorecurso": 
                loopnuevoRecurso = true; 
                break;
          case "abrirpuerta":
                loopabrirPuerta = true; 
                break;
          case "error": 
                looperror = true; 
                break;
          case "bosque": 
                loopbosque = true; 
                break;
          case "boss":  
                loopboss = true; 
                break;
          case "creditos":
                loopcreditos = true; 
                break;
          case "entradaaldea":
                loopentradaAldea = true; 
                break;
          case "guardia":  
                loopguardia = true; 
                break;
          case "hacha":
                loophacha = true; 
                break;
          case "jardinfuentes":
                loopjardinFuentes = true; 
                break;
          case "noche": 
                loopnoche = true; 
                break;
          case "refugiopatriarca": 
                looprefugioPatriarca = true; 
                break;
          case "rana": 
                looprana = true; 
                break;
          case "sonidocaja":
                loopsonidoCaja = true; 
                break;
          case "sonidosbosque":
                loopsonidosBosque = true; 
                break;
          case "success1":
                loopsuccess1 = true; 
                break;
          case "success2":
                loopsuccess2 = true; 
                break;
          case "rayo": 
                looprayo = true; 
                break;
          case "trueno": 
                looptrueno = true; 
                break;
          case "puzzle1": 
                looppuzzle1 = true; 
                break;
          case "puzzle2":  
                looppuzzle2 = true; 
                break;      
          case "gallo":  
                loopgallo = true; 
                break;  
          case "historia":  
                loophistoria = true; 
                break;
          case "reloj":  
                loopreloj = true; 
                break;    
       }
       new Loop(nombre).start();
    }
    
    public void detener(String nom)
    {       
       switch(nom)
       {
          case "portada": try { portada.close(); } catch (Exception e) {} 
                loopportada=false; 
                break;
          case "boton": try{ boton.close(); } catch (Exception e) {} 
                loopboton=false; 
                break;
          case "espadazo": try{ espada.close(); } catch (Exception e) {} 
                loopespada=false; 
                break;
          case "dano": try{ dano.close(); } catch (Exception e) {} 
                loopdano=false; 
                break;
          case "rio": try{ rio.close(); } catch (Exception e) {} 
                looprio=false; 
                break;
          case "nuevorecurso": try{ nuevoRecurso.close(); } catch (Exception e) {} 
                loopnuevoRecurso=false; 
                break;
          case "abrirpuerta": try{ abrirPuerta.close(); } catch (Exception e) {} 
                loopabrirPuerta=false; 
                break;
          case "error": try{ error.close(); } catch (Exception e) {} 
                looperror=false; 
                break;
          case "bosque": try{ bosque.close(); } catch (Exception e) {} 
                loopbosque=false; 
                break;
          case "boss": try{ boss.close(); } catch (Exception e) {} 
                loopboss=false; 
                break;
          case "creditos": try{ creditos.close(); } catch (Exception e) {} 
                loopcreditos=false; 
                break;
          case "entradaaldea": try{ entradaAldea.close(); } catch (Exception e) {} 
                loopentradaAldea=false; 
                break;
          case "guardia": try{ guardia.close(); } catch (Exception e) {} 
                loopguardia=false; 
                break;
          case "hacha": try{ hacha.close(); } catch (Exception e) {} 
                loophacha=false; 
                break;
          case "jardinfuentes": try{ jardinFuentes.close(); } catch (Exception e) {} 
                loopjardinFuentes=false; 
                break;
          case "noche": try{ noche.close(); } catch (Exception e) {} 
                loopnoche=false; 
                break;
          case "refugiopatriarca": try{ refugioPatriarca.close(); } catch (Exception e) {} 
                looprefugioPatriarca=false; 
                break;
          case "rana": try{ rana.close(); } catch (Exception e) {} 
                looprana=false; 
                break;
          case "sonidocaja": try{ sonidoCaja.close(); } catch (Exception e) {} 
                loopsonidoCaja=false; 
                break;
          case "sonidosbosque": try{ sonidosBosque.close(); } catch (Exception e) {} 
                loopsonidosBosque=false; 
                break;
          case "success1": try{ success1.close(); } catch (Exception e) {} 
                loopsuccess1=false; 
                break;
          case "success2": try{ success2.close(); } catch (Exception e) {} 
                loopsuccess2=false; 
                break;
          case "rayo": try{ rayo.close(); } catch (Exception e) {} 
                looprayo=false; 
                break;
          case "trueno": try{ trueno.close(); } catch (Exception e) {} 
                looptrueno=false; 
                break;
          case "puzzle1": try{ puzzle1.close(); } catch (Exception e) {} 
                looppuzzle1=false; 
                break;
          case "puzzle2": try{ puzzle2.close(); } catch (Exception e) {} 
                looppuzzle2=false; 
                break;
          case "gallo": try{ gallo.close(); } catch (Exception e) {} 
                loopgallo=false; 
                break; 
          case "historia": try{ historia.close(); } catch (Exception e) {} 
                loophistoria=false; 
                break;  
              
          case "reloj": try{ reloj.close(); } catch (Exception e) {} 
                loopreloj=false; 
                break;
       }
    }   
    
    public class Play extends Thread
    {
       String nombre;     
    
       public Play(String nombre){
         this.nombre = nombre;  
       }
       
       @Override
       public void run()
       {
          elegirPista(nombre);
       }       
    }
    
    public class Loop extends Thread
    { 
       String nombre;
    
       public Loop(String nombre){
         this.nombre = nombre;
       }
       
       @Override
       public void run()
       {           
          switch(nombre) 
          {
            case "portada": while (loopportada) { elegirPista(this.nombre); }
                  break;
            case "boton": while (loopboton) { elegirPista(this.nombre); } 
                  break;
            case "espadazo": while (loopespada) { elegirPista(this.nombre); } 
                  break;
            case "dano": while (loopdano) { elegirPista(this.nombre); } 
                  break;
            case "rio": while (looprio) { elegirPista(this.nombre); } 
                  break;
            case "nuevorecurso": while (loopnuevoRecurso) { elegirPista(this.nombre); } 
                  break;
            case "abrirpuerta": while (loopabrirPuerta) { elegirPista(this.nombre); } 
                  break;
            case "error": while (looperror) { elegirPista(this.nombre); } 
                  break;
            case "bosque": while (loopbosque) { elegirPista(this.nombre); } 
                  break;
            case "boss": while (loopboss) { elegirPista(this.nombre); } 
                  break;
            case "creditos": while (loopcreditos) { elegirPista(this.nombre); } 
                  break;
            case "entradaaldea": while (loopentradaAldea) { elegirPista(this.nombre); } 
                  break;
            case "guardia": while (loopguardia) { elegirPista(this.nombre); } 
                  break;
            case "hacha": while (loophacha) { elegirPista(this.nombre); } 
                  break;
            case "jardinfuentes": while (loopjardinFuentes) { elegirPista(this.nombre); } 
                  break;
            case "noche": while (loopnoche) { elegirPista(this.nombre); } 
                  break;
            case "refugiopatriarca": while (looprefugioPatriarca) { elegirPista(this.nombre); } 
                  break;
            case "rana": while (looprana) { elegirPista(this.nombre); } 
                  break;
            case "sonidocaja": while (loopsonidoCaja) { elegirPista(this.nombre); } 
                  break;
            case "sonidosbosque": while (loopsonidosBosque) { elegirPista(this.nombre); } 
                  break;
            case "success1": while (loopsuccess1) { elegirPista(this.nombre); } 
                  break;
            case "success2": while (loopsuccess2) { elegirPista(this.nombre); } 
                  break;
            case "rayo": while (looprayo) { elegirPista(this.nombre); } 
                  break;
            case "trueno": while (looptrueno) { elegirPista(this.nombre); } 
                  break;
            case "puzzle1": while (looppuzzle1) { elegirPista(this.nombre); } 
                  break;
            case "puzzle2": while (looppuzzle2) { elegirPista(this.nombre); } 
                  break;
            case "gallo": while (loopgallo) { elegirPista(this.nombre); } 
                  break;
            case "historia": while (loophistoria) { elegirPista(this.nombre); } 
                  break;
            case "reloj": while (loopreloj) { elegirPista(this.nombre); } 
                  break;
          }
       }       
    }
    
    
    public void activarCursor(JFrame jFrame)
    {
        Toolkit toolk = Toolkit.getDefaultToolkit();
        Image img = toolk.createImage("sources/cursor.png");
        Point point = new Point(0,0);
        Cursor cursor = toolk.createCustomCursor(img, point, "CustomCursor");
        
        jFrame.setCursor(cursor);
    }      
}