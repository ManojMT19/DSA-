public class B_08_LCA_in_BST
{
    public TreeNode lowestCommonAncestor_BT(TreeNode root, TreeNode p, TreeNode q)
    {
        // if 1 n 2 both r ancesters of p n q we should select 2 bcz we should select
        // the lowest or deepest ancesters

        if (root == null)
            return root;

        if (root == p || root == q)
        {
            return root;
        }

        TreeNode left = lowestCommonAncestor_BT(root.left, p, q);
        TreeNode right = lowestCommonAncestor_BT(root.right, p, q);

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

        // Time Complexity: O(n)
        // Space Complexity: (O(h), where h is the height of the tree.
    }

    public TreeNode lowestCommonAncestor_BST(TreeNode root, TreeNode p, TreeNode q)
    {
        if (root == null)
            return null;

        if (root == p || root == q)
        {
            return root;
        }

        if (p.val < root.val && q.val < root.val)
        {
            return lowestCommonAncestor_BST(root.left, p, q);
        } 
        if (p.val > root.val && q.val > root.val)
        {
            return lowestCommonAncestor_BST(root.right, p, q);
        }
        return root;

        // TC = O(h)
        // SC = O(h)
    }

    public TreeNode lowestCommonAncestor_BST_Better(TreeNode root, TreeNode p, TreeNode q)
    {
        while (root != null)
        {
            if (p.val < root.val && q.val < root.val)
            {
                root = root.left;
            } else if (p.val > root.val && q.val > root.val)
            {
                root = root.right;
            } else
            {
                return root;
            }
        }
        return null;

        // TC = O(h)
        // SC = O(1)
    }
}
