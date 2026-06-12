import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SQ15_Stock_Span
{
    static Stack<int[]> st;
    static List<Integer> list;

    public SQ15_Stock_Span()
    {
        list = new ArrayList<>();
        st = new Stack<>();
    }

    public int next_brute(int price)
    {

        list.add(price);

        int count = 1;
        int i = list.size() - 2;

        while (i >= 0 && list.get(i) <= price)
        {
            count++;
            i--;
        }

        return count;
    }

    public int next_optimal(int price)
    {

        int span = 1;

        while (!st.isEmpty() && st.peek()[0] <= price)
        {
            span += st.pop()[1];
        }

        st.push(new int[]{price,span});
        return span;
    }

    public static int[] previous_greater_element_optimal(int[] nums)
    {
        int[]res = new int[nums.length];
        Stack<Integer> st = new Stack<>();
        
        for (int i = 0; i < nums.length; i++)
        {
            int count = 1;
            while (!st.isEmpty() && st.peek() <= nums[i]) 
            {
                count++;
                st.pop();
            }

            if(st.isEmpty())
            {
                res[i] = 1;
            }
            else
            {
                res[i] = count;
            }
            st.push(nums[i]);
        }
        return res;
        //TC = O(n)
        //SC =O(n)
    }

    public static void main(String[] args)
    {
        SQ15_Stock_Span sb = new SQ15_Stock_Span();

        System.out.print(sb.next_optimal(100));
        System.out.print(sb.next_optimal(80));
        System.out.print(sb.next_optimal(60));
        System.out.print(sb.next_optimal(70));
        System.out.print(sb.next_optimal(60));
        System.out.print(sb.next_optimal(75));
        System.out.print(sb.next_optimal(85));

        int[] r = {100,80,60,70,60,75,85};

        int x[] = previous_greater_element_optimal(r);

        System.out.println();

        for (int i : x) 
        {
            System.out.print(i);
        }

    }
}
