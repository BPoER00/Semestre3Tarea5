package application.controlador;

import java.net.URL;
import java.util.ResourceBundle;

import application.modelo.AlertasPersonalizadas;
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
		activarCampos(true);
	}

	@FXML
	void enterBtnEliminar(KeyEvent event) {
		eliminarAlumno();
	}

	@FXML
	void enterBtnGuardar(KeyEvent event) {
		guardarCambios();
		activarCampos(false);
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
	public void initialize(String recibirId) {

		// Si la consulta se abrio desde la tabla de reportes, ejecutamos:
		if (!recibirId.equals(""))
			inicializarConsulta(recibirId);

		// Si la consulta se abrio desde el menu, solamente desactivamos los campos:
		activarCampos(false);

		// Desactivamos el TextId una vez terminada la consulta, para que no sufra
		// cambios por el usuario
		textId.setEditable(false);

		// Ingresamos la forma en que puede buscar a un alumno el usuario
		ObservableList<String> items = FXCollections.observableArrayList();

		// Agregamos los cursos|
		items.addAll("Id", "Carnet");

		comboBuscarPor.setItems(items);
		comboBuscarPor.setEditable(false);
		comboBuscarPor.setVisibleRowCount(5);

	}

	private void inicializarConsulta(String id) {

		// ESTO ES SOLO UNA PRUEBA
		textNombre.setText("Has accedido desde el Reportes");
		// Fin de la prueba.

		// Realizar consulta

		// Obtener datos de la consulta

		// Setear los datos en los Text field

		// Desactivar la edicion de los campos
		activarCampos(false);
	}

	/**
	 * Activa o desactiva los campos donde se muestra la informaciï¿½n del alumno.
	 * 
	 * @param valor
	 */
	private void activarCampos(boolean valor) {
		textCarnet.setEditable(valor);
		textNombre.setEditable(valor);
		textCurso.setEditable(valor);
	}

	/**
	 * Le pregunta al usuario si está seguro de eliminar al alumno. Si confirma, se
	 * eliminará al alumno de la bsae de datos.
	 */
	private void eliminarAlumno() {
		String mensaje = "¿Está seguro de eliminar este alumno?";
		if (miAlerta.mensajeConfirmar(mensaje, "Eliminar alumno")) {

			// TODO: Si presiona sí, pues ejecutar la eliminación.

			miAlerta.mensajeExito("Alumno eliminado exitósamente.", "Exito");
			Stage cerrar = (Stage) btnEliminar.getScene().getWindow();
			cerrar.close();
		}
	}

	/**
	 * Pregunta al usuario si está seguro de guardar los cambios antes de ejecutar
	 * una actualización a la base de datos
	 */
	private void guardarCambios() {
		String mensaje = "¿Está seguro de querer guardar los cambios?";
		if (miAlerta.mensajeConfirmar(mensaje, "Guardar cambios")) {

			// TODO: Si presiona sí, pues ejecutar la actualización.

			miAlerta.mensajeExito("Alumno actualizado exitósamente.", "Exito");
		}
	}
}
