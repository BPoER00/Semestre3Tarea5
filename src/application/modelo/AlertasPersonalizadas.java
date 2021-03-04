package application.modelo;

import java.util.Optional;

import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
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
	 * @bparam mensaje Realiar en forma de pregunta.
	 * @param title
	 * @return Yes = true, No = false
	 */
	public boolean mensajeConfirmar(String mensaje, String title) {
		Alert alert = new Alert(AlertType.WARNING, mensaje, ButtonType.YES, ButtonType.NO);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.getButtonTypes().clear();
		alert.getButtonTypes().addAll(ButtonType.YES, ButtonType.NO);

		// Con este trozo de código logramos que el enter sepa que botón se está presionando
		EventHandler<KeyEvent> fireOnEnter = event -> {
		    if (KeyCode.ENTER.equals(event.getCode()) 
		            && event.getTarget() instanceof Button) {
		        ((Button) event.getTarget()).fire();
		    }
		};
		
		DialogPane dialogPane = alert.getDialogPane();
		dialogPane.getButtonTypes().stream()
		        .map(dialogPane::lookupButton)
		        .forEach(button ->
		                button.addEventHandler(
		                        KeyEvent.KEY_PRESSED,
		                        fireOnEnter
		                )
		        );
		
		Optional<ButtonType> result = alert.showAndWait();
		
		if(result.get() == ButtonType.YES)
			return true;
		
		return false;
	}

}
