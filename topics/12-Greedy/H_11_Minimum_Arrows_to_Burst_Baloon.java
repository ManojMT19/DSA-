import java.util.Arrays;

public class H_11_Minimum_Arrows_to_Burst_Baloon // Leetcode 452
{
    public static int findMinArrowShots(int[][] points)
    {
        Arrays.sort(points,(a,b) -> Integer.compare(a[1], b[1]));
        int maxArrows = 1;
        int position = points[0][1];

        for (int i = 1; i < points.length ; i++)
        {
            if (points[i][0] > position) 
            {
                maxArrows++;    
                position = points[i][1];
            }
        }
        return maxArrows;
        // TC = O(n log n)
        // SC = O(n)
    }

    public static void main(String[] args)
    {
        // int points[][] = { { 10, 16 }, { 2, 8 }, { 1, 6 }, { 7, 12 } };
        int points[][] = { { 1, 2 }, { 3, 4 }, { 5, 6 }, { 7, 8 } };
        System.out.println(findMinArrowShots(points));
    }
}
