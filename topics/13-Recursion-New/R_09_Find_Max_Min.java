public class R_09_Find_Max_Min
{
    public static int find_max(int nums[],int index,int maxx)
    {
        if(index == nums.length)return maxx;

        maxx = Math.max(maxx, nums[index]);

        return find_max(nums, index+1, maxx);
    }

    public static int find_min(int nums[],int index,int minn)
    {
        if(index == nums.length)return minn;

        minn = Math.min(minn, nums[index]);

        return find_min(nums, index+1, minn);
    }

    public static void main(String[] args)
    {
        int nums[] = {4,2,7,8,10,3,17};

        System.out.println(find_max(nums, 0, Integer.MIN_VALUE));
        System.out.println(find_min(nums, 0, Integer.MAX_VALUE));
    }
}
