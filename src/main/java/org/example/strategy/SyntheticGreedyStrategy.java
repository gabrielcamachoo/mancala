package org.example.strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SyntheticGreedyStrategy implements MancalaStrategy {
    private final int player;
    private final Random random = new Random();

    public SyntheticGreedyStrategy(int player) {
        this.player = player;
    }

    @Override
    public int selectPit(int[] board, int player) {
        int start = (player == 1) ? 0 : 7;
        int end = (player == 1) ? 5 : 12;

        int bestGain = Integer.MIN_VALUE;
        List<Integer> bestPits = new ArrayList<>();

        for (int pit = start; pit <= end; pit++) {
            if (board[pit] == 0) continue; // saltar pozos vacíos

            int gain = simulateGain(board.clone(), pit, player);

            if (gain > bestGain) {
                bestGain = gain;
                bestPits.clear();
                bestPits.add(pit);
            } else if (gain == bestGain) {
                bestPits.add(pit);
            }
        }

        // Si no encontró ningún pozo con ganancia, buscar cualquiera disponible
        if (bestPits.isEmpty()) {
            for (int pit = start; pit <= end; pit++) {
                if (board[pit] > 0) {
                    bestPits.add(pit);
                }
            }
        }

        if (bestPits.isEmpty()) {
            System.out.println(" Bot Voraz no encuentra pozos válidos. Pierde turno.");
            return -1;
        }

        int chosen = bestPits.get(random.nextInt(bestPits.size()));
        System.out.println(" Bot Voraz juega en el pozo: " + chosen);
        return chosen;
    }

    private int simulateGain(int[] boardCopy, int pitIndex, int player) {
        int stones = boardCopy[pitIndex];
        boardCopy[pitIndex] = 0;

        int index = pitIndex;
        while (stones > 0) {
            index = (index + 1) % boardCopy.length;
            if ((player == 1 && index == 13) || (player == 2 && index == 6)) continue;
            boardCopy[index]++;
            stones--;
        }

        int houseIndex = (player == 1) ? 6 : 13;
        return (index == houseIndex) ? 1 : 0;  // ganar turno extra
    }
}
