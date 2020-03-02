import java.util.Scanner;

public class Lab6 {
    public static void main(final String[] args) {
        String userChoice;
        Boolean loopRunner = true;
        final Scanner myScanner = new Scanner(System.in);
        final String styledSeperator = "<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>";
        System.out.println(styledSeperator
                          +"\nCISS 226"
                          + "\nLab 6"
                          + "\nAdam Knitter"
                          + "\nThis interface will run the various test cases"
                          + "\nfor this app and display the results to you"
                          + "\nPlease run this full screen for best results" 
                          + "\n" + styledSeperator 
                          + "\nPress enter to begin");
                          myScanner.nextLine();

        while (loopRunner) {
            System.out.println("Please enter the number for your selection:"
                           + "\n1.) Run Quick Test"
                           + "\n2.) Run Full Details Test"
                           + "\n3.) Run Build and Output Test"
                           + "\n0.) Exit the program");

            userChoice = myScanner.nextLine();

            switch (userChoice) {
                case "1":
                    TestCases.runQuickTest();
                    System.out.println("\nPress Enter to return to the main menu");
                    myScanner.nextLine();
                    break;
            
                case "2":
                    TestCases.runAllTestsWithDetails();
                    System.out.println("Press Enter to return to the main menu");
                    myScanner.nextLine();
                    break;

                case "3":
                    TestCases.runBuildAndOutputTest();
                    System.out.println("Press Enter to return to the main menu");
                    myScanner.nextLine();
                    break;

                case "0":
                    loopRunner = false;
                    break;

                default:
                    System.out.println("Please Enter the number of your selection");
                    continue;
            }
        }
        

        myScanner.close();
    }
}