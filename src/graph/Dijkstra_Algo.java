package graph;

import java.util.*;

class Pairss {
    int distance;
    int node;

    Pairss(int distance, int node) {
        this.distance = distance;
        this.node = node;
    }
}
class Pair {
    int dist;
    int node;

    Pair(int dist, int node) {
        this.dist = dist;
        this.node = node;
    }

    // Override equals and hashCode for proper TreeSet removal
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pair)) return false;
        Pair p = (Pair) o;
        return dist == p.dist && node == p.node;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dist, node);
    }
}
public class Dijkstra_Algo {
    // Function to find the shortest distance of all the vertices
    // from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {

        // Min-heap priority queue
        PriorityQueue<Pairss> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);

        int[] dist = new int[V];
        for (int i = 0; i < V; i++)
            dist[i] = (int) 1e9;

        dist[S] = 0;
        pq.add(new Pairss(0, S));

        while (!pq.isEmpty()) {
            int dis = pq.peek().distance;
            int node = pq.peek().node;
            pq.remove();

            for (int i = 0; i < adj.get(node).size(); i++) {
                int edgeWeight = adj.get(node).get(i).get(1);
                int adjNode = adj.get(node).get(i).get(0);

                if (dis + edgeWeight < dist[adjNode]) {
                    dist[adjNode] = dis + edgeWeight;
                    pq.add(new Pairss(dist[adjNode], adjNode));
                }
            }
        }
        return dist;
    }
    public static int[] dijkstrausingSet(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        // TreeSet acts like C++ set<pair<int,int>>
        TreeSet<Pair> st = new TreeSet<>((a, b) -> {
            if (a.dist == b.dist)
                return a.node - b.node;
            return a.dist - b.dist;
        });

        int[] dist = new int[V];
        Arrays.fill(dist, (int) 1e9);
        dist[S] = 0;
        st.add(new Pair(0, S));

        while (!st.isEmpty()) {
            Pair it = st.pollFirst(); // smallest distance pair
            int node = it.node;
            int dis = it.dist;

            for (ArrayList<Integer> edge : adj.get(node)) {
                int adjNode = edge.get(0);
                int edgeWeight = edge.get(1);

                if (dis + edgeWeight < dist[adjNode]) {
                    // erase if it existed before
                    if (dist[adjNode] != (int) 1e9)
                        st.remove(new Pair(dist[adjNode], adjNode));

                    dist[adjNode] = dis + edgeWeight;
                    st.add(new Pair(dist[adjNode], adjNode));
                }
            }
        }
        return dist;
    }
}
