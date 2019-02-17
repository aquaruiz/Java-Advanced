package tasks;

import java.util.Arrays;
import java.util.Scanner;

public class ParkingSystem {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] rowCol = scanner.nextLine().split(" ");
		int rows = Integer.parseInt(rowCol[0]);
		int cols = Integer.parseInt(rowCol[1]);
		boolean[][] parking = new boolean[rows][cols];

		for (int i = 0; i < rows; i++) {
			parking[i][0] = true;
		}
		
		String line = scanner.nextLine();
		
		while(!line.equals("stop")) {
			int[] input = Arrays.stream(line.split(" "))
					.mapToInt(Integer::parseInt)
					.toArray();
			int entryRow = input[0];
			int desiredRow = input[1];
			int desiredCol = input[2];

			int traveledDistance = 0;
			
			if (parking[desiredRow][desiredCol]) {
				int leftIndex = Math.max(1, desiredCol - 1);
				int rightIndex = Math.min(parking[desiredRow].length - 1, desiredCol + 1);
				
				boolean found = false;
				
				if (!parking[desiredRow][leftIndex]) {
					desiredCol = leftIndex;
				} else {
					while(parking[desiredRow][leftIndex]) {
						if (!parking[desiredRow][leftIndex]) {
							found = true; 
							break;
						}
						
						if (leftIndex < 1) {
							break;
						}
						
						leftIndex--;
					}
					
					if (!parking[desiredRow][rightIndex]) {
						desiredCol = rightIndex;
					} else {
						while(parking[desiredRow][rightIndex]) {
							if (!parking[desiredRow][rightIndex]) {
								found = true; 
								break;
							}
							
							if (rightIndex >= parking[desiredRow].length - 1) {
								break;
							}
							
							rightIndex++;
						}
						
						if (found) {
							desiredCol = Math.abs(desiredCol - leftIndex) < Math.abs(desiredCol - rightIndex) ?
									leftIndex :
									rightIndex;
						} 
					}
				}
			}
			
			if (!parking[desiredRow][desiredCol]) {
				parking[desiredRow][desiredCol] = true;
				traveledDistance = Math.abs(desiredRow - entryRow) + 1 + Math.abs(desiredCol - 0);
				System.out.println(traveledDistance);
			} else {
				System.out.printf("Row %d full", desiredRow);
			}

			line = scanner.nextLine();
		}
	}
}