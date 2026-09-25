import java.util.*;

public class sumne
{
    public static int sumAndMultiply(String sub)
    {
        long x = 0;
        long sum = 0;
        long place = 1;
        final int MOD = 1_000_000_007;

        for (int i = sub.length() - 1; i >= 0; i--)
        {
            int digit = sub.charAt(i) - '0';

            if (digit != 0)
            {
                x = (x + digit * place) % MOD;
                place = (place * 10) % MOD;
                sum = (sum + digit) % MOD;
            }
        }

        return (int) ((x * sum) % MOD);
    }

    public static int[] sumAndMultiply_II(String s, int[][] queries)
    {
        int ans[] = new int[queries.length];
        for (int i = 0; i < queries.length; i++)
        {
            int l = queries[i][0];
            int r = queries[i][1];

            String sub = s.substring(l, r + 1);
            ans[i] = sumAndMultiply(sub);
        }

        return ans;
    }

    public static void main(String[] args)
    {
        // String num = "1432219";
        String num = "10203004";
        int queries[][] = { { 0, 7 }, { 1, 3 }, { 4, 6 } };

        int r[] = sumAndMultiply_II(num, queries);

        for (int i : r)
        {
            System.out.println(i);
        }

    }
}
