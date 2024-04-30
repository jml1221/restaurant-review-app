import java.util.List;

public class ReviewList {
    private List<Review> reviews;
    
    public boolean addReview(String content, int rating) {
        return true;
    }

    public List<Review> listAllReviews() {
        return reviews;
    }

    public int getRating() {
        return 0;
    }
}
