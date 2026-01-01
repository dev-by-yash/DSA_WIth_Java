package graph;

import java.util.LinkedList;
import java.util.Queue;

class Tuple{
    int first,second,third;
    Tuple(int first, int second, int third){
        this.first = first;
        this.second = second;
        this.third = third;
    }

}
public class ShortestDistanceInABinaryMaze {
    int shortestPath(int[][] grid, int[] source, int[] destination) {
        if(source[0] == destination[0] && source[1]==destination[1]) return 0;
        Queue<Tuple> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dist[i][j] = (int)(1e9);
            }
        }
        dist[source[0]][source[1]] = 0;
        q.add(new Tuple(0,source[0],source[1]));
        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};
        while(!q.isEmpty()){
            Tuple it = q.peek();
            q.remove();
            int dis = it.first;
            int r = it.second;
            int c = it.third;
            //4 directions
            for (int i = 0; i < 4; i++) {
                int newr = r+drow[i];
                int newc = c+dcol[i];
                if(newr >=0 && newr < n && newc >= 0 && newc < m && grid[newr][newc] == 1 && dis+1 < dist[newr][newc]){
                    dist[newr][newc] = dis+1;
                    if(newr == destination[0] && newc == destination[1]) return dis+1;
                    q.add(new Tuple(dis+1, newr, newc));
                }
            }
        }
        return -1;
    }
}
