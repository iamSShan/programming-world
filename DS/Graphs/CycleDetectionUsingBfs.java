import java.util.*;

class Node {
	int first;
	int second;
	public Node(int first, int second) {
		this.first = first; // For node
		this.second = second; // Here second integer is for prev node
	}
}

class CycleDetectionUsingBfs {

	// The methods or data members declared as private are accessible only within the class in which they are declared. Any other class of the same package will not be able to access these members.

	private int V; // no. of vertices
	// Declare adjacency list
	private LinkedList<Integer> adj[];

	// Constructor to create adjacency list in main function only when object is created
	CycleDetectionUsingBfs(int v) {
		V = v;
		adj = new LinkedList[v];
		for(int i=0; i<v; i++)
			adj[i] = new LinkedList<Integer>();

	}


	void addEdge(int v, int w) {
		adj[v].add(w);
		// adj.get(w).add(v); // This statement would have been also written if graph was undirected
	}


	boolean isCycle(int start, boolean[] vis) {
		
		// Create a queue for bfs
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(new Node(start, -1)); // -1 is for prev node for start
		vis[start] = true;

		while(!queue.isEmpty()) {
			int node = queue.peek().first;
			int prev = queue.peek().second;
			// Pop node
			queue.remove();

			// Travserse all adjacent nodes
			for(Integer it: adj[node]) {
				if(vis[it] == false) {
					vis[it] = true;
					queue.add(new Node(it, node));
				}
				else if(prev != it) {
					return true;
				}
			}
		}
		return false;	
		
	}

	boolean bfs() {
		// We will create a visted array
		boolean[] vis = new boolean[V]; // 0 based indexing so v, if 1 based then v+1
		Arrays.fill(vis, false);
		for(int i=0; i<V; i++) {
			if(vis[i] == false) {
				// Every time we will also pass parent node, so that parent(prev) node is not considered while saying cycle when getting adjacent nodes
				if(isCycle(i, vis))
					return true;
			}
		}
		return false;
	}


	public static void main(String[] args) {
		int v = 4; // from input
		CycleDetectionUsingBfs g = new CycleDetectionUsingBfs(4);
		// addEdge will be function which will create graph using adjacency list
		g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.print(g.bfs());
	}
}