import java.util.Stack;

public class SQ12_Area_Rectangle_Histogram
{
    public static int[] NSE(int []heights)
    {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int ans[] = new int[n];

        for (int i = n-1; i >= 0 ; i--)
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
    public static int[] PSE(int []heights)
    {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int ans[] = new int[n];

        for (int i = 0; i < n ; i++)
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
        int []pse = PSE(heights);
        int []nse = NSE(heights);

        for (int i = 0; i < heights.length; i++)
        {
            int left = i - pse[i];
            int right = nse[i] - i;

            area[i] = (left + right - 1) * heights[i];
        }
        int maxi = Integer.MIN_VALUE;

        for (int i = 0; i < area.length; i++)
        {
            if(area[i] > maxi)
            {
                maxi = area[i];
            }
        }
        return maxi;
        //TC = O(N)
        //SC = O(N)
    }

    // public static int largestRectangleArea_optimal(int[] heights)
    // {
                    //Optimal soln not written bcz i didnt understood
    // }


    public static void main(String[] args) {
        // int []h = {2,1,5,6,2,3};
        int []h = {2,1,5,6,6,3};
        
        System.out.println(largestRectangleArea(h));
    }

}