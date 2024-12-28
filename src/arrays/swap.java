package arrays;

import java.util.Arrays;

public class swap {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
//        swaping(arr,1,2);
        reverse(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void reverse(int[] arr){
        int start = 0;
        int end = arr.length-1;
        while(start < end){
            swaping(arr,start,end);
            start++;
            end--;
        }
    }
    static void swaping(int[] arr, int i1, int i2){
        int temp;
        temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }
}
