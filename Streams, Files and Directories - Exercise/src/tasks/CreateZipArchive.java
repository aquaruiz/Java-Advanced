package tasks;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CreateZipArchive {
	public static <var> void main(String[] args) throws IOException {
		String path1 = "CreateZipArchive/inputOne.txt";
		String path2 = "CreateZipArchive/inputTwo.txt";
		String path3 = "CreateZipArchive/inputThree.txt";

		String zipFile = "output.zip";

		FileOutputStream fout = new FileOutputStream(zipFile);
		ZipOutputStream zout = new ZipOutputStream(fout);

		zout.putNextEntry(new ZipEntry(path1));
		zout.putNextEntry(new ZipEntry(path2));
		zout.putNextEntry(new ZipEntry(path3));

		zout.closeEntry();
		zout.close();
	}
}
