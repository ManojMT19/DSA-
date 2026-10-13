import java.util.Stack;

public class B_11_BST_Iterator // Leetcode 173
{
    class BSTIterator
    {
        Stack<TreeNode> st = new Stack<>();

        public BSTIterator(TreeNode root)
        {
            pushAllLeft(root);
            // TC = O(h)
        }

        public int next()
        {
            TreeNode node = st.pop();

            pushAllLeft(node.right);

            return node.val;
            // TC = O(h)
        }

        public boolean hasNext()
        {
            return !st.isEmpty();
            // TC = O(1)
        }

        public void pushAllLeft(TreeNode root)
        {
            while (root != null)
            {
                st.push(root);
                root = root.left;
            }
        }
    }
}
