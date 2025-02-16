package LinkedList.LL.CLL;

public class Main {
    public static void main(String[] args) {
        LL list = new LL();
        list.insert(1);
        list.insert(12);
        list.insert(11);
        list.insert(21);

        list.display();

        list.delete(12);
        list.display();

        list.delete(11);
        list.display();

        list.delete(21);
        list.display();
    }
}
