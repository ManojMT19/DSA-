import java.util.HashMap;
import java.util.Stack;

public class SQ05_Next_Greater_Element_2
{
    public static int[] nextGreaterElements2(int[] nums)
    {
        int r[] = new int[nums.length];

        for (int i = 0; i < nums.length; i++)
        {
            r[i] = -1;
            for (int j = 1; j < nums.length; j++)
            {
                int n = (i + j) % nums.length;
                if (nums[n] > nums[i])
                {
                    r[i] = nums[n];
                    break;
                }
            }
        }
        return r;
        // TC = O(n sq)
        // SC = O(n)
    }

    public static int[] nextGreaterElements1(int[] nums)
    {
        int x = nums.length;
        int[] r = new int[nums.length];
        int[] n2 = new int[nums.length * 2];

        for (int i = 0; i < nums.length; i++)
        {
            n2[i] = nums[i];
        }

        for (int i = 0; i < nums.length; i++)
        {
            n2[x++] = nums[i];
        }

        for (int i = 0; i < nums.length; i++)
        {
            r[i] = -1;
            for (int j = i + 1; j < n2.length; j++)
            {
                if (n2[j] > nums[i])
                {
                    r[i] = n2[j];
                    break;
                }
            }
        }
        return r;
        // TC = O(n sq)
        // SC = O(n)
    }

    public static int[] nextGreaterElements3_optimal(int[] nums)
    {
        int[] res = new int[nums.length];
        Stack<Integer> st = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        int n = nums.length;
        for (int i = 2*n-1; i >= 0; i--)
        {
            int index = i % n;
            while (!st.isEmpty() && st.peek() <= nums[index])
            {
                st.pop();
            }
            if(index < n)
            {
                res[index] = st.isEmpty() ? -1 : st.peek();
            }
            
            st.push(nums[i%n]);
        }
        return res;
    }

    public static void main(String[] args)
    {
        int[] n = { 5, 4, 3, 2, 1 };
        int[] r = nextGreaterElements3_optimal(n);

        for (int i : r)
        {
            System.out.println(i);
        }

    }
}
