package graph;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.Iterator;

public class BFSSearch {

	public static void main(String[] args) {
		
		HashMap<String, ArrayList<String>> graph = new HashMap<String, ArrayList<String>>();
		graph.put("A", new ArrayList<String>(Arrays.asList("B", "C")));
		graph.put("B", new ArrayList<String>(Arrays.asList("A", "D")));
		graph.put("C", new ArrayList<String>(Arrays.asList("A", "G", "H", "I")));
		graph.put("D", new ArrayList<String>(Arrays.asList("B", "E", "F")));
		graph.put("E", new ArrayList<String>(Arrays.asList("D")));
		graph.put("F", new ArrayList<String>(Arrays.asList("D")));
		graph.put("G", new ArrayList<String>(Arrays.asList("C")));
		graph.put("H", new ArrayList<String>(Arrays.asList("C")));
		graph.put("I", new ArrayList<String>(Arrays.asList("C", "J")));
		graph.put("J", new ArrayList<String>(Arrays.asList("I")));
		
		ArrayList<String> bfs = bfsSearch(graph, "A");
		System.out.println(bfs);
		
		Iterator<String> ir = graph.keySet().iterator();
		while(ir.hasNext()) {
			String key = ir.next();
			System.out.println(key + ", " + graph.get(key));
		}
		System.out.println("------------------------------------");
		for(Map.Entry<String, ArrayList<String>> entry : graph.entrySet()) {
			System.out.println(entry.getKey() + ", " + entry.getValue());
		}
		
	}
	
	public static ArrayList<String> bfsSearch(HashMap<String, ArrayList<String>> graph, String startNode) {
		ArrayList<String> visited = new ArrayList<String>();
		ArrayList<String> needVisit = new ArrayList<String>(Arrays.asList(startNode));
		
		while(needVisit.size() > 0) {
			String node = needVisit.remove(0);
			
			if(visited.contains(node) == false) {
				visited.add(node);
				needVisit.addAll(graph.get(node));
			}
		}
		return visited;
	}

}
