package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import data.AlertsData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class NewAlertsController implements Initializable {
	
	@FXML
    private AnchorPane newWorkshopPane;
	
	@FXML
	private Button add;

	@FXML
	private Button cancel;

	@FXML
	private TextField description;

	@FXML
	private TextField title;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	public void handleButtonClicks(ActionEvent mouseEvent) throws IOException {
		
		if (mouseEvent.getSource() == add) {
			AlertsData.addAlert(title.getText(), description.getText());
			
			Stage stage = (Stage) cancel.getScene().getWindow();
            stage.close();
			
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("New Workshop");
			alert.setContentText("Workshop added successfully");
			alert.showAndWait();
		}

		if (mouseEvent.getSource() == cancel) {
			
			Stage stage = (Stage) cancel.getScene().getWindow();
            stage.close();
			
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("New Workshop");
			alert.setContentText("Workshop not added");
			alert.showAndWait();
		}
	}

}
