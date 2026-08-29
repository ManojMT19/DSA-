import java.util.*;

public class H_09_Insert_Intervals
{
    public static int[][] insert(int[][] interval, int[] newInterval)
    {
        int newData[][] = new int[interval.length + 1][2];
        int j = 0;

        for (int i[] : interval)
        {
            newData[j++] = i;
        }
        newData[j] = newInterval;

        Arrays.sort(newData, (a, b) -> Integer.compare(a[0], b[0]));

        ArrayList<int[]> answer = new ArrayList<>();

        for (int i = 0; i < newData.length; i++)
        {
            if (answer.isEmpty() || newData[i][0] > answer.get(answer.size() - 1)[1])
            {
                answer.add(newData[i]);
            } else
            {
                answer.get(answer.size() - 1)[1] = Math.max(answer.get(answer.size() - 1)[1], newData[i][1]);
            }
        }

        return answer.toArray(new int[answer.size()][]);

        // TC = O(n log n)
        // SC = O(n)
    }

    public static int[][] insert_2(int[][] interval, int[] newInterval)
    {
        List<int[]> answer = new ArrayList<>();
        int i = 0;
        int n = interval.length;

        // 1. Add all intervals that end before newInterval starts (no overlap, come first)
        while (i < n && interval[i][1] < newInterval[0])
        {
            answer.add(interval[i]);
            i++;
        }

        // 2. Merge all intervals that overlap with newInterval
        int start = newInterval[0];
        int end = newInterval[1];
        while (i < n && interval[i][0] <= end)
        {
            start = Math.min(start, interval[i][0]);
            end = Math.max(end, interval[i][1]);
            i++;
        }
        answer.add(new int[] { start, end });

        // 3. Add all remaining intervals (start strictly after merged end)
        while (i < n)
        {
            answer.add(interval[i]);
            i++;
        }

        return answer.toArray(new int[answer.size()][]);

        // TC = O(n)
        // SC = O(n)
    }

    public static void main(String[] args)
    {
        int intervals[][] = { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 }, { 18, 20 }, { 21, 25 } };

        int newIntervals[] = { 4, 19 };

        int res[][] = insert_2(intervals, newIntervals);

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
