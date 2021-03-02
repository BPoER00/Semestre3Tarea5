package application.controlador;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class PadreControlador {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;
	
	@FXML
	private Button btnCerrar;
	
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
		Platform.exit();
	}

	@FXML
	void initialize() {

	}
}
