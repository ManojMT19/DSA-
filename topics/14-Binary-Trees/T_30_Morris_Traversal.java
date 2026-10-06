import java.util.ArrayList;

public class T_30_Morris_Traversal
{
    /*
    
    prev.right == null
            ↓
    First time
    Create temporary link → go LEFT

    prev.right == current
            ↓
    Second time
    Remove temporary link → process current → go RIGHT

    */
    
    public ArrayList<Integer> Morris_Inorder(TreeNode root)
    {
        ArrayList<Integer> inorder = new ArrayList<>();
        TreeNode current = root;

        while (current != null)
        {
            if (current.left == null)
            {
                inorder.add(current.val);
                current = current.right;
            } 
            else
            {
                TreeNode prev = current.left;
                while (prev.right != null && prev.right != current)  // very important
                {
                    prev = prev.right;
                }

                if (prev.right == null)
                {
                    prev.right = current;
                    current = current.left;
                } 
                else // very very important
                {
                    prev.right = null;
                    inorder.add(current.val);
                    current = current.right;
                }
            }
        }
        return inorder;

        // TC = O(N)
        // SC = O(1)
    }
    public ArrayList<Integer> Morris_Preorder(TreeNode root)
    {
        ArrayList<Integer> inorder = new ArrayList<>();
        TreeNode current = root;

        while (current != null)
        {
            if (current.left == null)
            {
                inorder.add(current.val);
                current = current.right;
            } 
            else
            {
                TreeNode prev = current.left;
                while (prev.right != null && prev.right != current)
                {
                    prev = prev.right;
                }
                if (prev.right == null)
                {
                    prev.right = current;
                    inorder.add(current.val);
                    current = current.left;
                } 
                else
                {
                    prev.right = null;
                    current = current.right;
                }
            }
        }
        return inorder;

        // TC = O(N)
        // SC = O(1)
    }
}
