public class SQ16_Celebrity_Problem
{
    public static int celebrity_brute(int mat[][])
    {
        int n = mat.length;

        int knowme[] = new int[n];
        int iknow[] = new int[n];

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (mat[i][j] == 1)
                {
                    knowme[j]++;
                    iknow[i]++;
                }
            }
        }

        for (int i = 0; i < n; i++)
        {
            if (knowme[i] == n - 1 && iknow[i] == 0)
            {
                return i;
            }
        }
        return -1;
        // TC = O(n sq)
        // SC = O(2n)
    }

    public static int celebrity_optimal(int mat[][])
    {
        int n = mat.length;
        int top = 0;
        int down = n-1;

        while (top < down)
        {
            if (mat[top][down] == 1)
            {
                top++;
            } else if (mat[down][top] == 1)
            {
                down--;
            } else
            {
                top++;
                down--;
            }
        }

        if (top > down)
            return -1;

        for (int j = 0; j < n; j++)
        {
            if (top == j)
                continue;

            if (mat[top][j] == 0 && mat[j][top] == 1)
            {

            } else
            {
                return -1;
            }
        }

        return top;
        //TC = O(n)
        //SC = O(1)
    }

    public static void main(String[] args)
    {
        int mat[][] = { { 0, 1, 1, 0 }, { 0, 0, 0, 0 }, { 0, 1, 0, 0 }, { 1, 1, 0, 0 } };

        System.out.println(celebrity_optimal(mat));

    }

}