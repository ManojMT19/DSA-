public class H_18_Buy_n_Sell_Stocks_2
{
    public static int maxProfit_optimal(int[] prices) 
    {
        int maxProfit = 0;
        for(int i = 1 ; i < prices.length ; i++)
        {
            if(prices[i] > prices[i-1])
            {
                maxProfit += prices[i] - prices[i-1];
            }
        }
        return maxProfit;
    }

    public static void main(String[] args)
    {
        int prices[] = {7,1,5,3,6,4};
        System.out.println(maxProfit_optimal(prices));
    }
}
