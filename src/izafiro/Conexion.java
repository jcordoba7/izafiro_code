/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package izafiro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import oracle.jdbc.OracleDriver;

/**
 *
 * @author Jonathan
 */
public class Conexion {  
    
    static String usernameConnection = "CIS1310IS08";
    static String passwordConnection = "i7itdub0paIAWQ";
    static String serverConnection = "";
    
     public static Connection getConnection() throws SQLException 
     {         
        String username = usernameConnection;
        String password = passwordConnection;
        String thinConn = serverConnection;
        
        DriverManager.registerDriver(new OracleDriver());
        Connection conn = DriverManager.getConnection(thinConn, username, password);
        conn.setAutoCommit(false);
        return conn;
     }   
}
