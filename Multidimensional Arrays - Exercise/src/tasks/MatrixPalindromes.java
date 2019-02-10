package tasks;

import java.util.Scanner;

public class MatrixPalindromes {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] in = scanner.nextLine().split(" ");
		int rows = Integer.parseInt(in[0]);
		int cols = Integer.parseInt(in[1]);

		String[][] matrix = new String[rows][cols];
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				char firstLastLetter = (char)(97 + i);
				char middleLetter = (char)(97 + i + j);
				StringBuilder stringBuilder = new StringBuilder();
				stringBuilder.append(firstLastLetter);
				stringBuilder.append(middleLetter);
				stringBuilder.append(firstLastLetter);
				String input = stringBuilder.toString();
				matrix[i][j] = input;
			}
		}
		
		for (String[] strings : matrix) {
			for (String str : strings) {
				System.out.print(str + " ");
			}
			
			System.out.println();
		}
	}
}