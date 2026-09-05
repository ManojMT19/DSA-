import java.util.Arrays;

public class H_15_Candy
{
    public static int candy_brute(int[] ratings)
    {
        int n = ratings.length;
        int candies[] = new int[n];
        Arrays.fill(candies, 1);
        int ans = 0;

        boolean change = true;
        while (change)
        {
            change = false;
            for (int i = 0; i < n - 1; i++)
            {
                if(ratings[i] > ratings[i+1] && candies[i+1] >= candies[i])
                {
                    candies[i] = candies[i+1] + 1;
                    change = true;
                }
                else if(ratings[i] < ratings[i+1] && candies[i+1] <= candies[i])
                {
                    candies[i+1] = candies[i] + 1;
                    change = true;
                }
            }
        }
        for(int c : candies)ans += c;

        return ans;

        // TC = O(n sq)
        // SC = O(n)
    }
    
    public static int candy_optimal(int[] ratings)
    {
        int n = ratings.length;
        int candies[] = new int[n];
        Arrays.fill(candies, 1);
        int ans = 0;

        for(int i = 1 ; i < n ; i++)
        {
            if(ratings[i] > ratings[i-1])
            {
                candies[i] = candies[i-1] + 1;
            }
        }

        for(int i = n-2 ; i >= 0 ; i--)
        {
            if(ratings[i] > ratings[i+1])
            {
                candies[i] = Math.max(candies[i], candies[i+1] + 1);
            }
        }

        for(int c : candies)
        {
            ans += c;
        }
        return ans;
        
        // TC = O(n)
        // SC = O(n)
    }

    public static void main(String[] args)
    {
        int ratings[] = {1,3,2,1};
        System.out.println(candy_brute(ratings));
        System.out.println(candy_optimal(ratings));
    }
}
