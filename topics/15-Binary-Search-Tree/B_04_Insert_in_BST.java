public class B_04_Insert_in_BST
{
    public TreeNode insertIntoBST(TreeNode root, int val)
    {
        if(root == null)return new TreeNode(val);

        TreeNode curr = root;

        while (curr != null)
        {
            if (val > curr.val)
            {
                if(curr.right != null)
                {
                    curr = curr.right;
                }
                else
                {
                    curr.right = new TreeNode(val);
                    break;
                }
            } 
            else 
            {
                if(curr.left != null)
                {
                    curr = curr.left;
                }
                else
                {
                    curr.left = new TreeNode(val);
                    break;
                }
            }
        }
        return root;

        // TC = O(log n)
        // SC = O(1)
    }
}
