package graph;

public class Bellman_Ford_Allgo {
    public int[] bellmanFord(int V, int[][] edges, int src) {
        int INF = (int)1e8;
        int[] dist = new int[V];

        for(int i = 0; i < V; i++)
            dist[i] = INF;

        dist[src] = 0;

        // Relax edges V-1 times
        for(int i = 0; i < V - 1; i++){
            for(int[] it : edges){
                int u = it[0];
                int v = it[1];
                int wt = it[2];

                if(dist[u] != INF && dist[u] + wt < dist[v]){
                    dist[v] = dist[u] + wt;
                }
            }
        }

        for(int[] it: edges){
            int u = it[0];
            int v = it[1];
            int wt = it[2];

            if(dist[u] != INF && dist[u] + wt < dist[v]){
                return new int[]{-1};
            }
        }

        return dist;
    }
}
