package org.example;

import org.example.controller.MancalaController;
import org.example.strategy.HumanStrategy;

public class Main {
    public static void main(String[] args) {
        MancalaController game = new MancalaController(new HumanStrategy(), new HumanStrategy());
        game.play();
    }
}
