package SerializeCustomObject;

import java.io.Serializable;

public class Course implements Serializable {
	String name;
	int studentsNumber;

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("Name: %s, \nStudents: %d", this.name, this.studentsNumber);
	}
}
