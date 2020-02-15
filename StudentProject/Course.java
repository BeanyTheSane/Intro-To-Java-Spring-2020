import java.util.ArrayList;
import java.util.Random;

public class Course {
    String courseId;
    String courseName;
    int creditHours;

    Course(){}

    Course(String courseId, String courseName, int creditHours) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.creditHours = creditHours;
    }

    public String getCourseId() {
        return this.courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return this.courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCreditHours() {
        return this.creditHours;
    }

    public void setCreditHours(int creditHours) {
        this.creditHours = creditHours;
    }

    public void setDefaultNameAndIdByCreditHours(int creditHours) {
        this.courseId = "101";
        this.courseName = "Test Course";
        this.creditHours = creditHours;
    }
    public String getCourseDetailsAsString() {
        StringBuilder courseDetails = new StringBuilder();

        courseDetails.append("Id #" + getCourseId());
        courseDetails.append(", Name: " + getCourseName());
        courseDetails.append(", Credit Hours: " + getCreditHours());

        return courseDetails.toString();
    }

    public static ArrayList<Course> buildDefaultCourseList(int creditHours) {
		ArrayList<Course> defaultCourseList = new ArrayList<>();
        
        if (creditHours == 0) {
            //this will end up returning an empty List
        }
        else if (creditHours == 1) {
			Course course = new Course();
			course.setDefaultNameAndIdByCreditHours(1);
			defaultCourseList.add(course);
		}
		else {
			int total = 0;
            int subTotal = 0;
            int lastCourse = 0;
            while (total != creditHours) {
                int randomCreditHour = new Random().nextInt(6-1) + 1;
                total += randomCreditHour;
                if (total < creditHours) {
                    Course course = new Course();
                    course.setDefaultNameAndIdByCreditHours(randomCreditHour);
                    defaultCourseList.add(course);
                    subTotal += randomCreditHour;
                }
                else {
                    total = creditHours;
                    lastCourse = creditHours - subTotal;
                    Course course = new Course();
                    course.setDefaultNameAndIdByCreditHours(lastCourse);
                    defaultCourseList.add(course);
                }
		    }
        }
		return defaultCourseList;
	}
}