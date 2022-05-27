package ejercicio2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void leer(String nombre) {
		ArrayList<String> localidades = new ArrayList<String>();
		int contador = 0;	
		int divorcios1 = 0;
		int divorcios2 = 0;
		File file = new File(nombre);
		try {
			Scanner f = new Scanner(file);
			System.out.println();
			while (f.hasNextLine()) {
				String linea = f.nextLine();
				linea = linea.replaceAll("\\.", "");
				if (contador > 0) {
					String[] lineaSeparada = linea.split(";");
					if (lineaSeparada[2].equalsIgnoreCase("2019") && lineaSeparada[1].equalsIgnoreCase("Si")) {
						divorcios1 = divorcios1 + Integer.parseInt(lineaSeparada[3]);
					}
					if (lineaSeparada[2].equalsIgnoreCase("2018") && lineaSeparada[1].equalsIgnoreCase("No")) {
						divorcios2 = divorcios2 + Integer.parseInt(lineaSeparada[3]);
					}
					String[] localidad = lineaSeparada[0].split(" ");
					boolean encontrado = false;
					for (int z = 0; z < localidades.size(); z++) {
						if (localidad[0].equalsIgnoreCase(localidades.get(z))) {
							encontrado = true;
							break;
						}
					}
					if (encontrado == false) {
						localidades.add(localidad[0]);
					}
				}else {
					contador ++;
				}
			}
			System.out.println("El numero total de divorcios con separacion previa en el año 2019: " + divorcios1);
			System.out.println("El numero total de divorcios sin separacion previa en el año 2018: " + divorcios2);
			System.out.println("La localidad cuyo n�mero de divorcios desde 2013 hasta 2019 haya sido mayor: ");
			for (int z = 0; z < localidades.size(); z++) {
				System.out.println(localidades.get(z));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws Exception {
		Scanner entrada = new Scanner(System.in);
		leer("C:\\Users\\Salesianos\\Desktop\\ExamenFinalProgramacion\\Divorcios.csv");
	}
}
