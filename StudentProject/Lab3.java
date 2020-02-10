import java.util.Scanner;

public class Lab3 {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        Student constructorTest1 = new Student("Cloud Strife", "999999", 12, "OOC");
        Student constructorTest2 = new Student("Cait Sith", "111111", 4);

        System.out.println("\nThe following two Students are created using the new constructors\n");
        System.out.println(constructorTest1.getDetailsAsString());
        System.out.println(constructorTest2.getDetailsAsString());

        System.out.println("\nPress any Key to run the full tuition chart test\n");
        myScanner.nextLine();

        runTuitionTest();

        System.out.println("\nPress any Key to Exit\n");
        myScanner.nextLine();
    }

    private static void runTuitionTest() {
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
    }
}