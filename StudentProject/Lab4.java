public class Lab4 {

    public static void main(String[] args) {

        runTuitionTest();
        
    }

    private static void runTuitionTest() {
        int testCaseLimit = 22;

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