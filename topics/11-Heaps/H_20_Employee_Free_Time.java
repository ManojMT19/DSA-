import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class H_20_Employee_Free_Time  // Leetcode 759
{
    public static List<int[]> employeeFreeTime_Brute(int[][][] schedule)
    {
        List<int[]> all = new ArrayList<>();

        for (int[][] emp : schedule)
        {
            for (int[] interval : emp)
            {
                all.add(interval);
            }
        }

        all.sort((a, b) -> a[0] - b[0]);

        List<int[]> merged = new ArrayList<>();

        for (int[] interval : all)
        {
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0])
            {
                merged.add(interval);
            } else
            {
                merged.get(merged.size() - 1)[1] = Math.max(interval[1], merged.get(merged.size() - 1)[1]);
            }
        }

        List<int[]> result = new ArrayList<>();
        for (int i = 1; i < merged.size(); i++)
        {
            result.add(new int[] { merged.get(i - 1)[1], merged.get(i)[0] });
        }
        return result;
        // TC = O(n log n)
        // SC = O(n)
    }

    public static void main(String[] args)
    {
        int[][][] schedule = { { { 1, 2 }, { 5, 6 } }, { { 1, 3 } }, { { 4, 10 } } };
        List<int[]> freeTime = employeeFreeTime_Brute(schedule);

        for (int[] interval : freeTime)
        {
            System.out.println(Arrays.toString(interval));
        }
    }
}
