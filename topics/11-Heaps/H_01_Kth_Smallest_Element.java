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

        System.out.println(FindKthSmallest(p, 3));

    }

}
