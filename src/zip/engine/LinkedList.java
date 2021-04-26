package zip.engine;

public class LinkedList {
	Node ini;
	private int length = 0;

	public LinkedList() {
		ini = null;
	}

	public boolean isEmpty() {
		return ini == null;
	}

	public int length() {
		return this.length;
	}

	public void insertWord(String word) {
		insertWord(ini, word);
		length++;
	}

	public void insertWord(Node temp, String word) {

		if (temp == null) {
			Node novo = new Node(word, ini);
			ini = novo;
			return;
		}

		if (temp.getNext() == null) {
			Node novo = new Node(word, null);
			temp.setNext(novo);
			return;
		}
		insertWord(temp.getNext(), word);
	}

	public boolean findWord(String word) {
		Node temp = ini;

		while (temp != null) {
			if (temp.getWord().equals(word)) {
				return true;
			}
			temp = temp.getNext();
		}
		return false;
	}
	
	public int findIndexByWord(String word) {
		Node temp = ini;
		int count = 1;

		while (temp != null) {
			if (temp.getWord().equals(word)) {
				return count;
			}
			count++;
			temp = temp.getNext();
		}
		return -1;
	}
	
	public String findWordByIndex(int index) {
		Node temp = ini;
		int count = 1;

		while (temp != null) {
			if (count == index) {
				return temp.getWord();
			}
			count++;
			temp = temp.getNext();
		}
		return "";
	}

	@Override
	public String toString() {
		String stringList = "";
		Node temp = ini;

		while (temp != null) {
			stringList += temp.getWord() + " ";
			temp = temp.getNext();
		}
		return stringList;
	}
}
