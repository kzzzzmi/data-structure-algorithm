package algorithmSolving;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {
	
	public static void main(String[] args) {
		HashMap<String, Integer> map = new HashMap<>();
		map.put("����1", 12314);
		map.put("����2", 12314);
		map.put("����3", 12315);
		map.put("����3", 12314);
		map.put("����4", 12315);
		map.put("����5", 12314);
		
		Iterator<String> ir  = map.keySet().iterator();
		while(ir.hasNext()) {
			String st = ir.next();
			if(st.equals("����2")) {
				System.out.println(st);
			}
		}
		
		for(Map.Entry<String, Integer> entry : map.entrySet()) {
			if(entry.getValue() == 12315) {
				System.out.println(entry.getKey());
			}
		}
		
		
	}
	
}