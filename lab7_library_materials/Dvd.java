import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Dvd extends MediaItem {
    private String rating;
    final private long checkoutLengthInDays = 7;
    final private BigDecimal lateFeePerDay = BigDecimal.valueOf(1);

    Dvd (String title, String id, String rating) {
        super(title, id);
        this.rating = rating;    
    }

    public String getRating() {
        return this.rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
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
}
