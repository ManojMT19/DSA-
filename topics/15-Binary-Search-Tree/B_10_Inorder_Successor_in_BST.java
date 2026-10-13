
public class B_10_Inorder_Successor_in_BST
{
    public static void inorder(TreeNode root , int key , int i[])
    {
        if(root == null)return ;

        if(root.val > key && root.val < i[0])
        {
            i[0] = root.val;
        }
        if(key < root.val)
        {
            inorder(root.left, key, i);
        }
        else
        {
            inorder(root.right, key, i);
        }
    }

    public int inorder_successor_1(TreeNode root , int key)
    {
        int i[] = new int[1];
        i[0] = Integer.MAX_VALUE;
        inorder(root, key, i);

        return i[0];

        // TC = O(h)
        // SC = O(h)
    }

    public TreeNode inorder_successor_2(TreeNode root , TreeNode key)
    {
        TreeNode successor = null;

        while (root != null) 
        {
            if(key.val >= root.val)
            {
                root = root.right;
            }
            else
            {
                successor = root;
                root = root.left;
            }
        }
        return successor;
        
        // TC = O(h)
        // SC = O(1)
    }
    public TreeNode inorder_predessor_2(TreeNode root , TreeNode key)
    {
        TreeNode successor = null;

        while (root != null) 
        {
            if(key.val >= root.val)
            {
                successor = root;
                root = root.right;
            }
            else
            {
                root = root.left;
            }
        }
        return successor;

        // TC = O(h)
        // SC = O(1)
    }
}
