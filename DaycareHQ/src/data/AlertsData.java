package data;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collection;
import java.util.stream.Collectors;

import model.ChildModel;
import model.AlertsModel;

public class AlertsData {
	
	public static Collection<AlertsModel> AlertsList;
	
	public static void loadData() throws IOException {
		
		AlertsList = Files.readAllLines(new File("AlertsData.txt").toPath())
				.stream()
				.map(line -> {
					String[] details = line.split(",");
					AlertsModel alertsModel = new AlertsModel();
					alertsModel.setTitle(details[0]);
					alertsModel.setDescription(details[1]);
					return alertsModel;
				}).collect(Collectors.toList());
		
	}
	
	public static void addAlert(String title, String description) throws IOException {
		Files.write(Paths.get("AlertsData.txt"), ("\n" + title + "," + description).getBytes(), StandardOpenOption.APPEND);
		AlertsList.add(new AlertsModel(title, description));
	}

}
