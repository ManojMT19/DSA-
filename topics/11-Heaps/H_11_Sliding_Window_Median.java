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

        for (int r = k - 1; r < nums.length; r++)
        {
            int[] sorted = temp.clone();
            Arrays.sort(sorted);

            if (k % 2 == 1)
            {
                ans[l++] = sorted[k / 2];
            } else
            {
                ans[l++] = ((double) sorted[k / 2 - 1] + sorted[k / 2]) / 2.0;
            }

            if (r < nums.length - 1)
            {
                for (int i = 0; i < k - 1; i++)
                {
                    temp[i] = temp[i + 1];
                }
                temp[k - 1] = nums[r + 1];
            }

        }

        return ans;
    }

    public static double[] medianSlidingWindow_better(int[] nums, int k) // this is correct but time limit exceeds
    {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        double[] ans = new double[nums.length - k + 1];

        int left = 0;
        int right = 0;

        while (right < k)
        {

            if (maxHeap.isEmpty() || nums[right] <= maxHeap.peek())
            {
                maxHeap.add(nums[right]);
            } else
            {
                minHeap.add(nums[right]);
            }

            if (maxHeap.size() > minHeap.size() + 1)
            {
                minHeap.add(maxHeap.poll());
            }

            if (minHeap.size() > maxHeap.size())
            {
                maxHeap.add(minHeap.poll());
            }

            right++;
        }

        int index = 0;

        while (true)
        {

            if (k % 2 == 1)
            {
                ans[index++] = maxHeap.peek();
            } else
            {
                ans[index++] = ((double) maxHeap.peek() + minHeap.peek()) / 2.0;
            }

            if (right == nums.length)
            {
                break;
            }

            if (!maxHeap.remove(nums[left]))
            {
                minHeap.remove(nums[left]);
            }
            left++;

            if (maxHeap.isEmpty() || nums[right] <= maxHeap.peek())
            {
                maxHeap.add(nums[right]);
            } else
            {
                minHeap.add(nums[right]);
            }
            right++;

            if (maxHeap.size() > minHeap.size() + 1)
            {
                minHeap.add(maxHeap.poll());
            }

            if (minHeap.size() > maxHeap.size())
            {
                maxHeap.add(minHeap.poll());
            }
        }

        return ans;
    }

    public static void main(String[] args)  //  to make this accepted we have to use something called lazy deletion
    {
        int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };

        double res[] = medianSlidingWindow_better(nums, 3);
        // double res[] = medianSlidingWindow_Brute(nums, 3);

        for (double d : res)
        {
            System.out.println(d);
        }

    }
}
