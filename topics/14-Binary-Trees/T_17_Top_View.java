import java.util.*;


class Pair
{
    TreeNode node;
    int hd;

    Pair(TreeNode node, int hd)
    {
        this.node = node;
        this.hd = hd;
    }
}

public class T_17_Top_View
{
    public static ArrayList<Integer> topView(TreeNode root)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;

        Queue<Pair> queue = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        queue.add(new Pair(root, 0));

        while (!queue.isEmpty())
        {
            Pair current = queue.poll();

            TreeNode node = current.node;
            int hd = current.hd;

            if (!map.containsKey(hd))
            {
                map.put(hd, node.val);
            }

            if (node.left != null)
            {
                queue.add(new Pair(node.left, hd - 1));
            }

            if (node.right != null)
            {
                queue.add(new Pair(node.right, hd + 1));
            }
        }

        ArrayList<Integer> keys = new ArrayList<>(map.keySet());

        Collections.sort(keys); // we cna use TreeMap also just to avoid this sorting part 

        for (int key : keys)
        {
            ans.add(map.get(key));
        }
        return ans;

        // TC = O(n log n)
        // SC = O(n)

    }
}
