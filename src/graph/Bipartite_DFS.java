package graph;

import java.util.ArrayList;
public class Bipartite_DFS {
    private static boolean dfs(int node, int col, ArrayList<ArrayList<Integer>> adj, int[] color){
        color[node] = 0;
        for(Integer i: adj.get(node)){
            if(color[node] == -1){
                if(dfs(i,1-col,adj,color) == false){
                    return false;
                }
            }else if(color[node] == color[i]){
                return false;
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
                if(dfs(i,0,adj,color) == false){
                    return false;
                }
            }
        }
        return true;
    }
}
