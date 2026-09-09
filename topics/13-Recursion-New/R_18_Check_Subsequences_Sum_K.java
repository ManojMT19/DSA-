public class R_18_Check_Subsequences_Sum_K
{
    public static boolean check_subsequences_sum(int nums[], int target, int idx, int sum)
    {
        if (sum == target) return true;

        if (sum > target) return false;

        if (idx == nums.length)
        {
            return false;
        }

        boolean ans = check_subsequences_sum(nums, target, idx + 1, sum + nums[idx]);

        if (ans == false)
        {
            ans = check_subsequences_sum(nums, target, idx + 1, sum);
        }

        return ans;
    }

    /*
    Time: O(2^n) worst case (no valid subsequence exists anywhere, so every path must be checked) — often much faster in practice thanks to early exit.
    Space: O(n) — recursion stack depth.

    */
    public static void main(String[] args)
    {
        int nums[] = { 1, 2, 1, 1 };
        int target = 30;

        System.out.println(check_subsequences_sum(nums, target, 0, 0));

    }
}
