package tasks;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BalancedParentheses {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		String parentheses = scanner.nextLine();
		
		Deque<Character> openingBrackets= new ArrayDeque<>();
		Boolean isBalanced = true;
		
		for (int i = 0; i < parentheses.length(); i++) {
			char current = parentheses.charAt(i);
			
			if (current == '(' ||
				current == '{' ||
				current == '[') {
				
				openingBrackets.push(current);
			} else {
				if (openingBrackets.isEmpty()) {
					isBalanced = false;
					break;
				}
				
				char opening = openingBrackets.pop();
				
				if (current == '}' && opening == '{') {
					continue;
				} else if (current == ']' && opening == '[') {
					continue;
				} else if (current == ')' && opening == '(') {
					continue;
				} else {
					isBalanced = false;
					break;
				}
			}
		}
		
		if (isBalanced) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
}
