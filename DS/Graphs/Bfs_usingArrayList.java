// Assumed graph has just a single component

import java.util.*;


class Bfs {

	public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
		// Assuming that graph nodes start from 0
		// Output array list
        ArrayList<Integer> bfs = new ArrayList<>();
        // Visited array
        boolean[] vis = new boolean[V];
        
        // For bfs we need queue
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        vis[0] = true;
        while(!q.isEmpty()) {
        	Integer node = q.poll();
        	// Add the node to array
        	bfs.add(node);
        	// Now for each adjacent node
        	for(Integer it: adj.get(node)) {
        		if(vis[it] == false) {
        			vis[it] = true;
        			q.add(it);
        		}
        	}
        }
        return bfs;
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


		Bfs obj = new Bfs();
		ArrayList<Integer> ans = obj.bfsOfGraph(V, adj);
		for(int i=0; i<ans.size(); i++)
			System.out.print(ans.get(i) + " ");
	}
}