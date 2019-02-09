package tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PositionOf {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);


		int[] input = Arrays.stream(scanner.nextLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
		int rows = input[0];
		int cols = input[1];
		
		int[][] matrix = new int[rows][cols];
		
		for (int i = 0; i < matrix.length; i++) {
			matrix[i] = Arrays.stream(scanner.nextLine().split(" "))
					.mapToInt(Integer::parseInt)
					.toArray();		
		}
		
		int num = Integer.parseInt(scanner.nextLine());
		
		ArrayList<String> positions = isThere(matrix, num);
		if (positions.isEmpty()) {
			System.out.println("not found");
		} else {
			for (String string : positions) {
				System.out.println(string);
			}	
		}
	}
	
	static ArrayList isThere(int[][] matrix, int num) {
		ArrayList<String> found = new ArrayList<>();
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == num) {
					found.add(i + " " + j);
				}
			}
		}
		
		return found;
	}
}
