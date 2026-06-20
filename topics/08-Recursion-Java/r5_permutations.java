import java.util.*;

public class r5_permutations
{
    static void permutations(String p, String up)
    {
        if (up.isEmpty())
        {
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);

        for (int i = 0; i <= p.length(); i++)
        {
            String first = p.substring(0, i);
            String s = p.substring(i, p.length());
            permutations(first + ch + s, up.substring(1));
        }
    }

    static ArrayList<String> permutations_list(String p, String up)
    {
        if (up.isEmpty())
        {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);
        ArrayList<String> ans = new ArrayList<>();

        for (int i = 0; i <= p.length(); i++)
        {
            String first = p.substring(0, i);
            String s = p.substring(i, p.length());
            ans.addAll(permutations_list(first + ch + s, up.substring(1)));
        }
        return ans;
    }

    static int permutations_count_within_argument(String p, String up, int[] count)
    {
        if (up.isEmpty())
        {
            count[0]++;
            return count[0];
        }

        char ch = up.charAt(0);

        for (int i = 0; i <= p.length(); i++)
        {
            String first = p.substring(0, i);
            String s = p.substring(i, p.length());
            permutations_count_within_argument(first + ch + s, up.substring(1), count);
        }
        return count[0];
    }

    static int permutations_count(String p, String up)
    {
        if (up.isEmpty())
        {
            return 1;
        }

        char ch = up.charAt(0);
        int count = 0;

        for (int i = 0; i <= p.length(); i++)
        {
            String first = p.substring(0, i);
            String s = p.substring(i, p.length());
            count += permutations_count(first + ch + s, up.substring(1));
        }
        return count;
    }

    static void helper(int[] nums, List<Integer> curr, List<List<Integer>> ans)
    {
        if (nums.length == curr.size())
        {
            ans.add(new ArrayList<>(curr));
            // System.out.println(curr);
            return;
        }

        for (int i = 0; i < nums.length; i++)
        {
            if (curr.contains(nums[i]))
                continue;

            curr.add(nums[i]);
            helper(nums, curr, ans);
            curr.remove(curr.size() - 1);

        }

    }

    static List<List<Integer>> permute(int[] nums) // Leetcode 46
    {
        Arrays.sort(nums); // Most Important for Duplicates
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        helper(nums, curr, ans);
        return ans;
    }

    
    public static void main(String[] args)
    {
        // permutations("", "abc");

        // ArrayList<String> list = permutations2("", "abc");
        // System.out.println(list);

        // int count[] = {0};
        // int r = permutations_count_within_argument("", "abcd", count);
        // System.out.println(r);

        // System.out.println(permutations_count("", "abcd"));

        int nums[] = { 1, 1, 2 };
        List<List<Integer>> r = permute(nums);
        System.out.println(r);

    }

}
