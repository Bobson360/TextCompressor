package zip.engine;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileController {
	public static File file;
	public static FileReader fr;
	public static BufferedReader br;
	public static String word = "";
	public static LinkedList list = new LinkedList();
	public static void main(String[] args) throws IOException {
		readFile();
		zipFile();
	}
	
	public static void zipFile() throws IOException {
		int c = 0;
		while ((c = br.read()) != -1) {
			char character = (char) c;
			String st = Character.toString(character);
			if(st.matches("([a-zA-Z\n\s,-.']+)")) {
				if(st.matches("([\n\s,-.']+)")) {
						System.out.println("new word");
				}
				word += st;
				System.out.println(st);
			}
			
//			System.out.println(st);
		}
	}
	
	public static void readFile() throws FileNotFoundException {
		file = new File("filename.txt");
		fr = new FileReader(file);
		br = new BufferedReader(fr);
	}
	
	public void addWordAtList() {
		
	}
}
