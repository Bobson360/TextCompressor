package zip;

import java.io.IOException;

import zip.engine.FileController;

public class AppTest {
	public static void main(String[] args) throws IOException {
		FileController f1 = new FileController();
		f1.readFile("filename.txt");
		f1.zipFile();
		System.out.println();
		System.out.println(f1.text);
		
		FileController f2 = new FileController();
		f2.readFile("filename_zipped.txt");
		f2.unZipFile();
		System.out.println();
		System.out.println(f2.text);
	}

}
