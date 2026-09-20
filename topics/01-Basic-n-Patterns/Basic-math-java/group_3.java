/* 
Group 3: GCD and LCM
GCD using Euclid's algorithm
LCM using the GCD
GCD of an array (LC 1979)

*/
public class group_3
{
    public static int gcd_brute(int a, int b)
    {
        long x = Math.abs((long) a);
        long y = Math.abs((long) b);

        if (x == 0)
            return (int) y;
        if (y == 0)
            return (int) x;

        for (long i = Math.min(x, y); i >= 1; i--)
        {
            if (x % i == 0 && y % i == 0)
                return (int) i;
        }
        return 1;
    }

    public static long euclids_gcd(long a, long b)
    {
        long x = Math.abs((long) a);
        long y = Math.abs((long) b);

        while (y != 0)
        {
            long temp = y;
            y = x % y;
            x = temp;
        }
        return x;
    }

    public static int euclids_gcd_recursion(int a, int b)
    {
        if (b == 0)
            return Math.abs(a);
        return euclids_gcd_recursion(b, a % b);
    }

    public static long lcmBrute(int a, int b)
    {
        if (a == 0 || b == 0)
            return 0;
        long x = Math.abs((long) a);
        long y = Math.abs((long) b);
        long big = Math.max(x, y);

        for (long m = big;; m += big)
        {
            if (m % x == 0 && m % y == 0)
                return m;
        }
    }

    public static long LCM_using_GCD(int a, int b)
    {
        if (a == 0 || b == 0)
            return 0;

        long x = Math.abs((long) a);
        long y = Math.abs((long) b);

        return (x / euclids_gcd(x, y)) * y;

        // lcm(a,b) = (a*b) / gcd(a,b)  -- this  is the formula to be remembered
    }

    public static int GCD_of_array(int num[])
    {
    /*
            result = 0
            x = 24 → gcd(0, 24)  = 24   → result = 24
            x = 36 → gcd(24, 36) = 12   → result = 12
            x = 60 → gcd(12, 60) = 12   → result = 12

            Answer: 12
    */

        long  result = 0;
        for(long n : num)
        {
            result = euclids_gcd(result , n);
            if(result == 1)break;
        }
        return (int)result;
    }


    public static void main(String[] args)
    {
        // System.out.println(euclids_gcd(48, 18));
        // System.out.println(euclids_gcd_recursion(48, 18));

        // System.out.println(LCM_using_GCD(0, 0));

        System.out.println(GCD_of_array(new int[]{24,36,60}));
    }
}
