/*
 * author: Nazli Karalar
 */

public class Answers {
	private int answerNo;

	public Answers(int answerNo) {
		this.answerNo = answerNo;
	}

	public String createAnswers() {
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

	private String showAnswer1() {
		return "Answer1";
	}

	private String showAnswer2() {
		return "Answer2";
	}

	private String showAnswer3() {
		return "Answer3";
	}

	private String showAnswer4() {
		return "Answer4";
	}

	private String showAnswer5() {
		return "Answer5";
	}
}
