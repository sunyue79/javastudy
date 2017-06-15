/**
 * 
 */
package com.sunyue.study.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

/**
 * Find the shortest distance and path from given vertex to each vertexes
 * 
 * http://www.cnblogs.com/he-px/p/6677063.html
 * 
 * @author sunyue7
 *
 */
public class Dijkstra {

	static int MAX = Integer.MAX_VALUE - 1000;

	// vertexes
	static int A = 0;
	static int B = 1;
	static int C = 2;
	static int D = 3;
	static int E = 4;
	static int F = 5;
	static int G = 6;

	static int[] A2 = new int[] { 0, 12, MAX, MAX, MAX, 16, 14 };
	static int[] B2 = new int[] { 12, 0, 10, MAX, MAX, 7, MAX };
	static int[] C2 = new int[] { MAX, 10, 0, 3, 5, 6, MAX };
	static int[] D2 = new int[] { MAX, MAX, 3, 0, 4, MAX, MAX };
	static int[] E2 = new int[] { MAX, MAX, 5, 4, 0, 2, 8 };
	static int[] F2 = new int[] { 16, 7, 6, MAX, 2, 0, 9 };
	static int[] G2 = new int[] { 14, MAX, MAX, MAX, 8, 9, 0 };
	static int[][] matrix = new int[][] { A2, B2, C2, D2, E2, F2, G2 };

	static int[] dis = new int[7];
	@SuppressWarnings("unchecked")
	static List<Integer>[] path = new List[7];;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int givenVertex = 3;// D
		findShortestDistanceFrom(givenVertex);
		for (int d : dis) {
			System.out.print(d + " ");
		}
		System.out.println();
		System.out.println(" ================================ ");
		for (List<Integer> l : path) {
			if (l != null) {
				for (Integer i : l) {
					System.out.print(i + " ");
				}
			}
			System.out.println();
		}
	}

	/**
	 * @param givenVertex
	 * @return
	 */
	private static void findShortestDistanceFrom(int givenVertex) {
		HashMap<Integer, Vertex> known = new HashMap<Integer, Vertex>();
		known.put(givenVertex, new Vertex(givenVertex, givenVertex));
		HashMap<Integer, Vertex> unknown = new HashMap<Integer, Vertex>();
		unknown.put(A, new Vertex(A, givenVertex));
		unknown.put(B, new Vertex(B, givenVertex));
		unknown.put(C, new Vertex(C, givenVertex));
		unknown.put(D, new Vertex(D, givenVertex));
		unknown.put(E, new Vertex(E, givenVertex));
		unknown.put(F, new Vertex(F, givenVertex));
		unknown.put(G, new Vertex(G, givenVertex));
		unknown.remove(givenVertex);
		while (!unknown.isEmpty()) {
			Iterator<Entry<Integer, Vertex>> ite = unknown.entrySet().iterator();
			// find the closest vertex
			int shortest = MAX;
			Vertex closest = null;
			for (Vertex v : unknown.values()) {
				if (v.distance < shortest) {
					shortest = v.distance;
					closest = v;
				}
			}
			// put and remember distance
			known.put(closest.id, closest);
			dis[closest.id] = closest.distance;
			path[closest.id] = closest.path;
			// update distance in unknown
			for (; ite.hasNext();) {
				Vertex v = ite.next().getValue();
				if (v.id == closest.id) {
					ite.remove();
				} else {
					if (closest.distance + matrix[closest.id][v.id] < v.distance) {
						v.distance = closest.distance + matrix[closest.id][v.id];
						v.path = new ArrayList<Integer>();
						v.path.addAll(closest.path);
						v.path.add(v.id);
					}
				}
			}
		}
	}

}

class Vertex {
	int id;
	int distance;
	ArrayList<Integer> path = new ArrayList<Integer>();

	Vertex(int id, int fromVertex) {
		this.id = id;
		distance = Dijkstra.matrix[fromVertex][id];
		if (distance < Dijkstra.MAX) {
			path.add(id);
		}
	}

	@Override
	public String toString() {
		return "Vertex [id=" + id + ", distance=" + distance + ", path=" + path + "]";
	}

}
