import java.util.*;

public class T_05_Level_Order // leetcode 102
{
    public List<List<Integer>> levelOrder(TreeNode root)
    {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> ans = new LinkedList<List<Integer>>();

        if (root == null)
            return ans;
        queue.offer(root); 

        while (!queue.isEmpty())
        {
            int size = queue.size();
            List<Integer> sublist = new LinkedList<Integer>();
            for (int i = 0; i < size; i++)
            {
                if (queue.peek().left != null)
                    queue.offer(queue.peek().left);
                if (queue.peek().right != null)
                    queue.offer(queue.peek().right);

                sublist.add(queue.poll().data);
            }
            ans.add(sublist);
        }

        return ans;
    }
}
