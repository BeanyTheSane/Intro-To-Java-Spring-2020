import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Book extends MediaItem {
    private String author;
    final private long checkoutLengthInDays = 28;
    final private BigDecimal lateFeePerDay = BigDecimal.valueOf(0.25);

    Book(String title, String id, String author) {
        super(title, id);
        this.author = author;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    
    public String getFine(LocalDateTime returnDate) {
        return super.getFine(returnDate, this.lateFeePerDay, this.checkoutLengthInDays);
    }

    public String getDueDate() {     
        return super.getDueDate(this.checkoutLengthInDays);
    }

    public Boolean isOverdue() {
        return super.isOverdue(this.checkoutLengthInDays);
    }

}