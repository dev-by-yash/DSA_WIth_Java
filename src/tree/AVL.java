package tree;

public class AVL {
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
    public  AVL(){}
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
        return rotate(node);
    }
    private Node rotate(Node node){
        if (height(node.left) - height(node.right) > 1){
            // left heavy
            if (height(node.left.left) - height(node.left.right) > 0){
                // left-left case
                return rightRotate(node);
            }
            if (height(node.left.left) - height(node.left.right) < 0){
                // left-right case
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }

        if (height(node.left) - height(node.right) < -1){
            // right heavy
            if (height(node.right.left) - height(node.right.right) < 0){
                // right-right case
                return leftRotate(node);
            }
            if (height(node.right.left) - height(node.right.right) > 0){
                // right-left case (FIXED HERE)
                node.right = rightRotate(node.right); // ✅ FIXED LINE
                return leftRotate(node);
            }
        }

        return node;
    }

    public Node rightRotate(Node p){
        Node c = p.left;
        Node t = c.right;

        c.right = p;
        p.left = t;

        p.height = Math.max(height(p.left), height(p.right)+1);
        c.height = Math.max(height(c.left), height(c.right)+1);
        return c;
    }
    public Node leftRotate(Node c){
        Node p = c.right;  // fix here
        Node t = p.left;   // middle subtree

        // Perform rotation
        p.left = c;
        c.right = t;

        // Update heights
        c.height = Math.max(height(c.left), height(c.right)) + 1;
        p.height = Math.max(height(p.left), height(p.right)) + 1;

        return p;
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

    public static void main(String[] args) {
        AVL tree = new AVL();
        int[] nums = {21,26,30,9,4,14,28,18,15,10,2,3,7};
        // Insert each value
        for (int num : nums) {
            tree.insert(num);
        }

        // Display the tree visually
        System.out.println("Tree Structure:");
        tree.displayTree();
    }
}
