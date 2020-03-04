import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class MediaItem {
    protected String        title;
    protected String        id;
    protected String        mediaType;
    protected LocalDateTime checkoutDate;
    protected LocalDateTime returnDate;
    protected Boolean       checkedOut;

    MediaItem(String title, String id, String mediaType) {
        this.title = title;
        this.id = id;
        this.mediaType = mediaType;
        this.checkoutDate = LocalDateTime.of(1777, 02, 02, 02, 02, 02);
        this.returnDate = LocalDateTime.of(1777, 02, 02, 02, 02, 02);
        this.checkedOut = false;
    }

    public String getMediaType() {
        return this.mediaType;
    }

    public Boolean isCheckedOut() {
        return this.checkedOut;
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

	protected void setCheckoutDate(LocalDateTime checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    protected void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
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

    protected LocalDateTime getDueDateRaw(long checkoutLengthInDays) {
        return this.checkoutDate.plusDays(checkoutLengthInDays);
    };

    protected Boolean isOverdue(long checkoutLengthInDays) {
        LocalDateTime today = LocalDateTime.now();
        if (today.isAfter(this.checkoutDate.plusDays(checkoutLengthInDays + 1))) {
            return true;
        } 
        return false;
    };

    protected BigDecimal getFine(BigDecimal lateFeePerDay, long checkoutLengthInDays) {
        int differenceInDays = 0;

        if (this.returnDate.isAfter(this.checkoutDate.plusDays(checkoutLengthInDays))) {
            differenceInDays = this.returnDate.getDayOfYear() - this.getDueDateRaw(checkoutLengthInDays).getDayOfYear();
            return lateFeePerDay.multiply(BigDecimal.valueOf(differenceInDays));
        }
        return BigDecimal.valueOf(0);
    }
    
}