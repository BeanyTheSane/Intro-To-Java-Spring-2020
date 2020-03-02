import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Test {
    final Scanner myScanner = new Scanner(System.in);
    Library library = new Library();
    Patron testPatron = new Patron();
    ArrayList<Patron> patronsList = new ArrayList<>();
    HashMap<String, ArrayList<MediaItem>> mediaItems = new HashMap<>();
    MediaItem testBook = new Book("Test Book", "1234", "Author Test");
    MediaItem testDvd = new Dvd("Test DVD", "9876", "PG");

    private void cleanseGlobals() {
        this.library = new Library();
        this.testPatron = new Patron();
        this.patronsList = new ArrayList<>();
        this.testBook = new Book("Test Book", "1234", "Author Test");
        this.testDvd = new Dvd("Test DVD", "9876", "PG");
        this.mediaItems = new HashMap<>();
    }

    public void runAllQuick() {
        System.out.println(can_add_a_patron_to_the_library());
        System.out.println(can_remove_a_patron_from_the_library());
        System.out.println(can_add_a_book_to_the_library());

        System.out.println("Press Enter to continue...");
        myScanner.nextLine();
    }

    private String can_add_a_patron_to_the_library() {
        cleanseGlobals();
        testPatron.setId("1234");
        library.addPatron(testPatron);
        this.patronsList = library.getPatrons();
        Patron tP = this.patronsList.get(0);
        if (tP.getId().equals("1234")) {
            return "PASSED";
        }
        return "FAILED";
    }

    private String can_remove_a_patron_from_the_library() {
        cleanseGlobals();
        library.addPatron(testPatron);
        library.removePatron(testPatron);
        this.patronsList = library.getPatrons();
        if (!this.patronsList.contains(testPatron)) {
            return "PASSED";
        }
        return "FAILED";
    }

    private String can_add_a_book_to_the_library() {
        cleanseGlobals();
        library.addMediaItem(testBook);
        this.mediaItems = library.getIneventory();
        if (this.mediaItems.containsKey("book")
         && (this.mediaItems.get("book")).contains(testBook)) {
            return "PASSED";
        }
        return "FAILED";
    }
}