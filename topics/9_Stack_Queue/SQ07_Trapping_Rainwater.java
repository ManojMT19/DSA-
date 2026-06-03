import java.util.HashMap;

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

    public static int trap_optimal(int[] nums)
    {

    }

    public static void main(String[] args)
    {
        int nums[] = {4,2,0,3,2,5};
        int nums[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        int r = trap(nums);
        System.out.println(r);

    }

}
