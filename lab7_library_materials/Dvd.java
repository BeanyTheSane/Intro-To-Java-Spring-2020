import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Dvd extends MediaItem {
    private String rating;
    final private long checkoutLengthInDays = 7;
    final private BigDecimal lateFeePerDay = BigDecimal.valueOf(1);

    Dvd (String title, String id, String rating) {
        super(title, id, "dvd");
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

    public boolean isOverdue() {
        LocalDateTime today = LocalDateTime.now();
        LocalDateTime compareDate = this.checkoutDate.plusDays(this.checkoutLengthInDays + 1);
        int todaysDayCount = today.getDayOfYear();
        int compareDayCount = compareDate.getDayOfYear();
        if (todaysDayCount >= compareDayCount) {
            // System.out.println("MediaItem is overdue " + compareDate);
            return true;
        } 
        // System.out.println("MediaItem is NOT overdue " + compareDate);
        return false;
    }

    public long getCheckoutLengthInDays() {
        return this.checkoutLengthInDays;
    }
}
