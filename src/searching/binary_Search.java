package searching;

public class binary_Search {
    static int orderAgnosticBS(int[] arr, int target){
        int start, end;
        start = 0;
        end = arr.length-1;

        boolean Aesc = arr[start] < arr[end];
        while (start <= end){
            int mid = start + (end - start)/2;
            if (arr[mid] == target){
                return mid;
            }
            if (Aesc){
                if (target > arr[mid]){
                    start = mid +1;
                }else{
                    end = mid -1;
                }
            }else {
                if (target < arr[mid]){
                    start = mid +1;
                }else{
                    end = mid -1;
                }
            }

        }
        return -1;
    }
    static int search(int[] arr, int target){
        int start, end;
        start = 0;
        end = arr.length-1;

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
    public static void main(String[] args) {
//        int[] arr = {2, 4, 9, 12, 14, 19,23, 44, 66, 69};
        int[] arr = {44, 33, 22, 11, 9, 6, 4, 2, 1, 0};
        System.out.println(orderAgnosticBS(arr, 22));
    }
}
