
import java.util.*;

public class B_13_Recover_BST
{
    public static void inorder(TreeNode root, ArrayList<Integer> list)
    {
        if (root == null)
            return;

        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
    static int index = 0;
    public static void verify(TreeNode root, ArrayList<Integer> list)
    {
        if (root == null)
            return ;

        verify(root.left, list);

        root.val = list.get(index);
        index++;

        verify(root.right, list);

    }

    public void recoverTree_brute(TreeNode root)
    {
        ArrayList<Integer> list = new ArrayList<>();

        inorder(root, list);
        Collections.sort(list);

        verify(root, list);
    }

    private TreeNode first;
    private TreeNode middle;
    private TreeNode last;
    private TreeNode prev;
    public void inorder_optimal(TreeNode root)
    {
        if(root == null)return ;
        inorder_optimal(root.left);

        if(prev != null && root.val < prev.val)
        {
            if(first == null)
            {
                first = prev;
                middle = root;
            }
            else
            {
                last = root;
            }
        }

        prev = root;

        inorder_optimal(root.right);
    }
    
    public void recoverTree_optimal(TreeNode root)
    {
        first = middle = last = null;
        prev = new TreeNode(Integer.MIN_VALUE);

        inorder_optimal(root);

        if(first != null && last != null)
        {
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        }
        else if(first != null && middle != null)
        {
            int temp = first.val;
            first.val = middle.val;
            middle.val = temp;
        }
    }

}
