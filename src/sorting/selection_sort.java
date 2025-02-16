package sorting;

import java.util.Arrays;

public class selection_sort {
    public static void main(String[] args) {
        int[] arr = {4,5,1,2,2,3};
        selection(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void selection(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int last = arr.length - i - 1;
            int maxIndex = getMaxIndex(arr, 0, last);
            swap(arr, maxIndex, last);
        }
    }

    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    static int getMaxIndex(int[] arr, int start, int end) {
        int max = start; // Start by assuming the max is at the 'start' index
        for (int i = start; i <= end; i++) {
            if (arr[i] > arr[max]) { // Compare values to find the maximum index
                max = i; // Update 'max' to the index of the larger value
            }
        }
        return max; // Return the index of the maximum value
    }
}
