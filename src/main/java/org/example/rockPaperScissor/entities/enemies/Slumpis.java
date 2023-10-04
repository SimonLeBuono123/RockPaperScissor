package org.example.rockPaperScissor.entities.enemies;

import java.util.Random;

public class Slumpis extends Enemy{
    private static final Random random = new Random();
    public Slumpis() {
        super("Slumpis");
    }

    @Override
    public int getMove() {
        return random.nextInt(1, 3);
    }
}
