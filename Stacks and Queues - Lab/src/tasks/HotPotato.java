package tasks;

import java.util.*;

public class HotPotato {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		ArrayDeque<String> queue = new ArrayDeque<>();
		
		String[] players = scanner.nextLine().split("\\s+");
		int number = Integer.valueOf(scanner.nextLine());
		
		for(String child : players) {
			queue.offer(child);
		}
		
		while (queue.size() > 1) {
			for (int i = 0; i < number - 1; i++) {
				queue.offer(queue.poll());
			}

			System.out.println("Removed " + queue.poll());
		}
		
		System.out.println("Last is " + queue.poll());
	}
}