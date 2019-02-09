package tasks;

import java.util.Scanner;

public class Intersection2Matrices {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
				
		int rows = Integer.parseInt(scanner.nextLine());
		int cols = Integer.parseInt(scanner.nextLine());
		
		char[][] matrixOne = new char[rows][cols];
		char[][] matrixTwo = new char[rows][cols];
		
		for (int i = 0; i < rows; i++) {
			String[] input = scanner.nextLine().split(" ");
			for (int j = 0; j < cols; j++) {
				matrixOne[i][j] = input[j].charAt(0);
			}
//			char[] input = String.join("", scanner.nextLine().split("//s+")).toCharArray();
//			matrixOne[i] = input;
		}
		
		for (int i = 0; i < rows; i++) {
			String[] input = scanner.nextLine().split(" ");
			for (int j = 0; j < cols; j++) {
				matrixTwo[i][j] = input[j].charAt(0);
			}
//			char[] input = String.join("", scanner.nextLine().split(" ")).toCharArray();
//			matrixTwo[i] = input;
		}
		
		for (int i = 0; i < matrixTwo.length; i++) {
			for (int j = 0; j < matrixTwo[i].length; j++) {
				if (matrixOne[i][j] == matrixTwo[i][j]) {
					System.out.print(matrixOne[i][j] + " ");
				} else {
					System.out.print("* ");
				}
			}
			
			System.out.println(" ");
		}
	}
}