class Constant_Window
{
    // Maximum Sum
    public static int bruteForce(int[] arr, int k) // Brute Force Approach - O(n*k)
    {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i <= arr.length - k; i++)
        {
            int sum = 0;
            for (int j = i; j < i + k; j++)
            {
                sum += arr[j];
            }
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }

    public static int slidingWindow(int[] arr, int k) // Optimal Sliding Window Approach - O(n)
    {

        int sum = 0;

        // First window
        for (int i = 0; i < k; i++)
        {
            sum += arr[i];
        }

        int maxSum = sum;

        int left = 0;
        int right = k - 1;

        while (right < arr.length - 1)
        {

            sum -= arr[left];
            left++;

            right++;
            sum += arr[right];

            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }
}

class Window_with_operation
{
    public static int bruteForce(int[] arr, int ksum)
    {
        int maxLength = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++)
        {
            int sum = 0;
            for (int j = i; j < n; j++)
            {
                sum += arr[j];
                if (sum <= ksum)
                {
                    maxLength = Math.max(maxLength, j - i + 1);
                } else
                {
                    break;
                }
            }
        }
        return maxLength;
    }

    public static int better(int[] arr, int ksum)
    {
        int l = 0;
        int r = 0;
        int maxLength = 0;
        int sum = 0;

        while (r < arr.length)
        {
            sum += arr[r];

            while (sum > ksum)
            {
                sum -= arr[l++];
            }

            maxLength = Math.max(maxLength, r - l + 1);

            r++;
        }
        return maxLength;
        //TC = O(2N)
        //SC = O(1)
    }

    public static int optimal(int[] arr, int ksum) // This only works only in case of length
    {
        int l = 0;
        int r = 0;
        int maxLength = 0;
        int sum = 0;
        while (r < arr.length)
        {
            sum += arr[r];
            if (sum > ksum) // here instead of deleting the elements we keep the window fixed of that maxlength
            {
                sum -= arr[l];
                l++;
            }
            if (sum <= ksum)
            {
                maxLength = Math.max(maxLength, r - l + 1);
            }

            r++;
        }
        return maxLength;
        //TC = O(N)
        //SC = O(1)
    }

    public static void better_display(int[] arr, int ksum) // here we want to return the subarray not the length so we
                                                           // use better approach not the optimal one
    {
        int l = 0;
        int r = 0;
        int maxLength = 0;
        int sum = 0;

        int start = 0;
        int end = 0;
        while (r < arr.length)
        {
            sum += arr[r];

            while (sum > ksum)
            {
                sum -= arr[l++];
            }

            if (r - l + 1 > maxLength)
            {
                maxLength = r - l + 1;
                start = l;
                end = r;
            }
            r++;
        }
        for (int i = start; i <= end; i++)
        {
            System.out.print(arr[i] + " ");
        }
    }
}

public class SW_01_Intro
{
    public static void main(String[] args)
    {

        int[] arr = { -1, 2, 3, 3, 4, 5, -1 };

        // int k = 4;
        // System.out.println("Brute Force Answer : " + Constant_Window.bruteForce(arr,
        // k));
        // System.out.println("Optimal Answer : " + Constant_Window.slidingWindow(arr,
        // k));

        int ksum = 14;
        System.out.println("Brute Force Answer : " + Window_with_operation.bruteForce(arr, ksum));
        System.out.println("Better Answer      : " + Window_with_operation.better(arr, ksum));
        System.out.println("Optimal Answer     : " + Window_with_operation.optimal(arr, ksum));
        Window_with_operation.better_display(arr, ksum);

    }
}
