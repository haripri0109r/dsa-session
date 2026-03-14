import java.util.*;

public class bst{

    // Node class
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    // -------- INSERT FUNCTION --------
    public static Node insert(Node root, int val) {

        if (root == null)
            return new Node(val);

        if (val < root.data)
            root.left = insert(root.left, val);

        else if (val > root.data)
            root.right = insert(root.right, val);

        return root;
    }

    // -------- CREATE BST --------
    public static Node createBST(int[] arr) {

        Node root = null;

        for (int val : arr) {
            root = insert(root, val);
        }

        return root;
    }

    // -------- DISPLAY FUNCTION --------
    public static void display(Node node) {

        if (node == null)
            return;

        String str = "";

        if (node.left == null)
            str += ".";
        else
            str += node.left.data;

        str += " <- " + node.data + " -> ";

        if (node.right == null)
            str += ".";
        else
            str += node.right.data;

        System.out.println(str);

        display(node.left);
        display(node.right);
    }

    // -------- SIZE FUNCTION --------
    public static int size(Node node) {

        if (node == null)
            return 0;

        int leftSize = size(node.left);
        int rightSize = size(node.right);

        return leftSize + rightSize + 1;
    }

    // -------- MAX FUNCTION --------
    public static int max(Node node) {

        if (node.right == null)
            return node.data;

        return max(node.right);
    }

    // -------- HEIGHT FUNCTION --------
    public static int height(Node node) {

        if (node == null)
            return -1;  // edge based height

        int lh = height(node.left);
        int rh = height(node.right);

        return Math.max(lh, rh) + 1;
    }

    // -------- MAIN FUNCTION --------
    public static void main(String[] args) {

        int[] arr = {50,25,75,12,37,62,87};

        Node root = createBST(arr);

        display(root);

        System.out.println("Size: " + size(root));
        System.out.println("Max: " + max(root));
        System.out.println("Height: " + height(root));
    }
}
