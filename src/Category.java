public enum Category {
    FINE_DINING("Fine Dining"),
    CASUAL_DINING("Casual Dining"),
    FAST_CASUAL("Fast Casual"),
    FAST_FOOD("Fast Food"),
    ETHNIC("Ethnic"),
    CAFES("Cafés"),
    BAR_AND_GRILL("Bar and Grill"),
    BUFFET("Buffet");

    private String description;

    Category(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
}
