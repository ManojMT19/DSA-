import  java.util.*;

public class T_04_PostOrder
{
    public List<Integer> postorderTraversal(TreeNode root) 
    {
        List<Integer> ans = new ArrayList<>();
        postorder(root, ans);
        return ans;
            
    }

    public static void postorder(TreeNode node , List<Integer> ans)
    {
        if(node == null)return ;

        postorder(node.left, ans);
        postorder(node.right, ans);
        ans.add(node.data);
    } 

    public static void main(String[] args)
    {
        
    }
}
