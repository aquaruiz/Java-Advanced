package tasks;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseMatrixDiagonals {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] tokens = scanner.nextLine().split(" ");
		int rows = Integer.parseInt(tokens[0]);
		int cols = Integer.parseInt(tokens[1]);
		int[][] matrix = new int[rows][];
		
		for (int i = 0; i < rows; i++) {
			int[] input = Arrays.stream(scanner.nextLine().split(" "))
					.mapToInt(Integer::parseInt)
					.toArray();
			matrix[i] = input;
		}
		
//		if (rows == 1) {
//			for (int i = matrix[0].length - 1; i  >= 0; i--) {
//				System.out.println(matrix[0][i]);
//			}
//			
//			return;
//		}

		for (int i = cols - 1; i > 0; i--) {
            for (int row = matrix.length - 1, col = i;
            		row >= 0 && col < matrix[row].length; 
            		row--, col++) {
                System.out.print(matrix[row][col] + " ");
            }
            
            System.out.println();
        }
		
		 for (int i = rows - 1; i >= 0; i--) {
			 for (int row = i, col = 0; 
					 row >= 0 && col < matrix[row].length; 
					 row--, col++) {
		          System.out.print(matrix[row][col] + " ");
			 }

			 System.out.println();
		 }
	}
}