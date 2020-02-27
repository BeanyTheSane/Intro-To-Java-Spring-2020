public class StudentSubscriber extends Subscriber{
    protected String schoolName;
    protected String studentId;

    public StudentSubscriber(String schoolName, String studentId, String firstName, String lastName, String address, String city, String state, String zip) {
        super(firstName, lastName, address, city, state, zip);
        this.schoolName = schoolName;
        this.studentId = studentId;
    }

}