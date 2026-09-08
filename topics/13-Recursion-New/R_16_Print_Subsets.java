import java.util.ArrayList;
import java.util.List;

public class R_16_Print_Subsets
{
    public static void print_subsets(int nums[] , int idx , List<Integer> list)
    {
        if(idx == nums.length)
        {
            System.out.println(list);
            return ;
        }

        list.add(nums[idx]);
        print_subsets(nums, idx+1, list);
        list.remove(list.size()-1);

        print_subsets(nums, idx+1, list);
    }
    /*
    Time: O(2^n × n) — 2^n total leaf nodes (one per subsequence), and printing/copying each subsequence costs up to O(n).
    Space: O(n) for recursion stack depth + O(n) for the current list at any point in time = O(n) auxiliary space (not counting the output itself).
    */
    public static void main(String[] args)
    {
        int nums[] = {1,2,3};
        ArrayList<Integer> current = new ArrayList<>();

        print_subsets(nums, 0, current);
    }
}
