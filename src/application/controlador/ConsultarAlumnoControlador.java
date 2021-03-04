package application.controlador;

import java.net.URL;
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
	private ComboBox<String> comboBuscarPor;

	private AlertasPersonalizadas miAlerta = new AlertasPersonalizadas();

	/* =========== Comandos para los botones =========== */
	@FXML
	void clickBuscar(ActionEvent event) {
		System.out.println();
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
		activarCampos(false);
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
			activarCampos(false);
		}
	}

	@FXML
	void enterBtnBuscar(KeyEvent event) {
		if (event.getCode().equals(KeyCode.ENTER)) {
			System.out.println("Has presionado la tecla enter en Buscar...");
		}
	}

	/* =========== Comandos para los TextField =========== */
	@FXML
	void teclaPresionadaBuscar(KeyEvent event) {
		if (event.getCode().equals(KeyCode.ENTER)) {
			// Hacer referencia al metodo "Buscar Alumno" o lo que quieras
			System.out.println("Has presionado la tecla enter en Buscar...");
		}
	}

	@FXML
	void teclaPresionadaCampos(KeyEvent event) {
		if (event.getCode().equals(KeyCode.ENTER)) {
			// Hacer referencia al metodo "Guardar" o lo que quieras
			System.out.println("Has presionado la tecla enter entre los campos...");
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

			// TODO: Si presiona s�, pues ejecutar la eliminaci�n.

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

			miAlerta.mensajeExito("Alumno actualizado exitósamente.", "Éxito");
		}
	}
	
	/**
	 * Deshabilita los botones de acuerdo de donde provengan los datos.
	 * @param valor
	 */
	private void deshabilitarBotones(boolean valor) {
		btnEditar.setDisable(valor);
		btnEliminar.setDisable(valor);
		btnGuardar.setDisable(valor);
	}
}
