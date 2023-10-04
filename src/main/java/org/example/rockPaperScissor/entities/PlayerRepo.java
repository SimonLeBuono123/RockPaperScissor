package org.example.rockPaperScissor.entities;

import java.util.List;

public interface PlayerRepo {
    void scoreBoard();
    List<Player> createPlayer();
    void setActivePlayer();
    static Player fetchPlayer(){
        return null;
    };
}
