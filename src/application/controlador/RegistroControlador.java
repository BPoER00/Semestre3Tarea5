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

	@FXML
	void clickGuardar(ActionEvent event) {
		System.out.println("test");
	}

	@FXML
	void clickSalir(ActionEvent event) {

	}

	@FXML
	void teclaPresionada(KeyEvent event) {
		System.out.println("Normalmente solo la utilizo para cuando se presiona la tecla Enter");
		// Te dejo el código:
		if (event.getCode().equals(KeyCode.ENTER)) {
			// Hacer referencia al método "Guardar" o lo que quieras
			System.out.println("Has presionado la tecla enter...");
		}
	}

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
		items.addAll("Administración de tecnologías de información", "Algebra lineal", "Algoritmos",
				"Análisis de sistemas I", "Análisis de sistemas II", "Arquitectura de computadoras I",
				"Arquitectura de computadoras II", "Aseguramiento de la calidad del software", "Autómatas y lenguajes",
				"Base de datos I", "Base de datos II", "Cálculo I", "Cálculo II", "Compiladores", "Contabilidad I",
				"Contabilidad II", "Derecho Informático", "Desarrollo Humano", "Desarrollo Web",
				"Electrónica analógica", "Electrónica digital", "Emprendedores de negocios", "Estadística I",
				"Estadística II", "Ética profesional", "Física I", "Física II", "Inteligencia artificial",
				"Inteniería de software", "Introducción a los sistemas", "Investigación de operaciones",
				"Lógica de sistemas", "Matemática Discreta", "Metodo de la Investigación", "Métodos numéricos",
				"Microeconomía", "Precálculo", "Proceso Administrativo", "Programación I", "Programación II",
				"Programación III", "Proyecto de graduación I", "Proyecto de graduación II", "Redes de computadoras I",
				"Redes de computadoras II", "Seguridad y auditoria de Sistemas",
				"Seminarios de tecnologías de información", "Sistemas operativos", "Sistemas operativos II",
				"Telecomunicaciones");

		comboCurso.setItems(items);
		comboCurso.setEditable(false);
		comboCurso.setVisibleRowCount(5);
	}
}
