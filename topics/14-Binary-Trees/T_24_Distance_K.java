import java.util.*;

public class T_24_Distance_K // Leetcode 863
{
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

    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k)
    {
        Map<TreeNode, TreeNode> parent_map = new HashMap<>();
        marking_parent(root, parent_map);

        HashMap<TreeNode, Boolean> visited = new HashMap<>();

        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(target);
        visited.put(target, true);
        int curr_level = 0;

        while (!q.isEmpty())
        {
            int size = q.size();

            if (curr_level == k)
                break;

            curr_level++;

            for (int i = 0; i < size; i++)
            {
                TreeNode current = q.poll();

                // if (current.left != null && !visited.containsKey(current.left))  // this is also correct bcz we never insert with false condition then all existing nodes r true so checking existing also works 

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

                if (parent_map.get(current) != null && visited.get(parent_map.get(current)) == null)
                {
                    q.offer(parent_map.get(current));
                    visited.put(parent_map.get(current), true);
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        while (!q.isEmpty())
        {
            TreeNode current = q.poll();
            ans.add(current.data);
        }
        return ans;
    }

    // TC = O(n)
    // SC = O(n)
}
