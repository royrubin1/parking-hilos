package main;

public class Main {
	private static int numPlazas = 10;
	private static int numCoches = 10;
	public static void main(String[] args) {
		Parking parking = new Parking(numPlazas);
		EjecutarHilo ejecutarhilos = new EjecutarHilo(numCoches, parking);
		ejecutarhilos.arrancarCoches();
	}
}
