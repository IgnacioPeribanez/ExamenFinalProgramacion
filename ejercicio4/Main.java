package ejercicio4;

import java.util.Scanner;

public class Main {
	public static int tablaMultiplicar(int numero, int multiplo) {
		if (multiplo == 101) {
			return 0;
		} else {
			if (multiplo%2 == 0 )  {
				System.out.println(numero + " * " + multiplo + " = " + numero*multiplo);
			}
			return numero * (tablaMultiplicar(numero,multiplo+1));
		}
	}
	
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.print("Intoduce un numero entero: ");
		int numero = entrada.nextInt();
		tablaMultiplicar(numero, 0);
	}
}
