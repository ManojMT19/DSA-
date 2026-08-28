public class H_05_Valid_Parenthesis
{
    public static boolean checkValidString_Brute(String s) 
    {
        return func(s, 0, 0);
    }

    public static boolean func(String s , int index , int count)
    {
        if(count < 0)
        {
            return false;
        }
        if(index == s.length())
        {
            return count == 0;
        }
        if(s.charAt(index) == '(')
        {
            return func(s, index + 1, count + 1);
        }
        if(s.charAt(index) == ')')
        {
            return func(s, index + 1, count - 1);
        }
        if(s.charAt(index) == '*')
        {
            if(func(s, index + 1, count + 1) || func(s, index + 1, count - 1) || func(s, index + 1, count))
            {
                return true;
            }
        }
        return false;
        // TC = O(3^N)
        // SC = O(N)
    }
    
    public static boolean checkValidString_optimal(String s) 
    {
        int min = 0;
        int max = 0;

        char ss[] = s.toCharArray();

        for(char c : ss)
        {
            if(c == '(')
            {
                min += 1;
                max += 1;
            }
            else if(c == ')')
            {
                if((min - 1) < 0)
                {
                    min = 0;
                }
                else
                {
                    min -= 1;
                }
                max -= 1;
            }
            else if(c == '*')
            {
                if((min -1) < 0)
                {
                    min = 0;
                }
                else
                {
                    min -= 1;
                }
                max += 1;
            }
            if(max < 0)return false;
        }
        return min == 0;

        // TC = O(N)
        // SC = O(1)
    }
    public static void main(String[] args) 
    {
        String s = "(**)";
        System.out.println(checkValidString_Brute(s));    
        System.out.println(checkValidString_optimal(s));    
    }
}
