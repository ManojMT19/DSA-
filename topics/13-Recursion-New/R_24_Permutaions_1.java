import java.util.ArrayList;
import java.util.List;

public class R_24_Permutaions_1
{
    public static void solve(int nums[] , boolean used[], List<Integer> current , List<List<Integer>> ans)
    {
        if(current.size() == nums.length)
        {
            ans.add(new ArrayList<>(current));
            // System.out.println(current);
            return ;
        }
        
        for(int i = 0 ; i < nums.length ; i++)
        {
            if(used[i]) continue;

            current.add(nums[i]);
            used[i] = true;
            solve(nums, used, current, ans);
            used[i] = false;
            current.remove(current.size()-1);
        }
    }
    public static  List<List<Integer>> permute(int[] nums) 
    {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        boolean used[] = new boolean[nums.length];

        solve(nums, used, list, ans);

        return ans;
    }

    /*
        Time: O(n! × n) — n! total permutations, each taking O(n) to copy into the result.
        Space: O(n) for used + O(n) for recursion depth + O(n) for current.
    */

    public static void main(String[] args)
    {
        int nums[] = {1,2,3};

        System.out.println(permute(nums));
    }
}
