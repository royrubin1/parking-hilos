package main;

import java.util.ArrayList;

public class Parking {
	private int limite ;
	private Vehiculo [] parking;
	
	public Parking(int limite) {

		this.limite = limite;
		parking = new Vehiculo [limite];
	}

	public synchronized void entradaParking(Vehiculo vehiculo) throws InterruptedException {
		 esperaplaza();
		
		 for(int i = 0; i<parking.length;i++) {
			 if(parking[i] == null) {
				 parking[i] = vehiculo;
				 break;
			 }
		 }
		 
		notifyAll();
	}
	
	synchronized void salidaParking() {
		
	}
	
	private boolean estalleno() {
		for(int i = 0; i < parking.length; i++) {
			if(parking[i] == null) {
				return false;
			}
		}
		return true;
	}
	
	private void esperaplaza() throws InterruptedException {
		while(estalleno()) {
			wait();
		}
	}
	
}
