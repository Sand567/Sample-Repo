package com.sandeep.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class DirectedCyclicGraph {
	
	private int v;
	private List<List<Integer>> adj;
	
	public DirectedCyclicGraph(int v) {
		this.v = v;
		adj = new ArrayList<>(v);
		
		for (int i = 0; i < v; i++) {
			adj.add(new LinkedList<>());
		}
	}

	public static void main(String[] args) {
		
		DirectedCyclicGraph graph = new DirectedCyclicGraph(4); 
		
        graph.addEdge(0, 1); 
        graph.addEdge(0, 2); 
        graph.addEdge(1, 2); 
        graph.addEdge(2, 0); 
        graph.addEdge(2, 3); 
        graph.addEdge(3, 3); 
        
        if (graph.isCyclic()) {
        	System.out.println("Graph is cyclic");
        } else {
        	System.out.println("Graph is acyclic");
        }
        
	}
	
	private void addEdge(int source, int dest) {
		adj.get(source).add(dest);
	}
	
	private boolean isCyclic() {
		boolean[] visited = new boolean[v];
		boolean[] recStack = new boolean[v];
		
		for (int i = 0; i < v; i++) {
			if (isCyclicUtil(i, visited, recStack)) {
				return true;
			}
		}
		
		return false;
	}

	private boolean isCyclicUtil(int i, boolean[] visited, boolean[] recStack) {
		
		System.out.println("visited: " + Arrays.toString(visited));
		System.out.println("recStack: " + Arrays.toString(recStack));
		System.out.println();
		
		if (recStack[i]) {
			return true;
		}
		
		if (visited[i]) {
			return false;
		}
		
		visited[i] = true;
		recStack[i] = true;
		List<Integer> children = adj.get(i);
		
		for (Integer child : children) {
			if (isCyclicUtil(child, visited, recStack)) {
				return true;
			}
		}
		
		recStack[i] = false;
		return false;
		
	}

}
