/*
 * ��Ģ
 *  - answer�� choice�� ���ؼ� strike�� ball�� ����
 *  - �̶�, �񱳸� ���ؼ� ���� strike�� ball ���� cases ���� ����� ����� choice�� ���Ͽ� ��� compStrike�� compBall�� ���ϰ� �ȴ�
 *  - cases�� ��ҵ�� choice�� ���߼� ���� compStrike�� compBall ���� ���� strike�� ball�� ��ġ���� ������ answer�� �� �� ���� ������ ã��
 *  - ���� ������ �̿��Ͽ� ���� Ž���� �ؼ� �� �Է¸��� cases�� ��Ҹ� ����
 */

package algorithmSolving;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
<<<<<<< HEAD

public class Main {
	
	static int funcCount = 1;
=======
import java.util.ArrayList;

<<<<<<< HEAD
=======
>>>>>>> 49f911d374a427addc75b94351764a995965fbbf

>>>>>>> 90426cf3bc4cf1b2d0d811ba102bf05fd85ae847
public class Main {

	static ArrayList<String> cases = new ArrayList<>();
	static String answer;
	static int strike;
	static int ball;

	public static void main(String[] args) throws IOException {
<<<<<<< HEAD
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int[] fibonacci = new int[41];
		fibonacci[1] = 1;
		fibonacci[2] = 1;
		
		int fibCount = 0;
		for(int i = 3; i <= num; i++) {
			fibonacci[i] = fibonacci[i-1] + fibonacci[i-2];
			fibCount++;
		}
		fibonacci(num);
		
		System.out.println(funcCount + " " + fibCount);
	}
	
	public static int fibonacci(int num) {
		if(num <= 2) {
			return 1;
		}
		funcCount++;
		return fibonacci(num - 1) + fibonacci(num - 2);
=======

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int allGameCount = 0;
		int count = 0;

		while (count < 1) {
			while (true) {
				System.out.print("1 ~ 9 ���� �ߺ����� �ʴ� ���ڸ� ���� �Է����ּ��� : ");
				answer = br.readLine();
				if (validation(Integer.parseInt(answer))) {
					break;
				}
				System.out.println();
			}
//			answer = randomInput();
			initCase();

			while (true) {
				int random = (int) (Math.random() * cases.size());
				String choice = cases.remove(random);
				System.out.println("Bot : " + choice);
				getStrikeBall(choice);
				System.out.println("Strike : " + strike + ", Ball : " + ball);
				System.out.println();
				allGameCount++;

				if (strike == 3 || cases.size() <= 1) {
					break;
				}

				for (int index = 0; index < cases.size(); index++) {
					removeElements(choice, index);
				}
			}
			count++;
		}
		System.out.println(count + "�� ���� ��� ������ ã�µ� �ɸ� Ƚ�� ��� : " + allGameCount / count);
	}

	// strike, ball �׸��� compStrike, compBall �� ���Ͽ� ���� �ʴ� ��� ����
	public static void removeElements(String choice, int index) {
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
		}
	}

	// ��� ����� ���ߴ��� �׽�Ʈ ���ؼ� ���� ���� �Է����� �ִ� �Լ�
	public static String randomInput() {
		while (true) {
			int temp = (int) (Math.random() * 987 + 1);
			if (validation(temp)) {
				return Integer.toString(temp);
			}
		}
	}

	// ���α׷��� �������� �Է��� ���� answer�� ���ؼ� strike�� ball ���� �����ϴ� �Լ�
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

	// �� ó�� ������ ��� ����� ���� cases ����Ʈ�� add�ϴ� �Լ�
	public static void initCase() {
		int num = 123;
		while (num < 988) {
			if (validation(num)) {
				cases.add(Integer.toString(num));
			}
			num++;
		}
	}

	// answer �� randomInput, initCase �Լ��� ����� �� ��ȿ�� �˻��ϴ� �Լ�
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
<<<<<<< HEAD
		return true;
=======
		return false;
>>>>>>> 49f911d374a427addc75b94351764a995965fbbf
>>>>>>> 90426cf3bc4cf1b2d0d811ba102bf05fd85ae847
	}
}