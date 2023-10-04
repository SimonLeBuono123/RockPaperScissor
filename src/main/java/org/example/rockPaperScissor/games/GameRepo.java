package org.example.rockPaperScissor.games;

public interface GameRepo {
    void play(int count);

    String roundFormat(int playerScore, int computerScore, int round, String roundResult);

}
