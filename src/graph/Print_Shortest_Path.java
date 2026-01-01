package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Print_Shortest_Path {
    public List<Integer> shortestPath(int n, int m, int edges[][]) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i <= m; i++) {
            adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0], edges[i][2]));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x,y)-> x.first-y.first);
        int[] dist = new int[n+1];
        int[] parent = new int[n+1];
        for (int i = 0; i <= n; i++) {
            dist[i] = (int)(1e9);
            parent[i] = 1;
        }
        dist[1] = 0;
        pq.add(new Pair(0,1));
        while (pq.size() != 0){
            Pair it = pq.peek();
            int node = pq.second;
            int dis = pq.first;
            pq.remove();
            for(Pair iter: adj.get(node)){
                int adjnode = iter.second;
                int adjed = iter.first;
                if(dis+adjed < dist[adjnode]){
                    dist[adjnode] = dis+adjed;
                    pq.add(new Pair(adjed+dis,adjnode));
                    parent[adjnode] = node;
                }
            }

        }
        List<Integer> path = new ArrayList<>();
        if(dist[n] == 1e9){
            path.add(-1);
            return path;
        }
        int node = n;
        if(parent[node] != node){
            path.add(node);
            node = parent[node];
        }
        path.add(1);
        Collections.reverse(path);
        return path;
    }
}
