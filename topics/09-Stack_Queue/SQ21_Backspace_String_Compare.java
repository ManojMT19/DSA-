public class SQ21_Backspace_String_Compare
{
    public static boolean backspaceCompare(String s, String t)
    {
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();

        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            int len = s1.length();

            if (c == '#')
            {
                s1.deleteCharAt(len - 1);
            } else
            {
                s1.append(c);
            }
        }
        for (int j = 0; j < t.length(); j++)
        {
            char c = t.charAt(j);
            int len = s2.length();

            if (c == '#')
            {
                if (s2.length() > 0)
                {
                    s2.deleteCharAt(len - 1);
                }
            } else
            {
                s2.append(c);
            }
        }

        return s1.toString().equals(s2.toString());
    }

    public static void main(String[] args)
    {
        String s = "ab##";
        String t = "c#d#";

        System.out.println(backspaceCompare(s, t));
    }
}