public class SQ17_Find_Town_Judge
{
    public static int findJudge(int n, int[][] trust)
    {
        int[] knowme = new int[n + 1];
        int[] iknow = new int[n + 1];

        for (int i = 0; i < trust.length; i++)
        {
            iknow[trust[i][0]]++;
            knowme[trust[i][1]]++;
        }

        for (int i = 1; i <= n; i++)
        {
            if (knowme[i] == n - 1 && iknow[i] == 0)
            {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args)
    {
        int n = 3;
        int trust[][] = { { 1, 3 }, { 2, 3 } };

        System.out.print(findJudge(n, trust));
    }
}
