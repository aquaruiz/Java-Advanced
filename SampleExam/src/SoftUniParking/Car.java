package SoftUniParking;

public class Car {
	String make;
	String model;
	int horsePower;
	String registrationNumber;
	
	public Car(String make, String model, int horsePower, String registrationNumber) {
		this.make = make;
		this.model = model;
		this.horsePower = horsePower;
		this.registrationNumber = registrationNumber;
	}
	
	@Override
	public String toString() {
		return String.format("Make: %s%nModel: %s%nHorsePower: %s%nRegistrationNumber: %s",
				this.make,
				this.model,
				this.horsePower,
				this.registrationNumber);
	}
	
	public String getMake() {
		return this.make;
	}
	
	public int getHorsePower() {
		return this.horsePower;
	}
	
	public String getModel() {
		return this.model;
	}
	
	public String getRegistrationNumber() {
		return this.registrationNumber;
	}
}
