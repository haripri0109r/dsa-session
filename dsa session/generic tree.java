package Tree;
import java.util.*;

public class GenericTree {
    public static class Node {
        int data;
        List<Node> children = new ArrayList<>();
    }

    public static Node createGenericTree(int[] arr) {
        Stack<Node> st = new Stack<>();
        Node root = null; 

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1 && !st.empty()) {
                st.pop();
            } else {
                Node t = new Node();
                t.data = arr[i];
                if (st.size() == 0) {
                    root = t;
                } else {
                    st.peek().children.add(t);
                }
                st.push(t);
            }
        }
        return root;
    }

    public static void display(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " -> ");
        for (Node child : root.children) {
            System.out.print(child.data + ", ");
        }
        System.out.println(".");

        for (Node child : root.children) {
            display(child);
        }
    }

    public static int countNodes(Node root) {
        if (root == null) {
            return 0;
        }

        int count = 1;
        for (Node child : root.children) {
            count += countNodes(child);
        }
        return count;
    }

    public static int findMax(Node root) {
        if (root == null) {
            return 0;
        }

        int max=root.data;
        for (Node child : root.children) {
            if(child.data>max)
                max=child.data;
          findMax(child);
        }
        return max;
    }

public static int height(Node node){
    if(node==null){
        return -1;

    }

    int mh=-1;
    for(Node child:node.children){
        int ch=height(child);
        if(ch>mh){
            mh=ch;
        }
    }
}

    void main(String[] args) {
        int[] arr = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
        Node root = createGenericTree(arr);
        System.out.println("Generic Tree constructed. Displaying nodes:");
        display(root);
        System.out.print("No of Nodes:" + countNodes(root));
        System.out.print("Max Value:" + findMax(root));
        System.out.print("Height:" + height(root));
        
    }
}