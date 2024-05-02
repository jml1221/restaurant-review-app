public class Review {
    private String content;
    private int rating;
    private String userName;

    public Review(String content, int rating, String userName) {
        this.content = content;
        this.rating = rating;
        this.userName = userName;
    }

    public String getContent() {
        return content;
    }

    public int getRating() {
        return rating;
    }

    public String getUserName() {
        return userName;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void printDetails() {
        System.out.println(userName + ": " + rating + "/5");
        System.out.println(content);
    }
}
