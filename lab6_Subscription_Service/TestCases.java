import java.util.Scanner;

public class TestCases {
    final static Scanner myScanner = new Scanner(System.in);

    public static void runQuickTest() {
        System.out.println("Test 1: All fields constructor test");
        System.out.println(all_fields_constructor_test());
        
    }

    public static void runAllTestsWithDetails() {
        subscriberClassTests();

    }
    
    private static void subscriberClassTests() {
        System.out.println("Subscriber Class Test"
                       + "\nTest 1: All fields constructor test"
                       + "\nGIVEN I build a subscriber with the all fields constructor"
                       + "\nWHEN  I use the getters"
                       + "\nTHEN  I can see the details of the subscriber I created");

        all_fields_constructor_test();
        System.out.println("Press Enter To Continue...");
        myScanner.nextLine();


    }

    private static String all_fields_constructor_test() {
        final String styledSeperator = "<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>";
        Subscriber test = new Subscriber("Luke", "Skywalker", "123 Sandy Way", "Mos Eisley", "Tatooine", "44052");
        if (test.getFirstName().equals("Luke")
         && test.getLastName().equals("Skywalker")
         && test.getAddress().equals("123 Sandy Way")
         && test.getCity().equals("Mos Eisley")
         && test.getState().equals("Tatooine")
         && test.getZip().equals("44052")) {
            return styledSeperator
                          + "\nPASSED"
                          + "\n" + styledSeperator;
        } else {
            return styledSeperator
                          + "\nFAILED"
                          + "\n" + styledSeperator;
        }
    }
}