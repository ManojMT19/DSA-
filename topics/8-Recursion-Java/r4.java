public class r4
{
    static String remove_a_recur(String s, int i)
    {
        if (i == s.length())
            return "";

        char c = s.charAt(i);

        if (c != 'a')
        {
            return c + remove_a_recur(s, i + 1);
        }
        return remove_a_recur(s, i + 1);
    }

    static String remove_a_recur_Builder(String s, int i)
    {
        if (i == s.length())
            return "";

        char c = s.charAt(i);

        if (c != 'a')
        {
            StringBuilder sb = new StringBuilder();
            sb.append(c);
            sb.append(remove_a_recur(s, i + 1));
            return sb.toString();
        }
        return remove_a_recur(s, i + 1);
    }

    static void skip(String r, String source)
    {
        if (source.isEmpty())
        {
            System.out.println(r);
            return;
        }

        char c = source.charAt(0);
        if (c == 'a')
        {
            skip(r, source.substring(1));
        } else
        {
            skip(r + c, source.substring(1));
        }
    }

    static String remove_a_recur(String s)
    {
        if (s.length() == 0)
            return "";

        char c = s.charAt(0);
        if (c != 'a')
        {
            return c + remove_a_recur(s.substring(1));
        }
        return remove_a_recur(s.substring(1));
    }

    static String remove_apple(String s)
    {
        if (s.length() == 0)
            return "";

        if (s.startsWith("apple"))
        {
            return remove_apple(s.substring(5));
        }
        return s.charAt(0) + remove_apple(s.substring(1));
    }

    public static void main(String[] args)
    {
        // String s = "bbacdae";

        // System.out.println(remove_a(s));
        // System.out.println(remove_a_recur(s, 0));
        // System.out.println(remove_a_recur(s));

        skip("", "Banana");
        System.out.println(remove_apple("RCBappleCSK"));

    }
}
