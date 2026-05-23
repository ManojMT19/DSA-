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

public class J04_Loop_LL
{
    // ---------------- BRUTE (using HashMap) ----------------
    static boolean hasCycle_brute(ListNode head)
    {
        HashMap<ListNode, Integer> map = new HashMap<>();

        ListNode temp = head;

        while (temp != null)
        {
            if (map.containsKey(temp))
            {
                return true;
            }
            map.put(temp, 1);
            temp = temp.next;
        }
        return false;
    }

    // ---------------- OPTIMAL (Floyd's Cycle Detection) ----------------
    static boolean hasCycle_optimal(ListNode head)
    {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
            {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args)
    {
        
    }
}
