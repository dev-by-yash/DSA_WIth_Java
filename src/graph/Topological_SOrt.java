package graph;

import java.util.ArrayList;
import java.util.Stack;

public class Topological_SOrt {
    private void dfs(int node, int[] vis, ArrayList<ArrayList<Integer>> adj, Stack<Integer> st){
        vis[node] = 1;
        for(Integer i: adj.get(node)){
            if(vis[i] == 0){
                dfs(i, vis,adj,st);
            }
        }
        st.push(node);
    }
    public int[] topo(int v, ArrayList<ArrayList<Integer>> adj){
        int[] vis = new int[v];
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[v];
        for (int i = 0; i < v; i++) {
            if(vis[i] == 0){
                dfs(i,vis,adj,st);
            }
        }
        int i = 0;
        while ((!st.isEmpty())){
            ans[i++] = st.peek();
            st.peek();
        }
        return ans;
    }
}
