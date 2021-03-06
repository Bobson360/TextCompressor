package zip.engine;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;

public class FileController {
	public File file;
	public static FileReader fr;
	public static BufferedReader br;
	public static String word = "";
	public LinkedList list = new LinkedList();
	public String text = "";
	public String path;
	public String fileName;
	public String zipFileName;


	public void zipFile() throws IOException {
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
						text += word;
						word = "";
					}
				}
				if (st.matches("([^a-zA-Z])")) {
					text += st;
				}
			}

		}
		text += "\n0";
		
		
		createFile("zipped");
		saveFile();
	}
	
	public void unZipFile() throws IOException {
		int c = 0;
		while ((c = br.read()) != -1) {
			char character = (char) c;
			String st = Character.toString(character);
			if (st.matches("([a-zA-Z0-9\n\s,-.']+)")) {
				if (st.matches("[a-zA-Z0-9]+"))
					word += st;
			
				if (st.matches("([\n\s,-.']+)")) {
					if (word.length() > 0 ) {
						if(word.matches("([a-zA-Z]+)")) {
							word = addWordAtList(word.replace("-", "").replace(",", "").replace(".", "").replace(" ", "").trim());
							text += word;
							
						} else if(word.matches("([0-9]+)")) {
							word = list.findWordByIndex(Integer.parseInt(word));
							text += word;
							
						}
						word = "";
					}
				}
				if (st.matches("([^a-zA-Z0-9])")) {
					text += st;
				}
			}
		}
		createFile("unzipped");
		saveFile();
	}
	


	public String addWordAtList(String word) {
		if (!word.isEmpty())
			if (!list.findWord(word)) {
				list.insertWord(word);
				return word;
			}
		return Integer.toString(list.findIndexByWord(word));
	}
	
	public void readFile(String file) throws IOException {
		this.file = new File(file);
		this.fileName = file.replace(".txt", "");
		this.path = Paths.get(this.file.getAbsolutePath().toString()).getParent().toString();
		fr = new FileReader(file);
		br = new BufferedReader(fr);
	}
	
	public void createFile(String suffix) {
		this.zipFileName = this.fileName + "_"+ suffix + ".txt";
		try {
		      File myObj = new File(this.zipFileName);
		      if (myObj.createNewFile()) {
		        System.out.println("File created: " + myObj.getName());
		      } else {
		        System.out.println("File already exists.");
		      }
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	
	public void saveFile() {
		try {
		      FileWriter myWriter = new FileWriter(this.zipFileName);
		      myWriter.write(this.text);
		      myWriter.close();
		      System.out.println("Successfully wrote to the file.");
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
}
