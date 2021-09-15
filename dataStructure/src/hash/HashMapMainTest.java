package hash;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Hashtable;
import java.util.HashMap;

public class HashMapMainTest {

	public static void main(String[] args) {

		HashSet<Integer> set1 = new HashSet<>();
		//Hashtable<String, Integer> table = new Hashtable<>();
		HashMap<String, Integer> map1 = new HashMap<String, Integer>();
		
		//table.put("안", null); table은 null을 value로 가질 수 없음
		map1.put("안", null);
		
		set1.add(10);
		set1.add(10);
		set1.add(10);
		set1.add(10);
		set1.add(50);
		set1.add(5);
		
		for(Integer i : set1) {
			System.out.println(i);
		}
		
		
		Iterator iter = set1.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		for(String i : map1.keySet()) {
			System.out.println(map1.get(i));
		}

	}

}
