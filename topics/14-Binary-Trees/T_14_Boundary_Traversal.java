import java.util.ArrayList;
import java.util.List;

class TreeNode
{
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode()
    {
    }

    TreeNode(int val)
    {
        this.data = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right)
    {
        this.data = val;
        this.left = left;
        this.right = right;
    }
}

public class T_14_Boundary_Traversal
{
    public static boolean isLeaf(TreeNode root)
    {
        if (root.left == null && root.right == null) 
        {
            return true;    
        }
        return false;
    }

    public static void addLeft(TreeNode root , ArrayList<Integer> res)
    {
        TreeNode cur = root.left;
        while(cur != null)
        {
            if(isLeaf(cur) == false)res.add(cur.data);
            if(cur.left != null)cur = cur.left;
            else cur = cur.right;
        }
    }

    public static void addRight(TreeNode root , ArrayList<Integer> res)
    {
        TreeNode cur = root.right;
        ArrayList<Integer>temp = new ArrayList<>();
        while(cur != null)
        {
            if(isLeaf(cur) == false)temp.add(cur.data);
            if(cur.right != null)cur = cur.right;
            else cur = cur.left;
        }
        for(int i = temp.size()-1 ; i >= 0 ; i--)
        {
            res.add(temp.get(i));
        }
    }

    public static void addLeaf(TreeNode root , ArrayList<Integer> res) 
    {
        if(isLeaf(root))
        {
            res.add(root.data);
            return ;
        }
        if (root.left != null) addLeaf(root.left, res);
        if (root.right != null) addLeaf(root.right, res);    
    }
    
    public static List<Integer> tree_boundary(TreeNode root) 
    {
        ArrayList<Integer> res = new ArrayList<>();

        if(root == null)return res;

        addLeft(root, res);
        addLeaf(root, res);
        addRight(root, res);    

        return res;
    }
}

