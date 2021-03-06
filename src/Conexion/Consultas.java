/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import application.modelo.AlertasPersonalizadas;
import application.modelo.ModeloAlumno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bryan Paz Ramirez
 */
public class Consultas {
	public PreparedStatement ps;

	public boolean Guardar(ModeloAlumno alumno) {

		try {
			ConexionDB Conn = new ConexionDB();
			Connection con = Conn.conexion();

			ps = con.prepareStatement("INSERT INTO DatosEstudiante (Carne, Nombre, Curso) VALUES (?, ?, ?)");

			ps.setString(1, alumno.getCarnet());
			ps.setString(2, alumno.getNombre());
			ps.setString(3, alumno.getCurso());

			ps.executeUpdate();
			return true;

		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

	/**
	 * Obtenemos los datos que se encuentren dentro de la base de datos
	 * 
	 * @return
	 */
	public List<ModeloAlumno> consultarTabla() {

		boolean encontrado = false;
		List<ModeloAlumno> lista = new ArrayList<>();

		// Instanciamos un objeto para conectarnos a la base de datos:
		ConexionDB conexion = new ConexionDB();

		// Establecemos conexión:
		Connection CONEXION = conexion.conexion();

		// Armamos la consulta
		String SQL = "SELECT * FROM DatosEstudiante";

		// Creamos la sentencia:
		try {
			PreparedStatement sentencia = CONEXION.prepareStatement(SQL);
			ResultSet res = sentencia.executeQuery();

			// Si se llega ejecutar, entonces nos dará los datos del alumno:
			while (res.next()) {
				// Declaramos un dto para obtener los datos:
				ModeloAlumno miAlumno = new ModeloAlumno();
				encontrado = true;

				// Agregamos datos
				miAlumno.setId(String.valueOf(res.getInt("Id")));
				miAlumno.setCarnet(res.getString("Carne"));
				miAlumno.setNombre(res.getString("Nombre"));
				miAlumno.setCurso(res.getString("Curso"));

				// Lo agregamos a la lista:
				lista.add(miAlumno);
			}

			// Cerramos la conexión
			CONEXION.close();
			conexion = null;
			CONEXION = null;
		} catch (SQLException e) {
			AlertasPersonalizadas miAlerta = new AlertasPersonalizadas();
			miAlerta.mensajeError(e.getMessage(), "Error");
		}
		if (!encontrado) {
			String mensaje = "No hay alumnos por mostrar.";
			AlertasPersonalizadas miAlerta = new AlertasPersonalizadas();
			miAlerta.mensajeError(mensaje, "Error");
		}
		return lista.isEmpty() ? new ArrayList<>() : lista;
	}

	/**
	 * Busca a un alumno de acuerdo al id o carnet.
	 * 
	 * @param Seleccion
	 * @param Valor
	 * @return
	 */
	public List<ModeloAlumno> buscar(String Seleccion, String Valor) {
		boolean encontrado = false;
		List<ModeloAlumno> lista = new ArrayList<>();

		String sql = "";
		if (Seleccion.equals("Id")) {
			sql = "SELECT * FROM DatosEstudiante WHERE Id = ?";

		} else if (Seleccion.equals("Carnet")) {
			sql = "SELECT * FROM DatosEstudiante WHERE Carne = ?";

		}

		// Instanciamos un objeto para conectarnos a la base de datos:
		ConexionDB conexion = new ConexionDB();

		// Establecemos conexión:
		Connection CONEXION = conexion.conexion();

		// Creamos la sentencia:
		try {
			PreparedStatement sentencia = CONEXION.prepareStatement(sql);

			sentencia.setString(1, Valor);

			ResultSet res = sentencia.executeQuery();

			// Si se llega ejecutar, entonces nos dará los datos del cliente:
			while (res.next()) {
				// Declaramos un dto para obtener los datos:
				ModeloAlumno miAlumno = new ModeloAlumno();
				encontrado = true;

				// Agregamos datos
				miAlumno.setId(String.valueOf(res.getInt("Id")));
				miAlumno.setCarnet(res.getString("Carne"));
				miAlumno.setNombre(res.getString("Nombre"));
				miAlumno.setCurso(res.getString("Curso"));

				// Lo agregamos a la lista:
				lista.add(miAlumno);
			}

			// Cerramos la conexión
			CONEXION.close();
			conexion = null;
			CONEXION = null;
		} catch (SQLException e) {
			AlertasPersonalizadas miAlerta = new AlertasPersonalizadas();
			miAlerta.mensajeError(e.getMessage(), "Error");
		}
		if (!encontrado) {
			String mensaje = "No hay alumnos por mostrar.";
			AlertasPersonalizadas miAlerta = new AlertasPersonalizadas();
			miAlerta.mensajeError(mensaje, "Error");
		}

		return lista.isEmpty() ? new ArrayList<>() : lista;

	}

	/**
	 * Elimina al alumno de la base de datos
	 * 
	 * @param id
	 */
	public void Eliminar(String id) {
		String sql;
		sql = "DELETE FROM DatosEstudiante WHERE Id = ?";

		try {
			ConexionDB conectar = new ConexionDB();
			Connection conn = conectar.conexion();

			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.executeUpdate();

			conn.close();
		} catch (Exception e) {
			AlertasPersonalizadas alert = new AlertasPersonalizadas();
			alert.mensajeError("Error: " + e.getMessage(), "Advertencia");
		}
	}

	/**
	 * Actualiza los datos del alumno dentro de la base de datos
	 * 
	 * @param alumno
	 * @return
	 */
	public boolean Editar(ModeloAlumno alumno) {
		boolean exito = false;
		String sql = "";
		sql = "UPDATE DatosEstudiante SET " + "Carne = ?, " + "Nombre = ?, " + "Curso = ? " + " WHERE Id = ?";

		try {
			ConexionDB conectar = new ConexionDB();
			Connection conn = conectar.conexion();

			ps = conn.prepareStatement(sql);
			ps.setString(1, alumno.getCarnet());
			ps.setString(2, alumno.getNombre());
			ps.setString(3, alumno.getCurso());
			ps.setString(4, alumno.getId());

			ps.executeUpdate();

			conn.close();
			exito = true;

		} catch (Exception e) {
			AlertasPersonalizadas alert = new AlertasPersonalizadas();
			alert.mensajeError("Error: " + e.getMessage(), "Advertencia");
		}
		return exito;
	}
}
