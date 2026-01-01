package graph;

public class Replae_X_with_0 {
    static void dfs(int r, int c, int[][] vis, char[][] mat, int[] delr, int[] delc){
        vis[r][c] = 1;
        int n = mat.length;
        int m = mat[0].length;
        for (int i = 0; i < 4; i++) {
            int nrow = r + delr[i];
            int ncol = c + delc[i];
            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 && mat[nrow][ncol] == '0'){
                dfs(nrow,ncol,vis,mat,delr,delc);
            }
        }
    }
    static char[][] fill(int n, int m, char[][] mat){
        int[] delr = {-1,0,1,0};
        int[] delc = {0,1,0,-1};
        int[][] vis = new int[n][m];

//        traverse 1st row and ladst row
        for (int j = 0; j < m; j++) {
            if(vis[0][j] == 0 && mat[0][j] == '0'){
                dfs(0,j,vis,mat,delr,delc);
            }
            if(vis[n-1][j] == 0 && mat[n-1][j] == '0'){
                dfs(n-1,j,vis,mat,delr,delc);
            }
        }
        for (int i = 0; i < n; i++) {
            if(vis[i][0] == 0 && mat[i][0] == '0'){
                dfs(i,0,vis,mat,delr,delc);
            }
            if(vis[i][m-1] == 0 && mat[i][m-1] == '0'){
                dfs(i,m-1,vis,mat,delr,delc);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(vis[i][j] == 0 && mat[i][j] == '0'){
                    mat[i][j] = 'x';
                }
            }
        }
        return mat;
    }
}
