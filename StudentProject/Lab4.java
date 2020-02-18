import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Lab4 {

    public static void main(final String[] args) {
        final Scanner myScanner = new Scanner(System.in);
        boolean interfaceRunning = true;
        final TestScenarios constructorTest = new TestScenarios();


        //TODO add intro to program.  run program in fullscreen for best effect
        System.out.println("CISS 226"
                          + "\nLab 4"
                          + "\nAdam Knitter"
                          + "\nThis version now contains two tests for the new course class"
                          + "\nas well as all of the previous tests"
                          + "\nPlease run this full screen for best results"  
                          + "\nPress enter to begin");
                          myScanner.nextLine();
        
        while(interfaceRunning) {
            String mainMenuChoice = "";

            System.out.println("\n"
                                + "\n    1.)  Run Full Tuition Chart Test"
                                + "\n    2.)  Run Auto Filled Constructor Test"
                                + "\n    3.)  Run User Filled Constructor Test"
                                + "\n    4.)  Run Course Class Test"
                                + "\n    0.)  Exit the Program"
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
        //TODO add seperator lines to make console items stand out.  make a variable and drop it where needed
        boolean testIsRunning = true;
        Scanner myScanner = new Scanner(System.in);
        boolean loopRunner = true;
        final int testCaseLimit = 22;//general max number of credit hours reccomended
        final int minCreditHourPerCourse = 1;
        final int maxCreditHourPerCourse = 5;
        String CreditHourPerCourseRegex = buildCreditHourPerCourseRegex();
        InputVerifierModel nameVerifier = new InputVerifierModel("name", "^.{1,32}$", "\nPlease limit names to less than 32 characters for this test.  Try Again");
        InputVerifierModel courseIdVerifier = new InputVerifierModel("Id", "^[0-9]{3}$", "\nThe ID must be 3 digits long.  Try Again");
        InputVerifierModel studentNumberVerifier = new InputVerifierModel("Student Number", "^[0-9]{6}$", "\nPlease enter a 6 digit number.  Try Again");
        InputVerifierModel residentialStatusVerifier = new InputVerifierModel("Residential Status", "^[1-3]{1}$", "\nPlease enter the number that corresponds to te residential code you want to select.");
        InputVerifierModel creditHourVerifier = new InputVerifierModel("Credit Hour", "^([0-9]|[1-2][0-2])$", "\nPlease enter a number between 0 and 22 inclusive.  Try Again");
        InputVerifierModel creditHourperClassVerifier = new InputVerifierModel("Credit Hour per Class", CreditHourPerCourseRegex, "\nPlease enter a number between 1 and 5 inclusive.  Try Again");

        private String buildCreditHourPerCourseRegex() {
            return "^([" + minCreditHourPerCourse + "-" + maxCreditHourPerCourse + "]$";
        }

        public void runTuitionChartTest() {
            
    
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
                System.out.println("\nYou can test the new constructors with your own criteria now"
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
        
        private void runAddCoursesManuallyTest() {
            testIsRunning = true;
            String courseId = "";
            String courseName = "";
            String userChoice = ""; 
            boolean confirmChoice = true;
            int creditHours = -1;
            int creditHourSum = 0;
            int creditHourDiff = 0;
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
                if ((creditHourSum + creditHours) > testCaseLimit) {
                    creditHourDiff = (creditHourSum + creditHours) - testCaseLimit;
                    System.out.println("\nThis Course will exceed the credit hour limit by " + creditHourDiff + " hours."
                                        + "\n  Please re-enter the course with less credit hours or finalize the list"
                                        + "\n    Enter 'r' to re-enter this course with less credit hours"
                                        + "\n    Enter 's' to skip adding this course and proceed");
                    userChoice = myScanner.nextLine();
                    if ("r".equals(userChoice)) {
                        continue;
                    }
                    if ("s".equals(userChoice)) {
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

                    if ("y".equals(userChoice)) {
                        creditHourSum += creditHours;
                        courses.add(new Course(courseId, courseName, creditHours));
                        System.out.println("You have successfully added " + courseName + "\n");
                        break;
                    }
                    if ("n".equals(userChoice)) {
                        break;
                    }
                    System.out.println("Enter y to add this course or n to re-enter the details for this course\n");
                }
                
                confirmChoice = true;
                buildOrAddMoreCourses(courseTestStudent, courses);
            }
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

        private void runAddCoursesAutomaticallyTest() {
            //TODO build the auto test still
        }

        private boolean returnToMainMenu(final String command) {
            if ("exit".equals(command.toLowerCase())) {
                testIsRunning = false;
                loopRunner = false;
                return true;
            }
            return false;
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
    }
}