import java.util.*;

public class H_05_K_Closest_Point_From_Origin // Leetcode 973
{
    public static int[][] kClosest(int[][] points, int k)
    {
        Arrays.sort(points, (a, b) -> {
            int distA = a[0] * a[0] + a[1] * a[1];
            int distB = b[0] * b[0] + b[1] * b[1];
            return distA - distB;
        });

        int[][] ans = new int[k][2];

        for (int i = 0; i < k; i++)
        {
            ans[i] = points[i];
        }

        return ans;
    }

    public static void KClosest_2(int []nums , int k , int x)
    {
        int[] arr = new int[nums.length];
        int i = 0;
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));

        for(int n : nums)
        {
            arr[i++] = Math.abs(x - n);
        }
        for(int j = 0 ; j < nums.length ; j++)
        {
            maxHeap.add(new int[]{arr[j],nums[j]});

            if(maxHeap.size() > k)
            {
                maxHeap.poll();
            }
        }
        int r[] = new int[maxHeap.size()];
        int z = 0;
        while (maxHeap.size() != 0) 
        {
            r[z++] = maxHeap.poll()[1];    
        }
        
        for(int rr : r)
        {
            System.out.println(rr);
        }
    }

    public static int[][] kClosest_3(int[][] points, int k) 
    {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> {
                int distA = a[0] * a[0] + a[1] * a[1];
                int distB = b[0] * b[0] + b[1] * b[1];

                return Integer.compare(distB, distA);
            }
        );

        for (int p[] : points)
        {
            maxHeap.add(p);
            if (maxHeap.size() > k) 
            {
                maxHeap.poll();    
            }
        }

        int[][] ans = new int[k][2];

        for (int i = 0; i < k; i++)
        {
            ans[i] = maxHeap.poll();
        }
                        
        return ans;    
    }


    public static void main(String[] args) 
    {
        int arr[][] = {{1,3},{-2,2}};
        
        System.out.println(Arrays.deepToString(kClosest_3(arr, 1)));

        int p[] = {8,7,5,6,4,10};
        KClosest_2(p, 3, 7);
    }
}
