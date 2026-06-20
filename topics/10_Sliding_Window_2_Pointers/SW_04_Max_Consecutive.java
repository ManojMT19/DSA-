public class SW_04_Max_Consecutive
{
    public static int longestOnes(int[] nums, int k)
    {
        int maxlength = 0;
        for (int i = 0; i < nums.length; i++)
        {
            int count = 0;
            int x = k;
            for (int j = i; j < nums.length; j++)
            {
                if (nums[j] == 1)
                {
                    count++;
                } else if (nums[j] == 0 && x > 0)
                {
                    count++;
                    x--;
                } else if (nums[j] == 0 && x == 0)
                {
                    break;
                }
                maxlength = Math.max(maxlength, count);
            }
        }
        return maxlength;
        // TC = O(N sq)
        // SC = O(1)
    }

    public static int longestOnes_optimal(int[] nums, int k)
    {
        int r = 0;
        int l = 0;
        int zero = 0;
        int maxlength = 0;
        while (r < nums.length)
        {
            if (nums[r] == 0)
            {
                zero++;
            }
            if (zero > k)
            {
                while (zero > k)
                {
                    if (nums[l] == 0)
                    {
                        zero--;
                    }
                    l++;
                }
            }
            maxlength = Math.max(maxlength, r - l + 1);
            r++;
        }
        return maxlength;
        // TC = O(2N)
        // SC = O(1)
    }

    public static int longestOnes_most_optimal(int[] nums, int k)
    {
        int r = 0;
        int l = 0;
        int zero = 0;
        int maxlength = 0;
        while (r < nums.length)
        {
            if (nums[r] == 0)
            {
                zero++;
            }
            if (zero > k)
            {
                if (nums[l] == 0)
                {
                    zero--;
                }
                l++;

            }
            maxlength = Math.max(maxlength, r - l + 1);
            r++;
        }
        return maxlength;
        // TC = O(N)
        // SC = O(1)
    }

    public static void main(String[] args)
    {
        int nums[] = { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 };
        int k = 2;

        // int nums[] = { 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1 };
        // int k = 3;

        // int nums[] = { 0, 0, 1, 1 };
        // int k = 1;

        System.out.println(longestOnes_most_optimal(nums, k));
    }
}
