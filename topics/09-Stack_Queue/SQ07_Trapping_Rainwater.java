public class SQ07_Trapping_Rainwater
{
    public static int trap(int[] nums)
    {
        int n = nums.length;
        int prefix[] = new int[nums.length];
        int suffix[] = new int[nums.length];

        prefix[0] = nums[0];
        for (int i = 1; i < n; i++)
        {
            prefix[i] = Math.max(prefix[i - 1], nums[i]);
        }

        suffix[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--)
        {
            suffix[i] = Math.max(suffix[i + 1], nums[i]);
        }

        int total = 0;
        for (int i = 0; i < n - 1; i++)
        {
            int leftMax = prefix[i];
            int rightMax = suffix[i];
            if (nums[i] < leftMax && nums[i] < rightMax)
            {
                total += Math.min(leftMax, rightMax) - nums[i];
            }
        }
        return total;
        // TC = O(n)
        // SC = O(n)
    }

    public int trap_optimal(int[] height)
    {
        int n = height.length;

        int left = 0;
        int right = n - 1;

        int leftMax = 0;
        int rightMax = 0;

        int water = 0;

        while (left <= right)
        {
            if (leftMax <= rightMax)
            {
                if (height[left] >= leftMax)
                {
                    leftMax = height[left];
                } else
                {
                    water += leftMax - height[left];
                }

                left++;
            } else
            {
                if (height[right] >= rightMax)
                {
                    rightMax = height[right];
                } else
                {
                    water += rightMax - height[right];
                }

                right--;
            }
        }

        return water;
    }

    public static void main(String[] args)
    {
        // int nums[] = {4,2,0,3,2,5};
        int nums[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        int r = trap(nums);
        System.out.println(r);

    }

}
