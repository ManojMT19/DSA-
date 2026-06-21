import java.util.*;

public class SW_05_Fruits_Into_Baskets
{
    public static int totalFruit_brute(int[] fruits)
    {
        int maxLen = 0;

        for (int i = 0; i < fruits.length; i++)
        {
            HashSet<Integer> set = new HashSet<>();
            for (int j = i; j < fruits.length; j++)
            {

                set.add(fruits[j]);

                if (set.size() > 2)
                {
                    break;
                }
                maxLen = Math.max(maxLen, j - i + 1);
            }
        }

        return maxLen;
        // TC = O(N sq)
        // SC = O(3)
    }

    public static int totalFruit_optimal(int[] fruits)
    {
        int maxlength = 0;
        int l = 0;
        int r = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        while (r < fruits.length)
        {
            map.put(fruits[r], map.getOrDefault(fruits[r], 0) + 1);
            if (map.size() > 2)
            {
                while (map.size() > 2)
                {
                    map.put(fruits[l], map.get(fruits[l]) - 1);
                    if (map.get(fruits[l]) == 0)
                    {
                        map.remove(fruits[l]);
                    }
                    l++;

                }
            }
            maxlength = Math.max(maxlength, r - l + 1);
            r++;
        }
        return maxlength;
        // TC = O(2N)
        // SC = O(3)
    }

    public static int totalFruit_most_optimal(int[] fruits)
    {
        int maxlength = 0;
        int l = 0;
        int r = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        while (r < fruits.length)
        {
            map.put(fruits[r], map.getOrDefault(fruits[r], 0) + 1);
            if (map.size() > 2)
            {
                map.put(fruits[l], map.get(fruits[l]) - 1);
                if (map.get(fruits[l]) == 0)
                {
                    map.remove(fruits[l]);
                }
                l++;
            }
            maxlength = Math.max(maxlength, r - l + 1);
            r++;
        }
        return maxlength;
        // TC = O(N)
        // SC = O(1)
    }

    public static void main(String[] args)
    {
        int fruits[] = { 1, 1, 2, 3, 2, 2 };

        System.out.println(totalFruit_brute(fruits));
        System.out.println(totalFruit_optimal(fruits));
        System.out.println(totalFruit_most_optimal(fruits));
    }
}
