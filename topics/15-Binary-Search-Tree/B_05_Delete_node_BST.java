public class B_05_Delete_node_BST
{
    public TreeNode deleteNode(TreeNode root, int key)
    {
        TreeNode curr = root;
        TreeNode prev = null;
        while (curr != null && curr.val != key)
        {
            prev = curr;
            if (key > curr.val)
            {
                curr = curr.right;
            } 
            else
            {
                curr = curr.left;
            }
        }

        if (curr == null)
            return root;

        TreeNode replacement;

        if (curr.left == null)
        {
            replacement = curr.right;
        } 
        else
        {
            TreeNode front = curr.left;
            while (front.right != null)
            {
                front = front.right;
            }
            front.right = curr.right;
            replacement = curr.left;
        }

        if (prev == null)
        {
            return replacement;
        }

        if (prev.left == curr)
        {
            prev.left = replacement;
        } else
        {
            prev.right = replacement;
        }

        return root;
    }
}
