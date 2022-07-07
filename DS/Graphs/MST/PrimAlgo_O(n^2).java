// T.C: O(n) + O(n^2)
import java.util.*;

class Node {
	int v; // vertex
	int weight;

	Node(int _v, int _w) {
		v = _v;
		weight = _w;
	}
	// Simple functions to easily access v and weight
	int getV() { return v; }
	int getWeight() { return weight; }

}


class PrimAlgo {


	// A utility function to find the vertex with minimum key
    // value, from the set of vertices not yet included in MST
    int minKey(int[] key, boolean[] mstSet, int n)
    {
        // Initialize min value
        int min = Integer.MAX_VALUE, min_index = -1;
        for (int v = 0; v < n; v++)
            if (mstSet[v] == false && key[v] < min) { // Get minimum who is not yet in mst array
                min = key[v];
                min_index = v;
            }
 
        return min_index;
    }

	void getMST(ArrayList<ArrayList<Node>> adj, int n) {
		// Create key, parent and mst arrays
		int[] key = new int[n];
		int[] parent = new int[n];
		boolean[] mst = new boolean[n];
		// Initialize arrays
		for(int i=0; i<n; i++) {
			key[i] = 100000000; // Assign to very big number
			mst[i] = false;
			parent[i] = -1;
		}
		// Also weight for 0th node to itself is 0
		key[0] = 0;
		// Now iterate for n-1 edges as MST has n nodes and n-1 edges
		for(int i=0; i<n-1; i++) {
			// Step 1: Pick thd minimum key vertex from the set of vertices not yet included in MST
			int u = minKey(key, mst, n);
			// Mark this index as true in mst array
			mst[u] = true;
			// Step 2: Iterate for adjacent nodes
			for(Node it: adj.get(u)) {
				 // If not part of mst and weight is smaller than in key then update the value
				if(mst[it.getV()] == false && it.getWeight() < key[it.getV()]) {
					parent[it.getV()] = u; // updated parent
					key[it.getV()] = it.getWeight(); // updated the smaller weight, like 1000000 to smaller weight
				}
			}
		}
		// Now print MST
		for(int i=1; i<n; i++) {
			System.out.println(parent[i] + " - " + i);
		}
	}

	public static void main(String[] args) {
		int n = 5; // No. of nodes
		// As it is weighted graph, we will store each elem as pair: node, weight
		ArrayList<ArrayList<Node>> adj = new ArrayList<ArrayList<Node>>();

		// Add nodes in adjacency list
		for(int i=0; i<n; i++)
			adj.add(new ArrayList<Node>());

		adj.get(0).add(new Node(1, 2)); // Adding Node 1 to 0 with weight 2
		adj.get(1).add(new Node(0, 2));

		adj.get(1).add(new Node(2, 3));
		adj.get(2).add(new Node(1, 3));
		
		adj.get(0).add(new Node(3, 6));
		adj.get(3).add(new Node(0, 6));
		
		adj.get(1).add(new Node(3, 8));
		adj.get(3).add(new Node(1, 8));
		
		adj.get(1).add(new Node(4, 5));
		adj.get(4).add(new Node(1, 5));
		
		adj.get(2).add(new Node(4, 7));
		adj.get(4).add(new Node(2, 7));
		
		PrimAlgo obj = new PrimAlgo();
		obj.getMST(adj, n);

	}
}