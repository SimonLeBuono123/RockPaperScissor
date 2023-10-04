package org.example.rockPaperScissor.menu;

import org.example.rockPaperScissor.entities.ListBackedPlayerRepo;
import org.example.rockPaperScissor.entities.Player;
import org.example.rockPaperScissor.entities.enemies.Enemy;
import org.example.rockPaperScissor.games.Game;

import java.util.List;
import java.util.Scanner;

public class GameMenu extends Menu{
    private static final Scanner scanner = new Scanner(System.in);
    Player player = ListBackedPlayerRepo.fetchPlayer();
    public GameMenu() {
        super("Game Menu");
        menuOptions = List.of(
                new MenuOption(1, "Play against slumpis", () -> chosenEnemy(1, player)),
                new MenuOption(2, "Play against Klockis", () -> chosenEnemy(2, player)),
                new MenuOption(3, "Play against Namnis", () -> chosenEnemy(3, player)),
                new MenuOption(0, "Main menu", () -> MenuSystem.setState(new MainMenu()))
        );
    }

    public void chosenEnemy(int enemyType, Player player) {

        if(player == null || player.getName().equals("")){
            System.out.println("No player has been chosen," +
                    " please make a new one or choose from existing players");
            System.out.println("Press y to go player menu");
            String yesOrNo = scanner.nextLine();
            if(yesOrNo.equalsIgnoreCase("y")){
                MenuSystem.setState(new PlayerMenu());
            }


        }
        else {
            System.out.println("Select the amount of points need to win");
            int points = scanner.nextInt();
            Enemy enemy = Enemy.getEnemyType(enemyType);
            Game game = new Game(player, enemy);
            game.play(points);
        }

    }
}
