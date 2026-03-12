import java.util.*;

public class generic_tree {

    public static class Node {
        int data;
        List<Node> children = new ArrayList<>();
    }

    public static Node createGenericTree(int[] arr) {

        Stack<Node> st = new Stack<>();
        Node root = null;

        for (int val : arr) {

            if (val == -1) {
                st.pop();
            } 
            else {

                Node node = new Node();
                node.data = val;

                if (st.size() > 0) {
                    st.peek().children.add(node);
                } 
                else {
                    root = node;
                }

                st.push(node);
            }
        }

        return root;
    }

    public static void display(Node node) {

        if (node == null) return;

        System.out.print(node.data + " -> ");

        for (Node child : node.children) {
            System.out.print(child.data + ", ");
        }

        System.out.println(".");

        for (Node child : node.children) {
            display(child);
        }
    }

    public static int countNodes(Node node) {

        int count = 1;

        for (Node child : node.children) {
            count += countNodes(child);
        }

        return count;
    }

    public static int findMax(Node node) {

        int max = node.data;

        for (Node child : node.children) {

            int cm = findMax(child);
            max = Math.max(max, cm);

        }

        return max;
    }

    public static int height(Node node) {

        int mh = -1;

        for (Node child : node.children) {

            int ch = height(child);
            mh = Math.max(mh, ch);

        }

        return mh + 1;
    }

    public static void main(String[] args) {

        int[] arr = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};

        Node root = createGenericTree(arr);

        System.out.println("Generic Tree constructed. Displaying nodes:");
        display(root);

        System.out.println("No of Nodes: " + countNodes(root));
        System.out.println("Max Value: " + findMax(root));
        System.out.println("Height: " + height(root));
    }
}