package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Bipartite_BFS {
    private static boolean check(int start, int v, ArrayList<ArrayList<Integer>> adj, int[] color){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        color[start] = 0;
        while (!q.isEmpty()){
            int node = q.peek();
            q.remove();
            for (Integer i: adj.get(node)){
                if (color[i] == -1){
                    color[i] = 1 - color[node];
                    q.add(i);
                }
                else if(color[i] == color[node]){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isBipartite(int v, ArrayList<ArrayList<Integer>> adj){
        int[] color = new int[v];
        for(int i = 0; i < v; i++){
            color[i] = -1;
        }
        for (int i = 0; i < v; i++) {
            if (color[i] == -1){
                if(check(i,v,adj,color) == false){
                    return false;
                }
            }
        }
        return true;
    }
}
