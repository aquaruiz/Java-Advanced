package tasks;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SerializeArrayList {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		ArrayList<String> arr = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			arr.add("Input No" + (i + 1));
		}

		String path = "SerializeArrayList/list.ser";

		FileOutputStream fs = new FileOutputStream(new File(path));
		ObjectOutputStream outStream = new ObjectOutputStream(fs);

		outStream.writeObject(arr);
		outStream.flush();

		FileInputStream infs = new FileInputStream(new File(path));
		ObjectInputStream inputStream = new ObjectInputStream(infs);

		@SuppressWarnings("unchecked")
		ArrayList<String> newArr = (ArrayList<String>) inputStream.readObject();

		for (String string : newArr) {
			System.out.println(string);

		}

	}

}
