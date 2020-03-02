import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
public class TestCases {
    final static Scanner myScanner = new Scanner(System.in);
    final static String styledSeperator = "<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>";

    public static void runQuickTest() {
        System.out.println("Subscriber Class Tests:");
        System.out.println("    Test 1: All fields constructor test                                 ->      " + all_fields_constructor_test_Subscriber());
        System.out.println("    Test 2: Method for setting/retrieving Full Name                     ->      " + full_name_methods_test_Subscriber());
        System.out.println("StudentSubscriber Class Tests:");
        System.out.println("    Test 1: All fields constructor test                                 ->      " + all_fields_constructor_test_StudentSubscriber());
        System.out.println("Subscription Class Tests:");
        System.out.println("    Test 1: Constructor sets current date                               ->      " + constructor_sets_current_date_when_initiated_Subscription());
        System.out.println("    Test 2: formattedCostOfRenewal returns the correct foramtted cost   ->      " + constructor_sets_current_date_when_initiated_Subscription());
        System.out.println("    Test 3: getExpirationDate returns the correct foramtted date        ->      " + getExpirationDate_returns_the_correct_formatted_date());
    }

    public static void runAllTestsWithDetails() {
        subscriberClassTests();
        studentSubscriberClassTests();
        subscriptionClassTests();
        
    }
    
    private static void subscriptionClassTests() {
        System.out.println("Subscription Class Test"
                       + "\nTest 1: Constructor sets current date"
                       + "\nGIVEN I start a subscription using the constructor"
                       + "\nWHEN  I check the start Date"
                       + "\nTHEN  It matches the date the subscription was created");

        System.out.println(styledSeperator);
        System.out.println(constructor_sets_current_date_when_initiated_Subscription());
        System.out.println(styledSeperator);
        System.out.println("Press Enter To Continue...");
        myScanner.nextLine();

        System.out.print("Test 2: formattedCostOfRenewal returns the correct foramtted cost"
                       + "\nGIVEN I Have a subscription"
                       + "\nWHEN I check the formattedCostOfRenewal"
                       + "\nTHEN It returns the correct formatted cost");

        System.out.println(styledSeperator);
        System.out.println(formattedCostOfRenewal_returns_the_correct_formatted_cost());
        System.out.println(styledSeperator);
        System.out.println("Press Enter To Continue...");
        myScanner.nextLine();

        System.out.print("Test 3: getExpirationDate returns the correct foramtted date"
                       + "\nGIVEN I Have a subscription"
                       + "\nWHEN I check the formattedCostOfRenewal"
                       + "\nTHEN It returns the correct formatted cost");

        System.out.println(styledSeperator);
        System.out.println(getExpirationDate_returns_the_correct_formatted_date());
        System.out.println(styledSeperator);
        System.out.println("Press Enter To Continue...");
        myScanner.nextLine();
    }

    private static void subscriberClassTests() {
        System.out.println("Subscriber Class Test"
                       + "\nTest 1: All fields constructor test"
                       + "\nGIVEN I build a subscriber with the all fields constructor"
                       + "\nWHEN  I use the getters"
                       + "\nTHEN  I can see the details of the subscriber I created");

        System.out.println(styledSeperator);
        System.out.println(all_fields_constructor_test_Subscriber());
        System.out.println(styledSeperator);
        System.out.println("Press Enter To Continue...");
        myScanner.nextLine();

        System.out.println("Test 2: Method for setting/retrieving Full Name"
                       + "\nGIVEN I set a full name using the method"
                       + "\nWHEN I call the method to retrieve the full name"
                       + "\nTHEN The results match my input");

        System.out.println(styledSeperator);
        System.out.println(full_name_methods_test_Subscriber());
        System.out.println(styledSeperator);
        System.out.println("Press Enter To Continue...");
        myScanner.nextLine();

    }

    private static void studentSubscriberClassTests() {
        System.out.println("StudentSubscriber Class Test"
                      + "\nTest 1: All fields constructor test"
                      + "\nGIVEN I build a student subscriber with the all fields constructor"
                      + "\nWHEN  I use the getters"
                      + "\nTHEN  I can see the details of the subscriber I created");

                      System.out.println(styledSeperator);
                      System.out.println(all_fields_constructor_test_StudentSubscriber());
                      System.out.println(styledSeperator);
                      System.out.println("Press Enter To Continue...");
                      myScanner.nextLine();
    }

    private static String getExpirationDate_returns_the_correct_formatted_date() {
        Subscriber subscriber = new Subscriber("Luke", "Skywalker", "123 Sandy Way", "Mos Eisley", "Tatooine", "44052");
        Subscription subscription = new Subscription(subscriber);
        DateTimeFormatter shortDate = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        LocalDateTime dateTest = LocalDateTime.now();

        if (subscription.getExpirationDate().equals(dateTest.plusYears(1).format(shortDate))) {
            return "PASSED";
        } else {
            return "FAILED";
        }
    }

    private static String formattedCostOfRenewal_returns_the_correct_formatted_cost() {
        Subscriber subscriber = new Subscriber("Luke", "Skywalker", "123 Sandy Way", "Mos Eisley", "Tatooine", "44052");
        Subscription subscription = new Subscription(subscriber);

        if (subscription.foramttedCostOfRenewal().equals("$20.00")) {
            return "PASSED";
        } else {
            return "FAILED";
        }
    }

    private static String constructor_sets_current_date_when_initiated_Subscription() {
        Subscriber subscriber = new Subscriber("Luke", "Skywalker", "123 Sandy Way", "Mos Eisley", "Tatooine", "44052");
        Subscription subscription = new Subscription(subscriber);
        DateTimeFormatter shortDate = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        LocalDateTime now = LocalDateTime.now();
        if (subscription.getStartDate().format(shortDate).equals(now.format(shortDate))) {
            return "PASSED";
        } else {
            return "FAILED";
        }
    }

    private static String all_fields_constructor_test_StudentSubscriber() {
        StudentSubscriber subscriber = new StudentSubscriber("SkyStrike Academy", "123456", "Wedge", "Antilles", "77895 StarGazer Street", "Coronet City", "Corellia", "78945");
        if (subscriber.getFirstName().equals("Wedge")
         && subscriber.getLastName().equals("Antilles")
         && subscriber.getAddress().equals("77895 StarGazer Street")
         && subscriber.getCity().equals("Coronet City")
         && subscriber.getState().equals("Corellia")
         && subscriber.getZip().equals("78945")
         && subscriber.getSchoolName().equals("SkyStrike Academy")
         && subscriber.getStudentId().equals("123456")) {
            return "PASSED";
        } else {
            return "FAILED";
        }
    }

    private static String full_name_methods_test_Subscriber() {
        Subscriber subscriber = new Subscriber("Luke", "Skywalker", "123 Sandy Way", "Mos Eisley", "Tatooine", "44052");
        subscriber.setFullName("Han", "Solo");
        if (subscriber.getFullName().equals("Han Solo")) {
            return "PASSED";
        } else {
            return "FAILED";
        }
    }

    private static String all_fields_constructor_test_Subscriber() {
        Subscriber subscriber = new Subscriber("Luke", "Skywalker", "123 Sandy Way", "Mos Eisley", "Tatooine", "44052");
        if (subscriber.getFirstName().equals("Luke")
         && subscriber.getLastName().equals("Skywalker")
         && subscriber.getAddress().equals("123 Sandy Way")
         && subscriber.getCity().equals("Mos Eisley")
         && subscriber.getState().equals("Tatooine")
         && subscriber.getZip().equals("44052")) {
            return "PASSED";
        } else {
            return "FAILED";
        }
    }
}