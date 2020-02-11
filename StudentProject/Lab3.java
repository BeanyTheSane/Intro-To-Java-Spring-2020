import java.util.Scanner;
import java.util.regex.Pattern;

public class Lab3 {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        boolean interfaceRunning = true;
        TestScenarios constructorTest = new TestScenarios();
        
        while(interfaceRunning) {
            String mainMenuChoice = "";
            System.out.println("What would you like to do?");
            System.out.println("1.)  Run Full Tuition Chart Test");
            System.out.println("2.)  Run Auto Filled Constructor Test");
            System.out.println("3.)  Run User Filled Constructor Test");
            System.out.println("0.)  Exit the Program");
            System.out.println("Please Enter The Number of Your Selection...");
            mainMenuChoice = myScanner.nextLine();
            switch (mainMenuChoice) {
                case "1":
                    constructorTest.runTuitionTest();
                    break;

                case "2":
                    constructorTest.runAutoFilledConstructorTest();
                    break;

                case "3":
                    constructorTest.runUserFilledConstructorTest();
                    break;
            
                case "0":
                    interfaceRunning = false;
                    break;

                default:
                    System.out.println("Please Enter The Number of Your Selection!");
                    break;
            }
        }
        myScanner.close();
    }

    

    

    private static class TestScenarios {
        boolean testIsRunning = true;
        Scanner myScanner = new Scanner(System.in);
        boolean loopRunner = true;

        public void runTuitionTest() {
            int testCaseLimit = 22;//general max number of credit hours reccomended
    
            for (int i = 1; i <= testCaseLimit; i++) {
                Student inCountyStudent = new Student();
                Student outOfCountyStudent = new Student();
                Student outOfStateStudent = new Student();
                inCountyStudent.buildRandomPerson("INC", i);
                outOfCountyStudent.buildRandomPerson("OOC", i);
                outOfStateStudent.buildRandomPerson("OOS", i);
    
                System.out.println(inCountyStudent.getDetailsAsString());
                System.out.println(outOfCountyStudent.getDetailsAsString());
                System.out.println(outOfStateStudent.getDetailsAsString());
            }
            
            System.out.println("\nPress enter to return to the main menu\n");
            myScanner.nextLine();
        }

        public void runAutoFilledConstructorTest() {
            Student constructorTest1 = new Student("Cloud Strife", "999999", 12, "OOC");
            Student constructorTest2 = new Student("Cait Sith", "111111", 4);
    
            System.out.println("\nThe following two Students are created using the new constructors\n");
            System.out.println(constructorTest1.getDetailsAsString());
            System.out.println(constructorTest2.getDetailsAsString());
            System.out.println("\nPress enter to return to the main menu\n");
            myScanner.nextLine();
        }

        public void runUserFilledConstructorTest() {
            String name = "";
            String studentNumber = "";
            int creditHours = 0;
            String residentialStatus = "";

            while (testIsRunning) {
                System.out.println("\nYou can test the new constructors with your own criteria now");
                System.out.println("Type in exit at any time to return to the main menu\n");
                System.out.println("First we will test the constructor that accepts an input for all arguments");
                loopRunner = true;
                System.out.println("\nPlease enter the Students full name");
                name = verifyNameInput(loopRunner);
                if ("exit".equals(name.toLowerCase())) {
                    continue;
                }
                loopRunner = true;
                System.out.println("\nPlease enter the Students student Number (any 6 digit number)");
                studentNumber = verifyStudentNumberInput(loopRunner);
                if ("exit".equals(studentNumber.toLowerCase())) {
                    continue;
                }
                loopRunner = true;
                System.out.println("\nPlease enter the Students credit hours (A whole number between 1 and 22 inclusive)");
                creditHours = verifyCreditHourInput(loopRunner);
                if (creditHours == 0) {
                    continue;
                }
                loopRunner = true;
                System.out.println("\nPlease enter the students 3 letter residential status code by refering to the following list of options");
                System.out.println("'INC' -> In County");
                System.out.println("'OOC' -> Out Of County");
                System.out.println("'OOS' -> Out Of State");
                residentialStatus = verifyResidentialStatusInput(loopRunner);
                if ("exit".equals(residentialStatus.toLowerCase())) {
                    continue;
                }
                System.out.println("\nHere are the details for the student you just created\n");
                System.out.println(new Student(name, studentNumber, creditHours, residentialStatus).getDetailsAsString());
                
                System.out.println("\nPress enter to Continue\n");
                myScanner.nextLine();

                name = "";
                studentNumber = "";
                creditHours = 0;
                residentialStatus = "";

                System.out.println("Now we will test the constructor that sets the default Residential Status to 'INC'");
                System.out.println("\nPlease enter the Students full name");
                name = verifyNameInput(loopRunner);
                if ("exit".equals(name.toLowerCase())) {
                    continue;
                }
                System.out.println("\nPlease enter the Students student Number (any 6 digit number)");
                studentNumber = verifyStudentNumberInput(loopRunner);
                if ("exit".equals(studentNumber.toLowerCase())) {
                    continue;
                }
                System.out.println("\nPlease enter the Students credit hours (A whole number between 1 and 22 inclusive");
                creditHours = verifyCreditHourInput(loopRunner);
                if (creditHours == 0) {
                    continue;
                }
                System.out.println("\nHere are the details for the student you just created\n");
                System.out.println(new Student(name, studentNumber, creditHours).getDetailsAsString());

                System.out.println("\nPress enter to return to the main menu\n");
                myScanner.nextLine();
                testIsRunning = false;
            }
        }

        public boolean returnToMainMenu(String command) {
            if ("exit".equals(command.toLowerCase())) {
                testIsRunning = false;
                loopRunner = false;
                return true;
            }
            return false;
        }

        public String verifyNameInput(boolean loopRunner) {
            String inputToVerify = "";
            while(loopRunner) {
                inputToVerify = myScanner.nextLine();
                if (returnToMainMenu(inputToVerify)) {
                    return "exit";
                }
                if ("".equals(inputToVerify)) {
                    System.out.println("\nThe name cannot be blank.  Try Again");
                    continue;
                }
                if (inputToVerify.length() > 64) {
                    System.out.println("\nPlease limit names to less than 64 characters for this test.  Try Again");
                    continue;
                }
                loopRunner = false;
            }
            return inputToVerify;
        }

        public String verifyStudentNumberInput(boolean loopRunner) {
            String inputToVerify = "";
            Pattern sixDigitNumberRegex = Pattern.compile("[0-9]{6}");

            while(loopRunner) {
                inputToVerify = myScanner.nextLine();
                if (returnToMainMenu(inputToVerify)) {
                    return "exit";
                }
                if ("".equals(inputToVerify)) {
                    System.out.println("\nThe Student Number cannot be blank.  Try Again");
                    continue;
                }
                if (!sixDigitNumberRegex.matcher(inputToVerify).matches()) {
                    System.out.println("\nPlease enter a 6 digit number.  Try Again");
                    continue;
                }
                loopRunner = false;
            }
            return inputToVerify;
        }

        public int verifyCreditHourInput(boolean loopRunner) {
            String inputToVerify = "";
            int convertedInput = 0;
            while(loopRunner) {
                inputToVerify = myScanner.nextLine();
                if (returnToMainMenu(inputToVerify)) {
                    return 0;
                }
                try {
                    convertedInput = Integer.parseInt(inputToVerify);
                } catch (Exception e) {
                    System.out.println("\nPlease enter a number between 1 and 22 inclusive.  Try Again");
                }
                if (convertedInput < 1
                        || convertedInput > 22) {
                    System.out.println("\nPlease enter a positive number between 1 and 22 inclusive.  Try Again");
                    continue;
                }
                loopRunner = false;
            }
            return convertedInput;
        }

        public String verifyResidentialStatusInput(boolean loopRunner) {
            String inputToVerify = "";
            while(loopRunner) {
                inputToVerify = myScanner.nextLine().toUpperCase();
                if (returnToMainMenu(inputToVerify)) {
                    return "exit";
                }
                if ("".equals(inputToVerify)) {
                    System.out.println("\nThe Residential Status cannot be blank.  Try Again");
                    continue;
                }
                if ("INC".equals(inputToVerify)
                        || "OOC".equals(inputToVerify)
                        || "OOS".equals(inputToVerify)) {
                    loopRunner = false;
                } else {
                    System.out.println("\nThe Residential Status must be a 3 letter code from the provided list.  Try Again");
                    continue;
                }
            }
            return inputToVerify;
        }
    }
}