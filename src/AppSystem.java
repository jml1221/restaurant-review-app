import java.util.Scanner;

public class AppSystem {
    private Admin admin;
    private RestaurantList restaurantList;
    private Scanner kb;

    public AppSystem() {
        this.admin = new Admin();
        this.restaurantList = new RestaurantList();
        this.kb = new Scanner(System.in);
    }

    public void runSystem() {
        int loginChoice = 0;
        while(loginChoice != 3) {
            System.out.println("Login:");
            System.out.println("==============");
            System.out.println("Choose one of the following options:");
            System.out.println("(1) Log in as user");
            System.out.println("(2) Log in as admin");
            System.out.println("(3) Quit");
            System.out.print("Enter your choice: ");
            loginChoice = kb.nextInt();
            kb.nextLine();
            switch(loginChoice) {
                case 1:
                    System.out.println("Login as User");
                    System.out.println("===========================================================================");
                    System.out.print("Enter your username: ");
                    User user = new User(kb.nextLine());
                    
                    int userChoice = 0;
                    while(userChoice != 4) {
                        System.out.println("User Main Window");
                        System.out.println("===========================================================================");
                        user.printPopularRestaurants(restaurantList);
                        System.out.println("Choose one of the following options:");
                        System.out.println("(1) Browse restaurant details");
                        System.out.println("(2) Browse restaurants by category");
                        System.out.println("(3) Search restaurant by name");
                        System.out.println("(4) Log out");
                        System.out.print("Enter your choice: ");
                        userChoice = kb.nextInt();
                        kb.nextLine();

                        switch(userChoice) {
                            case 1:
                                browseRestaurantAddReview(user, kb, restaurantList);
                                break;
                            case 2:
                                System.out.println("Browse Restaurants by Category");
                                System.out.println("===========================================================================");
                                System.out.println("Choose one of the following categories: ");
                                printCategories();
                                System.out.print("Enter the number of the category: ");
                                Category category = Category.values()[kb.nextInt() - 1];
                                kb.nextLine();
                                user.getRestaurantsOfCategory(restaurantList, category).printAllRestaurants();;
                                
                                System.out.println("Choose one of the following options:");
                                System.out.println("(1) Browse restaurant details");
                                System.out.println("(2) Go back to User Main Window");
                                System.out.print("Enter your choice: ");
                                int browseChoice = kb.nextInt();
                                kb.nextLine();
                                if(browseChoice == 1) {
                                    browseRestaurantAddReview(user, kb, restaurantList);
                                }
                                break;
                            case 3:
                                System.out.println("Search restaurant by name");
                                System.out.println("===========================================================================");
                                System.out.print("Enter the restaurant name: ");
                                String restaurantString = kb.nextLine();
                                Restaurant restaurant = user.getRestaurant(restaurantList, restaurantString);
                                if(restaurant == null) {
                                    System.out.println("There is no restaurant with the entered name");
                                } else {
                                    restaurant.printDetails();
                                }
                                System.out.println("Press Enter to go back to the User Main Window");
                                kb.nextLine();
                                break;
                        }
                    }
                    break;
                case 2:
                    int adminChoice = 0;
                    while(adminChoice != 4) {
                        System.out.println("Admin Main Window");
                        System.out.println("===========================================================================");
                        System.out.println("Choose one of the following options:");
                        System.out.println("(1) Add a new restaurant");
                        System.out.println("(2) Edit a restaurant");
                        System.out.println("(3) Delete a restaurant");
                        System.out.println("(4) Log out");
                        System.out.print("Enter your choice: ");
                        adminChoice = kb.nextInt();
                        kb.nextLine();
                        switch(adminChoice) {
                            case 1:
                                System.out.println("Add a New Restaurant (Enter the following information)");
                                System.out.println("===========================================================================");
                                System.out.print("Name: ");
                                String name = kb.nextLine();
                                System.out.print("Address: ");
                                String address = kb.nextLine();
                                System.out.print("Phone: ");
                                String phone = kb.nextLine();
                                System.out.print("Website: ");
                                String website = kb.nextLine();
                                printCategories();
                                System.out.print("Category: ");
                                Category category = Category.values()[kb.nextInt() - 1];
                                kb.nextLine();
                                
                                if(admin.addRestaurant(restaurantList, name, address, phone, website, category)) {
                                    System.out.println("---------------------------------------------------------------------------");
                                    System.out.println("Restaurant added! Press Enter to go back to the Admin Main Window");
                                } else {
                                    System.out.println("---------------------------------------------------------------------------");
                                    System.out.println("Restaurant with entered name already exists. Press Enter to go back to the Admin Main Window");
                                }
                                kb.nextLine();
                                break;
                            case 2:
                                admin.printAllRestaurants(restaurantList);
                                System.out.println("Edit a Restaurant");
                                System.out.println("===========================================================================");
                                System.out.print("Enter the restaurant name: ");
                                String oldName = kb.nextLine();
                                Restaurant restaurant = admin.getRestaurant(restaurantList, oldName);
                                if(restaurant == null) {
                                    System.out.println("There is no restaurant with the entered name. Press Enter to go back to the Admin Main Window");
                                } else {
                                    restaurant.printDetails();
                                    System.out.println("---------------------------------------------------------------------------");
                                    System.out.println("Enter the following new information:");
                                    System.out.print("Name: ");
                                    String newName = kb.nextLine();
                                    System.out.print("Address: ");
                                    String newAddress = kb.nextLine();
                                    System.out.print("Phone: ");
                                    String newPhone = kb.nextLine();
                                    System.out.print("Website: ");
                                    String newWebsite = kb.nextLine();
                                    printCategories();
                                    System.out.print("Category: ");
                                    Category newCategory = Category.values()[kb.nextInt() - 1];
                                    kb.nextLine();
                                    admin.editRestaurant(restaurantList, oldName, newName, newAddress, newPhone, newWebsite, newCategory);
                                    System.out.println("---------------------------------------------------------------------------");
                                    System.out.println("Restaurant edited! Press Enter to go back to the Admin Main Window");
                                }
                                kb.nextLine();
                                break;
                            case 3:
                                admin.printAllRestaurants(restaurantList);
                                System.out.println("Delete a Restaurant");
                                System.out.println("===========================================================================");
                                System.out.print("Enter the restaurant name: ");
                                if(admin.deleteRestaurant(restaurantList, kb.nextLine())) {
                                    System.out.println("Restaurant deleted! Press Enter to go back to the Admin Main Window");
                                } else {
                                    System.out.println("There is no restaurant with the entered name. Press Enter to go back to the Admin Main Window");
                                }
                                kb.nextLine();
                                break;
                        }
                    }
                    break;
            }
        }
    }

    private void printCategories() {
        System.out.println("Enter the number of one of the following categories: ");
        int index = 1;
        for(Category c: Category.values()) {
            System.out.println("(" + index + ") " + c.getDescription());
            index++;
        }
    }

    private void browseRestaurantAddReview(User user, Scanner kb, RestaurantList restaurantList) {
        System.out.println("Browse Restaurant Details");
        System.out.println("===========================================================================");
        System.out.print("Enter the name of the restaurant you would like to view: ");
        String restaurant = kb.nextLine();
        user.getRestaurant(restaurantList, restaurant).printDetails();

        System.out.println("Choose one of the following options:");
        System.out.println("(1) Add a review");
        System.out.println("(2) Go back to User Main Window");
        System.out.print("Enter your choice: ");
        int reviewChoice = kb.nextInt();
        kb.nextLine();
        if(reviewChoice == 1) {
            System.out.println("Add a Review");
        
            System.out.println("===========================================================================");
            System.out.print("Enter your review for the restaurant: ");
            String comment = kb.nextLine();
            System.out.print("Enter your rating (1-5) for the restaurant: ");
            int rating = kb.nextInt();
            kb.nextLine();
            if(user.addReview(restaurantList, restaurant, comment, rating)) {
                System.out.println("Review added! Press Enter to back to the User Main Window");
            } else {
                System.out.println("Review was not added. Make sure your rating is 1-5. Press Enter to back to the User Main Window");
            }
            kb.nextLine();
        }
    }
}
