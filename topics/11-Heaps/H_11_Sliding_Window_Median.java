import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class H_11_Sliding_Window_Median // Leetcode 480
{
    public static double[] medianSlidingWindow_Brute(int[] nums, int k) // this is correct but time limit exceeds
    {
        double ans[] = new double[nums.length - k + 1];
        int temp[] = new int[k];

        for (int i = 0; i < k; i++)
        {
            temp[i] = nums[i];
        }

        int l = 0;

        for(int r = k-1 ; r < nums.length ; r++)
        {   
            int[] sorted = temp.clone();
            Arrays.sort(sorted);

            if (k % 2 == 1)
            {
                ans[l++] = sorted[k / 2];
            }
            else
            {
                ans[l++] = ((double) sorted[k / 2 - 1] + sorted[k / 2]) / 2.0;
            }

            if(r < nums.length - 1)
            {
                for(int i = 0 ; i < k-1 ; i++)
                {
                    temp[i] = temp[i+1];
                }
                temp[k-1] = nums[r+1];
            }

        }

        return ans;
    }

    public static double[] medianSlidingWindow(int[] nums, int k)
    {
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < k; i++)
        {
            maxheap.add(nums[i]);
        }

        int l = 0;
        int r = k - 1;
        double ans[] = new double[nums.length - k];

        while (r < nums.length - 1)
        {
            int top = maxheap.poll();
            int middle = maxheap.poll();
            maxheap.poll();

            ans[l] = middle;

            maxheap.add(top);
            maxheap.add(middle);

            l++;
            maxheap.add(nums[r++]);
        }
        return ans;
    }

    public static void main(String[] args)
    {
        int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };

        // double res[] = medianSlidingWindow(nums, 3);
        double res[] = medianSlidingWindow_Brute(nums, 3);

        for (double d : res)
        {
            System.out.println(d);
        }

    }
}
