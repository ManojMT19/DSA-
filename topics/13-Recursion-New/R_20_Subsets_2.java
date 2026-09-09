import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class R_20_Subsets_2
{
    public static void subsets(int nums[], int idx, List<Integer> list, List<List<Integer>> ans)
    {
        ans.add(new ArrayList<>(list));

        for (int i = idx; i < nums.length ; i++)
        {
            if (i > idx && nums[i] == nums[i-1]) continue;

            list.add(nums[i]);
            subsets(nums, i + 1, list, ans);
            list.remove(list.size() - 1);
        }

        // Time: O(2^n × n) in the worst case (no duplicates) — same as Subsets I; duplicates only reduce actual output size, not the worst-case bound.
        // Space: O(n) recursion depth + O(n) for current.
    }

    public static void print_subsets(int nums[], int idx, List<Integer> list, List<List<Integer>> ans)
    {
        if (idx == nums.length)
        {
            ans.add(new ArrayList<>(list)); // IMPORTANT: copy, not the same reference
            return;
        }

        list.add(nums[idx]);
        print_subsets(nums, idx + 1, list, ans);
        list.remove(list.size() - 1);

        int temp = idx + 1;
        while(temp < nums.length && nums[temp] == nums[temp-1])
        {
            temp++;
        }

        print_subsets(nums, temp, list, ans);
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums)
    {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        // subsets(nums, 0, list, ans);
        print_subsets(nums, 0, list, ans);

        return ans;
    }

    public static void main(String[] args)
    {
        int nums[] = { 1, 2, 2 };

        System.out.println(subsetsWithDup(nums));

    }
}
