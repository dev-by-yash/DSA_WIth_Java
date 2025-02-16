package LinkedList.LL.CLL;

public class LL {
    private Node head;
    private Node tail;
    public LL(){
        this.head = null;
        this.tail = null;
    }

    public void insert(int val){
        Node newNode = new Node(val);
        if (head == null){
            head = newNode;
            tail = newNode;
            return;
        }
        tail.next = newNode;
        newNode.next = head;
        tail = newNode;
    }
    public void delete(int val){
        Node temp = head;
        if (temp == null){
            return;
        }
        if (temp.value == val){
            head = head.next;
            tail.next = head;
        }
        do {
            Node n = temp.next;
            if (n.value == val){
                temp.next = n.next;
                break;
            }
            temp = temp.next;
        }while (temp != head);
    }
    public void display(){
        Node temp = head;
        if (head != null){
            do {
                System.out.print(temp.value + " -> ");
                temp = temp.next;
            }while (temp != head);
        }
        System.out.println("HEAD");
    }
    class Node{
        private int value;
        private Node next;

        public Node(int value){
            this.value = value;
        }
    }
}
