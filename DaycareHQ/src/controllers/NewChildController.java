package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import data.ChildData;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class NewChildController implements Initializable {
	
	@FXML
	private AnchorPane newChildPane;
	
	@FXML
	private Button add;
	
	@FXML
	private Button cancel;
	
	@FXML
	private TextField name;
	
	@FXML
	private TextField parentName;
	
//	@FXML
//	private TextField department;
	
	@FXML
	private TextField careGiver;
	
	@FXML
	private TextField fee;
	
	@FXML
	private TextField age;
	
	@FXML
	private ComboBox<String> department;
	
	public void handleButtonClicks(ActionEvent mouseEvent) throws IOException {
        if (mouseEvent.getSource() == add) {
        	ChildData.addChild(name.getText(), parentName.getText(), department.getValue(), careGiver.getText(), Integer.parseInt(fee.getText()), Float.parseFloat(age.getText()));
        	Stage stage = (Stage) cancel.getScene().getWindow();
            stage.close();
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("New Child");
            alert.setContentText("Child added successfully");
            alert.showAndWait();
        }
        else if (mouseEvent.getSource() == cancel) {
        	Stage stage = (Stage) cancel.getScene().getWindow();
            stage.close();
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("New Child");
            alert.setContentText("Child not added");
            alert.showAndWait();
        }
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		try {
			loadComboBox();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void loadComboBox() throws IOException
    {
		department.getItems().add("Infants");
		department.getItems().add("Toddlers");
		department.getItems().add("Pre-School");
		//department.getItems().add("Testing");
		department.setPromptText("Select Department");
    }
	
	private void loadStage(String fxml) {
        try {
        	AnchorPane pane = FXMLLoader.load(getClass().getResource(fxml));
        	newChildPane.getChildren().setAll(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	
	

}
