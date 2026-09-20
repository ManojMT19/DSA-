/*
Group 1: Digit extraction

Count digits (try 0 and negatives)
Sum of digits
Reverse a number, including trailing zeros like 1200 (LC 7, watch overflow)
Palindrome number (LC 9)
Armstrong number (153, 9474; use a loop, not Math.pow)

*/

public class group_1
{
    public static int count(int num)
    {
        if (num == 0)
            return 1;

        long n = Math.abs((long) num);
        int count = 0;

        while (n > 0)
        {
            count++;
            n = n / 10;
        }
        return count;

        // Time: O(d), where d is the number of digits, which equals O(log₁₀ n). The
        // loop runs once per digit.
        // Space: O(1), since only two variables are used.
    }

    public static int sum_of_digits(int num)
    {
        long n = Math.abs((long) num);

        int sum = 0;
        while (n > 0)
        {
            long l = n % 10;
            sum += l;
            n = n / 10;
        }
        return sum;

        // Time: O(d), where d is the number of digits, i.e. O(log₁₀ n).
        // Space: O(1).
    }

    public static int reverse_num(int n)
    {
        long r = 0;
        int sign = 1;
        if (n < 0)
        {
            sign = -1;
            n = n * (-1);
        }

        while (n > 0)
        {
            long temp = n % 10;
            r = (r * 10) + temp;
            n = n / 10;

            if (r > Integer.MAX_VALUE)
                return 0;
        }
        return (int) (r * sign);

        // Time: O(d), where d is the number of digits, i.e. O(log₁₀ n).
        // Space: O(1).
    }

    public static boolean palindrome(int n)
    {
        if (n < 0)
            return false;

        long o = n;
        // long r = (long)reverse_num(n);
        long r = 0;

        while (n > 0)
        {
            long temp = n % 10;
            r = (r * 10) + temp;
            n = n / 10;
        }

        return o == r;

        // Time: O(d), where d is the number of digits, i.e. O(log₁₀ n).
        // Space: O(1).
    }

    public static boolean armstrong(int n)
    {
        if (n < 0)
            return false;

        int size = count(n);
        int o = n;
        long sum = 0;

        while (n > 0)
        {
            int l = n % 10;
            long t = 1;
            for (int i = 0; i < size; i++)
            {
                t = t * l;
            }

            sum = sum + t;
            n = n / 10;
        }
        return o == sum;

        // Time: O(d²). count(n) costs O(d). The main loop runs d times, and each pass
        // runs an inner loop of d multiplications so that part costs d × d.
        // Space: O(1). You use only a few variables.
    }    

    public static void main(String[] args)
    {
        // System.out.println(count(-127));

        // System.out.println(sum_of_digits(-465));

        // System.out.println(reverse_num(-12300));

        // System.out.println(palindrome(123210));

        System.out.println(armstrong(153));

    }
}