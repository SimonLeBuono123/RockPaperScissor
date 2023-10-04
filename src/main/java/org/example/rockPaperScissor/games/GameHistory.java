package org.example.rockPaperScissor.games;

import java.util.ArrayList;
import java.util.List;

public class GameHistory {
    private static final List<List<String>> gameHistory = new ArrayList<>();

    public static List<List<String>> addToHistory(List<String> lastGame){
        gameHistory.add(lastGame);
       return  gameHistory;
    }

    public static List<List<String>> getGameHistory() {
        return gameHistory;
    }
}
