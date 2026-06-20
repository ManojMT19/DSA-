import java.util.*;

class node
{
    int data;
    node next;

    // Constructor with data and next
    node(int data1, node next1)
    {
        data = data1;
        next = next1;
    }

    // Constructor with only data
    node(int data1)
    {
        data = data1;
        next = null;
    }
}

public class J01_intro
{

    public static node ARR_to_LL(ArrayList<Integer> arr)
    {
        node head = new node(arr.get(0));
        node mover = head;

        for (int i = 1; i < arr.size(); i++)
        {
            node temp = new node(arr.get(i));
            mover.next = temp;
            mover = temp;
        }
        return head;
    }

    public static void traversal(node head)
    {
        node temp = head;
        while (temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static int find_length(node head)
    {
        int len = 0;
        node temp = head;
        while (temp != null)
        {
            len++;
            temp = temp.next;
        }
        return len;
    }

    public static boolean search_value(node head, int value)
    {
        node temp = head;
        while (temp != null)
        {
            if (temp.data == value)
            {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public static void main(String[] args)
    {

        ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList(10, 20, 30, 40));

        node y = new node(arr1.get(0), null); // Observe the diff

        node y1 = new node(arr1.get(0), null); // Same in Java (no pointer vs object diff like C++)

        node head = ARR_to_LL(arr1);

        // traversal(head);

        // System.out.println("\nLength : " + find_length(head));

        System.out.println(search_value(head, 30));
    }
}
