package application.modelo;

import java.io.Serializable;
import javafx.scene.control.SingleSelectionModel;

public class ModeloAlumno implements Serializable {

	private String id;
	private String carnet;
	private String nombre;
	private String curso;

	public ModeloAlumno() {

	}

	public ModeloAlumno(String id, String carnet, String nombre, String curso) {
		this.id = id;
		this.carnet = carnet;
		this.nombre = nombre;
		this.curso = curso;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCarnet() {
		return carnet;
	}

	public void setCarnet(String carnet) {
		this.carnet = carnet;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

    public void setCurso(SingleSelectionModel<String> Curso) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
