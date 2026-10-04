import java.util.HashMap;

public class T_28_Construct_Tree_from_In_Post // Leetcode 106
{
    public TreeNode buildTree(int[] inorder, int[] postorder)
    {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++)
        {
            map.put(inorder[i], i);
        }

        TreeNode root = solve(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, map);

        return root;
    }

    public static TreeNode solve(int inorder[], int inStart, int inEnd, int postorder[], int postStart, int postEnd,
            HashMap<Integer, Integer> map)
    {
        if (inStart > inEnd || postStart > postEnd)
            return null;

        TreeNode root = new TreeNode(postorder[postEnd]);

        int inRoot = map.get(root.val);
        int numsLeft = inRoot - inStart;

        root.left = solve(inorder, inStart, inRoot - 1, postorder, postStart, postStart + numsLeft - 1, map);
        root.right = solve(inorder, inRoot + 1, inEnd, postorder, postStart + numsLeft, postEnd - 1, map);

        return root;
    }

    public static long maxAlternatingSum(int[] nums)
    {
        long maxx = Integer.MIN_VALUE;

        for (int i : nums)
        {
            if (i > maxx)
                maxx = i;
        }

        long temp = 0;
        for (int i = 0; i < nums.length; i++)
        {
            if (i % 2 == 0)
            {
                temp += nums[i];
            } else
            {
                temp -= nums[i];
            }
        }

        if (temp > maxx)
            maxx = temp;

        int j = 0;
        while (j < nums.length)
        {
            long ex = 0;
            for (int i = 0; i < nums.length; i++)
            {
                if(i == j)continue;

                if (i % 2 == 0)
                {
                    ex += nums[i];
                } else
                {
                    ex -= nums[i];
                }
            }
            j = j + 1;
            if(ex > maxx)maxx = ex;
        }
        return maxx;
    }
}
