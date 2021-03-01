package application;

import java.io.IOException;

import application.controlador.ConsultarAlumnoControlador;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class Main extends Application {

	// Atributos
	protected Stage primaryStage;
	protected BorderPane rootLayout;

	@Override
	public void start(Stage primaryStage) {

		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Control de datos ddd");

		iniciar();
	}

	/**
	 * Primera escena que se mostrará al iniciar el programa.
	 */
	public void iniciar() {
		try {
			// Cargamos la escenasdf
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("vista/PadreFXML.fxml"));
			rootLayout = (BorderPane) loader.load();

			// Mostramos la escena
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Abre una nueva ventana para registra a un nuevo alumno.
	 */
	public void abrirRegistro() {
		try {
			// Cargamos el archivo
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("vista/RegistroFXML.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Mostramos la esceha
			Stage ventanaRegistrar = new Stage();
			ventanaRegistrar.setTitle("Registrar Alumno");
			ventanaRegistrar.initModality(Modality.APPLICATION_MODAL);
			ventanaRegistrar.initOwner(primaryStage);
			Scene scene = new Scene(page);
			ventanaRegistrar.setScene(scene);

			ventanaRegistrar.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Abre una nueva ventana para consultar a un alumno
	 */
	public void abrirConsultas(String id) {
		try {
			// Cargamos el archivo
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("vista/ConsultarAlumnoFXML.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Accedemos al controlador para inicializar los textfields, según sera el
			// Id:
			// Id vacío = Se está abriendo desde el menú.
			// Id con el ID = Se está abriendo desde el botón Consultar de Reporte.
			ConsultarAlumnoControlador controlador = loader.getController();
			controlador.initialize(id);

			// Mostramos la esceha
			Stage ventanaRegistrar = new Stage();
			ventanaRegistrar.setTitle("Reporte");
			ventanaRegistrar.initModality(Modality.APPLICATION_MODAL);
			ventanaRegistrar.initOwner(primaryStage);
			Scene scene = new Scene(page);
			ventanaRegistrar.setScene(scene);

			ventanaRegistrar.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Abre una nueva ventana para visualizar a todos los alumnos o poder filtrarlos
	 */
	public void abrirReportes() {
		try {
			// Cargamos el archivo
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("vista/ReporteFXML.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Mostramos la esceha
			Stage ventanaRegistrar = new Stage();
			ventanaRegistrar.setTitle("Reporte");
			ventanaRegistrar.initModality(Modality.APPLICATION_MODAL);
			ventanaRegistrar.initOwner(primaryStage);
			Scene scene = new Scene(page);
			ventanaRegistrar.setScene(scene);

			ventanaRegistrar.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
