package searching;

public class Rotated_Binary_Search {
    public static void main(String[] args) {
        int[] arr ={2,3,3,4,5,2,1};
        System.out.println(search(arr,4));
    }
    static int search(int[] arr,int target){
        int pivot = findPivotWithDuplicates(arr);
        if (pivot == -1){
            return binary_search(arr, target,0, arr.length-1);
        }
        if (arr[pivot] == target){
            return pivot;
        }
        if (target > arr[0]){
            return binary_search(arr, target, 0, pivot - 1);
        }else {
            return binary_search(arr, target, pivot + 1, arr.length - 1);
        }

    }
    static int binary_search(int[] arr, int target,int start,int end){

        while (start <= end){
            int mid = start + (end - start)/2;
            if (target > arr[mid]){
                start = mid +1;
            }else if(target < arr[mid]){
                end = mid -1;
            }else {
                return mid;
            }
        }
        return -1;
    }
    static int findPivot(int[] arr){
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (mid < end && arr[mid] > arr[mid + 1]){
                return mid;
            }
            if (mid > start && arr[mid] < arr[mid - 1]){
                return mid - 1;
            }
            if(arr[start] >= arr[mid]){
                end = mid -1;
            }else{
                start = mid + 1;
            }


        }
        return -1;
    }
    static int findPivotWithDuplicates(int[] arr){
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (mid < end && arr[mid] > arr[mid + 1]){
                return mid;
            }
            if (mid > start && arr[mid] < arr[mid - 1]){
                return mid - 1;
            }
            if (arr[mid] == arr[start] && arr[mid] == arr[end]){
//                when start is pivot
                if (arr[start] > arr[start + 1]){
                    return start;
                }
                start++;

//                when end is pivot
                if (arr[end] < arr[end - 1]){
                    return end - 1;
                }
                end--;
            }  // left side is sorted, so pivot should be in right
            else if(arr[start] < arr[mid] || (arr[start] == arr[mid] && arr[mid] > arr[end])) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }


        }
        return -1;
    }
}
