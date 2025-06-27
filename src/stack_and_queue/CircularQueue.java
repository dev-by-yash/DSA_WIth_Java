package stack_and_queue;

public class CircularQueue {
    protected int[] data;
    protected int end = 0;
    protected int front = 0;
    private int size = 0;
    private static final int DEFAULT_SIZE = 10;

    CircularQueue(){
        this(DEFAULT_SIZE);
    }
    CircularQueue(int size){
        this.data = new int[size];
    }
    public boolean isFull(){
        return size == data.length;
    }
    private boolean isEmpty(){
        return size ==0;
    }
    public boolean insert(int item){
        if (isFull()){
            return false;
        }
        data[end++] = item;
        end = end % data.length;
        size++;
        return true;
    }
    public int remove()throws Exception{
        if (isEmpty()){
            throw new Exception("queue is empty");
        }
        int item = data[front++];
        front = front % data.length;
        size--;
        return item;
    }
    public int front()throws Exception{
        if (isEmpty()){
            throw new Exception("queue is empty");
        }
        return data[front];
    }
    public void display(){
        int i = front;
        do {
            System.out.print(data[i]+" -> ");
            i++;
            i %= data.length;
        }while (i != end);
        System.out.println(" END");
    }


}
