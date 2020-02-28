import java.util.Scanner;

public class Lab6 {
    public static void main(final String[] args) {
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

        TestCases.runQuickTest();

        myScanner.close();
    }
}