package application.controlador;

import Conexion.Consultas;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import application.modelo.AlertasPersonalizadas;
import application.modelo.ModeloAlumno;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

public class ConsultarAlumnoControlador {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button btnEliminar;

	@FXML
	private Button btnGuardar;

	@FXML
	private Button btnEditar;

	@FXML
	private Button btnBuscar;

	@FXML
	private TextField textId;

	@FXML
	private TextField textCarnet;

	@FXML
	private TextField textNombre;

	@FXML
	private TextField textCurso;

	@FXML
	private TextField textBuscar;

	@FXML
	private ComboBox<String> comboBuscarPor;

	private AlertasPersonalizadas miAlerta = new AlertasPersonalizadas();

	/* =========== Comandos para los botones =========== */
	@FXML
	void clickBuscar(ActionEvent event) {
		Buscar();
	}

	@FXML
	void clickEditar(ActionEvent event) {
		activarCampos(true);
	}

	@FXML
	void clickEliminar(ActionEvent event) {
		eliminarAlumno();
	}

	@FXML
	void clickGuardar(ActionEvent event) {
		guardarCambios();
	}

	@FXML
	void enterBtnEditar(KeyEvent event) {
		if (event.getCode().equals(KeyCode.ENTER)) {
			activarCampos(true);
		}
	}

	@FXML
	void enterBtnEliminar(KeyEvent event) {
		if (event.getCode().equals(KeyCode.ENTER)) {
			eliminarAlumno();
		}
	}

	@FXML
	void enterBtnGuardar(KeyEvent event) {
		if (event.getCode().equals(KeyCode.ENTER)) {
			guardarCambios();
		}
	}

	@FXML
	void enterBtnBuscar(KeyEvent event) {
		if (event.getCode().equals(KeyCode.ENTER)) {
			Buscar();
		}
	}

	/* =========== Comandos para los TextField =========== */
	@FXML
	void teclaPresionadaBuscar(KeyEvent event) {
		if (event.getCode().equals(KeyCode.ENTER)) {
			Buscar();
			// Hacer referencia al metodo "Buscar Alumno" o lo que quieras
			System.out.println("Has presionado la tecla enter en Buscar...");
		}
	}

	@FXML
	void teclaPresionadaCampos(KeyEvent event) {
		if (event.getCode().equals(KeyCode.ENTER)) {
			guardarCambios();
		}
	}

	/* =========== Inicializador =========== */
	@FXML
	public void initialize(ModeloAlumno recibirAlumno) {

		deshabilitarBotones(true);

		// Si la consulta se abrio desde la tabla de reportes, ejecutamos:
		if (!recibirAlumno.getId().equals(""))
			inicializarDatos(recibirAlumno);

		// Si la consulta se abrio desde el menu, solamente desactivamos los campos:
		activarCampos(false);

		// Desactivamos el TextId una vez terminada la consulta, para que no sufra
		// cambios por el usuario
		textId.setEditable(false);

		// Ingresamos la forma en que puede buscar a un alumno el usuario
		ObservableList<String> items = FXCollections.observableArrayList();
		items.addAll("Id", "Carnet");

		comboBuscarPor.setItems(items);
		comboBuscarPor.setEditable(false);
		comboBuscarPor.setVisibleRowCount(5);
	}

	/**
	 * Inserta los datos del alumno seleccionado en la tabla de reportes.
	 * 
	 * @param recibirAlumno
	 */
	private void inicializarDatos(ModeloAlumno recibirAlumno) {
		// Seteamos los datos
		textId.setText(recibirAlumno.getId());
		textCarnet.setText(recibirAlumno.getCarnet());
		textNombre.setText(recibirAlumno.getNombre());
		textCurso.setText(recibirAlumno.getCurso());

		// Desactivar la edicion de los campos
		activarCampos(false);

		// Activamos botones
		deshabilitarBotones(false);
	}

	/**
	 * Activa o desactiva los campos donde se muestra la informaci�n del alumno.
	 * 
	 * @param valor
	 */
	private void activarCampos(boolean valor) {
		textCarnet.setEditable(valor);
		textNombre.setEditable(valor);
		textCurso.setEditable(valor);
	}

	/**
	 * Elimina a un alumno
	 */
	private void eliminarAlumno() {
		String mensaje = "¿Está seguro de eliminar este alumno?";
		if (miAlerta.mensajeConfirmar(mensaje, "Eliminar alumno")) {

			Eliminar();

			miAlerta.mensajeExito("Alumno eliminado exitósamente.", "Éxito");
			Stage cerrar = (Stage) btnEliminar.getScene().getWindow();
			cerrar.close();
		}
	}

	/**
	 * Guarda los cambios realizados al editar
	 */
	private void guardarCambios() {
		String mensaje = "¿Está seguro de querer guardar los cambios?";
		if (miAlerta.mensajeConfirmar(mensaje, "Guardar cambios")) {
			if (Editar()) {
				miAlerta.mensajeExito("Alumno actualizado exitósamente.", "Éxito");
				activarCampos(false);
			}
		}
	}

	/**
	 * Deshabilita los botones de acuerdo de donde provengan los datos.
	 * 
	 * @param valor
	 */
	private void deshabilitarBotones(boolean valor) {
		btnEditar.setDisable(valor);
		btnEliminar.setDisable(valor);
		btnGuardar.setDisable(valor);
	}

	/**
	 * Elimina al alumno de acuerdo al Id
	 */
	public void Eliminar() {
		Consultas eliminarDato = new Consultas();
		eliminarDato.Eliminar(textId.getText());
	}

	/**
	 * Busca dentro de la base de datos ya sea con Id o carnet al alumno consultado.
	 */
	public void Buscar() {
		String dato = comboBuscarPor.getValue();
		String enviar = textBuscar.getText();
		if (!enviar.equals("")) {
			Consultas buscar = new Consultas();
			List<ModeloAlumno> alumno = new ArrayList<ModeloAlumno>();
			alumno = buscar.buscar(dato, enviar);

			// Seteamos los datos
			textId.setText(alumno.get(0).getId());
			textCarnet.setText(alumno.get(0).getCarnet());
			textNombre.setText(alumno.get(0).getNombre());
			textCurso.setText(alumno.get(0).getCurso());

			deshabilitarBotones(false);

		} else {
			AlertasPersonalizadas alert = new AlertasPersonalizadas();
			alert.mensajeError("Primero llene los campos y vuelva a intentar", "Advertencia");
		}
	}

	/**
	 * Actualiza los datos del alumno dentro de la base de datos.
	 * @return
	 */
	public boolean Editar() {
		try {
			ModeloAlumno alumno = new ModeloAlumno();
			alumno.setId(textId.getText());
			alumno.setCarnet(textCarnet.getText());
			alumno.setNombre(textNombre.getText());
			alumno.setCurso(textCurso.getText());
			// Actualizamos
			Consultas editar = new Consultas();
			return editar.Editar(alumno);
		} catch (Exception e) {
			AlertasPersonalizadas alert = new AlertasPersonalizadas();
			alert.mensajeError(e.getMessage(), "Error");
		}
		return false;
	}
}
