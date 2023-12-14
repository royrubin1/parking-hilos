package main;

public class Vehiculo extends Thread{

	private Parking parking;
	private String matricula;
	private GenerarMatricula generarMatricula = new GenerarMatricula();
	private int plaza;
	
	
	public Vehiculo(Parking parking) {
		this.parking = parking;
		this.matricula = generarMatricula.generarMatricula();
	}

	
	
	public String getIdVehiculo() {
		return matricula;
	}

	@Override
	public void run() {
		
	}
	
}
