import java.util.ArrayList;
import java.util.List;

public class R_19_Subsets_1
{
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

        print_subsets(nums, idx + 1, list, ans);
    }

    public static void solve(int[] nums, int idx, List<Integer> current, List<List<Integer>> result) // subsets 2 type solving
    {
        result.add(new ArrayList<>(current)); // add at top — every call is one valid subset

        for (int i = idx; i < nums.length; i++)
        {
            current.add(nums[i]);
            solve(nums, i + 1, current, result);
            current.remove(current.size() - 1); 
        }
    }

    public static List<List<Integer>> subsets(int[] nums)
    {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        print_subsets(nums, 0, list, ans);

        return ans;
    }

    public static void main(String[] args)
    {
        int nums[] = { 1, 2, 3 };

        System.out.println(subsets(nums));
    }
}
