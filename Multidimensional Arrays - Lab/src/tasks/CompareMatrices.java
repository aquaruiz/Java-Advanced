package tasks;

import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		int[] input1 = Arrays.stream(scanner.nextLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
		int cols1 = input1[0];
		int rows1 = input1[1];
		
		int[][] matrixOne = new int[cols1][rows1];

		for (int i = 0; i < matrixOne.length; i++) {
			matrixOne[i] = Arrays.stream(scanner.nextLine().split(" "))
					.mapToInt(Integer::parseInt)
					.toArray();		
		}
		
		int[] input2 = Arrays.stream(scanner.nextLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
		int cols2 = input2[0];
		int rows2 = input2[1];
		
		int[][] matrixTwo = new int[cols2][rows2];
		
		for (int i = 0; i < matrixOne.length; i++) {
			matrixTwo[i] = Arrays.stream(scanner.nextLine().split(" "))
					.mapToInt(Integer::parseInt)
					.toArray();		
		}
		
		System.out.println(areMatricesEqual(matrixOne, matrixTwo) ? "equal" : "not equal");
	}
	
	static boolean areMatricesEqual(int[][] matrixOne, int[][] matrixTwo) {
		if (matrixOne.length != matrixTwo.length) {
			return false;
		}
		
		for (int i = 0; i < matrixTwo.length; i++) {
			if (matrixOne[i].length != matrixTwo[i].length) {
				return false;
			}
			
			for (int j = 0; j < matrixTwo[i].length; j++) {
				if (matrixOne[i][j] != matrixTwo[i][j]) {
					return false;
				}
			}
		}
		
		return true;
	}
}