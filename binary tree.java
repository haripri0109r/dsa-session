import java.util.*;

public class Main {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    // ---------- TREE CREATION FUNCTION ----------
    public static Node createTree(int[] arr) {

    Node root = new Node(arr[0]);

    Stack<Pair> st = new Stack<>();
    st.push(new Pair(root, 1));

    int idx = 1;

    while (!st.isEmpty() && idx < arr.length) {

        Pair top = st.peek();

        if (top.state == 1) {

            if (arr[idx] != -1) {
                Node newNode = new Node(arr[idx]);
                top.node.left = newNode;
                st.push(new Pair(newNode, 1));
            }

            idx++;
            top.state++;

        } 
        else if (top.state == 2) {

            if (arr[idx] != -1) {
                Node newNode = new Node(arr[idx]);
                top.node.right = newNode;
                st.push(new Pair(newNode, 1));
            }

            idx++;
            top.state++;

        } 
        else {
            st.pop();
        }
    }

    return root;
}
    // ---------- DISPLAY FUNCTION ----------
    public static void display(Node node) {

        if (node == null)
            return;

        String str = "";

        if (node.left == null)
            str += "-1";
        else
            str += node.left.data;

        str += " <- " + node.data + " -> ";

        if (node.right == null)
            str += "-1";
        else
            str += node.right.data;

        System.out.println(str);

        display(node.left);
        display(node.right);
    }

       //Size of a binary tree
    public static int size(Node node){
        if(node==null){
            return 0;
        }
        else {
            int sleft=size(node.left);
            int sright=size(node.right);
            return sleft+sright+1;
        }
    }

    //Maximum value in a binary tree
    public static int max(Node node){
        if(node==null){
            return Integer.MIN_VALUE;
        }
        else {
            int mleft=max(node.left);
            int mright=max(node.right);
            return Math.max(node.data,Math.max(mleft,mright));
        }

        //Minimum value in a binary tree
    public static int min(Node node){
        if(node==null){
            return Integer.MAX_VALUE;
        }
        else {
            int mleft=min(node.left);
            int mright=min(node.right);
            return Math.min(node.data,Math.min(mleft,mright));
        }
    }   

 

    // ---------- MAIN FUNCTION ----------
    public static void main(String[] args) {

        int[] arr = {1,2,4,-1,5,-1,-1,3,6,-1,-1,7,-1,-1};

        Node root = createTree(arr);
        

        display(root);
        System.out.println("Size of the tree: " + size(root));
        System.out.println("Maximum value in the tree: " + max(root));

    }
 
}