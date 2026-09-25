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

public class T_21_Print_Root_to_Leaf_Path
{

    // Hint 1 : Start from the root node and traverse the tree recursively. Maintain
    // a current path list that stores nodes visited so far.

    // Hint 2 : When reaching a leaf node, store the current path in the result
    // list. Use backtracking to remove the last node when returning from recursion.

    public static void solve(TreeNode root, List<List<Integer>> result, List<Integer> current)
    {
        if (root == null)
            return;

        current.add(root.data);

        if (root.left == null && root.right == null)
        {
            result.add(new ArrayList<>(current));
            return;
        }

        if (root.left != null)
        {
            solve(root.left, result, current);
            current.remove(current.size() - 1);     // backtracking
        }

        if (root.right != null)
        {
            solve(root.right, result, current);
            current.remove(current.size() - 1);     // backtracking
        }
    }

    public List<List<Integer>> allRootToLeaf(TreeNode root)
    {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        if (root == null)
            return result;

        solve(root, result, current);

        return result;
    }

    /*
     * 
     * Leetcode 257 = here we r not removing anything bcz string creates a new
     * string everytime
     * 
     * 
     * public static void solve(TreeNode root, List<String> ans, String path) {
     * if(root == null) return;
     * 
     * path += root.val;
     * 
     * // Leaf node if(root.left == null && root.right == null) { ans.add(path);
     * return; }
     * 
     * path += "->";
     * 
     * solve(root.left, ans, path); solve(root.right, ans, path); }
     * 
     * public List<String> binaryTreePaths(TreeNode root) { List<String> ans = new
     * ArrayList<>();
     * 
     * solve(root, ans, "");
     * 
     * return ans; }
     * 
     */
}
