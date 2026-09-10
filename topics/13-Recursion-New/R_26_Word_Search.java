public class R_26_Word_Search
{
    public static boolean solve(char board[][], String word)
    {
        for (int row = 0; row < board.length; row++)
        {
            for (int col = 0; col < board[row].length; col++)
            {
                if (dfs(board, word, row, col, 0))
                    return true;
            }
        }
        return false;
    }

    public static boolean dfs(char board[][], String word, int r, int c, int idx)
    {
        if (idx == word.length())
            return true;

        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != word.charAt(idx))
        {
            return false;
        }

        char temp = board[r][c];
        board[r][c] = '#';

        boolean found =    dfs(board, word, r + 1, c, idx + 1)     
                        || dfs(board, word, r - 1, c, idx + 1)
                        || dfs(board, word, r, c + 1, idx + 1) 
                        || dfs(board, word, r, c - 1, idx + 1);

        board[r][c] = temp;

        return found;
    }

    public static boolean exist(char[][] board, String word)
    {
        return solve(board, word);
    }

    public static void main(String[] args)
    {
        char board[][] = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };

        String word = "ABCCED";

        System.out.println(exist(board, word));

    }
}
