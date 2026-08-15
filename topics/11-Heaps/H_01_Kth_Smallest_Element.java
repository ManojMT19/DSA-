import java.util.*;

public class H_01_Kth_Smallest_Element
{
    public static int FindKthSmallest(int[] s, int k)
    {
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < s.length; i++)
        {
            maxheap.add(s[i]);

            if (maxheap.size() > k)
            {
                maxheap.poll();
            }
        }
        return maxheap.peek();
    }

    public static int maximumLengthSubstring(String s) // this is substring sliding problem totally unrelated to heaps
    {
        int k = 2;
        int l = 0;
        int r = 0;
        int maxLength = 0;
        HashMap<Character, Integer> freq = new HashMap<>();

        while (r < s.length())
        {
            char c = s.charAt(r);
            freq.put(c, freq.getOrDefault(c, 0) + 1);

            while (freq.get(c) > k)
            {
                char cc = s.charAt(l++);
                freq.put(cc, freq.get(cc) - 1);
                if (freq.get(cc) == 0)
                {
                    freq.remove(cc);
                }
            }

            maxLength = Math.max(maxLength, r - l + 1);

            r++;
        }
        return maxLength;
    }



    public static void main(String[] args)
    {
        int[] p = { 7, 10, 4, 3, 20, 15 };

        // int n = p.length;
        // Arrays.sort(p);
        // System.out.println(p[2]);
        // System.out.println(Arrays.toString(p));

        // System.out.println(FindKthSmallest(p, 3));

    }

}

/*
 * 
 * Here are the most frequently asked Heap (Priority Queue) problems on
 * LeetCode, categorized by difficulty and pattern. 
 * These are the "must-solve" problems often found in technical interview blind lists (like Blind 75 or
 * Grind 75). [1, 2, 3] ## 1. Top K Elements Pattern
 * 
 * LeetCode 215 - Kth Largest Element in an Array (Medium) 
 * LeetCode 347 - Top K Frequent Elements (Medium) LeetCode 692 - Top K Frequent Words (Medium)
 * LeetCode 973 - K Closest Points to Origin (Medium) 
 * LeetCode 703 - Kth Largest Element in a Stream (Easy) [4, 5, 6, 7, 8]
 * 
 * ## 2. Merge K Sorted Lists / Streams Pattern
 * 
 * LeetCode 23 - Merge k Sorted Lists (Hard) 
 * LeetCode 378 - Kth Smallest Element in a Sorted Matrix (Medium) 
 * LeetCode 373 - Find K Pairs with Smallest Sums (Medium) [9, 10, 11, 12, 13]
 * 
 * ## 3. Two Heaps Pattern (Tracking Median)
 * 
 * LeetCode 295 - Find Median from Data Stream (Hard) LeetCode 480 - Sliding
 * Window Median (Hard) [14, 15, 16]
 * 
 * ## 4. Greedy Scheduling / Optimization Pattern
 * 
 * LeetCode 621 - Task Scheduler (Medium) LeetCode 502 - IPO (Hard) LeetCode
 * 1834 - Single-Threaded CPU (Medium) LeetCode 1405 - Longest Happy String
 * (Medium) [17, 18]
 * 
 * ## 5. Array / Game Simulation
 * 
 * LeetCode 1046 - Last Stone Weight (Easy) LeetCode 1962 - Remove Stones to
 * Minimize the Total (Medium) [19, 20]
 * 
 * 
 */


/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */