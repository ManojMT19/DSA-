public class LC_Weekly_522
{
    public static int minRotations(String s) // leetcode 4070
    {
        int current = 0;
        int total = 0;

        for (char ch : s.toCharArray())
        {
            int target = ch - '0';

            int diff = Math.abs(current - target);
            int rotations = Math.min(diff, 10 - diff);

            total += rotations;
            current = target;
        }

        return total;
    }

        public static long maxAlternatingSum(int[] nums) // this is correct but TLE
    {
        long maxx = Integer.MIN_VALUE;

        for (int i : nums)
        {
            if (i > maxx)
                maxx = i;
        }

        long temp = 0;
        for (int i = 0; i < nums.length; i++)
        {
            if (i % 2 == 0)
            {
                temp += nums[i];
            } else
            {
                temp -= nums[i];
            }
        }

        if (temp > maxx)
            maxx = temp;

        int j = 0;
        while (j < nums.length)
        {
            long ex = 0;
            for (int i = 0; i < nums.length; i++)
            {
                if(i == j)continue;

                if (i % 2 == 0)
                {
                    ex += nums[i];
                } else
                {
                    ex -= nums[i];
                }
            }
            j = j + 1;
            if(ex > maxx)maxx = ex;
        }
        return maxx;
    }

    public static void main(String[] args)
    {
        String s = "0192837465";

        System.out.println(minRotations(s));
    }
}
