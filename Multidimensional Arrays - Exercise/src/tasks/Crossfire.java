package tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Crossfire {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String[] input = scanner.nextLine().split(" ");
		int rows = Integer.parseInt(input[0]);
		int cols = Integer.parseInt(input[1]);
		
		ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
		
		int counter = 1;
		for (int i = 0; i < rows; i++) {
			matrix.add(new ArrayList<Integer>());
			for (int j = 0; j < cols; j++) {
				matrix.get(i).add(counter++);
			}
		}
		
		String line = scanner.nextLine();

		while (!line.equals("Nuke it from orbit")) {
			int[] tokens = Arrays.stream(line.split(" "))
					.mapToInt(Integer::parseInt)
					.toArray();
			int bombRow = tokens[0];
			int bombCol = tokens[1];
			int bombRange = tokens[2];
			
			int detonationStartCol = Math.max(bombCol - bombRange, 0);
			int detonationStartRow = Math.max(bombRow - bombRange, 0);
			int detonationEndCol = Math.min(bombCol + bombRange, cols - 1);
			int detonationEndRow = Math.min(bombRow + bombRange, rows - 1);
			
			for (int i = detonationStartRow; i <= detonationEndRow; i++) {
				for (int j = detonationStartCol; j <= detonationEndCol; j++) {
					if (j == bombCol) {
						try {
							matrix.get(i).set(j, -1);
						} catch (Exception e) {
							// TODO: handle exception
						}
					} else if (i == bombRow) {
						try { 
							matrix.get(i).set(j, -1);
						} catch (Exception e) {
							// TODO: handle exception
						}
					}
				}
			}
			
			for (int i = 0; i < matrix.size(); i++) {
				for (int j = 0; j < matrix.get(i).size(); j++) {
					if (matrix.get(i).get(j) == -1) {
						matrix.get(i).remove(j);
						j--;
					}
				}
			}
			
			for (int i = 0; i < matrix.size(); i++) {
				if (matrix.get(i).size() == 0) {
					matrix.remove(i);
				}
			}

			line = scanner.nextLine();
		}
		

		for (int i = 0; i < matrix.size(); i++) {
			for (int j = 0; j < matrix.get(i).size(); j++) {
				if (matrix.get(i).get(j) != -1) {
					System.out.print(matrix.get(i).get(j) + " ");
				}
			}
			
			System.out.println();
		}
	}
}