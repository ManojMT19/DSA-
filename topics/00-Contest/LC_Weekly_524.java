import java.util.*;

public class LC_Weekly_524
{
    public int minDeletions(int[] nums)
    {
        int count = 0;
        int last = nums[0];

        for (int i = 1; i < nums.length; i++)
        {
            if (nums[i] == last)
            {
                count++;
            } else
            {
                last = nums[i];
            }
        }

        return count;
    }

    public int[] lastVisitedCell(char[][] grid)
    {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];

        int r = 0, c = 0;
        visited[0][0] = true;

        while (true)
        {
            char ch = grid[r][c];

            int nr = r, nc = c;

            if (ch == 'L')
                nc--;
            else if (ch == 'R')
                nc++;
            else if (ch == 'U')
                nr--;
            else if (ch == 'D')
                nr++;

            if (nr < 0 || nr >= m || nc < 0 || nc >= n)
                break;

            if (visited[nr][nc])
                break;

            r = nr;
            c = nc;
            visited[r][c] = true;
        }

        return new int[] { r, c };
    }

    public int findRoot(int[][] edges, String colors)
    {
        int n = edges.length + 1; // a tree with n nodes always has exactly n - 1 edges

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++)
        {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges)
        {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        for (int root = 0; root < n; root++)
        {
            if (isValid(root, n, adj, colors))
            {
                return root;
            }
        }

        return -1;
    }

    private boolean isValid(int root, int n, List<List<Integer>> adj, String colors)
    {
        boolean[] visited = new boolean[n];
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[] { root, -1, 0 });
        visited[root] = true;

        while (!queue.isEmpty())
        {
            int[] curr = queue.poll();

            int node = curr[0];
            int parent = curr[1];
            int depth = curr[2];

            int expected = colors.charAt(root) == 'R' ? 0 : colors.charAt(root) == 'B' ? 1 : 2;

            int actual = colors.charAt(node) == 'R' ? 0 : colors.charAt(node) == 'B' ? 1 : 2;

            if (actual != (expected + depth) % 3)
            {
                return false;
            }

            int children = 0;

            for (int next : adj.get(node))
            {
                if (next == parent)
                {
                    continue;
                }

                children++;

                if (children > 2 || visited[next])
                {
                    return false;
                }

                visited[next] = true;
                queue.offer(new int[] { next, node, depth + 1 });
            }
        }

        return true;
    }

}