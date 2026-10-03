
public class T_12_Children_Sum_Property
{
    public static boolean checkChildrenSum(TreeNode root)
    {
        int left_data = 0, right_data = 0;

        // if node is null or both child nodes are null, we
        // return true.
        if (root == null || (root.left == null && root.right == null))
            return true;

        else
        {

            // if left child is not null then we store its
            // value.
            if (root.left != null)
                left_data = root.left.val;

            // if right child is not null then we store its
            // value.
            if (root.right != null)
                right_data = root.right.val;

            // if sum of stored val of left and right child
            // is equal to the current node val and
            // recursively for the left and right subtree,
            // parent val is equal to sum of child val
            // then we return true.

            if ((root.val == left_data + right_data) && checkChildrenSum(root.left) && checkChildrenSum(root.right))
                return true;

            // else we return false.
            else
                return false;
        }
    }

    public static void changeTree(TreeNode root)
    {
        if (root == null)
            return;

        // 1. Calculate current children sum
        int childSum = 0;
        if (root.left != null)
            childSum += root.left.val;
        if (root.right != null)
            childSum += root.right.val;

        // 2. Push values down symmetrically
        if (childSum >= root.val)
        {
            root.val = childSum;
        } else
        {
            if (root.left != null)
                root.left.val = root.val;
            if (root.right != null)
                root.right.val = root.val; // Fixed: Removed the 'else'
        }

        // 3. Recurse
        changeTree(root.left);
        changeTree(root.right);

        // 4. Backtrack and update parent
        int total = 0;
        if (root.left != null)
            total += root.left.val;
        if (root.right != null)
            total += root.right.val;

        if (root.left != null || root.right != null)
        {
            root.val = total;
        }
    }

    public static void main(String[] args)
    {

        /*
            35 
           / \ 
           20 15 
          / \ / \ 
         15 5 10 5

        */

        TreeNode root = new TreeNode(35);
        root.left = new TreeNode(20);
        root.right = new TreeNode(15);

        root.left.left = new TreeNode(15);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);

        if (checkChildrenSum(root))
            System.out.print("true");
        else
            System.out.print("false");
    }
}