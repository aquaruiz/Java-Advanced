package tasks;

import java.util.ArrayDeque;
import java.util.Scanner;

public class InfixtoPostfix {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		String[] expresion = scanner.nextLine().split(" ");
		ArrayDeque<String> outputQueue = new ArrayDeque<>();
		ArrayDeque<String> operatorsStack = new ArrayDeque<>();
		
		for (int i = 0; i < expresion.length; i++) {
			String ch = expresion[i];
			if (ch.matches("-?\\d+(\\.\\d+)?")) {
				outputQueue.offer(ch);
			} else if(ch.equals("(")) {
				operatorsStack.push(ch);
			} else if (ch.equals(")")) {
				while(!operatorsStack.peek().equals("(")){
					outputQueue.offer(operatorsStack.pop());
				}
				
				// one more to get rid of left bracket "("
				operatorsStack.pop();
			} else {
				if (ch.equals("+") || ch.equals("-")) {
					while (!operatorsStack.isEmpty() && !operatorsStack.peek().equals("(")) {
						outputQueue.offer(operatorsStack.pop());
					}
				} else {
					while (!operatorsStack.isEmpty() && !"+-(".contains(operatorsStack.peek())) {
						outputQueue.offer(operatorsStack.pop());
						
					}
				}
				
				operatorsStack.push(ch);
			}
		}
		
		while (!operatorsStack.isEmpty()) {
			outputQueue.offer(operatorsStack.pop());
		}
		
		System.out.println(String.join(" ", outputQueue));
	}
}