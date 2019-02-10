package tasks;

import java.awt.geom.GeneralPath;
import java.nio.channels.Pipe.SourceChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Crossfire {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] input = scanner.nextLine().split(" ");
		int rows = Integer.parseInt(input[0]);
		int cols = Integer.parseInt(input[1]);
		
		ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
		
		int counter = 1;
		for (int i = 0; i < rows; i++) {
			matrix.add(new ArrayList<Integer>());
			for (int j = 0; j < cols; j++) {
				matrix.get(i).add(counter++);
			}
		}
		
		String line = scanner.nextLine();
		
		while(!line.equals("Nuke it from orbit")) {
			int[] tokens = Arrays.stream(line.split(" "))
					.mapToInt(Integer::parseInt).toArray();
			int targetRow = tokens[0];
			int targetCol = tokens[1];
			int range = tokens[2];
			
			int horizontalStartPoint = Math.max(0, targetCol - range);
			int verticalStartPoint = Math.max(0, targetRow - range);
			int horizontalEndPoint = Math.min(cols, targetCol + range+1);
			int verticalEndPoint = Math.min(rows, targetRow + range+1);

			for (int i = verticalStartPoint; i <= verticalEndPoint; i++) {
				if (i < rows) {
					if (i == targetRow) {
						for (int j = horizontalStartPoint; j <= horizontalEndPoint; j++) {
							if (j <= matrix.get(i).size()) {
								matrix.get(i).remove(horizontalStartPoint);
							}
						}
//						for (int f : matrix.get(i)) {
//							System.out.print(f + " ");
//						}
//						System.out.println();
//						System.out.println(i);
//						System.out.println(horizontalStartPoint);
						matrix.get(i).remove(horizontalStartPoint);
					} else {
						if (targetCol < matrix.get(i).size()) {
							matrix.get(i).remove(targetCol);
						}
					}
				}
			}
			
			line = scanner.nextLine();
		}
		
		for (ArrayList<Integer> arrayLists : matrix) {
			for (Integer in : arrayLists) {
				System.out.print(in + " ");
			}
			
			System.out.println();
		}
	}
}
