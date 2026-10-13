import java.util.ArrayList;

public class B_12_Two_Sum_in_BST // leetcode 653
{
    public static void inorder(TreeNode root , int l , ArrayList<Integer> list)
    {
        if(root == null)return ;

        inorder(root.left, l, list);
        list.add(root.val);
        inorder(root.right, l, list);
    }

    public boolean findTarget(TreeNode root, int k) 
    {
        ArrayList<Integer> list = new ArrayList<>();
        inorder(root, k, list);
        int i = 0;
        int j = list.size()-1;
        while (i < j) 
        {
            int temp = list.get(i) + list.get(j);
            if(temp == k)return true;

            if(temp < k)i++;
            else j--;
        }
        
        return false;
    }
}
