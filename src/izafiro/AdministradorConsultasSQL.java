/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package izafiro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Jonathan
 */
public class AdministradorConsultasSQL {
    
     public AdministradorConsultasSQL(){}
    
     public ArrayList<Usuario> consultarTop()
     {
        Connection conex = null;
        PreparedStatement ps = null;
        ResultSet resultados = null;
        
        int tam = 0;
        
        ArrayList<Usuario> usuarios = new ArrayList<>();
        
        try {
            conex = Conexion.getConnection();
            ps = conex.prepareStatement("Select * from JUGADOR order by PUNTAJE desc");
            resultados = ps.executeQuery();
            
            while(resultados.next() && tam < 5)
            {
              usuarios.add(new Usuario (resultados.getString("nickname"),resultados.getString("puntaje"),resultados.getString("genero"))); // ESTA ES LA LINEA DE LINEAS!! LECTURA DE LA BASE DE DATOS
              tam++;
            }
            
        } catch (SQLException ex) {
         //JOptionPane.showMessageDialog(null, "¡Hubo un problema con la conexión\na la Base de Datos! ...", "Error", 0);
         //---JOptionPane.showMessageDialog(null, "Se buscará en la Base de Datos Local ...", "Mensaje", 1);
         GestorJuego.getInstance().setUbicacionBD(1);
         //Logger.getLogger(AdministradorConsultasSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        finally{
          try{     
            if(resultados != null){resultados.close();}
            if(ps != null){ps.close();}
            if(conex != null){conex.close();}
          }
          catch (SQLException ex) {
            //Logger.getLogger(AdministradorConsultasSQL.class.getName()).log(Level.SEVERE, null, ex);
          }
        }
        
        return usuarios;
     }
     
     public boolean usuarioRepetido(String nuevoNickName)
     {
        Connection conex = null;
        PreparedStatement ps = null;
        ResultSet resultados = null;
        
        try {
            conex = Conexion.getConnection();
            ps = conex.prepareStatement("Select nickname from JUGADOR");
            resultados = ps.executeQuery();
           
            
            while(resultados.next())
            {  
              if(nuevoNickName.equals(resultados.getString("nickname")))
              {                    
                 try{     
                   if(resultados != null){resultados.close();}
                   if(ps != null){ps.close();}
                   if(conex != null){conex.close();}
                 }
                 catch (SQLException ex) {
                   //Logger.getLogger(AdministradorConsultasSQL.class.getName()).log(Level.SEVERE, null, ex);
                 }                  
                 return true;   
              }
            }
            
           } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "¡Hubo un problema con la conexión\na la Base de Datos! ...", "Error", 0);
            //---JOptionPane.showMessageDialog(null, "Se buscará en la Base de Datos Local ...", "Mensaje", 1);
            GestorJuego.getInstance().setUbicacionBD(1);
            //Logger.getLogger(AdministradorConsultasSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        finally{
          try{     
            if(resultados != null){resultados.close();}
            if(ps != null){ps.close();}
            if(conex != null){conex.close();}
          }
          catch (SQLException ex) {
            //Logger.getLogger(AdministradorConsultasSQL.class.getName()).log(Level.SEVERE, null, ex);
          }
        }
        
        return false;
     }
     
     public boolean usuarioCorrecto(String nickName, String password)
     {
        Connection conex = null;
        PreparedStatement ps = null;
        ResultSet resultados = null;
        
        try {
            conex = Conexion.getConnection();
            ps = conex.prepareStatement("Select * from JUGADOR");
            resultados = ps.executeQuery();
           
            
            while(resultados.next())
            {  
              if(nickName.equals(resultados.getString("nickname")))
              {                  
                if(password.equals(resultados.getString("clave")))
                { 
                  try{     
                    if(resultados != null){resultados.close();}
                    if(ps != null){ps.close();}
                    if(conex != null){conex.close();}
                  }
                  catch (SQLException ex) {
                    //Logger.getLogger(AdministradorConsultasSQL.class.getName()).log(Level.SEVERE, null, ex);
                  }  
                  return true;  //el usuario es correcto
                }
                else
                {
                  try{     
                    if(resultados != null){resultados.close();}
                    if(ps != null){ps.close();}
                    if(conex != null){conex.close();}
                  }
                  catch (SQLException ex) {
                    //Logger.getLogger(AdministradorConsultasSQL.class.getName()).log(Level.SEVERE, null, ex);
                  }   
                  return false;  //la clave no coincide
                }
              }
            }
            
           } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "¡Hubo un problema con la conexión\na la Base de Datos! ...", "Error", 0);
            //---JOptionPane.showMessageDialog(null, "Se buscará en la Base de Datos Local ...", "Mensaje", 1);
            GestorJuego.getInstance().setUbicacionBD(1);
            //Logger.getLogger(AdministradorConsultasSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        finally{
          try{     
            if(resultados != null){resultados.close();}
            if(ps != null){ps.close();}
            if(conex != null){conex.close();}
          }
          catch (SQLException ex) {
            //Logger.getLogger(AdministradorConsultasSQL.class.getName()).log(Level.SEVERE, null, ex);
          }
        }
        
        return false; //el nickname ingresado no existe
     }    
     
    
     public void ingresarNuevoUsuario(String nickName, String password)
     {
        Connection conex = null;
        PreparedStatement ps = null;
        ResultSet resultados = null;
        
        try {
            conex = Conexion.getConnection();
            ps = conex.prepareStatement("insert into JUGADOR values ('"+nickName+"','"+password+"',0,'tahi','000000','00000000','03','000000000')");
            resultados = ps.executeQuery();       
            GestorJuego.getInstance().setUbicacionBD(0);
                
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "¡Hubo un problema con la conexión\na la Base de Datos! ...", "Error", 0);
            //---JOptionPane.showMessageDialog(null, "Los datos han sido guardados en la\nBase de Datos Local ...", "Mensaje", 1);
            GestorJuego.getInstance().setUbicacionBD(1);
            //Logger.getLogger(AdministradorConsultasSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        finally{
          try{     
            if(resultados != null){resultados.close();}
            if(ps != null){ps.close();}
            if(conex != null){conex.close();}
          }
          catch (SQLException ex) {
            //Logger.getLogger(AdministradorConsultasSQL.class.getName()).log(Level.SEVERE, null, ex);
          }
        }
     }
     
     public void actualizarGenero(String usuario, String genero)
     {
        Connection conex = null;
        PreparedStatement ps = null;
        ResultSet resultados = null;
        
        try {
            conex = Conexion.getConnection();
            ps = conex.prepareStatement("update JUGADOR set genero='"+GestorJuego.getInstance().getGenero()+"' WHERE nickname='"+GestorJuego.getInstance().getUsuario()+"'");
            resultados = ps.executeQuery(); 
           
           } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "¡Hubo un problema con la conexión\na la Base de Datos! ...", "Error", 0);
            //JOptionPane.showMessageDialog(null, "Se trabajará con la Base de Datos Local ...", "Error", 1);
            GestorJuego.getInstance().setUbicacionBD(1);
            //Logger.getLogger(AdministradorConsultasSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        finally{
          try{     
            if(resultados != null){resultados.close();}
            if(ps != null){ps.close();}
            if(conex != null){conex.close();}
          }
          catch (SQLException ex) {
            //Logger.getLogger(AdministradorConsultasSQL.class.getName()).log(Level.SEVERE, null, ex);
          }
        }
     }
     
     public void continuarPartida(String usuario)
     {
        Connection conex = null;
        PreparedStatement ps = null;
        ResultSet resultados = null;
        
        try {
            conex = Conexion.getConnection();
            ps = conex.prepareStatement("select * from JUGADOR where nickname='"+usuario+"'");
            resultados = ps.executeQuery(); 
            
            resultados.next();
            
            GestorJuego.getInstance().setGenero(resultados.getString("genero"));
            //Sonidos.getInstance().setDano();
            GestorJuego.getInstance().setPuntaje(Integer.parseInt(resultados.getString("puntaje")));
            
            String puertas = resultados.getString("puertas");
            String recursos = resultados.getString("recursos");
            String mensajes = resultados.getString("msnapertura");
            String escenarioinicial = resultados.getString("escenarioinicial");
            
            
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
            
            
           } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "¡Hubo un problema con la conexión\na la Base de Datos! ...", "Error", 0);
            //---JOptionPane.showMessageDialog(null, "Se trabajará con la Base de Datos Local ...", "Mensaje", 1);
            GestorJuego.getInstance().setUbicacionBD(1);
            //Logger.getLogger(AdministradorConsultasSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        finally{
          try{     
            if(resultados != null){resultados.close();}
            if(ps != null){ps.close();}
            if(conex != null){conex.close();}
          }
          catch (SQLException ex) {
            //Logger.getLogger(AdministradorConsultasSQL.class.getName()).log(Level.SEVERE, null, ex);
          }
        }
     }
     
     
     public void guardarPartida()
     {
        AdministradorBDLocal adL = new AdministradorBDLocal();
        
        if(!adL.guardarPartida()){adL.guardarPartida();}
        
        Connection conex = null;
        PreparedStatement ps = null;
        ResultSet resultados = null;
        
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
        
        
        try {
            conex = Conexion.getConnection();
            ps = conex.prepareStatement("update JUGADOR set puntaje="+puntaje+", recursos='"+recursos+"', puertas='"+puertas+"', escenarioinicial='"+escenarioinicial+"', msnapertura='"+mensajes+"' WHERE nickname='"+GestorJuego.getInstance().getUsuario()+"'");
            
            resultados = ps.executeQuery();               
            
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "¡Hubo un problema con la conexión\na la Base de Datos! ...", "Error", 0);
            //---JOptionPane.showMessageDialog(null, "Se guardarán los datos en la Base\nde Datos Local ...", "Mensaje", 1);
            GestorJuego.getInstance().setUbicacionBD(1);
            //Logger.getLogger(AdministradorConsultasSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        finally{
          try{     
            if(resultados != null){resultados.close();}
            if(ps != null){ps.close();}
            if(conex != null){conex.close();}
          }
          catch (SQLException ex) {
            //Logger.getLogger(AdministradorConsultasSQL.class.getName()).log(Level.SEVERE, null, ex);
          }
        }
     }
     
     
     public void mostrarUsuarios()
     {
        Connection conex = null;
        PreparedStatement ps = null;
        ResultSet resultados = null;
        
        try {
            conex = Conexion.getConnection();
            ps = conex.prepareStatement("Select nickname,clave from JUGADOR");
            resultados = ps.executeQuery();     
            
            while(resultados.next())
            {
              System.out.print(resultados.getString("nickname"));
              System.out.println(resultados.getString("clave"));
            }
            
            } catch (SQLException ex) {
              //JOptionPane.showMessageDialog(null, "¡Hubo un problema con la conexión\na la Base de Datos! ...", "Error", 0);
              GestorJuego.getInstance().setUbicacionBD(1);
              //Logger.getLogger(AdministradorConsultasSQL.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        finally{
          try{     
            if(resultados != null){resultados.close();}
            if(ps != null){ps.close();}
            if(conex != null){conex.close();}
          }
          catch (SQLException ex) {
            //Logger.getLogger(AdministradorConsultasSQL.class.getName()).log(Level.SEVERE, null, ex);
          }
        }
     }
}
