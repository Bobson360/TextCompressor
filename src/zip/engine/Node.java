package zip.engine;

public class Node {
	String element;
	Node next;
	
	public Node(String element, Node next) {
		this.element = element;
		this.next = next;
	}
	
	public String getWord() {
		return element;
	}
	
	public Node getNext() {
		return next;
	}
	
	public void setElement(String element) {
		this.element = element; 
	}
	
	public void setNext(Node next) {
		this.next = next;
	}
	
	public String toString() {
		return "No { " + " element = " + element + ", next = " + next + " }";
	}
}
