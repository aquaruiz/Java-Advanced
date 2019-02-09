package tasks;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class FindRealQueen {

	public static void main(String[] args) {
		final int boardSize = 8; 
		
		Scanner scanner = new Scanner(System.in);
		Set<Character> uniqueChars = new HashSet<>();
		
		String[][] matrix = new String[boardSize][boardSize];
		Boolean[][] queens = new Boolean[boardSize][boardSize];
		
		for (int i = 0; i < queens.length; i++) {
			Arrays.fill(queens[i], true);
		}
		
		for (int i = 0; i < matrix.length; i++) {
			String[] input = scanner.nextLine().split(" ");
			
			matrix[i] = input;
		}
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				String wannabe = matrix[i][j];
				// horizontal
				
				if (queens[i][j]) {
					// horizontal
					for (int k = 0; k < matrix[i].length; k++) {
						if (k != j && wannabe.equals(matrix[i][k])) {
							queens[i][j] = false;
							queens[i][k] = false;
						}
					}
					
//					// vertical
					for (int k = 0; k < matrix.length; k++) {
						if (k != i && wannabe.equals(matrix[k][j])) {
							queens[i][j] = false;
							queens[k][j] = false;
						}
					}
					
					
					// left diagonals
					for (int k = 1; i - k >= 0 && j - k >= 0; k++) {
						if (wannabe.equals(matrix[i - k][j - k])) {
								queens[i][j] = false;
								queens[i - k][j - k] = false;
						}
					}
					
					for (int k = 1; i + k < matrix.length && j + k < matrix[i].length; k++) {
						if (wannabe.equals(matrix[i + k][j + k])) {
								queens[i][j] = false;
								queens[i + k][j + k] = false;
						}
					}
					
					// right diagonal
					for (int k = 1; i - k >= 0 && j + k < matrix[i].length; k++) {
						if (wannabe.equals(matrix[i - k][j + k])) {
								queens[i][j] = false;
								queens[i - k][j + k] = false;
						}
					}
					
					for (int k = 1; i + k < matrix.length && j - k >= 0; k++) {
						if (wannabe.equals(matrix[i + k][j - k])) {
								queens[i][j] = false;
								queens[i + k][j - k] = false;
						}
					}
					
				}
			}
		}
		
//		for (Boolean[] ba : queens) {
//			for (Boolean b : ba) {
//				System.out.print(b + " ");
//			}
//			
//			System.out.println();
//		}
		
		for (int i = 0; i < queens.length; i++) {
			for (int j = 0; j < queens[i].length; j++) {
				if (queens[i][j]) {
					System.out.println(i + " " + j);
				}
			}
		}
	}
}