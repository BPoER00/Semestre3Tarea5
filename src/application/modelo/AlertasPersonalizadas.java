package application.modelo;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class AlertasPersonalizadas {

	/**
	 * HAY MAS TIPOS DE MENSAJE, AQUA SOLO PUSE LAS QUE MAS FRECUENTO
	 */

	/**
	 * Genera un mensaje mostrando algun tipo de informacion necesaria para el
	 * usuario.
	 * 
	 * @param mensaje
	 * @param titulo
	 */
	public void mensajeExito(String mensaje, String titulo) {
		Alert alert = new Alert(AlertType.INFORMATION, mensaje, ButtonType.OK);
		alert.setTitle(titulo);
		alert.setHeaderText(null);
		Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
		stage.getIcons().add(new Image("application/recursos/icono.png")); // Agregamos icono
		stage.showAndWait();
	}

	/**
	 * Genera un mensaje mostrando algun error.
	 * 
	 * @param mensaje
	 * @param titulo
	 */
	public void mensajeError(String mensaje, String titulo) {
		Alert alert = new Alert(AlertType.ERROR, mensaje, ButtonType.OK);
		alert.setTitle("Error al intentar guardar");
		alert.setHeaderText(null);
		Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
		stage.getIcons().add(new Image("application/recursos/icono.png")); // Agregamos �cono
		stage.showAndWait();
	}

	/**
	 * Genera un mensaje de confirmacion antes de llevar a cabo una accion.
	 * 
	 * @param mensaje Realiar en forma de pregunta.
	 * @param title
	 * @return Yes = true, No = false
	 */
	public boolean mensajeConfirmar(String mensaje, String title) {
		Alert alert = new Alert(AlertType.WARNING, mensaje, ButtonType.YES, ButtonType.NO);
		alert.setTitle(title);
		alert.setHeaderText(null);
		Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
		stage.getIcons().add(new Image("application/recursos/icono.png")); // Agregamos icono
		Optional<ButtonType> result = alert.showAndWait();

		return result.get() == ButtonType.YES;
	}

}
