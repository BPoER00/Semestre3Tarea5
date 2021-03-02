
package semestre3tarea5.Conexion;

import java.sql.Connection;
import javax.swing.JOptionPane;


public class ConexionDB {
    
    public static void Connect(){
        Connection conn = null;
        try{
            String url = "jdbc:sqlite:|";
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Advertencia","Error: "+e, JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
