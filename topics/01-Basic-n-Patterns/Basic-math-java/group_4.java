/*

Group 4: Powers, modulo and factorials
Power x^n in O(log n), including negative n (LC 50)
Power of two, three and four (LC 231, 326, 342)
Factorial, and trailing zeros in a factorial (LC 172)
Modular exponentiation, a^b % m


*/

public class group_4
{
    public static double myPow(double x, int n) // Leetcode 50
    {
        long exp = n;
        if (exp < 0)
        {
            x = 1 / x;
            exp = -exp;
        }

        double base = x;
        double result = 1;

        while (exp > 0)
        {
            if (exp % 2 == 1)
                result *= base;

            base *= base;
            exp /= 2;
        }
        return result;
    }

    public static boolean power(int base, int n)
    {
        // base ^ n
        // if base = 2 , n = 3
        // 2^3

        if (n <= 0)
            return false;

        while (n % base == 0)
        {
            n = n / base;
        }
        return n == 1;
    }

    public static boolean isPowerOf_number(int n)
    {
        return power(2, n);
        /*
         * 16 % 2 = 0 → 16 / 2 = 8 8 % 2 = 0 → 8 / 2 = 4 4 % 2 = 0 → 4 / 2 = 2 2 % 2 = 0
         * → 2 / 2 = 1 1 % 2 = 1 → can't divide, stop
         * 
         * Ended at 1 → YES
         */
    }

    public static long factorial(int n)
    {
        long result = 1;
        for (int i = 2; i <= n; i++)
        {
            result *= i;
        }
        return result;
    }

    public static int trailingZeroes(int n) // Leetcode 172 -- very important
    {
        /*
         * LeetCode 172 — Factorial Trailing Zeroes
         * 
         * Core idea: Don't calculate n!.
         * 
         * A trailing 0 comes from 10 = 2 × 5. In n!, factors of 2 are much more than
         * factors of 5. Therefore, count the number of factors of 5. Multiples of 25 =
         * 5² contribute an extra 5. Multiples of 125 = 5³ contribute another extra 5,
         * and so on. Formula Answer = n/5 + n/25 + n/125 + n/625 + ...
         * 
         * Stop when n / power_of_5 = 0.
         * 
         */

        int count = 0;
        while (n >= 5)
        {
            n = n / 5;
            count += n;
        }
        return count;
    }

    public static long modPow(long a, long b, long m)
    {
        long result = 1 % m; // if m is 1, everything is 0
        a = ((a % m) + m) % m; // make a fit inside 0..m-1, even if negative
    /*
        The problem: in Java, % can return a negative result.

        7 % 5  =  2
        -2 % 7  = -2     ← not 5, as you might expect

        For modular arithmetic, we want the answer to always be between 0 and m - 1. In that world -2 and 5 are the same value when m = 7, because they differ by exactly 7.

        Walk through the line with a = -2, m = 7:

        a % m        = -2 % 7  = -2     (still negative)
        + m          = -2 + 7  = 5      (now positive)
        % m          = 5 % 7   = 5      (already in range, stays 5)

        So -2 becomes 5.

    */

        while (b > 0)
        {
            if (b % 2 == 1)
                result = (result * a) % m;
            a = (a * a) % m;
            b /= 2;
        }
        return result;
    }

    public static void main(String[] args)
    {
        // System.out.println(myPow(2, 10));

        System.out.println(isPowerOf_number(12));
        System.out.println(isPowerOf_number(16));
    }
}
