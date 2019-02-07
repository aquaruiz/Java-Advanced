package tasks;

import java.util.ArrayDeque;
import java.util.Scanner;


public class MaximumElement {

	public static void main(String[] args) {
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		int commands = Integer.parseInt(scanner.nextLine());
		
		for (int i = 0; i < commands; i++) {
			String[] input = scanner.nextLine().split(" ");
			
			switch (input[0]) {
			case "1":
				int element = Integer.parseInt(input[1]);
				stack.push(element);
				break;
			case "2": 
				if (!stack.isEmpty()) {
					stack.pop();
				}
				break;
			case "3":
				ArrayDeque<Integer> newStack = new ArrayDeque<>(stack);
				int max;
				if (newStack.isEmpty()) {
					max = Integer.MIN_VALUE;
				} else {
					max = newStack.pop();
					while (!newStack.isEmpty()) {
						element = newStack.pop();
						if (element > max) {
							max = element;
						}
					}
				}
				
				System.out.println(max);
				break;
			}
		}
	}
}