package com.example.phase2.view;

import com.example.phase2.controller.FoodMenuForAdminController;
import com.example.phase2.controller.FoodMenuForUserController;
import com.example.phase2.model.Food;


import java.util.regex.Matcher;

public class FoodMenuForUser {
    private FoodMenuForUserController foodMenuForUserController;

    public FoodMenuForUser() {
        foodMenuForUserController = new FoodMenuForUserController();
    }
    public void run(Food food){
        String command;
        Matcher matcher;
        while (true){
            command = Menu.getScanner().nextLine();
            if (command.matches("^\\s*back to restaurant menu\\s*$")) return;
            else if ((matcher = Menu.getMatcher(command, "^\\s*(DISPLAY|Display|display)\\s+(COMMENTS|Comments|comments)\\s*$")) != null) {
                foodMenuForUserController.showComments();
            }
            else if((matcher = Menu.getMatcher(command, "^\\s*(ADD|add|Add)\\s+(NEW|New|new)\\s+(COMMENTS|Comments|comments)\\s*$"))!=null){

            }

        }
    }
}
