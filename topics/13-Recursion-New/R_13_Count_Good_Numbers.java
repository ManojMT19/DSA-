public class R_13_Count_Good_Numbers // :eetcode 1922
{
    static final int MOD = 1_000_000_007;

    public static int countGoodNumbers(long n) // worst question ever
    {
        long even = (n + 1) / 2;
        long odd = n / 2;

        return (int) ((fastPow(5, even) * fastPow(4, odd)) % MOD);
    }

    public static long fastPow(long x, long n)
    {
        if (n == 0) return 1L;

        long half = fastPow(x, n / 2) % MOD; 
        long answer = (half * half) % MOD;

        if (n % 2 == 1)
        {
            answer = (answer * (x % MOD)) % MOD;
        }
        return answer;
    }

    public static void main(String[] args)
    {
        System.out.println(countGoodNumbers(3));
    }
}
