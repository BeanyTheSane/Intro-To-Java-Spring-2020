import java.math.BigDecimal;
import java.time.LocalDateTime;

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

    public boolean isOverdue() {
        LocalDateTime today = LocalDateTime.now();
        LocalDateTime compareDate = this.checkoutDate.plusDays(this.checkoutLengthInDays + 1);
        int todaysDayCount = today.getDayOfYear();
        int compareDayCount = compareDate.getDayOfYear();
        if (todaysDayCount >= compareDayCount) {
            // System.out.println("MediaItem is overdue " + compareDate);
            return true;
        } else { 
            // System.out.println("MediaItem is NOT overdue " + compareDate + " " + this.getCheckoutDate());
            return false;
        }
    }

    public long getCheckoutLengthInDays() {
        return this.checkoutLengthInDays;
    }

}