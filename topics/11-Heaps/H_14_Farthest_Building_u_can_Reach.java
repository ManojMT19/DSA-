import java.util.PriorityQueue;

public class H_14_Farthest_Building_u_can_Reach // Leetcode 1642
{
    public static int furthestBuilding(int[] heights, int bricks, int ladders)
    {
        int i;
        for (i = 0; i < heights.length - 1; i++)
        {
            if (heights[i + 1] < heights[i])
            {
                continue;
            } else if (bricks >= (heights[i + 1] - heights[i]))
            {
                bricks -= (heights[i + 1] - heights[i]);
            } else if (ladders > 0)
            {
                ladders -= 1;
            } else
            {
                break;
            }
        }
        return i;
        // TC = O(n)
        // SC = O(1)
        // but not correct for all cases
    }

    public static int furthestBuilding_sumne(int[] heights, int bricks, int ladders) // this approch is wrong
    {
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        int n = heights.length;
        int ans = 0;

        for (int i = 0; i < n - 1; i++)
        {
            int diff = heights[i + 1] - heights[i];

            if (diff <= 0)
            {
                ans++;
                continue;
            }
            minheap.offer(diff);
        }

        while (minheap.size() > 0)
        {
            if (bricks >= minheap.peek())
            {
                bricks -= minheap.poll();
                ans++;
            } 
            else if (ladders > 0)
            {
                ans++;
                ladders--;
                minheap.poll();
            }
            else
            {
                break;
            }
        }
        return ans;
    }

    public static int furthestBuilding_optimal(int[] heights, int bricks, int ladders)
    {
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        int n = heights.length;

        for (int i = 0; i < n - 1; i++)
        {
            int diff = heights[i + 1] - heights[i];

            if (diff <= 0)
                continue;

            minheap.offer(diff);
            if (minheap.size() > ladders)
            {
                bricks -= minheap.poll();
            }

            if (bricks < 0)
            {
                return i;
            }

        }
        return n - 1;
        // TC = O(n log ladders)
        // SC = O(ladders)
    }

    
    public static void main(String[] args)
    {
        int h[] = { 4, 2, 7, 6, 9, 14, 12 };
        int brick = 5;
        int ladders = 1;

        int h2[] = { 4, 12, 2, 7, 3, 18, 20, 3, 19 };
        int brick2 = 10;
        int ladders2 = 2;

        int h3[] = { 14, 3, 19, 3 };
        int brick3 = 17;
        int ladders3 = 0;

        System.out.println(furthestBuilding(h, brick, ladders));
        System.out.println(furthestBuilding(h2, brick2, ladders2));
        System.out.println(furthestBuilding(h3, brick3, ladders3));

        System.out.println();
        
        System.out.println(furthestBuilding_optimal(h, brick, ladders));
        System.out.println(furthestBuilding_optimal(h2, brick2, ladders2));
        System.out.println(furthestBuilding_optimal(h3, brick3, ladders3));
        
        System.out.println();
        
        System.out.println(furthestBuilding_sumne(h, brick, ladders));
        System.out.println(furthestBuilding_sumne(h2, brick2, ladders2));
        System.out.println(furthestBuilding_sumne(h3, brick3, ladders3));
    }
}
