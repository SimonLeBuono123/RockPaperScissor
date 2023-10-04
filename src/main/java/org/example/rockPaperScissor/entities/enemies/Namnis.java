package org.example.rockPaperScissor.entities.enemies;

import org.example.rockPaperScissor.entities.ListBackedPlayerRepo;
import org.example.rockPaperScissor.entities.Player;


public class Namnis extends Enemy {
    Player player = ListBackedPlayerRepo.fetchPlayer();
    public Namnis() {
        super("Namnis");
    }




    @Override
    public int getMove() {
        if(player.getName().contains("Rock")){
            return 1;
        } else if (player.getName().contains("Paper")) {
            return 2;
        } else if (player.getName().contains("Scissor")) {
            return 3;
        }
        return 0;
    }
}
