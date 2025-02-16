package LinkedList.LL.DLL;

public class LL {
    private Node head;

    private int size;
    public LL(){
        this.size = 0;
    }

    public void insertFirst(int val){
        Node newNode = new Node(val);
        newNode.next = head;
        newNode.prev = null;
        if (head != null){
            head.prev = newNode;
        }
        head = newNode;
    }
    public void insertLast(int val){
        Node newNode = new Node(val);
        Node last = head;
        if (head == null){
            newNode.prev = null;
            head = newNode;
        }
        while (last.next != null){
          last = last.next;
        }
        last.next = newNode;
        newNode.next = null;
        newNode.prev = last;
    }
    public Node find(int value) {
        Node node = head;
        while (node != null) {
            if (node.value == value) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public void insert(int after, int val) {
        Node p = find(after);

        if (p == null) {
            System.out.println("does not exist");
            return;
        }

        Node node = new Node(val);
        node.next = p.next;
        p.next = node;
        node.prev = p;
        if (node.next != null) {
            node.next.prev = node;
        }
    }

    public void display(){
        Node node = head;
        while (node != null){
            System.out.print(node.value + " -> ");
            node = node.next;
        }
        System.out.println("END");
    }
    public void displayReverse(){
        Node node = head;
        Node last = null;
        while (node != null){
            System.out.print(node.value + " -> ");
            last = node;
            node = node.next;
        }
        System.out.println();
        while (last != null){
            System.out.print(last.value + " -> ");
            last = last.prev;
        }
        System.out.println();
    }

    class Node{
        private int value;
        private Node next;
        private Node prev;

        public Node(int value){
            this.value = value;
        }

        public Node(int value, Node next){
            this.value = value;
            this.next = next;
        }
        public Node(int value, Node next, Node prev){
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }
}
