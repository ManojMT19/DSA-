
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
                left_data = root.left.data;

            // if right child is not null then we store its
            // value.
            if (root.right != null)
                right_data = root.right.data;

            // if sum of stored data of left and right child
            // is equal to the current node data and
            // recursively for the left and right subtree,
            // parent data is equal to sum of child data
            // then we return true.

            if ((root.data == left_data + right_data) && checkChildrenSum(root.left) && checkChildrenSum(root.right))
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
            childSum += root.left.data;
        if (root.right != null)
            childSum += root.right.data;

        // 2. Push values down symmetrically
        if (childSum >= root.data)
        {
            root.data = childSum;
        } else
        {
            if (root.left != null)
                root.left.data = root.data;
            if (root.right != null)
                root.right.data = root.data; // Fixed: Removed the 'else'
        }

        // 3. Recurse
        changeTree(root.left);
        changeTree(root.right);

        // 4. Backtrack and update parent
        int total = 0;
        if (root.left != null)
            total += root.left.data;
        if (root.right != null)
            total += root.right.data;

        if (root.left != null || root.right != null)
        {
            root.data = total;
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