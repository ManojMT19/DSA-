import java.util.*;

public class H_13_Find_K_pairs_with_Smallest_SUm // Leetcode 373
{
 
    public static List<List<Integer>> kSmallestPairs_Brute(int[] nums1, int[] nums2, int k) 
    {
        List<List<Integer>> result =  new ArrayList<>();
        PriorityQueue<int[]> maxheap = new PriorityQueue<>((a,b) -> Integer.compare(b[0], a[0]));

        for (int i = 0; i < nums1.length; i++)
        {
            for (int j = 0; j < nums2.length; j++)
            {
                int sum = nums1[i] + nums2[j];
                maxheap.offer(new int[]{sum , nums1[i] , nums2[j]});

                if (maxheap.size() > k)
                {
                    maxheap.poll(); 
                }
            }
        }

        for (int i = 0; i < k; i++)
        {
            List<Integer> temp = new ArrayList<>();
            int data[] = maxheap.poll();
            temp.add(data[1]);
            temp.add(data[2]);
            result.add(temp);
        }

        return result.reversed();
    }

    
    public static List<List<Integer>> kSmallestPairs_optimal(int[] nums1, int[] nums2, int k)
    {
        List<List<Integer>> result =  new ArrayList<>();
        PriorityQueue<int[]> minheap = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));

        for (int i = 0; i < nums1.length && i < k; i++)
        {
            int sum = nums1[i] + nums2[0];
            minheap.offer(new int[]{sum ,i ,0});
        }

        while (k > 0 && minheap.size() > 0) 
        {
            int data[] = minheap.poll();
            int i = data[1];    
            int j = data[2];

            result.add(Arrays.asList(nums1[i],nums2[j]));
            
            if (j + 1 < nums2.length) 
            {
                int sum = nums1[i]+nums2[j+1];
                minheap.offer(new int[]{sum , i , j+1});
            }
            k--;
        }

        return result;
    }

    public static void main(String[] args) 
    {
        int n1[] = {1,7,11};
        int n2[] = {2,4,6};
        
        System.out.println(kSmallestPairs_optimal(n1, n2, 3));
    }
}