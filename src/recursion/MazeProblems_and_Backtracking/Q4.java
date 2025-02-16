package recursion.MazeProblems_and_Backtracking;

import java.util.ArrayList;

public class Q4 {
    public static void main(String[] args) {
        boolean[][] maze = {
                {true,true,true},
                {true,false,true},
                {true,true,true}
        };
        path("",maze,0,0);
    }
    static void path(String p, boolean[][] maze, int r, int c){
        if (r == maze.length-1 && c == maze[0].length-1){
            System.out.println(p);
            return;
        }

        if (!maze[r][c]){
            return;
        }

        if (r < maze.length-1){
            path(p+'V', maze,r+1,c);
        }
        if (c < maze.length-1){
            path(p+'H', maze, r,c+1);
        };
    }
}
