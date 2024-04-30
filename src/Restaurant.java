public class Restaurant {
    private String name;
    private String address;
    private String phone;
    private String website;
    private Category category;
    private int rating;
    private ReviewList reviewList;

    public Restaurant(String name) {
        this.name = name;
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

    public ReviewList getReviewList() {
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

    public boolean addReview (String content, int rating) {
        return true;
    }
}

