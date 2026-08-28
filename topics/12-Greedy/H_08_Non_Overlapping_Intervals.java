import java.util.Arrays;

public class H_08_Non_Overlapping_Intervals
{
    public static int eraseOverlapIntervals(int[][] intervals) // Sort according to the finishing time
    {
        Arrays.sort(intervals, (a, b) -> {
            if (a[1] == b[1])
            {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        int result = 0;

        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++)
        {
            if (intervals[i][0] >= end)
            {
                end = intervals[i][1];
            } else
            {
                result++;
            }
        }
        return result;
        // TC = O(n log n)
        // SC = O(1)
    }

    public static void main(String[] args)
    {
        int intervals[][] = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 3 } };
        System.out.println(eraseOverlapIntervals(intervals));
    }
}
