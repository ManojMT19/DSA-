import java.util.*;

public class R_21_Combination_Sum // Leetcode 39
{
    public static void solve(int nums[], int target, int idx, int sum, List<Integer> current, List<List<Integer>> ans)
    {
        if (sum == target)
        {
            ans.add(new ArrayList<>(current));
            return;
        }

        if (idx == nums.length || sum > target)
            return;

        current.add(nums[idx]);
        sum += nums[idx];
        solve(nums, target, idx, sum, current, ans);
        sum -= nums[idx];
        current.remove(current.size() - 1);

        solve(nums, target, idx + 1, sum, current, ans);
    }

    public static void solve_2(int[] candidates, int target, int idx, List<Integer> current, int sum, List<List<Integer>> result)
    {
        if (sum == target)
        {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = idx; i < candidates.length; i++)
        {
            if (sum + candidates[i] > target) break; // sorted, so all further candidates also overshoot 

            current.add(candidates[i]);
            solve_2(candidates, target, i, current, sum + candidates[i], result); // stay at i for reuse
            current.remove(current.size() - 1);
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target)
    {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        solve(candidates, target, 0, 0, current, ans);

        return ans;
    }

    public static void main(String[] args)
    {
        int nums[] = { 2, 3, 6, 7 };
        int target = 7;

        System.out.println(combinationSum(nums, target));
    }

}
