package tasks;

import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] input = scanner.nextLine().split(" ");
		int rows = Integer.parseInt(input[0]);
		int cols = Integer.parseInt(input[1]);
		
		final int maxSumSize = 3;
		
		int[][] matrix = new int[rows][cols];
		
		for (int i = 0; i < matrix.length; i++) {
			int[] tokens = Arrays.stream(scanner.nextLine().split(" "))
					.mapToInt(Integer::parseInt)
					.toArray();
			matrix[i] = tokens;
		}
		
		int maxSum = Integer.MIN_VALUE;
		int maxStartIndexX = 0;
		int maxStartIndexY = 0;
		
		for (int i = 0; i < matrix.length - 2; i++) {
			for (int j = 0; j < matrix[i].length - 2; j++) {
				int sum = 0;
				for (int k = 0; k < maxSumSize; k++) {
					for (int l = 0; l < maxSumSize; l++) {
						sum += matrix[i + k][j + l];
					}
				}
				
				if (maxSum < sum) {
					maxSum = sum;
					maxStartIndexX = i;
					maxStartIndexY = j;
				}
			}
		}
		
		System.out.println("Sum = " + maxSum);
		
		for (int i = maxStartIndexX; i < maxStartIndexX + maxSumSize; i++) {
			for (int j = maxStartIndexY; j < maxStartIndexY + maxSumSize; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			
			System.out.println();
		}
	}
}
