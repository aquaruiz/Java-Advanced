package softUniParking;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Parking {
	Map<String, Car> cars;
	int capacity;
	int booked;
	
	public Parking(int capacity) {
		this.cars = new LinkedHashMap<>();
		this.capacity = capacity;
		booked = 0;
	}
	
	public String addCar(Car car) {
		for (String carName : this.cars.keySet()) {
			if (carName.equals(car.getRegistrationNumber())) {
				return "Car with that registration number, already exists!";
			}
		}
		
		if (booked == capacity) {
			return "Parking is full!";
		}
		
		this.cars.put(car.getRegistrationNumber(), car);
		this.booked++;
		
		return String.format("Successfully added new car %s %s",
				car.getMake(),
				car.getRegistrationNumber());
	}
	
	public String removeCar(String registrationNumber) {
		if (!this.cars.containsKey(registrationNumber)) {
			return "Car with that registration number, doesn't exists!";
		}
		
		Car currentCar = this.getCar(registrationNumber);
		this.cars.remove(currentCar);
		this.booked--;
		
		return String.format("Successfully removed %s", registrationNumber);
	}
	
	public Car getCar(String registrationNumber) {
		return this.cars.get(registrationNumber);
	}
	
	public void removeSetOfRegistrationNumber(List<String> registrationNumbers) {
		for (String registrationNumber : registrationNumbers) {
			this.removeCar(registrationNumber);
		}
	}
	
	public int getCount() {
		return this.booked;
	}
}