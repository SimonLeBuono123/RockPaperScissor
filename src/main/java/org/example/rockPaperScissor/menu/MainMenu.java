package org.example.rockPaperScissor.menu;

import org.example.rockPaperScissor.games.GameHistory;

import java.util.List;

public class MainMenu extends Menu implements MenuState{

    public MainMenu() {
        super("Main menu");
        menuOptions = List.of(
                new MenuOption(1, "Game Menu", () -> MenuSystem.setState(new GameMenu())),
                new MenuOption(2, "Game History", () -> System.out.println(GameHistory.getGameHistory())),
                new MenuOption(3, "Player Menu", () -> MenuSystem.setState(new PlayerMenu())),
                new MenuOption(0, "Exit the system", () -> System.exit(0))
        );
    }
}
