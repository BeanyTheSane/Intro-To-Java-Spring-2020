import java.math.BigDecimal;

public class Book extends MediaItem {
    private String              author;
    final private long          checkoutLengthInDays    = 28;
    final private BigDecimal    lateFeePerDay           = BigDecimal.valueOf(0.25);

    Book(String title, String id, String author) {
        super(title, id, "book");
        this.author = author;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    
    public BigDecimal getFine() {
        return super.getFine(this.lateFeePerDay, this.checkoutLengthInDays);
    }

    public String getDueDate() {     
        return super.getDueDate(this.checkoutLengthInDays);
    }

    public Boolean isOverdue() {
        return super.isOverdue(this.checkoutLengthInDays);
    }

    public long getCheckoutLengthInDays() {
        return this.checkoutLengthInDays;
    }

}