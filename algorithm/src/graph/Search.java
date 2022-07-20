package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Search {

	public static void main(String[] args) {
		
		HashMap<String, ArrayList<String>> graph = new HashMap<String, ArrayList<String>>();
		graph.put("A", new ArrayList<>(Arrays.asList("B", "C")));
		graph.put("B", new ArrayList<>(Arrays.asList("D")));
		graph.put("C", new ArrayList<>(Arrays.asList("G", "H", "I")));
		graph.put("D", new ArrayList<>(Arrays.asList("E","F")));
		graph.put("E", new ArrayList<>(Arrays.asList("D")));
		graph.put("F", new ArrayList<>(Arrays.asList("D")));
		graph.put("G", new ArrayList<>(Arrays.asList("C")));
		graph.put("H", new ArrayList<>(Arrays.asList("C")));
		graph.put("I", new ArrayList<>(Arrays.asList("C", "J")));
		graph.put("J", new ArrayList<>(Arrays.asList("I")));
		
		System.out.println(DFS(graph));
	}
	
	public static ArrayList<String> DFS(HashMap<String, ArrayList<String>> graph) {
		ArrayList<String> visited = new ArrayList<String>();
		ArrayList<String> needVisit = new ArrayList<String>();
		needVisit.add("A");
		
		while(needVisit.size() > 0) {
			String temp = needVisit.remove(needVisit.size() - 1);
			if(!visited.contains(temp)) {
				visited.add(temp);
				ArrayList<String> tempArr = graph.get(temp);
				int index = tempArr.size() - 1;
				while(index >= 0) {
					needVisit.add(tempArr.get(index--));
				}
			}
		}
		
		return visited;
	}

}
