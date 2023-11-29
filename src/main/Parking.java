package main;

import java.util.ArrayList;

public class Parking {
	final int limite = 10;
	ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
	
	public synchronized void entradaParking(Vehiculo vehiculo) {
		while(vehiculos.size() >= limite) {
			System.out.println("Parking lleno.");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		vehiculos.add(vehiculo);
		notifyAll();
	}
	
	synchronized void salidaParking() {
		
	}
	
}
