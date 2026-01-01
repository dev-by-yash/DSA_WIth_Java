package graph;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int iniColor = image[sr][sc];
        if (iniColor == color) return image; // no need to fill if already same color

        int n = image.length;
        int m = image[0].length;
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        dfs(image, sr, sc, color, delRow, delCol, iniColor, n, m);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int color, int[] delRow, int[] delCol, int iniColor, int n, int m) {
        image[sr][sc] = color; // fill current pixel

        for (int i = 0; i < 4; i++) {
            int nRow = sr + delRow[i];
            int nCol = sc + delCol[i];

            if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && image[nRow][nCol] == iniColor) {
                dfs(image, nRow, nCol, color, delRow, delCol, iniColor, n, m);
            }
        }
    }
}
