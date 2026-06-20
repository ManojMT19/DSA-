import java.util.ArrayDeque;
import java.util.Deque;

public class SQ14_Sliding_Window_Maximum
{
    public static int findMax(int[] num)
    {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < num.length; i++)
        {
            max = Math.max(max, num[i]);
        }
        return max;
    }

    public static int[] maxSlidingWindow(int[] nums, int k)
    {
        int[] ans = new int[nums.length - k + 1];

        for (int i = 0; i <= nums.length - k; i++)
        {
            int[] temp = new int[k];
            int x = 0;
            for (int j = i; j < i + k; j++)
            {
                temp[x++] = nums[j];
            }
            ans[i] = findMax(temp);
        }
        return ans;
    }

    public static int[] maxSlidingWindow_optimal(int[] nums, int k)
    {
        if (nums == null || nums.length == 0 || k <= 0)
        {
            return new int[0];
        }

        Deque<Integer> dq = new ArrayDeque<>();
        int[] ans = new int[nums.length - k + 1];
        int idx = 0;

        for (int i = 0; i < nums.length; i++)
        {
            // Rule 1: Remove indices outside current window
            if (!dq.isEmpty() && dq.peekFirst() <= i - k)
            {
                dq.pollFirst();
            }

            // Rule 2: Remove smaller elements from the back
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i])
            {
                dq.pollLast();
            }

            // Add current index
            dq.offerLast(i);

            // Store maximum once window is formed
            if (i >= k - 1)
            {
                ans[idx++] = nums[dq.peekFirst()];
            }
        }

        return ans;
        //TC = O(N)
        //SC = O(k)
    }

    public static void main(String[] args)
    {
        int[] num = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;

        int[] res = maxSlidingWindow_optimal(num, k);

        for (int i : res)
        {
            System.out.print(i);
        }
    }
}
