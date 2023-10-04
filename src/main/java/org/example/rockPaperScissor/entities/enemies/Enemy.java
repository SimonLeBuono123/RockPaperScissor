package org.example.rockPaperScissor.entities.enemies;

import org.example.rockPaperScissor.entities.Entity;

public abstract class Enemy extends Entity {
    public Enemy(String name) {
        super(name);
    }
    public Enemy(){}
    //Abstract factory patter
    public static Enemy getEnemyType(int choice){
        return switch(choice){
            case 1 -> new Slumpis();
            case 2 -> new Klockis();
            case 3 -> new Namnis();
            default ->  throw new IllegalStateException("Need to type in a number");
        };

    }

    public abstract int getMove();
}
