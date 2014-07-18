
/*
 * author: Nazli Karalar
 */

public class Answers {

	public static String createAnswers(int answerNo) {
		String answer = null;
		switch (answerNo) {
		case 1:
			answer = showAnswer1();
			break;
		case 2:
			answer = showAnswer2();
			break;
		case 3:
			answer = showAnswer3();
			break;
		case 4:
			answer = showAnswer4();
			break;
		case 5:
			answer = showAnswer5();
			break;
		}
		return answer;
	}

	private static String showAnswer1() {
		return "Answer1";
	}

	private static String showAnswer2() {
		return "Answer2";
	}

	private static String showAnswer3() {
		return "Answer3";
	}

	private static String showAnswer4() {
		return "Answer4";
	}

	private static String showAnswer5() {
		return "Answer5";
	}
}
