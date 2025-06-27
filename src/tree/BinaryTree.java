package tree;

import javax.swing.plaf.synth.SynthTreeUI;
import java.util.Scanner;

public class BinaryTree {
    public BinaryTree(){}
    private static class Node{
        int val;
        Node left;
        Node right;
        public Node(int val){
            this.val = val;
        }
    }
    private Node root;
    public void populate(Scanner sc){
        System.out.println("enter root node:");
        int val = sc.nextInt();
        this.root = new Node(val);
        populate(sc, this.root);
    }
    private void populate(Scanner sc, Node node){
        System.out.println("do you want to enter left of "+node.val);
        boolean left = sc.nextBoolean();
        if (left){
            System.out.println("enter value of left of "+node.val);
            int val = sc.nextInt();
            node.left = new Node(val);
            populate(sc,node.left);
        }
        System.out.println("do you want to enter right of "+node.val);
        boolean right = sc.nextBoolean();
        if (right){
            System.out.println("enter value of right of "+node.val);
            int val = sc.nextInt();
            node.right = new Node(val);
            populate(sc,node.right);
        }
    }
    public void display(){
        display(root, "");
    }
    private void display(Node node, String indent){
        if(node==null){
            return;
        }
        System.out.println(indent + node.val);
        display(node.left,indent + "\t");
        display(node.right,indent + "\t");
    }
    public void prettyDisplay(){
        prettyDisplay(root, 0);
    }
    private void prettyDisplay(Node node, int level){
        if(node==null){
            return;
        }
        prettyDisplay(node.right,level+1);
        if(level != 0){
            for(int i = 0; i < level-1; i++){
                System.out.print("|\t\t");
            }
            System.out.println("|--------->"+node.val);
        }else {
            System.out.println(node.val);
        }
        prettyDisplay(node.left,level+1);

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
//        Scanner sc = new Scanner(System.in);
//        BinaryTree bt = new BinaryTree();
//        bt.populate(sc);
//        bt.prettyDisplay();
        BST bst = new BST();
        int[] nums = {15,10,20,5,3,6,8};
        bst.populate(nums);
        bst.displayTree();
        bst.preorder();
    }
}
