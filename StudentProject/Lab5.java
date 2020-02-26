import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;


public class Lab5 {

    public static void main(final String[] args) {
        final Scanner myScanner = new Scanner(System.in);
        final TestScenarios constructorTest = new TestScenarios();
        final String styledSeperator = "<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>";
        boolean interfaceRunning = true;

        System.out.println(styledSeperator
                          +"\nCISS 226"
                          + "\nLab 5"
                          + "\nAdam Knitter"
                          + "\nThis version now contains two tests for the new payments class"
                          + "\n(Select option '5' on the main menu)"
                          + "\nas well as all of the previous tests"
                          + "\nPlease run this full screen for best results" 
                          + "\n" + styledSeperator 
                          + "\nPress enter to begin");
                          myScanner.nextLine();
        
        while(interfaceRunning) {
            String mainMenuChoice = "";

            System.out.println("\n"
                                + "\n Welcome to the Student App Test Interface"
                                + "\n" + styledSeperator
                                + "\n    1.)  Run Full Tuition Chart Test"
                                + "\n    2.)  Run Auto Filled Constructor Test"
                                + "\n    3.)  Run User Filled Constructor Test"
                                + "\n    4.)  Run Course Class Test"
                                + "\n    5.)  Run Payments Class Test"
                                + "\n    0.)  Exit the Program"
                                + "\n" + styledSeperator
                                + "\nPlease Enter The Number of Your Selection...");
            mainMenuChoice = myScanner.nextLine();
            switch (mainMenuChoice) {
                case "1":
                    constructorTest.runTuitionChartTest();
                    break;

                case "2":
                    constructorTest.runAutoFilledConstructorTest();
                    break;

                case "3":
                    constructorTest.runUserFilledConstructorTest();
                    break;

                case "4":
                    constructorTest.runCourseClassTest();
                    break;

                case "5":
                    constructorTest.runPaymentsClassTest();
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
        final String styledSeperator = "<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>";
        final int testCaseLimit = 22;//general max number of credit hours reccomended
        final int minCreditHourPerCourse = 1;
        final int maxCreditHourPerCourse = 5;
        String CreditHourPerCourseRegex = buildCreditHourPerCourseRegex();
        //The following models are used to verify different user inputs.  They are objects containing details to pass to a generic method.
        //They utilize a regex string to validate a desired criteria.
        InputVerifierModel nameVerifier = 
                            new InputVerifierModel("name", 
                                                    "^.{1,32}$", 
                                                    "\nPlease limit names to less than 32 characters for this test.  Try Again");
        InputVerifierModel courseIdVerifier = 
                            new InputVerifierModel("Id", 
                                                    "^[0-9]{3}$", 
                                                    "\nThe ID must be 3 digits long.  Try Again");
        InputVerifierModel studentNumberVerifier = 
                            new InputVerifierModel("Student Number", 
                                                    "^[0-9]{6}$", 
                                                    "\nPlease enter a 6 digit number.  Try Again");
        InputVerifierModel residentialStatusVerifier = 
                            new InputVerifierModel("Residential Status", 
                                                    "^[1-3]{1}$", 
                                                    "\nPlease enter the number that corresponds to the residential code you want to select.");
        InputVerifierModel creditHourVerifier = 
                            new InputVerifierModel("Credit Hour", 
                                                    "^([0-9]|1[0-9]|2[0-2])$", 
                                                    "\nPlease enter a number between 0 and 22 inclusive.  Try Again");
        InputVerifierModel creditHourperClassVerifier = 
                            new InputVerifierModel("Credit Hour per Class", 
                                                    CreditHourPerCourseRegex, 
                                                    "\nPlease enter a number between 1 and 5 inclusive.  Try Again");
        InputVerifierModel paymentVerifier = 
                            new InputVerifierModel("Payment", 
                                                    "^[+-]?[0-9]{1,3}(?:,?[0-9]{3})*(?:\\.[0-9]{2})?$", 
                                                    "\nPlease enter a payment amount equal to a dollar or more using the following format XXXX.XX"); 


        InputVerifierModel descriptionVerifier =
                            new InputVerifierModel("Description", 
                                                    "^.{0,255}$", 
                                                    "Please limit your description to 255 characters or less");

        private String buildCreditHourPerCourseRegex() {
            return "^([" + minCreditHourPerCourse + "-" + maxCreditHourPerCourse + "])$";
        }

        public void runPaymentsClassTest() {
            String paymentsTestChoice = "";
            int creditHours = 0;
            boolean courseInterfaceRunning = true;
            Student paymentTestStudent = new Student();
            NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();

            System.out.println("\nThis test requires you to create a test student"
                               + "\nPlease enter an amount of credit hours between 0 and 22 and one will be created for you\n");
                            
            loopRunner = true;
            creditHours = verifyIntegerInput(loopRunner, creditHourVerifier);
            if (creditHours == -1) {
                return;
            }

            paymentTestStudent.buildRandomPerson("INC", creditHours);

            System.out.println("\nWelcome "
                                + paymentTestStudent.getName()
                                + "!  Your Current remaining tuition balance is "
                                + currencyFormatter.format(paymentTestStudent.getTotalDue())
                                + "\nPress enter to continue to the payments menu");
            myScanner.nextLine();

            courseInterfaceRunning = true;
            while (courseInterfaceRunning) {
                System.out.println("\nYou can test the new Payments class by making payments towards "
                                    + paymentTestStudent.getName()
                                    + "s tuition and viewing payment details"
                                    + "\n    1.) Create a new test student"
                                    + "\n    2.) Make a payment"
                                    + "\n    3.) See Total Tuition due"
                                    + "\n    4.) See Total Payments made"
                                    + "\n    0.) Return to The previous menu"
                                    + "\n\nPlease Enter The Number of Your Selection...\n");
                paymentsTestChoice = myScanner.nextLine();
                switch (paymentsTestChoice) {
                    case "1":
                        paymentTestStudent = createNewPaymentTestStudent(paymentTestStudent);
                        break;

                    case "2":
                        promptForPayment(paymentTestStudent);
                        break;

                    case "3":
                        showRemainingBalance(paymentTestStudent);
                        break;

                    case "4":
                        showListOfPayments(paymentTestStudent);
                        break;
                
                    case "0":
                        courseInterfaceRunning = false;
                        break;

                    default:
                        System.out.println("Please Enter The Number of Your Selection!");
                        break;
                }
            }
        }

        private void showListOfPayments(Student paymentTestStudent) {
            NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
            StringBuilder listOfPayments = new StringBuilder();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");

            testIsRunning = true;
            while (testIsRunning) {
                if (!checkIfAnyPaymentsHaveBeenMade(paymentTestStudent)){
                    testIsRunning = false;
                    continue;
                }                            

                listOfPayments.append(paymentTestStudent.getName() + " has made the following payments:\n");

                for (Payment payment : paymentTestStudent.getListOfPayments()) {
                    listOfPayments.append(payment.getDateOfPayment().format(formatter) + "  ...  ");
                    listOfPayments.append(currencyFormatter.format(payment.getPaymentAmount()) + " --> ");
                    listOfPayments.append(payment.getDescription() + "\n");
                }

                listOfPayments.append("For a total of: " + currencyFormatter.format(paymentTestStudent.getTotalPayments())
                                        + "\nPress enter to continue");
                testIsRunning = false;
            }

            System.out.println(listOfPayments);
            myScanner.nextLine();
        }

        private void showRemainingBalance(Student paymentTestStudent) {
            NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();

            String formattedTotal = currencyFormatter.format(paymentTestStudent.getTotalDue());

            System.out.println(paymentTestStudent.getName() + " has a remaining balance of " + formattedTotal
                                + "\nPress enter to continue");
            myScanner.nextLine();
        }

        private void promptForPayment(Student paymentTestStudent) {

            BigDecimal paymentAmount =  BigDecimal.valueOf(0);
            NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
            String description = "";
                        
            testIsRunning = true;
            while (testIsRunning) {
                if (zeroBalanceCheck(paymentTestStudent)) {
                    testIsRunning = false;
                    continue;
                }
                loopRunner = true;
                System.out.println("Current Balance: "
                                    + currencyFormatter.format(paymentTestStudent.getTotalDue()) 
                                    + "\nPlease enter the amount of the payment\n");
                paymentAmount = verifyBigDecimalInput(loopRunner, paymentVerifier);
                if (paymentAmount.equals(BigDecimal.valueOf(-1))) {
                    continue;
                }
                
                if (overPaymentCheck(paymentTestStudent, paymentAmount)) {
                    testIsRunning = false;
                    continue;
                }

                loopRunner = true;
                System.out.println("\nPlease enter a brief description of the payment\n");
                description = verifyStringInput(loopRunner, descriptionVerifier);
                if ("exit".equals(description.toLowerCase())) {
                    continue;
                }

                paymentTestStudent.makePayment(paymentAmount, description);
                System.out.println("Thank you " 
                                    + paymentTestStudent.getName() 
                                    + " for your payment of " 
                                    + currencyFormatter.format(paymentAmount)
                                    + "\nYour remaining balance is "
                                    + currencyFormatter.format(paymentTestStudent.getTotalDue())
                                    + "\nPress enter to continue");
                myScanner.nextLine();
                testIsRunning = false;
            }
        }

        private Student createNewPaymentTestStudent(Student paymentTestStudent) {
            int creditHours = 0;
            NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();

            System.out.println("\nPlease enter an amount of credit hours between 0 and 22 and a new student will be created for you\n");
            testIsRunning = true;
            while (testIsRunning) {
                loopRunner = true;
                creditHours = verifyIntegerInput(loopRunner, creditHourVerifier);
                if (creditHours == -1) {
                    continue;
                }
            
                paymentTestStudent = new Student();
                paymentTestStudent.buildRandomPerson("INC", creditHours);

                System.out.println("\nWelcome "
                        + paymentTestStudent.getName()
                        + "!  Your Current remaining tuition balance is "
                        + currencyFormatter.format(paymentTestStudent.getTotalDue())
                        + "\nPress enter to continue to the payments menu");
                myScanner.nextLine();
                break;
            }
            return paymentTestStudent;
        }

        private Boolean checkIfAnyPaymentsHaveBeenMade(Student testStudent) {
            ArrayList<Payment> listOfPayments = testStudent.getListOfPayments();
            if (listOfPayments.size() == 0) {
                System.out.println(testStudent.getName() + " Has not made any payments"
                                    + "\nPress enter to continue");
                return false;
            }
            return true;
        }

        private Boolean overPaymentCheck(Student testStudent, BigDecimal paymentAmount) {
            NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
            BigDecimal difference = testStudent.getTotalDue().subtract(paymentAmount);
            if (difference.compareTo( BigDecimal.valueOf(0)) == -1) {
                System.out.println("The payment of "
                                    + currencyFormatter.format(paymentAmount)
                                    + " exceeds the remaining balance for " 
                                    + testStudent.getName()
                                    + " By "
                                    + currencyFormatter.format(difference.multiply(BigDecimal.valueOf(-1)))
                                    + "\nThis payment will not be applied"
                                    + "\nPress enter to continue"); 
                myScanner.nextLine(); 
                return true;
            }
            return false;
        }

        private Boolean zeroBalanceCheck(Student testStudent) {
            if (testStudent.getTotalDue().compareTo(BigDecimal.valueOf(0)) == 0) {
                //display to user there is no current balance
                System.out.println("The remaining balance for " + testStudent.getName() + " is currently zero"
                                    + "\nPlease create a new student with one or more credit hours to continue testing this feature"
                                    + "\nPress enter to return to the previous menu");
                myScanner.nextLine();
                return true;
            }
            return false;
        }

        public void runTuitionChartTest() {
            
            System.out.println(styledSeperator);
            for (int i = 1; i <= testCaseLimit; i++) {
                final Student inCountyStudent = new Student();
                final Student outOfCountyStudent = new Student();
                final Student outOfStateStudent = new Student();
                inCountyStudent.buildRandomPerson(Student.ResidentialCodes.INC.toString(), i);
                outOfCountyStudent.buildRandomPerson(Student.ResidentialCodes.OOC.toString(), i);
                outOfStateStudent.buildRandomPerson(Student.ResidentialCodes.OOS.toString(), i);
    
                System.out.println(inCountyStudent.getDetailsAsString()
                                    + "\n" + outOfCountyStudent.getDetailsAsString()
                                    + "\n" + outOfStateStudent.getDetailsAsString());
            }
            
            System.out.println(styledSeperator);
            System.out.println("\nPress enter to return to the main menu\n");
            myScanner.nextLine();
        }

        public void runAutoFilledConstructorTest() {
            final Student constructorTest1 = new Student("Cloud Strife", "999999", Student.ResidentialCodes.getResidentialCodeById(1));
            final Student constructorTest2 = new Student("Cait Sith", "777777", Student.ResidentialCodes.getResidentialCodeById(2));
            final Student constructorTest3 = new Student("Tifa Lockhart", "444444", Student.ResidentialCodes.getResidentialCodeById(3));
            final Student constructorTest4 = new Student("Aerith Gainsborogh", "111111");
            final Student constructorTest5 = new Student("Barret Wallace", "123456");

            constructorTest1.addCourseList(Course.buildDefaultCourseList(19));
            constructorTest2.addCourseList(Course.buildDefaultCourseList(12));
            constructorTest3.addCourseList(Course.buildDefaultCourseList(4));
            constructorTest4.addCourseList(Course.buildDefaultCourseList(1));
            constructorTest5.addCourseList(Course.buildDefaultCourseList(0));
    
            System.out.println("\nThe following Students are created using the new constructors and course lists\n"
                                + "\n" + styledSeperator
                                + "\n" + constructorTest1.getDetailsAsString()
                                + "\n" + constructorTest1.getCourseList()
                                + "\n" + constructorTest2.getDetailsAsString()
                                + "\n" + constructorTest2.getCourseList()
                                + "\n" + constructorTest3.getDetailsAsString()
                                + "\n" + constructorTest3.getCourseList()
                                + "\n" + constructorTest4.getDetailsAsString()
                                + "\n" + constructorTest4.getCourseList()
                                + "\n" + constructorTest5.getDetailsAsString()
                                + "\n" + constructorTest5.getCourseList()
                                + "\n" + styledSeperator
                                + "\n\nPress enter to return to the main menu\n");
            myScanner.nextLine();
        }

        public void runUserFilledConstructorTest() {
            String name = "";
            String studentNumber = "";
            int creditHours = 0;
            int residentialStatus = 0;
            ArrayList<Course> courses = new ArrayList<>();

            testIsRunning = true;
            while (testIsRunning) {
                System.out.println("\n" + styledSeperator
                                    +"\nYou can test the new constructors with your own criteria now"
                                    + "\nType in exit at any time to return to the main menu\n"
                                    + "\nFirst we will test the constructor that accepts an input for all arguments");
                loopRunner = true;
                System.out.println("\nPlease enter the Students full name");
                name = verifyStringInput(loopRunner, nameVerifier);
                if ("exit".equals(name.toLowerCase())) {
                    continue;
                }
                loopRunner = true;
                System.out.println("\nPlease enter the Students student Number (any 6 digit number)");
                studentNumber = verifyStringInput(loopRunner, studentNumberVerifier);
                if ("exit".equals(studentNumber.toLowerCase())) {
                    continue;
                }
                loopRunner = true;
                System.out.println("\nPlease enter the Students credit hours (A whole number between 0 and 22 inclusive)");
                creditHours = verifyIntegerInput(loopRunner, creditHourVerifier);
                if (creditHours == -1) {
                    continue;
                }
                courses = Course.buildDefaultCourseList(creditHours);
                loopRunner = true;
                System.out.println("\nPlease select a residential status from the following list of options by entering the corresponding number"
                                    + "\n    1.) 'INC' -> In County"
                                    + "\n    2.) 'OOC' -> Out Of County"
                                    + "\n    3.) 'OOS' -> Out Of State");
                residentialStatus = verifyIntegerInput(loopRunner, residentialStatusVerifier);
                if (residentialStatus == -1) {
                    continue;
                }
                System.out.println("\nHere are the details for the student you just created\n");
                Student.ResidentialCodes code = Student.ResidentialCodes.getResidentialCodeById(residentialStatus);
                Student student = new Student(name, studentNumber, courses, code);
                System.out.println(student.getDetailsAsString()
                                    + "\n" + student.getCourseList());
                
                System.out.println("\nPress enter to Continue\n");
                myScanner.nextLine();

                name = "";
                studentNumber = "";
                creditHours = 0;
                residentialStatus = 0;

                System.out.println("Now we will test the constructor that sets the default Residential Status to 'INC'"
                                    + "\n\nPlease enter the Students full name");
                name = verifyStringInput(loopRunner, nameVerifier);
                if ("exit".equals(name.toLowerCase())) {
                    continue;
                }
                System.out.println("\nPlease enter the Students student Number (any 6 digit number)");
                studentNumber = verifyStringInput(loopRunner, studentNumberVerifier);
                if ("exit".equals(studentNumber.toLowerCase())) {
                    continue;
                }
                System.out.println("\nPlease enter the Students credit hours (A whole number between 0 and 22 inclusive");
                creditHours = verifyIntegerInput(loopRunner, creditHourVerifier);
                if (creditHours == -1) {
                    continue;
                }
                courses = Course.buildDefaultCourseList(creditHours);
                System.out.println("\nHere are the details for the student you just created\n");
                Student student2 = new Student(name, studentNumber, courses);
                System.out.println(student2.getDetailsAsString()
                                    + "\n" + student2.getCourseList());

                System.out.println("\nPress enter to return to the main menu\n");
                myScanner.nextLine();
                testIsRunning = false;
            }
        }

        public void runCourseClassTest() {
            String courseTestChoice = "";
            boolean courseInterfaceRunning = true;
            while (courseInterfaceRunning) {
                System.out.println("\nYou can test the new Course class by adding and viewing courses for a student"
                                    + "\n    1.) Add courses one by one then view the details"
                                    + "\n    2.) Run automated test with default courses added"
                                    + "\n    0.) Return to The previous menu"
                                    + "\nPlease Enter The Number of Your Selection...");
                courseTestChoice = myScanner.nextLine();
                switch (courseTestChoice) {
                    case "1":
                        runAddCoursesManuallyTest();
                        break;

                    case "2":
                        runAddCoursesAutomaticallyTest();
                
                    case "0":
                        courseInterfaceRunning = false;
                        break;

                    default:
                        System.out.println("Please Enter The Number of Your Selection!");
                        break;
                }
            }

        }

        private void runAddCoursesAutomaticallyTest() {
            final Student courseTestStudent1 = new Student("Vivi Orunitia", "666666");
            final Student courseTestStudent2 = new Student("Zidane Tribal", "777777");
            final Student courseTestStudent3 = new Student("Garnet Til Alexandros XVII", "111111");
            final Student courseTestStudent4 = new Student("Adelbert Steiner", "123456");
            final Student courseTestStudent5 = new Student("Freya Crescent", "987654");

            courseTestStudent1.addCourseList(Course.buildDefaultCourseList(22));
            courseTestStudent2.addCourseList(Course.buildDefaultCourseList(12));
            courseTestStudent3.addCourseList(Course.buildDefaultCourseList(4));
            courseTestStudent4.addCourseList(Course.buildDefaultCourseList(1));
            courseTestStudent5.addCourseList(Course.buildDefaultCourseList(0));

            System.out.println("\nThe following Students were created using the new course class.\n"
                                + "\n" + styledSeperator
                                + "\n" + courseTestStudent1.getDetailsAsString()
                                + "\n" + courseTestStudent1.getCourseList()
                                + "\n" + styledSeperator
                                + "\n" + courseTestStudent2.getDetailsAsString()
                                + "\n" + courseTestStudent2.getCourseList()
                                + "\n" + styledSeperator
                                + "\n" + courseTestStudent3.getDetailsAsString()
                                + "\n" + courseTestStudent3.getCourseList()
                                + "\n" + styledSeperator
                                + "\n" + courseTestStudent4.getDetailsAsString()
                                + "\n" + courseTestStudent4.getCourseList()
                                + "\n" + styledSeperator
                                + "\n" + courseTestStudent5.getDetailsAsString()
                                + "\n" + courseTestStudent5.getCourseList()
                                + "\n" + styledSeperator
                                + "\n\nPress enter to return to the main menu\n");
            myScanner.nextLine();

        }
        
        private void runAddCoursesManuallyTest() {
            testIsRunning = true;
            String courseId = "";
            String courseName = "";
            String userChoice = "";
            String exitCheck = ""; 
            boolean confirmChoice = true;
            int creditHours = -1;
            int creditHourSum = 0;
            int pendingTotal = 0;
            Student courseTestStudent = new Student();
            ArrayList<Course> courses = new ArrayList<>();
            
            courseTestStudent.buildRandomPerson(Student.ResidentialCodes.INC.toString(), 0);

            System.out.println("\nThis test allows you to manually create courses and add them to a students record"
                              + "\n  Type in 'exit' at any time to return to the previous menu"
                              + "\n    There is a limit of " + testCaseLimit + " credit hours total per student\n");

            while (testIsRunning) {
                loopRunner = true;
                System.out.println("\nPlease enter a 3 digit number for the course ID");
                courseId = verifyStringInput(loopRunner, courseIdVerifier);
                if ("exit".equals(courseId.toLowerCase())) {
                    continue;
                }
                loopRunner = true;
                System.out.println("\nPlease enter the course name");
                courseName = verifyStringInput(loopRunner, nameVerifier);
                if ("exit".equals(courseName.toLowerCase())) {
                    continue;
                }
                loopRunner = true;
                System.out.println("\nPlease enter a number 1 through 5 for the credit hours");
                creditHours = verifyIntegerInput(loopRunner, creditHourperClassVerifier);
                if (creditHours == -1) {
                    continue;
                }
                loopRunner = true;
                pendingTotal = (creditHourSum + creditHours);
                if (pendingTotal > testCaseLimit) {
                    exitCheck = creditHourLimitWarning(loopRunner, pendingTotal);
                    if ("exit".equals(exitCheck.toLowerCase())) {
                        continue;
                    } else if ("redo".equals(exitCheck.toLowerCase())) {
                        continue;
                        
                    } else if ("skip".equals(exitCheck.toLowerCase())) {
                        buildOrAddMoreCourses(courseTestStudent, courses);
                        continue;
                    }
                }

                confirmChoice = true;
				while (confirmChoice) {
                    System.out.println("    Course ID: " + courseId
                                        + "\n    Course Namme: " + courseName
                                        + "\n    Credit Hours: " + creditHours
                                        + "\nAre you sure you want to add this course? [y]es, [n]o");

                    userChoice = myScanner.nextLine();

                    if ("y".equals(userChoice.toLowerCase())) {
                        creditHourSum += creditHours;
                        courses.add(new Course(courseId, courseName, creditHours));
                        System.out.println("You have successfully added " + courseName + "\n");
                        break;
                    }
                    if ("n".equals(userChoice.toLowerCase())) {
                        break;
                    }
                    System.out.println("Enter y to add this course or n to re-enter the details for this course\n");
                }
                
                confirmChoice = true;
                buildOrAddMoreCourses(courseTestStudent, courses);
            }
        }

        private String creditHourLimitWarning(boolean loopRunner, int pendingTotal) {
            int creditHourDiff = 0;
            String userChoice = "";
            if (pendingTotal > testCaseLimit) {
                creditHourDiff = pendingTotal - testCaseLimit;
                System.out.println("\nThis Course will exceed the credit hour limit by " + creditHourDiff + " hours."
                                    + "\n  Please re-enter the course with less credit hours or finalize the list"
                                    + "\n    Enter 'r' to re-enter this course with less credit hours"
                                    + "\n    Enter 's' to skip adding this course and proceed");
                while (loopRunner) {
                    userChoice = myScanner.nextLine();
                    if (returnToMainMenu(userChoice)) {
                        return "exit";
                    }
                    if ("r".equals(userChoice)) {
                        return "redo";
                    }
                    else if ("s".equals(userChoice)) {
                        return "skip";
                    }
                    else {
                        System.out.println("Please enter 'r' or 's'");
                        continue;
                    }
                }
            }
            return "";
        }

        private void buildOrAddMoreCourses(Student courseTestStudent, ArrayList<Course> courses) {
            boolean confirmChoice = true;
            String userChoice;
            int totalCreditHours = 0;
            while (confirmChoice) {
                System.out.println("Current course list:");
                totalCreditHours = 0;
                for (Course course : courses) {
                    System.out.println("    " + course.getCourseDetailsAsString());
                    totalCreditHours += course.getCreditHours();
                }
                System.out.println("Total Credit Hours: " + totalCreditHours
                                  + "\n\nEnter 'b' to build the student with this course list"
                                  + "\nEnter 'a' to add another course");
                userChoice = myScanner.nextLine();

                if ("b".equals(userChoice)) {
                    courseTestStudent.addCourseList(courses);
                    System.out.println("These are the Details for the student and their new course list\n\n"
                                      + courseTestStudent.getDetailsAsString()
                                      + "\n    " + courseTestStudent.getCourseList()
                                      + "\nPress enter to continue");
                    myScanner.nextLine();
                    testIsRunning = false;
                    break;
                }
                if ("a".equals(userChoice)) {
                    break;
                }
            }
        }

        private String verifyStringInput(boolean loopRunner, InputVerifierModel inputType) {
            String inputToVerify = "";
            final Pattern regexPattern = Pattern.compile(inputType.getRegexPattern());
            while(loopRunner) {
                inputToVerify = myScanner.nextLine();
                if (returnToMainMenu(inputToVerify)) {
                    return "exit";
                }
                if ("".equals(inputToVerify)) {
                    System.out.println("\nThe " + inputType.getName() + " cannot be blank.  Try Again");
                    continue;
                }
                if (!regexPattern.matcher(inputToVerify).matches()) {
                    System.out.println(inputType.getErrorMessage());
                    continue;
                }
                loopRunner = false;
            }
            return inputToVerify;
        }

        private int verifyIntegerInput(boolean loopRunner, InputVerifierModel inputType) {
            String inputToVerify = "";
            int convertedInput = 0;
            final Pattern regexPattern = Pattern.compile(inputType.getRegexPattern());
            while(loopRunner) {
                inputToVerify = myScanner.nextLine();
                if (returnToMainMenu(inputToVerify)) {
                    return -1;
                }
                if (!regexPattern.matcher(inputToVerify).matches()) {
                    System.out.println(inputType.getErrorMessage());
                    continue;
                }
                try {
                    convertedInput = Integer.parseInt(inputToVerify);
                } catch (final Exception e) {
                    System.out.println(inputType.getErrorMessage());
                    continue;
                }
                loopRunner = false;
            }
            return convertedInput;
        }

        private BigDecimal verifyBigDecimalInput(boolean loopRunner, InputVerifierModel inputType) {
            String inputToVerify = "";
            BigDecimal convertedInput = BigDecimal.valueOf(0);
            final Pattern regexPattern = Pattern.compile(inputType.getRegexPattern());
            while(loopRunner) {
                inputToVerify = myScanner.nextLine();
                if (returnToMainMenu(inputToVerify)) {
                    return  BigDecimal.valueOf(-1);
                }
                if (!regexPattern.matcher(inputToVerify).matches()) {
                    System.out.println(inputType.getErrorMessage());
                    continue;
                }
                try {
                    convertedInput = BigDecimal.valueOf(Double.parseDouble(inputToVerify));
                } catch (final Exception e) {
                    System.out.println(inputType.getErrorMessage());
                    continue;
                }
                loopRunner = false;
            }
            return convertedInput;
        }

        private boolean returnToMainMenu(final String command) {
            if ("exit".equals(command.toLowerCase())) {
                testIsRunning = false;
                loopRunner = false;
                return true;
            }
            return false;
        }
    }
}