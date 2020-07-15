import java.util.Scanner;

/*
 * The Employee check class
 */
public class EmpCheck {

	private static final int IS_PRESENT = 1;

	public static void main(String[] args) {
		// Calling function
		final Scanner sc = new Scanner(System.in);

		System.out.println("Enter the total number of Days Employ have to work");
		// taking input for number of working Days
		final int maxDays = sc.nextInt();

		System.out.println("Enter the total number of Hours Employ have to work");
		// taking input for number of working Hours
		final int maxHours = sc.nextInt();

		System.out.println("Enter the Employ Wage for per Hour");
		// taking input for wage per hours
		final int perHrsWage = sc.nextInt();

		// Calling function
		empWage(maxDays, maxHours, perHrsWage);

		sc.close();
	}

	/**
	 * Check employee
	 * 
	 * @return true if employee present otherwise false.
	 */
	public static boolean empCheck() {
		return IS_PRESENT == Math.floor(Math.random() * 10) % 2;
	}

	/**
	 * Check employee Working Hours
	 * 
	 * @return numbers of hrs the employ worked.
	 */
	public static int empWorkHours() {

		final double timing = Math.floor(Math.random() * 10) % 2;
		final int value = (int) timing;

		switch (value) {
			case 1:
				return 8;
			case 0:
				return 4;
			default:
				return 0;
		}
	}

	/**
	 * Calculate employee wage based on params.
	 * 
	 * @param ratePerHrs the employee rate per hours.
	 * @param totalHrs   total employee hours.
	 * @return total employee wage.
	 */
	public static double calulateWage(final int ratePerHrs, final int totalHrs) {
		return ratePerHrs * totalHrs;
	}

	/**
	 * printing the Employ wage for everyDay.
	 * 
	 * @param maxDays    total number of days for the Employ to Work.
	 * @param maxHours   total number of hours for the Employ to Work.
	 * @param perHrsWage per hours wage for the employ.
	 */
	public static void empWage(final int maxDays, final int maxHours, final int perHrsWage) {

		int countDay = 1;
		int totalHrs = 0;
		double totalWage = 0;

		while (countDay <= maxDays && totalHrs <= maxHours) {

			final boolean isPresent = empCheck();

			if (isPresent) {

				// Calling function
				final int empWorkHrs = empWorkHours();

				totalHrs += empWorkHrs;

				// Calling function
				final double wage = calulateWage(perHrsWage, empWorkHrs);

				System.out.println("Employee is Present ==>");

				if (empWorkHrs == 8) {
					System.out.println("Employee is working FullTime ==>");
				} else {
					System.out.println("Employee is working HalfTime ==>");
				}

				System.out.println("Total number of days Employee worked : " + countDay);
				System.out.println("Total number of hours Employee worked : " + totalHrs);
				totalWage += wage;
				System.out.println("Total Employee wage is : " + totalWage);

			} else {

				System.out.println("Employee is absent ==>");
				System.out.println("Total number of days Employee worked : " + countDay);
				System.out.println("Total number of hours Employee worked : " + totalHrs);
				System.out.println("Total Employee wage is :" + totalWage);

			}

			countDay++;
			System.out.println();
		}
	}

}