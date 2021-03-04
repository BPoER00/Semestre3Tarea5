/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import application.modelo.ModeloAlumno;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Bryan Paz Ramirez
 */
public class Consultas {
    
    public void Guardar(String Carne, String Nombre, String Curso){
        PreparedStatement ps;
        //ModeloAlumno datos = new ModeloAlumno();
        //String Carne = datos.getCarnet();
        //String Nombre = datos.getNombre();
        //String Curso = datos.getCurso();
        
        try{
            
            ConexionDB Conn = new ConexionDB();
            Connection con = Conn.conexion();
            
            ps = con.prepareStatement("INSERT INTO DatosEstudiante (Carne, Nombre, Curso) VALUES (?, ?, ?)");
            
            ps.setString(1, Carne);
            ps.setString(2, Nombre);
            ps.setString(3, Curso);
            
            System.out.println("Dato 1: "+Carne);
            System.out.println("Dato 2: "+Nombre);
            System.out.println("Dato 3: "+Curso);
            
            ps.executeUpdate();
            
        }catch(Exception e){
            System.out.println(e);
            
        }
    }
    
}
