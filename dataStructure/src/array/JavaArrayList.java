package array;

import java.util.ArrayList;

public class JavaArrayList {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();	// int �� �����͸� ���� �� �ִ� ���� ������ �迭 ����
		
		list.add(1);		// �迭�� ������ �߰�
		list.add(2);
		System.out.println(list.get(0));		// �迭�� Ư�� ������ ������
		
		list.set(0, 5);		// Ư�� �ε����� �ش��ϴ� �������� ����
		System.out.println(list.get(0));
		
		list.remove(0);		// Ư�� �ε����� �ش��ϴ� �������� ����
		System.out.println(list.get(0));
		
		System.out.println(list.size());		// �迭�� ���� Ȯ��

	}

}
