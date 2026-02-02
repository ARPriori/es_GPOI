package it.priori;

public class Main {
    public static void main(String[] args) {
        Temperatura t = new Temperatura(30);
        System.out.println(t.toString());
        t.aumenta(10);
        System.out.println(t.toString());
        t.diminuisci(20);
        System.out.println(t.toString());
    }
}