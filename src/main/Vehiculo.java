package main;

public class Vehiculo extends Thread{

	private Parking parking;
	private String matricula;
	
	public Vehiculo(Parking parking, String matricula) {
		this.parking = parking;
		this.matricula = matricula;
	}

	public String getIdVehiculo() {
		return matricula;
	}

	@Override
	public void run() {
		
	}
	
}
