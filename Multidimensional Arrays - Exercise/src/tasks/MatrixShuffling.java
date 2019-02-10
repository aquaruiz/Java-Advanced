package tasks;

import java.util.Arrays;
import java.util.Scanner;

import javax.naming.ldap.ExtendedRequest;

public class MatrixShuffling {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] input = scanner.nextLine().split(" ");
		int rows = Integer.parseInt(input[0]);
		int cols = Integer.parseInt(input[1]);
		
		String[][] matrix = new String[rows][cols];
		
		for (int i = 0; i < matrix.length; i++) {
			String[] tokens = scanner.nextLine().split(" ");
			matrix[i] = tokens;
		}
		
		
		String[] cmd = scanner.nextLine().split(" ");
		
		while (!cmd[0].equals("END") ) {
			if (!cmd[0].equals("swap") || cmd.length != 5) {
				System.out.println("Invalid input!");
				cmd = scanner.nextLine().split(" ");
				continue;
			}
			
			int row1 = Integer.parseInt(cmd[1]);
			int col1 = Integer.parseInt(cmd[2]); 
			int row2 = Integer.parseInt(cmd[3]);
			int col2 = Integer.parseInt(cmd[4]);
			
			if (row1 < 0 || row1 >= matrix.length
				|| col1 < 0 || col1 >= matrix[0].length
				|| row2 < 0 || row2 >= matrix.length
				|| col2 < 0 || col2 >= matrix[0].length) {
				
				System.out.println("Invalid input!");
				cmd = scanner.nextLine().split(" ");
				continue;
			}
			
			String oldValue = matrix[row1][col1];
			matrix[row1][col1] = matrix[row2][col2];
			matrix[row2][col2] = oldValue;
			
			for (String[] stringArr : matrix) {
				for (String string : stringArr) {
					System.out.print(string + " ");
				}
				
				System.out.println();
			}

			cmd = scanner.nextLine().split(" ");
		}

	}

}
