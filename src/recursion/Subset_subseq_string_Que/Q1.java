package recursion.Subset_subseq_string_Que;

public class Q1 {
    public static void main(String[] args) {
        skip("","eanjanalhrglalaag");
    }
    static void skip(String p, String unp){
        if (unp.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch = unp.charAt(0);

        if (ch == 'a') {
            skip(p,unp.substring(1));
        }else {
            skip(p+ch, unp.substring(1));
        }
    }
}
