import java.util.*;

public class R_27_Rat_in_Maize
{
    public static void solve(int maze[][], int r , int c ,boolean visited[][] , StringBuilder current ,ArrayList<String>result )
    {
        int n = maze.length;
        if(r == n-1 && c == n-1)
        {
            result.add(current.toString());
            return ;
        }

        visited[r][c] = true;

        if(is_valid(maze, r+1, c, visited, current, result))
        {
            current.append("D");
            solve(maze, r+1, c, visited, current, result);
            current.deleteCharAt(current.length()-1);
        }

        if(is_valid(maze, r-1, c, visited, current, result))
        {
            current.append("U");
            solve(maze, r-1, c, visited, current, result);
            current.deleteCharAt(current.length()-1);
        }

        if(is_valid(maze, r, c+1, visited, current, result))
        {
            current.append("R");
            solve(maze, r, c+1, visited, current, result);
            current.deleteCharAt(current.length()-1);
        }

       if(is_valid(maze, r, c-1, visited, current, result))
        {
            current.append("L");
            solve(maze, r, c-1, visited, current, result);
            current.deleteCharAt(current.length()-1);
        }

        visited[r][c] = false;
    } 

    public static boolean is_valid(int maze[][] , int r ,int c ,boolean visited[][], StringBuilder current , ArrayList<String> result)
    {
        int n = maze.length;
        if(r >= 0 && c >= 0 && c < n && r < n && maze[r][c] == 1 && !visited[r][c])
        {
            return true;
        }
        return false;
    }

    public static ArrayList<String> ratInMaze(int[][] maze) 
    {
        int n = maze.length;
        ArrayList<String> result = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        boolean visited[][] = new boolean[n][n];

        if(maze[0][0] != 1) return result;

        solve(maze, 0, 0, visited, current, result);

        return result;
    }

    public static void main(String[] args) 
    {
        int maze[][] = {{1, 0, 0, 0}, {1, 1, 0, 1}, {1, 1, 0, 0}, {0, 1, 1, 1}};
        
        System.out.println(ratInMaze(maze));
    }
}
