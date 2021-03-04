package application.controlador;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.control.Alert.AlertType;
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
		String mensaje = "Universidad Mariano Gálvez, Zacapa\n"
				+ "Ingeniería en Sistemas\n"
				+ "Curso:\t\t Programación III\n"
				+ "Ciclo:\t\t V\n"
				+ "Catedrático:\t Ing. Vinicio Román\n"
				+ "Grupo:\n"
				+ "Alumno:\t\t Bryan Emanuel Paz Ramírez\nCarnet:\t\t 1190-19-3929\n"
				+ "Alumno:\t\t Luis Renato Granados Ogáldez\nCarnet:\t\t 1190-19-4642\n"
				+ "Fecha:\t\t 06/03/2021";
		
		Alert alert = new Alert(AlertType.INFORMATION, mensaje, ButtonType.OK);
		alert.setTitle("Hecho por");
		alert.setHeaderText(null);
		Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
		stage.getIcons().add(new Image("application/recursos/icono.png")); // To add an icon
		stage.showAndWait();
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
