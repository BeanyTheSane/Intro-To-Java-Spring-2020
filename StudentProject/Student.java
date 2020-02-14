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

	Student(String name, String studentNumber, ArrayList<Course> courses, ResidentialCodes residencyCode) {
		this.name = name;
		this.studentNumber = studentNumber;
		this.residencyCode = residencyCode.toString();
		this.courses = courses;
	}

	Student(String name, String studentNumber, ArrayList<Course> courses) {
		this.name = name;
		this.studentNumber = studentNumber;
		this.residencyCode = ResidentialCodes.INC.toString();
		this.courses = courses;
	}

	Student(String name, String studentNumber, ResidentialCodes residencyCode) {
		this.name = name;
		this.studentNumber = studentNumber;
		this.residencyCode = residencyCode.toString();
	}

	Student(String name, String studentNumber) {
		this.name = name;
		this.studentNumber = studentNumber;
		this.residencyCode = ResidentialCodes.INC.toString();
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
        double baseRate = this.residencyCode.equals(ResidentialCodes.INC.toString()) ? TuitionRates.getInCountyBaseRate()
                        : this.residencyCode.equals(ResidentialCodes.OOC.toString()) ? TuitionRates.getOutOfCountyBaseRate()
                        : this.residencyCode.equals(ResidentialCodes.OOS.toString()) ? TuitionRates.getOutOfStateBaseRate()
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
		this.courses = Course.buildDefaultCourseList(creditHours);
			
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

	public String getCourseList() {
		StringBuilder courseList = new StringBuilder();
		courseList.append("		Course List:\n");
		if (!this.courses.isEmpty()) {
			for (Course course : this.courses) {
				courseList.append("		" + course.getCourseDetailsAsString() + "\n");
			}
			return courseList.toString();
		}
		courseList.append("		This Student has not signed up for any classes yet");
		return courseList.toString();
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

	public static enum ResidentialCodes {
        INC(1),
        OOC(2),
		OOS(3);
		private int value;

		private ResidentialCodes(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}

		public static ResidentialCodes getResidentialCodeById(int id) {

			ResidentialCodes code = null;

			switch (id) {
				case 1:
					code = INC;
					break;

				case 2:
					code = OOC;
					break;

				case 3:
					code = OOS;
					break;	
			
				default:
					break;
			}

			return code;
		}
    }
}