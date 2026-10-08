public class B_03_Floor_in_BST
{
    public int floor(TreeNode root, int val)
    {
        int floor = -1;

        while (root != null)
        {
            if(val == root.val)
            {
                floor = root.val;
                return floor;
            }
            if(val > root.val)
            {
                floor = root.val;
                root = root.right;
            }
            else
            {
                root = root.left;
            }
        }
        return floor;
    }
}
