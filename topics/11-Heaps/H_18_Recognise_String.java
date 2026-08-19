import java.util.PriorityQueue;

public class H_18_Recognise_String // Leetcode 767
{
    public static String reorganizeString_optimal(String s)
    {
        int freq[] = new int[26];

        for (char c : s.toCharArray())
        {
            freq[c - 'a']++;
        }

        int n = s.length();
        for (int f : freq)
        {
            if (f > (n + 1) / 2)
                return ""; // feasibility check
        }

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));

        for (int i = 0; i < 26; i++)
        {
            if (freq[i] > 0)
            {
                maxHeap.offer(new int[] { i, freq[i] });
            }
        }

        StringBuilder result = new StringBuilder();
        int []prev = null;

        while (!maxHeap.isEmpty())
        {
            int[] current = maxHeap.poll();

            result.append((char) (current[0] + 'a'));
            current[1]--;

            if(prev != null && prev[1] > 0)
            {
                maxHeap.offer(prev);
            }

            prev = current;
        }

        for (int i = 1; i < result.length(); i++)
        {
            if (result.charAt(i) == result.charAt(i - 1))
            {
                return "";
            }
        }
        return result.toString();
    }

    public static void main(String[] args)
    {
        String s = "aabb";

        System.out.println(reorganizeString_optimal(s));
    }
}
