import java.util.*;

public class H_06_Find_K_Closest_Element
{
    public static List<Integer> findClosestElements(int[] arr, int k, int x)
    {
        PriorityQueue<int[]> maxheap = new PriorityQueue<>((a, b) -> {
            if (a[1] != b[1])
            {
                return Integer.compare(b[1], a[1]); // larger distance first
            }
            return Integer.compare(b[0], a[0]); // larger value first
        });

        // (a, b) -> Integer.compare(a[0], b[0]) // min heap (smallest on top)
        // (a, b) -> Integer.compare(b[0], a[0]) // max heap (largest on top)

        List<Integer> ans = new ArrayList<>(k);

        for (int i = 0; i < arr.length; i++)
        {
            maxheap.offer(new int[] { arr[i], Math.abs(x - arr[i]) });
            if (maxheap.size() > k)
            {
                maxheap.poll();
            }
        }

        while (maxheap.size() > 0)
        {
            ans.add(maxheap.peek()[0]);
            maxheap.poll();
        }

        Collections.sort(ans);
        return ans;
    }

    public static void main(String[] args)
    {
        int arr[] = { 1, 2, 3, 4, 5 };

        // int arr[] = {1,1,1,10,10,10};

        System.out.println(findClosestElements(arr, 4, 3));
    }
}
