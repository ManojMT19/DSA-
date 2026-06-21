import java.util.*;

public class SW_07_Longest_Repeating_Character_Replacement
{
    public static int characterReplacement_brute(String s, int k)
    {
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++)
        {
            int freq[] = new int[26];
            int maxFreq = 0;
            for (int j = i; j < s.length(); j++)
            {
                char c = s.charAt(j);
                freq[c - 'A']++;

                maxFreq = Math.max(maxFreq, freq[c -'A']);
                if (((j - i + 1) - maxFreq) <= k)
                {
                    maxLength = Math.max(maxLength, j - i + 1);
                } 
                else
                {
                    break;
                }
            }
        }
        return maxLength;
    }

    public static int characterReplacement_optimal(String s, int k)
    {
        int maxLength = 0;
        int r = 0;
        int l = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        while (r < s.length())
        {
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
            int maxFreq = Collections.max(map.values());

            int len = r - l + 1;
            if ((len - maxFreq) <= k)
            {
                maxLength = Math.max(maxLength, len);
            } else
            {
                while ((len - maxFreq) > k)
                {
                    map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                    l++;
                    maxFreq = Collections.max(map.values());
                    len = r - l + 1;
                }
                maxLength = Math.max(maxLength, len);
            }
            r++;
        }
        return maxLength;
    }

    public static int characterReplacement_most_optimal(String s, int k)
    {
        int maxLength = 0;
        int r = 0;
        int l = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        while (r < s.length())
        {
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
            int maxFreq = Collections.max(map.values());

            int len = r - l + 1;
            if ((len - maxFreq) <= k)
            {
                maxLength = Math.max(maxLength, len);
            } 
            else
            {
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                l++;
                maxFreq = Collections.max(map.values());
                len = r - l + 1;

                maxLength = Math.max(maxLength, len);
            }
            r++;
        }
        return maxLength;
    }

    public static void main(String[] args)
    {
        // String s = "ABAB";
        // int k = 2;

        String s = "AABABBA";
        int k = 1;

        System.out.println(characterReplacement_brute(s, k));
        System.out.println(characterReplacement_optimal(s, k));
        System.out.println(characterReplacement_most_optimal(s, k));
    }
}
