package stack_and_queue;

public class CustomQueue {
    private int[] data;
    int end = 0;
    private static final int DEFAULT_SIZE = 10;

    CustomQueue(){
        this(DEFAULT_SIZE);
    }
    CustomQueue(int size){
        this.data = new int[size];
    }
    public boolean isFull(){
        return end == data.length;
    }
    private boolean isEmpty(){
        return end ==0;
    }
    public boolean insert(int item){
        if (isFull()){
            return false;
        }
        data[end++] = item;
        return true;
    }

    public int remove()throws Exception{
        if (isEmpty()){
            throw new Exception("queue is empty");
        }
        int item = data[0];
//        shifting elements
        for (int i = 1; i < end; i++) {
            data[i-1] = data[i];
        }
        end--;
        return item;
    }
    public int front()throws Exception{
        if (isEmpty()){
            throw new Exception("queue is empty");
        }
        return data[0];
    }
    public void display(){
        for (int i = 0; i < end; i++) {
            System.out.print(data[i]+" ");
        }
    }
}
