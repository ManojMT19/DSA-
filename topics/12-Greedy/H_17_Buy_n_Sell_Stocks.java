public class H_17_Buy_n_Sell_Stocks // Leetcode 121
{
    public static int maxProfit(int[] prices) 
    {
        int maxProfit = 0;
        int n = prices.length;
        for(int buy = 0 ; buy < n ; buy++)
        {
            for(int sell = buy + 1 ; sell < n ; sell++)
            {
                int profit = prices[buy] - prices[sell];
                maxProfit = Math.max(maxProfit, profit);
            }
        }
        return maxProfit;
    }
    
    public static int maxProfit_1(int[] prices)  // 2 pointer sliding window approach
    {
        int maxProfit = 0;
        int left = 0;
        int right = 1;
        while (right < prices.length) 
        {
            if(prices[left] < prices[right])
            {
                int profit = prices[right] - prices[left];
                maxProfit = Math.max(maxProfit, profit);
                right++;
            }
            else
            {
                left = right;
                right++;
            }
        }
        return maxProfit;
    }

    public static int maxProfit_2(int []prices)
    {
        /*
        Instead of trying every possible buy → sell pair, we scan the array only once.
        At every day, we remember the cheapest price we could have bought at so far, and ask: “If I sell today, what is my profit?” 
        */

        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for(int p : prices)
        {
            if(p < minPrice)
            {
                minPrice = p;
            }
            else if(p - minPrice > maxProfit)
            {
                maxProfit = p - minPrice;
            }
        }
        return maxProfit;
        // TC = O(n)
        // SC = O(1)
    }

    public static void main(String[] args)
    {
        // int prices[] = {2,1,2,1,0,1,2};
        int prices[] = {1,2,4,2,5,7,2,4,9,0,9};

        System.out.println(maxProfit(prices));
        System.out.println(maxProfit_1(prices));
        System.out.println(maxProfit_2(prices));
    }
}
