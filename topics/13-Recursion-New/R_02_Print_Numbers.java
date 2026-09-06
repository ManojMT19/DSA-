public class R_02_Print_Numbers
{
    public static void N_to_One(int n)
    {
        if(n == 1)
        {
            System.out.println(n);
            return ;
        }
        System.out.println(n);
        N_to_One(n-1);
    }

    public static void one_to_N(int n)
    {
        if(n == 1)
        {
            System.out.println(1);
            return ;
        }
        one_to_N(n-1);
        System.out.println(n);
    }
    
    public static void main(String[] args)
    {
        // N_to_One(5);
        one_to_N(5);
    }
}
