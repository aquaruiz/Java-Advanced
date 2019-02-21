package Sneaking;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int rows = Integer.parseInt(scanner.nextLine());
		char[][] matrix = new char[rows][];
		
		for (int i = 0; i < rows; i++) {
			 char[] input = scanner.nextLine().toCharArray();
			 matrix[i] = input;
		}
		
		char[] commands = scanner.nextLine().toCharArray();
		
		// find Sam
		// find Nikoladze
		boolean isSamDead = false;
		int samRow = 0;
		int samCol = 0;

		boolean isNikoladzeDead = false;
		int nikoladzeRow = 0;
		int nikoladzeCol = 0;
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 'S') {
					samRow = i;
					samCol = j;
				}
				
				if (matrix[i][j] == 'N') {
					nikoladzeRow = i;
					nikoladzeCol = j;
				}
			}
		}
		
		for (int i = 0; i < commands.length; i++) {
			// move every enemy
			for (int j = 0; j < matrix.length; j++) {
				for (int k = 0; k < matrix[j].length; k++) {
					if (matrix[j][k] == 'd') {
						matrix[j][k] = '.';

						if (k - 1 >= 0) {
							if (samRow == j 
									&& samCol < k - 1) {
								isSamDead = true;
								matrix[samRow][samCol] = 'X';
							}
							
							matrix[j][k - 1] = 'd';
						} else if (k == 0) {
							if (samRow == j 
									&& samCol > k) {
								isSamDead = true;
								matrix[samRow][samCol] = 'X';
							}

							matrix[j][k] = 'b';
						}
					} else if (matrix[j][k] == 'b') {
						matrix[j][k] = '.';
						
						if (k + 1 < matrix[j].length) {
							if (samRow == j 
									&& samCol > k  + 1) {
								isSamDead = true;
								matrix[samRow][samCol] = 'X';
							}

							matrix[j][k + 1] = 'b';
							break;
						} else if (k == matrix[j].length - 1) {
							matrix[j][k] = 'd';

							if (samRow == j 
									&& samCol < k) {
								isSamDead = true;
								matrix[samRow][samCol] = 'X';
							}
						}
						
					}
				}
			}
			
			// move Sam
			char currentMove = commands[i];
			
			if (!isSamDead) {
				switch (currentMove) {
				case 'U':
					matrix[samRow][samCol] = '.';
					samRow = samRow - 1;
					if (samRow == nikoladzeRow ) {
						isNikoladzeDead = true;
						matrix[nikoladzeRow][nikoladzeCol] = 'X';
					}

					matrix[samRow][samCol] = 'S';
					break;
				case 'D':
					matrix[samRow][samCol] = '.';
					samRow = samRow + 1;
					if (samRow == nikoladzeRow) {
						isNikoladzeDead = true;
						matrix[nikoladzeRow][nikoladzeCol] = 'X';
					}

					matrix[samRow][samCol] = 'S';
					break;
				case 'L':
					matrix[samRow][samCol] = '.';
					samCol = samCol - 1;
					if (samRow == nikoladzeRow) {
						isNikoladzeDead = true;
						matrix[nikoladzeRow][nikoladzeCol] = 'X';
					}

					matrix[samRow][samCol] = 'S';
					break;
				case 'R':
					matrix[samRow][samCol] = '.';
					samCol = samCol + 1;
					if (samRow == nikoladzeRow 
							&& samCol == nikoladzeCol) {
						isNikoladzeDead = true;
						matrix[nikoladzeRow][nikoladzeCol] = 'X';
					}

					matrix[samRow][samCol] = 'S';
					break;
				case 'W':
					
					break;
				}
			} 
			
			if(isSamDead){
				System.out.printf("Sam died at %d, %d%n", samRow, samCol);
			}
			
			if (isNikoladzeDead) {
				System.out.println("Nikoladze killed!");
			}

			if (isNikoladzeDead || isSamDead) {
				print(matrix);
				return;
			}
//			System.out.println(i);
//			print(matrix);
		}
	}

	private static void print(char[][] matrix) {
		for (char[] cs : matrix) {
			for (char c : cs) {
				System.out.print(c);
			}
			
			System.out.println();
		}
	}
}
