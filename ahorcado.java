package juegodelahorcado;

import java.util.Scanner;

public class JuegoDelAhorcado {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String palabraSecreta = "TECLADO";
        char letraIngresada;
        char letras[] = new char[palabraSecreta.length()];
        int intentosMax = 5;
        boolean estaAdivinada = false;

        System.out.println("------------------------------");
        System.out.println("----- JUEGO DEL AHORCADO -----");
        System.out.println("------------------------------\n");

        System.out.println("LA PALABRA TIENE " + palabraSecreta.length() + " LETRAS Y TENES " + intentosMax + " INTENTOS\n");
        for (int i = 0; i < letras.length; i++) {
            letras[i] = '_';
            System.out.print(" ");
            System.out.print(letras[i] + " ");
        }

        System.out.println("\n");

        while ((!(estaAdivinada)) && (intentosMax > 0) && (intentosMax < 6)) {

            System.out.print("INGRESE UNA LETRA AQUI --> ");
            letraIngresada = Character.toUpperCase(scanner.next().charAt(0)); //devuelve la primer letra que escribo

            boolean letraCorrecta = false;

            for (int i = 0; i < palabraSecreta.length(); i++) {

                if (letraIngresada == palabraSecreta.charAt(i)) {
                    letras[i] = letraIngresada;
                    letraCorrecta = true;
                }
            }

            if (letraCorrecta) {
                System.out.println("\nLETRA CORRECTA !!! \n");
                System.out.println(" " + String.valueOf(letras) + "\n");
            } else {
                intentosMax--;
                if (intentosMax > 0) {
                    System.out.println("\nLETRA INCORRECTA, TE QUEDAN " + intentosMax + " INTENTOS \n");
                    System.out.println(" " + String.valueOf(letras) + "\n");
                }
            }

            if (String.valueOf(letras).equals(palabraSecreta)) { //comparo si lo que se ingreso es == a la palabra
                estaAdivinada = true;
            }
        }

        if (estaAdivinada) {
            System.out.println("\nADIVINASTE LA PALABRA !!! \n");
        } else {
            System.out.println("\nTE QUEDASTE SIN INTENTOS ;( \n");
        }

        scanner.close();
    }
}