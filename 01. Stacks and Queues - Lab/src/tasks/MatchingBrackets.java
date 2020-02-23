package tasks;

import java.util.*;
public class MatchingBrackets {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		ArrayDeque<Integer> bracketsIndex = new ArrayDeque<>();
		
		String expression = scanner.nextLine();
		
		for (int i = 0; i < expression.length(); i++) {
			char ch = expression.charAt(i);
			
			if (ch == '(') {
				bracketsIndex.push(i);
			} else if (ch == ')') {
				int startIndex = bracketsIndex.pop();
				String subExpression = expression.substring(startIndex, i + 1);
				System.out.println(subExpression);
			}
		}
	}
}