import java.util.*;

public class H_07_Top_K_Frequent 
{
    public static void Top_K_Freq_No(int num[] , int k)
    {
        HashMap<Integer , Integer> map = new HashMap<>();

        for (int i = 0; i < num.length; i++)
        {
            map.put(num[i], map.getOrDefault(num[i],0)+1);
        }

        PriorityQueue<int[]> minheap = new PriorityQueue<>((a,b) -> Integer.compare(a[0],b[0]));

        for(Map.Entry<Integer,Integer> entry : map.entrySet())
        {
            int key = entry.getKey();
            int freq = entry.getValue();

            minheap.add(new int[]{freq , key});

            if (minheap.size() > k) 
            {
                minheap.poll();    
            }
        }

        while (minheap.size() > 0) 
        {
            System.out.println(minheap.poll()[1]);    
        }

    }

    public static List<Integer> Freq_Sort(int nums[]) // similar but without K (Just add everything to minheap), we can do without heaps also
    {
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int n : nums)
        {
            map.put(n, map.getOrDefault(n, 0)+1);
        }

        PriorityQueue<Map.Entry<Integer , Integer>> minheap = new PriorityQueue<>((a,b) -> Integer.compare(a.getValue(), b.getValue()));

        for(Map.Entry<Integer , Integer> entry : map.entrySet())
        {
            minheap.add(entry);
        }

        ArrayList<Integer> result = new ArrayList<>();

        while(minheap.size() > 0)
        {
            result.add(minheap.poll().getKey());
        }

        Collections.reverse(result);
            
        return result;
    }

    public static List<String> Top_K_Freq_Words(String[] words, int k)
    {
        HashMap<String, Integer> map = new HashMap<>();
    
        for (int i = 0; i < words.length; i++)
        {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }
    
        PriorityQueue<Map.Entry<String, Integer>> minheap =
            new PriorityQueue<>((a, b) -> {
    
                if (!a.getValue().equals(b.getValue()))
                {
                    return Integer.compare(a.getValue(), b.getValue());
                }
    
                return b.getKey().compareTo(a.getKey());
            });
    
        for (Map.Entry<String, Integer> entry : map.entrySet())
        {
            minheap.add(entry);
    
            if (minheap.size() > k)
            {
                minheap.poll();
            }
        }
    
        List<String> ans = new ArrayList<>();
    
        while (!minheap.isEmpty())
        {
            ans.add(minheap.poll().getKey());
        }
    
        Collections.reverse(ans);// reverse to get in order (higher freq comes first)
    
        return ans;
    }

    public static void main(String[] args) 
    {
        // int num[] = {1,5,3,1,2,3,4,5,2,5,3,5};
        
        // Top_K_Freq_No(num, 3);

        int nums[] = {2,1,2,4,4,3,4,1,4,4,10,1,10};

        System.out.println(Freq_Sort(nums));

    }
    
}