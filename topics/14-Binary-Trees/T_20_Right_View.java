import java.util.*;

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

public class T_20_Right_View
{
    public static void solve(TreeNode root , ArrayList<Integer> ans , int level)
    {
        if(root == null)return ;

        if(level == ans.size())
        {
            ans.add(root.data);
        }
        solve(root.right, ans, level+1);    // this is the only change between righht n left view in recursion
        solve(root.left, ans, level+1);
    }
    public static ArrayList<Integer> RightView_recursion(TreeNode root)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        
        solve(root, ans, 0);

        return ans;
    }
    public static ArrayList<Integer> RightView(TreeNode root)
    {
        if (root == null)
            return new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer>ans = new ArrayList<>();

        queue.add(root);

        while (!queue.isEmpty())
        {

            int size = queue.size();

            for (int i = 0; i < size; i++)
            {
                TreeNode node = queue.poll();

                if (i == size-1)
                {
                    ans.add(node.data);
                }

                if (node.left != null)
                {
                    queue.add(node.left);
                }

                if (node.right != null)
                {
                    queue.add(node.right);
                }
            }

        }
        return ans;
    }
}
