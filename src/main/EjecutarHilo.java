package main;


public class EjecutarHilo {

	private int numero_coches;
	private Parking parking;
	
	public EjecutarHilo(int numeroCoches, Parking parking) {
		this.numero_coches = numeroCoches;
		this.parking = parking;
	}

	public void arrancarCoches() {
		for (int i = 0; i < numero_coches; i++) {
			Vehiculo vehiculo = new Vehiculo(parking);
			vehiculo.start();
			System.out.println("Coche "+vehiculo.getIdVehiculo()+" se ha arrancado");
		}
	}
}
