import java.util.Arrays;
import java.util.PriorityQueue;

public class H_02_K_Larger_Elements
{
    public static void Kth_Largest_Elements(int []arr , int k)
    {
        PriorityQueue<Integer> minheap = new PriorityQueue<>();

        for (int i = 0; i < arr.length; i++)
        {
            minheap.add(arr[i]);
            if(minheap.size() > k)
            {
                minheap.poll();
            }
        }
        System.out.println(minheap.peek());
    }

    public static void K_Larger_Elements(int[]arr , int k)
    {
        PriorityQueue<Integer> minheap =  new PriorityQueue<>();

        for (int i = 0; i < arr.length; i++)
        {
            minheap.add(arr[i]);
            if(minheap.size() >  k)
            {
                minheap.poll();
            }
        }
        
        for (int x : minheap) 
        {
            System.out.println(x);
        }
        
    }

    public static void k_large_sorting(int[]p , int k)
    {
        Arrays.sort(p);

        for (int i = k; i < p.length; i++)
        {
            System.out.println(p[i]);
        }
    }
    public static void main(String[] args) 
    {
        int[] p = {7,10,4,3,20,15};

        // Kth_Largest_Elements(p, 3);

        System.out.println();

        K_Larger_Elements(p, 3);

        System.out.println();

        // k_large_sorting(p, 3);
    }
}
