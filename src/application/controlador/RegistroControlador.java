package application.controlador;

import java.net.URL;
import java.util.ResourceBundle;

import application.modelo.AlertasPersonalizadas;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class RegistroControlador {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField textCarnet;

	@FXML
	private TextField textNombre;

	@FXML
	private ComboBox<String> comboCurso;

	@FXML
	private Button btnGuardar;

	@FXML
	private Button btnSalir;

	@FXML
	private Label labelErrorCarnet;

	@FXML
	private Label labelErrorNombre;

	@FXML
	private Label labelErrorCurso;

	AlertasPersonalizadas miAlerta = new AlertasPersonalizadas();

	/* =========== Comandos para los botones =========== */
	@FXML
	void clickGuardar(ActionEvent event) {
		guardarAlumno();
	}

	@FXML
	void clickSalir(ActionEvent event) {
		cerrarRegistro();
	}

	@FXML
	void enterBtnGuardar(KeyEvent event) {
		if (event.getCode().equals(KeyCode.ENTER)) {
			guardarAlumno();
		}
	}

	@FXML
	void enterBtnSalir(KeyEvent event) {
		if (event.getCode().equals(KeyCode.ENTER)) {
			cerrarRegistro();
		}
	}

	/* =========== Comandos para los TextField =========== */
	@FXML
	void teclaPresionada(KeyEvent event) {
		System.out.println("Normalmente solo la utilizo para cuando se presiona la tecla Enter");
		// Te dejo el codigo:
		if (event.getCode().equals(KeyCode.ENTER)) {
			// Hacer referencia al mï¿½todo "Guardar" o lo que quieras
			System.out.println("Has presionado la tecla enter...");
		}
	}

	/* =========== Inicializador =========== */
	@FXML
	void initialize() {
		insertarDatosAlComboBox();
		labelErrorCarnet.setVisible(false);
		labelErrorNombre.setVisible(false);
		labelErrorCurso.setVisible(false);
	}

	/**
	 * Inserta una lista de cursos disponbiles para los estudiantes
	 */
	private void insertarDatosAlComboBox() {
		ObservableList<String> items = FXCollections.observableArrayList();

		// Agregamos los cursos|
		items.addAll("Administraciï¿½n de tecnologï¿½as de informaciï¿½n", "Algebra lineal", "Algoritmos",
				"Anï¿½lisis de sistemas I", "Anï¿½lisis de sistemas II", "Arquitectura de computadoras I",
				"Arquitectura de computadoras II", "Aseguramiento de la calidad del software",
				"Autï¿½matas y lenguajes", "Base de datos I", "Base de datos II", "Cï¿½lculo I", "Cï¿½lculo II",
				"Compiladores", "Contabilidad I", "Contabilidad II", "Derecho Informï¿½tico", "Desarrollo Humano",
				"Desarrollo Web", "Electrï¿½nica analï¿½gica", "Electrï¿½nica digital", "Emprendedores de negocios",
				"Estadï¿½stica I", "Estadï¿½stica II", "ï¿½tica profesional", "Fï¿½sica I", "Fï¿½sica II",
				"Inteligencia artificial", "Intenierï¿½a de software", "Introducciï¿½n a los sistemas",
				"Investigaciï¿½n de operaciones", "Lï¿½gica de sistemas", "Matemï¿½tica Discreta",
				"Metodo de la Investigaciï¿½n", "Mï¿½todos numï¿½ricos", "Microeconomï¿½a", "Precï¿½lculo",
				"Proceso Administrativo", "Programaciï¿½n I", "Programaciï¿½n II", "Programaciï¿½n III",
				"Proyecto de graduaciï¿½n I", "Proyecto de graduaciï¿½n II", "Redes de computadoras I",
				"Redes de computadoras II", "Seguridad y auditoria de Sistemas",
				"Seminarios de tecnologï¿½as de informaciï¿½n", "Sistemas operativos", "Sistemas operativos II",
				"Telecomunicaciones");

		comboCurso.setItems(items);
		comboCurso.setEditable(false);
		comboCurso.setVisibleRowCount(5);
	}

	/**
	 * Pregunta al usuario si está seguro de guardar al alumno en la base de datos.
	 */
	private void guardarAlumno() {
		String mensaje = "¿Está seguro de querer guardar?";
		if (miAlerta.mensajeConfirmar(mensaje, "Guardar")) {

			// TODO: Si presiona sí, pues ejecutar el Insert.

			miAlerta.mensajeExito("Alumno guardado exitósamente.", "Éxito");
		}
	}

	/**
	 * Pregunta al usuario si está seguro de querer cerrar la ventana de registros.
	 */
	private void cerrarRegistro() {
		String mensaje = "¿Está seguro de querer cerrar la pantalla de registro?";
		if (miAlerta.mensajeConfirmar(mensaje, "Salir")) {
			Stage cerrar = (Stage) btnSalir.getScene().getWindow();
			cerrar.close();
		}
	}
}
