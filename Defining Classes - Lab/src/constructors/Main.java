package constructors;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		List<Car> cars = new LinkedList<>();
		
		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine());
		
		for (int i = 0; i < n; i++) {
			Car car;
			String[] inputs = scanner.nextLine().split(" ");
			if (inputs.length == 1) {
				car = new Car(inputs[0]);
			} else {
				car = new Car(inputs[0], inputs[1], Integer.parseInt(inputs[2]));
			}
			
			cars.add(car);
		}
		
		scanner.close();
		
		for (Car car : cars) {
			System.out.println(car.getInfo());
		}
	}
}