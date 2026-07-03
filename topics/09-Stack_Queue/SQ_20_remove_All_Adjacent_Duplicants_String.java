import java.util.Stack;

public class SQ_20_remove_All_Adjacent_Duplicants_String
{
    public static String removeDuplicates(String s)
    {
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray())
        {
            int len = sb.length();

            if (len > 0 && sb.charAt(len - 1) == c)
            {
                sb.deleteCharAt(len - 1);
            } else
            {
                sb.append(c); 
            }
        }

        return sb.toString();
    }

    public static String removeDuplicates_stack(String s)
    {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);

            if (!st.isEmpty() && st.peek() == c)
            {
                st.pop();
            } else
            {
                st.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();

        for (char c : st)
        {
            sb.append(c);
        }

        return sb.toString();
    }

    public static void main(String[] args)
    {
        String s = "abbaca";

        System.out.println(removeDuplicates(s));
    }
}
