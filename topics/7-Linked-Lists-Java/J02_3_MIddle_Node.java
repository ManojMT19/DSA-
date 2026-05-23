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

public class J02_3_MIddle_Node
{

    // Brute force (2 passes)
    static ListNode middleNode_brute(ListNode head)
    {
        if (head == null)
            return null;

        int count = 0;
        ListNode temp = head;

        while (temp != null)
        {
            count++;
            temp = temp.next;
        }

        int a = (count / 2) + 1;

        temp = head;
        while (temp != null)
        {
            a--;
            if (a == 0)
                break;
            temp = temp.next;
        }

        return temp;
    }

    // Optimal (slow-fast pointer)
    static ListNode middleNode_optimal(ListNode head)
    {
        if (head == null)
            return null;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void main(String[] args)
    {
        // optional test
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        ListNode mid = middleNode_optimal(head);

        System.out.println(mid.val); // expected 3
    }
}