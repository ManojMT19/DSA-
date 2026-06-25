public class SW_10_Count_Number_of_Nice_Subarray
{
    public static int numberOfSubarrays_brute(int[] nums, int k)
    {
        int count = 0;
        for (int i = 0; i < nums.length; i++)
        {
            int sum = 0;
            for (int j = i; j < nums.length; j++)
            {
                if (nums[j] % 2 != 0)
                {
                    sum += 1;
                }
                if (sum == k)
                {
                    count++;
                } else if (sum > k)
                {
                    break;
                }
            }
        }

        return count;
    }

    public static int numberOfSubarrays_optimal(int[] nums, int k)
    {
        return Atmost(nums, k) - Atmost(nums, k - 1);
    }

    public static int Atmost(int[] nums, int k)
    {
        if (k < 0)
        {
            return 0;
        }

        int sum = 0;
        int r = 0;
        int l = 0;
        int count = 0;
        
        while (r < nums.length)
        {
            if (nums[r] % 2 != 0)
            {
                sum += 1;
            }
            
            while (sum > k)
            {
                if (nums[l] % 2 != 0)
                {
                    sum--;
                }
                l++;
            }
            count += r-l+1;
            r++;
        }
        return count;
    }

    public static void main(String[] args)
    {
        // int nums[] = { 1, 1, 2, 1, 1 };
        int nums[] = { 2, 2, 2, 1, 2, 2, 1, 2, 2, 2 };
        int k = 2;

        System.out.println(numberOfSubarrays_brute(nums, k));
        System.out.println(numberOfSubarrays_optimal(nums, k));
    }
}
