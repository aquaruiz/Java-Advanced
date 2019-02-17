package tasks;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class TheMatrix {
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
		Scanner scanner = new Scanner(System.in);
		String[] tokens = scanner.nextLine().split(" ");
		int rows = Integer.parseInt(tokens[0]);
		int cols = Integer.parseInt(tokens[1]);
		char[][] matrix = new char[rows][cols];
		
		for (int i = 0; i < rows; i++) {
			String[] input = scanner.nextLine().split(" ");
			for (int j = 0; j < input.length; j++) {
				matrix[i][j] = input[j].charAt(0);
			}
		}
		
		char fillWith = scanner.nextLine().charAt(0);
		tokens = scanner.nextLine().split(" ");
		int chRow = Integer.parseInt(tokens[0]);
		int chCol = Integer.parseInt(tokens[1]);
		char ch = matrix[chRow][chCol];
		
		ArrayDeque<String> coordinates = new ArrayDeque<>();
		coordinates.offer(chRow + " " + chCol);
		
		while (!coordinates.isEmpty()){
			char[][] newarr = copyMatrix(matrix);
			
			tokens = coordinates.removeFirst().split(" ");
			chRow = Integer.parseInt(tokens[0]);
			chCol = Integer.parseInt(tokens[1]);
			newarr[chRow][chCol] = fillWith;
			
			try {
				if (matrix[chRow][chCol + 1] == ch) {
					newarr[chRow][chCol + 1] = fillWith;
					coordinates.offer(chRow + " " + (chCol+1));
				}
			} catch (Exception e) {}
			try {
				if (matrix[chRow][chCol - 1] == ch) {
					newarr[chRow][chCol - 1] = fillWith;
					coordinates.offer(chRow + " " + (chCol-1));
				}
			} catch (Exception e) {}
			try {
				if (matrix[chRow + 1][chCol] == ch) {
					newarr[chRow + 1][chCol] = fillWith;
					coordinates.offer((chRow+1) + " " + chCol);
				}
			} catch (Exception e) {}
			try {
				if (matrix[chRow - 1][chCol] == ch) {
					newarr[chRow - 1][chCol] = fillWith;
					coordinates.offer((chRow-1) + " " + chCol);
				}
			} catch (Exception e) {}
			matrix = copyMatrix(newarr);
		}
		
		for (char[] strCh : matrix) {
			for (char chf : strCh) {
				System.out.print(chf);
			}
			
			System.out.println();
		}
	}
}