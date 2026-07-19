import java.util.Arrays;
import java.util.PriorityQueue;

public class H_03_Sort_K_Sorted_Array
{
    public static void NearlySorted_brute(int []arr , int k)
    {
        Arrays.sort(arr);

        for (int i : arr) 
        {
            System.out.println(i);
        }
    }

    public static void NearlySorted_optimal(int []arr , int k)
    {
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        int []ans = new int[arr.length];
        int j = 0;

        for (int i = 0; i < arr.length; i++)
        {
            minheap.add(arr[i]);

            if (minheap.size() > k) 
            {
                ans[j] = minheap.poll();
                j++;
            }
        }

        while (j != arr.length) {
            ans[j] = minheap.poll();
            j++;
        }

        for (int i : ans) 
        {
            System.out.println(i);
        }
    }

    public static void main(String[] args) 
    {
        int []arr = {6,5,3,2,8,10,9};

        NearlySorted_brute(arr, 3);
        NearlySorted_optimal(arr, 3);
    }
}
