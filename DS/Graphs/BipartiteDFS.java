// Assumed graph has just a single component

import java.util.*;


class BipartiteDFS {

	boolean dfsCheck(ArrayList<ArrayList<Integer>> adj, int elem, int[] color) {
		// If coming for the first time
		if(color[elem] == -1)
			color[elem] = 1;
		// Traverse adjacent nodes
		for(Integer it: adj.get(elem)) {
			if(color[it] == -1) {
				color[it] = 1 - color[elem];
				// Calling for adjancent nodes
				if(dfsCheck(adj, it, color) == false)
					return false;
			}
			else if(color[it] == color[elem])
				return false;
		}
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
        		if(dfsCheck(adj, i, color) == false) {
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


		BipartiteDFS obj = new BipartiteDFS();
		if(obj.isBipartite(adj, n) == true)
			System.out.println("Bipartite");
		else
			System.out.println("Not Bipartite");
	}
}