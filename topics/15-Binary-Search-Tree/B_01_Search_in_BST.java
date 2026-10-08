public class B_01_Search_in_BST
{
    public TreeNode searchBST(TreeNode root, int val) 
    {
        while (root != null && root.val != val) 
        {
            if(val < root.val)    
            {
                root = root.left;
            }
            else
            {
                root = root.right;
            }
        }
        return root;
    }    
}
