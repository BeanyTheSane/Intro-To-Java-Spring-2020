import java.util.ArrayList;
import java.util.HashMap;

public class Library {
    private ArrayList<Patron> patrons = new ArrayList<>();
    private HashMap<String, ArrayList<MediaItem>> ineventory = new HashMap<>();


    public ArrayList<Patron> getPatrons() {
        return this.patrons;
    }

    public void addPatron(Patron patron) {
        if (!patrons.contains(patron)) {
            this.patrons.add(patron);
        }
    }

    public void removePatron(Patron patron) {
        if (this.patrons.contains(patron)) {
            this.patrons.remove(patron);
        }
    }

    public HashMap<String,ArrayList<MediaItem>> getIneventory() {
        return this.ineventory;
    }

    public Boolean addMediaItem(MediaItem mediaItem) {
        String key = mediaItem.getMediaType();
        ArrayList<MediaItem> newList = this.ineventory.get(key) != null 
                                     ? this.ineventory.get(key) 
                                     : new ArrayList<MediaItem>();
        if (newList == null || !newList.contains(mediaItem)) {
            newList.add(mediaItem);
            this.ineventory.put(key, newList);
            return true;
        }
        this.ineventory.put(key, newList);
        return false;
    }

    public Boolean removeMediaItem(MediaItem mediaItem) {
        String key = mediaItem.getMediaType();
        ArrayList<MediaItem> newList = this.ineventory.get(key) != null 
                                     ? this.ineventory.get(key) 
                                     : new ArrayList<MediaItem>();
        if (newList != null && newList.contains(mediaItem)){
            newList.remove(mediaItem);
            return true;
        }
        this.ineventory.put(key, newList);
        return false;
    }
}