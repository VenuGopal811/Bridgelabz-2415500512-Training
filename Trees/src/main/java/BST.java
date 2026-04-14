

public class BST {
    public static void main(String[] args) {
        Node root = null;
        int[] arr= {10, 5, 15, 3, 7, 12, 18};
        for(int val : arr) {
            root = insert(root, val);
        }

        System.out.println("Inorder Traversal of the BST:");
        inorder(root);
    }

    public static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    public static Node insert(Node root, int data){
        if(root == null){
            root = new Node(data);
            return root;
        }
        if(data < root.data){
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }
        return root;
    }
    
    public static class Node {
        int data;
        Node left, right;
        
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
}