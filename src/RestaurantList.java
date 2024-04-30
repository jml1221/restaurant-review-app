import java.util.List;

public class RestaurantList {
    private List<Restaurant> restaurants;

    public Restaurant add(String name) {
        return new Restaurant(name);
    }

    public List<Restaurant> searchByName(String name) {
        return null;
    }

    public boolean delete(Restaurant restaurant) {
        return true;
    } 

    public List<Restaurant> listAllRestaurantsByName() {
        return null;
    }
    
    public List<Restaurant> listAllRestaurantsByCategory() {
        return null;
    }
}
