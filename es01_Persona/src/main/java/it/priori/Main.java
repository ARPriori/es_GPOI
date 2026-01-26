package it.priori;

public class Main {
    public static void main(String[] args) {
        try {
            Persona p1 = new Persona("Mario", "Rossi", "MRARSS01A25D567K");
            Persona p2 = new Persona("Giorgio", "Rino", "GRGRNI08S14C801O");

            System.out.println(p1.toString());
            System.out.println(p2.toString());

            if (p1.isOmonimo(p2)) {
                System.out.println(p1.getNome() + " e " + p2.getNome() + " sono omonimi");
            } else {
                System.out.println(p1.getNome() + " e " + p2.getNome() + " NON sono omonimi");
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Errore: " + e.getMessage());
        }
    }
}