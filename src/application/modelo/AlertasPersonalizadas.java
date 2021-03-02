package application.modelo;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;

public class AlertasPersonalizadas {

	/**
	 * HAY MÁS TIPOS DE MENSAJE, AQUÍ SOLO PUSE LAS QUE MÁS FRECUENTO
	 */

	/**
	 * Genera un mensaje mostrando algún tipo de información necesaria para el
	 * usuario.
	 * 
	 * @param mensaje
	 * @param titulo
	 */
	public void mensajeExito(String mensaje, String titulo) {
		Alert alert = new Alert(AlertType.INFORMATION, mensaje, ButtonType.OK);
		alert.setTitle(titulo);
		alert.setHeaderText(null);
		alert.showAndWait();
	}

	/**
	 * Genera un mensaje mostrando algún error.
	 * 
	 * @param mensaje
	 * @param titulo
	 */
	public void mensajeError(String mensaje, String titulo) {
		Alert alert = new Alert(AlertType.ERROR, mensaje, ButtonType.OK);
		alert.setTitle("Error al intentar guardar");
		alert.setHeaderText(null);
		alert.showAndWait();
	}

	/**
	 * Genera un mensaje de confirmación antes de llevar a cabo una acción.
	 * 
	 * @param mensaje Realiar en forma de pregunta.
	 * @param title
	 * @return Yes = true, No = false
	 */
	public boolean mensajeConfirmar(String mensaje, String title) {
		Alert alert = new Alert(AlertType.WARNING, mensaje, ButtonType.YES, ButtonType.NO);
		alert.setTitle(title);
		alert.setHeaderText(null);
		Optional<ButtonType> result = alert.showAndWait();

		return result.get() == ButtonType.YES;
	}

}
