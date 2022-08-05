package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Prim {

	public static void main(String[] args) {
		ArrayList<Edge> edges = new ArrayList<Edge>();
		edges.add(new Edge(7, "A", "B"));
		edges.add(new Edge(5, "A", "D"));
		edges.add(new Edge(8, "B", "C"));
		edges.add(new Edge(9, "B", "D"));
		edges.add(new Edge(5, "C", "E"));
		edges.add(new Edge(7, "D", "E"));
		edges.add(new Edge(6, "D", "F"));
		edges.add(new Edge(7, "B", "E"));
		edges.add(new Edge(8, "E", "F"));
		edges.add(new Edge(9, "E", "G"));
		edges.add(new Edge(11, "F", "G"));

		System.out.println(primFunc("A", edges));
	}

	public static ArrayList<Edge> primFunc(String startNode, ArrayList<Edge> edges) {
		ArrayList<Edge> mst = new ArrayList<Edge>();
		ArrayList<String> connectedNode = new ArrayList<String>();
		HashMap<String, ArrayList<Edge>> adjacentEdges = new HashMap<String, ArrayList<Edge>>();

		ArrayList<Edge> adjacentEdgeList;
		Edge currentEdge, poppedEdge, adjacentEdge;

		for (int i = 0; i < edges.size(); i++) {
			currentEdge = edges.get(i);
			if (!adjacentEdges.containsKey(currentEdge.node1)) {
				adjacentEdges.put(currentEdge.node1, new ArrayList<Edge>());
			}
			if (!adjacentEdges.containsKey(currentEdge.node2)) {
				adjacentEdges.put(currentEdge.node2, new ArrayList<Edge>());
			}
		}

		for (int i = 0; i < edges.size(); i++) {
			currentEdge = edges.get(i);
			adjacentEdgeList = adjacentEdges.get(currentEdge.node1);
			adjacentEdgeList.add(new Edge(currentEdge.weight, currentEdge.node1, currentEdge.node2));
			adjacentEdgeList = adjacentEdges.get(currentEdge.node2);
			adjacentEdgeList.add(new Edge(currentEdge.weight, currentEdge.node2, currentEdge.node1));
		}

		PriorityQueue<Edge> minHeap = new PriorityQueue<Edge>();
		connectedNode.add(startNode);
		adjacentEdgeList = adjacentEdges.get(startNode);
		for (int i = 0; i < adjacentEdgeList.size(); i++) {
			minHeap.add(adjacentEdgeList.get(i));
		}

		while (minHeap.size() > 0) {
			poppedEdge = minHeap.poll();
			if (!connectedNode.contains(poppedEdge.node2)) {
				connectedNode.add(poppedEdge.node2);
				mst.add(new Edge(poppedEdge.weight, poppedEdge.node1, poppedEdge.node2));
				adjacentEdgeList = adjacentEdges.get(poppedEdge.node2);

				for (int i = 0; i < adjacentEdgeList.size(); i++) {
					adjacentEdge = adjacentEdgeList.get(i);
					if (!connectedNode.contains(adjacentEdge.node2)) {
						minHeap.add(new Edge(adjacentEdge.weight, adjacentEdge.node1, adjacentEdge.node2));
					}
				}
			}
		}

		return mst;
	}
}
