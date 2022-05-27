package ejercicio1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
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
				linea = linea.replaceAll(",", "").replaceAll("\\.", "").replaceAll("\\?", "").replaceAll("\\¿", "");
					String[] lineaSeparada = linea.split(" ");
					for(int i = 0; i < lineaSeparada.length; i++) { 
						if (lineaSeparada[i].substring(0, 1).equalsIgnoreCase(letra) || 
								lineaSeparada[i].substring(lineaSeparada[i].length()-1, lineaSeparada[i].length()).equalsIgnoreCase(letra)) {
							dao.insertRegistro(letra, lineaSeparada[i], lineaPalabra);
						}
					} 
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws Exception {
		Scanner entrada = new Scanner(System.in);
		leer("C:\\Users\\Salesianos\\Desktop\\ExamenFinal\\ExamenFinal\\HablanosDelDon.txt", "a");
	}
}
