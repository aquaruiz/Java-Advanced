package SerializeCustomObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeMyObject {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Course myCourse = new Course();
		myCourse.name = "java";
		myCourse.studentsNumber = 133;

		String path = "SerializeCustomObject/course.ser";

		FileOutputStream fs = new FileOutputStream(new File(path));
		ObjectOutputStream outStream = new ObjectOutputStream(fs);

		outStream.writeObject(myCourse);
		outStream.flush();

		FileInputStream infs = new FileInputStream(new File(path));
		ObjectInputStream inputStream = new ObjectInputStream(infs);

		@SuppressWarnings("unchecked")
		Course newMyCourse = (Course) inputStream.readObject();

		System.out.println(newMyCourse);
	}

}
