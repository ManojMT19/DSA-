public class R_06_Binary_Search
{
    public static int binary_Search(int nums[], int target, int start, int end)
    {
        if (end >= start)
        {

            int mid = start + (end - start) / 2;
            if (nums[mid] == target)
            {
                return mid;
            } else if (nums[mid] > target)
            {
                return binary_Search(nums, target, start, mid - 1);
            } else
            {
                return binary_Search(nums, target, mid + 1, end);
            }
        }
        return -1;
    }

    public static void main(String[] args)
    {
        int nums[] = {-1,0,3,5,7,9,12};
        System.out.println(binary_Search(nums, 9, 0, nums.length-1));
    }

}
