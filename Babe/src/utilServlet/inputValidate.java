package utilServlet;

public class inputValidate {
	private static boolean mismatch = false;
	private static boolean ssnInvalid = false;
	private static boolean zipcodeInvalid = false;
	private static boolean creditCardInvalid = false;
	

	private static boolean isNumber = false;
	public static boolean invalidNumber() {
		return isNumber;
	}

	public static void validateNumber(boolean m) {
		isNumber = m;
	}
	
	public static boolean creditCardInvalid() {
		return creditCardInvalid;
	}

	public static void validateCCD(boolean m) {
		creditCardInvalid = m;
	}
	
	public static boolean zipCodeInvalid() {
		return zipcodeInvalid;
	}

	public static void validateZip(boolean m) {
		zipcodeInvalid = m;
	}
	
	public static boolean ssnInvalid() {
		return ssnInvalid;
	}

	public static void validateSSN(boolean m) {
		ssnInvalid = m;
	}

	
	public static boolean isMismatch() {
		return mismatch;
	}

	public static void setMismatch(boolean m) {
		mismatch = m;
	}


}
