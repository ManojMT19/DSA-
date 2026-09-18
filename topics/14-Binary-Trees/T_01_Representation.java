public class T_01_Representation
{
    static class Node
    {
        Node right;
        Node left;
        int data;

        Node(int key)
        {
            data = key;
        }
    }

    public static void main(String[] args)
    {
        Node root = new Node(1);

        root.right = new Node(2);
        root.left = new Node(3);
        root.right.left = new Node(4);
        
    }
}

