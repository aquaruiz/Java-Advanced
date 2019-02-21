package Hospital;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import java.util.Collections;;


public class Program {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		Map<String, String[][]> departments = new LinkedHashMap<>();
		Map<String, List<String>> doctors = new LinkedHashMap<>();
		// Cardiology Petar Petrov Ventsi
		
		String line = scanner.nextLine();
		while (!line.equals("Output")){
			List<String> tokens = Arrays.asList(line.split(" "));
			String deparmentName = tokens.get(0);
			String patient = tokens.get(tokens.size() - 1);
			String doctorName = String.join(" ", tokens.subList(1, 3));
			
			if (!departments.containsKey(deparmentName)) {
				departments.put(deparmentName, new String[20][3]);
			}
			
			// add aptient at free bed
			String[][] rooms = departments.get(deparmentName);
			placePatientSleep(rooms, patient);
			
			if (!doctors.containsKey(doctorName)) {
				doctors.put(doctorName, new LinkedList<String>());
			}
			
			doctors.get(doctorName).add(patient);
			
			line = scanner.nextLine();
		}
		
		line = scanner.nextLine();
		
		while (!line.equals("End")) {
			String[] tokens = line.split(" ");
			
			if (tokens.length == 2) {
				try {
					int roomNum = Integer.parseInt(tokens[1]);
					String departmentName = tokens[0];
					String[] patientsInRoom = departments.get(departmentName)[roomNum - 1];
					Arrays.sort(patientsInRoom);
					Arrays.stream(patientsInRoom).forEach(System.out::println);
					
					
				} catch (Exception e) {
					String doctorName = String.join(" ", tokens);
					List<String> patientsbyDoctor = doctors.get(doctorName);
					Collections.sort(patientsbyDoctor);
					patientsbyDoctor.stream().forEach(System.out::println);;
					
				}
			} else if (tokens.length == 1) {
				String departmentName = tokens[0];
				Arrays.stream(departments.get(departmentName))
					.forEach(arr -> Arrays.stream(arr)
							.filter(x -> x != null)
							.forEach(System.out::println));
			}
			
			line = scanner.nextLine();
			
			
		}
		
		System.out.println();
	}

	private static void placePatientSleep(String[][] rooms, String patient) {
		for (int i = 0; i < rooms.length; i++) {
			for (int j = 0; j < rooms[i].length; j++) {
				if (rooms[i][j]== null) {
					rooms[i][j] = patient;
					return;
				}
			}
		}
	}
}
