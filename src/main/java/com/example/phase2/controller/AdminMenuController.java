package  com.example.phase2.controller;
import com.example.phase2.model.Node;
import com.example.phase2.model.Admin;
import com.example.phase2.model.DataBase;
import com.example.phase2.model.Restaurant;

public class AdminMenuController {
    public AdminMenuController() {}
    public void addRestaurant(String restaurantName, String location){
        Node node = DataBase.getNodeByName(location);
        Restaurant restaurant = new Restaurant(restaurantName,node);
        DataBase.getCurrentAdmin().addRestaurant(restaurant);
        DataBase.addRestaurant(restaurant);
        System.out.println("restaurant added successfully");
    }
    public void showAllRestaurants(){
        System.out.println("restaurants are:");
        for (String restaurantName : DataBase.getCurrentAdmin().getRestaurantsSorted()) {
            System.out.println(restaurantName);
        }
    }
    public void selectRestaurant(String restaurantName){
    }
}
