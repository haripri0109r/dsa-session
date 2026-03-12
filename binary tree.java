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

    // ---------- MAIN FUNCTION ----------
    public static void main(String[] args) {

        int[] arr = {1,2,4,-1,5,-1,-1,3,6,-1,-1,7,-1,-1};

        Node root = createTree(arr);

        display(root);
    }

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


}