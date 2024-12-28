package searching;

public class linearSearch {
    public static void main(String[] args) {
        int[] arr = {23,45, 67, 99, 69,21, 74, 86, 21};
        search(arr, 69);
    }
    static int search(int[] arr, int key){
        if (arr.length==0){
            return -1;
        }
        for (int i = 0; i <= arr.length; i++) {
            int ele = arr[i];
            if (ele==key){
                System.out.println("element "+ele+" found at location "+i);
                return i;
            }
        }
        return -1;
    }
}
