package task2;

import java.util.Scanner;

public class Program {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int rows = Integer.parseInt(scanner.nextLine());

		char[][] matrix = new char[rows][];

		for (int i = 0; i < rows; i++) {
			matrix[i] = scanner.nextLine().toCharArray();
		}

		int firstPlayerRow = 0;
		int firstPlayerCol = 0;
		int secondPlayerRow = 0;
		int secondPlayerCol = 0;

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 'f') {
					firstPlayerRow = i;
					firstPlayerCol = j;
				}

				if (matrix[i][j] == 's') {
					secondPlayerRow = i;
					secondPlayerCol = j;
				}
			}
		}

		while (true) {
			String[] input = scanner.nextLine().split(" ");
			String firstPlayerMove = input[0];
			String secondPlayerMove = input[1];

			// move first player
			switch (firstPlayerMove) {
			case "up":
				firstPlayerRow--;
				if (firstPlayerRow < 0) {
					firstPlayerRow = matrix.length - 1;
				}
				break;
			case "down":
				firstPlayerRow++;
				if (firstPlayerRow > matrix.length - 1) {
					firstPlayerRow = 0;
				}
				break;
			case "left":
				firstPlayerCol--;
				if (firstPlayerCol < 0) {
					firstPlayerCol = matrix[0].length - 1;
				}
				break;
			case "right":
				firstPlayerCol++;
				if (firstPlayerCol > matrix[0].length - 1) {
					firstPlayerCol = 0;
				}
				break;
			default:
				break;
			}

			if (matrix[firstPlayerRow][firstPlayerCol] == 's') {
				matrix[firstPlayerRow][firstPlayerCol] = 'x';
				break;
			}

			matrix[firstPlayerRow][firstPlayerCol] = 'f';

			// move second player
			switch (secondPlayerMove) {
			case "up":
				secondPlayerRow--;
				if (secondPlayerRow < 0) {
					secondPlayerRow = matrix.length - 1;
				}
				break;
			case "down":
				secondPlayerRow++;
				if (secondPlayerRow > matrix.length - 1) {
					secondPlayerRow = 0;
				}
				break;
			case "left":
				secondPlayerCol--;
				if (secondPlayerCol < 0) {
					secondPlayerCol = matrix[0].length - 1;
				}
				break;
			case "right":
				secondPlayerCol++;
				if (secondPlayerCol > matrix[0].length - 1) {
					secondPlayerCol = 0;
				}
				break;
			default:
				break;
			}

			if (matrix[secondPlayerRow][secondPlayerCol] == 'f') {
				matrix[secondPlayerRow][secondPlayerCol] = 'x';
				break;
			}

			matrix[secondPlayerRow][secondPlayerCol] = 's';
		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j]);
			}

			System.out.println();
		}
	}
}
