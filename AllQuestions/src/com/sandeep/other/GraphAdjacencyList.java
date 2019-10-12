package com.sandeep.other;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class GraphAdjacencyList {
	
	private Map<Integer, List<Integer>> adjacencyList = new HashMap<>();

	public GraphAdjacencyList(int numberOfVertices) {
		for (int i = 1; i <= numberOfVertices; i++) {
			adjacencyList.put(i, new LinkedList<>());
		}
	}

	public static void main(String[] args) {
		
		int source = 0;
		int destination = 0;
		int numberOfEdges;
		int numberOfVertices;
		int count = 1;
		
		GraphAdjacencyList graphAdjacencyList = null;
		
		Scanner scanner = new Scanner(System.in);
		try {
			
			// reading the number of vertices and edges in the graph
			System.out.println("Enter the number of vertices and edges in the graph: ");
			numberOfVertices = scanner.nextInt();
			numberOfEdges = scanner.nextInt();
			
			System.out.println("Enter the vertices");
			for (int i = 0; i < numberOfVertices; i++) {
				graphAdjacencyList = new GraphAdjacencyList(scanner.nextInt());
			}
			
			System.out.println("Enter the edges in graph Format : <source index> <destination index>");
			
			while (count <= numberOfEdges) {
				
				source = scanner.nextInt();
				destination = scanner.nextInt();
				
				if (graphAdjacencyList != null) {
					graphAdjacencyList.setEdge(source, destination);
				}
				
				count++;
			}
			
			System.out.println("Adjacency list for a graph");
			for (int i = 1; i <= numberOfVertices; i++) {
				System.out.print(i + " ");
				
                List<Integer> edgeList = graphAdjacencyList.getEdge(i);
                
                if (edgeList.size() == 0) {
                	System.out.println("none");
                }
                    
                for (int j = 1; j <= edgeList.size(); j++) {
                    if (j != edgeList.size()) {
                        System.out.print(edgeList.get(j - 1) + ", ");
                    } else {
                        System.out.print(edgeList.get(j - 1));
                        break;
                    }
                }
                
                System.out.println();
			}
			
			
		} catch (InputMismatchException e) {
			System.out.println("Error in Input Format. \nFormat : <source index> <destination index>");
			e.printStackTrace();
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
		
		

	}

	private List<Integer> getEdge(int i) {
		return null;
	}

	private void setEdge(int source2, int destination2) {
		
	}

}
