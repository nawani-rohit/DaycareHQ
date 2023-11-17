package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class Controller implements Initializable{
	
	@FXML
	private AnchorPane rootPane;

    @FXML
    private Button Announcements;

    @FXML
    private Button Departments;

    @FXML
    private Button Children;
    
    @FXML
    private Button Attendance;

    @FXML
    private Button AdminDashboard;

    @FXML
    private Button DcAlerts;
    
    @FXML
    private PieChart pieChart;
    
    @FXML
    private ImageView logout;
	

    public void handleButtonClicks(ActionEvent mouseEvent) throws IOException {
        if (mouseEvent.getSource() == Attendance) {
            //Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
        	loadStage("/fxml/Attendance.fxml");
        } 
        else if (mouseEvent.getSource() == Children) {
            loadStage("/fxml/Children.fxml");
        } else if (mouseEvent.getSource() == DcAlerts) {
        	System.out.println("In Alert");
            loadStage("/fxml/Alerts.fxml");
        }
        else if (mouseEvent.getSource() == AdminDashboard) {
            loadStage("/fxml/AdminDashboard.fxml");
        }
        else if (mouseEvent.getSource() == Departments) {
            loadStage("/fxml/Departments.fxml");
        }
        else if (mouseEvent.getSource() == Announcements) {
            loadStage("/fxml/Annoucements.fxml");
        }
    }
    
    public void logOut() {
    	loadStage("/fxml/Login.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//    	ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
//    			new PieChart.Data("D.VA",13),
//    			new PieChart.Data("Mercy",22),
//    			new PieChart.Data("Tracer",15),
//    			new PieChart.Data("Widowmaker",10));
//    	
//    	pieChart.setData(pieChartData);
    }
    
    
    private void loadStage(String fxml) {
        try {
        	AnchorPane pane = FXMLLoader.load(getClass().getResource(fxml));
        	rootPane.getChildren().setAll(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

}

