import java.util.*;

public class SQ11_Remove_Key
{
    public static String removeKdigits_brute(String num, int k)
    {
        if (k >= num.length())
            return "0";

        int count = 0;
        StringBuilder sb = new StringBuilder(num);

        int i = 0;
        while (i < sb.length() - 1 && count < k)
        {
            if (sb.charAt(i) > sb.charAt(i + 1))
            {
                sb.deleteCharAt(i);
                count++;

                i = Math.max(0, i - 1); // Very Important to check again after deleting that current element
            } else
            {
                // Only move forward if no deletion happened
                i++;
            }
        }

        // FIX 2: If count < k (e.g., "1234" where digits keep increasing),
        // delete remaining digits from the very end.
        while (count < k)
        {
            sb.deleteCharAt(sb.length() - 1);
            count++;
        }

        while (sb.length() > 1 && sb.charAt(0) == '0') // Strip out any leading zeros (e.g., "0200" -> "200")
        {
            sb.deleteCharAt(0);
        }

        return sb.toString();

        // TC = O(N sq)
        // SC = O(N)
    }

    public static String removeKdigits_Optimal(String num, int k)
    {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < num.length(); i++)
        {
            char curr = num.charAt(i);

            while (!st.isEmpty() && k > 0 && st.peek() > curr)
            {
                st.pop();
                k--;
            }

            st.push(curr);
        }

        while (k > 0)
        {
            st.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();

        for (char ch : st) // no need to reverse bcz it will append from bottom to top
        {
            sb.append(ch);
        }

        // Remove leading zeros
        while (sb.length() > 1 && sb.charAt(0) == '0')
        {
            sb.deleteCharAt(0);
        }

        return sb.length() == 0 ? "0" : sb.toString();
        // TC = O(n²)
        // SC = O(n)
    }

    public static void main(String[] args)
    {
        String num = "1432219";

        String res = removeKdigits_Optimal(num, 3);

        System.out.println(res);
    }
}
