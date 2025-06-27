package stack_and_queue;

public class QueueMain {
    public static void main(String[] args)throws Exception {
        CircularQueue q = new CircularQueue(5);
        q.insert(10);
        q.insert(3);
        q.insert(12);
        q.insert(2);
        q.insert(44);

        q.display();
        System.out.println(q.remove());
        q.insert(133);
        q.display();
    }
}
