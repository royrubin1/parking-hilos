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
		} catch (Exception e) {
			e.printStackTrace();
		}
		parking[plaza] = vehiculo;
		plaza = -1;
		
	}

	synchronized void salidaParking(Vehiculo vehiculo) {

		for (int i = 0; i < parking.length; i++) {
			if (parking[i] == vehiculo) {
				parking[i] = null;
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
			wait();
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
