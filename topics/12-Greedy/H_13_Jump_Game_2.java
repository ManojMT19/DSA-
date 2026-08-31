public class H_13_Jump_Game_2 // Leetcode 45  
{

    // Very difficult to understand 


    public static int jump_brute(int[] nums) 
    {
        return func(nums, 0, 0);
    }
    
    public static int func(int nums[] , int jump , int index)
    {
        if(index >= nums.length-1)return jump;

        int mini = Integer.MAX_VALUE;

        for(int i = 1 ; i <= nums[index] ; i++)
        {
            mini = Math.min(mini , func(nums, jump+1, index + i));
        }
        return mini;
    }
    
    public static int jump_optimal(int[] nums) 
    {
        int jump = 0;
        int left = 0;
        int right = 0;

        while(right < nums.length-1)
        {
            int farthest = 0;
            for(int i = left ; i <= right ; i++)
            {
                farthest = Math.max(farthest, i + nums[i]);
            }
            left = right + 1;
            right = farthest;
            jump++;
        }
        return jump;
    }

    public static void main(String[] args)
    {
        int nums[] = {2,3,1,1,4};

        System.out.println(jump_brute(nums));
        System.out.println(jump_optimal(nums));
    }
}
