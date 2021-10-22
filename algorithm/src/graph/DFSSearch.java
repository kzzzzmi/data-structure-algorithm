package graph;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;

public class DFSSearch {

	public static void main(String[] args) {

		HashMap<String, ArrayList<String>> graph = new HashMap<>();
		
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
		
		System.out.println(dfsSearch(graph, "A"));		
		
	}
	
	public static ArrayList<String> dfsSearch(HashMap<String, ArrayList<String>> graph, String startNode) {
		ArrayList<String> visited = new ArrayList<>();
		ArrayList<String> needVisit = new ArrayList<>();
		needVisit.add(startNode);
		
		while(needVisit.size() > 0) {
			String node = needVisit.remove(needVisit.size() - 1);
			if(visited.contains(node) == false) {
				visited.add(node);
				needVisit.addAll(graph.get(node));
			}
		}
		
		return visited;
	}

}
