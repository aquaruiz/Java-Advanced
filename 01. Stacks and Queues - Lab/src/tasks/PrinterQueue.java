package tasks;
import java.util.*;

public class PrinterQueue {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayDeque<String> queue = new ArrayDeque<>();
		
		String line = scanner.nextLine();
		
		while (!line.equals("print")) {
			if (line.equals("cancel")) {
				if (queue.isEmpty()) {
					System.out.println("Printer is on standby");
				} else {
					String job = queue.pollFirst();
					System.out.println("Canceled " + job);
				}
			} else {
				queue.offer(line);
			}
			line = scanner.nextLine();
		}
		
		while (!queue.isEmpty()) {
			System.out.println(queue.pollFirst());
		}
	}

}