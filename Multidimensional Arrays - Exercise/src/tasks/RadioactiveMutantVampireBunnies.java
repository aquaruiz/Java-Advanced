package tasks;

import java.util.Arrays;
import java.util.Scanner;

public class RadioactiveMutantVampireBunnies {
	public static void print(char[][] matrix) {
		for (char[] is : matrix) {
			for (char i : is) {
				System.out.print(i);
			}
			
			System.out.println();
		}
	}
	
	public static char[][] copyMatrix(char[][] matrix) {
		char[][] copy = new char[matrix.length][matrix[0].length];
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				copy[i][j] = matrix[i][j];
			}
		}
		
		return copy;
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int[] tokens = Arrays.stream(scanner.nextLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
		int rows = tokens[0];
		int cols = tokens[1];
		
		char[][] matrix = new char[rows][];
		
		for (int i = 0; i < rows; i++) {
			matrix[i] = scanner.nextLine().toCharArray();
		}
		
		String playerStatus = "n/a";
		char[] commands = scanner.nextLine().toCharArray();
		char[][] matrix2 = copyMatrix(matrix);
		
		if (commands.length == 0) {
			return;
		}
		
		for (int i = 0; i < commands.length; i++) {
			//find player
			int playerRow = -1;
			int playerCol = -1;
			
			for (int j = 0; j < matrix.length; j++) {
				for (int k = 0; k < matrix[j].length; k++) {
					
					if (matrix[j][k] == 'P') {
						matrix2[j][k] = '.';
						playerRow = j;
						playerCol = k;
						break;
					}
				}
			}
			
			// move player
			switch (commands[i]) {
			case 'L':
				try {
					if (matrix[playerRow][playerCol - 1] == 'B') {
						playerCol--;
						playerStatus = "dead";
					} else {
						matrix2[playerRow][playerCol - 1] = 'P';
					}
				} catch (Exception e) {
					playerStatus = "won";
				}
				break;
			case 'R':
				try {
					if (matrix[playerRow][playerCol + 1] == 'B') {
						playerCol++;
						playerStatus = "dead";
					} else {
						matrix2[playerRow][playerCol + 1] = 'P';
					}
				} catch (Exception e) {
					playerStatus = "won";
				}
				break;
			case 'U':
				try {
					if (matrix[playerRow - 1][playerCol] == 'B') {
						playerRow--;
						playerStatus = "dead";
					} else {
						matrix2[playerRow - 1][playerCol] = 'P';
					}
				} catch (Exception e) {
					playerStatus = "won";
				}
				break;
			case 'D':
				try {
					if (matrix[playerRow + 1][playerCol] == 'B') {
						playerRow++;
						playerStatus = "dead";
					} else {
						matrix2[playerRow + 1][playerCol] = 'P';
					}
				} catch (Exception e) {
					playerStatus = "won";
				}
				break;
			}
			
			matrix = copyMatrix(matrix2); // ??
			
			// multiply bunnies
			for (int j = 0; j < matrix.length; j++) {
				for (int k = 0; k < matrix[j].length; k++) {
					if (matrix[j][k] == 'B') {
						try {
							matrix2[j][k + 1] = 'B';
							if (matrix[j][k + 1] == 'P') {
								playerRow = j;
								playerCol = k + 1;
								playerStatus = "dead";
							}
						} catch (Exception e) {
						}
						try {
							matrix2[j][k - 1] = 'B';
							if (matrix[j][k-1] == 'P') {
								playerRow = j;
								playerCol = k -1;
								playerStatus = "dead";
//								break;
							}
						} catch (Exception e) {
						}
						try {
							matrix2[j + 1][k] = 'B';
							if (matrix[j+1][k] == 'P') {
								playerRow = j + 1;
								playerCol = k;
								playerStatus = "dead";
//								break;
							}
						} catch (Exception e) {
						}
						try {
							matrix2[j - 1][k] = 'B';
							if (matrix[j-1][k] == 'P') {
								playerRow = j - 1;
								playerCol = k;
								playerStatus = "dead";
//								break;
							}
						} catch (Exception e) {
						}
					}
				}
			}
			matrix = copyMatrix(matrix2);
			
			if (playerStatus.equals("won")) {
				print(matrix);
				System.out.println("won: " + playerRow + " " + playerCol);
				return;
			} else if (playerStatus.equals("dead")){
				print(matrix);
				System.out.println("dead: " + playerRow + " " + playerCol);
				return;
			}
		}
	}
}