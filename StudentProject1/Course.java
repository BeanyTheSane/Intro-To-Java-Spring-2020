import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Pattern;

public class Course {
    final int minCreditHourPerCourse = 1;
    final int maxCreditHourPerCourse = 5;
    final String CreditHourPerCourseRegex = buildCreditHourPerCourseRegex();

    String courseId;
    String courseName;
    int creditHours;

    Course(){}

    Course(String courseId, String courseName, int creditHours) 
    throws CourseException {
        setCourseId(courseId);
        setCourseName(courseName);
        setCreditHours(creditHours);
    }

    public String getCourseId() {
        return this.courseId;
    }

    public void setCourseId(String courseId)  
    throws CourseException {
		final Pattern regexPattern = Pattern.compile("^[0-9]{3}$");
		if (!regexPattern.matcher(courseId).matches()) {
            throw new CourseException("The ID must be 3 digits long.  Try Again");
        }
        this.courseId = courseId;
    }

    public String getCourseName() {
        return this.courseName;
    }

    public void setCourseName(String courseName)  
    throws CourseException {
		final Pattern regexPattern = Pattern.compile("^.{1,32}$");
		if (!regexPattern.matcher(courseName).matches()) {
            throw new CourseException("Please limit names to less than 32 characters for this test.  Try Again");
        }
        this.courseName = courseName;
    }

    public int getCreditHours() {
        return this.creditHours;
    }

    public void setCreditHours(int creditHours)  
    throws CourseException {
		final Pattern regexPattern = Pattern.compile(CreditHourPerCourseRegex);
		if (!regexPattern.matcher(String.valueOf(creditHours)).matches()) {
            throw new CourseException("Please enter a number between " + minCreditHourPerCourse + " and " + maxCreditHourPerCourse + " inclusive.  Try Again");
        }
        this.creditHours = creditHours;
    }

    public void setDefaultNameAndIdByCreditHours(int creditHours)  
    throws CourseException {
        setCourseId("101");
        setCourseName("Test Course");
        setCreditHours(creditHours);
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
            return defaultCourseList;
        }
        else if (creditHours == 1) {
            Course course = new Course();
            try {
                course.setDefaultNameAndIdByCreditHours(1);
                defaultCourseList.add(course);
            } catch (NullPointerException e){
				System.out.println(e.toString());
            }
            catch (NumberFormatException e){
                    System.out.println(e.toString());
            }
            catch (CourseException e){
                    System.out.println(e.toString());
            }
            catch (Exception e){
                    System.out.println(e.toString());
            }
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
                    try {
                        course.setDefaultNameAndIdByCreditHours(randomCreditHour);
                        defaultCourseList.add(course);
                        subTotal += randomCreditHour;
                    } catch (NullPointerException e){
                        System.out.println(e.toString());
                    }
                    catch (NumberFormatException e){
                            System.out.println(e.toString());
                    }
                    catch (CourseException e){
                            System.out.println(e.toString());
                    }
                    catch (Exception e){
                            System.out.println(e.toString());
                    }
                }
                else {
                    total = creditHours;
                    lastCourse = creditHours - subTotal;
                    Course course = new Course();
                    try {
                        course.setDefaultNameAndIdByCreditHours(lastCourse);
                        defaultCourseList.add(course);
                    } catch (NullPointerException e){
                        System.out.println(e.toString());
                    }
                    catch (NumberFormatException e){
                            System.out.println(e.toString());
                    }
                    catch (CourseException e){
                            System.out.println(e.toString());
                    }
                    catch (Exception e){
                            System.out.println(e.toString());
                    }
                }
		    }
        }
		return defaultCourseList;
    }

    private String buildCreditHourPerCourseRegex() {
        return "^([" + minCreditHourPerCourse + "-" + maxCreditHourPerCourse + "])$";
    }
}