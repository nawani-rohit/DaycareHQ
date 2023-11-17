package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class DepartmentsController implements Initializable {
	
	@FXML
	private AnchorPane departmentsPane;
	
	@FXML
	private ImageView departmentsHomeButton;
	
	@FXML
	private ImageView logout;
	
	public void logOut() {
    	loadStage("/fxml/Login.fxml");
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	public void handleButtonClicks(ActionEvent mouseEvent) throws IOException {
        if (mouseEvent.getSource() == departmentsHomeButton) {
        	loadStage("/fxml/Home.fxml");
        }
    }
	
	public void redirectHome() {
    	loadStage("/fxml/Home.fxml");
    }
	
	
	
	private void loadStage(String fxml) {
        try {
        	AnchorPane pane = FXMLLoader.load(getClass().getResource(fxml));
        	departmentsPane.getChildren().setAll(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
}
