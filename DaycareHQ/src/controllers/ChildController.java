package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import data.ChildData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.ChildModel;

public class ChildController implements Initializable {
	
	@FXML
	private AnchorPane childrenPane;
	
	@FXML
    private ImageView home;
	
	@FXML
    private TableView<ChildModel> childrenTable;
	
	@FXML
    public TableColumn<ChildModel, String> childId;
	
	@FXML
    public TableColumn<ChildModel, String> childName;

    @FXML
    public TableColumn<ChildModel, String> parentName;
    
    @FXML
    public TableColumn<ChildModel, String> department;
    
    @FXML
    public TableColumn<ChildModel, String> reportsTo;
    
    @FXML
    public Button addNewChild;
    
    @FXML
	private ImageView logout;
	
	public void logOut() {
    	loadStage("/fxml/Login.fxml");
    }
    
    public void handleButtonClicks(ActionEvent mouseEvent) throws IOException {
        if (mouseEvent.getSource() == home) {
        	loadStage("/fxml/Home.fxml");
        }
        
        else if (mouseEvent.getSource() == addNewChild) {
        	loadNewStage("/fxml/NewChild.fxml");
        }
        
    }
    
    public void redirectHome() {
    	loadStage("/fxml/Home.fxml");
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	
    	try {
			loadChildren();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    private void loadChildren() throws IOException
    {
    	childId.setCellValueFactory(new PropertyValueFactory<>("id"));
    	childName.setCellValueFactory(new PropertyValueFactory<>("Name"));
    	parentName.setCellValueFactory(new PropertyValueFactory<>("ParentName"));
    	department.setCellValueFactory(new PropertyValueFactory<>("Department"));
    	reportsTo.setCellValueFactory(new PropertyValueFactory<>("ReportsTo"));
    	ChildData.loadData();
    	childrenTable.setItems(ChildData.childData);
    }

    private void loadStage(String fxml) {
        try {
        	AnchorPane pane = FXMLLoader.load(getClass().getResource(fxml));
        	childrenPane.getChildren().setAll(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void loadNewStage(String fxml) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(fxml));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}