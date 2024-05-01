public class Admin {
    public Admin() {
    }

    public boolean addRestaurant(RestaurantList restaurantList, String name, String address, String phone, String website, Category category) {
        return restaurantList.addRestaurant(name, address, phone, website, category);
    }

    public boolean editRestaurant(RestaurantList restaurantList, String oldName, String newName, String newAddress, String newPhone, String newWebsite, Category newCategory) {
        return restaurantList.editRestaurant(oldName, newName, newAddress, newPhone, newWebsite, newCategory);
    }

    public boolean deleteRestaurant(RestaurantList restaurantList, String name) {
        return restaurantList.deleteRestaurant(restaurantList.getRestaurant(name));
    }
}

