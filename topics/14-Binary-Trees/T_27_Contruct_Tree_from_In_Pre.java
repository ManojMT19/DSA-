import java.util.*;

public class T_27_Contruct_Tree_from_In_Pre // Leetcode 105
{
    public TreeNode buildTree(int[] preorder, int[] inorder)
    {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++)
        {
            map.put(inorder[i], i);
        }

        TreeNode root = solve(inorder, 0, inorder.length - 1, preorder, 0, preorder.length - 1, map);

        return root;
    }

    public static  TreeNode solve(int inorder[], int inStart, int inEnd, int preorder[], int preStart, int preEnd, HashMap<Integer, Integer> map)
    {
        if (inStart > inEnd || preStart > preEnd)
            return null;

        TreeNode root = new TreeNode(preorder[preStart]);

        int inRoot = map.get(root.val);
        int numsLeft = inRoot - inStart;

        root.left = solve(inorder, inStart, inRoot - 1, preorder, preStart + 1, preStart + numsLeft, map);
        root.right = solve(inorder, inRoot + 1, inEnd, preorder, preStart + numsLeft + 1, preEnd, map);

        return root;
    }
}
