public class B_07_Validate_BST
{
    public static boolean solve(TreeNode root , Long min , Long max)
    {
        if(root == null)return true;

        if(root.val >= max || root.val <= min)return false;

        return solve(root.left, min, (long) root.val) && solve(root.right, (long) root.val, max);
    }

    public boolean isValidBST(TreeNode root)
    {
        return solve(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}
