package recursion;

import java.util.ArrayList;
import java.util.List;

public class LeetCode17 {
    public static void main(String[] args) {
        System.out.println(phonepadList("","12"));
    }
    static void phonepad(String p, String up){
        if (up.isEmpty()){
            System.out.println(p);
            return;
        }

        int digit = up.charAt(0) - '0';

        for (int i = (digit - 1) * 3; i < digit * 3; i++) {
            char ch = (char) ('a' + i);
            phonepad(p + ch, up.substring(1));
        }
    }

    static ArrayList<String> phonepadArrList(String p, String up){
        if (up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        int digit = up.charAt(0) - '0';
        ArrayList<String> ans = new ArrayList<>();
        for (int i = (digit - 1) * 3; i < digit * 3; i++) {
            char ch = (char) ('a' + i);
            ans.addAll(phonepadArrList(p + ch, up.substring(1)));
        }
        return ans;
    }

    static List<String> phonepadList(String p, String up){
        if (up.isEmpty()){
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        int digit = up.charAt(0) - '0';
        List<String> ans = new ArrayList<>();
        for (int i = (digit - 1) * 3; i < digit * 3; i++) {
            char ch = (char) ('a' + i);
            ans.addAll(phonepadList(p + ch, up.substring(1)));
        }
        return ans;
    }

    static int phonepadCount(String p, String up){
        if (up.isEmpty()){
            System.out.println(p);
            return 1;
        }
        int count = 0;
        int digit = up.charAt(0) - '0';

        for (int i = (digit - 1) * 3; i < digit * 3; i++) {
            char ch = (char) ('a' + i);
            count += phonepadCount(p + ch, up.substring(1));
        }
        return count;
    }
}
