package main;

public class GenerarMatricula {

    private static String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String parteEntera;
    private String parteString;
    private String matricula;

    private String generarEnteros() {
        try {
            StringBuilder sb = new StringBuilder();
            String numeroRandom = String.valueOf((int) (Math.random() * 9998 + 1));
            int cerosPorAgregar = 4 - numeroRandom.length();
            for (int i = 0; i < cerosPorAgregar; i++) {
                sb.append('0');
            }
            sb.append(numeroRandom);
            return sb.toString();
        } catch (Exception e) {
            System.err.println("Error al generar la parte entera de la matrícula: " + e.getMessage());
            return "0000"; 
        }
    }

    private String generarLetras() {
        try {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 3; i++) {
                sb.append(alfabeto.charAt((int) (Math.random() * alfabeto.length())));
            }
            return sb.toString();
        } catch (Exception e) {
            System.err.println("Error al generar la parte de letras de la matrícula: " + e.getMessage());
            return "AAA"; 
        }
    }

    public String generarMatricula() {
        try {
            parteEntera = generarEnteros();
            parteString = generarLetras();
            matricula = parteEntera + " " + parteString;
            return matricula;
        } catch (Exception e) {
            System.err.println("Error al generar la matrícula completa: " + e.getMessage());
            return "0000 AAA"; 
        }
    }
}