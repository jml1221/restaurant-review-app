import java.util.*;

public class Main {
    public static void main(String[] args) {
        RestaurantList restaurantList = new RestaurantList();
        Admin admin = new Admin();
        int loginChoice = 0;
        while(loginChoice != 3) {
            Scanner kb = new Scanner(System.in);
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
                        System.out.println("(1) Browse popular restaurant details");
                        System.out.println("(2) Browse restaurants by category");
                        System.out.println("(3) Search restaurant by name");
                        System.out.println("(4) Log out");
                        System.out.print("Enter your choice: ");
                        userChoice = kb.nextInt();
                        kb.nextLine();

                        switch(userChoice) {
                            case 1:
                                System.out.println("User Main Window --> Browse popular restaurant details");
                                System.out.println("===========================================================================");
                                System.out.print("Enter the name of the restaurant you would like to view: ");
                                String restaurant = kb.nextLine();
                                user.searchRestaurants(restaurantList, restaurant).printDetails();

                                System.out.println("Choose one of the following options:");
                                System.out.println("(1) Add a review");
                                System.out.println("(2) Go back to User Main Window");
                                System.out.print("Enter your choice: ");
                                int reviewChoice = kb.nextInt();
                                kb.nextLine();
                                if(reviewChoice == 1) {
                                    System.out.println("User Main Window --> Browse popular restaurant details --> Add a Review");
                                
                                    System.out.println("===========================================================================");
                                    System.out.print("Enter your review for the restaurant: ");
                                    String comment = kb.nextLine();
                                    System.out.print("Enter your rating (1-5) for the restaurant: ");
                                    int rating = kb.nextInt();
                                    kb.nextLine();
                                    if(user.addReview(restaurantList, restaurant, comment, rating)) {
                                        System.out.println("Review added! Press Enter to back to Main Window");
                                    } else {
                                        System.out.println("Review was not added. Make sure your rating is 1-5. Press Enter to back to Main Window");
                                    }
                                    kb.nextLine();
                                }
                                break;

                        }
                    }
                    
            }
        }
    }
}