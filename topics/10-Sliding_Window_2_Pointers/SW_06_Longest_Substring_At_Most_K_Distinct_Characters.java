import java.util.*;

public class SW_06_Longest_Substring_At_Most_K_Distinct_Characters
{
    public static int lengthOfLongestSubstringKDistinct_brute(String s, int k)
    {
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++)
        {
            HashSet<Character> set = new HashSet<>();
            for (int j = i; j < s.length(); j++)
            {
                set.add(s.charAt(j));
                if (set.size() > k)
                {
                    break;
                }
                maxLength = Math.max(maxLength, j - i + 1);
            }
        }
        return maxLength;
        // TC = O(N sq)
        // SC = O(k)
    }

    public static int lengthOfLongestSubstringKDistinct_optimal(String s, int k)
    {
        if (k == 0)
            return 0;

        HashMap<Character, Integer> map = new HashMap<>();

        int r = 0;
        int l = 0;
        int maxLength = 0;

        while (r < s.length())
        {
            char ch = s.charAt(r);

            map.put(ch, map.getOrDefault(ch, 0) + 1);

            while (map.size() > k)
            {
                char leftChar = s.charAt(l);
                map.put(leftChar, map.get(leftChar) - 1);

                if (map.get(leftChar) == 0)
                {
                    map.remove(leftChar);
                }

                l++;
            }

            maxLength = Math.max(maxLength, r - l + 1);
            r++;
        }

        return maxLength;
        // TC = O(2n)
        // SC = O(k)
    }

    public static int lengthOfLongestSubstringKDistinct_most_optimal(String s, int k)
    {
        if (k == 0)
            return 0;

        HashMap<Character, Integer> map = new HashMap<>();

        int r = 0;
        int l = 0;
        int maxLength = 0;

        while (r < s.length())
        {
            char ch = s.charAt(r);

            map.put(ch, map.getOrDefault(ch, 0) + 1);

            if(map.size() > k)
            {
                char leftChar = s.charAt(l);
                map.put(leftChar, map.get(leftChar) - 1);

                if (map.get(leftChar) == 0)
                {
                    map.remove(leftChar);
                }

                l++;
            }

            maxLength = Math.max(maxLength, r - l + 1);
            r++;
        }
        return maxLength;
        // TC = O(n)
        // SC = O(k)
    }

    public static void main(String[] args)
    {
        String s = "aaabbccd";
        int k = 2;

        System.out.println(lengthOfLongestSubstringKDistinct_brute(s, k));
        System.out.println(lengthOfLongestSubstringKDistinct_optimal(s, k));
        System.out.println(lengthOfLongestSubstringKDistinct_most_optimal(s, k));
    }

}
