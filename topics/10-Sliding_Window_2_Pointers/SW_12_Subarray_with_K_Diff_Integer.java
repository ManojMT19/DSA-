import java.util.HashMap;
import java.util.HashSet;

public class SW_12_Subarray_with_K_Diff_Integer
{
    public static int subarraysWithKDistinct(int[] nums, int k) 
    {
        int count = 0;
        for (int i = 0; i < nums.length; i++)
        {
            HashSet<Integer> set = new HashSet<>();
            for (int j = i; j < nums.length; j++)
            {
                set.add(nums[j]);
                if(set.size() == k)
                {
                    count++;
                }
            }
        }
        return count;
    }

    public static int func(int[] nums, int k) 
    {
        int count = 0;
        int  r = 0;
        int l = 0;
        HashMap <Integer , Integer> map = new HashMap<>();
        while (r < nums.length) 
        {
            map.put(nums[r] , map.getOrDefault(nums[r], 0) + 1);

            while (map.size() > k) 
            {
                map.put(nums[l], map.get(nums[l]) - 1);
                if(map.get(nums[l]) == 0)
                {
                    map.remove(nums[l]);
                }
                l++;
            }
            if (map.size() <= k) 
            {
                count += r - l + 1;    
            }
            r++;
        }

        return count;
    }
    
    public static int subarraysWithKDistinct_optimal(int[] nums, int k) 
    {
        return func(nums, k) - func(nums, k-1);
    }

    public static void main(String[] args) 
    {
        int nums[] = {1,2,1,2,3};
        int k = 2;
        
        System.out.println(subarraysWithKDistinct_optimal(nums, k));
    }
}
