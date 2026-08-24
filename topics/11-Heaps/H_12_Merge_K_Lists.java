import java.util.*;

public class H_12_Merge_K_Lists //Leetcode 23
{
    public ListNode mergeKLists_brute(ListNode[] lists)
    {
        List<Integer> values = new ArrayList<>();

        for (ListNode node : lists)
        {
            while (node != null)
            {
                values.add(node.val);
                node = node.next;
            }
        }

        Collections.sort(values);

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        for (int val : values)
        {
            curr.next = new ListNode(val);
            curr = curr.next;
        }

        return dummy.next;
        // TC: O(N log N)
        // SC: O(N)
    }

    
    public ListNode mergeKLists_optimal(ListNode[] lists)
    {
        if(lists == null || lists.length == 0)return null;

        PriorityQueue<ListNode> minheap = new PriorityQueue<>((a,b) ->  a.val - b.val);

        for(ListNode node : lists)
        {
            if(node != null)
            {
                minheap.offer(node);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while (minheap.size() > 0) 
        {
            ListNode smallest = minheap.poll();
            curr.next = smallest;
            curr = curr.next;
            
            if(smallest.next != null)
            {
                minheap.offer(smallest.next);
            }
        }
        curr.next = null;
        return dummy.next;
        // TC: O(N log K)
        // SC: O(K)
    }

    public static void main(String[] args) 
    {
        
    }


}
