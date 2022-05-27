package ejercicio4;

import java.util.Scanner;

public class Main {
	public static void tablaMultiplicar(int numero) {
		return numero +(tablaMultiplicar());
	}
	
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Intoduce un numero entero: ");
		int numero = entrada.nextInt();
		tablaMultiplicar(numero);
	}
}
