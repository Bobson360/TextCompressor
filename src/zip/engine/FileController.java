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
	public static String text = "";
	
	public static void main(String[] args) throws IOException {
		readFile();
		zipFile();
		System.out.println(list);
		System.out.println(list.length());
		System.out.println();
		System.out.println(text);
		
	}
	
	public static void zipFile() throws IOException {
		int c = 0;
		while ((c = br.read()) != -1) {
			char character = (char) c;
			String st = Character.toString(character);
			if(st.matches("([a-zA-Z\n\s,-.']+)")) {
				if(st.matches("[a-zA-Z]+"))
					word += st;
				if(st.matches("([\n\s,-.']+)")) {
					word = addWordAtList(word.replace("-", "").replace(",", "").replace(".", "").replace(" ", "").trim());
						text += word;
//						System.out.println("New Word: " + word);
						word = "";
//						System.out.println(word);
////						System.out.println(text);
				}
				if(st.matches("([^a-zA-Z])")){
					text += st;
				}
			}
			
//			System.out.println(st);
		}
	}
	
	public static void readFile() throws FileNotFoundException {
		file = new File("filename.txt");
		fr = new FileReader(file);
		br = new BufferedReader(fr);
	}
	
	public static String addWordAtList(String word) {
		if(!word.isBlank())
			System.out.println("Words to add: " + word);
			if(!list.findWord(word)) {
				list.insertWord(word);
				return word;
			}
			return Integer.toString(list.findIndexByWord(word));
	}
}
