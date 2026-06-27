import java.util.HashMap;
import java.util.HashSet;

public class SW_11_No_Substring_Containing_All_3_Chars
{
    public static int numberOfSubstrings_brute(String s)
    {
        int count = 0;
        for (int i = 0; i < s.length(); i++)
        {
            HashSet<Character> set = new HashSet<>();
            for (int j = i; j < s.length(); j++)
            {
                char c = s.charAt(j);
                set.add(c);
                if (set.size() >= 3)
                {
                    count++;
                }
            }
        }

        return count;
    }

    
    public static int func(String s , int n)
    {
        int r = 0;
        int l = 0;
        int total = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        
        while (r < s.length())
        {
            char c = s.charAt(r);
            map.put(c , map.getOrDefault(c, 0) + 1);
            while (map.size() > n) 
            {
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                if(map.get(s.charAt(l)) == 0)
                {
                    map.remove(s.charAt(l));
                }
                l++;
            }
            total = total + r-l+1;
            r++;
        }

        return total;
    }

    public static int numberOfSubstrings(String s)
    {
        return func(s, 3) - func(s, 2);
    }

    public static void main(String[] args)
    {
        String s = "abcabc";

        System.out.println(numberOfSubstrings(s));
    }
}
