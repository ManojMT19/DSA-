import java.util.Stack;

public class SQ13_Largest_Area_Rectangle
{
    public static int[] NSE(int[] heights)
    {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int ans[] = new int[n];

        for (int i = n - 1; i >= 0; i--)
        {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i])
            {
                st.pop();
            }
            ans[i] = !st.isEmpty() ? st.peek() : n;
            st.push(i);
        }
        return ans;
    }

    public static int[] PSE(int[] heights)
    {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int ans[] = new int[n];

        for (int i = 0; i < n; i++)
        {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i])
            {
                st.pop();
            }
            ans[i] = !st.isEmpty() ? st.peek() : -1;
            st.push(i);
        }
        return ans;
    }

    public static int largestRectangleArea(int[] heights)
    {
        int area[] = new int[heights.length];
        int[] pse = PSE(heights);
        int[] nse = NSE(heights);

        for (int i = 0; i < heights.length; i++)
        {
            int left = i - pse[i];
            int right = nse[i] - i;

            area[i] = (left + right - 1) * heights[i];
        }
        int maxi = Integer.MIN_VALUE;

        for (int i = 0; i < area.length; i++)
        {
            if (area[i] > maxi)
            {
                maxi = area[i];
            }
        }
        return maxi;
        // TC = O(N)
        // SC = O(N)
    }

    public static int maximalRectangle(char[][] matrix)
    {
        int[] m = new int[matrix[0].length];
        int maxi = Integer.MIN_VALUE;

        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix[i].length; j++)
            {
                if (matrix[i][j] == '1')
                {
                    m[j] += matrix[i][j] - '0';
                } else
                {
                    m[j] = 0;
                }
            }
            int r = largestRectangleArea(m);
            maxi = Math.max(maxi, r);
        }
        return maxi;
    }

    public static void main(String[] args)
    {
        char[][] matrix = {{'1','0','1','0','0'}, {'1','0','1','1','1'}, {'1','1','1','1','1'},{'1','0','0','1','0' }};
        int x = maximalRectangle(matrix);
        System.out.println(x);

    }
}
