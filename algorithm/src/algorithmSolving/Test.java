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

       System.out.println("3���� ���ڸ� �Է��Ͽ� ������ ���ּ��� (1~9)");

       a1 = scanner.nextInt();
       a2 = scanner.nextInt();
       a3 = scanner.nextInt();

       n1 = 3;
       n2 = 5;
       n3 = 7;

       if(a1==n1){  //ù��° �ڸ� ���ڰ� ���� ��� strikeCnt++
        strikeCnt++;
       }
       if(a2==n2){ //�ι�° �ڸ� ���ڰ� ���� ��� strikeCnt++
        strikeCnt++;
       }
       if(a3==n3){  //����° �ڸ� ���ڰ� ���� ��� strikeCnt++
        strikeCnt++;
       }
       if(a1==n2 || a1==n3){ // a1�� n2�� ���ų� a1�� n3�� ���� ��� ballCnt++
        ballCnt++;
       }
       if(a2==n1 || a2==n3){ // a2�� n1�� ���ų� a2�� n3�� ���� ��� ballCnt++
        ballCnt++;
       }
       if(a3==n1 || a3==n2){ // a3�� n1�� ���ų� a3�� n2�� ���� ��� ballCnt++
        ballCnt++;
       }

       System.out.println(n1+ " " +n2+ " " +n3+ " " +strikeCnt+ "S " +ballCnt+ "B");

       switch (strikeCnt) {
        case 1:
            //�ϳ��� �ڸ� �����ϰ� �ٲٱ�
            break;
        case 2:
            //
            break;
        case 3:
            System.out.println("�����Դϴ�!");
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