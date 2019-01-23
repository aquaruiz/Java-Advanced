import java.util.*;

public class BrowserHistiry {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		ArrayDeque<String> browser = new ArrayDeque<>();
		String line = scanner.nextLine();
		while (!line.equals("Home")) {
			if (line.equals("back")) {
				if (browser.isEmpty() || browser.size() == 1) {
					System.out.println("no previous URLs");
				} else {
					browser.pop();
					System.out.println(browser.peek());

					// show back
				}
			} else {
				browser.push(line);
				System.out.println(line);
			}
			
			line = scanner.nextLine();
		}
	}
}
