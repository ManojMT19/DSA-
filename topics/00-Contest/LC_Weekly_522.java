public class LC_Weekly_522
{
    public static int minRotations(String s) // leetcode 4070
    {
        int current = 0;
        int total = 0;

        for (char ch : s.toCharArray())
        {
            int target = ch - '0';

            int diff = Math.abs(current - target);
            int rotations = Math.min(diff, 10 - diff);

            total += rotations;
            current = target;
        }

        return total;
    }

    public static void main(String[] args)
    {
        String s = "0192837465";

        System.out.println(minRotations(s));
    }
}
