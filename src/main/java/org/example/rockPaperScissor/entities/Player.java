package org.example.rockPaperScissor.entities;

import org.example.rockPaperScissor.entities.enemies.Enemy;
import org.example.rockPaperScissor.entities.enemies.Klockis;
import org.example.rockPaperScissor.entities.enemies.Namnis;
import org.example.rockPaperScissor.entities.enemies.Slumpis;

public class Player extends Entity{
    private int score;
    private final int id;
    private static int idCounter = 0;
    public Player(String name, int score){
        super(name);
        this.score = score;
        this.id = idCounter++;
    }
    public Player(String name) {
        super(name);
        this.id = idCounter++;
        this.score = 0;
    }


    private void setScore(int score) {
        this.score += score;
    }

    public <T extends Enemy>void calculateScore(T enemy){
        if(enemy instanceof Slumpis){
            this.setScore(50);
        }
        if(enemy instanceof Klockis){
            this.setScore(110);
        }
        if(enemy instanceof Namnis){
            this.setScore(10);
        }
    }

    public int getId() {
        return id;
    }

    public int getScore() {
        return score;
    }


    @Override
    public String toString() {
        return "[ id: %s - name: %s - score: %s]%n".formatted(id, getName(), score);

    }
}
