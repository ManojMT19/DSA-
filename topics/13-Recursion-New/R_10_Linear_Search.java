public class R_10_Linear_Search
{
    public static int linear_search(int nums[] , int target,int index)
    {
        if(index == nums.length)return -1;

        if(nums[index] == target)return  index;

        return linear_search(nums, target, index+1);
    }

    public static void main(String[] args)
    {
        int nums[] = {4,2,7,8,10,3,17};
        System.out.println(linear_search(nums, 8, 0));
    }
}
