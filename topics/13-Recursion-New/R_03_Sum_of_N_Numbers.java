public class R_03_Sum_of_N_Numbers
{
    /*
    
      We can use n*(n+1)/2

    */

    public static int sum(int n)
    {
        if(n == 1)
        {
            return 1;
        }
        return n + sum(n-1);
    }
    public static void main(String[] args)
    {
        System.out.println(sum(3));
    }
}
