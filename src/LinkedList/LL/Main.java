package LinkedList.LL;

public class Main {
    public static void main(String[] args) {
        LL list = new LL();

        list.insertFirst(11);
        list.insertFirst(23);
        list.insertFirst(13);
        list.insertFirst(137);
        list.insertEnd(4);
        list.insertAtAny(44, 3);
        list.display();

        list.deleteEnd();
        list.display();

        list.deleteAtAny(3);
        list.display();
    }
}
