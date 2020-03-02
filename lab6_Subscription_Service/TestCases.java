import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
public class TestCases {
    final static Scanner myScanner = new Scanner(System.in);
    final static String styledSeperator = "<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>";

    public static void runQuickTest() {
        System.out.println("\nSubscriber Class Tests:");
        System.out.println("    Test 1: All fields constructor test                                 ->      " + all_fields_constructor_test_Subscriber());
        System.out.println("    Test 2: Method for setting/retrieving Full Name                     ->      " + full_name_methods_test_Subscriber());
        System.out.println("StudentSubscriber Class Tests:");
        System.out.println("    Test 1: All fields constructor test                                 ->      " + all_fields_constructor_test_StudentSubscriber());
        System.out.println("Subscription Class Tests:");
        System.out.println("    Test 1: Constructor sets current date                               ->      " + constructor_sets_current_date_when_initiated_Subscription());
        System.out.println("    Test 2: formattedCostOfRenewal returns the correct foramtted cost   ->      " + formattedCostOfRenewal_returns_the_correct_formatted_cost_Subscription());
        System.out.println("    Test 3: getExpirationDate returns the correct foramtted date        ->      " + getExpirationDate_returns_the_correct_formatted_date_Subscription());
        System.out.println("StudentSubscription Class Tests:");
        System.out.println("    Test 1: Constructor builds with StudentSubscriber                   ->      " + constructor_builds_with_StudentSubscriber_StudentSubscription());
        System.out.println("    Test 2: formattedCostOfRenewal returns the correct foramtted cost   ->      " + formattedCostOfRenewal_returns_the_correct_formatted_cost_StudentSubscription());
        System.out.println("PremiumSubscription Class Tests:");
        System.out.println("    Test 1: formattedCostOfRenewal returns the correct foramtted cost   ->      " + formattedCostOfRenewal_returns_the_correct_formatted_cost_PremiumSubscription());
        System.out.println("    Test 2: getExpirationDate returns the correct foramtted date        ->      " + getExpirationDate_returns_the_correct_formatted_date_PremiumSubscription());
    }

    public static void runAllTestsWithDetails() {
        subscriberClassTests();
        studentSubscriberClassTests();
        subscriptionClassTests();
        studentSubscriptionClassTests();
        premiumSubscriptionClassTest();
    }

	public static void runBuildAndOutputTest() {
        buildSubscriberList();
        buildSubscriptionList();
	}

    private static void subscriberClassTests() {
        System.out.println("\nSubscriber Class Test"
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

        System.out.println("Test 2: formattedCostOfRenewal returns the correct foramtted cost"
                       + "\nGIVEN I Have a subscription"
                       + "\nWHEN I check the formattedCostOfRenewal"
                       + "\nTHEN It returns the correct formatted cost");

        System.out.println(styledSeperator);
        System.out.println(formattedCostOfRenewal_returns_the_correct_formatted_cost_Subscription());
        System.out.println(styledSeperator);
        System.out.println("Press Enter To Continue...");
        myScanner.nextLine();

        System.out.println("Test 3: getExpirationDate returns the correct foramtted date"
                       + "\nGIVEN I Have a subscription"
                       + "\nWHEN I check the getExpirationDate"
                       + "\nTHEN It returns the correct formatted date");

        System.out.println(styledSeperator);
        System.out.println(getExpirationDate_returns_the_correct_formatted_date_Subscription());
        System.out.println(styledSeperator);
        System.out.println("Press Enter To Continue...");
        myScanner.nextLine();
    }

    private static void studentSubscriptionClassTests() {
        System.out.println("StudentSubscription Class Test"
                      + "\nTest 1: Constructor builds with StudentSubscriber"
                      + "\nGIVEN I build a student subscription with a StudentSubscriber"
                      + "\nWHEN  I check the subscriber"
                      + "\nTHEN  I can see the school ID of the subscriber I created");

                      System.out.println(styledSeperator);
                      System.out.println(constructor_builds_with_StudentSubscriber_StudentSubscription());
                      System.out.println(styledSeperator);
                      System.out.println("Press Enter To Continue...");
                      myScanner.nextLine();

                      System.out.println("Test 2: formattedCostOfRenewal returns the correct formatted cost"
                                     + "\nGIVEN I Have a Student subscription"
                                     + "\nWHEN I check the formattedCostOfRenewal"
                                     + "\nTHEN It returns the correct formatted cost");
              
                      System.out.println(styledSeperator);
                      System.out.println(formattedCostOfRenewal_returns_the_correct_formatted_cost_StudentSubscription());
                      System.out.println(styledSeperator);
                      System.out.println("Press Enter To Continue...");
                      myScanner.nextLine();
    }

    private static void premiumSubscriptionClassTest() {
        System.out.println("PremiumSubscription Class Test"
                      + "\nTest 1: formattedCostOfRenewal returns the correct formattted cost"
                      + "\nGIVEN I Have a Premium Subscription"
                      + "\nWHEN  I check the formattedCostOfRenewal"
                      + "\nTHEN  It returns the correct formatted cost");

                      System.out.println(styledSeperator);
                      System.out.println(formattedCostOfRenewal_returns_the_correct_formatted_cost_PremiumSubscription());
                      System.out.println(styledSeperator);
                      System.out.println("Press Enter To Continue...");
                      myScanner.nextLine();

                      System.out.println("Test 2: getExpirationDate returns the correct formatted date"
                                     + "\nGIVEN I Have a Premium Subscription"
                                     + "\nWHEN I check the getExpirationDate"
                                     + "\nTHEN It returns the correct formatted date");
              
                      System.out.println(styledSeperator);
                      System.out.println(getExpirationDate_returns_the_correct_formatted_date_PremiumSubscription());
                      System.out.println(styledSeperator);
                      System.out.println("Press Enter To Continue...");
                      myScanner.nextLine();
    }

    private static String getExpirationDate_returns_the_correct_formatted_date_PremiumSubscription() {
        Subscriber subscriber = new Subscriber("Luke", "Skywalker", "123 Sandy Way", "Mos Eisley", "Tatooine", "44052");
        Subscription premiumSubscription = new PremiumSubscription(subscriber);
        DateTimeFormatter shortDate = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        LocalDateTime dateTest = LocalDateTime.now();
        dateTest = dateTest.plusYears(premiumSubscription.getSubscriptionLength());

        if (premiumSubscription.getExpirationDate().equals(dateTest.format(shortDate))) {
            return "PASSED";
        } else {
            return "FAILED";
        }
    }

    private static String formattedCostOfRenewal_returns_the_correct_formatted_cost_PremiumSubscription() {
        Subscriber subscriber = new Subscriber("Luke", "Skywalker", "123 Sandy Way", "Mos Eisley", "Tatooine", "44052");
        Subscription premiumSubscription = new PremiumSubscription(subscriber);

        if (premiumSubscription.foramttedCostOfRenewal().equals("$50.00")) {
            return "PASSED";
        } else {
            return "FAILED";
        }
    }

    private static String formattedCostOfRenewal_returns_the_correct_formatted_cost_StudentSubscription() {
        Subscriber studentSubscriber = new StudentSubscriber("SkyStrike Academy", "123456", "Wedge", "Antilles", "77895 StarGazer Street", "Coronet City", "Corellia", "78945");
        Subscription studentSubscription = new StudentSubscription(studentSubscriber);

        if (studentSubscription.foramttedCostOfRenewal().equals("$15.00")) {
            return "PASSED";
        } else {
            return "FAILED";
        }
    }

    private static String constructor_builds_with_StudentSubscriber_StudentSubscription() {
        Subscriber studentSubscriber = new StudentSubscriber("SkyStrike Academy", "123456", "Wedge", "Antilles", "77895 StarGazer Street", "Coronet City", "Corellia", "78945");
        Subscription studentSubscription = new StudentSubscription(studentSubscriber);

        StudentSubscriber compareSubscriber = (StudentSubscriber) studentSubscription.getSubscriber();
        if (compareSubscriber.getStudentId().equals("123456")) {
            return "PASSED";
        }
        return "FAILED";
    }

    private static String getExpirationDate_returns_the_correct_formatted_date_Subscription() {
        Subscriber subscriber = new Subscriber("Luke", "Skywalker", "123 Sandy Way", "Mos Eisley", "Tatooine", "44052");
        Subscription subscription = new Subscription(subscriber);
        DateTimeFormatter shortDate = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        LocalDateTime dateTest = LocalDateTime.now();
        dateTest = dateTest.plusYears(subscription.getSubscriptionLength());

        if (subscription.getExpirationDate().equals(dateTest.format(shortDate))) {
            return "PASSED";
        } else {
            return "FAILED";
        }
    }

    private static String formattedCostOfRenewal_returns_the_correct_formatted_cost_Subscription() {
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