// Assumed graph has just a single component

import java.util.*;


class Dfs {

	public void dfs(int node, ArrayList<Integer> out, boolean[] vis, ArrayList<ArrayList<Integer>> adj) {
		// Add element to output
		out.add(node);
		vis[node] = true;
		// Now for each adjacent node, call dfs recursively
		for(int it: adj.get(node)) {
			if(!vis[it])
				dfs(it, out, vis, adj);
		}
	}



	public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
		// Assuming that graph nodes start from 0
		// Output array list
        ArrayList<Integer> out = new ArrayList<>();
        // Visited array
        boolean[] vis = new boolean[V];
        // Here we need to use recursion
        dfs(0, out, vis, adj); // 0 is the first element
        return out;
	}

	public static void main(String[] args) {
		int V = 7;

		ArrayList<ArrayList<Integer> > adj = new ArrayList<ArrayList<Integer> >();

		for (int i = 0; i < V; i++) 
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


		Dfs obj = new Dfs();
		ArrayList<Integer> ans = obj.dfsOfGraph(V, adj);
		for(int i=0; i<ans.size(); i++)
			System.out.print(ans.get(i) + " ");
	}
}