import java.util.Stack;

class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode()
    {
    }

    TreeNode(int val)
    {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right)
    {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class T_26_Flatten_Binary_Tree  // leetcode 114
{
    TreeNode prev = null;
    public void flatten_1(TreeNode root)
    {
        if(root == null)return ;

        flatten_1(root.right); // this is most important we r going into right first , reverse postorder 
        flatten_1(root.left);

        root.right = prev;
        root.left = null;

        prev = root;
    }

    public void flatten_2(TreeNode root)
    {
        Stack<TreeNode> st = new Stack<>();

        st.push(root);

        while (!st.isEmpty()) 
        {
            TreeNode curr = st.pop();
            
            if(curr.right != null)
            {
                st.push(curr.right);
            }

            if (curr.left != null) 
            {
                st.push(curr.left);    
            }

            if(!st.isEmpty())
                curr.right = st.peek();

            curr.left = null;
        }
    }

    
    public void flatten_3(TreeNode root)
    {
        TreeNode curr = root ;
        
        while (curr != null) 
        {
            if(curr.left != null)
            {
                TreeNode prev = curr.left;

                while (prev.right != null) 
                {
                    prev = prev.right;    
                }
                prev.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }
}
