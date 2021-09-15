package array;

import java.util.ArrayList;

public class JavaArrayList {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();	// int 형 데이터를 담을 수 있는 가변 길이의 배열 선언
		
		list.add(1);		// 배열에 아이템 추가
		list.add(2);
		System.out.println(list.get(0));		// 배열의 특정 아이템 가져옴
		
		list.set(0, 5);		// 특정 인덱스에 해당하는 아이템을 변경
		System.out.println(list.get(0));
		
		list.remove(0);		// 특정 인덱스에 해당하는 아이템을 삭제
		System.out.println(list.get(0));
		
		System.out.println(list.size());		// 배열의 길이 확인

	}

}
