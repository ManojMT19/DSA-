

public class r1
{
    static int fiboNth(int n)
    {
        if (n < 2)
            return n;
        return fiboNth(n - 2) + fiboNth(n - 1);
    }

    static void fibo(int n)
    {
        int a = 0;
        int b = 1;
        for (int i = 0; i <= n; i++)
        {
            int c = a + b;
            System.out.print(a + " ");
            a = b;
            b = c;
        }
    }

    static int search(int[] arr, int target, int start, int end)
    {
        if (start > end)
            return -1;

        int mid = start + (end - start) / 2;
        if (arr[mid] == target)
            return mid;

        if (arr[mid] > target)
            end = mid - 1;
        else
            start = mid + 1;

        return search(arr, target, start, end);
    }

    public static void main(String[] args)
    {
        System.out.println(fiboNth(10));
        fibo(10);

        int[] a = { 1, 2, 33, 40, 55, 74 };
        System.out.println("\n" + search(a, 40, 0, a.length - 1));
    }
}