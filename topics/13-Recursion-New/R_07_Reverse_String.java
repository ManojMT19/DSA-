public class R_07_Reverse_String
{
    public static void reverse_array(int nums[], int left, int right)
    {
        if (left >= right)
            return;

        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;

        reverse_array(nums, left + 1, right - 1);

        // Time: O(n) — n/2 swaps, but each recursive call does O(1) work, so O(n) calls total.
        // Space: O(n) — recursion stack depth is n/2, still counts as O(n).
    }

    public void reverseString(char[] s, int left, int right)
    {
        if (left >= right)return;

        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;

        reverseString(s, left + 1, right - 1);
    }

    public static void main(String[] args)
    {
        int nums[] = { 1, 2, 3, 4, 5 };
        reverse_array(nums, 0, nums.length - 1);

        for (int n : nums)
        {
            System.out.print(n + " ");
        }
    }
}
