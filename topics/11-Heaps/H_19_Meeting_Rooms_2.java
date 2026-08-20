import java.util.Arrays;
import java.util.PriorityQueue;

public class H_19_Meeting_Rooms_2 /// Leetcode 253
{
    public static int meetingRooms_Brute(int[][] intervals)
    {
        int maxRooms = 0;

        for (int[] currentMeeting : intervals)
        {
            int currentTime = currentMeeting[0];
            int activeMeetings = 0;

            for (int[] meeting : intervals)
            {
                if (meeting[0] <= currentTime && currentTime < meeting[1])
                {
                    activeMeetings++;
                }
            }

            maxRooms = Math.max(maxRooms, activeMeetings);
        }
        return maxRooms;
        // TC = O(n^2)
        // SC = O(1)
    }

    public static int meetingRooms_Optimal(int[][] intervals)
    {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));      
        PriorityQueue<Integer> minheap = new PriorityQueue<>();

        for (int[] meeting : intervals)
        {
            int start = meeting[0];
            int end = meeting[1];

            if (!minheap.isEmpty() && minheap.peek() <= start)
            {
                minheap.poll();
            }

            minheap.offer(end);
        }
        return minheap.size();
        // TC = O(n log n)
        // SC = O(n)
    }

    public static void main(String[] args)
    {
        int intervals[][] = { { 0, 30 }, { 5, 10 }, { 15, 20 } };

        System.out.println(meetingRooms_Brute(intervals));
        System.out.println(meetingRooms_Optimal(intervals));
    }
}
