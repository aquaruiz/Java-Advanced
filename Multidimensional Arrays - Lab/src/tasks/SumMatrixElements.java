package tasks;

import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] input = scanner.nextLine().split(", ");
		
		int rows = Integer.parseInt(input[0]);
		int cols = Integer.parseInt(input[1]);
		
		int[][] matrix = new int[rows][cols];
		int rowsCount = rows;
		int colsCount = cols;
		
		int sum = 0;
		for (int i = 0; i < rows; i++) {
			matrix[i] = Arrays.stream(scanner.nextLine().split(", "))
					.mapToInt(Integer::parseInt)
					.toArray();
			
//			sum += Arrays.stream(matrix[i]).sum();
			sum += Arrays.stream(matrix[i]).reduce(0, Integer::sum);
		}
		
		System.out.printf("%d%n%d%n%d", rowsCount, colsCount, sum);
	}
}
