package zip;

import java.io.IOException;

import zip.engine.FileController;
import zip.engine.LinkedList;

public class AppTest {
	public static LinkedList list = new LinkedList();
	public static void main(String[] args) throws IOException {
//		FileController f1 = new FileController();
		FileController f2 = new FileController();
//		f1.readFile("filename.txt");
		f2.readFile("filename_zipped.txt");
//		f1.zipFile();
		f2.unZipFile();
		
		
//		System.out.println(f1.path);
//		System.out.println(list);
//		System.out.println(list.length());
//		System.out.println();
//		System.out.println(f1.text);
		System.out.println(f2.text);
		
//		System.out.println(f2.list);
//		f1.createFile();
//		f1.saveFile();
//		f2.createFile();
//		f2.saveFile();
	}
	
}
