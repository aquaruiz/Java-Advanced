package carInfo;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		List<Car> cars = new LinkedList<>();
		
		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine());
		
		for (int i = 0; i < n; i++) {
			String[] inputs = scanner.nextLine().split(" ");
			Car car = new Car();
			car.setMake(inputs[0]);
			car.setModel(inputs[1]);
			car.setHorsePower(Integer.parseInt(inputs[2]));
			
			cars.add(car);
		}
		
		scanner.close();
		
		for (Car car : cars) {
			System.out.println(car.getInfo());
		}
	}

}