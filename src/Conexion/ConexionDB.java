
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
 
public class ConexionDB {
    
    private String url = "jdbc:sqlite:DatosTarea5.db";
    private Connection datos = null;
    
    public Connection conexion(){
        // SQLite connection string
        Connection conn = null;
        try {
            String url = "jdbc:sqlite:DatosTarea5.db";
            
            conn = DriverManager.getConnection(url);
            
            if(conn == null){
                System.out.println("no hay conexion");
            }else{
                System.out.println("Conexion exitosa");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return conn;
    
    }
    
}
