package org.example.rockPaperScissor.entities.enemies;

import org.example.rockPaperScissor.entities.Entity;

public abstract class Enemy extends Entity {
    public Enemy(String name) {
        super(name);
    }
    public Enemy(){}
    // Factory method pattern
    public static Enemy getEnemyType(String choice){
        return switch(choice.toLowerCase()){
            case "slumpis" -> new Slumpis();
            case "klockis" -> new Klockis();
            case "namnis" -> new Namnis();
            default ->  throw new IllegalStateException("Invalid type chosen");
        };

    }

    public abstract int getMove();
}
