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

    public void setCheckoutList(ArrayList<MediaItem> checkoutList) {
        this.checkoutList = checkoutList;
    }
}