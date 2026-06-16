public class LC_weekly_506
{
    public static boolean checkGoodInteger(int n) 
    {
        int digitsum = 0 ;
        int squaresum = 0;
        while(n > 0)
        {
            int d = n % 10;
            n = n/10;

            digitsum += d;
            squaresum += (d*d);
        }

        if(squaresum - digitsum >= 50)return true;
        return false;
    }

    public static void main(String[] args) {
        int n = 1000;
        System.out.println(checkGoodInteger(n));
    }
}
