package tree;

public class BST {
    private static class Node{
       private int val;
        private int height;
        Node left;
        Node right;
        public Node(int val){
            this.val = val;
        }
        public int getValue(){
            return val;
        }
    }
    private Node root;
    public  BST(){}
    public int height(Node node){
        if(node == null){
            return -1;
        }
        return node.height;
    }

    public boolean isEmpty(){
        return root == null;
    }
    public void insert(int val){
        root = insert(val, root);
    }
    private Node insert(int val, Node node){
        if(node == null){
            node = new Node(val);
            return node;
        }
        if(val < node.val){
            node.left = insert(val, node.left);
        }
        if(val > node.val){
            node.right = insert(val, node.right);
        }
        node.height = Math.max(height(node.left), height(node.right))+1;
        return node;
    }
    public void populate(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            this.insert(nums[i]);
        }
    }
    public void populatedSorted(int[] nums){
        populatedSorted(nums,0, nums.length-1);
    }
    private void populatedSorted(int[] nums, int start, int end){
        if(start >= end){
            return;
        }
        int mid = (start+end)/2;
        this.insert(nums[mid]);
        populatedSorted(nums,start,mid);
        populatedSorted(nums,mid+1,end);
    }
    public boolean balanced(){
        return balanced(root);
    }
    private boolean balanced(Node node){
        if(node == null){
            return true;
        }
        return Math.abs(height(node.left) - height(node.right)) <= 1 && balanced(node.left) && balanced(node.right);
    }

    public void display(){
        display(this.root, "Root Node: ");
    }
    private void display(Node node, String details){
        if (node == null){
            return;
        }
        System.out.println(details+node.val);
        display(node.left,"left child of "+node.val+":");
        display(node.right,"right child of "+node.val+":");
    }
    public void displayTree() {
        displayTree(this.root, "", true);
    }

    private void displayTree(Node node, String prefix, boolean isTail) {
        if (node == null) {
            return;
        }
        System.out.println(prefix + (isTail ? "└── " : "├── ") + node.val);
        if (node.left != null || node.right != null) {
            if (node.left != null) {
                displayTree(node.left, prefix + (isTail ? "    " : "│   "), node.right == null);
            }
            if (node.right != null) {
                displayTree(node.right, prefix + (isTail ? "    " : "│   "), true);
            }
        }
    }
    public void preorder(){
        preorder(root);
    }
    private void preorder(Node node){
        if (node == null){
            return;
        }
        System.out.println(node.val+" ");
        preorder(node.left);
        preorder(node.right);
    }
}
