package main;

public class Vehiculo extends Thread {

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
		while (true) {

			try {

				Thread.sleep((long) (Math.random() * 7000 + 1000));
				parking.entradaParking(this);
				Thread.sleep((long) (Math.random() * 7000 + 1000));
				parking.salidaParking(this);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

}
