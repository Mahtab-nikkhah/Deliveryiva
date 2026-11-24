package  com.example.phase2.controller;

import   com.example.phase2.model.Food;
import   com.example.phase2.model.DataBase;
import   com.example.phase2.model.Order;
import   com.example.phase2.model.FoodType;
import   com.example.phase2.view.Menu;

import java.util.ArrayList;

public class RestaurantMenuForAdminController {
    public RestaurantMenuForAdminController() {
    }

    public void showRestaurantLocation() {
        System.out.println(DataBase.getCurrentRestaurantForAdmin().getLocation().getName());
    }

    public void editRestaurantLocation(String nodename) {
        DataBase.getCurrentRestaurantForAdmin().setLocation(DataBase.getNodeByName(nodename));
    }

    public void showRestaurantFoodType() {
        for (FoodType foodType : DataBase.getCurrentRestaurantForAdmin().getRestaurantType()) {
            System.out.println(foodType.getName());
        }
    }

    public void editRestaurantFoodType() {
        if (DataBase.getCurrentRestaurantForAdmin().isThereOrder()) {
            System.out.println("there is an active order");
        } else {
            System.out.println("ARE YOU SURE YOU WANT TO CHANGE YOUR RESTAURANT TYPE?");
            String yesOrNo = Menu.getScanner().nextLine();
            if (yesOrNo.equals("yes")) {
                String input = "";
                ArrayList<FoodType> foodTypes = new ArrayList<>();
                while (!(input = Menu.getScanner().nextLine()).equals("end")) {
                    foodTypes.add(new FoodType(input));
                }
                DataBase.getCurrentRestaurantForAdmin().setRestaurantType(foodTypes);
                DataBase.getCurrentRestaurantForAdmin().getMenu().clear();
                ArrayList<Food> foods = new ArrayList<>();
                String food = "";
                while (!(food = Menu.getScanner().nextLine()).equals("end")) {
                    double cost = Menu.getScanner().nextDouble();
                    foods.add(new Food(food, cost));
                }
                DataBase.getCurrentRestaurantForAdmin().setMenu(foods);
            }
        }
    }

    public void selectMenuOfRestaurant() {
        DataBase.getCurrentRestaurantForAdmin().selectMenuForShowingFoods();
    }

    public void editFoodName(String foodId, String newName) {
        int id = Integer.parseInt(foodId);
        DataBase.getCurrentRestaurantForAdmin().getFoodById(id).setName(newName);
        System.out.println("NAME CHANGED SUCCESSFULLY");
    }

    public void editFoodPrice(String foodId, String newPrice) {
        int id = Integer.parseInt(foodId);
        double cost = Double.parseDouble(newPrice);
        DataBase.getCurrentRestaurantForAdmin().getFoodById(id).setCost(cost);
        System.out.println("PRICE CHANGED SUCCESSFULLY");
    }

    public void addFoodToRestaurant(String name, String price) {
        double cost = Double.parseDouble(price);
        DataBase.getCurrentRestaurantForAdmin().addFoodToMenu(new Food(name, cost));
        System.out.println("FOOD ADDED TO RESTAURANT MENU SUCCESSFULLY");
    }


    public void deleteFoodFromRestaurant(String foodId) {
        int id = Integer.parseInt(foodId);
        System.out.println("ARE YOU SURE YOU WANT TO DELETE THIS FOOD?");
        String yesOrNo = Menu.getScanner().nextLine();
        if (yesOrNo.equals("yes")) {
            if (DataBase.getCurrentRestaurantForAdmin().isThereOrder()) {
                DataBase.getCurrentRestaurantForAdmin().getMenu().remove(DataBase.getCurrentRestaurantForAdmin().getFoodById(id));
                System.out.println("FOOD DELETED SUCCESSFULLY");
            } else {
                System.out.println("THERE IS ACTIVE ORDER YOU CAN NOT DELETE THIS FOOD");
            }

        }
    }


    public void deactivateFoodFromRestaurant(String foodId) {
        int id = Integer.parseInt(foodId);
        if (DataBase.getCurrentRestaurantForAdmin().isThereOrder()) {
            DataBase.getCurrentRestaurantForAdmin().getFoodById(id).setActive(false);
            System.out.println("FOOD DEACTIVATED SUCCESSFULLY");
        } else {
            System.out.println("THERE IS ACTIVE ORDER YOU CAN NOT DEACTIVATE THIS FOOD");
        }
    }

    public void activeFoodFromRestaurant(String foodId) {
        int id = Integer.parseInt(foodId);
        DataBase.getCurrentRestaurantForAdmin().getFoodById(id).setActive(true);
        System.out.println("FOOD ACTIVATED SUCCESSFULLY");
    }

    public void discountFood(String foodId, String discountPercent, String timestamp) {
        int id = Integer.parseInt(foodId);
        double discount = Double.parseDouble(discountPercent);
        double time = Double.parseDouble(timestamp);
        if (DataBase.getCurrentRestaurantForAdmin().getFoodById(id).isThereDiscount()) {
            System.out.println("YOU CAN NOT ADD ANOTHER DISCOUNT");
        } else {
            if (discount <= 0.5) {
                DataBase.getCurrentRestaurantForAdmin().getFoodById(id).setDiscount(discount);
                DataBase.getCurrentRestaurantForAdmin().getFoodById(id).setTimestamp(time);
                DataBase.getCurrentRestaurantForAdmin().getFoodById(id).setThereDiscount(true);
                System.out.println("DISCOUNT ADDED SUCCESSFULLY");
            }
        }
    }

    public void deleteDiscountFood(String foodId) {
        int id = Integer.parseInt(foodId);
        DataBase.getCurrentRestaurantForAdmin().getFoodById(id).setDiscount(1);
        DataBase.getCurrentRestaurantForAdmin().getFoodById(id).setTimestamp(0);
        System.out.println("DISCOUNT DELETED SUCCESSFULLY");
    }

    public void displayOnlineOrders() {
        for (Order order : DataBase.getCurrentRestaurantForAdmin().getOnlineOrder()) {
            System.out.println(order.getId());
            //TODO
        }
    }

    public void editOnlineOrder(String orderId) {
        int id = Integer.parseInt(orderId);
        DataBase.getCurrentRestaurantForAdmin().getOnlineOrderById(id).setStatus("Updated");
        //TODO
    }

    public void showOrderHistory() {
        for (Order allOrder : DataBase.getCurrentRestaurantForAdmin().getAllOrders()) {
            System.out.println(allOrder.getId());
        }
        //TODO
    }
}
