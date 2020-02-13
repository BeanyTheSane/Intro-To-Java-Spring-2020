public class Lab4 {

    public static void main(String[] args) {

        runTuitionTest();
        
    }

    private static void runTuitionTest() {
        int testCaseLimit = 22;//general max number of credit hours reccomended
        // ArrayList<String> listOfInCountyStudents = new ArrayList<>();
        // ArrayList<String> listOfOutOfCountyStudents = new ArrayList<>();
        // ArrayList<String> listOfOutOfStateStudents = new ArrayList<>();

        //add lists to store each set as they are generated

        for (int i = 1; i <= testCaseLimit; i++) {
            Student inCountyStudent = new Student();
            Student outOfCountyStudent = new Student();
            Student outOfStateStudent = new Student();
            inCountyStudent.buildRandomPerson("INC", i);
            outOfCountyStudent.buildRandomPerson("OOC", i);
            outOfStateStudent.buildRandomPerson("OOS", i);
            //build a method to output the data of these students on Student in the format that I need (see canvas for format)
            //I don"t really like the way the following works, we have to create a second loop to unwind these lists, lets just print them out now.
            // listOfInCountyStudents.add(inCountyStudent.getDetailsAsString());
            // listOfOutOfCountyStudents.add(outOfCountyStudent.getDetailsAsString());
            // listOfOutOfStateStudents.add(outOfStateStudent.getDetailsAsString());

            System.out.println(inCountyStudent.getDetailsAsString());
            System.out.println(outOfCountyStudent.getDetailsAsString());
            System.out.println(outOfStateStudent.getDetailsAsString());
        }



    }
}