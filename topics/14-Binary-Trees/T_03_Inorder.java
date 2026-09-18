import  java.util.*;

class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val)
    {
        this.val = val;
    }
}

public class T_03_Inorder
{
    public List<Integer> InorderTraversal(TreeNode root) 
    {
        List<Integer> ans = new ArrayList<>();
        inorder(root, ans);
        return ans;
            
    }

    public static void inorder(TreeNode node , List<Integer> ans)
    {
        if(node == null)return ;

        inorder(node.left, ans);
        ans.add(node.val);
        inorder(node.right, ans);
    } 

    public static void main(String[] args)
    {
        
    }
}
