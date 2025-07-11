package _05_Graphen_Part_2;

import java.util.LinkedList;

public class Tree {
    Node root;

    public Tree(int data) {

        root = new Node(data);
    }

    // search first node with null children and add new node there
    public void addData(int data) {

        LinkedList<Node> queue = new LinkedList<Node>(); // use as Queue
        queue.addFirst(root);

        Node new_node = new Node(data);

        while(queue.size() > 0) {

            Node tmp = queue.removeLast();

            if(tmp.left != null) {

                queue.addFirst(tmp.left);

            } else {

                tmp.left = new_node;
                return;
            }

            if(tmp.right != null) {

                queue.addFirst(tmp.right);

            } else {

                tmp.right = new_node;
                return;
            }
        }
    }

    // go through all nodes (Breitensuche) and print each layer
    public void showTree() {

        LinkedList<Node> queue = new LinkedList<Node>(); // use as Queue
        queue.addFirst(root);

        int count = 0;

        StringBuilder s = new StringBuilder();

        while (!queue.isEmpty()) {

            Node tmp = queue.removeLast();

            count++;

            if (count <= 1) {
                s.append("<").append(tmp.data).append(">");
            } else if (count <= 3) {
                s.append("<").append(tmp.data).append(">\t\t\t\t\t\t\t");
            } else if (count <= 7) {
                s.append("<").append(tmp.data).append(">\t\t\t\t");
            } else if (count <= 15) {
                s.append("<").append(tmp.data).append(">\t\t");
            }

            if (tmp.left != null) queue.addFirst(tmp.left);
            if (tmp.right != null) queue.addFirst(tmp.right);

            if (count == 1) {
                System.out.println("\t\t\t\t\t\t\t\t" + s + "\n");
                s = new StringBuilder();
            }
            if (count == 3) {
                System.out.println("\t\t\t\t\t" + s + "\n");
                s = new StringBuilder();
            }
            if (count == 7) {
                System.out.println("\t\t\t" + s + "\n");
                s = new StringBuilder();
            }
            if (count == 15) {
                System.out.println("\t\t" + s + "\n");
                s = new StringBuilder();
            }
        }
    }
}
