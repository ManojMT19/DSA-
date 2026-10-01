import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class T_24_Min_Time_Burn_BT  // Leetcode 2385
{
    public static TreeNode findStart(TreeNode root, int start)
    {
        if (root == null)
            return null;

        if (root.val == start)
            return root;

        TreeNode left = findStart(root.left, start);

        if (left != null)
            return left;

        TreeNode right = findStart(root.right, start);

        return right;
    }

    public static void marking_parent(TreeNode root, Map<TreeNode, TreeNode> parent_map)
    {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);

        while (!q.isEmpty())
        {
            int size = q.size();

            for (int i = 0; i < size; i++)
            {
                TreeNode current = q.poll();
                if (current.left != null)
                {
                    parent_map.put(current.left, current);
                    q.offer(current.left);
                }

                if (current.right != null)
                {
                    parent_map.put(current.right, current);
                    q.offer(current.right);
                }
            }
        }
    }

    public static int min_time_to_Burn(TreeNode root, TreeNode starting_node)
    {
        int min = 0;

        Map<TreeNode, TreeNode> parents = new HashMap<>();
        marking_parent(root, parents);

        HashMap<TreeNode, Boolean> visited = new HashMap<>();

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(starting_node);
        visited.put(starting_node, true);

        while (!q.isEmpty())
        {
            int size = q.size();

            for (int i = 0; i < size; i++)
            {
                TreeNode current = q.poll();

                if (current.left != null && visited.get(current.left) == null)
                {
                    visited.put(current.left, true);
                    q.offer(current.left);
                }

                if (current.right != null && visited.get(current.right) == null)
                {
                    visited.put(current.right, true);
                    q.offer(current.right);
                }

                if (parents.get(current) != null && visited.get(parents.get(current)) == null)
                {
                    visited.put(parents.get(current), true);
                    q.offer(parents.get(current));
                }
            }

            if(!q.isEmpty())
            {
                min++;
            }
        }

        return min;
    }

    public static int amountOfTime(TreeNode root, int start) 
    {
        TreeNode starting_node = findStart(root, start);

        int ans = min_time_to_Burn(root, starting_node);

        return ans;
    }
}
