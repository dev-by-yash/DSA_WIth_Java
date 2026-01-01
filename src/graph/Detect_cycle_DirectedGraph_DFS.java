package graph;

import java.util.ArrayList;

public class Detect_cycle_DirectedGraph_DFS {
    private boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] vis, int[] pathvis){
        vis[node] = 1;
        pathvis[node] = 1;
        for (Integer i: adj.get(node)){
            if(vis[i] == 0){
                if(dfs(i,adj,vis,pathvis)) return true;
            } else if(pathvis[i] == 1){
                return true;
            }
        }
        pathvis[node] = 0;
        return false;
    }

    public boolean isCycle(int v, ArrayList<ArrayList<Integer>> adj){
        int[] vis = new int[v];
        int[] pathvis = new int[v];
        for (int i = 0; i < v; i++) {
            if(vis[i] == 0){
                if(dfs(i, adj, vis, pathvis)) return true;
            }
        }
        return false;
    }

    // driver code
    public static void main(String[] args) {
        int V = 4;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++) adj.add(new ArrayList<>());

        // Example graph
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(1); // back edge -> cycle

        Detect_cycle_DirectedGraph_DFS obj = new Detect_cycle_DirectedGraph_DFS();
        if(obj.isCycle(V, adj))
            System.out.println("Cycle detected!");
        else
            System.out.println("No cycle.");
    }
}
