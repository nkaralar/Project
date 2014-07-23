/*
 * author: Nazli Karalar
 */

/**
 * This class finds which message comes to server 
 *
 */

public class Messages {
	private static boolean[] isSelected;

	public static String createMessages() {
		// it will be changed because of the CheckBoxController class
		isSelected = new boolean[5];
		CheckBoxController c = new CheckBoxController();
		isSelected = c.getIsSelected();
		String result = null;
		for (int i = 0; i < isSelected.length; i++) {
			if (isSelected[i] == true) {
				result = findMessage(i, result);
			}
		}
		return result;
	}

	private static String findMessage(int i, String result) {
		switch (i) {
		case 1:
			result = showMessage1();
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
