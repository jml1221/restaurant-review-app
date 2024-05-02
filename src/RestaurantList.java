import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RestaurantList {
    private List<Restaurant> restaurants;

    public RestaurantList() {
        this.restaurants = new ArrayList<Restaurant>();
    }

    public List<Restaurant> getRestaurantList() {
        return restaurants;
    }

    public void setRestaurantList(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    public Restaurant getRestaurant(String name) {
        for(Restaurant restaurant: restaurants) {
            if(restaurant.getName().equals(name)) {
                return restaurant;
            }
        }
        return null;
    }

    public boolean addRestaurant(String name, String address, String phone, String website, Category category) {
        if(getRestaurant(name) != null) {
            return false;
        }
        return restaurants.add(new Restaurant(name, address, phone, website, category));
    }

    public boolean editRestaurant(String oldName, String newName, String newAddress, String newPhone, String newWebsite, Category newCategory) {
        Restaurant oldRestaurant = getRestaurant(oldName);
        if(oldRestaurant == null) {
            return false;
        }
        oldRestaurant.setName(newName);
        oldRestaurant.setAddress(newAddress);
        oldRestaurant.setPhone(newPhone);
        oldRestaurant.setWebsite(newWebsite);
        oldRestaurant.setCategory(newCategory);
        return true;
    }

    public boolean deleteRestaurant(Restaurant restaurant) {
        if(restaurant == null) {
            return false;
        }
        return restaurants.remove(restaurant);
    } 
    
    public RestaurantList getRestaurantsOfCategory(Category category) {
        RestaurantList restaurantsByCategory = new RestaurantList();
        for(Restaurant restaurant: restaurants) {
            if(restaurant.getCategory() == category) {
                restaurantsByCategory.addRestaurant(restaurant.getName(), null, null, null, category);
            }
        }
        return restaurantsByCategory;
    }

    public void printPopularRestaurants() {
        restaurants.sort(null);
        int i = 1;
        System.out.println("Most popular restaurants:");
        for(Restaurant restaurant: restaurants) {
            System.out.println(i + ": " + restaurant.getName());
            if(i == 10) {
                break;
            }
        }
    }

    public void printAllRestaurants() {
        System.out.println("All restaurants:");
        for(Restaurant restaurant: restaurants) {
            System.out.println(restaurant.getName());
        }
    }
}