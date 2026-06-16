public class SW_02_Maximum_Points_Cards
{
    public static int maxScore(int[] cardPoints, int k)
    {
        int n = cardPoints.length;

        int lsum = 0;
        int rsum = 0;
        for (int i = 0; i < k; i++)
        {
            lsum += cardPoints[i];
        }
        int maxsum = lsum;

        int rindex = n - 1;
        for (int i = k - 1; i >= 0; i--)
        {
            lsum -= cardPoints[i];

            rsum += cardPoints[rindex];
            rindex = rindex - 1;

            maxsum = Math.max(maxsum, lsum + rsum);
        }
        return maxsum;
    }

    public static void main(String[] args)
    {
        // int[] cardpoints = { 1, 2, 3, 4, 5, 6, 1 };
        int[] cardpoints = { 96, 90, 41, 82, 39, 74, 64, 50, 30 };
        int k = 8;

        System.out.println(maxScore(cardpoints, k));
    }
}
