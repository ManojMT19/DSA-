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

public class T_09_Diameter_of_Tree // Leetcode 543
{
    static int maxx = Integer.MIN_VALUE;

    public static int maxDepth(TreeNode root)
    {
        if (root == null)
            return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        maxx = Math.max(maxx, left + right);

        return 1 + Math.max(left, right);
    }

    public static int diameterOfBinaryTree_Brute(TreeNode root)
    {
        maxx = 0;
        maxDepth(root);
        return maxx;
    }
    // TC = O(N)
    // SC = O(H)

    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(diameterOfBinaryTree_Brute(root));
    }
}
