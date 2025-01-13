package recursion.MazeProblems_and_Backtracking;

import java.util.ArrayList;

public class Q1 {
    public static void main(String[] args) {
//        System.out.println(coun(3,3));
        System.out.println(path("",3,3));
    }
    static int coun(int r, int c){
        if (r == 1 || c == 1){
            return 1;
        }

        int left = coun(r-1,c);
        int right = coun(r,c-1);

        return left + right;
    }

    static ArrayList<String> path(String p, int r, int c){
        if (r == 1 && c == 1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> ans = new ArrayList<>();
        if (r > 1 && c > 1){
            ans.addAll(path(p+'D',r-1,c-1));
        }
        if (r > 1){
             ans.addAll(path(p+'V',r-1,c));
        }
        if (c > 1){
            ans.addAll(path(p+'H',r,c-1));
        }
        return ans;
    }
}
