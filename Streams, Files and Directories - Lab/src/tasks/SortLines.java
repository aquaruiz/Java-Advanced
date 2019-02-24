package tasks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class SortLines {

	public static void main(String[] args) {
		Path inPath = Paths.get("SortLines/input.txt");
		Path outPath = Paths.get("SortLines/output.txt");

		try {
			List<String> lines = Files.readAllLines(inPath);
			Collections.sort(lines);
			Files.write(outPath, lines);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}