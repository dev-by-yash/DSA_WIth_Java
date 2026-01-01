package graph;

import java.util.*;

public class FindEventualSafeStates_Topo_BFS {
    public List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {
        // Reverse graph
        List<List<Integer>> adjRev = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjRev.add(new ArrayList<>());
        }

        int indegree[] = new int[V];
        for (int i = 0; i < V; i++) {
            for (int it : adj.get(i)) {
                adjRev.get(it).add(i); // reverse edge
                indegree[i]++;         // indegree of original graph
            }
        }

        Queue<Integer> q = new LinkedList<>();
        List<Integer> safeNodes = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int node = q.poll();
            safeNodes.add(node);
            for (int it : adjRev.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) q.add(it);
            }
        }

        Collections.sort(safeNodes);
        return safeNodes;
    }
}
