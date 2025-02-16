package LinkedList.LL.DLL;

public class Main {
    public static void main(String[] args) {
        LL list = new LL();
        list.insertFirst(10);
        list.insertFirst(20);
        list.insertFirst(30);
        list.insertLast(110);
        list.insert(10, 21);
        list.display();
//        list.displayReverse();
    }
}
