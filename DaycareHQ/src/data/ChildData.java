package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.ChildModel;

public class ChildData {

	private static int idGenerator;

	public static ObservableList<ChildModel> childData;

	public static void loadData() throws IOException {

		BufferedReader br = null;
		String sCurrentLine;
		String lastLine = "";

		br = new BufferedReader(new FileReader("ChildData.txt"));

		while ((sCurrentLine = br.readLine()) != null) {
			//System.out.println(sCurrentLine);
			lastLine = sCurrentLine;
		}
		String[] lastLineArr = lastLine.split(",");
		idGenerator = Integer.parseInt(lastLineArr[0]) + 1;
		if (br != null)br.close();


		Collection<ChildModel> childList = Files.readAllLines(new File("ChildData.txt").toPath())
				.stream()
				.map(line -> {
					String[] details = line.split(",");
					ChildModel child = new ChildModel();
					child.setId(Integer.parseInt(details[0]));
					child.setName(details[1]);
					child.setParentName(details[2]);
					child.setDepartment(details[3]);
					child.setReportsTo(details[4]);
					return child;
				}).collect(Collectors.toList());

		childData = FXCollections.observableArrayList(childList);

	}

	public static void addChild(String name, String parentName, String department, String manager, Integer fee, Float age) throws IOException {
		Files.write(Paths.get("ChildData.txt"), ("\n" + idGenerator + "," + name + "," + parentName + "," + department  + "," + manager).getBytes(), StandardOpenOption.APPEND);
		Files.write(Paths.get("FeeData.txt"), ("\n" + idGenerator + "," + name + "," + fee + "," + age  + "," + department).getBytes(), StandardOpenOption.APPEND);
		childData.add(new ChildModel(idGenerator, name, parentName, department, manager));
		idGenerator++;
	}

}
