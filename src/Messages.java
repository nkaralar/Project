/*
 * author: Nazli Karalar
 */

public class Messages {
	private int msgNo;

	public Messages(int msgNo) {
		this.msgNo = msgNo;
	}

	public String createMessages() {
		String result = null;
		switch (msgNo) {
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

	private String showMessage1() {
		return "1";
	}

	private String showMessage2() {
		return "2";
	}

	private String showMessage3() {
		return "3";
	}

	private String showMessage4() {
		return "4";
	}

	private String showMessage5() {
		return "5";
	}
}
