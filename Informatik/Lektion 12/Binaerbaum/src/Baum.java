public class Baum {
    Knoten root;

    public void Insert(Knoten neu) {
        if (root == null)
        {
            root = neu;
        }
        else
        {
            Insert(root, neu);
        }
    }

    private void Insert(Knoten temp, Knoten neu) {
        if (neu.getWord().compareTo(temp.getWord()) < 0)
        {
            if (temp.left == null)
            {
                temp.left = neu;
            }
            else
            {
                Insert(temp.left, neu);
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
                Insert(temp.right, neu);
            }
        }
    }

    public void Print()
    {
        baumPrint(root);
    }

    private void baumPrint(Knoten temp)
    {
        if (temp.left != null)
        {
            baumPrint(temp.left);
        }
        System.out.println(temp.word);
        if (temp.right != null)
        {
            baumPrint(temp.right);
        }
    }

    public String search(String word)
    {
        return searchWord(root, word);
    }

    private String searchWord(Knoten knoten, String word)
    {
        if (knoten == null)
        {
            return null; // Word not found
        }

        int comparison = word.compareTo(knoten.getWord());

        if (comparison == 0) // Found the word
        {
            return knoten.getBedeutung();
        }
        else if (comparison < 0) // Word may be in the left subtree
        {
            return searchWord(knoten.left, word);
        }
        else // Word may be in the right subtree
        {
            return searchWord(knoten.right, word);
        }
    }

    public void delete(Knoten k)
    {
        root = deleteNode(root, k);
    }

    private Knoten deleteNode(Knoten root, Knoten k)
    {
        if (root == null)
        {
            return root; // Node not found
        }

        int comparison = k.getWord().compareTo(root.getWord());

        // Recursive cases for searching the node to be deleted
        if (comparison < 0)
        {
            root.left = deleteNode(root.left, k);
        }
        else if (comparison > 0)
        {
            root.right = deleteNode(root.right, k);
        }
        else
        {
            // Node with only one child or no child
            if (root.left == null)
            {
                return root.right;
            }
            else if (root.right == null)
            {
                return root.left;
            }

            // Node with two children: get the in-order successor (smallest in the right subtree)
            root.setWord(minValueNode(root.right).getWord());
            root.setBedeutung(minValueNode(root.right).getBedeutung());

            // Delete the in-order successor
            root.right = deleteNode(root.right, new Knoten(root.getWord(), root.getBedeutung()));
        }

        return root;
    }

    private Knoten minValueNode(Knoten root)
    {
        while (root.left != null)
        {
            root = root.left;
        }
        return root;
    }
}

