import java.util.Stack;

public class R_14_Sort_Stack
{
    public static void sort_stack(Stack<Integer> stack)
    {
        if(stack.isEmpty())return ;

        int top = stack.pop();
        sort_stack(stack);

        insert_stack(stack,top);
    }

    public static  void insert_stack(Stack<Integer> stack, int x)
    {
        if(stack.isEmpty() || x > stack.peek())
        {
            stack.push(x);
            return;
        }

        int top = stack.pop();
        insert_stack(stack, x);
        stack.push(top);
    }

    /*
    
    Time: O(n²) — sortStack is called n times; each call's insertSorted can take up to O(n) in the worst case (inserting into an already-sorted stack of size up to n) → O(n) × O(n) = O(n²).
    Space: O(n) for sortStack's recursion depth + O(n) for insertSorted's recursion depth at any given point = O(n) auxiliary (the call stack IS your extra space, no separate array used).

    */

    public static void main(String[] args)
    {
        Stack<Integer> st = new Stack<>();

        st.push(1);
        st.push(4);
        st.push(3);
        st.push(10);  
        st.push(2);

        System.out.println(st);
        sort_stack(st);
        System.out.println(st);
    }
}
