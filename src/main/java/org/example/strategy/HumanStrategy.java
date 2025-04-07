package org.example.strategy;

import java.util.Scanner;

public class HumanStrategy implements MancalaStrategy {
    private Scanner sc;

    public HumanStrategy() {
        sc = new Scanner(System.in);
    }

    @Override
    public int selectPit(int[] board, int player) {
        return sc.nextInt();
    }
}
