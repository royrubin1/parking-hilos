package main;

public class Parking {

	private int limite;
	private Vehiculo[] parking;

	public Parking(int limite) {
		this.setLimite(limite);
		parking = new Vehiculo[limite];
	}

	public synchronized void entradaParking(Vehiculo vehiculo) throws InterruptedException {
	    int plaza = -1;
	    try {
	        plaza = esperaPlaza();
	    } catch (InterruptedException e) {
	        System.err.println("Error al esperar una plaza: " + e.getMessage());   
	        throw e;
	    }
	    parking[plaza] = vehiculo;
	    
	    System.out.println(
	            "El coche " + vehiculo.getIdVehiculo() + " ha entrado al parking y se sitúa en la plaza " + plaza);
	    plaza = -1;
	}

	synchronized void salidaParking(Vehiculo vehiculo) {

		for (int i = 0; i < parking.length; i++) {
			if (parking[i] == vehiculo) {
				parking[i] = null;
				System.out.println(
						"El coche " + vehiculo.getIdVehiculo() + " ha salido de la plaza " + i + " del parking.");

				break;
			}
		}
		notifyAll();

	}

	private int siLleno() {
		for (int i = 0; i < parking.length; i++) {
			if (parking[i] == null) {
				return i;
			}
		}
		return -1;
	}

	private int esperaPlaza() throws InterruptedException {
	    while (siLleno() == -1) {
	        try {
	            wait();
	        } catch (InterruptedException e) {
	            System.err.println("El hilo fue interrumpido mientras esperaba una plaza: " + e.getMessage());
	            throw e;
	        }
	    }
	    return siLleno();
	}

	public int getLimite() {
		return limite;
	}

	public void setLimite(int limite) {
		this.limite = limite;
	}

}