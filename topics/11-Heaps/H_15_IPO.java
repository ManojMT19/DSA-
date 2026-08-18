import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class H_15_IPO // Leetcode 502 
{
    public static int findMaximizedCapital_Brute(int k, int w, int[] profits, int[] capital)
    {
        int n = profits.length;
        boolean used[] = new boolean[n];

        for (int round = 0; round < k; round++)
        {
            int bestProfit = -1;
            int bestIdx = -1;

            for (int i = 0; i < n; i++)
            {
                if (!used[i] && capital[i] <= w && bestProfit < profits[i])
                {
                    bestProfit = profits[i];
                    bestIdx = i;
                }
            }

            if(bestIdx == -1)break;

            used[bestIdx] = true;
            w += profits[bestIdx];
        }
        return w;
        // TC = O(k . n)
        // SC = O(n)
    }
    
    public static int findMaximizedCapital_Optimal(int k, int w, int[] profits, int[] capital)
    {
        int n = profits.length;

        int [][] projects = new int[n][2];
        for(int i = 0 ; i < n ; i++)
        {
            projects[i][0] = capital[i];
            projects[i][1] = profits[i];
        }

        Arrays.sort(projects,(a,b) -> a[0]-b[0]);

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        int ptr = 0;
        for(int round = 0 ; round < k ; round++)
        {
            while (ptr < n && projects[ptr][0] <= w) 
            {
                maxHeap.offer(projects[ptr][1]);
                ptr++;
            }

            if(maxHeap.isEmpty()) break;

            w += maxHeap.poll();
        }
        return w;

        // TC = O(n log n) + O(n log n)    
        // SC = O(n)
    }

    public static void main(String[] args) 
    {
        int []profits = {1,2,3};
        int []capital = {0,1,1};
        int k = 2;
        int w = 0;

        System.out.println(findMaximizedCapital_Brute(k, w, profits, capital));
        System.out.println(findMaximizedCapital_Optimal(k, w, profits, capital));

    }


}