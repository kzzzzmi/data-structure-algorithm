package array;

import java.util.Arrays;

public class JavaArray {

	public static void main(String[] args) {
		
		// �迭�� �̸� �����ϰ�, �����͸� ����
		Integer[] dataList = new Integer[10];
		dataList[0] = 1;
		System.out.println(dataList[0]);
		
		// �迭�� ���� �� ���� �����͸� ����
		Integer dataList0[] = {1, 2, 3, 4, 5};
		System.out.println(dataList0[0]);
		
		// Arrays Ŭ������ Ȱ���Ͽ� �迭�� ��ü ������ ���
		System.out.println(Arrays.toString(dataList0));

	}

}
