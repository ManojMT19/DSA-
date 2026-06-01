import java.util.*;

public class SQ10_Range_of_SubArray
{
    public static long subArrayRanges_Brute(int[] arr)
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

        long ans = 0;
        for (int i = 0; i < list.size(); i++)
        {
            int mini = Integer.MAX_VALUE;
            int maxi = Integer.MIN_VALUE;
            for (int j = 0; j < list.get(i).size(); j++)
            {
                mini = Math.min(mini, list.get(i).get(j));
                maxi = Math.max(maxi, list.get(i).get(j));
            }
            ans += (long) (maxi - mini);
        }
        return ans;
        // TC = O(n^3)
        // SC = O(n^3)
    }

    public static long subArrayRanges_Better(int[] arr)
    {
        long sum = 0;
        for (int i = 0; i < arr.length; i++)
        {
            long largest = arr[i];
            long smallest = arr[i];

            for (int j = i; j < arr.length; j++)
            {
                largest = Math.max(largest, arr[j]);
                smallest = Math.min(smallest, arr[j]);

                sum += (largest - smallest);
            }
        }
        return sum;
        //TC = o(N sq)
        //SC = OO(1)
    }

    private static int[] findPSEE(int[] arr)
    {
        int n = arr.length;
        int[] ans = new int[n];

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++)
        {
            while (!st.isEmpty() && arr[st.peek()] > arr[i])
            {
                st.pop();
            }
            ans[i] = !st.isEmpty() ? st.peek() : -1;

            st.push(i);
        }
        return ans;
    }

    private static int[] findPGEE(int[] arr)
    {
        int n = arr.length;
        int[] ans = new int[n];

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++)
        {
            while (!st.isEmpty() && arr[st.peek()] < arr[i])
            {
                st.pop();
            }
            ans[i] = !st.isEmpty() ? st.peek() : -1;

            st.push(i);
        }
        return ans;
    }

    private static int[] findNSE(int[] arr)
    {
        int n = arr.length;
        int[] ans = new int[n];

        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--)
        {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i])
            {
                st.pop();
            }
            ans[i] = !st.isEmpty() ? st.peek() : n;

            st.push(i);
        }
        return ans;
    }

    private static int[] findNGE(int[] arr)
    {
        int n = arr.length;
        int[] ans = new int[n];

        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--)
        {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i])
            {
                st.pop();
            }
            ans[i] = !st.isEmpty() ? st.peek() : n;

            st.push(i);
        }
        return ans;
    }

    public static long subArrayRanges_optimal(int[] arr)
    {
        int n = arr.length;
        int[] nse = findNSE(arr);
        int[] pse = findPSEE(arr);

        int[] nge = findNGE(arr);
        int[] pge = findPGEE(arr);

        long sum = 0;

        for (int i = 0; i < n; i++)
        {
            int sleft = i - pse[i];
            int sright = nse[i] - i;
            long sfreq = sleft * sright * 1L;  // this will give u no of subarrays
            long sval = (sfreq * arr[i]); 

            int gleft = i - pge[i];
            int gright = nge[i] - i;
            long gfreq = gleft * gright * 1L;
            long gval = (gfreq * arr[i]);

            long total = (gval - sval);

            sum += total;
        }

        return sum;
        //TC = O(N)
        //SC = O(N)
    }

    public static void main(String[] args)
    {
        int[] arr = { 4, -2, -3, 4, 1 };

        long ans = subArrayRanges_Better(arr);
        System.out.println(ans);

    }
}
