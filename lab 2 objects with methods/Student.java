import java.text.NumberFormat;
import java.util.Locale;

public class Student {
    private String name;
    private String studentNumber;
    private int creditHours;
	private String residencyCode;

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
		return this.creditHours;
	}

	public void setCreditHours(int creditHours) {
		this.creditHours = creditHours;
	}

    public Double getTuition() {
        double baseRate = this.residencyCode.equals("INC") ? TuitionRates.getInCountyBaseRate()
                        : this.residencyCode.equals("OOC") ? TuitionRates.getOutOfCountyBaseRate()
                        : this.residencyCode.equals("OOS") ? TuitionRates.getOutOfStateBaseRate()
                                                           : 0.0;
        if (this.creditHours <= 13) {
            return baseRate * this.creditHours;
        } else if (this.creditHours >= 13 && this.creditHours <= 18) {
            return baseRate * TuitionRates.getCreditHourBonusRate();
        }
        
        return (this.creditHours - TuitionRates.getCreditHourBonusRateOffset()) * baseRate;
	}
	
	public void buildRandomPerson(String residencyCode, int creditHours) {
		this.name = getRandomName();
		this.studentNumber = MyUtilities.generateRandomNumber(6).toString();
		this.creditHours = creditHours;
		this.residencyCode = residencyCode;
	}

	public String getDetailsAsString() {
		Locale locale = new Locale("en", "US");
		NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(locale);
		String response =  "Student " 
						+ this.studentNumber 
						+ " " 
						+ this.name 
						+ " takes " 
						+ this.creditHours 
						+ " credit hours, resideny=" 
						+ this.residencyCode 
						+ ", tuition = "
						+ currencyFormat.format(getTuition());
		if (doCreditHoursQualifyForSpecialRate()) {
			response += " **";
		}
		return response;
	}

	private boolean doCreditHoursQualifyForSpecialRate() {
		return (this.creditHours >= TuitionRates.getCreditHourBonusRate() 
			   && this.creditHours <= TuitionRates.getCreditHourBonusRate() + TuitionRates.getCreditHourBonusRateOffset());
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