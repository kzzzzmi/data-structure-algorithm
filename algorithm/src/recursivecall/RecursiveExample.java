package recursivecall;

import java.util.ArrayList;
import java.util.Arrays;

public class RecursiveExample {

	public static void main(String[] args) {
		System.out.println(factorial(4));
		System.out.println(arraySum(new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10))));
		System.out.println(makeNum(6));
	}
	
	public static int factorial(int num) {
		if(num <= 1) {
			return 1;
		}
		return num * factorial(num - 1);
	}
	
	public static int arraySum(ArrayList<Integer> array) {
		if(array.size() <= 0) {
			return 0;
		}
		return array.get(0) + arraySum(new ArrayList<>(array.subList(1, array.size())));		
	}
	
	public static int makeNum(int num) {
		if(num == 1) {
			return 1;
		} else if(num == 2) {
			return 2;
		} else if(num == 3) {
			return 4;
		}
		return makeNum(num - 1) + makeNum(num - 2) + makeNum(num - 3);
	}

}