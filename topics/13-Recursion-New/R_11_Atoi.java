public class R_11_Atoi // Leetcode 8
{
    public static int myAtoi_1(String s)
    {
        int n = s.length();
        int i = 0;
        int sign = 1;
        int ans = 0;

        while (i < n && s.charAt(i) == ' ')
        {
            i++;
        }

        if (i < n && s.charAt(i) == '+')
        {
            i++;
        } else if (i < n && s.charAt(i) == '-')
        {
            i++;
            sign = -1;
        }

        while (i < n && s.charAt(i) >= '0' && s.charAt(i) <= '9')
        {
            int digit = (s.charAt(i) - '0');

            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && digit > 7)) // this is more important 
            {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            ans = ans * 10 + digit;
            i++;
        }

        return sign * ans;
    }

    public static void main(String[] args)
    {
        String s = "  -4vb   2u";
        System.out.println(myAtoi_1(s));
    }
}
