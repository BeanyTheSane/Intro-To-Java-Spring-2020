import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class MediaItem {
    protected String        title;
    protected String        id;
    protected LocalDateTime checkoutDate;

    MediaItem(String title, String id) {
        this.title = title;
        this.id = id;
        this.checkoutDate = LocalDateTime.now();
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getCheckoutDate() {
        return this.checkoutDate;
    }

    public void setCheckoutDate(LocalDateTime checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    protected String getDueDate(long checkoutLengthInDays) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        LocalDateTime dueDate = this.checkoutDate.plusDays(checkoutLengthInDays);
        return formatter.format(dueDate);
    };

    protected Boolean isOverdue(long checkoutLengthInDays) {
        LocalDateTime today = LocalDateTime.now();
        if (today.isAfter(this.checkoutDate.plusDays(checkoutLengthInDays))) {
            return true;
        } 
        return false;
    };

    protected String getFine(LocalDateTime returnDate, BigDecimal lateFeePerDay, long checkoutLengthInDays) {
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
        int differenceInDays = 0;
        BigDecimal fine = BigDecimal.valueOf(0);

        if (returnDate.isAfter(this.checkoutDate.plusDays(checkoutLengthInDays))) {
            differenceInDays = returnDate.getDayOfYear() - checkoutDate.getDayOfYear();
            fine = lateFeePerDay.multiply(BigDecimal.valueOf(differenceInDays));
        }
        return currencyFormatter.format(fine);
    }
    
}