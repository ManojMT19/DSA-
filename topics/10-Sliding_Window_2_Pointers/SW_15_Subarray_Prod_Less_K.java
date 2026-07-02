public class SW_15_Subarray_Prod_Less_K
{
    public static int numSubarrayProductLessThanK_brute(int[] nums, int k) 
    {
        int count = 0;
        for (int i = 0; i < nums.length; i++)
        {
            int prod = 1;
            for (int j = i; j < nums.length; j++)
            {
                prod = prod * nums[j];
                if(prod >= k)
                {
                    break;
                }
                count ++;
            }
        }
        return count ;
    }
    public static int numSubarrayProductLessThanK_optimal(int[] nums, int k) 
    {
        int count = 0;
        int r = 0;
        int l = 0;
        int prod = 1;
        while (r < nums.length) 
        {
            prod *= nums[r]; 
            while(prod >= k)
            {
                prod /= nums[l];
                l++;
            }
            count += r - l + 1;
            r++;
        }

        return count ;
    }
    public static void main(String[] args) {
        int []nums1 = {10,5,2,6};
        int k1 = 100;

        int []nums2 = {1,2};
        int k2 = 2;

        System.out.println(numSubarrayProductLessThanK_brute(nums1, k1));
        System.out.println(numSubarrayProductLessThanK_optimal(nums1, k1));

        System.out.println(numSubarrayProductLessThanK_brute(nums2, k2));
        System.out.println(numSubarrayProductLessThanK_optimal(nums2, k2));
    }
}
