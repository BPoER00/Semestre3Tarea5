package application.controlador;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import Conexion.Consultas;
import application.Main;
import application.modelo.ModeloAlumno;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ReporteControlador {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TableView<ModeloAlumno> tableAlumnos;

	@FXML
	private TableColumn columnId;

	@FXML
	private TableColumn columnCarnet;

	@FXML
	private TableColumn columnNombre;

	@FXML
	private TableColumn columnCurso;

	@FXML
	private TextField textBuscar;

	@FXML
	private Button btnConsultar;

	private Main miMain = new Main();

	@FXML
	void clickConsultar(ActionEvent event) {
		// TODO: Cerrar esta ventana y abrir la ventana de consultas con los datos ya
		// dentro de los
		// campos.

		// Buscar la forma de obtener el valor del Id de la fila seleccionada por el
		// usuario:
		miMain.abrirConsultas("Obtener Id de la fila seleccionada");

		// Cerramos la ventana
		Stage cerrar = (Stage) btnConsultar.getScene().getWindow();
		cerrar.close();
	}

	@FXML
	void initialize() {

		/**
		 * NOTA:
		 * No se si funcionara de manera separada.
		 * En caso de que no se haya problemas, intentar escribir en un solo m�todo los dos m�todos
		 * o pegarlo todo aqui.
		 * Aunque creo que si funciono, porque me agarro el ejemplo
		 */
		List<ModeloAlumno> modelo = new ArrayList<ModeloAlumno>();
		// modelo = baseDeDatos.consultar(); --- Consultar toda la base de datos para obtener datos.
		// Prueba
		Consultas obtenerDatos = new Consultas();
		modelo = obtenerDatos.consultarTabla();
		modelo.add(new ModeloAlumno("1", "1190", "Fabi�n", "Sistemas"));
		agregarDatosATabla(modelo);
		agregarFiltros(modelo);
	}

	/**
	 * Agrega datos a la tabla.
	 */
	private void agregarDatosATabla(List<ModeloAlumno> modelo) {
		
		// Insertamos la informaci�n
		ObservableList<ModeloAlumno> data = FXCollections.observableArrayList(modelo);

		// Adaptamos las celdas para que sean compatibles al tipo de dato que recibir�n
		// Nota: El nombre al final debe ser igual a los atributos del modelo
		columnId.setCellValueFactory(new PropertyValueFactory<ModeloAlumno, String>("Id"));
		columnCarnet.setCellValueFactory(new PropertyValueFactory<ModeloAlumno, String>("Carnet"));
		columnNombre.setCellValueFactory(new PropertyValueFactory<ModeloAlumno, String>("Nombre"));
		columnCurso.setCellValueFactory(new PropertyValueFactory<ModeloAlumno, String>("Curso"));
	}

	/**
	 * Le agrega filtros al campo textField para que el usuario pueda buscar y
	 * filtre autom�ticamente la tabla
	 */
	private void agregarFiltros(List<ModeloAlumno> modelo) {
		// Insertamos la informaci�n
		ObservableList<ModeloAlumno> data = FXCollections.observableArrayList(modelo);

		// 1. Agregamos un filtro para la barra de b�squeda
		FilteredList<ModeloAlumno> filtrarDatos = new FilteredList<>(data, b -> true);

		// 2. Creamos un listener que escuchar� los cambios en la barra y tratar� de
		// hallar coincidencias.
		textBuscar.textProperty().addListener((observable, oldValue, newValue) -> {
			filtrarDatos.setPredicate(dato -> {
				// Si est� vac�o, que muestre toda la informaci�n en la tabla
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}

				String lowerCaseFilter = newValue.toLowerCase();

				if (dato.getId().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Coincidencia con el Id
				} else if (dato.getCarnet().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Coincidencia con la organizaci�n
				} else if (dato.getNombre().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Coincidencia con el nombre
				} else if (dato.getCurso().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Coincidencia con la curso
				} else
					return false; // Ninguna coincidencia.
			});
		});

		// 3. Agregamos los datos en un sortedData para ordenarlos
		// Esto no tiene nada que ver con las dem�s consultas
		SortedList<ModeloAlumno> datoOrdenado = new SortedList<>(filtrarDatos);

		// 4. Vinculamos el sorted con los datos
		datoOrdenado.comparatorProperty().bind(tableAlumnos.comparatorProperty());

		// 5. Agregamos los datos ordenados para filtrar a la tabla.
		tableAlumnos.setItems(datoOrdenado);
	}
}
