package Questions;

public class WordSearch_79 {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(dfs(board,word,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }
    boolean dfs(char[][] board, String word, int i, int j, int k){
        // base condition
        // /out of bounds
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length){
            return false;
        }
        // if word doesnt match
        if(board[i][j] != word.charAt(k)){
            return false;
        }
        // word match
        // all chars match
        if(k == word.length() - 1){
            return true;
        }
        char temp = board[i][j];
        board[i][j] = '#';
        boolean found = dfs(board,word,i-1,j,k+1) || //up
                dfs(board,word,i+1,j,k+1) || // down
                dfs(board,word,i,j-1,k+1) || //left
                dfs(board,word,i,j+1,k+1); //right
        board[i][j] = temp; //backtrack
        return found;
    }
}
