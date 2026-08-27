import java.util.*;

public class sumne
{
    public static int[] topKFrequent(int[] nums, int k)
    {
        Map<Integer, Integer> freq = new TreeMap<>(Collections.reverseOrder());

        for (int i : nums)
        {
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(freq.entrySet());

        list.sort((a, b) -> b.getValue() - a.getValue());

        int[] arr = new int[k];

        for (int i = 0; i < k; i++)
        {
            arr[i] = list.get(i).getKey();
        }
        return arr;
    }

    public static void main(String[] args)
    {
        int[] nums = { 1, 2, 1, 2, 1, 2, 3, 1, 3, 2 };

        int r[] = topKFrequent(nums, 2);

        for (int j : r)
        {
            System.out.println(j);
        }
    }
}
