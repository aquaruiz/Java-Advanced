package tasks;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BasicQueueOperations {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		String[] input = scanner.nextLine().split(" ");
		ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
		
		int elementsAdd = Integer.parseInt(input[0]);
		int elementsRemove = Integer.parseInt(input[1]);
		int isThere = Integer.parseInt(input[2]);		
		
		String[] tokens = scanner.nextLine().split(" ");
		
		for (int i = 0; i < elementsAdd; i++) {
			queue.offer(Integer.parseInt(tokens[i]));
		}
		
		for (int j = 0; j < elementsRemove; j++) {
			queue.removeFirst();
		}
		
		int min = Integer.MAX_VALUE;

		if (queue.isEmpty()) {
			min = 0;
		}
		
		while (!queue.isEmpty()) {
			int element = queue.removeFirst();
			if (element < min) {
				min = element;
			}
			
			if (element == isThere) {
				System.out.println(true);
				return;
			}
		}
		
		System.out.println(min);
	}
}