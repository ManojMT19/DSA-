import java.util.*;

public class LC_weekly_525
{

    public static long maxNumber(long n)
    {
        char[] arr = String.valueOf(n).toCharArray();

        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder(new String(arr));
        sb.reverse();

        return Long.parseLong(sb.toString());
    }

    public long maximizeSum(int[] nums, int k)
    {
        long ans = 0;
        int n = nums.length;

        long[][] arr = new long[n][2];

        for (int i = 0; i < n; i++)
        {
            long maxNo = maxNumber(nums[i]);

            arr[i][0] = maxNo - nums[i];
            arr[i][1] = nums[i];
        }

        Arrays.sort(arr, (a, b) -> Long.compare(b[0], a[0]));

        for (int i = 0; i < n; i++)
        {
            if (i < k && arr[i][0] > 0)
            {
                ans += arr[i][1] + arr[i][0];
            } else
            {
                ans += arr[i][1];
            }
        }

        return ans;
    }

    public int countStaircase(int[] nums)
    {
        int size = nums.length;
        Map<Integer, Integer> freq = new HashMap<>();
        int mapsize = freq.size();
        int[] count = new int[nums.length];

        for (int i = 0; i < nums.length; i++)
        {
            int n = nums[i];

            freq.put(n, freq.getOrDefault(n, 0) + 1);

            count[i] = freq.get(n);
        }

        int l = 0;
        int r = 1;

        int ans = 0;
        for(int i = 0 ; i < count.length ; i++)
        {
            if(count[l] == count[r])r++;

        }

        return  size + ans;
    }

}
