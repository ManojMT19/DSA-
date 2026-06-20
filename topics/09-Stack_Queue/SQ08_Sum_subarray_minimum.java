import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SQ08_Sum_subarray_minimum
{
    public static int sumSubarrayMins_brute(int[] arr)
    {
        List<List<Integer>> list = new ArrayList<>();

        int n = arr.length;
        for (int i = 0; i < n; i++)
        {
            for (int j = i; j < n; j++)
            {
                ArrayList<Integer> temp = new ArrayList<>();
                for (int k = i; k <= j; k++)
                {
                    temp.add(arr[k]);
                }
                list.add(temp);
            }
        }

        int minimum = 0;
        for (int i = 0; i < list.size(); i++)
        {
            int mini = Integer.MAX_VALUE;
            for (int j = 0; j < list.get(i).size(); j++)
            {
                mini = Math.min(mini, list.get(i).get(j));
            }
            minimum += mini;
        }
        return minimum;
        // TC = O(n^3)
        // SC = O(n^3)
    }

    public static int sumSubarrayMins_better(int[] arr)
    {
        int mod = (int) 1e9 + 7;
        int sum = 0;
        for (int i = 0; i < arr.length; i++)
        {
            int mini = arr[i];
            for (int j = i; j < arr.length; j++)
            {
                mini = Math.min(mini, arr[j]);
                sum = (sum + mini) % mod;
            }
        }
        return sum;
        // TC = O(n ^ 2)
        // SC = O(1)
    }

    private static int[] findPSEE(int[] arr)
    {
        int n = arr.length;
        int[] ans = new int[n];

        Stack<Integer> st = new Stack<>();

        for (int i = 0 ; i < n ; i++)
        {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) 
            {
                st.pop();    
            }
            ans[i] = !st.isEmpty() ? st.peek() : -1 ;

            st.push(i);
        }
        return ans;
    }
    private static int[] findNSE(int[] arr)
    {
        int n = arr.length;
        int[] ans = new int[n];

        Stack<Integer> st = new Stack<>();

        for (int i = n-1 ; i >= 0; i--)
        {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) 
            {
                st.pop();    
            }
            ans[i] = !st.isEmpty() ? st.peek() : n ;

            st.push(i);
        }
        return ans;
    }
    public static int sumSubarrayMins_optimal(int[] arr)
    {
        int n = arr.length;
        int []nse = findNSE(arr);
        int []pse = findPSEE(arr);
        int sum = 0 ;
        int mod = (int) 1e9+7;

        for (int i = 0; i < n; i++)
        {
            int left = i - pse[i];
            int right = nse[i] - i;
            long freq = left * right * 1L;
            int val = (int)((freq * arr[i]) % mod);
            sum = (sum + val) % mod;
        }

        return sum;
    }

    public static void main(String[] args)
    {
        int[] arr = { 3, 1, 2, 4 };

        int r = sumSubarrayMins_optimal(arr);

        System.out.println(r);

    }
}
