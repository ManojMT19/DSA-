import java.util.ArrayList;
import java.util.List;

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

public class T_11_Symmetric // Leetcode 101
{
    public static void preorder(TreeNode root, List<Integer> ans)
    {
        if (root == null)
        {
            ans.add(null);
            return;
        }

        ans.add(root.val);
        preorder(root.left, ans);
        preorder(root.right, ans);
    }

    public static void preorder_reverse(TreeNode root, List<Integer> ans)
    {
        if (root == null)
        {
            ans.add(null);
            return;
        }

        ans.add(root.val);
        preorder_reverse(root.right, ans);
        preorder_reverse(root.left, ans);
    }

    public static boolean isSymmetric(TreeNode root)
    {
        List<Integer> ans1 = new ArrayList<>();
        List<Integer> ans2 = new ArrayList<>();

        preorder(root, ans1);
        preorder_reverse(root, ans2);

        if (ans1.size() != ans2.size())
            return false;

        for (int i = 0; i < ans1.size(); i++)
        {
            if (ans1.get(i) != ans2.get(i))
            {
                return false;
            }
        }
        return true;
    }

}