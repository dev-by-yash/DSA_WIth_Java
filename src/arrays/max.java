package arrays;

public class max {
    public static void main(String[] args) {
        int[] arr = {1,4,7,8,10,33,2,34};
        System.out.println(maxItem(arr));
    }

    static int maxItem(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }
}
