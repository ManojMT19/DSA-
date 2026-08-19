import java.security.Key;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class H_17_Task_Scheduler // Leetcode 621
{
    public static int leastInterval(char[] tasks, int n) 
    {
        int freq[] = new int[26];

        for(char t : tasks)
        {
            freq[t - 'A']++;
        }

        Arrays.sort(freq);

        int maxfreq = freq[25];

        int empty = (maxfreq - 1)*n;

        for(int i = 24 ; i >= 0 ; i--)
        {
            empty -= Math.min(maxfreq - 1, freq[i]);
        }

        if(empty > 0)
        {
            return tasks.length + empty;
        }

        return tasks.length;
    }
    
    public static int leastInterval_optimal(char[] tasks, int n) 
    {
        // Array to store frequency of each task (A-Z)
        int charFreq[] = new int[26];

        // Max heap to always pick the task
        // with the highest remaining frequency
        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>((a, b) -> b - a);

        // Step 1:
        // Count frequency of each task
        for(int i = 0; i < tasks.length; i++) {

            // Convert task character to index
            // 'A' → 0, 'B' → 1, etc
            charFreq[tasks[i] - 'A']++;
        }

        // Step 2:
        // Insert all non-zero frequencies into max heap
        for(int i = 0; i < 26; i++) {
            if(charFreq[i] > 0) {
                maxHeap.add(charFreq[i]);
            }
        }

        // Total time required
        int ans = 0;

        // Step 3:
        // Continue scheduling until all tasks are completed
        while(!maxHeap.isEmpty()) {

            // Number of tasks executed in current cycle
            int taskCycle = 0;

            // Each cycle length
            int cycle = n + 1;

            // Temporary list to store remaining tasks
            // that still need to be executed later
            ArrayList<Integer> list = new ArrayList<>();

            // Step 4:
            // Execute up to (n+1) tasks in this cycle
            while(cycle > 0 && !maxHeap.isEmpty()) {

                // Pick task with highest frequency
                int currTask = maxHeap.poll();

                // If this task still has remaining executions,
                // store it to be reinserted later
                if(currTask > 1) {
                    list.add(currTask - 1);
                }

                // One task executed
                taskCycle++;

                // Decrease cycle slot
                cycle--;
            }

            // Step 5:
            // Reinsert remaining tasks back into heap
            for(int ele : list) {
                maxHeap.add(ele);
            }

            // Step 6:
            // If heap is empty, no idle slots are needed
            // Otherwise full cycle must be counted
            ans += maxHeap.isEmpty() ? taskCycle : n + 1;
        }

        // Return total intervals required
        return ans;
    }

    
    public static void main(String[] args) {
        char []tasks = {'A','A','A','B','B','B'};
        int n = 2;

        System.out.println(leastInterval(tasks, n));
        System.out.println(leastInterval_optimal(tasks, n));
    }
}
