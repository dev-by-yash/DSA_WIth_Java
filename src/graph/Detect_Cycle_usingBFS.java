package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Detect_Cycle_usingBFS {
    public boolean checkCycle(int src, int v, ArrayList<ArrayList<Integer>> adj, boolean[] vis){
        vis[src] = true;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src,-1));
        while(!q.isEmpty()){
            int node = q.peek().first;
            int parent = q.peek().second;
            for(int adjacentNode: adj.get(node)){
                if(vis[adjacentNode] == false){
                    vis[adjacentNode] = true;
                    q.add(new Pair(adjacentNode,node));
                }else if(parent != adjacentNode) return true;
            }
        }
        return false;
    }
    public boolean isCycle(int v, ArrayList<ArrayList<Integer>> adj){
        boolean[] vis = new boolean[v];
        for (int i = 0; i < v; i++) {
            vis[i] = false;
        }
        for (int i = 0; i < v; i++) {
            if(vis[i] == false){
                if(checkCycle(i,v,adj,vis)){
                    return true;
                }
            }
        }
        return false;
    }
}
