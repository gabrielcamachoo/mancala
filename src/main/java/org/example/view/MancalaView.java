package org.example.view;

public class MancalaView {
    public void displayBoard(int[] board, int currentPlayer) {
        String playerTurn = (currentPlayer == 1) ? "👉 Turno del Jugador 1 (abajo)" : "👈 Turno del Jugador 2 (arriba)";

        System.out.println("\n" + playerTurn);
        System.out.println("╔═══════════════════════════════════════════════════╗");
        System.out.println("║     Índices P2: 12 11 10  9  8  7                ║");
        System.out.println("║                   🅿️  Jugador 2                  ║");
        System.out.println("║     ┌────┬────┬────┬────┬────┬────┐               ║");
        System.out.printf ("║     │ %2d │ %2d │ %2d │ %2d │ %2d │ %2d │               ║\n",
                board[12], board[11], board[10], board[9], board[8], board[7]);
        System.out.println("║     └────┴────┴────┴────┴────┴────┘               ║");

        System.out.printf ("║ 🏦 %2d                              %2d 🏦 ║\n", board[13], board[6]);

        System.out.println("║     ┌────┬────┬────┬────┬────┬────┐               ║");
        System.out.printf ("║     │ %2d │ %2d │ %2d │ %2d │ %2d │ %2d │               ║\n",
                board[0], board[1], board[2], board[3], board[4], board[5]);
        System.out.println("║     └────┴────┴────┴────┴────┴────┘               ║");
        System.out.println("║     Índices P1:  0  1  2  3  4  5                ║");
        System.out.println("║                   🅿️  Jugador 1                  ║");
        System.out.println("╚═══════════════════════════════════════════════════╝");
    }


    public void displayWinner(int winner) {
        if (winner == 0)
            System.out.println("¡Empate!");
        else if (winner > 0)
            System.out.println("¡Ganador Jugador 1!");
        else
            System.out.println("¡Ganador Jugador 2!");
    }

    public void promptPlayer(int player) {
        System.out.printf("Jugador %d, selecciona un pozo: ", player);
    }

    public void invalidMove() {
        System.out.println("Movimiento inválido. Intenta nuevamente.");
    }
}
