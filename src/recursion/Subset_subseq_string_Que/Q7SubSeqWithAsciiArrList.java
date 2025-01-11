package recursion.Subset_subseq_string_Que;

import java.util.ArrayList;

public class Q7SubSeqWithAsciiArrList {
    public static void main(String[] args) {
        System.out.println(subSeq("","abc"));
    }
    static ArrayList<String> subSeq(String p, String up){
        if (up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);

        ArrayList<String> first =  subSeq(p + ch, up.substring(1));
        ArrayList<String> second = subSeq(p, up.substring(1));
        ArrayList<String> third = subSeq(p+(ch+0), up.substring(1));

        first.addAll(second);
        first.addAll(third);
        return first;
    }
}
