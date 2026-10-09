import java.util.ArrayList;

public class B_06_Kth_Smallest_No
{
    public static void inorder(TreeNode root , ArrayList<Integer> list)
    {
        if(root == null)return ;

        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
    public int kthSmallest(TreeNode root, int k)
    {
        ArrayList<Integer> list = new ArrayList<>();

        inorder(root, list); // inorder always gives in sorted manner     

        return list.get(k-1);
    }
}
