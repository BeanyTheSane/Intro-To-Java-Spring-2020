import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Student {
    private String name;
    private String studentNumber;
	private String residencyCode;
	private ArrayList<Course> courses = new ArrayList<>();  
	private ArrayList<Payment> payments = new ArrayList<>();
	
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

    public BigDecimal getTuition() {
        BigDecimal baseRate = this.residencyCode.equals(ResidentialCodes.INC.toString()) ? TuitionRates.getInCountyBaseRate()
                        : this.residencyCode.equals(ResidentialCodes.OOC.toString()) ? TuitionRates.getOutOfCountyBaseRate()
                        : this.residencyCode.equals(ResidentialCodes.OOS.toString()) ? TuitionRates.getOutOfStateBaseRate()
                                                           : BigDecimal.valueOf(0);
        if (getCreditHours() <= 13) {
            return baseRate.multiply(BigDecimal.valueOf(getCreditHours()));
        } else if (getCreditHours() >= 13 && getCreditHours() <= 18) {
            return baseRate.multiply(BigDecimal.valueOf(TuitionRates.getCreditHourBonusRate()));
        }
        
        return BigDecimal.valueOf(getCreditHours() - TuitionRates.getCreditHourBonusRateOffset()).multiply(baseRate);
	}
	
	public void buildRandomPerson(String residencyCode, int creditHours) {
		this.name = getRandomName();
		this.studentNumber = MyUtilities.generateRandomNumber(6).toString();
		this.residencyCode = residencyCode;
		this.courses = Course.buildDefaultCourseList(creditHours);
			
	}
	
	public void buildRandomPerson(String residencyCode, ArrayList<Course> courses) {
		this.name = getRandomName();
		this.studentNumber = MyUtilities.generateRandomNumber(6).toString();
		this.residencyCode = residencyCode;
		this.courses = courses;
			
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

	public BigDecimal getTotalPayments() {
		BigDecimal totalPayments =  BigDecimal.valueOf(0);

		for (Payment payment : this.payments) {
			totalPayments = totalPayments.add(payment.getPaymentAmount());
		}

		return totalPayments;
	}

	public void makePayment(BigDecimal paymentAmount, String description) {
		LocalDateTime dateOfPayment = LocalDateTime.now();

		Payment payment = new Payment(paymentAmount, dateOfPayment, description);
		this.payments.add(payment);
	}

	public ArrayList<Payment> getListOfPayments() {
		return this.payments;
	}

	public BigDecimal getTotalDue() {
		return getTuition().subtract(getTotalPayments());
	}

	public String getCourseList() {
		StringBuilder courseList = new StringBuilder();
		int runningTotal = 0;
		courseList.append("		Course List:\n");
		if (!this.courses.isEmpty()) {
			for (Course course : this.courses) {
				courseList.append("		" + course.getCourseDetailsAsString() + "\n");
				runningTotal += course.getCreditHours();
			}
			courseList.append("			Total Credit Hours: " + runningTotal);
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

		public static String getResidentialCodeAsString(ResidentialCodes code) {

			switch (code) {
				case INC:
					return "INC";

				case OOC:
					return "OOC";

				case OOS:
					return "OOS";
			
				default:
				return null;
			}
		}
    }
}