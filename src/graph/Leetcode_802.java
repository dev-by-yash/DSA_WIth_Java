package graph;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_802 {
    private boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] vis, int[] pathvis,int[] check){
        vis[node] = 1;
        pathvis[node] = 1;
        for (Integer i: adj.get(node)){
            if(vis[i] == 0){
                if(dfs(i,adj,vis,pathvis,check)) return true;
            } else if(pathvis[i] == 1){
                return true;
            }
        }
        check[node] = 1;
        pathvis[node] = 0;
        return false;
    }
    List<Integer> problem(int v, ArrayList<ArrayList<Integer>> adj){
        int[] vis = new int[v];
        int[] pathvis = new int[v];
        List<Integer> safeNodes = new ArrayList<>();
        int[] check = new int[v];
        for (int i = 0; i < v; i++) {
            if(vis[i] == 0){
                dfs(i, adj, vis, pathvis,check);
            }
        }
        for (int i = 0; i < v; i++) {
            if(check[i] == 1){
                safeNodes.add(i);
            }
        }
        return safeNodes;
    }
}
