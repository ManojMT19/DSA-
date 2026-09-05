import java.util.Arrays;

public class H_19_Largest_Number  // Leetcode 179
{
    public static String largestNumber_optimal(int[] nums) // this is the optimal soln 
    {
        String[] str = new String[nums.length];
        for(int i = 0 ; i < nums.length ; i++)
        {
            str[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(str , (a,b) -> (b+a).compareTo(a+b));
        if (str[0].equals("0")) return "0"; 

        StringBuilder sb = new StringBuilder();
        for(String s : str)
        {
            sb.append(s);
        }
        return sb.toString();
    }
    public static void main(String[] args)
    {
        // int nums[] = {10,2};
        int nums[] = {3,30,34,5,9};
        System.out.println(largestNumber_optimal(nums));
    }
}
