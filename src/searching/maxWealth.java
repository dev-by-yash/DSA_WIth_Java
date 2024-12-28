package searching;

public class maxWealth {
    public static void main(String[] args) {
        int[][] arr = {
                {1,5},
                {7,3},
                {3,5}
        };
        System.out.println(maximumWealth(arr));
    }
    static int maximumWealth(int[][] accounts){
        int max = 0;
        for (int[] account : accounts) {
            int rowSum = 0;
            for (int i : account) {
                rowSum += i;
            }
            if (rowSum > max) {
                max = rowSum;
            }
        }
        return max;
    }
}
