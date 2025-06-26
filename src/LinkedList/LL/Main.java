package LinkedList.LL;

public class Main {
    public static void main(String[] args) {
        LL list = new LL();

        list.insertFirst(11);
        list.insertFirst(23);
        list.insertFirst(22);
        list.insertFirst(21);
        list.insert(43,2);
//        list.insertAtAny(44, 3);
        list.display();
//
//        list.deleteEnd();
//        list.display();
//
//        list.deleteAtAny(3);
//        list.display();
    }
}
