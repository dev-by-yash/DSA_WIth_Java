// User function Template for Java
class Pairs {
    int f, s;
    Pairs(int f, int s) {
        this.f = f;
        this.s = s;
    }
}

class Solution {

    public void toposort(int node, ArrayList<ArrayList<Pairs>> adj, int[] vis, Stack<Integer> st) {
        vis[node] = 1;
        for (Pairs p : adj.get(node)) {
            int v = p.f;
            if (vis[v] == 0) {
                toposort(v, adj, vis, st);
            }
        }
        st.push(node);
    }

    public int[] shortestPath(int n, int m, int[][] edges) {
        ArrayList<ArrayList<Pairs>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Build adjacency list
        for (int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adj.get(u).add(new Pairs(v, wt));
        }

        int[] vis = new int[n];
        Stack<Integer> st = new Stack<>();

        // Topological sort
        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                toposort(i, adj, vis, st);
            }
        }

        int[] dist = new int[n];
        for (int i = 0; i < n; i++) {
            dist[i] = (int)(1e9);
        }

        dist[0] = 0; // Source is node 0

        // Process nodes in topological order
        while (!st.isEmpty()) {
            int node = st.pop();
            if (dist[node] != (int)(1e9)) {
                for (Pairs p : adj.get(node)) {
                    int v = p.f;
                    int wt = p.s;
                    if (dist[node] + wt < dist[v]) {
                        dist[v] = dist[node] + wt;
                    }
                }
            }
        }

        // Replace infinity with -1 for unreachable nodes
        for (int i = 0; i < n; i++) {
            if (dist[i] == (int)(1e9)) dist[i] = -1;
        }

        return dist;
    }
}
