import java.util.ArrayList;
import java.util.List;

public class R_17_Count_All_Subsequences_Sum_K
{
    public static void print_subsequences_sum_k(int nums[] ,int target, int sum , int idx , List<Integer> current)
    {
        if (sum > target) return ; 
        
        if(idx == nums.length)
        {
            if(sum == target)
            {
                System.out.println(current);
            }
            return ;
        }

        current.add(nums[idx]);
        sum += nums[idx];
        print_subsequences_sum_k(nums, target, sum, idx+1, current);
        sum -= current.get(current.size()-1);
        current.remove(current.size()-1);

        print_subsequences_sum_k(nums, target, sum, idx+1, current);
    }
    
    public static int count_subsequences_sum_K(int nums[] ,int target, int sum , int idx)
    {
        if (sum > target) return 0; 
        
        if(idx == nums.length)
        {
            return (sum == target) ? 1 : 0;
        }

        int take = count_subsequences_sum_K(nums, target, sum + nums[idx], idx+1);

        int skip = count_subsequences_sum_K(nums, target, sum, idx+1);

        return take + skip;

        /*
            Time: O(2^n) — two branches per index, same shape as print-all-subsequences.
            Space: O(n) — recursion stack depth only (no current list needed here).
        */
    }

    public static void main(String[] args)
    {
        int  nums[] = {1,2,1,1};
        int target = 3;

        List<Integer> ans = new ArrayList<>();
        print_subsequences_sum_k(nums, target, 0, 0, ans);

        System.out.println(count_subsequences_sum_K(nums, target, 0, 0));
        
    }
}
