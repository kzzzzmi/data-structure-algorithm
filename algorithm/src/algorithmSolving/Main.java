package algorithmSolving;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Set;

public class Main {
	
	static int[] array;
	static HashMap<Integer, Integer> modeArray = new HashMap<Integer, Integer>();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		array = new int[num];
		
		for(int i = 0; i < array.length; i++) {
			int value = Integer.parseInt(br.readLine());;
			modeArray.put(value, modeArray.containsKey(value) ? modeArray.get(value) + 1 : 1);
			array[i] = value;
		}
		Arrays.sort(array);
		
		StringBuilder sb = new StringBuilder();
		sb.append(average()).append('\n');
		sb.append(middleValue()).append('\n');
		sb.append(mode()).append('\n');
		sb.append(range());
		
		System.out.println(sb);
		
	}
	
	public static int range() {
		return array[array.length - 1] - array[0];
	}
	
	public static int mode() {
		Set<Integer> keySet = modeArray.keySet();
		ArrayList<Integer> maxKey = new ArrayList<>();
		
		int maxValue = 0;
		
		for(int i : keySet) {
			if(modeArray.get(i) > maxValue) {
				maxKey.clear();
				maxKey.add(i);
				maxValue = modeArray.get(i);
			} else if(modeArray.get(i) == maxValue) {
				maxKey.add(i);
			}
		}
		
		if(maxKey.size() == 1) {
			return maxKey.get(0);
		} else {
			maxKey.sort(new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					return o1 - o2;
				}
			});
			return maxKey.get(1);
		}
		
	}
	
	public static int average() {
		int sum = 0;
		for(int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		
		double avg = ((double) sum / array.length);
		int result;
		if(avg >= 0) {
			result = (int)(avg + 0.5);
		} else {
			result = (int)(avg - 0.5);
		}
		return result;
	}
	
	public static int middleValue() {
		return array[array.length / 2];
	}

}