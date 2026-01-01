package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class bfs {

    // BFS function
    public ArrayList<Integer> bfsOfGraph(int v, ArrayList<ArrayList<Integer>> adj){
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean visit[] = new boolean[v];
        Queue<Integer> q = new LinkedList<>();

        // Start from node 0
        q.add(0);
        visit[0] = true;

        while(!q.isEmpty()){
            Integer node = q.poll();
            bfs.add(node);

            for(Integer i: adj.get(node)){
                if(!visit[i]){
                    visit[i] = true;
                    q.add(i);
                }
            }
        }
        return bfs;
    }

    // Main method to test BFS
    public static void main(String[] args) {
        int v = 5; // number of vertices (0 to 4)
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        // initialize adjacency list
        for(int i = 0; i < v; i++){
            adj.add(new ArrayList<>());
        }

        // Add edges (undirected)
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(0);
        adj.get(1).add(3);
        adj.get(2).add(0);
        adj.get(2).add(4);
        adj.get(3).add(1);
        adj.get(4).add(2);

        // Run BFS
        bfs obj = new bfs();
        ArrayList<Integer> ans = obj.bfsOfGraph(v, adj);

        // Print BFS order
        System.out.println("BFS Traversal: " + ans);
    }
}
