package org.example;

public class Binaerbaum
{
    String name;
    Knoten root;

    static class Knoten
    {
        String nachname;
        Knoten left;
        Knoten right;

        public Knoten(String name)
        {
            this.nachname = name;
        }
        public String getNachname()
        {
            return nachname;
        }
        public void setNachname(String nachname)
        {
            this.nachname = nachname;
        }

    }
    public void insert(Knoten neu)
    {
        if (root == null)
        {
            root = neu;
        }
        else
        {
            insertElement(root, neu);
        }
    }
    private static void insertElement(Knoten temp, Knoten neu)
    {
        if (neu.getNachname().compareTo(temp.getNachname()) < 0)
        {
            if(temp.left == null)
            {
                temp.left = neu;
            }
            else
            {
                insertElement(temp.left, neu);
            }
        }
        else
        {
            if (temp.right == null)
            {
                temp.right = neu;
            }
            else
            {
                insertElement(temp.right, neu);
            }
        }
    }
    public void printForward() {
        printInOrder(root);
    }

    private void printInOrder(Knoten node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.println(node.getNachname());
            printInOrder(node.right);
        }
    }
}
