import java.util.ArrayList;
import java.util.List;

public class R_28_N_Queens
{
    public static boolean isSafe(int board[][], int row, int col, int n)
    {
        int i, j;
        for (i = 1; i < row; i++)
        {
            if (board[i][col] == 1)
                return false;
        }

        for (i = row, j = col; i >= 1 && j >= 1; i--, j--)
        {
            if (board[i][j] == 1)
                return false;
        }

        for (i = row, j = col; i >= 1 && j <= n; i--, j++)
        {
            if (board[i][j] == 1)
                return false;
        }

        return true;
    }

    public static void print_board(int board[][], int n, List<List<String>> result)
    {
        List<String> temp = new ArrayList<>();

        for (int i = 1; i <= n; i++)
        {
            StringBuilder row = new StringBuilder();
            for (int j = 1; j <= n; j++)
            {
                row.append(board[i][j] == 1 ? 'Q' : '.');
            }
            temp.add(row.toString());
        }
        result.add(temp);
    }

    public static void N_Queens(int board[][], int row, int n, List<List<String>> result)
    {
        if (row > n)
        {
            print_board(board, n, result);
            return;
        }

        for (int col = 1; col <= n; col++)
        {
            if (isSafe(board, row, col, n))
            {
                board[row][col] = 1;
                N_Queens(board, row + 1, n, result);
                board[row][col] = 0;
            }
        }
    }

    public static List<List<String>> solveNQueens(int n)
    {
        List<List<String>> result = new ArrayList<>();

        int board[][] = new int[n+1][n+1];

        N_Queens(board, 1, n, result);

        return result;
    }

    public static void main(String[] args)
    {
        System.out.println(solveNQueens(4));
    }
}
