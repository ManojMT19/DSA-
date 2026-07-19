import java.util.*;

public class H_01_Kth_Smallest_Element
{
    public static int FindKthSmallest(int [] arr, int k)
    {
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < arr.length; i++)
        {
            maxheap.add(arr[i]);
            
            if (maxheap.size() > k) 
            {
                maxheap.poll();    
            }
        }
        return maxheap.peek();
    }
    public static void main(String[] args) 
    {
        int []p = {7,10,4,3,20,15};

        // int n =  p.length;
        // Arrays.sort(p);
        // System.out.println(p[2]);
        // System.out.println(Arrays.toString(p));

        // System.out.println(FindKthSmallest(p, 3));
    }
}
