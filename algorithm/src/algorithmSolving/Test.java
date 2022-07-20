package algorithmSolving;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) throws Exception {

       Scanner scanner = new Scanner(System.in);

       int a1, a2, a3;
       int n1, n2, n3;
       int gameCnt = 0;
       int strikeCnt = 0;
       int ballCnt = 0;

       System.out.println("3개의 숫자를 입력하여 문제를 내주세요 (1~9)");

       a1 = scanner.nextInt();
       a2 = scanner.nextInt();
       a3 = scanner.nextInt();

       n1 = 3;
       n2 = 5;
       n3 = 7;

       if(a1==n1){  //첫번째 자리 숫자가 같을 경우 strikeCnt++
        strikeCnt++;
       }
       if(a2==n2){ //두번째 자리 숫자가 같을 경우 strikeCnt++
        strikeCnt++;
       }
       if(a3==n3){  //세번째 자리 숫자가 같을 경우 strikeCnt++
        strikeCnt++;
       }
       if(a1==n2 || a1==n3){ // a1이 n2와 같거나 a1이 n3가 같을 경우 ballCnt++
        ballCnt++;
       }
       if(a2==n1 || a2==n3){ // a2와 n1이 같거나 a2와 n3가 같을 경우 ballCnt++
        ballCnt++;
       }
       if(a3==n1 || a3==n2){ // a3와 n1이 같거나 a3와 n2가 같은 경우 ballCnt++
        ballCnt++;
       }

       System.out.println(n1+ " " +n2+ " " +n3+ " " +strikeCnt+ "S " +ballCnt+ "B");

       switch (strikeCnt) {
        case 1:
            //하나씩 자리 고정하고 바꾸기
            break;
        case 2:
            //
            break;
        case 3:
            System.out.println("정답입니다!");
            break;
       }

       switch (ballCnt) {
        case 1:
            break;
        case 2:
            break;
        case 3:
            break;
       }

    }

}