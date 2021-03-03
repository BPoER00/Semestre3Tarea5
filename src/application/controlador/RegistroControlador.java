package application.controlador;

import java.net.URL;
import java.util.ResourceBundle;

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

	/* =========== Comandos para los botones =========== */
	@FXML
	void clickGuardar(ActionEvent event) {
		System.out.println("Guardando");
	}

	@FXML
	void clickSalir(ActionEvent event) {
		System.out.println("Saliendo");
	}

	@FXML
	void enterBtnGuardar(KeyEvent event) {
		System.out.println("Guardando");
	}

	@FXML
	void enterBtnSalir(KeyEvent event) {
		System.out.println("Saliendo");
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
}
