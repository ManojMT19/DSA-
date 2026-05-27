import java.util.Stack;

public class SQ02_Valid_Parenthesis
{
    public static boolean isValid(String s)
    {
        char[] ss = s.toCharArray();

        Stack<Character> st = new Stack<>();
        int n = ss.length;
        int count = 0;

        for (char c : ss)
        {
            if (c == '(' || c == '[' || c == '{')
            {
                st.push(c);
            } 
            else
            {
                if (st.isEmpty())
                    return false;

                if (c == ')' && st.peek() != '(')
                {
                    return false;
                } else if (c == ']' && st.peek() != '[')
                {
                    return false;
                } else if (c == '}' && st.peek() != '{')
                {
                    return false;
                }

                st.pop();
            }
        }
        return st.isEmpty();
    }

    public static void main(String[] args)
    {
        String s = "([])";

        boolean r = isValid(s);
        System.out.println(r);
    }

}
