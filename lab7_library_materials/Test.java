import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Test {
    final Scanner myScanner = new Scanner(System.in);
    final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
    Library library = new Library();
    Patron testPatron = new Patron();
    ArrayList<Patron> patronsList = new ArrayList<>();
    HashMap<String, ArrayList<MediaItem>> mediaItems = new HashMap<>();
    MediaItem testBook = new Book("Test Book", "1234", "Author Test");
    MediaItem testDvd = new Dvd("Test DVD", "9876", "PG");
    Boolean successCheck = false;
    LocalDateTime checkoutDate;
    LocalDateTime returnDate;

    private void cleanseGlobals() {
        this.library = new Library();
        this.testPatron = new Patron();
        this.patronsList = new ArrayList<>();
        this.testBook = new Book("Test Book", "1234", "Author Test");
        this.testDvd = new Dvd("Test DVD", "9876", "PG");
        this.mediaItems = new HashMap<>();
        this.successCheck = false;
        this.checkoutDate = null;
        this.returnDate = null;
    }

    public void runAllQuick() {
        System.out.println("\nLibrary Class Tests\n");
        System.out.println("can add a patron                    ->      " + can_add_a_patron_to_the_library());
        System.out.println("can remove a patron                 ->      " + can_remove_a_patron_from_the_library());
        System.out.println("can add a book                      ->      " + can_add_a_book_to_the_library());
        System.out.println("can remove a book                   ->      " + can_remove_a_book_from_the_library());
        System.out.println("can add a dvd                       ->      " + can_add_a_dvd_to_the_library());
        System.out.println("can remove  dvd                     ->      " + can_remove_a_dvd_from_the_library());
        System.out.println("it returns the full inventory       ->      " + it_returns_the_full_inventory());
        System.out.println("\nBook Class Tests\n");
        System.out.println("gets correct fine                   ->      " + gets_correct_fine());
        System.out.println("gets correct due date               ->      " + gets_correct_due_date());
        System.out.println("checks if overdue                   ->      " + checks_if_overdue());
        System.out.println("can checkout                        ->      " + can_check_out());
        System.out.println("can return                          ->      " + can_return());
        System.out.println("sets the correct return date        ->      " + sets_the_correct_return_date());
        System.out.println("");
        System.out.println("");

        System.out.println("Press Enter to continue...");
        myScanner.nextLine();
    }

    private String gets_correct_due_date() {
        cleanseGlobals();
        this.checkoutDate = LocalDateTime.now();
        LocalDateTime compareDate = this.checkoutDate.plusDays(((Book) this.testBook).getCheckoutLengthInDays());
        if (((Book) this.testBook).getDueDate().equals(this.formatter.format(compareDate))) {
            return "PASSED";
        }
        return "FAILED";
    }

    private String gets_correct_fine() {
        cleanseGlobals();
        this.checkoutDate = LocalDateTime.of(2020, 01, 01, 9, 00);
        this.returnDate = LocalDateTime.of(2020, 02, 8, 9, 00);
        this.testBook.setCheckoutDate(this.checkoutDate);
        this.testBook.setReturnDate(this.returnDate);
        BigDecimal testFine = ((Book) this.testBook).getFine();
        if (testFine.equals(BigDecimal.valueOf(2.5))) {
            return "PASSED";
        }
        return "FAILED";
    }

    private String it_returns_the_full_inventory() {
        cleanseGlobals();
        library.addMediaItem(testDvd);
        library.addMediaItem(testBook);
        this.mediaItems = library.getIneventory();
        if (this.mediaItems.containsKey("dvd")
         && (this.mediaItems.get("dvd")).contains(testDvd)
         && this.mediaItems.containsKey("book")
         && (this.mediaItems.get("book")).contains(testBook)) {
            return "PASSED";
        }
        return "FAILED";
    }

    private String can_remove_a_dvd_from_the_library() {
        cleanseGlobals();
        library.addMediaItem(testDvd);
        library.removeMediaItem(testDvd);
        this.mediaItems = library.getIneventory();
        if (!this.mediaItems.get("dvd").contains(testDvd)) {
            return "PASSED";
        }
        return "FAILED";
    }

    private String can_add_a_dvd_to_the_library() {
        cleanseGlobals();
        library.addMediaItem(testDvd);
        this.mediaItems = library.getIneventory();
        if (this.mediaItems.containsKey("dvd")
         && (this.mediaItems.get("dvd")).contains(testDvd)) {
            return "PASSED";
        }
        return "FAILED";
    }

    private String can_remove_a_book_from_the_library() {
        cleanseGlobals();
        library.addMediaItem(testBook);
        library.removeMediaItem(testBook);
        this.mediaItems = library.getIneventory();
        if (!this.mediaItems.get("book").contains(testBook)) {
            return "PASSED";
        }
        return "FAILED";
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
        successCheck = this.library.addMediaItem(testBook);
        this.mediaItems = this.library.getIneventory();
        if (successCheck = true 
            && this.mediaItems.containsKey("book")
            && (this.mediaItems.get("book")).contains(testBook)) {
            return "PASSED";
        }
        return "FAILED";
    }
}