package SerializeCustomObject;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializeCustomObject {

	public static void main(String[] args) {
		Cube cube = new Cube();
		cube.color = "green";
		cube.width = 15.3d;
		cube.height = 12.4d;
		cube.depth = 3d;

		String path = "SerializeCustomObject/save.txt";

		try {
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path));
			objectOutputStream.writeObject(cube);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
