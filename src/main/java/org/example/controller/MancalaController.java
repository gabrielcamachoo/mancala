package org.example.controller;

import org.example.model.MancalaModel;
import org.example.view.MancalaView;
import org.example.strategy.*;

public class MancalaController {
    private MancalaModel model;
    private MancalaView view;
    private MancalaStrategy player1Strategy;
    private MancalaStrategy player2Strategy;

    // Constructor por defecto: jugador humano vs bot voraz
    public MancalaController() {
        model = new MancalaModel();
        view = new MancalaView();
        player1Strategy = new HumanStrategy();
        player2Strategy = new SyntheticGreedyStrategy(2);
    }

    // Constructor alterno por si quieres inyectar las estrategias manualmente
    public MancalaController(MancalaStrategy p1, MancalaStrategy p2) {
        model = new MancalaModel();
        view = new MancalaView();
        player1Strategy = p1;
        player2Strategy = p2;
    }

    public void play() {
        int currentPlayer = 1;
        while (!model.isGameOver()) {
            separadorEntreTurnos();
            view.displayBoard(model.getBoard(), currentPlayer);
            view.promptPlayer(currentPlayer);

            int pitIndex = (currentPlayer == 1)
                    ? player1Strategy.selectPit(model.getBoard(), 1)
                    : player2Strategy.selectPit(model.getBoard(), 2);

            if (!validMove(pitIndex, currentPlayer)) {
                view.invalidMove();
                continue;
            }
            if (pitIndex == -1) {
                System.out.println("️ Jugador " + currentPlayer + " no tiene jugadas válidas. Turno perdido.");
                currentPlayer = (currentPlayer == 1) ? 2 : 1;
                continue;
            }

            boolean extraTurn = model.makeMove(pitIndex, currentPlayer);
            if (!extraTurn)
                currentPlayer = (currentPlayer == 1) ? 2 : 1;

        }

        view.displayBoard(model.getBoard(), currentPlayer);
        view.displayWinner(model.getWinner());
    }

    private boolean validMove(int pitIndex, int player) {
        if (player == 1 && (pitIndex < 0 || pitIndex > 5))
            return false;
        if (player == 2 && (pitIndex < 7 || pitIndex > 12))
            return false;

        return model.getBoard()[pitIndex] > 0;
    }

    private void separadorEntreTurnos() {
        System.out.println();
        System.out.println("────────────────────────────────────────────────────────────");
        System.out.println();
    }
}
