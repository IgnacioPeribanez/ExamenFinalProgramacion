package ejercicio2;

public class Localidad {
	private int idLocalidad;
	private String localidad;
	private int totalDivorcios;
	
	public Localidad(int idLocalidad, String localidad, int totalDivorcios) {
		this.idLocalidad = idLocalidad;
		this.localidad = localidad;
		this.totalDivorcios = totalDivorcios;
	}

	public int getIdLocalidad() {
		return idLocalidad;
	}

	public void setIdLocalidad(int idLocalidad) {
		this.idLocalidad = idLocalidad;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public int getTotalDivorcios() {
		return totalDivorcios;
	}

	public void setTotalDivorcios(int totalDivorcios) {
		this.totalDivorcios = totalDivorcios;
	}
	
}
