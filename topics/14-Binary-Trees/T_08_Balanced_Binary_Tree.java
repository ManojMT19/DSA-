class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val)
    {
        this.val = val;
    }
} 

public class T_08_Balanced_Binary_Tree
{
    // if any one of the subtree unbalanced then whole tree is unbalanced

    public static int depth(TreeNode root)
    {
        if(root == null) return 0;
        
        int left = depth(root.left);
        if(left == -1) return -1;
        
        int right = depth(root.right);
        if(right == -1) return -1;

        if(Math.abs(left - right) > 1) return -1;

        return 1 + Math.max(left, right); 
    }

    
    public static boolean isBalanced(TreeNode root) 
    {
        return depth(root) != -1;
    }

    // -----------------------------------------------------------------------------------------------------------

    public static int maxDepth(TreeNode root)
    {
        if(root == null) return 0;

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
    
    public static boolean isBalanced_brute(TreeNode root) 
    {
        if(root == null)return false;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        if(Math.abs(left - right) > 1)return false;

        return isBalanced_brute(root.left) && isBalanced_brute(root.right);
    }
}
