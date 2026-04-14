import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class r4_subset
{
    // -------------------------------------------------------------------------------------------------
    // Recursive Approach
    static ArrayList<String> subset(String r, String s, ArrayList<String> list)
    {
        if (s.isEmpty())
        {
            list.add(r);
            return list;
        }
        char c = s.charAt(0);

        subset(r + c, s.substring(1), list);

        return subset(r, s.substring(1), list);
    }

    static ArrayList<String> subset_1(String r, String s)
    {
        if (s.length() == 0)
        {
            ArrayList<String> list = new ArrayList<>();
            list.add(r);
            return list;
        }
        char c = s.charAt(0);
        ArrayList<String> left = subset_1(r + c, s.substring(1));
        ArrayList<String> right = subset_1(r, s.substring(1));

        left.addAll(right);

        return left;
    }

    class Solution
    {
        List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> subsetsWithDup(int[] nums)
        {
            Arrays.sort(nums); // sort to group duplicates
            List<Integer> list = new ArrayList<>();
            generate(list, nums, 0);
            return res;
        }

        public void generate(List<Integer> list, int[] nums, int index)
        {
            if (index == nums.length)
            {
                res.add(new ArrayList<>(list));
                return;
            }

            // INCLUDE
            list.add(nums[index]);
            generate(list, nums, index + 1);
            list.remove(list.size() - 1);

            // EXCLUDE — skip all duplicates
            while (index + 1 < nums.length && nums[index] == nums[index + 1])
            {
                index++; // skip duplicate
            }
            generate(list, nums, index + 1);
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    // Iterative Approach -- For every existing subset, create a new subset by
    // adding the new element to that subset.
    // For Strings
    static void solve(int index, String s, String curr, ArrayList<String> ans)
    {
        ans.add(curr);
        for (int i = index; i < s.length(); i++)
        {
            if (i > index && s.charAt(i) == s.charAt(i - 1))
                continue;

            solve(i + 1, s, curr + s.charAt(i), ans);
        }
    }

    static ArrayList<String> subset_2(String s)
    {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        s = new String(arr);
        ArrayList<String> ans = new ArrayList<>();

        solve(0, s, "", ans);

        return ans;
    }

    // For Numbers not for Strings
    static void solve(int index, int[] nums, List<Integer> curr, List<List<Integer>> ans)
    {
        ans.add(new ArrayList<>(curr)); // store current subset

        for (int i = index; i < nums.length; i++)
        {

            // 🔥 skip duplicates
            if (i > index && nums[i] == nums[i - 1])
                continue;

            curr.add(nums[i]);
            solve(i + 1, nums, curr, ans);
            curr.remove(curr.size() - 1); // backtrack
        }
    }

    static List<List<Integer>> subsetsWithDup(int[] nums)
    {
        Arrays.sort(nums); // MUST

        List<List<Integer>> ans = new ArrayList<>();
        solve(0, nums, new ArrayList<>(), ans);

        return ans;
    }

    public static void main(String[] args)
    {
        // ArrayList<String> list = new ArrayList<>();
        // subset("", "abc", list);
        // list = subset_1("", "xyz");
        // System.out.println(list);

        System.out.println(subset_2("122"));

    }
}
