import java.util.HashMap;

public class SW_08_Count_Subarray_Sum_Equals_K
{
    public static int subarraySum_brute(int[] nums, int k)
    {
        int count = 0;

        for (int i = 0; i < nums.length; i++)
        {
            int sum = 0;
            for (int j = i; j < nums.length; j++)
            {
                sum += nums[j];
                if (sum == k)
                {
                    count++;
                }
            }
        }
        return count;
    }

    public static int subarraySum_optimal(int[] nums, int k) // Important prefix sum method works for both +ve n -ve
    {
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);

        int prefixSum = 0;
        int count = 0;

        for (int num : nums)
        {
            prefixSum += num;

            if (map.containsKey(prefixSum - k))
            {
                count += map.get(prefixSum - k);
            }

            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }

    public static int atMost(int[] nums, int k)
    {
        if (k < 0)
            return 0;

        int l = 0;
        int sum = 0;
        int count = 0;

        for (int r = 0; r < nums.length; r++)
        {
            sum += nums[r];

            while (sum > k)
            {
                sum -= nums[l++];
            }

            count += r - l + 1;
        }

        return count;
    }

    public static int countSubarraysExactlyK(int[] nums, int k) // works only in +ve not in -ve
    {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    public static void main(String[] args)
    {
        int[] nums = { 1, 2, 3 };
        int k = 3;

        System.out.println(subarraySum_brute(nums, k));
        System.out.println(subarraySum_optimal(nums, k));
        System.out.println(countSubarraysExactlyK(nums, k));
    }
}
