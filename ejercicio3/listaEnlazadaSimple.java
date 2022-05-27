package ejercicio3;

/**
 * Esta clase actua como una lista de nodos, sirve para organizar esos nodos.
 **/
public class listaEnlazadaSimple {
	private Node first;
	private int size;
	
	public listaEnlazadaSimple () {
		this.first = null;
		this.size = 0;
	}
	
	public listaEnlazadaSimple (Node first, int size) {
		this.first = first;
		this.size = 1;
	}

	public Node getFirst() {
		return first;
	}

	public void setFirst(Node first) {
		this.first = first;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	public boolean add(Node node) {
		try {
			if (size == 0) {
				first = node;
			} else {
				Node p = first;
				for (int i = 1; i < size; i++) {
					p = p.getNext();
				}
				p.setNext(node);
			} size++;
			return true;
		} catch (Exception e) {
			System.out.print(e.toString());
			return false;
		}
	}
	
	public boolean add(int position, Node node) {
		if (position == 0) {
			node.setNext(first);
			first = node;
		} else if (position == size) {
			return add(node);
		} else {
			Node p = first;
			for (int i = 0; i < (position-1); i++) {
				p = p.getNext();
			} 
			node.setNext(p.getNext());
			p.setNext(node);
			size++;
			return true;
		}
		return false;
	}
	
	public boolean delete(int position) {
		if (position == 0) {
			first = first.getNext();
			size--;
		} else if (position == size) {
			Node p = first;
			for (int i = 0; i < (position-1); i++) {
				p = p.getNext();
			} 
			p.setNext(null);
			size--;
			return true;
		} else {
			Node p = first;
			for (int i = 0; i < (position-1); i++) {
				p = p.getNext();
			} 
			p.setNext(p.getNext().getNext());
			size--;
			return true;
		}
		return false;
	}
	
	public Node get(int position) {
		try {
			if (position > size || position < 0) {
				return null;
			} else {
				Node p = first;
				for (int i = 0; i < position; i++) {
					p = p.getNext();
				} 
				return p;
			}
		} catch (Exception e) {
			System.out.print(e.toString());
		} return null;
	}
	
	public boolean eliminarMayor() {
		if (size == 1) {
			delete(1);
		} else {
			Node mayor = new Node(0, null);
			Node p = first;
			for (int i = 0; i < size-1; i++) {
				if (p.getContent() > p.getNext().getContent() && p.getContent() > mayor.getContent()) {
					mayor = p;
				} else if (p.getContent() < p.getNext().getContent() && p.getContent() > mayor.getContent()) {
					mayor = p.getNext();
				}
				p = p.getNext();
 			} 
			System.out.println(mayor.getContent());
			return true;
		}
		return false;
	}
	
	public void show() {
		Node p = first;
		for (int i = 0; i < size; i++) {
			System.out.println("[" + i + "] -> " + p.getContent());
			p = p.getNext();
		}
	}
}
