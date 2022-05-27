package ejercicio1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	
	/**
	 * Pre: --- 
	 * Post: Este método lee el fichero y filtra las palabras por la letra recibida como parametro,
	 * 		 despues inserta cada registro en la base de datos.
	 */
	public static void leer(String nombre, String letra) throws Exception {
		MySQLAccess dao = new MySQLAccess();
		int lineaPalabra = 0;
		File file = new File(nombre);
		try {
			Scanner f = new Scanner(file);
			System.out.println();
			while (f.hasNextLine()) {
				lineaPalabra++;
				String linea = f.nextLine();
				linea = linea.replaceAll(",", "").replaceAll("\\.", "").replaceAll("\\?", "").replaceAll("\\�", "");
				String[] lineaSeparada = linea.split(" ");
				for (int i = 0; i < lineaSeparada.length; i++) {
					if (lineaSeparada[i].substring(0, 1).equalsIgnoreCase(letra)
							|| lineaSeparada[i].substring(lineaSeparada[i].length() - 1, lineaSeparada[i].length())
									.equalsIgnoreCase(letra)) {
						dao.insertRegistro(letra, lineaSeparada[i], lineaPalabra);
						System.out.println("Nuevo Registro: " + "Letra:" + letra + "Palabra:" + lineaSeparada[i]
								+ "Linea" + +lineaPalabra);
					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Pre: --- 
	 * Post: Este método llama al método leer, pasando por parametro un path y una letra.
	 */
	public static void main(String[] args) throws Exception {
		leer("C:\\Users\\Salesianos\\Desktop\\ExamenFinal\\ExamenFinal\\HablanosDelDon.txt", "a");
	}
}
