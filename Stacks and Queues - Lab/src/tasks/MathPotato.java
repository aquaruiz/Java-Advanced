package tasks;
import java.util.ArrayDeque;
import java.util.Scanner;

public class MathPotato {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		ArrayDeque<String> queue = new ArrayDeque<>();
				
		String[] players = scanner.nextLine().split("\\s+");
		int number = Integer.valueOf(scanner.nextLine());
		
		for(String child : players) {
			queue.offer(child);
		}
		
		int circle = 0;
		
		while (queue.size() > 1) {
			circle++;
			for (int i = 1; i < number; i++) {
				queue.offer(queue.poll());
			}
			
			if (isPrime(circle) && circle != 1) {
				System.out.println("Prime " + queue.peek());
			} else {
				System.out.println("Removed " + queue.poll());
			}
		}
		
		System.out.println("Last is " + queue.poll());
	}

	private static boolean isPrime(int number) {
		for (int i = 2; i < number; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		
		return true;
	}
}