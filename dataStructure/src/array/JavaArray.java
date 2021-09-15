package array;

import java.util.Arrays;

public class JavaArray {

	public static void main(String[] args) {
		
		// 배열을 미리 선언하고, 데이터를 넣음
		Integer[] dataList = new Integer[10];
		dataList[0] = 1;
		System.out.println(dataList[0]);
		
		// 배열을 선언 시 직접 데이터를 넣음
		Integer dataList0[] = {1, 2, 3, 4, 5};
		System.out.println(dataList0[0]);
		
		// Arrays 클래스를 활용하여 배열의 전체 데이터 출력
		System.out.println(Arrays.toString(dataList0));

	}

}
