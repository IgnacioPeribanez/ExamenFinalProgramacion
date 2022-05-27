package ejercicio3;

public class Main {
	
	/**
	 * Pre: --- 
	 * Post: Este método se encarga de lanzar el programa y gestionar una 
	 *		 ListaEnlazadaSimple
	 */
	public static void main(String[] arg) {
		listaEnlazadaSimple l = new listaEnlazadaSimple();
		Node n1 = new Node(20, null);
		Node n2 = new Node(5, null);
		Node n3 = new Node(30, null);
		l.add(n1);
		l.add(n2);
		l.add(n3);
		l.eliminarMayor();
		l.show();
	}
}
