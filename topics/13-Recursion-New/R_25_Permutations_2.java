import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class R_25_Permutations_2
{
    public static void solve(int nums[], boolean used[], List<Integer> current, List<List<Integer>> result)
    {
        if (current.size() == nums.length)
        {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++)
        {
            if (used[i])
                continue;

            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
                continue;

            // !used[i-1] means since both current n previous are equal i am sufficient with previous itself 

            current.add(nums[i]);
            used[i] = true;
            solve(nums, used, current, result);
            used[i] = false;
            current.remove(current.size() - 1);
        }
    }

    public static List<List<Integer>> permuteUnique(int[] nums)
    {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        boolean used[] = new boolean[nums.length];

        solve(nums, used, list, ans);

        return ans;
    }

    /*
    Time: O(n! × n) worst case (no duplicates present, no pruning benefit) — same bound as Permutations I; duplicates only reduce actual output count.
    
    Space: O(n) for used + O(n) recursion depth + O(n) for current.
    */

    public static void main(String[] args)
    {
        int nums[] = { 1, 1, 2 };
        System.out.println(permuteUnique(nums));
    }
}
