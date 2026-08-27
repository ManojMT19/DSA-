import java.util.Arrays;

public class H_01_Assign_Cookies
{
    public static int findContentChildren(int[] g, int[] s) 
    {
        Arrays.sort(g);
        Arrays.sort(s);
        int count=0;
        int j =0;

        for(int i =0 ; i < s.length && j< g.length ; i++)
        {
            if(s[i] >= g[j])
            {
              count++;
              j++;
            }

        }
        return count;
    }
    public static void main(String[] args) 
    {
        int []g = {1,2};
        int []s = {1,2,3};

        System.out.println(findContentChildren(g, s));
    }
}
