package ejercicio3;

public class Main {
	public static void main(String[] arg) {
		listaEnlazadaSimple l = new listaEnlazadaSimple();
		Node n1 = new Node(20, null);
		Node n2 = new Node(5, null);
		Node n3 = new Node(10, null);
		l.add(n1);
		l.add(n2);
		l.add(n3);
		l.eliminarMayor();
		l.show();
	}
}
