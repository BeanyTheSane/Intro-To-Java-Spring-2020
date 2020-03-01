import java.util.ArrayList;
import java.util.HashMap;

public class Library {
    private ArrayList<Patron> patrons;
    private HashMap<String, ArrayList<MediaItem>> ineventory = new HashMap<>();


    public ArrayList<Patron> getPatrons() {
        return this.patrons;
    }

    public void addPatron(Patron patron) {
        if (!patrons.contains(patron)) {
            this.patrons.add(patron);
        }
    }

    public HashMap<String,ArrayList<MediaItem>> getIneventory() {
        return this.ineventory;
    }

    public void addMediaItem(MediaItem mediaItem) {
        String key = mediaItem.getMediaType();
        ArrayList<MediaItem> newList = new ArrayList<>();
        newList = this.ineventory.get(key);
        if (!newList.contains(mediaItem)) {
            newList.add(mediaItem);
        }
        this.ineventory.put(key, newList);
    }

    public void removeMediaItem(MediaItem mediaItem) {
        String key = mediaItem.getMediaType();
        ArrayList<MediaItem> newList = new ArrayList<>();
        newList = this.ineventory.get(key);
        if (newList.contains(mediaItem)){
            newList.remove(mediaItem);
        }
        this.ineventory.put(key, newList);
    }

    public void removePatron(Patron patron) {
        if (this.patrons.contains(patron)) {
            this.patrons.remove(patron);
        }
    }
}