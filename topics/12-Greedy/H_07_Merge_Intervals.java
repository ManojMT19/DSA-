import java.util.ArrayList;
import java.util.Arrays;

public class H_07_Merge_Intervals
{
    public static int[][] merge(int[][] intervals)
    {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int ans[][] = new int[intervals.length][2];
        int start = intervals[0][0];
        int end = intervals[0][1];
        int j = 0;

        for (int i = 1; i < intervals.length; i++)
        {
            if (intervals[i][0] <= end)
            {
                end = Math.max(intervals[i][1], end);
            } else
            {
                ans[j++] = new int[] { start, end };

                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        ans[j++] = new int[] { start, end }; // adding the last interval

        return Arrays.copyOf(ans, j);
        // TC = O(n log n)
        // SC = O(n)
    }

    public int[][] merge_2(int[][] num)
    {
        Arrays.sort(num, (a, b) -> Integer.compare(a[0], b[0]));

        int n = num.length;
        ArrayList<int[]> answer = new ArrayList<>();

        for (int i = 0; i < n; i++)
        {
            if (answer.isEmpty() || num[i][0] > answer.get(answer.size() - 1)[1])
            {
                answer.add(num[i]);
            } else
            {
                answer.get(answer.size() - 1)[1] = Math.max(answer.get(answer.size() - 1)[1], num[i][1]);
            }
        }

        return answer.toArray(new int[answer.size()][]);
    }

    public static void main(String[] args)
    {
        int intervals[][] = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };

        int res[][] = merge(intervals);

        for (int[] i : res)
        {
            for (int j : i)
            {
                System.out.print(j + ",");
            }
            System.out.println();
        }
    }
}
