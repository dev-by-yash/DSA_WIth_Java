package graph;

import java.util.ArrayList;

// leetcode 547
public class NumOfProvinces {
    static void dfs(int node, ArrayList<ArrayList<Integer>> adjLs, int[] vis){
        vis[node] = 1;
        for(Integer i: adjLs.get(node)){
            if(vis[i]==0){
                dfs(node,adjLs,vis);
            }
        }
    }
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int v){
        ArrayList<ArrayList<Integer>> adjLs = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < v; i++){
            adjLs.add(new ArrayList<>());
        }
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                if(adjLs.get(i).get(j) == 1 && i != j){
                    adjLs.get(i).add(j);
                    adjLs.get(j).add(i);
                }
            }
        }
        int[] visit = new int[v];
        int c = 0;
        for (int i = 0; i < v; i++) {
            if(visit[i] == 0){
                dfs(i,adjLs,visit);
                c++;
            }
        }
        return c;
    }
}
