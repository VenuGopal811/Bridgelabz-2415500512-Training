package Trees;

import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class Tree{
    public static void main(String[] args) {
        //0 level
        Node root = new Node(25);

        //1 level
        root.left = new Node(10);
        root.right = new Node(35);

        //2 level
        root.left.left = new Node(5);
        root.left.right = new Node(15);
        root.right.left = new Node(30);
        root.right.right = new Node(40);

        //3 level
        root.left.right.left = new Node(13);
        root.left.right.right = new Node(20);

        System.out.println("Preorder Traversal:");
        preOrder(root);
        System.out.println("\nInorder Traversal:");
        inOrder(root);
        System.out.println("\nPostorder Traversal:");
        postOrder(root);
        System.out.println("Preorder List:");
        preorderList(root);

    }

    static void preOrder(Node root){
        if(root == null) return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    static void inOrder(Node root){
        if(root == null) return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    static void postOrder(Node root){
        if(root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    static List<Integer> preorderList(Node root){
        if(root==null) return new ArrayList<>();

        List<Integer> ans= new ArrayList<>();

        System.out.print(root.data + " ");

        ans.addAll(preorderList(root.left));
        ans.addAll(preorderList(root.right));
        
        return ans;
    }
}
