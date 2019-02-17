package ExcelFunstions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		int n = Integer.parseInt(scanner.nextLine());
		ArrayList<ArrayList<String>> matrix = new ArrayList<>(n);
		
		for (int i = 0; i < n; i++) {
			String[] input = scanner.nextLine().split(", ");
			matrix.add(i, new ArrayList<>());
			for (int j = 0; j < input.length; j++) {
				matrix.get(i).add(j, input[j]);
			}
		}
		
		String[] command = scanner.nextLine().split(" ");
		ArrayList<String> header = matrix.remove(0);
		
		switch (command[0]) {
		case "hide":
			// delete column
			String colName = command[1];
			for (int i = 0; i < matrix.size(); i++) {
				for (int j = 0; j < matrix.get(i).size(); j++) {
					if (header.get(j).equals(colName)) {
						matrix.get(i).remove(j);
						continue;
					}
				}
			}
			
			int indexColName = header.indexOf(colName);
			header.remove(indexColName);
			break;
		case "sort":
			colName = command[1];
			indexColName = header.indexOf(colName);
			matrix.sort((a, b) -> a.get(indexColName).compareTo(b.get(indexColName)));
			break;
		case "filter":
			colName = command[1];
			String colValue = command[2];
			indexColName = header.indexOf(colName);
			ArrayList<ArrayList<String>> output = new ArrayList<>();
			
			for (int i = 0; i < matrix.size(); i++) {
				for (int j = 0; j < matrix.get(i).size(); j++) {
					if (j == indexColName
						&& matrix.get(i).get(j).equals(colValue)) {
						output.add(matrix.get(i));
					}
				}
			}

			matrix = output;
			break;
		}
		
		System.out.println(String.join(" | ", header));
		for (ArrayList<String> stringList : matrix) {
			System.out.println(String.join(" | ", stringList));
		}
	}
}
