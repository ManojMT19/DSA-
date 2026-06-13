import java.util.*;
public class SQ19_Daily_Temp
{
    public static int[] dailyTemperatures_brute(int[] arr) 
    {
        int n = arr.length;
        int res[] = new int[n];

        for (int i = 0; i < n; i++)
        {
            for (int j = i+1; j < n; j++)
            {
                if(arr[j] > arr[i])
                {
                    res[i] = j-i;
                    break;
                }
            }
        }
        return res;
    }
    public static int[] dailyTemperatures(int[] arr) 
    {
        int n = arr.length;
        int[] ans = new int[n];

        Stack<Integer> st = new Stack<>();

        for (int i = n-1 ; i >= 0; i--)
        {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i])   
            {
                st.pop();    
            }
            ans[i] = st.isEmpty() ? 0 : st.peek() - i;
            st.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] temp = {73,74,75,71,69,72,76,73};

        int[]r = dailyTemperatures(temp);

        for (int i : r) 
        {
            System.out.print(i+" ");
        }
    }
}
