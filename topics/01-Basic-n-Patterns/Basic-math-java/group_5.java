/*
Group 5: Number systems
nth Fibonacci number (loop version)
Decimal to binary and binary to decimal
Count set bits in a number

Star patterns
Right triangle (stars = i)
Inverted triangle (stars = n - i + 1)
Pyramid (spaces = n - i, stars = 2i - 1)
Diamond (a pyramid followed by an inverted pyramid)
Number triangle (print j instead of *)
Hollow square or pyramid (star only on the border, otherwise a space)

*/
public class group_5
{
    public static int fibonacci_loop(int n)
    {
        int prev = 0;
        int curr = 1;
        for(int i = 2 ; i <= n ; i++)
        {
            int next = prev + curr;
            prev = curr;
            curr = next;
        }
        return curr;
    }

    public static String decimalToBinary(int n) 
    {
        if(n == 0)return "0";

        StringBuilder sb = new StringBuilder();

        while(n > 0)
        {
            int remainder = n % 2;
            sb.append(remainder);
            n = n/ 2;
        }
        return sb.reverse().toString();
    }

    public static int BinaryToDecimal(String s)
    {
    /*
        Every binary position represents a power of 2:

        1    1    0    1
        ↓    ↓    ↓    ↓
        2³   2²   2¹   2⁰

        So:

        1101

        = 1×8 + 1×4 + 0×2 + 1×1
        = 8 + 4 + 0 + 1
        = 13
    */

        int result = 0;
        int n= s.length();
        int base = 1;

        for(int i = n-1 ; i >=0 ; i--)
        {
            int temp = s.charAt(i) - '0';
            result = result + temp*base;
            base = 2*base;
        }
        return result;
    }

    public static int countSetbits_1(int n) // important
    {
        int  count = 0;

        while(n > 0)
        {
            if(n % 2 == 1)
            {
                count++;
            }
            n = n/2;
        }
        return count;
    }

    
    public static int countSetbits_2(int n) // important -- using but manipulation formula
    {
        int count = 0;
        while(n > 0)
        {
            n = n & (n - 1);
            count++;
        }
        return count;
    }

    public static void main(String[] args)
    {
        // System.out.println(fibonacci_loop(3));

        // System.out.println(decimalToBinary(15));

        // System.out.println(BinaryToDecimal("1111"));

        System.out.println(countSetbits_1(15));
        System.out.println(countSetbits_2(15));
    }
}
