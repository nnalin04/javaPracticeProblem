/**
 * The Employee check class
 */
public class EmpCheck {

	private static final int IS_PRESENT = 1;

	public static void main(final String[] args) {
		// Calling function

		int count = 0;
		double totalWage = 0;
		while (count < 20) {
			final boolean isPresent = empCheck();
			if (isPresent) {
				// Calling function
				final int empWorkHrs = empWorkHours();
				// Calling function
				final double wage = calulateWage(20, empWorkHrs);
				System.out.println("Employee is Present ==>");
				if (empWorkHrs == 8) {
					System.out.println("Employee is working FullTime ==>");
				} else {
					System.out.println("Employee is working HalfTime ==>");
				}
				count++;
				System.out.println("Total number of days Employee worked : " + count);
				totalWage += wage;
				System.out.println("Total Employee wage is : " + totalWage);
			} else {
				System.out.println("Employee is absent ==>");
				System.out.println("Total Employee wage is : 0.0");
			}
			System.out.println();
		}
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

}