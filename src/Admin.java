public class Admin implements Person {

    public Admin() {

    }

    public Restaurant addRestaurant(String name) {

        return new Restaurant(name);
    }

    public Restaurant getRestaurant(String name) {

        return null;
    }

    public boolean deleteRestaurant(String name) {

        return true;
    }
}

