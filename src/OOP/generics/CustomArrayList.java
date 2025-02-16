package OOP.generics;

import java.util.Arrays;

public class CustomArrayList {
    private  int[] data;
    private static int default_size = 10;
    private int size = 0;

    CustomArrayList(){
        this.data = new int[default_size];
    }
    private void add(int num){
        if (isFull()){
            resize();
        }
        data[size++] = num;
    }

    private void resize() {
        int[] temp = new int[data.length*2];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }

    private int remove(){
        int removed = data[--size];
        return removed;
    }

    private boolean isFull(){
        return size == data.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(data);
    }

    public static void main(String[] args) {
        CustomArrayList list = new CustomArrayList();
        list.add(2);
        list.add(5);
        list.add(8);

        System.out.println(list);
    }
}
