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

public class T_07_Max_Depth // leetcode 104
{
    public static int maxDepth(TreeNode root) 
    {
        if(root == null)return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return 1 + Math.max(left, right);
    }
}
