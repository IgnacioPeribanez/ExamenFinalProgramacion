package ejercicio3;

/**
 * Esta clase actua como un nodo, con un atributo int y otro Node, se utiliza para almacenar un int
 * y se usa en una ListaEnlazadaSimple
 */
public class Node {
	private int content;
	private Node next;
	
	public Node (int content, Node next) {
		this.content = content;
		this.next = next;
	}

	public int getContent() {
		return content;
	}

	public void setContent(int content) {
		this.content = content;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "Node [content=" + content + ", next=" + next + "]";
	}
	
}
