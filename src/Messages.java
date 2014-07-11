/*
 * author: Nazli Karalar
 */

public class Messages {

	public static String createMessages(int msgNo) {
		String result = null;
		switch (msgNo) {
		case 1:
			result = showMessage1();
			Math.abs(3);
			break;
		case 2:
			result = showMessage2();
			break;
		case 3:
			result = showMessage3();
			break;
		case 4:
			result = showMessage4();
			break;
		case 5:
			result = showMessage5();
			break;
		}
		return result;
	}

	private static String showMessage1() {
		return "1";
	}

	private static String showMessage2() {
		return "2";
	}

	private static String showMessage3() {
		return "3";
	}

	private static String showMessage4() {
		return "4";
	}

	private static String showMessage5() {
		return "5";
	}
}
