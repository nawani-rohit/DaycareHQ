package data;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collection;
import java.util.HashMap;
import java.util.stream.Collectors;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.scene.chart.PieChart;
import model.FeeModel;

public class FeeData {

	public static ObservableList<FeeModel> feeData;

	public static ObservableList<PieChart.Data> feePieChartData;
	
	public static ObservableMap<String, Integer> feeBarChartData;


	public static void loadData() throws IOException {

		HashMap<String, Integer> feeByDepartment = new HashMap<String, Integer>();

		feeByDepartment.put("Infant", 0);
		feeByDepartment.put("Toddler", 0);
		feeByDepartment.put("Pre-school", 0);
		//feeByDepartment.put("Testing", 0);


		Collection<FeeModel> feeList = Files.readAllLines(new File("feeData.txt").toPath())
				.stream()
				.map(line -> {
					String[] details = line.split(",");
					FeeModel feeModel = new FeeModel();
					feeModel.setId(Integer.parseInt(details[0]));
					feeModel.setName(details[1]);
					feeModel.setFee(details[2]);
					feeModel.setAge(details[3]);
					feeModel.setDepartment(details[4]);
					feeByDepartment.put(details[4], feeByDepartment.getOrDefault(details[4], 0) + Integer.parseInt(details[2]));
					return feeModel;
				}).collect(Collectors.toList());

		feeData = FXCollections.observableArrayList(feeList);

//		feePieChartData = FXCollections.observableArrayList(
//				new PieChart.Data("HR", feeByDepartment.get("Infants")),
//				new PieChart.Data("Back-End", feeByDepartment.get("Toddlers")),
//				new PieChart.Data("Front-End", feeByDepartment.get("Pre-School")),
//				new PieChart.Data("Testing", feeByDepartment.get("Testing"))
//				);

		
		feeBarChartData = FXCollections.observableHashMap();
		feeBarChartData.putAll(feeByDepartment);
	}

}
