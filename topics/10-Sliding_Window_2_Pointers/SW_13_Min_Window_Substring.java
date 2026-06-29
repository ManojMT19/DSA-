import java.sql.Time;
import java.util.HashMap;

public class SW_13_Min_Window_Substring
{
    public static String minWindow_brute(String s, String t)
    {
        int n = s.length();

        if (n < t.length())
            return "";

        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : t.toCharArray())
        {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        String ans = "";

        for (int i = 0; i < n; i++)
        {

            for (int j = i; j < n; j++)
            {

                HashMap<Character, Integer> tempMap = new HashMap<>(map);

                for (int k = i; k <= j; k++)
                {
                    char ch = s.charAt(k);

                    if (tempMap.containsKey(ch))
                    {
                        tempMap.put(ch, tempMap.get(ch) - 1);

                        if (tempMap.get(ch) == 0)
                        {
                            tempMap.remove(ch);
                        }
                    }
                }

                if (tempMap.isEmpty())
                {
                    String temp = s.substring(i, j + 1);// here we using j+1 bcz substring func excludes the lastindex

                    if (ans.equals("") || temp.length() < ans.length())
                    {
                        ans = temp;
                    }
                }
            }
        }

        return ans;
        // TC : O(n² × (n + m)) ≈ O(n³)
        // SC : O(m)
    }

    public static String minWindow_optimal(String s, String t)
    {
        int n = s.length();

        if (n < t.length())
            return "";

        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : t.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        int l = 0, r = 0;
        int count = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        while (r < s.length())
        {

            char ch = s.charAt(r);

            if (map.containsKey(ch))
            {
                map.put(ch, map.get(ch) - 1);

                if (map.get(ch) >= 0)
                    count++;
            }

            while (count == t.length())
            {

                if (r - l + 1 < minLen)
                {
                    minLen = r - l + 1;
                    start = l;
                }

                char left = s.charAt(l);

                if (map.containsKey(left))
                {
                    map.put(left, map.get(left) + 1);

                    if (map.get(left) > 0)
                        count--;
                }

                l++;
            }

            r++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }

    public static void main(String[] args)
    {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        String s1 = "bba";
        String t1 = "ab";

        System.out.println(minWindow_brute(s, t));
        System.out.println(minWindow_brute(s1, t1));

        System.out.println(minWindow_optimal(s, t));
        System.out.println(minWindow_optimal(s1, t1));


    }
}
