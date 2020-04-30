import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Lab4 {

    public static void main(final String[] args) {
        final Scanner myScanner = new Scanner(System.in);
        boolean interfaceRunning = true;
        final TestScenarios constructorTest = new TestScenarios();
        
        while(interfaceRunning) {
            String mainMenuChoice = "";
            System.out.println("What would you like to do?");
            System.out.println("1.)  Run Full Tuition Chart Test");
            System.out.println("2.)  Run Auto Filled Constructor Test");
            System.out.println("3.)  Run User Filled Constructor Test");
            System.out.println("4.)  Run Course Class Test");
            System.out.println("0.)  Exit the Program");
            System.out.println("Please Enter The Number of Your Selection...");
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
        boolean testIsRunning = true;
        Scanner myScanner = new Scanner(System.in);
        boolean loopRunner = true;
        final int testCaseLimit = 22;//general max number of credit hours reccomended

        public void runTuitionChartTest() {
            
    
            for (int i = 1; i <= testCaseLimit; i++) {
                final Student inCountyStudent = new Student();
                final Student outOfCountyStudent = new Student();
                final Student outOfStateStudent = new Student();
                inCountyStudent.buildRandomPerson(Student.ResidentialCodes.INC.toString(), i);
                outOfCountyStudent.buildRandomPerson(Student.ResidentialCodes.OOC.toString(), i);
                outOfStateStudent.buildRandomPerson(Student.ResidentialCodes.OOS.toString(), i);
    
                System.out.println(inCountyStudent.getDetailsAsString());
                System.out.println(outOfCountyStudent.getDetailsAsString());
                System.out.println(outOfStateStudent.getDetailsAsString());
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
    
            System.out.println("\nThe following Students are created using the new constructors and course lists\n");
            System.out.println(constructorTest1.getDetailsAsString());
            System.out.println(constructorTest1.getCourseList());
            System.out.println(constructorTest2.getDetailsAsString());
            System.out.println(constructorTest2.getCourseList());
            System.out.println(constructorTest3.getDetailsAsString());
            System.out.println(constructorTest3.getCourseList());
            System.out.println(constructorTest4.getDetailsAsString());
            System.out.println(constructorTest4.getCourseList());
            System.out.println(constructorTest5.getDetailsAsString());
            System.out.println(constructorTest5.getCourseList());
            System.out.println("\nPress enter to return to the main menu\n");
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
                System.out.println("\nPlease enter the Students credit hours (A whole number between 0 and 22 inclusive)");
                creditHours = verifyCreditHourInput(loopRunner);
                if (creditHours == -1) {
                    continue;
                }
                courses = Course.buildDefaultCourseList(creditHours);
                loopRunner = true;
                System.out.println("\nPlease select a residential status from the following list of options by entering the corresponding number");
                System.out.println("1.) 'INC' -> In County");
                System.out.println("2.) 'OOC' -> Out Of County");
                System.out.println("3.) 'OOS' -> Out Of State");
                residentialStatus = verifyResidentialStatusInput(loopRunner);
                if (residentialStatus == -1) {
                    continue;
                }
                System.out.println("\nHere are the details for the student you just created\n");
                Student.ResidentialCodes code = Student.ResidentialCodes.getResidentialCodeById(residentialStatus);
                Student student = new Student(name, studentNumber, courses, code);
                System.out.println(student.getDetailsAsString());
                System.out.println(student.getCourseList());
                
                System.out.println("\nPress enter to Continue\n");
                myScanner.nextLine();

                name = "";
                studentNumber = "";
                creditHours = 0;
                residentialStatus = 0;

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
                System.out.println("\nPlease enter the Students credit hours (A whole number between 0 and 22 inclusive");
                creditHours = verifyCreditHourInput(loopRunner);
                if (creditHours == -1) {
                    continue;
                }
                courses = Course.buildDefaultCourseList(creditHours);
                System.out.println("\nHere are the details for the student you just created\n");
                Student student2 = new Student(name, studentNumber, courses);
                System.out.println(student2.getDetailsAsString());
                System.out.println(student2.getCourseList());

                System.out.println("\nPress enter to return to the main menu\n");
                myScanner.nextLine();
                testIsRunning = false;
            }
        }

        public void runCourseClassTest() {
            String courseTestChoice = "";
            boolean courseInterfaceRunning = true;
            while (courseInterfaceRunning) {
                System.out.println("\nYou can test the new Course class by adding and viewing courses for a student");
                System.out.println("Please select the task you would like to perform");
                System.out.println("1.) Add courses one by one then view the details");
                System.out.println("2.) Run automated test with default courses added");
                System.out.println("0.) Return to The previous menu");
                System.out.println("Please Enter The Number of Your Selection...");
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
            int creditHours = -1;
            int creditHourSum = 0;
            int creditHourDiff = 0;
            Student courseTestStudent = new Student();
            ArrayList<Course> courses = new ArrayList<>();
            
            courseTestStudent.buildRandomPerson(Student.ResidentialCodes.INC.toString(), 0);

            System.out.println("\nThis test allows you to manually create courses and add them to a students record, \nthen view the students full details");
            System.out.println("Type in exit at any time to return to the main menu");
            System.out.println("There is a limit of " + testCaseLimit + " credit hours total per student\n     ");

            while (testIsRunning) {
                loopRunner = true;
                System.out.println("\nPlease enter a 3 digit number for the course ID");
                courseId = verifyCourseIdInput(loopRunner);
                if ("exit".equals(courseId.toLowerCase())) {
                    continue;
                }
                loopRunner = true;
                System.out.println("\nPlease enter the course name");
                courseName = verifyCourseNameInput(loopRunner);
                if ("exit".equals(courseName.toLowerCase())) {
                    continue;
                }
                loopRunner = true;
                System.out.println("\nPlease enter a number 1 through 5 for the credit hours");
                creditHours = verifycreditHoursInput(loopRunner);
                if (creditHours == -1) {
                    continue;
                }
                if ((creditHourSum + creditHours) > testCaseLimit) {
                    creditHourDiff = (creditHourSum + creditHours) - testCaseLimit;
                    System.out.println("\nThis Course will exceed the credit hour limit by " + creditHourDiff + " hours.");
                    System.out.println("\nPlease re-enter the course with less credit hours or finalize the list");
                    continue;
                }
                creditHourSum += creditHours;
                courses.add(new Course(courseId, courseName, creditHours)); 
//need to add some way to break off early   when user wishes it.
            }
            courseTestStudent.addCourseList(courses);
        }

        private int verifycreditHoursInput(boolean loopRunner) {
            String inputToVerify = "";
            int convertedInput = 0;
            while(loopRunner) {
                inputToVerify = myScanner.nextLine();
                if (returnToMainMenu(inputToVerify)) {
                    return -1;
                }
                try {
                    convertedInput = Integer.parseInt(inputToVerify);
                } catch (final Exception e) {
                    System.out.println("\nPlease enter a number between 1 and 5 inclusive.  Try Again");
                }
                if (convertedInput < 0
                        || convertedInput > 22) {
                    System.out.println("\nPlease enter a number between 1 and 5 inclusive.  Try Again");
                    continue;
                }
                loopRunner = false;
            }
            return convertedInput;
        }

        private String verifyCourseNameInput(boolean loopRunner) {
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
                if (inputToVerify.length() > 32) {
                    System.out.println("\nPlease limit names to less than 32 characters for this test.  Try Again");
                    continue;
                }
                loopRunner = false;
            }
            return inputToVerify;
        }

        private String verifyCourseIdInput(boolean loopRunner) {
            String inputToVerify = "";
            final Pattern threeDigitNumberRegex = Pattern.compile("[0-9]{3}");
            while(loopRunner) {
                inputToVerify = myScanner.nextLine();
                if (returnToMainMenu(inputToVerify)) {
                    return "exit";
                }
                if ("".equals(inputToVerify)) {
                    System.out.println("\nThe id cannot be blank.  Try Again");
                    continue;
                }
                if (!threeDigitNumberRegex.matcher(inputToVerify).matches()) {
                    System.out.println("\nThe ID must be 3 digits long.  Try Again");
                    continue;
                }
                loopRunner = false;
            }
            return inputToVerify;
        }

        private void runAddCoursesAutomaticallyTest() {
            //TODO
        }

        private boolean returnToMainMenu(final String command) {
            if ("exit".equals(command.toLowerCase())) {
                testIsRunning = false;
                loopRunner = false;
                return true;
            }
            return false;
        }

        private String verifyNameInput(boolean loopRunner) {
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

        private String verifyStudentNumberInput(boolean loopRunner) {
            String inputToVerify = "";
            final Pattern sixDigitNumberRegex = Pattern.compile("[0-9]{6}");
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

        private int verifyCreditHourInput(boolean loopRunner) {
            String inputToVerify = "";
            int convertedInput = 0;
            while(loopRunner) {
                inputToVerify = myScanner.nextLine();
                if (returnToMainMenu(inputToVerify)) {
                    return -1;
                }
                try {
                    convertedInput = Integer.parseInt(inputToVerify);
                } catch (final Exception e) {
                    System.out.println("\nPlease enter a number between 0 and 22 inclusive.  Try Again");
                }
                if (convertedInput < 0
                        || convertedInput > 22) {
                    System.out.println("\nPlease enter a positive number between 0 and 22 inclusive.  Try Again");
                    continue;
                }
                loopRunner = false;
            }
            return convertedInput;
        }

        private int verifyResidentialStatusInput(boolean loopRunner) {
            String inputToVerify = "";
            int convertedInput = 0;
            while(loopRunner) {
                inputToVerify = myScanner.nextLine();
                if (returnToMainMenu(inputToVerify)) {
                    return -1;
                }
                try {
                    convertedInput = Integer.parseInt(inputToVerify);
                } catch (final Exception e) {
                    System.out.println("\nPlease enter the number that corresponds to te residential code you want to select.");
                    continue;
                }
                if (convertedInput < 1 || convertedInput > 3) {
                    System.out.println("\nPlease enter the number that corresponds to te residential code you want to select.");
                    continue;
                }
                loopRunner = false;
            }
            return convertedInput;
        }
    }
}