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

public class T_02_Preorder
{
    public List<Integer> preorderTraversal(TreeNode root) 
    {
        List<Integer> ans = new ArrayList<>();
        preorder(root, ans);
        return ans;
            
    }

    public static void preorder(TreeNode node , List<Integer> ans) 
    {
        if(node == null)return ;

        ans.add(node.val);
        preorder(node.left, ans);
        preorder(node.right, ans);
    } 

    public static void main(String[] args)
    {
        
    }
}
