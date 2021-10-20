package algorithmSolving;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {
	
	public static void main(String[] args) {
		HashMap<String, Integer> map = new HashMap<>();
		map.put("¿Î¿Î1", 12314);
		map.put("¿Î¿Î2", 12314);
		map.put("¿Î¿Î3", 12315);
		map.put("¿Î¿Î3", 12314);
		map.put("¿Î¿Î4", 12315);
		map.put("¿Î¿Î5", 12314);
		
		Iterator<String> ir  = map.keySet().iterator();
		while(ir.hasNext()) {
			String st = ir.next();
			if(st.equals("¿Î¿Î2")) {
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