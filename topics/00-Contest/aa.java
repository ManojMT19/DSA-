public class aa
{
    public int[] maxProductPair(int[] nums, int target)
    {
        int maxProduct = Integer.MIN_VALUE;
        int[] ans = { -1, -1 };

        for (int i = 0; i < nums.length; i++)
        {
            for (int j = 0; j < nums.length; j++)
            {
                if (i != j && nums[i] + nums[j] == target && nums[i] > nums[j])
                {

                    int product = nums[i] * nums[j];

                    if (product > maxProduct)
                    {
                        maxProduct = product;
                        ans[0] = i;
                        ans[1] = j;
                    }
                }
            }
        }

        return ans;
    }


    public int resilientSubarray(int[] nums, int k)
    {
        int n = nums.length;
        int ans = 1;

        for (int i = 0; i < n; i++)
        {
            int r = ((nums[i] % k) + k) % k;

            for (int j = i; j < n; j++)
            {
                int cur = ((nums[j] % k) + k) % k;

                if (cur != r)
                    break;

                long len = j - i + 1;
                if (((len - 1) * r) % k == 0)
                {
                    ans = Math.max(ans, (int) len);
                }
            }
        }

        return ans;
    }
}
