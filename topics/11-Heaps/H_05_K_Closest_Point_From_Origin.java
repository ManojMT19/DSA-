import java.util.*;

public class H_05_K_Closest_Point_From_Origin
{
    public static int[][] kClosest(int[][] points, int k)
    {
        Arrays.sort(points, (a, b) -> {
            int distA = a[0] * a[0] + a[1] * a[1];
            int distB = b[0] * b[0] + b[1] * b[1];
            return distA - distB;
        });

        int[][] ans = new int[k][2];

        for (int i = 0; i < k; i++)
        {
            ans[i] = points[i];
        }

        return ans;
    }

    public static void main(String[] args) 
    {
        int arr[][] = {{1,3},{-2,2}};
        
        System.out.println(Arrays.deepToString(kClosest(arr, 1)));
    }
}
