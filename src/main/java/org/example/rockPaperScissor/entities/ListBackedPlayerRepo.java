package org.example.rockPaperScissor.entities;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ListBackedPlayerRepo implements PlayerRepo{
    private static final Scanner scanner = new Scanner(System.in);
    private static Player activePlayer;
    private static List<Player> playerList = new ArrayList<>(List.of(
            new Player("Johnny", 1000),
            new Player("Donn", 600)
    ));

    @Override
    public List<Player> createPlayer() {
        System.out.println("Enter a username to create a new player");
        String newPlayer = scanner.nextLine();
        playerList.add(new Player(newPlayer));
        //after creating and adding player to playerList the recently
        // created player will also become the currently active player
        selectPlayer(playerList.size() - 1);
        return playerList;
    }

    @Override
    public void scoreBoard() {
        playerList.stream()
                .sorted(Comparator.comparing(Player::getScore).reversed())
                .forEach(System.out::println);
    }

    private void selectPlayer(int playerIndex){
        activePlayer = playerList.get(playerIndex);
    }

    @Override
    public void setActivePlayer() {
       playerList.forEach(System.out::println);
        System.out.println("Select one player to play with by its id");
        int selectedPlayer = scanner.nextInt();
        for(int i = 0; i < playerList.size(); i++){
            int playerId = playerList.get(i).getId();
            if(selectedPlayer == playerId){
                selectPlayer(i);
            }
        }

    }

    public static Player fetchPlayer() {
        return activePlayer;
    }
}
