package graph;

import java.util.ArrayList;

public class Detect_Cycle_usingDFS {
    private boolean dfs(int node, int parent, int[] vis, ArrayList<ArrayList<Integer>> adj){
        vis[node] = 1 ;
        for(Integer i: adj.get(node)){
            if(vis[node] == 0){
                if(dfs(i,node,vis,adj)){
                    return true;
                }
            }else if(i != parent) return true;
        }
        return false;
    }
    public boolean isCycle(int v, ArrayList<ArrayList<Integer>> adj){
        int[] vis = new int[v];
        for (int i = 0; i < v; i++) {
            if (vis[i] == 0){
                if(dfs(0,-1,vis,adj)) return true;
            }
        }
        return false;
    }
}
