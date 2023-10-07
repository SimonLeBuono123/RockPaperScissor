package org.example.rockPaperScissor.entities.enemies;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Klockis extends Enemy{
    private final Calendar rightNow = Calendar.getInstance();

    private static int nextMove = 0;
    private final List<Integer> clocks = new ArrayList<>(List.of(
            1, 1, 2, 2, 3, 3, 3, 3, 2, 2, 1, 1
    ));
    public Klockis(){
        super("Klockis");
    }
    private int getNextMove(){

        return clocks.get(nextMove - 1);
    }

    @Override
    public int getMove() {
        //gets the hour of the day(12 hour)so 13:00 would then be hour 1
        int hour = rightNow.get(Calendar.HOUR);
        if(hour == nextMove){
            nextMove = 0;
        }
        nextMove++;
        return getNextMove();
    }
}
