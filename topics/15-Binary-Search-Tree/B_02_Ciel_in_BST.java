public class B_02_Ciel_in_BST
{
    public int ceil(TreeNode root , int val)
    {
        int ceil = -1;

        while(root != null)
        {
            if(root.val == val)
            {
                ceil = root.val;
                return ceil;
            }
            if(val < root.val)
            {
                ceil = root.val;
                root = root.left;
            }
            else
            {
                root = root.right;
            }
        }
        return ceil;
    }    
}
