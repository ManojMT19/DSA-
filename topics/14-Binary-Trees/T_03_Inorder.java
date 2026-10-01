import  java.util.*;

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
        ans.add(node.data);
        inorder(node.right, ans);
    } 

    public static void main(String[] args)
    {
        
    }
}
