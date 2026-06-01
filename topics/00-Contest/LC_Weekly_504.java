import java.util.HashMap;

public class LC_Weekly_504
{
    public static int digitFrequencyScore(int n)
    {
        HashMap<Integer, Integer> freq = new HashMap<>();

        while (n > 0) 
        {
            int digit = n % 10;
            freq.put(digit, freq.getOrDefault(digit, 0) + 1);
            n /= 10;
        }

        int total = 0;

        for(int x : freq.keySet())
        {
            total += (x*freq.get(x));
        }

        return total;
    }

    public static void main(String[] args)
    {
        int xx = digitFrequencyScore(112233);
        System.out.println(xx);
    }
}
