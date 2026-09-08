import java.util.Stack;

public class R_15_Reverse_Stack
{
    public static void reverse_stack(Stack<Integer> stack)
    {
        if(stack.isEmpty())return ;

        int top = stack.pop();

        reverse_stack(stack);

        insert_at_bottom(stack, top);
    }

    public static void insert_at_bottom(Stack<Integer> stack, int x)
    {
        if(stack.isEmpty())
        {
            stack.push(x);
            return ;
        }

        int top = stack.pop();
        insert_at_bottom(stack, x);
        stack.push(top);
    }

    /*
    Time: O(n²) — reverseStack runs n times, and insertAtBottom can take O(n) each time (always digs to the bottom) → O(n²).
    Space: O(n) — recursion stack depth for both functions combined, no extra explicit array/stack used.
    */

    public static void main(String[] args)
    {
        Stack<Integer> st = new Stack<>();

        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);

        System.out.println(st);

        reverse_stack(st);

        System.out.println(st);
    }

}
