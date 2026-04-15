public class longest_string_with_unique_charac
{
    public static int lengthOfLongestSubstring(String s) 
    {
        int freq[] = new int[256];
        int maxlength = 0 , left = 0;

        for (int right = 0; right < s.length(); right++)
        {
            freq[s.charAt(right)]++;
            
            while (freq[s.charAt(right)] > 1) 
            {
                freq[s.charAt(left)]--;
                left++;
            }

            maxlength = Math.max(maxlength, right - left + 1);
        }
        return maxlength;
    }

    public static void main(String[] args)
    {
        String s = "abcabcbb";
        
        System.out.println(lengthOfLongestSubstring(s));
    }
}
