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
			if (st.matches("([a-zA-Z\n\s,-.']+)")) {
				if (st.matches("[a-zA-Z]+"))
					word += st;
				if (st.matches("([\n\s,-.']+)")) {
					if (word.length() > 0) {
						word = addWordAtList(
								word.replace("-", "").replace(",", "").replace(".", "").replace(" ", "").trim());
						System.out.println("Words to add: " + word);
						text += word;
						word = "";
					}
				}
				if (st.matches("([^a-zA-Z])")) {
					text += st;
				}
			}

		}
	}

	public static void readFile() throws FileNotFoundException {
		file = new File("filename.txt");
		fr = new FileReader(file);
		br = new BufferedReader(fr);
	}

	public static String addWordAtList(String word) {
		if (!word.isEmpty())
			if (!list.findWord(word)) {
				list.insertWord(word);
				return word;
			}
		return Integer.toString(list.findIndexByWord(word));
	}
	
	public void saveFile() {
		
	}
}
