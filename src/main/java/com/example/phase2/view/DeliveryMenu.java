package com.example.phase2.view;

import   com.example.phase2.controller.DeliveryMenuController;
import com.example.phase2.controller.MainMenuController;
public class DeliveryMenu {
    private DeliveryMenuController deliveryMenuController;

    public DeliveryMenu() {
        deliveryMenuController = new DeliveryMenuController();
    }
    public void run(){
        String command;
        while (true){
            command = Menu.getScanner().nextLine();
            if (command.matches("^\\s*back to main menu\\s*$")) return;

        }
    }
}
