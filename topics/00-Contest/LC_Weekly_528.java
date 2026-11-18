import java.util.ArrayList;
import java.util.Arrays;

public class LC_Weekly_528
{
    static int findMin(int[] arr)
    {
        int min = arr[0];

        for (int i = 1; i < arr.length; i++)
        {
            if (arr[i] < min)
            {
                min = arr[i];
            }
        }

        return min;
    }

    static int findAnd(int[] arr)
    {

        int and = arr[0];

        for (int i = 1; i < arr.length; i++)
        {
            and = and & arr[i];
        }

        return and;
    }

    public int countConsistent(int[] nums)
    {

        int ans = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++)
        {

            for (int j = i; j < n; j++)
            {

                ArrayList<Integer> temp = new ArrayList<>();

                for (int k = i; k <= j; k++)
                {
                    temp.add(nums[k]);
                }

                int[] arr = temp.stream().mapToInt(Integer::intValue).toArray();

                int mini = findMin(arr);
                int and = findAnd(arr);

                if (mini == and)
                {
                    ans++;
                }
            }
        }

        return ans;
    }


    long dp[];

    static long turn(int nums[], int ind, long dp[])
    {

        int n = nums.length;

        if (ind >= n)
            return 0;

        if (dp[ind] != Long.MIN_VALUE)
        {
            return dp[ind];
        }

        long num = nums[ind];

        long option1;

        if (num % 3 == 0)
        {
            option1 = num - turn(nums, ind + 1, dp);
        } else
        {
            option1 = num + turn(nums, ind + 1, dp);
        }

        long option2 = Long.MIN_VALUE;

        if (ind + 1 < n)
        {

            num = (long) nums[ind] + nums[ind + 1];

            if (num % 3 == 0)
            {
                option2 = num - turn(nums, ind + 2, dp);
            } else
            {
                option2 = num + turn(nums, ind + 2, dp);
            }
        }

        return dp[ind] = Math.max(option1, option2);
    }

    public long maxDifference(int[] nums)
    {

        int n = nums.length;

        long dp[] = new long[n + 1];

        Arrays.fill(dp, Long.MIN_VALUE);

        return turn(nums, 0, dp);
    }
}
