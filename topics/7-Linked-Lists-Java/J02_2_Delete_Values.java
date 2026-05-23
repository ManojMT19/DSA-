import java.util.*;

class ListNode
{
    int val;
    ListNode next;

    ListNode()
    {
        val = 0;
        next = null;
    }

    ListNode(int x)
    {
        val = x;
        next = null;
    }

    ListNode(int x, ListNode nextNode)
    {
        val = x;
        next = nextNode;
    }
}

public class J02_2_Delete_Values
{

    static ListNode ARR_to_LL(int[] arr)
    {
        if (arr.length == 0)
            return null;

        ListNode head = new ListNode(arr[0]);
        ListNode mover = head;

        for (int i = 1; i < arr.length; i++)
        {
            ListNode temp = new ListNode(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }

    static void display(ListNode head)
    {
        ListNode temp = head;
        while (temp != null)
        {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Leetcode 203
    static ListNode removeElements(ListNode head, int val)
    {
        if (head == null)
            return null;

        if (head.val == val)
        {
            return removeElements(head.next, val);
        }

        ListNode temp = head;
        ListNode prev = null;

        while (temp != null)
        {
            if (temp.val == val)
            {
                prev.next = temp.next;
                return removeElements(head, val);
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }

    // Brute force reverse
    static ListNode reverseList_Brute(ListNode head)
    {
        ListNode t1 = head;
        ArrayList<Integer> list = new ArrayList<>();

        while (t1 != null)
        {
            list.add(t1.val);
            t1 = t1.next;
        }

        t1 = head;
        for (int i = list.size() - 1; i >= 0; i--)
        {
            t1.val = list.get(i);
            t1 = t1.next;
        }

        return head;
    }

    // Iterative reverse
    static ListNode reverseList_Iterative(ListNode head)
    {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null)
        {
            ListNode front = curr.next;
            curr.next = prev;
            prev = curr;
            curr = front;
        }

        return prev;
    }

    // Recursive reverse
    static ListNode reverseList_Recursion(ListNode head)
    {
        if (head == null || head.next == null)
            return head;

        ListNode newHead = reverseList_Recursion(head.next);
        ListNode front = head.next;

        front.next = head;
        head.next = null;

        return newHead;
    }

    public static void main(String[] args)
    {
        int[] arr = { 1, 2, 3, 4, 5 };

        ListNode head = ARR_to_LL(arr);

        head = reverseList_Iterative(head);

        display(head);
    }
}