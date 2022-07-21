/*
 * 규칙
 *  - answer과 choice를 비교해서 strike와 ball을 받음
 *  - 이때, 비교를 통해서 얻은 strike와 ball 값은 cases 내의 경우의 수들과 choice를 비교하여 얻는 compStrike와 compBall과 비교하게 된다
 *  - cases의 요소들과 choice를 비교했서 얻은 compStrike와 compBall 값과 위의 strike와 ball이 일치하지 않으면 answer이 될 수 없는 조건을 찾음
 *  - 위의 조건을 이용하여 완전 탐색을 해서 매 입력마다 cases의 요소를 지움
 */
package algorithmSolving;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	static ArrayList<String> cases = new ArrayList<>();
	static String answer;
	static int strike;
	static int ball;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int gameCount = 0;

		while (true) {
			System.out.print("1 ~ 9 까지 중복되지 않는 세자리 수를 입력해주세요 : ");
			answer = br.readLine();
			if (validation(Integer.parseInt(answer))) {
				break;
			}
			System.out.println();
		}
		initCase();

		while (true) {
			int random = (int) (Math.random() * cases.size());
			String choice = cases.remove(random);
			System.out.println("Bot : " + choice);
			getStrikeBall(choice);
			System.out.println("Strike : " + strike + ", Ball : " + ball);
			System.out.println();
			gameCount++;

			if (strike == 3 || cases.size() <= 1) {
				break;
			}

			for (int index = 0; index < cases.size(); index++) {
				index = removeElements(choice, index);
			}
		}

		System.out.println("정답을 찾는데 걸린 횟수 : " + gameCount);
	}

	// 평균 몇번에 맞추는지 테스트 위해서 랜덤 값을 입력으로 넣는 함수
	public static String randomInput() {
		while (true) {
			int temp = (int) (Math.random() * 987 + 1);
			if (validation(temp)) {
				return Integer.toString(temp);
			}
		}
	}

	// strike, ball 그리고 compStrike, compBall 을 비교하여 같지 않는 요소 제거
	public static int removeElements(String choice, int index) {
		int compStrike = 0;
		int compBall = 0;

		String caseWord = cases.get(index);
		for (int j = 0; j < 3; j++) {
			char choiceAlphabet = choice.charAt(j);

			if (choiceAlphabet == caseWord.charAt(j)) {
				compStrike++;
			} else {
				for (int k = 0; k < 3; k++) {
					if (choiceAlphabet == caseWord.charAt(k)) {
						compBall++;
					}
				}
			}
		}

		if (!(strike == compStrike && ball == compBall)) {
			cases.remove(index);
			index--;
		}
		return index;
	}

	// 프로그램이 랜덤으로 입력한 값과 answer을 비교해서 strike와 ball 값을 변경하는 함수
	public static void getStrikeBall(String choice) {
		strike = 0;
		ball = 0;
		for (int i = 0; i < 3; i++) {
			if (answer.charAt(i) == choice.charAt(i)) {
				strike++;
			} else {
				for (int j = 0; j < 3; j++) {
					if (answer.charAt(i) == choice.charAt(j)) {
						ball++;
					}
				}
			}
		}
	}

	// 맨 처음 가능한 모든 경우의 수를 cases 리스트에 add하는 함수
	public static void initCase() {
		int num = 123;
		while (num < 988) {
			if (validation(num)) {
				cases.add(Integer.toString(num));
			}
			num++;
		}
	}

	// answer 및 randomInput, initCase 함수를 사용할 때 유효성 검사하는 함수
	public static boolean validation(int num) {
		int[] temp = new int[3];
		temp[0] = num / 100;
		temp[1] = num / 10 % 10;
		temp[2] = num % 10;

		if (temp[0] == temp[1] || temp[0] == temp[2] || temp[1] == temp[2]) {
			return false;
		}
		if (temp[0] == 0 || temp[1] == 0 || temp[2] == 0) {
			return false;
		}
		return true;
	}

}