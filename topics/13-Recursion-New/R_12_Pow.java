public class R_12_Pow  // Leetcode 50
{
    public static double myPow_0(double x, int n) 
    {
        if(n == 0)return 1;
        
        return x * myPow_0(x, n-1);
    }
    
    public static double myPow_1(double x, int n) 
    {
        double ans = x;
        int sign = 0;
        if(n < 0)
        {
            sign = 1;
            n *= -1;
        }
        for(int i = 1 ; i < n ; i++)
        {
            ans *= x;
        }
        if(sign == 1)
        {
            return 1/ans;
        }
        return  ans;
    }

    public static double myPow_2(double x, int n) 
    {
        long N = n;
        if(N < 0)
        {
            x = 1/x;
            N = -N;
        }
        return fast_pow(x,N);
    }

    public static double fast_pow(double x , long n)
    {
        if(n == 0)return 1.0;

        double half = fast_pow(x, n/2);
        double ans = half * half;

        if(n % 2 == 1)
        {
            ans = ans*x;
        }
        return ans;
    }

    public static void main(String[] args)
    {
        System.out.println(myPow_0(2,3));

        System.out.println(myPow_1(2,-3));
        System.out.println(myPow_2(2,-3));
    }
}
