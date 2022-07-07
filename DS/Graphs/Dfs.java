import java.util.*;

// Dfs is done using recursion
class Dfs {

	// The methods or data members declared as private are accessible only within the class in which they are declared. Any other class of the same package will not be able to access these members.

	private int V; // no. of vertices
	// Declare adjacency list
	private LinkedList<Integer> adj[];

	// Constructor to create adjacency list in main function only when object is created
	Dfs(int v) {
		V = v;
		adj = new LinkedList[v];
		for(int i=0; i<v; i++)
			adj[i] = new LinkedList<Integer>();

	}


	void addEdge(int v, int w) {
		adj[v].add(w);
		// adj.get(w).add(v); // This statement would have been also written if graph was undirected
	}

	void print_DFS(int i, boolean[] vis) {
		vis[i] = true;
		System.out.print(i + " ");
		for(Integer it: adj[i]) {
			if(vis[it] == false)
				print_DFS(it, vis);
		}
	}

	void DFS_traversal() {
		boolean[] vis = new boolean[V]; // 0 based indexing so v, if 1 based then v+1
		for(int i=0; i<V; i++) {
			if(vis[i] == false)
				print_DFS(i, vis);
		}
	}


	public static void main(String[] args) {
		int v = 4; // from input
		Dfs g = new Dfs(4);
		// addEdge will be function which will create graph using adjacency list
		g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        g.DFS_traversal();
	}
}