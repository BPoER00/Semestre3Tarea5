package application.controlador;

import java.net.URL;
import java.util.ResourceBundle;

import Conexion.Consultas;
import application.modelo.AlertasPersonalizadas;
import application.modelo.ModeloAlumno;
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
			// Hacer referencia al m�todo "Guardar" o lo que quieras
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
		items.addAll("Administraci�n de tecnolog�as de informaci�n", "Algebra lineal", "Algoritmos",
				"An�lisis de sistemas I", "An�lisis de sistemas II", "Arquitectura de computadoras I",
				"Arquitectura de computadoras II", "Aseguramiento de la calidad del software",
				"Aut�matas y lenguajes", "Base de datos I", "Base de datos II", "C�lculo I", "C�lculo II",
				"Compiladores", "Contabilidad I", "Contabilidad II", "Derecho Inform�tico", "Desarrollo Humano",
				"Desarrollo Web", "Electr�nica anal�gica", "Electr�nica digital", "Emprendedores de negocios",
				"Estad�stica I", "Estad�stica II", "�tica profesional", "F�sica I", "F�sica II",
				"Inteligencia artificial", "Intenier�a de software", "Introducci�n a los sistemas",
				"Investigaci�n de operaciones", "L�gica de sistemas", "Matem�tica Discreta",
				"Metodo de la Investigaci�n", "M�todos num�ricos", "Microeconom�a", "Prec�lculo",
				"Proceso Administrativo", "Programaci�n I", "Programaci�n II", "Programaci�n III",
				"Proyecto de graduaci�n I", "Proyecto de graduaci�n II", "Redes de computadoras I",
				"Redes de computadoras II", "Seguridad y auditoria de Sistemas",
				"Seminarios de tecnolog�as de informaci�n", "Sistemas operativos", "Sistemas operativos II",
				"Telecomunicaciones");

		comboCurso.setItems(items);
		comboCurso.setEditable(false);
		comboCurso.setVisibleRowCount(5);
	}

	/**
	 * Pregunta al usuario si est� seguro de guardar al alumno en la base de datos.
	 */
	private void guardarAlumno() {
		String mensaje = "�Est� seguro de querer guardar?";
		if (miAlerta.mensajeConfirmar(mensaje, "Guardar")) {

			Consultas guardarDB = new Consultas();
			
			ModeloAlumno alumno = new ModeloAlumno();
			alumno.setCarnet(textCarnet.getText());
			alumno.setNombre(textNombre.getText());
			alumno.setCurso(comboCurso.getValue());
			
			guardarDB.Guardar(alumno);

			miAlerta.mensajeExito("Alumno guardado exit�samente.", "�xito");
		}
	}

	/**
	 * Pregunta al usuario si est� seguro de querer cerrar la ventana de registros.
	 */
	private void cerrarRegistro() {
		String mensaje = "�Est� seguro de querer cerrar la pantalla de registro?";
		if (miAlerta.mensajeConfirmar(mensaje, "Salir")) {
			Stage cerrar = (Stage) btnSalir.getScene().getWindow();
			cerrar.close();
		}
	}
}
