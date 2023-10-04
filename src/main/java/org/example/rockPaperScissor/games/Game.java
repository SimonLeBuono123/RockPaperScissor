package org.example.rockPaperScissor.games;

import org.example.rockPaperScissor.entities.Player;
import org.example.rockPaperScissor.entities.enemies.Enemy;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


enum RPSmoves{
    ROCK, PAPER, SCISSOR;

    public int getMoveValue(){
        return switch (this){
            case ROCK -> 1;
            case PAPER -> 2;
            case SCISSOR -> 3;
        };
    }
    public static String getMoveName(int move){
        return switch (move){
            case 1 -> "Rock";
            case 2 -> "Paper";
            case 3 -> "Scissor";
            default -> "Invalid move";
        };
    }
}
public class Game implements GameRepo{
    private static final Scanner scanner = new Scanner(System.in);
    protected List<String> gameTracking;
    //dependency inversion
    //composite pattern
    private final Enemy enemy;
    private final Player player;
    private LocalDate currentDate;
    private int round = 0;

    private final int rock = RPSmoves.ROCK.getMoveValue();
    private final int paper = RPSmoves.PAPER.getMoveValue();
    private final int scissor = RPSmoves.SCISSOR.getMoveValue();
    public Game(Player player, Enemy enemy) {
        this.enemy = enemy;
        this.player = player;
        this.currentDate = LocalDate.now();
    }


    @Override
    public void play(int pointsToWin) {
        gameTracking = new ArrayList<>();
        boolean exitGame = true;
         int playerScore = 0;
         int computerScore = 0;
        int playerMove;
        int computerMove;
        while(pointsToWin > playerScore && pointsToWin > computerScore && exitGame){
            System.out.println("Choose between:\n  rock - 1, paper - 2, scissors - 3" +
                    " or press 0 to exit back to Main menu");
            playerMove = scanner.nextInt();
            computerMove = enemy.getMove();
            if(playerMove == 0){
                exitGame = false;

            }
            System.out.println("Computer choose: " + RPSmoves.getMoveName(computerMove));
            if(playerMove == computerMove){
                round++;
                gameTracking.add(roundFormat(playerScore, computerScore, round, "Draw"));
                System.out.println(roundFormat(playerScore, computerScore, round, "Draw"));
                System.out.println("Draw!! ");
            }
            if(computerScores(playerMove, computerMove)){
                System.out.println("Computer scores!");
                computerScore++;
                round++;
                System.out.println(roundFormat(playerScore, computerScore, round, "Computer scores"));
                gameTracking.add(roundFormat( playerScore, computerScore, round, "Computer scores"));
            }
            if(playerScores(playerMove, computerMove)){
                System.out.println("Player scores!");
                playerScore++;
                round++;
                System.out.println(roundFormat(playerScore, computerScore, round, "Player scores"));
                gameTracking.add(roundFormat(playerScore, computerScore, round, "Player scores"));
            }
            scanner.nextLine();
        }
        if(pointsToWin <= computerScore){
            System.out.println("Computer wins");
            System.out.printf("Result: %s - %s to %s%n", playerScore, computerScore, enemy.getName());
            gameTracking.add("Result: %s - %s to %s".formatted(computerScore, playerScore, enemy.getName()));
            GameHistory.addToHistory(gameTracking);
        }
        if(pointsToWin <= playerScore){
            System.out.println(player.getName() +  " wins");
            player.calculateScore(enemy);
            System.out.printf("Result: %s - %s to %s%n", playerScore, computerScore, player.getName());
            gameTracking.add("%nResult: %s - %s to %s%n%n".formatted(playerScore, computerScore, player.getName()));
            GameHistory.addToHistory(gameTracking);
        }
    }


    private boolean computerScores(int playerMove, int computerMove) {

        return  (computerMove == rock && playerMove == scissor) ||
                (computerMove == paper && playerMove == rock) ||
                (computerMove == scissor && playerMove == paper);


    }

    private boolean playerScores(int playerMove, int computerMove) {

        return  (playerMove == rock && computerMove == scissor) ||
                (playerMove == paper && computerMove == rock) ||
                (playerMove == scissor && computerMove == paper);
    }


    @Override
    public String roundFormat(int playerScore, int computerScore, int round, String roundResult) {
        String currentRound = round + " " + roundResult;
        return "Round %s%nPlayer score: %s ---- Computer score: %S%n".formatted(currentRound, playerScore, computerScore);
    }


}
