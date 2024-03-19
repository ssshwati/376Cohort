package com.wileyedge.algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class DijkstraAlgorithm {
	static class Edge {
		char source;
		char destination;
		int weight;

		public Edge(char source, char destination, int weight) {
			this.source = source;
			this.destination = destination;
			this.weight = weight;
		}
	}

	static class Graph {
		int vertices;
		LinkedList<Edge>[] adjacencylist;
		boolean[] visited;

		Graph(int vertices) {
			this.vertices = vertices;
			adjacencylist = new LinkedList[vertices];
			visited = new boolean[vertices];
			// initialize adjacency lists for all the vertices
			for (int i = 0; i < vertices; i++) {
				adjacencylist[i] = new LinkedList<>();
			}
		}

		public void addEgde(char source, char destination, int weight) {
			int sourceIndex = source - 'A';
			int destinationIndex = destination - 'A';

			Edge edge = new Edge(source, destination, weight);
			adjacencylist[sourceIndex].addFirst(edge); // for directed graph
		}

		public void printGraph() {
			for (int i = 0; i < vertices; i++) {
				LinkedList<Edge> list = adjacencylist[i];
				for (int j = 0; j < list.size(); j++) {
					System.out.println("vertex-" + (char) ('A' + i) + " is connected to " + list.get(j).destination
							+ " with weight " + list.get(j).weight);
				}
			}
		}

		public int dijkstra(char source, char destination) {
			int sourceIndex = source - 'A';
			int destinationIndex = destination - 'A';

			int[] distance = new int[vertices];
			Arrays.fill(distance, Integer.MAX_VALUE);
			distance[sourceIndex] = 0;
			
			for (int i = 0; i < vertices - 1; i++) {
				int minDistance = Integer.MAX_VALUE;
				int minIndex = -1;

				for (int j = 0; j < vertices; j++) {
					if (!visited[j] && distance[j] < minDistance) {
						minDistance = distance[j];
						minIndex = j;
					}
				}

				if (minIndex == -1) {
					break; // All remaining vertices are unreachable
				}

				visited[minIndex] = true;

				LinkedList<Edge> edges = adjacencylist[minIndex];
				for (Edge edge : edges) {
					int newDistance = distance[minIndex] + edge.weight;

					if (newDistance < distance[edge.destination - 'A']) {
						distance[edge.destination - 'A'] = newDistance;
					}
				}
			}
			return distance[destinationIndex];
		}
	}

	public static void main(String[] args) {
		int vertices = 6;
		Graph graph = new Graph(vertices);
		graph.addEgde('A', 'B', 2);
		graph.addEgde('A', 'D', 8);
		graph.addEgde('B', 'D', 5);
		graph.addEgde('B', 'E', 6);
		graph.addEgde('D', 'E', 3);
		graph.addEgde('D', 'F', 2);
		graph.addEgde('E', 'F', 1);
		graph.addEgde('E', 'C', 9);
		graph.addEgde('F', 'C', 3);
		graph.printGraph();
		System.out.println("Minimum distance from A to C : " + graph.dijkstra('A', 'C'));
	}

}
