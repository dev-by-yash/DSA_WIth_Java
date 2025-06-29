package heap;

import java.util.ArrayList;

public class Heap<T extends Comparable<T>> {
    private ArrayList<T> list;
    public Heap(){
        list = new ArrayList<>();
    }
    private void swap(int first, int second){
        T temp = list.get(first);
        list.set(first,list.get(second));
        list.set(second,temp);
    }
    private int parent(int i){
        return (i-1)/2;
    }
    private int left(int i){
        return i*2+1;
    }
    private int right(int i){
        return i*2+2;
    }
    public void insert(T value){
        list.add(value);
        upHeap(list.size()-1);
    }
    private  void upHeap(int index){
        if (index == 0){
            return;
        }
        int p = parent(index);
        if (list.get(index).compareTo(list.get(p))<0){
            swap(index,p);
            upHeap(p);
        }
    }
    public T remove() throws Exception{
        if (list.isEmpty()){
            throw new Exception("heap is empty");
        }
        T temp = list.get(0);
        T last = list.remove(list.size()-1);
        if(!list.isEmpty()){
            list.set(0,last);
            downHeap(0);
        }
        return temp;
    }
    private void downHeap(int index){
        int min = index;
        int left = left(index);
        int right = right(index);

        if (left<list.size() && list.get(min).compareTo(list.get(left))>0){
            min = left;
        }
        if (right<list.size() && list.get(min).compareTo(list.get(right))>0){
            min = right;
        }
        if(min != index){
            swap(min,index);
            downHeap(min);
        }
    }

    public static void main(String[] args) throws Exception {
        Heap<Integer> h = new Heap<>();
        h.insert(34);
        h.insert(45);
        h.insert(22);
        h.insert(89);
        h.insert(76);

        System.out.println(h.remove());
        System.out.println(h.remove());
        System.out.println(h.remove());
        System.out.println(h.remove());
        System.out.println(h.remove());
    }
}
