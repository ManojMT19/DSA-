import java.util.*;

public class R_22_Combination_Sum_2
{
    public static void solve(int nums[] , int target , int sum , int idx , List<Integer> current , List<List<Integer>> ans)
    {
        if(sum > target) return ;

        if(sum == target)
        {
            if(ans.contains(current) == false)
            {
                ans.add(new ArrayList<>(current));
            }
            return ;
        }

        if(idx == nums.length) return ;

        current.add(nums[idx]);
        sum += nums[idx];
        solve(nums, target, sum, idx+1, current, ans);
        sum -= nums[idx];
        current.remove(current.size() - 1);

        solve(nums, target, sum, idx+1, current, ans);
    }

    
    public static void solve_2(int nums[] , int target , int sum , int idx , List<Integer> current , List<List<Integer>> ans)
    {
        if(sum > target)return ;
        
        if(sum == target)
        {
            ans.add(new ArrayList<>(current));
            return ;
        }

        for(int i = idx ; i < nums.length ; i++)
        {
            if(i > idx && nums[i] == nums[i-1])continue;

            current.add(nums[i]);
            sum += nums[i];
            solve_2(nums, target, sum, i+1, current, ans);
            sum -= nums[i];
            current.remove(current.size()-1);
        }
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) 
    {
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        // solve(candidates, target, 0, 0, list, ans);
        solve_2(candidates, target, 0, 0, list, ans);

        return ans;
    }

    public static void main(String[] args)
    {
        int nums[] = {10,1,2,7,6,1,5};
        int target = 8;
    
        int nums2[] = {2,5,2,1,2};
        int target2 = 5;

        System.out.println(combinationSum2(nums, target));
        System.out.println(combinationSum2(nums2, target2));
    }
}
