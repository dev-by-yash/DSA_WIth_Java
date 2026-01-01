package sorting;

import java.util.Arrays;
import java.util.HashMap;

public class count_sort {
   static void usingarray(int[] arr){
        if(arr == null || arr.length <= 1){
            return;
        }
        int max = arr[0];
        for(int nums: arr){
            if(nums > max){
                max = nums;
            }
        }
        int[] countArray = new int[max+1];
        for(int num: arr){
            countArray[num]++;
        }
        int index = 0;
        for(int i = 0; i <= max; i++){
            while(countArray[i] > 0){
                arr[index] = i;
                index++;
                countArray[i]--;
            }
        }
    }


    public static void main(String[] args) {
        int[] arr = {6,3,10,9,2,4,9,7};
        usingarray(arr);
        System.out.println(Arrays.toString(arr));
    }
}
