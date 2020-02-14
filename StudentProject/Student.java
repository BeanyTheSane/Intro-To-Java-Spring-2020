import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Student {
    private String name;
    private String studentNumber;
	private String residencyCode;
	private ArrayList<Course> courses = new ArrayList<>();  
	
	Student(){}

	Student(String name, String studentNumber, ArrayList<Course> courses, String residencyCode) {
		this.name = name;
		this.studentNumber = studentNumber;
		this.residencyCode = residencyCode;
		this.courses = courses;
	}

	Student(String name, String studentNumber, ArrayList<Course> courses) {
		this.name = name;
		this.studentNumber = studentNumber;
		this.residencyCode = "INC";
		this.courses = courses;
	}

	Student(String name, String studentNumber, String residencyCode) {
		this.name = name;
		this.studentNumber = studentNumber;
		this.residencyCode = residencyCode;
	}

	Student(String name, String studentNumber) {
		this.name = name;
		this.studentNumber = studentNumber;
		this.residencyCode = "INC";
	}

	public String getResidencyCode() {
		return this.residencyCode; 
	}

	public void setResidencyCode(String residencyCode) {
		this.residencyCode = residencyCode;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStudentNumber() {
		return this.studentNumber;
	}

	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	public int getCreditHours() {
		int creditHours = 0;
		for (Course course : courses) {
			creditHours += course.getCreditHours();
		}
		return creditHours;
	}

	public void addCourse(Course course) {
		this.courses.add(course);
	}

	public void addCourseList(List<Course> courses) {
		for (Course course : courses) {
			addCourse(course);
		}
	}

    public Double getTuition() {
        double baseRate = this.residencyCode.equals("INC") ? TuitionRates.getInCountyBaseRate()
                        : this.residencyCode.equals("OOC") ? TuitionRates.getOutOfCountyBaseRate()
                        : this.residencyCode.equals("OOS") ? TuitionRates.getOutOfStateBaseRate()
                                                           : 0.0;
        if (getCreditHours() <= 13) {
            return baseRate * getCreditHours();
        } else if (getCreditHours() >= 13 && getCreditHours() <= 18) {
            return baseRate * TuitionRates.getCreditHourBonusRate();
        }
        
        return (getCreditHours() - TuitionRates.getCreditHourBonusRateOffset()) * baseRate;
	}
	
	public void buildRandomPerson(String residencyCode, int creditHours) {
		this.name = getRandomName();
		this.studentNumber = MyUtilities.generateRandomNumber(6).toString();
		this.residencyCode = residencyCode;
		this.courses = buildDefaultCourseList(creditHours);
			
	}

	public static ArrayList<Course> buildDefaultCourseList(int creditHours) {
		ArrayList<Course> defaultCourseList = new ArrayList<>();
		if (creditHours == 0 || creditHours == 1) {
			Course course = new Course();
			course.setDefaultNameAndIdByCreditHours(1);
			defaultCourseList.add(course);
		}
		else if ((creditHours % 3) == 0) {
			for (int i = 0; i < 3; i++) {
				Course course = new Course();
				course.setDefaultNameAndIdByCreditHours(creditHours / 3);
				defaultCourseList.add(course);			
			}
		}
		else if ((creditHours % 2) == 0) {
			for (int i = 0; i < 2; i++) {
				Course course = new Course();
				course.setDefaultNameAndIdByCreditHours(creditHours / 2);
				defaultCourseList.add(course);
			}
		}
		else {
			Course course = new Course();
			course.setDefaultNameAndIdByCreditHours(creditHours);
			defaultCourseList.add(course);
		}
		return defaultCourseList;
	}

	public String getDetailsAsString() {
		Locale locale = new Locale("en", "US");
		NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(locale);
		String response =  "Student " 
						+ getStudentNumber() 
						+ " " 
						+ getName() 
						+ " takes " 
						+ getCreditHours() 
						+ " credit hours, residency=" 
						+ getResidencyCode() 
						+ ", tuition = "
						+ currencyFormat.format(getTuition());
		if (doCreditHoursQualifyForSpecialRate()) {
			response += " **";
		}
		return response;
	}

	private boolean doCreditHoursQualifyForSpecialRate() {
		return (getCreditHours() >= TuitionRates.getCreditHourBonusRate() 
			   && getCreditHours() <= TuitionRates.getCreditHourBonusRate() + TuitionRates.getCreditHourBonusRateOffset());
	}

	private static String getRandomName() {
        String[] firstNames = { "Lucius", "Wallace", "Lacy", "Rafael", "Alfredo", "Malik", "Santos", "Roman",
            "Robin", "Marcos", "Winston", "Kenny", "Marlin", "Art", "Granville", "Kelvin", "Bobbie", "Lucas", "Prince",
            "Norberto", "Deandre", "Homer", "Mikel", "Cletus", "Fidel", "Janis", "Sandra", "Chanelle", "Trang",
            "Sharonda", "Cynthia", "Shakira", "Monet", "Salina", "Kiara", "Harriette", "Merna", "Joanne", "Evangeline",
            "Adriane", "Zada", "Natividad", "Deirdre", "Chere", "Karyn", "Lulu", "Keren", "Tinisha", "Jasmine",
			"Irina" };

		String[] lastNames = {"Beckmann", "Compo", "Pechacek", "Everts", "Ledwell", "Vermillion", "Leanos", 
		"Levingston", "Hosch","Shier", "Whitehorn", "Considine", "Solorio", "Patino", "Culver", "Franko", 
		"Northam", "Domina", "Mattern", "Stidham", "Causby", "Greenwalt", "Branan", "Maddocks", "Mathison", 
		"Lykes", "Cullen", "Button", "Presutti", "Old", "Gregory", "Saunder", "Meigs", "Voisine", "Gipson", 
		"Maddox", "Platner", "Pippen", "Swartout", "Briceno", "Liberty", "Mccranie", "Monico", "Laferriere", 
		"Gertz", "Martins", "Morford", "Smithey", "Orsi", "Scholl"};

		return MyUtilities.getRandomStringFromArray(firstNames) + " " + MyUtilities.getRandomStringFromArray(lastNames);
			
	}
}