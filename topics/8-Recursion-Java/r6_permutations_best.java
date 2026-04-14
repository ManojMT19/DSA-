import java.util.*;

public class r6_permutations_best
{
    static List<List<Integer>> permute_Bruteforce(int[] nums) // Leetcode 46
    {
        List<Integer> up = new ArrayList<>();
        for (int n : nums)
            up.add(n);

        List<List<Integer>> ans = new ArrayList<>();
        helper1(new ArrayList<>(), up, ans);
        return ans;
    }

    static void helper1(List<Integer> curr, List<Integer> up, List<List<Integer>> ans)
    {
        if (up.isEmpty())
        {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < up.size(); i++)
        {
            int ch = up.get(i);
            up.remove(i);
            curr.add(ch);
            helper1(curr, up, ans);
            curr.remove(curr.size() - 1);
            up.add(i, ch);
        }
    }

    static List<List<Integer>> permute_optimal(int[] nums)
    {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        helper2(nums, new ArrayList<>(), used, ans);
        return ans;
    }

    static void helper2(int[] nums, List<Integer> curr, boolean[] used, List<List<Integer>> ans)
    {
        if (curr.size() == nums.length)
        {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < nums.length; i++)
        {
            if (used[i])
                continue;

            used[i] = true;
            curr.add(nums[i]);
            helper2(nums, curr, used, ans);
            curr.remove(curr.size() - 1);
            used[i] = false;
        }
    }

    // ----------------------------------------------------------------------------------------------------------------------

    static List<List<Integer>> permuteUnique_duplicates_Bruteforce(int[] nums)  // Leetcode 47
    {
        Arrays.sort(nums);
        List<Integer> up = new ArrayList<>();
        for (int n : nums)
            up.add(n);

        List<List<Integer>> ans = new ArrayList<>();
        helper4(new ArrayList<>(), up, ans);
        return ans;
    }

    static void helper4(List<Integer> curr, List<Integer> up, List<List<Integer>> ans)
    {
        if (up.isEmpty())
        {
            ans.add(new ArrayList<>(curr));
            return;
        }

        HashSet<Integer> seen = new HashSet<>();

        for (int i = 0; i < up.size(); i++)
        {
            if (seen.contains(up.get(i)))
                continue;

            int ch = up.get(i);
            seen.add(ch);
            up.remove(i);
            curr.add(ch);
            helper4(curr, up, ans);
            curr.remove(curr.size() - 1);
            up.add(i, ch);
        }
    }

    static List<List<Integer>> permuteUnique_Duplicates_optimal(int[] nums) 
    {
        Arrays.sort(nums); // group duplicates
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        helper3(nums, new ArrayList<>(), used, ans);
        return ans;
    }

    static void helper3(int[] nums, List<Integer> curr, boolean[] used, List<List<Integer>> ans)
    {
        if (curr.size() == nums.length)
        {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < nums.length; i++)
        {
            if (used[i])
                continue;
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
                continue;

            used[i] = true;
            curr.add(nums[i]);
            helper3(nums, curr, used, ans);
            curr.remove(curr.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) 
    {
        int nums[] = {1,2,2};
        List<List<Integer>> result = permuteUnique_Duplicates_optimal(nums);
        System.out.println(result);
        
        
    }

}
