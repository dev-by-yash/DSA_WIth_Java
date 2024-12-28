package searching;

import java.util.Arrays;
import java.util.Scanner;

public class linearSerachQue {
    public static void main(String[] args) {
//        String name = "yash mehta";
//        searchQ1(name,'m');


//        int[] arr = {3,4,0,1,7,9};
//        System.out.println(min(arr));
        Scanner sc = new Scanner(System.in);
        int target;
        System.out.println("enter element to be search: ");
        target = sc.nextInt();
        int[][] arr = {
                {23,32,64},
                {12,65,89,98},
                {11,43,12,6,86,21}
        };
        int[] ans = searchIn2DArray(arr, target);
        System.out.println(Arrays.toString(ans));
    }

    static int[] searchIn2DArray(int[][] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j]==target){
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1,-1};
    }

    static int min(int[] arr){
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min){
                min = arr[i];
            }
        }
        return min;
    }
    static boolean searchQ1(String name, char target) {
        if (name.length()==0){
            return false;
        }
        for (int i = 0; i < name.length(); i++) {
            if (target==name.charAt(i)){
                return true;
            }
        }
        return false;
    }
}
