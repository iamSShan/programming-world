// Assumed graph has just a single component

import java.util.*;


class BipartiteBFS {

	boolean bfsCheck(ArrayList<ArrayList<Integer>> adj, int elem, int color[]) {
		// First step to add to queue and make color array elem as 1;
		Queue<Integer> q = new LinkedList<>();
		q.add(elem); 
		color[elem] = 1;
		// BFS logic
		while(!q.isEmpty()) {
			Integer n = q.poll();
			// Iterate adjacent nodes
			for(Integer it: adj.get(n)) {
				if(color[it] == -1) {
					// Always color it with opposite color of prev node(n)
					color[it] = 1 - color[n];
					// Add adjacent node to queue
					q.add(it);
				}
				// Color of prev node and adjacent node are same, then return false
				else if(color[it] == color[n])
					return false;
			}
		}
		// If all nodes are colored properly, then return true
		return true;
	}

	boolean isBipartite(ArrayList<ArrayList<Integer>> adj, int n) {
		// Declaring color array
		int[] color = new int[n];
		for(int i = 0;i<n;i++) {
        	color[i] = -1; 
        }

        // Iterating for each node
        for(int i=0; i<n; i++) {
        	if(color[i] == -1) {
        		if(bfsCheck(adj, i, color) == false) {
        			return false;
        		}
        	}
        }
        return true;
	}

	public static void main(String[] args) {
		int n=7;
		ArrayList<ArrayList<Integer> > adj = new ArrayList<ArrayList<Integer> >();
		for (int i = 0; i < n; i++) 
			adj.add(new ArrayList<Integer>());
		adj.get(0).add(1);
		adj.get(1).add(0);

		adj.get(1).add(2);
		adj.get(2).add(1);

		adj.get(2).add(3);
		adj.get(3).add(2);

		adj.get(4).add(3);
		adj.get(3).add(4);

		adj.get(4).add(5);
		adj.get(5).add(4);

		adj.get(4).add(6);
		adj.get(6).add(4);

		adj.get(1).add(6);
		adj.get(6).add(1);


		BipartiteBFS obj = new BipartiteBFS();
		if(obj.isBipartite(adj, n) == true)
			System.out.println("Bipartite");
		else
			System.out.println("Not Bipartite");
	}
}