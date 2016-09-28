/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package izafiro;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Jonathan
 */
public class AdministradorBDLocal {
    
     String ruta = new File("sources/persistencia/datoslocales.txt").getAbsolutePath().replace("\\", "/");
     String error = new File("error.log").getAbsolutePath().replace("\\", "/");
     
     public int puntajeActual;    
    
     public ArrayList<String[]> obtenerTodosLosDatos() // como un select * from ...
     {
        ArrayList<String[]> datosBD = new ArrayList<>(); // se almacenará toda la base de datos local.
        
        try{
            // Abrimos el archivo            
            FileInputStream fstream = new FileInputStream(ruta);
            // Creamos el objeto de entrada
            DataInputStream entrada = new DataInputStream(fstream);
            // Creamos el Buffer de Lectura
            BufferedReader buffer = new BufferedReader(new InputStreamReader(entrada));
            String strLinea;
            // Leer el archivo linea por linea
            while ((strLinea = buffer.readLine()) != null)   {                
                datosBD.add(strLinea.split(",,"));
            }
            // Cerramos el archivo
            entrada.close();
            buffer.close();
            fstream.close();
            
            return datosBD;
                    
        }catch (Exception e){ //Catch de excepciones
            //System.err.println("Ocurrio un error: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "¡Hubo un problema con la conexión\na la Base de Datos Local! ...", "Error", 0);
        } 
        return null;
     }   
     
     
     public void actualizarBD(ArrayList<String[]> datosBD) // como un update de toda la BD ...
     {
        try {
 
           String content = concatenarInformacion(datosBD);          
           
           File file = new File(ruta);
           File file2 = new File(error);
           
           // if file doesnt exists, then create it
           if (!file.exists()) {
                   file.createNewFile();
           }
           
           FileWriter fw = new FileWriter(file.getAbsoluteFile());
           try (BufferedWriter bw = new BufferedWriter(fw)) {
               bw.write(content);
               bw.close();
               fw.close();
               //JOptionPane.showMessageDialog(null, "se supone q ya actualizo");   
           }
           catch(IOException e)
           {
             //JOptionPane.showMessageDialog(null, "esta pinche monda no escribio 1!"+e);            
           }
           
           if (file2.exists()) {
             FileWriter fw2 = new FileWriter(file2.getAbsoluteFile());
             try (BufferedWriter bw = new BufferedWriter(fw2)) {
               bw.write("...");
               bw.close();
               fw2.close();
             }
           }

       } catch (IOException e) {
           //e.printStackTrace();
           //JOptionPane.showMessageDialog(null, "esta pinche monda no escribio 2!\n"+e);  
       }   
     }
     
     
     public String concatenarInformacion(ArrayList<String[]> datosBD)
     {
        String info = "";
        
        for(int i=0; i<datosBD.size(); i++)
        {
          for(int j=0; j<datosBD.get(i).length; j++)
          {
             info += datosBD.get(i)[j]+",,";
          }
          info += "\n";
        }
        return info;
     }
    
    
     public boolean usuarioCorrecto(String nickName, String password)
     {
        try{
            // Abrimos el archivo            
            FileInputStream fstream = new FileInputStream(ruta);
            // Creamos el objeto de entrada
            DataInputStream entrada = new DataInputStream(fstream);
            // Creamos el Buffer de Lectura
            BufferedReader buffer = new BufferedReader(new InputStreamReader(entrada));
            String strLinea;
            // Leer el archivo linea por linea
            while ((strLinea = buffer.readLine()) != null)   {
                
                String[] datosUsuario = strLinea.split(",,");
                                
                if(nickName.equals(datosUsuario[0]))
                {                  
                  if(password.equals(datosUsuario[1]))
                  { 
                    entrada.close();
                    buffer.close();
                    fstream.close();
                    return true;
                  }
                }
            }
            // Cerramos el archivo
            entrada.close();
            buffer.close();
            fstream.close();
            
            return false; // no coincide el password
            
        }catch (Exception e){ //Catch de excepciones
            //System.err.println("Ocurrio un error: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "¡Hubo un problema con la conexión\na la Base de Datos Local! ...", "Error", 0);
        }
        return false; //el nickname ingresado no existe
     }
     
    
     public void continuarPartida(String usuario)
     {        
        try{
            // Abrimos el archivo            
            FileInputStream fstream = new FileInputStream(ruta);
            // Creamos el objeto de entrada
            DataInputStream entrada = new DataInputStream(fstream);
            // Creamos el Buffer de Lectura
            BufferedReader buffer = new BufferedReader(new InputStreamReader(entrada));
            String strLinea;
            // Leer el archivo linea por linea
            while ((strLinea = buffer.readLine()) != null)   {
                
                String[] datosUsuario = strLinea.split(",,");
                                
                if(datosUsuario[0].equals(usuario))
                {
                    cargarDatos(datosUsuario);
                    entrada.close();
                    return;
                }  
            }
            // Cerramos el archivo
            entrada.close();
            buffer.close();
            fstream.close();
        }catch (Exception e){ //Catch de excepciones
            //System.err.println("Ocurrio un error: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "¡Hubo un problema con la conexión\na la Base de Datos Local! ...", "Error", 0);
        }     
     }
     
     public void cargarDatos(String[] datosUsuario)
     {
        GestorJuego.getInstance().setGenero(datosUsuario[3]);
        //Sonidos.getInstance().setDano();
        GestorJuego.getInstance().setPuntaje(Integer.parseInt(datosUsuario[2]));

        String puertas = datosUsuario[5];
        String recursos = datosUsuario[4];
        String mensajes = datosUsuario[7];
        String escenarioinicial = datosUsuario[6];


        //Se actualizan las puertas!
        for(int i=0; i<puertas.length(); i++)
        {
           String senal = puertas.charAt(i)+"";  
           if(0 == Integer.parseInt(senal)){
             GestorJuego.getInstance().getPuertas()[i] = false;
           }
           else{
             GestorJuego.getInstance().getPuertas()[i] = true;  
           }
        }            

        //Se actualizan los recursos!
        for(int i=0; i<recursos.length(); i++)
        {
           String senal = recursos.charAt(i)+"";  
           if(0 == Integer.parseInt(senal)){
             GestorJuego.getInstance().getRecursos()[i] = false;
           }
           else{
             GestorJuego.getInstance().getRecursos()[i] = true;  
           }
        }

        //Se actualizan los mensajes de apertura!
        for(int i=0; i<mensajes.length(); i++)
        {
           String senal = mensajes.charAt(i)+"";  
           if(0 == Integer.parseInt(senal)){
             GestorJuego.getInstance().getMsnApertura()[i] = false;
           }
           else{
             GestorJuego.getInstance().getMsnApertura()[i] = true;  
           }
        }            

        //Se actualiza el escenario inicial!
        int fila = Integer.parseInt(escenarioinicial.charAt(0)+"");  
        int columna =  Integer.parseInt(escenarioinicial.charAt(1)+""); 

        GestorJuego.getInstance().getEscenarioInicial()[0] = fila;
        GestorJuego.getInstance().getEscenarioInicial()[1] = columna;
     }
     
     
     public boolean usuarioRepetido(String nuevoNickName)
     {
        ArrayList<String[]> datosBD = obtenerTodosLosDatos();
        
        for(int i=0; i<datosBD.size(); i++)
        {
          if(nuevoNickName.equals(datosBD.get(i)[0])) // Se comparan los nombres existentes con el nuevo.
          {
            return true;  
          }
        }
        return false;
     }
     
     public void ingresarNuevoUsuario(String nickName, String password)
     {
        ArrayList<String[]> datosBD = obtenerTodosLosDatos(); 
        String[] nuevoUsuario = (nickName+",,"+password+",,0,,tahi,,000000,,00000000,,03,,000000000").split(",,");
        
        datosBD.add(nuevoUsuario);
        
        actualizarBD(datosBD);        
     } 
     
     public void actualizarGenero(String usuario, String genero)
     {
        ArrayList<String[]> datosBD = obtenerTodosLosDatos();
        
        for(int i=0; i<datosBD.size(); i++)
        {
          if(usuario.equals(datosBD.get(i)[0])) // Se busca el nombre en la BD local.
          {
             datosBD.get(i)[3] = genero;
             actualizarBD(datosBD);
             return;
          }          
        }
     }
     
     public boolean guardarPartida()
     {
        String usuario = GestorJuego.getInstance().getUsuario(); 
        String personaje = GestorJuego.getInstance().getGenero();
        String puertas = "";
        String recursos = "";
        String mensajes = "";
        String escenarioinicial = "";
        String puntaje = "";
        
        for(int i=0; i<GestorJuego.getInstance().getPuertas().length; i++)
        {
           if(GestorJuego.getInstance().getPuertas()[i]){puertas += "1";} 
           else{puertas += "0";} 
        }
        
        for(int i=0; i<GestorJuego.getInstance().getRecursos().length; i++)
        {
           if(GestorJuego.getInstance().getRecursos()[i]){recursos += "1";} 
           else{recursos += "0";} 
        }
        
        for(int i=0; i<GestorJuego.getInstance().getMsnApertura().length; i++)
        {
           if(GestorJuego.getInstance().getMsnApertura()[i]){mensajes += "1";} 
           else{mensajes += "0";}  
        }
        
        for(int i=0; i<GestorJuego.getInstance().getEscenarioInicial().length; i++)
        {
           escenarioinicial += GestorJuego.getInstance().getEscenarioInicial()[i]; 
        }
        
        puntaje += GestorJuego.getInstance().getPuntaje();
        
        ArrayList<String[]> datosBD = obtenerTodosLosDatos();
        
        for(int i=0; i<datosBD.size(); i++)
        {
          if(usuario.equals(datosBD.get(i)[0])) // Se busca el nombre en la BD local.
          {
             puntajeActual = Integer.parseInt(puntaje) - Integer.parseInt(datosBD.get(i)[2]);
              
             datosBD.get(i)[2] = puntaje;
             datosBD.get(i)[4] = recursos;
             datosBD.get(i)[3] = personaje;
             datosBD.get(i)[5] = puertas;
             datosBD.get(i)[6] = escenarioinicial;
             datosBD.get(i)[7] = mensajes;
             
             actualizarBD(datosBD);
             
             aumentarPuntajeAleatorio("Daniel123");
             aumentarPuntajeAleatorio("JessicaC");
             aumentarPuntajeAleatorio("Jonathan1021");
             aumentarPuntajeAleatorio("Lexis");
             
             return true;
          }          
        }
        // Si llega aquí, es por q el usuario sólo esta en el servidor orion.        
        ingresarNuevoUsuario(GestorJuego.getInstance().getUsuario(), GestorJuego.getInstance().getPassword()); 
        return false;
     }
     
     public void aumentarPuntajeAleatorio(String usuario)
     {
        if(!(new Random().nextBoolean()))
        {
            return;
        }
         
        ArrayList<String[]> datosBD = obtenerTodosLosDatos();
        
        for(int i=0; i<datosBD.size(); i++)
        {
          if(usuario.equals(datosBD.get(i)[0])) // Se busca el nombre en la BD local.
          {
             int aumentoPuntaje = new Random().nextInt(5);
             
             while(aumentoPuntaje < 1)
             {
                 aumentoPuntaje = new Random().nextInt(5);
             }
              
             datosBD.get(i)[2] = (Integer.parseInt(datosBD.get(i)[2])+(puntajeActual/aumentoPuntaje))+"";
             
             actualizarBD(datosBD);
             
             return;
          }          
        }              
     }
     
     public ArrayList<Usuario> consultarTop()
     {
        ArrayList<String[]> datosBD = obtenerTodosLosDatos();
                
        for(int i=0; i<datosBD.size(); i++)
        {
           for(int j=i+1; j<datosBD.size(); j++)
           {    
              if(Integer.parseInt(datosBD.get(i)[2]) < Integer.parseInt(datosBD.get(j)[2]))
              {
                 Collections.swap(datosBD, i, j);
              }
           }
        }
        
        ArrayList<Usuario> top5 = new ArrayList<>();
        
        for(int i=0; i<datosBD.size(); i++)
        {
          if(i == 5) { return top5; }  
          top5.add(new Usuario(datosBD.get(i)[0],datosBD.get(i)[2],datosBD.get(i)[3]));          
        }        
        return top5;
     } 
     
     
     public String[] buscarUsuario(String usuario, String password)
     {        
        try{
            // Abrimos el archivo            
            FileInputStream fstream = new FileInputStream(ruta);
            // Creamos el objeto de entrada
            DataInputStream entrada = new DataInputStream(fstream);
            // Creamos el Buffer de Lectura
            BufferedReader buffer = new BufferedReader(new InputStreamReader(entrada));
            String strLinea;
            // Leer el archivo linea por linea
            while ((strLinea = buffer.readLine()) != null)   {
                
                String[] datosUsuario = strLinea.split(",,");
                                
                if(datosUsuario[0].equals(usuario) && datosUsuario[1].equals(password))
                {                    
                    entrada.close();
                    return datosUsuario;
                }  
            }
            // Cerramos el archivo
            entrada.close();
            buffer.close();
            fstream.close();
        }catch (Exception e){ //Catch de excepciones
            //System.err.println("Ocurrio un error: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "¡Hubo un problema con la conexión\na la Base de Datos Local! ...", "Error", 0);
        }  
        return null;
     }
}
