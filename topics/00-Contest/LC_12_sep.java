import java.util.Arrays;

public class LC_12_sep
{
    public static int countIntersectingIntervals_1(int[][] intervals)
    {
        int count = 0;

        for (int i = 0; i < intervals.length - 1; i++)
        {
            for (int j = i + 1; j < intervals.length; j++)
            {
                if (intervals[i][0] <= intervals[j][1] && intervals[j][0] <= intervals[i][1])
                {
                    count++;
                }
            }
        }

        return count;
    }

    public static long countIntersectingIntervals(int[][] intervals)
    {
        int n = intervals.length;
        if (n <= 1)
            return 0;

        int[] starts = new int[n];
        int[] ends = new int[n];

        for (int i = 0; i < n; i++)
        {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }

        Arrays.sort(starts);

        Arrays.sort(ends);

        long nonIntersectingCount = 0;
        int startPtr = 0;

        for (int i = 0; i < n; i++)
        {
            int currentEnd = ends[i];

            while (startPtr < n && starts[startPtr] <= currentEnd)
            {
                startPtr++;
            }

            nonIntersectingCount += (n - startPtr);
        }

        long totalPairs = (long) n * (n - 1) / 2;
        return totalPairs - nonIntersectingCount;
    }
}
