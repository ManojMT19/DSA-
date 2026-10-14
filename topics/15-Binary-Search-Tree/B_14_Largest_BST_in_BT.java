public class B_14_Largest_BST_in_BT
{

    public boolean isBST(TreeNode root, long min, long max)
    {
        if (root == null)
            return true;

        if (root.val <= min || root.val >= max)
            return false;

        return isBST(root.left, min, root.val) && isBST(root.right, root.val, max);
    }

    public int countNodes(TreeNode root)
    {
        if (root == null)
            return 0;

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public void find(TreeNode root, int[] maxSize)
    {
        if (root == null)
            return;

        if (isBST(root, Long.MIN_VALUE, Long.MAX_VALUE))
        {
            maxSize[0] = Math.max(maxSize[0], countNodes(root));
        }

        find(root.left, maxSize);
        find(root.right, maxSize);
    }

    public int largestBSTSubtree(TreeNode root)
    {
        int[] maxSize = { 0 };

        find(root, maxSize);

        return maxSize[0];
    }
}
