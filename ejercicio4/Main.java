package ejercicio4;

import java.util.Scanner;

public class Main {
	
	/**
	 * Pre: --- 
	 * Post: Este método se encarga de mostrar por pantalla el resultado de multiplicar
	 * 		 un número por un multiplo que va variando.
	 */
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
	
	/**
	 * Pre: --- 
	 * Post: Este método se encarga de pedirle un numero al usuario, y llamar 
	 * 		 al metodo tablaMultiplicar().
	 */
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.print("Intoduce un numero entero: ");
		int numero = entrada.nextInt();
		tablaMultiplicar(numero, 0);
	}
}
