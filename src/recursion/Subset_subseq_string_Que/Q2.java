package recursion.Subset_subseq_string_Que;

public class Q2 {
    public static void main(String[] args) {
        System.out.println(skipApples("i am apple from market"));
    }
    static String skipApples(String up){
        if (up.isEmpty()){
            return "";
        }

        if (up.startsWith("apple")){
            return skipApples(up.substring(5));
        }else {
            return up.charAt(0) + skipApples(up.substring(1));
        }
    }
}
