package application.controlador;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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
	}

	private void insertarDatosAlComboBox() {
		ObservableList<String> items = FXCollections.observableArrayList();

		// Aquí voy a poner todos los cursos de Sistemas Bryan
		items.addAll("item 1", "item 2", "item 3");

		comboCurso.setItems(items);
		comboCurso.setEditable(false);
		comboCurso.setVisibleRowCount(5);
	}
}
