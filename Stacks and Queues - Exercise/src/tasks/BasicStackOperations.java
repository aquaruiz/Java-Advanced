package tasks;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BasicStackOperations {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		String[] input = scanner.nextLine().split("\\s+");
		
		int pushN = Integer.parseInt(input[0]);
		Integer popS = Integer.parseInt(input[1]);
		Integer isX = Integer.parseInt(input[2]);

		String[] numbers = scanner.nextLine().split("\\s+");
		
		ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
		
		for (int i = 0; i < pushN; i++) {
			stack.push(Integer.parseInt(numbers[i]));
		}
		
		for (int j = 0; j < popS; j++) {
			stack.pop();
		}
		
		if (stack.contains(isX)) {
			System.out.println(true);
		} else {
			int min;
			
			if (stack.isEmpty()) {
				min = 0;
			} else {
				min = stack.pop();
				
				while (!stack.isEmpty()) {
					int element = stack.pop();
					if (element < min) {
						min = element;
					}
				}	
			}
			
			System.out.println(min);
		}
	}
}
