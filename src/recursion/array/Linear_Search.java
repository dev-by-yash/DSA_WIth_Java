package recursion.array;

import java.util.ArrayList;

public class Linear_Search {
    public static void main(String[] args) {
//        int[] arr = {3,2,1,18,9};
//        System.out.println(search(arr, 18,0));
        int[] arr = {2, 3, 1, 4, 4, 5};
//        ArrayList<Integer> list = new ArrayList<>();
//        ArrayList<Integer> ans = findAllIndex(arr, 4, 0, list);
//        System.out.println(ans);

        System.out.println(findAllIndex2(arr,4,0));
    }
    static int search(int[] arr, int target, int index){
        if (index == arr.length){
            return -1;
        }
        if (arr[index] == target){
            return index;
        }else {
            return search(arr, target, index+1);
        }
    }
    static ArrayList<Integer> findAllIndex(int[] arr, int target, int index, ArrayList<Integer> list) {
        if (index == arr.length) {
            return list;
        }
        if (arr[index] == target) {
            list.add(index);
        }
        return findAllIndex(arr, target, index + 1, list);
    }

    static ArrayList<Integer> findAllIndex2(int[] arr, int target, int index) {
        ArrayList<Integer> list = new ArrayList<>();
        if (index == arr.length) {
            return list;
        }
        if (arr[index] == target) {
            list.add(index);
        }
        ArrayList<Integer> ansFromBelowList = findAllIndex2(arr, target, index + 1);
        list.addAll(ansFromBelowList);
        return list;
    }
}
