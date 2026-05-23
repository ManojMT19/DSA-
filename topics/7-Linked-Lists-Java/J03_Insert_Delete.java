import java.util.*;

class Node
{
    int data;
    Node next;

    Node(int data1)
    {
        data = data1;
        next = null;
    }

    Node(int data1, Node next1)
    {
        data = data1;
        next = next1;
    }
}

public class J03_Insert_Delete
{

    static Node ARR_to_LL(int[] arr)  
    {
        if (arr.length == 0)
            return null;

        Node head = new Node(arr[0]);
        Node mover = head;

        for (int i = 1; i < arr.length; i++)
        {
            mover.next = new Node(arr[i]);
            mover = mover.next;
        }
        return head;
    }

    // ---------------- REMOVE ----------------

    static Node remove_head(Node head)
    {
        if (head == null)
            return null;
        return head.next; // cleaner (Java GC handles memory)
    }

    static Node remove_last(Node head)
    {
        if (head == null || head.next == null)
            return null;

        Node temp = head;
        while (temp.next.next != null)
        {
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }

    static Node remove_kth(Node head, int k)
    {
        if (head == null || k <= 0)
            return head; // FIX: invalid k handling

        if (k == 1)
            return head.next;

        Node temp = head;
        Node prev = null;
        int count = 0;

        while (temp != null)
        {
            count++;
            if (count == k)
            {
                if (prev != null)
                    prev.next = temp.next; // FIX: safe linking
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }

    static Node remove_element(Node head, int ele)
    {
        if (head == null)
            return null;

        if (head.data == ele)
            return head.next;

        Node temp = head;
        Node prev = null;

        while (temp != null)
        {
            if (temp.data == ele)
            {
                if (prev != null)
                    prev.next = temp.next; // FIX: safe unlink
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }

    // ---------------- INSERT ----------------

    static Node insert_front(Node head, int ele)
    {
        return new Node(ele, head);
    }

    static Node insert_last(Node head, int ele)
    {
        if (head == null)
            return new Node(ele);

        Node mover = head;
        while (mover.next != null)
        {
            mover = mover.next;
        }
        mover.next = new Node(ele);
        return head;
    }

    // ✅ CONSOLIDATED: insert BEFORE kth (clear definition)
    static Node insert_kth(Node head, int k, int ele)
    {

        if (k <= 0)
            return head; // FIX: invalid position

        if (k == 1)
            return new Node(ele, head);

        if (head == null)
            return null; // FIX: cannot insert at position >1

        Node temp = head;
        int cnt = 0;

        while (temp != null)
        {
            cnt++;
            if (cnt == k - 1)
            {
                temp.next = new Node(ele, temp.next);
                return head;
            }
            temp = temp.next;
        }

        // FIX: if k == length + 1 → insert at end
        if (cnt == k)
        {
            return insert_last(head, ele);
        }

        return head; // FIX: if k > length + 1 → ignore
    }

    static Node insert_before_value(Node head, int before_value, int ele)
    {
        if (head == null)
            return null;

        if (head.data == before_value)
        {
            return new Node(ele, head);
        }

        Node temp = head;

        // FIX: prevent NullPointerException (temp.next check)
        while (temp.next != null)
        {
            if (temp.next.data == before_value)
            {
                temp.next = new Node(ele, temp.next);
                return head;
            }
            temp = temp.next;
        }

        return head; // FIX: value not found → no change
    }

    // ---------------- DISPLAY ----------------

    static void display(Node head)
    {
        Node temp = head;
        while (temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args)
    {

        int[] arr = { 10, 20, 30, 40, 50, 60, 70 };

        Node head = ARR_to_LL(arr);

        head = insert_before_value(head, 70, 500);

        display(head);
    }
}