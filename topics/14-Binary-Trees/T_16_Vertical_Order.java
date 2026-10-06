import java.util.*;

public class T_16_Vertical_Order // Leetcode 987
{
    static class Pair
    {
        TreeNode node;
        int column;
        int row;

        Pair(TreeNode node, int column, int row)
        {
            this.node = node;
            this.column = column;
            this.row = row;
        }
    }

    public static List<List<Integer>> verticalTraversal(TreeNode root)
    {

        List<List<Integer>> ans = new ArrayList<>();

        if (root == null)
            return ans;

        TreeMap<Integer, TreeMap<Integer, List<TreeNode>>> map = new TreeMap<>();

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0, 0));

        while (!q.isEmpty())
        {

            Pair curr = q.poll();

            TreeNode node = curr.node;
            int column = curr.column;
            int row = curr.row;

            map.putIfAbsent(column, new TreeMap<>());
            map.get(column).putIfAbsent(row, new ArrayList<>());

            map.get(column).get(row).add(node);

            if (node.left != null)
            {
                q.offer(new Pair(node.left, column - 1, row + 1));
            }

            if (node.right != null)
            {
                q.offer(new Pair(node.right, column + 1, row + 1));
            }
        }

        for (TreeMap<Integer, List<TreeNode>> rows : map.values())
        {

            List<Integer> verticalColumn = new ArrayList<>();

            for (List<TreeNode> samePositionNodes : rows.values())
            {
                Collections.sort(samePositionNodes, (a, b) -> Integer.compare(a.val, b.val)); // very important , this will sort only when both row n coln r same

                for (TreeNode node : samePositionNodes)
                {
                    verticalColumn.add(node.val);
                }
            }

            ans.add(verticalColumn);
        }

        return ans;
    }
}