package ejercicio2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	
	/**
	 * Pre: --- 
	 * Post: Este método se encarga de leer el fichero recibido como parámetro y
	 * 		 mostrar por pantalla los datos del ejercicio
	 */
	public static void leer(String nombre) {
		ArrayList<Localidad> localidades = new ArrayList<Localidad>();
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
					for (int i = 0; i < localidades.size(); i++) {
						if (Integer.parseInt(localidad[0]) == localidades.get(i).getIdLocalidad()) {
							encontrado = true;
							break;
						}
					}
					Localidad l = new Localidad(Integer.parseInt(localidad[0]), localidad[1], 0);
					if (encontrado == false) {
						localidades.add(l);
					}
					for (int j = 3; j < 10; j++) {
						for (int i = 0; i < localidades.size(); i++) {
							if (localidades.get(i).getIdLocalidad() == Integer.parseInt(localidad[0])
									&& lineaSeparada[2].equalsIgnoreCase("201" + j)) {
								if (lineaSeparada.length < 4) {

								} else {
									localidades.get(i).setTotalDivorcios(localidades.get(i).getTotalDivorcios()
											+ Integer.parseInt(lineaSeparada[3]));
								}
							}
						}
					}
				} else {
					contador++;
				}
			}
			Collections.sort(localidades);
			System.out.println("El numero total de divorcios con separacion previa en el año 2019: " + divorcios1);
			System.out.println("El numero total de divorcios sin separacion previa en el año 2018: " + divorcios2);
			System.out.println("La localidad cuyo numero de divorcios desde 2013 hasta 2019 haya sido mayor: "
					+ localidades.get(0).getIdLocalidad() + " " + localidades.get(0).getLocalidad());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Pre: --- 
	 * Post: Este método llama al método leer dandole como parámetro y
	 * 		 un path
	 */
	public static void main(String[] args) throws Exception {
		leer("C:\\Users\\Salesianos\\Desktop\\ExamenFinalProgramacion\\Divorcios.csv");
	}
}
