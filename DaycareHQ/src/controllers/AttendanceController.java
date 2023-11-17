package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import data.AttendanceData;
import data.ChildData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import model.AttendanceModel;

public class AttendanceController implements Initializable {
	
	@FXML
	private AnchorPane attendancePane;
	
	@FXML
	private ImageView attendanceHome;
	
	@FXML
	private ImageView logout;
	
	@FXML
    private Label billHours;
	
	@FXML
	private TableView<AttendanceModel> attendanceTable;
	 
	@FXML
    private Label noOfChildren;
	
	@FXML
    private TableColumn<AttendanceModel, String> date;

    @FXML
    private TableColumn<AttendanceModel, String> id;
    
    @FXML
    private TableColumn<AttendanceModel, String> name;

    @FXML
    private TableColumn<AttendanceModel, String> hours;
    
    @FXML
    private TableColumn<AttendanceModel, String> attendanceRecord;
    
	
	public void logOut() {
    	loadStage("/fxml/Login.fxml");
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			loadAttendance();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void redirectHome() {
    	loadStage("/fxml/Home.fxml");
	}
	
	public void handleButtonClicks(ActionEvent mouseEvent) throws IOException {
        if (mouseEvent.getSource() == attendanceHome) {
        	loadStage("/fxml/Home.fxml");
        }
    }
	
	private void loadStage(String fxml) {
        try {
        	AnchorPane pane = FXMLLoader.load(getClass().getResource(fxml));
        	attendancePane.getChildren().setAll(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	private void loadAttendance() throws IOException {
		AttendanceData.loadData();
		id.setCellValueFactory(new PropertyValueFactory<>("id"));
    	name.setCellValueFactory(new PropertyValueFactory<>("Name"));
    	date.setCellValueFactory(new PropertyValueFactory<>("Date"));
    	//hours.setCellValueFactory(new PropertyValueFactory<>("Hours"));
    	attendanceRecord.setCellValueFactory(new PropertyValueFactory<>("AttendanceRecord"));
//    	Integer totalhours = 0;
//    	int i = 0;
//    	for(AttendanceModel dm : AttendanceData.attendanceData) {
//    		totalhours += dm.getHours();
//    		i++;
//    	}
//    	billHours.setText("" + totalhours);
    	attendanceTable.setItems(AttendanceData.attendanceData);
    	ChildData.loadData();
    	//noOfChildren.setText("" + ChildData.childData.size());
	}

}
