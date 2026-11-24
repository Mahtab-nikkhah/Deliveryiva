package com.example.phase2.view;

import com.example.phase2.controller.FoodMenuForAdminController;
import com.example.phase2.model.Food;
import com.example.phase2.model.Node;

import java.util.regex.Matcher;

public class FoodMenuForAdmin {
    private FoodMenuForAdminController foodMenuForAdminController;

    public void run(Food food) {
        String command;
        Matcher matcher;
        while (true) {
            command = Menu.getScanner().nextLine();
            if (command.matches("^\\s*back to restaurant menu\\s*$")) return;
            else if ((matcher = Menu.getMatcher(command, "^\\s*(DISPLAY|Display|display)\\s+(RATING|rating|Rating)\\s*$")) != null) {
                foodMenuForAdminController.showRating();
            } else if ((matcher = Menu.getMatcher(command, "^\\s*(DISPLAY|Display|display)\\s+(COMMENTS|Comments|comments)\\s*$")) != null) {
                foodMenuForAdminController.showComments();
            } else if ((matcher = Menu.getMatcher(command, "^\\s*(ADD|add|Add)\\s+(NEW|New|new)\\s+(RESPONSE|Response|response)\\s+(?<comment_id>\\S+)\\s+(?<message>\\S+)\\s*$")) != null) {
                foodMenuForAdminController.addNewResponse(matcher.group("comment_id"), matcher.group("message"));
            } else if ((matcher = Menu.getMatcher(command, "^\\s*(EDIT|edit|Edit)\\s+(RESPONSE|Response|response)\\s+(?<comment_id>\\S+)\\s+(?<message>\\S+)\\s*$")) != null) {
                foodMenuForAdminController.editResponse(matcher.group("comment_id"), matcher.group("message"));
            }
        }
    }
}
