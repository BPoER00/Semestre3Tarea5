package application.controlador;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class PadreControlador {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	Main miMain = new Main();

	@FXML
	void clickConsultarAlumno(ActionEvent event) {
		miMain.abrirConsultas("");
	}

	@FXML
	void clickHechoPor(ActionEvent event) {

	}

	@FXML
	void clickRegistrar(ActionEvent event) {
		miMain.abrirRegistro();
	}

	@FXML
	void clickReporte(ActionEvent event) {
		miMain.abrirReportes();
	}

	@FXML
	void clickSalir(ActionEvent event) {
		System.out.println("Test");
	}

	@FXML
	void initialize() {

	}
}
