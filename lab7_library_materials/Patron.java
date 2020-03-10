import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Patron {
    private String id;
    private String name;
    private ArrayList<MediaItem> checkoutList = new ArrayList<>();
    private BigDecimal totalFine;

    Patron() {
        this.id = "1234";
        this.name = "Tester";
        this.totalFine = BigDecimal.valueOf(0);
    }

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
        if (!mediaItem.isCheckedOut() && !this.checkoutList.contains(mediaItem)) {
            mediaItem.checkoutMedia(LocalDateTime.now());
            this.checkoutList.add(mediaItem);
            return true;
        }
        return false;
    }

    public Boolean returnMedia(MediaItem mediaItem) {
        if (mediaItem.isCheckedOut() && this.checkoutList.contains(mediaItem)) {
            mediaItem.returnMedia(LocalDateTime.now());
            if (mediaItem instanceof Book
            && ((Book) mediaItem).isOverdue()) {
                this.totalFine = this.totalFine.add(((Book) mediaItem).getFine());
            } else if (mediaItem instanceof Dvd
            && ((Dvd) mediaItem).isOverdue()) {
                this.totalFine = this.totalFine.add(((Dvd) mediaItem).getFine());
            }
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

    public BigDecimal getTotalFine() {
        return this.totalFine;
    }
}