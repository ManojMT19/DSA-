import java.util.ArrayList;

public class r3
{
    static void sorted(int arr[], int i)
    {
        if (i != arr.length - 1)
        {
            if (arr[i] < arr[i + 1])
            {
                sorted(arr, i + 1);
            } else
            {
                System.out.println("Not Sorted");
                return;
            }
        } else
        {
            System.out.println("Sorted");
            return;
        }
    }

    static boolean sorted_bool(int arr[], int i)
    {
        if (i == arr.length - 1)
            return true;

        if (arr[i] > arr[i + 1])
            return false;

        return sorted_bool(arr, i + 1);
    }

    static int linearSearch_or_find(int arr[], int target, int i)
    {
        if (i == arr.length)
        {
            System.out.println("Target NOT Found ");
            return -1;
        }
        if (arr[i] == target)
        {
            System.out.println("Target Found ");
            return i;
        }
        return linearSearch_or_find(arr, target, i + 1);
    }

    static int find_index_from_last(int arr[], int target, int i)
    {
        if (i < 0)
            return -1;

        if (arr[i] == target)
            return i;

        return find_index_from_last(arr, target, i - 1);
    }

    static ArrayList<Integer> find_all_index(int arr[], int target, int i, ArrayList<Integer> list)
    {
        if (i == arr.length)
            return list;

        if (arr[i] == target)
        {
            list.add(i);
        }
        return find_all_index(arr, target, i + 1, list);
    }

    static ArrayList<Integer> find_all_index_2(int arr[], int target, int i)
    {
        ArrayList<Integer> list = new ArrayList<>();
        if (i == arr.length)
            return list;

        if (arr[i] == target)
        {
            list.add(i);
        }
        ArrayList<Integer> ansfromBelowCalss = find_all_index_2(arr, target, i + 1);
        list.addAll(ansfromBelowCalss);
        return list;
    }

    static void start_Pat_1(int row, int col, int n)
    {
        if (row == n)
            return;
        // if(col == n-row )return;

        else if(col != n - row)
        {
            System.out.print("* ");
            // start_Pat_1(row, col++, n);
        }
        System.out.println();

        start_Pat_1(row + 1, col, n);
    }

    static void print_col(int col)
    {
        if(col == 0)return;
        System.out.print("* ");
        print_col(col - 1);
    }
    static void inverted_triangle(int n)
    {
        if(n == 0)return;
        print_col(n);
        System.out.println();

        inverted_triangle(n-1);
    }

    static void normal_triangle(int n)
    {
        if(n == 0)return;
        normal_triangle(n-1);
        System.out.println();
        print_col(n);
    }

    public static void main(String[] args)
    {
        // int arr[] = { 1, 2, 3, 4, 4, 5, 6 };

        // sorted(arr, 0);

        // System.out.println(sorted_bool(arr, 0) ? "Sorted" : "Not Sorted");

        // int r = linearSearch_or_find(arr, 6, 0);
        // System.out.println(r);

        // int x = find_index_from_last(arr, 4, 5);
        // System.out.println(x);

        // System.out.println(find_all_index(arr, 4 ,0, new ArrayList<>()));

        // System.out.println(find_all_index_2(arr, 4, 0));

        // start_Pat_1(0, 5, 5);

        inverted_triangle(5);

        System.out.println();

        normal_triangle(5);

    }
}
