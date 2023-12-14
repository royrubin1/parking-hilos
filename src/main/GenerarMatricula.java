package main;

public class GenerarMatricula {

	private static String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private String parteEntera;
	private String parteString;
	private String matricula;

	private String generarEnteros() {		
		StringBuilder sb = new StringBuilder();		
		String numeroRandom = String.valueOf((int) (Math.random() * 9998 + 1));
		int cerosPorAgregar = 4 - numeroRandom.length();
	    for (int i = 0; i < cerosPorAgregar; i++) {
	        sb.append('0');
	    }	   
	    sb.append(numeroRandom);	    
	    return sb.toString();
	}

	private String generarLetras() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 3; i++) {
			sb.append(alfabeto.charAt((int) (Math.random() * alfabeto.length())));
		}
		return sb.toString();
	}

	public String generarMatricula() {
		parteEntera = generarEnteros();
		parteString = generarLetras();
		matricula = parteEntera + " " + parteString;
		return matricula;
	}

}
