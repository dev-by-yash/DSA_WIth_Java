package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Detect_cycle_DirectedGraph_BFS {
    public boolean topo(int v, ArrayList<ArrayList<Integer>> adj){
        int[] indeg = new int[v];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            for(int j: adj.get(i)){
                indeg[j]++;
            }
        }
        for (int i = 0; i < v; i++) {
            if(indeg[i] == 0){
                q.add(i);
            }
        }
        int c = 0;
        int i = 0;
        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();
            c++;
            for(int j: adj.get(i)){
                indeg[j]--;
                if(indeg[j] == 0){
                    q.add(j);
                }
            }
        }
        if(c == v) return false;
        return true;
    }
}
