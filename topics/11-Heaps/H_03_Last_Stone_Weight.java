import java.util.Collections;
import java.util.PriorityQueue;

public class H_03_Last_Stone_Weight // Leetcode 1046
{
    public static int lastStoneWeight(int[] stones) 
    {
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());

        for(int i : stones)
        {
            maxheap.offer(i);
        }

        while (maxheap.size() > 1) 
        {
            int a = maxheap.poll();    
            int b = maxheap.poll();
            
            int c = a - b;
            if(c != 0)
                maxheap.offer(c);
        }
        if (maxheap.size() > 0)
        {
            return maxheap.poll();    
        }
        return 0;
        
        // TC = O(n log n)
        // SC = O(n)
    }

    public static void main(String[] args) 
    {
        int [] stones = {2,4,7,1,8,1};

        System.out.println(lastStoneWeight(stones));
    }
}
