public class B_09_Construct_BST_from_Preorder
{
    public static void solve_brute(int preorder[], int index, TreeNode root)
    {
        if (index == preorder.length)
        {
            return;
        }

        TreeNode curr = root;
        int val = preorder[index];

        while (true)
        {
            if (val < curr.val)
            {
                if (curr.left == null)
                {
                    curr.left = new TreeNode(val);
                    break;
                }
                curr = curr.left;
            } else
            {
                if (curr.right == null)
                {
                    curr.right = new TreeNode(val);
                    break;
                }
                curr = curr.right;
            }
        }

        solve_brute(preorder, index + 1, root);
    }

    public TreeNode bstFromPreorder_brute(int[] preorder)
    {
        if (preorder.length == 0)
        {
            return null;
        }

        TreeNode root = new TreeNode(preorder[0]);

        solve_brute(preorder, 1, root);

        return root;

        // TC = O(n sq) worst case because each element may traverse the existing tree before insertion
        // SC = O(n)
    }

    
    public TreeNode bstFromPreorder_better(int[] preorder)
    {
        /*
            if we sort the preorder we get the inorder 

            from inorder n preorder we can construct a BST like we did in BT
        
        */

        return new TreeNode();
    }


    public static TreeNode solve_optimal(int preorder[] , int bound , int i[])
    {
        if(i[0] >= preorder.length || preorder[i[0]] > bound)
        {
            return null;
        }

        TreeNode root = new TreeNode(preorder[i[0]++]);

        root.left = solve_optimal(preorder, root.val, i);
        root.right = solve_optimal(preorder, bound, i);

        return root;
    }
    public TreeNode bstFromPreorder_optimal(int[] preorder)
    {
        // this is similar to validate BST using range --> lowerbound n upperbound but here we r only using upperbound

        return solve_optimal(preorder, Integer.MAX_VALUE, new int[]{0});
    }
}
