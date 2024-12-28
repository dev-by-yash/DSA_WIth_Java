package searching;

public class firtsAndLastPosition {
    public int[] searchRange(int[] nums, int target) {
        int[] arr = {-1,-1};
        int start = search(nums, target, true);
        int end = search(nums, target, false);
        arr[0] = start;
        arr[1] = end;

        return arr;
    }
    int search(int[] nums,int target, boolean findStartIndex){
        int ans = -1;
        int start, end;
        start = 0;
        end = nums.length-1;

        while (start <= end){
            int mid = start + (end - start)/2;
            if (target > nums[mid]){
                start = mid +1;
            }else if(target < nums[mid]){
                end = mid -1;
            }else {
                ans = mid;
                if (findStartIndex){
                    end = mid-1;
                }else{
                    start = mid + 1;
                }
            }
        }
        return ans;
    }
}
