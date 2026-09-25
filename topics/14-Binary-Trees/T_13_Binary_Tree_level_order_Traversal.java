import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class T_13_Binary_Tree_level_order_Traversal
{
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) 
    {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> ans = new LinkedList<List<Integer>>();

        if (root == null)
            return ans;
        queue.offer(root); 
        int index = 0;

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

                sublist.add(queue.poll().val);
            }
            if(index % 2 == 0)
            {
                ans.add(sublist);
            }
            else
            {
            ans.add(sublist.reversed());
            }
        }

        return ans;
    }    
    

}
