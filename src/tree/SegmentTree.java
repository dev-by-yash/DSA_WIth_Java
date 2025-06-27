package tree;

public class SegmentTree {
    private class Node{
        int data;
        int startinterval;
        int endinterval;
        Node left;
        Node right;

        public Node(int startinterval, int endinterval){
            this.startinterval = startinterval;
            this.endinterval = endinterval;
        }
    }
    Node root;
    SegmentTree(int[] arr){
        this.root = constructTree(arr,0,arr.length-1);
    }
    private  Node constructTree(int[] arr, int start, int end){
        if(start==end){
//            leaf node
            Node leaf = new Node(start,end);
            leaf.data = arr[start];
            return leaf;
        }

        Node node = new Node(start,end);
        int mid = (start + end)/2;
        node.left = this.constructTree(arr,start,mid);
        node.right = this.constructTree(arr,mid+1,end);

        node.data = node.left.data + node.right.data;
        return node;
    }

    public void display(){
        display(this.root);
    }
    private void display(Node node) {
        String str = "";

        if (node.left != null) {
            str += "interval [" + node.left.startinterval + "-" + node.left.endinterval + "] data: " + node.left.data + " -> ";
        } else {
            str += "no left child -> ";
        }

        // current node
        str += "interval [" + node.startinterval + "-" + node.endinterval + "] data: " + node.data + " -> ";

        if (node.right != null) {
            str += "interval [" + node.right.startinterval + "-" + node.right.endinterval + "] data: " + node.right.data;
        } else {
            str += "no right child";
        }

        System.out.println(str);

        // recursion
        if (node.left != null) {
            display(node.left);
        }
        if (node.right != null) {
            display(node.right);
        }
    }


//    query
    public int query(int qsi, int qei){
        return this.query(this.root,qsi,qei);
    }
    private int query(Node node, int qsi, int qei) {
        // total overlap
        if (node.startinterval >= qsi && node.endinterval <= qei) {
            return node.data;
        }
        // no overlap
        else if (node.endinterval < qsi || node.startinterval > qei) {
            return 0;
        }
        // partial overlap
        else {
            int leftSum = query(node.left, qsi, qei);
            int rightSum = query(node.right, qsi, qei);
            return leftSum + rightSum;
        }
    }


    public void update(int index, int val){
        this.root.data = update(this.root,index,val);
    }
    private int update(Node node, int index, int value) {
        if (index >= node.startinterval&& index <= node.endinterval){
            if(index == node.startinterval && index == node.endinterval) {
                node.data = value;
                return node.data;
            } else {
                int leftAns = update(node.left, index, value);
                int rightAns = update(node.right, index, value);
                node.data = leftAns + rightAns;
                return node.data;
            }
        }
        return node.data;
    }
    public static void main(String[] args) {
        int[] arr = {3, 8, 7,6,-2,-8,4,9};
        SegmentTree tree = new SegmentTree(arr);
         tree.display();

        System.out.println(tree.query(2, 6));
    }
}