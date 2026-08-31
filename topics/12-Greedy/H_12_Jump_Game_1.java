public class H_12_Jump_Game_1 // Leetcode 55
{
    public static boolean canJump(int[] nums) 
    {
        int maxindex = 0;

        for(int i = 0 ; i < nums.length ; i++)
        {
            if(i > maxindex)return false;

            maxindex = Math.max(maxindex, i + nums[i]);
        }
        return true;
        // TC = O(n)
        // SC = O(1)
    }

    public static void main(String[] args)
    {
        int nums[] = {2,3,1,1,4};

        System.out.println(canJump(nums));
    }
}
