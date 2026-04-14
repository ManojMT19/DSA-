public class r2
{
    static void ntoone(int n)
    {
        if (n == 0)
            return;
        System.out.println(n);
        ntoone(n - 1);
    }

    static int factorial(int n)
    {
        if (n <= 1)
            return 1;

        return factorial(n - 1) * n;
    }

    static int sum(int n)
    {
        if (n == 0)
            return 0;
        return n + sum(n - 1);
    }

    static int digitsum(int n)
    {
        if (n == 0)
            return 0;

        return (n % 10) + digitsum(n / 10);

    }

    static int digitprod(int n)
    {
        if (n % 10 == n)
            return n;

        return (n % 10) * digitprod(n / 10);
    }

    static void reverse_1(int n)
    {
        if (n < 10)
        {
            System.out.println(n);
            return;
        }

        System.out.print(n % 10);
        reverse_1(n / 10);
    }

    static int reverse_2(int n , int rev)
    {
        if(n == 0)return rev;

        return reverse_2(n/10, rev*10 + n%10);
    }

    static boolean palin(int n)
    {
        return n == reverse_2(n,0);
    }

    static int countzero(int n , int count)
    {
        if(n == 0)
        {
            return count;
        }
        if(n%10 == 0)count++;

        return countzero(n/10, count);
    }
    static int numberOfSteps(int num)
    {
        return steps(num , 0);
    }

    static int steps(int num , int count)
    {
        if(num == 0)return count;

        if(num % 2 == 0)
        {
            return steps(num/2, count+1);
        }
        return steps(num-1, count+1);
    }

    public static void main(String[] args)
    {
        // ntoone(5);
        // System.out.println(factorial(5));
        // System.out.println(sum(5));

        // System.out.println(digitsum(1342));
        // System.out.println(digitprod(55));

        reverse_1(10200);
        // System.out.println(reverse_2(123400,0 ));
        // System.out.println(palin(12321));

        // System.out.println(countzero(10203, 0));

        // System.out.println(numberOfSteps(14));
    }
}
