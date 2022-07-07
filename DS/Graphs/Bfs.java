// Please refer Bfs_usingArrayList, that has simpler explanation

import java.util.*;

class Bfs {

	// The methods or data members declared as private are accessible only within the class in which they are declared. Any other class of the same package will not be able to access these members.

	private int V; // no. of vertices
	// Declare adjacency list
	private LinkedList<Integer> adj[];

	// Constructor to create adjacency list in main function only when object is created
	Bfs(int v) {
		V = v;
		adj = new LinkedList[v];
		for(int i=0; i<v; i++)
			adj[i] = new LinkedList<Integer>();

	}


	void addEdge(int v, int w) {
		adj[v].add(w);
		// adj.get(w).add(v); // This statement would have been also written if graph was undirected
	}

	void get_bfs() {
		// We will create a visted array
		boolean[] vis = new boolean[V]; // 0 based indexing so v, if 1 based then v+1
		// Create a queue for bfs
		Queue<Integer> queue = new LinkedList<Integer>();

		// If source is getting passed from main function then:
		// int s = 2; // Assumed source
		// queue.add(s);
		// vis[s] = true;
		// while(!queue.isEmpty()) {
		// 	// Pop node
		// 	Integer node = queue.poll();
		// 	System.out.print(node + " ");

		// 	// Travserse all adjacent nodes
		// 	for(Integer it: adj[node]) {
		// 		if(vis[it] == false) {
		// 			vis[it] = true;
		// 			queue.add(it);
		// 		}
		// 	}
		// }

		// Else BFS from 0th node:

		for(int i=0; i<V; i++) {
			if(vis[i] == false) {
				queue.add(i);
				vis[i] = true;

				while(!queue.isEmpty()) {
					// Pop node
					Integer node = queue.poll();
					System.out.print(node + " ");

					// Travserse all adjacent nodes
					for(Integer it: adj[node]) {
						if(vis[it] == false) {
							vis[it] = true;
							queue.add(it);
						}
					}
				}
			}
		}
	}


	public static void main(String[] args) {
		int v = 4; // from input
		Bfs g = new Bfs(4);
		// addEdge will be function which will create graph using adjacency list
		g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        g.get_bfs();
	}
}