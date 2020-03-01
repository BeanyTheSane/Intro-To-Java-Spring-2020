import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class MediaItem {
    protected String        title;
    protected String        id;
    protected LocalDateTime checkoutDate;
    protected LocalDateTime returnDate;
    protected Boolean       checkedOut;

    MediaItem(String title, String id) {
        this.title = title;
        this.id = id;
        this.checkoutDate = null;
        this.returnDate = null;
        this.checkedOut = false;
    }

    protected String getTitle() {
        return this.title;
    }

    protected void setTitle(String title) {
        this.title = title;
    }

    protected String getId() {
        return this.id;
    }

    protected void setId(String id) {
        this.id = id;
    }

    protected LocalDateTime getCheckoutDate() {
        return this.checkoutDate;
    }

    protected LocalDateTime getReturnDate() {
        return this.returnDate;
    }

    protected Boolean checkoutMedia(LocalDateTime checkoutDate) {
        if (!this.checkedOut) {
            this.checkoutDate = checkoutDate;
            this.checkedOut = true;
            return true;
        }
        return false;
    }

    protected Boolean returnMedia(LocalDateTime returnDate) {
        if (this.checkedOut) {
            this.returnDate = returnDate;
            this.checkedOut = false;
            return true;
        }
        return false;
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

    protected BigDecimal getFine(BigDecimal lateFeePerDay, long checkoutLengthInDays) {
        int differenceInDays = 0;

        if (this.returnDate.isAfter(this.checkoutDate.plusDays(checkoutLengthInDays))) {
            differenceInDays = this.returnDate.getDayOfYear() - this.checkoutDate.getDayOfYear();
            return lateFeePerDay.multiply(BigDecimal.valueOf(differenceInDays));
        }
        return BigDecimal.valueOf(0);
    }
    
}