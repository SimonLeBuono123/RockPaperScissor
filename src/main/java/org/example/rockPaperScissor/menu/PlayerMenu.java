package org.example.rockPaperScissor.menu;

import org.example.rockPaperScissor.entities.ListBackedPlayerRepo;
import org.example.rockPaperScissor.entities.PlayerRepo;

import java.util.List;

public class PlayerMenu extends Menu{

    private static final PlayerRepo playerList = new ListBackedPlayerRepo();

    public PlayerMenu() {
        super("Player Menu");
        menuOptions = List.of(
                new MenuOption(1, "Create account", this::createNewPlayer),
                new MenuOption(2, "Choose a player to play with", playerList::setActivePlayer),
                new MenuOption(3, "Score board", playerList::scoreBoard),
                new MenuOption(0, "Go back to main Menu", () -> MenuSystem.setState(new MainMenu()))

        );
    }

    private void createNewPlayer(){
        playerList.createPlayer();
    }

}
