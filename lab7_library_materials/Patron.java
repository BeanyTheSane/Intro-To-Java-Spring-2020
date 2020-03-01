import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Patron {
    private String id;
    private String name;
    private ArrayList<MediaItem> checkoutList = new ArrayList<>();

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<MediaItem> getCheckoutList() {
        return this.checkoutList;
    }

    //The bool that these return can be used to determine if the addition or deltion is succesful
    public Boolean checkoutMedia(MediaItem mediaItem) {
        if (!this.checkoutList.contains(mediaItem)) {
            this.checkoutList.add(mediaItem);
            return true;
        }
        return false;
    }

    public Boolean returnMedia(MediaItem mediaItem) {
        if (this.checkoutList.contains(mediaItem)) {
            this.checkoutList.remove(mediaItem);
            return true;
        }
        return false;
    }

    public ArrayList<MediaItem> getListOfOverdueMedia() {
        ArrayList<MediaItem> overdueMedia = new ArrayList<>();

        for (MediaItem mediaItem : this.checkoutList) {
            if (mediaItem instanceof Book) {
                if (((Book) mediaItem).isOverdue()) {
                    overdueMedia.add(mediaItem);
                }
            } else if (mediaItem instanceof Dvd) {
                if (((Dvd) mediaItem).isOverdue()) {
                    overdueMedia.add(mediaItem);
                }
            }
        }

        return overdueMedia;
    }

    public String getTotalFine() {
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
        BigDecimal totalFine = BigDecimal.valueOf(0);

        for (MediaItem mediaItem : this.checkoutList) {
            if (mediaItem instanceof Book) {
                Book book = ((Book) mediaItem);
                if (book.isOverdue()) {
                    totalFine.add(book.getFine());
                }
            } else if (mediaItem instanceof Dvd) {
                Dvd dvd = ((Dvd) mediaItem);
                if (dvd.isOverdue()) {
                    totalFine.add(dvd.getFine());
                }
            }
        }
        return currencyFormatter.format(totalFine);
    }
}