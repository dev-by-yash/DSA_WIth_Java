package arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class arrayListExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            list.add(sc.nextInt());
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(list.get(i));
        }
    }
}
