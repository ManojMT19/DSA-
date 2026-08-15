import java.util.Collections;
import java.util.PriorityQueue;

public class H_09_Sum_Between_K1_K2
{
    public static int sum_between_k1_n_k2(int nums[], int k1, int k2)
    {
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
        // PriorityQueue<Integer> maxheap = new PriorityQueue<>((a,b) -> Integer.compare(b,a));

        for (int n : nums)
        {
            maxheap.add(n);
            if (maxheap.size() > k2)
            {
                maxheap.poll();
            }
        }

        int n2 = maxheap.peek();

        for (int i = 0; i < k2-k1; i++)
        {
            maxheap.poll();
        }

        int n1 = maxheap.peek();
        int sum = 0;

        for (int n : nums)
        {
            if (n > n1 && n < n2)
            {
                sum += n;
            }
        }
        return sum;
    }

    public static void main(String[] args)
    {
        int nums[] = { 1, 3, 12, 5, 15, 11 };

        System.out.println(sum_between_k1_n_k2(nums, 3, 6));
    }
}
