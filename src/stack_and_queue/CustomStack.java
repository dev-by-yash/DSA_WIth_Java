package stack_and_queue;

public class CustomStack {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;

    int top = -1;

    CustomStack(){
        this(DEFAULT_SIZE);
    }
    CustomStack(int size){
        this.data = new int[size];
    }

    public boolean push(int item){
        if(isFull()){
            System.out.println("stack is full");
            return false;
        }

        top++;
        data[top] = item;
        return true;
    }
    public int pop() throws Exception{
        if (isEmpty()){
            throw new Exception("cannot pop from an empty stack");
        }
        int removedItem = data[top];
        top--;
        return removedItem;
    }
    public int peek(){
        return data[top];
    }

    public boolean isFull(){
        return top == data.length - 1;
    }
    private boolean isEmpty(){
        return top == - 1;
    }
}
