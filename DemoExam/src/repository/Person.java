package repository;

public class Person {
	String name;
	int age;
	String birthDate;
	
	public Person(String name, int age, String birthDate) {
		this.name = name;
		this.age = age;
		this.birthDate = birthDate;
	}
	
	public String toString() {
		return String.format("Name: %s%n" + 
				"Age: %s%n" + 
				"Birthday: %s", 
				this.name,
				this.age,
				this.birthDate);
	}
}