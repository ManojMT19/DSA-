public class SW_14_Min_Size_Subarray_Sum
{
    public static int minSubArrayLen_brute(int target, int[] nums)
    {
        int len = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++)
        {
            int sum = 0;
            for (int j = i; j < nums.length; j++)
            {
                sum += nums[j];
                if (sum >= target)
                {
                    len = Math.min(len, j - i + 1);
                }
            }
        }

        if (len == Integer.MAX_VALUE)
            return 0;

        return len;
    }

    public static int minSubArrayLen(int target, int[] nums)
    {
        int r = 0;
        int l = 0;
        int len = Integer.MAX_VALUE;
        int sum = 0;
        while (r < nums.length)
        {
            sum += nums[r];
            while (sum >= target)
            {
                len = Math.min(len, r - l + 1);
                sum -= nums[l++];
            }
            r++;
        }
        if (len == Integer.MAX_VALUE)
        {
            return 0;
        }
        return len;
    }

    public static void main(String[] args)
    {
        int []nums1 = {2,3,1,2,4,3};
        int []nums2 = {1,2,3,4,5};

        System.out.println(minSubArrayLen_brute(7, nums1));
        System.out.println(minSubArrayLen(7, nums1));

        System.out.println(minSubArrayLen_brute(11, nums2));
        System.out.println(minSubArrayLen(11, nums2));
    }
}
