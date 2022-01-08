package dadTest3;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;

public class Controller implements Initializable {

	// model
	
	private StringProperty seleccionado = new SimpleStringProperty();
	private ListProperty<String> nombres = new SimpleListProperty<String>(FXCollections.observableArrayList());
	
	// view
	
	@FXML
    private Button anadirButton;

    @FXML
    private ListView<String> nombresList;

    @FXML
    private Button quitarButton;

    @FXML
    private BorderPane view;

    @FXML
    void onAnadirAction(ActionEvent event) {

    	nombres.add("Jackie Chan");
    	
    }

    @FXML
    void onQuitarAction(ActionEvent event) {

    	nombres.remove(seleccionado.get());
    	
    }
    
    public Controller() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Test1.fxml"));
		loader.setController(this);
		loader.load();
	}
	
	public void initialize(URL location, ResourceBundle resources) {
		
		// bindings
		
		nombresList.itemsProperty().bind(nombres); // cuando manipulemos el listProperty los cambios
		// se verán en el listview
		
		seleccionado.bind(nombresList.getSelectionModel().selectedItemProperty());

	}
	
	public BorderPane getView() {
		return view;
	}

}
