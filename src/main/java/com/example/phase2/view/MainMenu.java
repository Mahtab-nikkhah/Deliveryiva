package com.example.phase2.view;

import com.example.phase2.controller.MainMenuController;

public class MainMenu {
    private MainMenuController mainMenuController;
    public MainMenu(MainMenuController mainMenuController) {
        this.mainMenuController = mainMenuController;
    }
    public String run(){
        String command;
        while (true){
            command = Menu.getScanner().nextLine();
            if(command.matches("^\\s*(admin|Admin|ADMIN)\\s+(menu|Menu|MENU)\\s*$")){
                if (mainMenuController.isLoggedInUser())
                    System.out.println("access denied!");
                else
                    return "admin menu";
            }
            else if (command.matches("^\\s*(user|USER|User)\\s+(menu|Menu|MENU)\\s*$")) {
                if (!mainMenuController.isLoggedInUser())
                    System.out.println("access denied!");
                else
                    return "user menu";
            }
            else if (command.matches("^\\s*(delivery|DELIVERY|Delivery)\\s+(menu|Menu|MENU)\\s*$")) {
                if (mainMenuController.isLoggedInUser())
                    System.out.println("access denied!");
                else
                    return "delivery menu";
            }
            else if (command.matches("^\\s*(logout|Logout|LOGOUT)\\s*$")) {
                System.out.println(mainMenuController.logout());
                return "logout";
            } else
                System.out.println("invalid command!");

        }
    }
}
