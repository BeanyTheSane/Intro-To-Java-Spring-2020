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
        System.out.println("Press Enter to continue...");
        myScanner.nextLine();
    
        System.out.println("\nBook Class Tests\n");
        System.out.println("gets correct fine                   ->      " + gets_correct_fine());
        System.out.println("gets correct due date               ->      " + gets_correct_due_date());
        System.out.println("checks if overdue or not            ->      " + checks_if_overdue_or_not());
        System.out.println("can checkout                        ->      " + can_check_out());
        System.out.println("can return                          ->      " + can_return());
        System.out.println("Press Enter to continue...");
        myScanner.nextLine();
    
        System.out.println("\nDvd Class Tests\n");
        System.out.println("gets correct fine                   ->      " + gets_correct_fine_dvd());
        System.out.println("gets correct Due Date               ->      " + gets_correct_due_date_dvd());
        System.out.println("checks if overdue or not            ->      " + checks_if_overdue_or_not_dvd());
        System.out.println("Press Enter to continue...");
        myScanner.nextLine();
    
        System.out.println("\nPatron Class Tests\n");
        System.out.println("can get total fines                 ->      " + can_get_total_fines());
        System.out.println("can get overdue media list          ->      " + can_get_overdue_media_list());
        System.out.println("gets list of checked out media      ->      " + gets_list_of_checked_out_media());

        System.out.println("Press Enter to continue...");
        myScanner.nextLine();
    }

    private String gets_list_of_checked_out_media() {
        cleanseGlobals();
        MediaItem notAnOverdueBook = new Book("Other Book", "9516", "Writer Guy");
        this.testPatron.checkoutMedia(this.testBook);
        this.testPatron.checkoutMedia(this.testDvd);
        this.testPatron.checkoutMedia(notAnOverdueBook);
        ArrayList<MediaItem> overdueMedia = this.testPatron.getCheckoutList();
        if (overdueMedia.contains(this.testBook)
        && overdueMedia.contains(this.testDvd)
        && overdueMedia.contains(notAnOverdueBook)) {
            return "PASSED";
        }
        return "FAILED";
    }

    private String can_get_overdue_media_list() {
        cleanseGlobals();
        MediaItem notAnOverdueBook = new Book("Other Book", "9516", "Writer Guy");
        this.testPatron.checkoutMedia(this.testBook);
        this.testPatron.checkoutMedia(this.testDvd);
        this.testPatron.checkoutMedia(notAnOverdueBook);
        this.testBook.setCheckoutDate(LocalDateTime.now().minusDays(((Book) this.testBook).getCheckoutLengthInDays() + 10));
        this.testDvd.setCheckoutDate(LocalDateTime.now().minusDays(((Dvd) this.testDvd).getCheckoutLengthInDays() + 10));
        ArrayList<MediaItem> overdueMedia = this.testPatron.getListOfOverdueMedia();
        if (overdueMedia.contains(this.testBook)
        && overdueMedia.contains(this.testDvd)
        && !overdueMedia.contains(notAnOverdueBook)) {
            return "PASSED";
        }
        return "FAILED";
    }

    private String can_get_total_fines() {
        cleanseGlobals();
        this.testPatron.checkoutMedia(this.testBook);
        this.testPatron.checkoutMedia(this.testDvd);
        this.testBook.setCheckoutDate(LocalDateTime.now().minusDays(((Book) this.testBook).getCheckoutLengthInDays() + 10));
        this.testDvd.setCheckoutDate(LocalDateTime.now().minusDays(((Dvd) this.testDvd).getCheckoutLengthInDays() + 10));
        this.testPatron.returnMedia(this.testBook);
        this.testPatron.returnMedia(this.testDvd);

        BigDecimal totalFine = this.testPatron.getTotalFine();
        if (totalFine.equals(BigDecimal.valueOf(1250, 2))) {
            return "PASSED";
        }
        return "FAILED";
    }


    private String checks_if_overdue_or_not_dvd() {
        cleanseGlobals();
        Long checkoutLengthInDays = ((Dvd) this.testDvd).getCheckoutLengthInDays();
        this.checkoutDate = LocalDateTime.of(2020, 01, 01, 9, 00);
        ArrayList<LocalDateTime> overdueDates = new ArrayList<>();
        ArrayList<LocalDateTime> notOverdueDates = new ArrayList<>();
        notOverdueDates.add(LocalDateTime.now().minusDays(1));
        notOverdueDates.add(LocalDateTime.now().minusDays(checkoutLengthInDays));
        overdueDates.add(LocalDateTime.now().minusDays(checkoutLengthInDays + 1));
        overdueDates.add(LocalDateTime.now().minusDays(checkoutLengthInDays +10));

        for (LocalDateTime checkoutDate : notOverdueDates) {
            this.testDvd.checkoutMedia(checkoutDate);
            if (!((Dvd) this.testDvd).isOverdue()) {
                this.testDvd = new Dvd("Test DVD", "9876", "PG");
            } else {
                return "FAILED";
            }
        }
        for (LocalDateTime checkoutDate : overdueDates) {
            this.testDvd.checkoutMedia(checkoutDate);
            if (((Dvd) this.testDvd).isOverdue()) {
                this.testDvd = new Dvd("Test DVD", "9876", "PG");
            } else {
                return "FAILED";
            }
        }
        return "PASSED";
    }

    private String gets_correct_due_date_dvd() {
        cleanseGlobals();
        this.checkoutDate = LocalDateTime.now();
        this.testDvd.checkoutMedia(checkoutDate);
        LocalDateTime compareDate = this.checkoutDate.plusDays(((Dvd) this.testDvd).getCheckoutLengthInDays());
        if (((Dvd) this.testDvd).getDueDate().equals(this.formatter.format(compareDate))) {
            return "PASSED";
        }
        return "FAILED";    }

    private String gets_correct_fine_dvd() {
        cleanseGlobals();
        this.checkoutDate = LocalDateTime.of(2020, 01, 01, 9, 00);
        this.returnDate = LocalDateTime.of(2020, 01, 18, 9, 00);
        this.testDvd.setCheckoutDate(this.checkoutDate);
        this.testDvd.setReturnDate(this.returnDate);
        BigDecimal testFine = ((Dvd) this.testDvd).getFine();
        if (testFine.equals(BigDecimal.valueOf(10))) {
            return "PASSED";
        }
        return "FAILED";
    }

    private String can_return() {
        cleanseGlobals();
        this.testBook.checkoutMedia(LocalDateTime.now());
        this.testBook.returnMedia(LocalDateTime.now());
        if (!this.testBook.isCheckedOut()) {
            return "PASSED";
        }
        return "FAILED";
    }

    private String can_check_out() {
        cleanseGlobals();
        this.testBook.checkoutMedia(LocalDateTime.now());
         if (this.testBook.isCheckedOut()) {
             return "PASSED";
         }
        return "FAILED";
    }

    private String checks_if_overdue_or_not() {
        cleanseGlobals();
        Long checkoutLengthInDays = ((Book) this.testBook).getCheckoutLengthInDays();
        this.checkoutDate = LocalDateTime.of(2020, 01, 01, 9, 00);
        ArrayList<LocalDateTime> overdueDates = new ArrayList<>();
        ArrayList<LocalDateTime> notOverdueDates = new ArrayList<>();
        notOverdueDates.add(LocalDateTime.now().minusDays(1));
        notOverdueDates.add(LocalDateTime.now().minusDays(checkoutLengthInDays));
        overdueDates.add(LocalDateTime.now().minusDays(checkoutLengthInDays + 1));
        overdueDates.add(LocalDateTime.now().minusDays(checkoutLengthInDays +10));

        for (LocalDateTime checkoutDate : notOverdueDates) {
            this.testBook.checkoutMedia(checkoutDate);
            if (!((Book) this.testBook).isOverdue()) {
                this.testBook = new Book("Test Book", "1234", "Author Test");
            } else {
                return "FAILED";
            }
        }
        for (LocalDateTime checkoutDate : overdueDates) {
            this.testBook.checkoutMedia(checkoutDate);
            if (((Book) this.testBook).isOverdue()) {
                this.testBook = new Book("Test Book", "1234", "Author Test");
            } else {
                return "FAILED";
            }
        }
        return "PASSED";
    }

    private String gets_correct_due_date() {
        cleanseGlobals();
        this.checkoutDate = LocalDateTime.now();
        this.testBook.checkoutMedia(checkoutDate);
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
        if (testFine.equals(BigDecimal.valueOf(((long)250), 2))) {
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