import java.util.*;

public class H_04_Kth_Smallest_Element_in_Matrix // Leetcode 378
{
    public static int kthSmallest_Brute(int[][] matrix, int k)
    {
        int n = matrix.length;
        int ans[] = new int[n * n];
        int x = 0;

        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix[i].length; j++)
            {
                ans[x++] = matrix[i][j];
            }
        }

        Arrays.sort(ans);

        return ans[k - 1];
    }
 
    public static int kthSmallest_better(int[][] matrix, int k)  // using technique B
    {
        // Box B: treat matrix as one unsorted pile, keep best-k-smallest, evict worst
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int[] row : matrix)
        {
            for (int val : row)
            {
                maxHeap.offer(val);

                if (maxHeap.size() > k)
                {
                    maxHeap.poll();
                }
            }
        }

        return maxHeap.peek(); 
    }

    public static int kthSmallest_optimal(int[][] matrix, int k) // using technique A
    {
        /*
         * Insert first element of every row into Min Heap as {value, row, col}. Heap
         * top gives the smallest current element. Remove (poll) the smallest element
         * and decrease k. Push the next element from the same row (col + 1) into the
         * heap. Repeat until k = 1, then heap top is the answer.
         */

        int n = matrix.length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));  // min heap (smallest on top)

        // (a, b) -> Integer.compare(b[0], a[0]) // max heap (largest on top)

        for (int i = 0; i < n; i++)
        {
            pq.offer(new int[] { matrix[i][0], i, 0 });
        }

        while (k > 1)
        {

            int[] curr = pq.poll();

            int row = curr[1];
            int col = curr[2];

            if (col + 1 < n)
            {
                pq.offer(new int[] { matrix[row][col + 1], row, col + 1 });
            }

            k--;
        }

        return pq.peek()[0];
    }

    public static void main(String[] args)
    {
        int arr[][] = { { 1, 9, 91 }, { 10, 11, 13 }, { 12, 19, 33 } };

        System.out.println(kthSmallest_Brute(arr, 8));
        System.out.println(kthSmallest_better(arr, 8));
        System.out.println(kthSmallest_optimal(arr, 8));
    }
}