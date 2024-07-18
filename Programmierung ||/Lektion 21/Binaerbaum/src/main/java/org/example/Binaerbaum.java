package org.example;

public class Binaerbaum<T extends Comparable<T>>
{
    Knoten<T> root;

    public static class Knoten<T>
    {
        T value;
        Knoten<T> left;
        Knoten<T> right;

        public Knoten(T value)
        {
            this.value = value;
        }
        public T getValue()
        {
            return value;
        }
    }
    public void insert(Knoten<T> neu)
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
    private void insertElement(Knoten<T> temp, Knoten<T> neu)
    {
        if (neu.getValue().compareTo(temp.getValue()) < 0)
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

    private void printInOrder(Knoten<T> node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.println(node.getValue());
            printInOrder(node.right);
        }
    }
}
