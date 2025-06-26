package LinkedList.LL;

public class LL {
    private Node head;
    private Node tail;

    private int size;
    public LL(){
        this.size = 0;
    }

    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        head = node;

        if (tail == null){
            tail = head;
        }

        size+=1;
    }

    public void insertEnd(int val){
        if (tail == null){
            insertFirst(val);
            return;
        }
        Node newNode = new Node(val);
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    public void insertAtAny(int val, int index){
        if (index == 1){
            insertFirst(val);
            return;
        }
        if (index == size){
            insertEnd(val);
            return;
        }

        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        Node newNode = new Node(val, temp.next);
        temp.next = newNode;
        size++;
    }

    public void insert(int val, int index){
        head = insertRec(val, index, head);
    }
    private Node insertRec(int val, int index, Node node){
        if (index == 0){
            Node temp = new Node(val, node);
            size++;
            return temp;
        }
        node.next = insertRec(val, index-1, node.next);
        return node;
    }
    public int deleteFirst(){
        int val = head.value;
        head = head.next;
        if (head == null){
            tail = null;
        }
        size--;
        return val;
    }


    public int deleteEnd(){
        if (size <= 1){
            deleteFirst();
        }
        int val = tail.value;
        Node secondLast = get(size-2);
        tail = secondLast;
        tail.next = null;
        return val;
    }
    public Node get(int index){
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public int deleteAtAny(int index){
        if (index == 0){
            deleteFirst();
        }
        if (index == size){
            deleteEnd();
        }
        Node prev = get(index-1);
        int val = prev.next.value;
        prev.next = prev.next.next;

        return val;
    }

    public void display(){
        Node temp = head;
        while (temp!=null){
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }

        System.out.println("END");
    }

    class Node{
        private int value;
        private Node next;

        public Node(int value){
            this.value = value;
        }

        public Node(int value, Node next){
            this.value = value;
            this.next = next;
        }

    }
}
