package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import data.ChildData;
import data.FeeData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.ChildModel;
import model.FeeModel;

public class FeeController implements Initializable {
	

	
	@FXML
	private AnchorPane feePane;
	
	@FXML
	private ImageView feeHomeButton;
	
	@FXML
    private TableView<FeeModel> feeTable;
	
	@FXML
    public TableColumn<FeeModel, String> feeId;
	
	@FXML
    public TableColumn<FeeModel, String> childName;

    @FXML
    public TableColumn<FeeModel, String> fee;
    
    @FXML
    public TableColumn<FeeModel, String> age;
    
    @FXML
    public TableColumn<FeeModel, String> department;
    
    @FXML
    public Button addNewChild;
    
    @FXML
    private PieChart salaryPieChart;
    
    @FXML
	private ImageView logout;
    
    @FXML
    private BarChart<String, Number> feeBarChart;
	
	public void logOut() {
    	loadStage("/fxml/Login.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	
    	try {
			loadChildrenFee();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    private void loadChildrenFee() throws IOException
    {
    	feeId.setCellValueFactory(new PropertyValueFactory<>("id"));
    	childName.setCellValueFactory(new PropertyValueFactory<>("Name"));
    	fee.setCellValueFactory(new PropertyValueFactory<>("fee"));
    	age.setCellValueFactory(new PropertyValueFactory<>("age"));
    	department.setCellValueFactory(new PropertyValueFactory<>("Department"));
    	FeeData.loadData();
    	feeTable.setItems(FeeData.feeData);
    	//salaryPieChart.setData(FeeData.feePieChartData);
    	for (String department : FeeData.feeBarChartData.keySet()) {
    	    XYChart.Series<String, Number> series = new XYChart.Series<>();
    	    series.setName(department);
    	    series.getData().add(new XYChart.Data<>(department, FeeData.feeBarChartData.get(department)));
    	    feeBarChart.getData().add(series);
    	}
    }
    
    private void loadStage(String fxml) {
        try {
        	AnchorPane pane = FXMLLoader.load(getClass().getResource(fxml));
        	feePane.getChildren().setAll(pane);
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
	
    public void redirectHome() {
        	loadStage("/fxml/Home.fxml");
        
    }

}
