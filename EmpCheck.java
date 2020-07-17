public class EmpCheck {

	public static void main(final String[] args) {
		final EmpWageBuilderArray companyWage = new EmpWageBuilderArray();
		// For Apple
		companyWage.addCpompnyEmployWage("Apple", 20, 20, 100);
		// For Samsung
		companyWage.addCpompnyEmployWage("samsung", 22, 30, 120);

		companyWage.printEmpWage();

	}
}

class EmpWageBuilderArray {
	private static final int IS_PART_TIME = 1;
	private static final int IS_FULL_TIME = 2;

	private int numOfCompany = 0;
	private final Company[] companyWageArray;

	public EmpWageBuilderArray() {
		companyWageArray = new Company[5];
	}

	public static int computeEmpWage(final Company company) {
		// variables
		int empHrs = 0, totalHrs = 0, totalWorkingDays = 0;

		while (totalHrs <= company.getMaxHrsInMonth() && totalWorkingDays < company.getTotalWorkingDays()) {
			totalWorkingDays++;
			final int value = (int) Math.floor(Math.random() * 10) % 3;
			switch (value) {
				case IS_PART_TIME:
					empHrs = 4;
					break;
				case IS_FULL_TIME:
					empHrs = 8;
					break;
				default:
					empHrs = 0;
					break;
			}
			totalHrs += empHrs;
			System.out.println("Day#: " + totalWorkingDays + " Emp Hrs: " + empHrs + " total Emp Emp Hrs: " + totalHrs);
		}
		final int totalWage = totalHrs * company.getEmpRate();
		return totalWage;
	}

	public void printEmpWage() {
		for (int i = 0; i < numOfCompany; i++) {
			companyWageArray[i].setTotalEmpWage(EmpWageBuilderArray.computeEmpWage(companyWageArray[i]));
			System.out.println(companyWageArray[i]);
		}
	}

	public void addCpompnyEmployWage(final String companyName, final int companyWage, final int workingDays,
			final int workingHours) {
		companyWageArray[numOfCompany] = new Company(companyName, companyWage, workingDays, workingHours);
		numOfCompany++;
	}
}

class Company {

	private String name;

	private int empRate;

	private int totalWorkingDays;

	private int maxHrsInMonth;

	private int totalEmpWage;

	public Company() {
	}

	public Company(final String name, final int empRate, final int totalWorkingDays, final int maxHrsInMonth) {
		this.name = name;
		this.empRate = empRate;
		this.totalWorkingDays = totalWorkingDays;
		this.maxHrsInMonth = maxHrsInMonth;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setEmpRate(final int empRate) {
		this.empRate = empRate;
	}

	public int getEmpRate() {
		return empRate;
	}

	public void setTotalWorkingDays(final int totalWorkingDays) {
		this.totalWorkingDays = totalWorkingDays;
	}

	public int getTotalWorkingDays() {
		return totalWorkingDays;
	}

	public void setMaxHrsInMonth(final int maxHrsInMonth) {
		this.maxHrsInMonth = maxHrsInMonth;
	}

	public int getMaxHrsInMonth() {
		return maxHrsInMonth;
	}

	public void setTotalEmpWage(final int totalEmpWage) {
		this.totalEmpWage = totalEmpWage;
	}

	public int getTotalEmpWage() {
		return totalEmpWage;
	}

	@Override
	public String toString() {
		return "total Employ wage for the company " + name + " is " + totalEmpWage;
	}
}