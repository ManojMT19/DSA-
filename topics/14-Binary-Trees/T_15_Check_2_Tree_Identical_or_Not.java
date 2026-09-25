import java.util.ArrayList;

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

public class T_15_Check_2_Tree_Identical_or_Not // Leetcode 100
{

    public static void inorder(TreeNode root, ArrayList<Integer> r)
    {
        if (root == null)
        {
            r.add(null);
            return;
        }

        inorder(root.left, r);
        r.add(root.val);
        inorder(root.right, r);
    }

    public static boolean isSameTree_1(TreeNode p, TreeNode q)
    {
        ArrayList<Integer> r1 = new ArrayList<>();
        ArrayList<Integer> r2 = new ArrayList<>();

        inorder(p, r1);
        inorder(q, r2);

        if (r1.size() != r2.size())
            return false;

        for (int i = 0; i < r1.size(); i++)
        {
            // if(r1.get(i) != r2.get(i))
            if (!java.util.Objects.equals(r1.get(i), r2.get(i)))
            {
                return false;
            }
        }
        return true;
    }

    public static boolean isSameTree_2(TreeNode p, TreeNode q)
    {
        if (p == null && q == null)
            return true;

        if (p == null || q == null)
            return false;

        return (p.val == q.val) && isSameTree_2(p.left, q.left) && isSameTree_2(p.right, q.right);
    }
}
