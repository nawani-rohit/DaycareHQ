package data;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collection;
import java.util.stream.Collectors;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.AttendanceModel;
import model.ChildModel;

public class AttendanceData {
	
	public static ObservableList<AttendanceModel> attendanceData;
	
	public static void loadData() throws IOException {

		Collection<AttendanceModel> attendanceList = Files.readAllLines(new File("AttendanceData.txt").toPath())
				.stream()
				.map(line -> {
					String[] details = line.split(",");
					AttendanceModel attendanceModel = new AttendanceModel();
					attendanceModel.setId(Integer.parseInt(details[0]));
					attendanceModel.setName(details[1]);
					attendanceModel.setDate(details[2]);
					//attendanceModel.setHours(Integer.parseInt(details[3]));
					attendanceModel.setAttendanceRecord(details[3]);

					return attendanceModel;
				}).collect(Collectors.toList());

		attendanceData = FXCollections.observableArrayList(attendanceList);

	}
	
	public static void addAttendanceData(Integer id, String name, String date, Integer hours, String attendanceRecord) throws IOException {
		Files.write(Paths.get("AttendanceData.txt"), ("\n" + id + "," + name + "," + date + "," + attendanceRecord).getBytes(), StandardOpenOption.APPEND);
		attendanceData.add(new AttendanceModel(id, name, date, hours, attendanceRecord));
	}
}
