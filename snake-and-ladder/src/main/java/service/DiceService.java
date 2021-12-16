package service;

import java.util.Random;

import model.Constants;

public class DiceService {
    private final int bound;

    public DiceService(int bound) {
        this.bound = bound;
    }

    public DiceService() {
        this.bound = Constants.DEFAULT_DICE_BOUND;
    }

    public int rollDice() {
        return new Random().nextInt(bound) + 1;
    }
}
