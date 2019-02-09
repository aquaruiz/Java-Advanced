package tasks;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumSubmatrix {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] input = scanner.nextLine().split(", ");
		
		int rows = Integer.parseInt(input[0]);
		int cols = Integer.parseInt(input[1]);
		
		int[][] matrix = new int[rows][cols];

		for (int i = 0; i < rows; i++) {
			matrix[i] = Arrays.stream(scanner.nextLine().split(", "))
					.mapToInt(Integer::parseInt)
					.toArray();
		}
		
		int maxSum = 0;
		int startRow = 0;
		int startCol = 0;
		
		for (int i = 0; i < matrix.length - 1; i++) {
			for (int j = 0; j < matrix[i].length - 1; j++) {
				int[][] subMatrix = {{matrix[i][j], matrix[i][j+1]},
									{matrix[i+1][j], matrix[i+1][j+1]}};
				
				int current = sumSubMatrix(subMatrix);
				
				if (current > maxSum) {
					maxSum = current;
					startRow = i;
					startCol = j;
				}
			}
		}
		
		System.out.printf("%d %d%n%d %d%n", 
				matrix[startRow][startCol],
				matrix[startRow][startCol+1],
				matrix[startRow+1][startCol],
				matrix[startRow+1][startCol+1]);
		
		System.out.println(maxSum);
	}

	static int sumSubMatrix (int[][] submatrix) {
		int sum = 0;
		for (int i = 0; i < submatrix.length; i++) {
			for (int j = 0; j < submatrix[i].length; j++) {
				sum += submatrix[i][j];
			}
		}
		
		return sum;
	}
}
