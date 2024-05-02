import java.util.List;

public class User {
    private String userName;

    public User(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public void printPopularRestaurants(RestaurantList restaurantList) {
        restaurantList.printPopularRestaurants();
    }

    public RestaurantList getRestaurantsOfCategory(RestaurantList restaurantList, Category category) {
        return restaurantList.getRestaurantsOfCategory(category);
    }

    public Restaurant getRestaurant(RestaurantList restaurantList, String name) {
        return restaurantList.getRestaurant(name);
    }

    public boolean addReview(RestaurantList restaurantList, String name, String content, int rating) {
        return restaurantList.getRestaurant(name).addReview(content, rating, userName);
    }
}
