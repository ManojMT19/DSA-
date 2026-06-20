import java.util.*;

public class SW_03_Longest_Substring_Without_Repeating
{
    public static int lengthOfLongestSubstring_brute(String s)
    {
        if (s == null || s.length() == 0) return 0;

        int maxlength = 0;
        for (int i = 0; i < s.length(); i++)
        {
            HashMap <Character , Integer> map = new HashMap<>();
            for (int j = i; j < s.length(); j++)
            {
                char c = s.charAt(j);
                
                if (map.containsKey(c)) {
                    break;
                }

                map.put(c, 1);
                
                maxlength = Math.max(maxlength, j - i + 1);
                
            }
        }
        return maxlength;
    }

    public static int lengthOfLongestSubstring_optimal(String s)
    {
        if (s == null || s.length() == 0) return 0;

        int freq[] = new int[256];
        int left = 0;
        int right = 0;
        int maxlength = 0;
        while (right < s.length()) 
        {
            freq[s.charAt(right)]++;
            while (freq[s.charAt(right)] > 1) 
            {
                freq[s.charAt(left)]--;
                left++;    
            }
            maxlength = Math.max(maxlength, right - left + 1);
            right++;
        }
        return maxlength;
        // TC = O(N)
        // SC = O(1)
    }
    public static void main(String[] args) {
        // String s = "abcabcbb";
        String s = " ";

        System.out.println(lengthOfLongestSubstring_optimal(s));
    }
}
