import java.util.HashMap;

public class LC_Weekly_503
{
    public int[] limitOccurrences(int[] nums, int k) 
    {
        HashMap<Integer , Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++)
        {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for (int n : map.keySet()) 
        {
            if(map.get(n) > k)
            {
                map.put(n, k);
            }
        }

        for(int i = 0 ; i < nums.length ; i++)
        {
            nums[i] = map.get(key);
        }

        return nums;
        
    }
    public int passwordStrength(String password)
    {
        int upper = 0;
        int lower = 0;
        int number = 0;
        int special = 0;

        for (int i = 0; i < password.length(); i++)
        {
            char ch = password.charAt(i);

            if (ch >= 'A' && ch <= 'Z')
            {
                upper++;
            } else if (ch >= 'a' && ch <= 'z')
            {
                lower++;
            } else if (ch >= '0' && ch <= '9')
            {
                number++;
            } else
            {
                special++;
            }
        }

        int sum = 0 ;
        sum = sum + (upper * 2);
        sum = sum + (lower * 1);
        sum = sum + (number * 3);
        sum = sum + (special * 5);

        return sum;

    }

    public static void main(String[] args)
    {
        LC_Weekly_503  obj = new LC_Weekly_503();
        String password = "aA1!";
        int res = obj.passwordStrength(password);

        System.out.println(res);
    }
}