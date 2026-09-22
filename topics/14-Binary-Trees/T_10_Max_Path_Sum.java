class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode()
    {
    }

    TreeNode(int val)
    {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right)
    {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class T_10_Max_Path_Sum  // Leetcode 124   --  kind of important problem   
{
    public static int maxDepth(TreeNode root , int maxx[])
    {
        if(root == null)return 0;

        int left = Math.max(0 , maxDepth(root.left , maxx)); // here we comparing wiht 0 to remove the negative value 

        int right = Math.max(0, maxDepth(root.right , maxx));

        maxx[0] = Math.max(maxx[0], left + right + root.val);      
        
        return root.val + Math.max(left, right);
    }
    public static int maxPathSum(TreeNode root) 
    {
        int max[] = new int[1];
        max[0] = Integer.MIN_VALUE;

        maxDepth(root , max);

        return max[0];
    }
}
