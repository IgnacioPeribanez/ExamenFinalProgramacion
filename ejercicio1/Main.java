package ejercicio1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
	public static void leer(String nombre, String letra) {
		int lineaPalabra = 0;
		File file = new File(nombre);
		try {
			Scanner f = new Scanner(file);
			System.out.println();
			while (f.hasNextLine()) {
				String linea = f.nextLine(); 
				linea = linea.replaceAll(",", "").replaceAll("\\.", "").replaceAll("\\?", "").replaceAll("\\¿", "");
					String[] lineaSeparada = linea.split(" ");
					for(int i = 0; i < lineaSeparada.length; i++) { 
						System.out.println(lineaSeparada[i]);
						if (lineaSeparada[i].substring(0, 1).equalsIgnoreCase(letra) || 
								lineaSeparada[i].substring(lineaSeparada[i].length()-1, lineaSeparada[i].length()).equalsIgnoreCase(letra)) {
							System.out.println(lineaSeparada[i]);
						}
					} 
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		leer("C:\\Users\\Salesianos\\Desktop\\ExamenFinal\\ExamenFinal\\HablanosDelDon.txt", "a");
	}
}
