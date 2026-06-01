import java.util.Stack;

public class SQ06_Previous_Small_Element
{
    public static int[] previous_small_element_brute(int[] nums)
    {
        int n = nums.length;
        int[]res = new int[n];
        for (int i = 0; i < n; i++)
        {
            res[i] = -1;
            for (int j = i-1; j >= 0 ; j--)
            {
                if(nums[j] < nums[i])
                {
                    res[i] = nums[j];
                    break;
                }
            }
        }
        return res;
        //TC = O(n sq)
        //SC =o(n)
    }
    public static int[] previous_small_element_optimal(int[] nums)
    {
        int[]res = new int[nums.length];
        Stack<Integer> st = new Stack<>();
        
        for (int i = 0; i < nums.length; i++)
        {
            while (!st.isEmpty() && st.peek() >= nums[i]) 
            {
                st.pop();
            }

            if(st.isEmpty())
            {
                res[i] = -1;
            }
            else
            {
                res[i] = st.peek();
            }
            st.push(nums[i]);
        }
        return res;
        //TC = O(n)
        //SC =O(n)
    }

    public static void main(String[] args) 
    {
        int nums[] = { 1,3,4,2};

        int r[] = previous_small_element_optimal(nums);

        for(int i : r)
        {
            System.out.println(i);
        }
    }
}
