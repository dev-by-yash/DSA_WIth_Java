package graph;

import java.util.ArrayList;

public class DFS {

    // Recursive DFS function
    static void dfs(int node, boolean[] visit, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ls){
        visit[node] = true;      // mark current node visited
        ls.add(node);            // add to result list

        for(Integer i: adj.get(node)){
            if(!visit[i]){       // if not visited, call DFS
                dfs(i, visit, adj, ls);
            }
        }
    }

    // DFS traversal starting from 0
    static ArrayList<Integer> dfsOfGraph(int v, ArrayList<ArrayList<Integer>> adj){
        boolean visit[] = new boolean[v];
        ArrayList<Integer> ls = new ArrayList<>();
        dfs(0, visit, adj, ls);
        return ls;
    }

    // Main method to test DFS
    public static void main(String[] args) {
        int v = 5; // vertices 0..4
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        // initialize adjacency list
        for(int i = 0; i < v; i++){
            adj.add(new ArrayList<>());
        }

        // Add edges (undirected graph)
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(0);
        adj.get(1).add(3);
        adj.get(2).add(0);
        adj.get(2).add(4);
        adj.get(3).add(1);
        adj.get(4).add(2);

        // Run DFS
        ArrayList<Integer> ans = dfsOfGraph(v, adj);

        // Print DFS traversal
        System.out.println("DFS Traversal: " + ans);
    }
}
