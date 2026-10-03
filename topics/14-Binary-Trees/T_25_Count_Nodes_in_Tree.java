public class T_25_Count_Nodes_in_Tree
{
    static int count = 0;
    public static void solve(TreeNode root) 
    {
        if(root == null)return;

        count++;
        solve(root.left);
        solve(root.right);
    }

    public static int countNodes_1(TreeNode root)
    {
        solve(root);
        return count;
    }
    
    public static int countNodes(TreeNode root)
    {
        if(root == null)return 0;

        int lh = leftHeight(root);
        int rh = rightHeight(root);

        if(lh == rh)
        {
            // ( x << n ) means x × 2ⁿ.
            return (1 << lh) - 1;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    //  to find the no of nodes in perfect tree of height h : 2^h - 1
    //  so here also we r using the same technique if it is a perfect tree we use that formula if not perfect tree

    public static int leftHeight(TreeNode root)
    {
        int height = 0;

        while(root != null)
        {
            height++;
            root = root.left;
        }
        return height;
    }

    public static int rightHeight(TreeNode root)
    {
        int height = 0;

        while(root != null)
        {
            height++;
            root = root.right;
        }
        return height;
    }
    
}
