import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class R_05_Check_Array_Sorted
{
    public  static  boolean sorted_1(List<Integer> nums, int n)
    {
        if(n == 0 || n == 1)return true;

        if(nums.get(n-1) >= nums.get(n-2) && sorted_1(nums, n-1))
        {
            return true;
        }
        return false;
    }

    public  static  boolean sorted_2(List<Integer> nums, int n)
    {
        if(n == 0 || n == 1)return true;

        if(nums.get(n-1) >= nums.get(n-2))
        {
            return sorted_2(nums, n-1);
        }
        return false;
    } 
    
    public  static  boolean sorted_3(List<Integer> nums, int index)
    {
        if(index == nums.size())return true;

        if(nums.get(index) > nums.get(index+1))return false;

        return sorted_3(nums, index+1);
    }

    public static void main(String[] args)
    {
        List<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 31, 4, 5,6));

        System.out.println(sorted_1(nums, nums.size()));
        System.out.println(sorted_2(nums, nums.size()));
        System.out.println(sorted_3(nums, 0));

    }
}
