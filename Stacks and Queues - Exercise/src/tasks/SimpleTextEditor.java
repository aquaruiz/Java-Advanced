package tasks;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		String text = "";
		int operationsN = Integer.parseInt(scanner.nextLine());
		ArrayDeque<String> statuses = new ArrayDeque<>();
		statuses.push(text);
		
		for (int i = 0; i < operationsN; i++) {			
			String[] operation = scanner.nextLine().split(" ");
			
			int operator = Integer.parseInt(operation[0]);
			
			switch (operator) {
			case 1:
				String str = operation[1];
				text += str;
				statuses.push(text);
				break;
			case 2:
				int lenght = Integer.parseInt(operation[1]);
				text = text.substring(0, text.length() - lenght);
				statuses.push(text);
				break;
			case 3:
				int index = Integer.parseInt(operation[1]);
				if(index - 1 >= 0) {
					System.out.println(text.charAt(index - 1));
				}
				break;
			case 4:
				statuses.pollFirst();
				String currentText = statuses.peek();
				text = currentText;
				break;
			}
		}
	}
}