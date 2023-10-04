package org.example.rockPaperScissor;


import org.example.rockPaperScissor.menu.MenuSystem;


public class Main {
    public static void main(String[] args) {

        MenuSystem menuSystem = MenuSystem.getInstance();
        while(true){
            menuSystem.execute();
        }
    }
}
