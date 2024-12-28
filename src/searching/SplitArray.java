package searching;

public class SplitArray {
    public static void main(String[] args) {
    }

    public int splitArray(int[] nums, int k) {
        int start = 0;
        int end = 0;

        for (int i = 0; i < nums.length; i++) {
            start = Math.max(start,nums[i]);
            end += nums[i];
        }
//        binary search
        while (start < end){
            int mid = start + (end - start)/2;

//            calculate how many peices you can divide with max sum
            int sum = 0;
            int peice = 1;
            for (int num: nums){
                if (sum + num > mid){
                    sum = mid;
                    peice++;
                }else {
                    sum += num;
                }
            }
            if (peice > k){
                start = mid + 1;
            }else {
                end = mid;
            }
        }
        return end;
    }
}
