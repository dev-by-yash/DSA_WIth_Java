package recursion.Subset_subseq_string_Que;

public class Q3 {
    public static void main(String[] args) {
        System.out.println(skipAppNotApples("i am app from market"));
    }
    static String skipAppNotApples(String up){
        if (up.isEmpty()){
            return "";
        }

        if (up.startsWith("app") && !up.startsWith("apple")){
            return skipAppNotApples(up.substring(3));
        }else {
            return up.charAt(0) + skipAppNotApples(up.substring(1));
        }
    }
}
