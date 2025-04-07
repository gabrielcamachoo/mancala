package org.example.model;

public class MancalaModel {
    private int[] board;
    public static final int PLAYER1_STORE = 6;
    public static final int PLAYER2_STORE = 13;

    public MancalaModel() {
        board = new int[14];
        for (int i = 0; i < board.length; i++) {
            if (i != PLAYER1_STORE && i != PLAYER2_STORE)
                board[i] = 4;
        }
    }

    public int[] getBoard() {
        return board;
    }

    public boolean makeMove(int pitIndex, int player) {
        int stones = board[pitIndex];
        board[pitIndex] = 0;
        int currentIndex = pitIndex;

        while (stones > 0) {
            currentIndex = (currentIndex + 1) % 14;

            if ((player == 1 && currentIndex == PLAYER2_STORE) ||
                    (player == 2 && currentIndex == PLAYER1_STORE))
                continue;

            board[currentIndex]++;
            stones--;
        }

        return (player == 1 && currentIndex == PLAYER1_STORE) ||
                (player == 2 && currentIndex == PLAYER2_STORE);
    }

    public boolean isGameOver() {
        boolean side1Empty = true, side2Empty = true;

        for (int i = 0; i < PLAYER1_STORE; i++)
            if (board[i] != 0) side1Empty = false;

        for (int i = 7; i < PLAYER2_STORE; i++)
            if (board[i] != 0) side2Empty = false;

        return side1Empty || side2Empty;
    }

    public int getWinner() {
        int score1 = board[PLAYER1_STORE];
        int score2 = board[PLAYER2_STORE];

        return Integer.compare(score1, score2);
    }
}
