import java.util.ArrayList;
import java.util.List;

class TreeNode
{
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode()
    {
    }

    TreeNode(int val)
    {
        this.data = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right)
    {
        this.data = val;
        this.left = left;
        this.right = right;
    }
}

public class T_22_Lowest_Common_Ancester // Leetcode 236
{
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) // worst problem didnt understand
    {
        // if 1 n 2 both r ancesters of p n q we should select 2 bcz we should select
        // the lowest or deepest ancesters

        if (root == null)
            return root;

        if (root == p || root == q)
        {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null)
        {
            return right;
        } else if (right == null)
        {
            return left;
        } else
        {
            return root;
        }

    }

    // -------------------------------------------------------------------------------------------------------------------------

    public static boolean findPath(TreeNode root, TreeNode target, List<TreeNode> path)
    {
        if (root == null)
            return false;

        path.add(root);

        if (root == target)
            return true;

        if (root.left != null)
        {
            if (findPath(root.left, target, path))
                return true;

            path.remove(path.size() - 1); // backtracking
        }

        if (root.right != null)
        {
            if (findPath(root.right, target, path))
                return true;

            path.remove(path.size() - 1); // backtracking
        }

        return false;
    }

    public static TreeNode lowestCommonAncestor_brute(TreeNode root, TreeNode p, TreeNode q)
    {

        List<TreeNode> pathP = new ArrayList<>();
        List<TreeNode> pathQ = new ArrayList<>();

        findPath(root, p, pathP);
        findPath(root, q, pathQ);

        int i = 0;

        while (i < pathP.size() && i < pathQ.size() && pathP.get(i) == pathQ.get(i))
        {

            i++;
        }

        return pathP.get(i - 1);
    }
}
