public class SW_09_Binary_SubArray_With_Sum
{
    public static int numSubarraysWithSum_Brute(int[] nums, int goal)
    {
        int count = 0;
        for (int i = 0; i < nums.length; i++)
        {
            int sum = 0;
            for (int j = i; j < nums.length; j++)
            {
                sum += nums[j];

                if (sum == goal)
                {
                    count++;
                }
                if (sum > goal)
                {
                    break;
                }
            }
        }
        return count;
    }

    public static int function(int[]nums , int goal)
    {
        if(goal < 0)
        return 0;
    
        int count = 0;
        int r = 0;
        int l = 0;
        int sum = 0;
        while (r < nums.length)
        {
            sum += nums[r];

            while (sum > goal)
            {
                sum -= nums[l];
                l++;
            }

            count = count + r - l + 1;
            r++;
        }

        return count;
    }
    public static int numSubarraysWithSum_Optimal(int[] nums, int goal)
    {
        return function(nums, goal) - function(nums, goal-1);
    }

    public static void main(String[] args)
    {
        int nums[] = { 1,0,1,0,1};
        int goal = 2;

        System.out.println(numSubarraysWithSum_Brute(nums, goal));
        System.out.println(numSubarraysWithSum_Optimal(nums, goal));
    }
}
