package org.example;

import org.example.controller.MancalaController;
import org.example.strategy.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== MANCALA ===");
        System.out.println("Elige el modo de juego:");
        System.out.println("1. Jugador vs Jugador");
        System.out.println("2. Jugador vs Computadora (Bot Voraz)");
        System.out.print("Opción: ");

        int opcion = scanner.nextInt();

        MancalaController controller;

        if (opcion == 1) {
            MancalaStrategy jugador1 = new HumanStrategy();
            MancalaStrategy jugador2 = new HumanStrategy();
            controller = new MancalaController(jugador1, jugador2);
        } else if (opcion == 2) {
            MancalaStrategy jugador1 = new HumanStrategy();
            MancalaStrategy bot = new SyntheticGreedyStrategy(2);
            controller = new MancalaController(jugador1, bot);
        } else {
            System.out.println("Opción inválida. Saliendo...");
            return;
        }

        controller.play();
    }
}
