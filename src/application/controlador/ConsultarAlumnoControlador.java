package application.controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class ConsultarAlumnoControlador {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField textId;

	@FXML
	private TextField textCarnet;

	@FXML
	private TextField textNombre;

	@FXML
	private TextField textCurso;

	@FXML
	void clickEditar(ActionEvent event) {
		activarCampos(true);
	}

	@FXML
	void clickEliminar(ActionEvent event) {

	}

	@FXML
	void clickGuardar(ActionEvent event) {
		activarCampos(false);
	}

	@FXML
	void teclaPresionadaBuscar(KeyEvent event) {
		System.out.println("Normalmente solo la utilizo para cuando se presiona la tecla Enter");
		// Te dejo el código:
		if (event.getCode().equals(KeyCode.ENTER)) {
			// Hacer referencia al método "Buscar Alumno" o lo que quieras
			System.out.println("Has presionado la tecla enter en Buscar...");
		}
	}

	@FXML
	void teclaPresionadaCampos(KeyEvent event) {
		System.out.println("Normalmente solo la utilizo para cuando se presiona la tecla Enter");
		// Te dejo el código:
		if (event.getCode().equals(KeyCode.ENTER)) {
			// Hacer referencia al método "Guardar" o lo que quieras
			System.out.println("Has presionado la tecla enter entre los campos...");
		}
	}

	@FXML
	public void initialize(String recibirId) {

		// Si la consulta se abrió desde la tabla de reportes, ejecutamos:
		if (!recibirId.equals(""))
			inicializarConsulta(recibirId);
		
		// Si la consulta se abrió desde el menú, solamente desactivamos los campos:
		activarCampos(false);

	}

	private void inicializarConsulta(String id) {
		
		// ESTO ES SOLO UNA PRUEBA
		textNombre.setText("Has accedido desde el Reportes");
		// Fin de la prueba.
		
		// Realizar consulta
		

		// Obtener datos de la consulta
		

		// Setear los datos en loas Text field
		

		// Desactivar la edición de los campos
		activarCampos(false);
	}
	
	
	/**
	 * Activa o desactiva los campos donde se muestra la información del alumno.
	 * @param valor
	 */
	private void activarCampos(boolean valor) {
		textId.setEditable(valor);
		textCarnet.setEditable(valor);
		textNombre.setEditable(valor);
		textCurso.setEditable(valor);
	}
}
