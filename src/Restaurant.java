import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Restaurant implements Comparable<Restaurant> {
    private String name;
    private String address;
    private String phone;
    private String website;
    private int rating;
    private Category category;
    private List<Review> reviewList;

    public Restaurant(String name, String address, String phone, String website, Category category) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.website = website;
        this.rating = -1; // no rating initially
        this.category = category;
        this.reviewList = new ArrayList<Review>();
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getWebsite() {
        return website;
    }

    public Category getCategory() {
        return category;
    }

    public int getRating() {
        return rating;
    }

    public List<Review> getReviewList() {
        return reviewList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public boolean addReview (String content, int rating, String userName) {
        if(rating >= 0 && rating <= 5) {
            reviewList.add(new Review(content, rating, userName));

            int totalRatings = 0;
            for(Review review: reviewList) {
                totalRatings += review.getRating();
            }
            setRating(Math.round(totalRatings / reviewList.size()));
            return true;
        }
        return false;
    }

    @Override public int compareTo(Restaurant restaurant) {
        return restaurant.getRating() - this.getRating();
    }

    public void printDetails() {
        System.out.print("Name: " + name + " | Address: " + address + " | Phone: " + phone + " | Website: " + website + " | Category: " + category.getDescription());
        if(rating == -1) {
            System.out.println(" | Rating: No rating yet");
        } else {
            System.out.println(" | Rating: " + rating);
        }
        System.out.println("Reviews:");
        if(reviewList.size() == 0) {
            System.out.println("No reviews yet");
        }
        for(Review review: reviewList) {
            review.printDetails();
        }
    }
}

