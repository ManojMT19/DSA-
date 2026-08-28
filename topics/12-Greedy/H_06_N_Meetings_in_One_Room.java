import java.util.ArrayList;
import java.util.List;

public class H_06_N_Meetings_in_One_Room
{
    public static ArrayList<Integer> maxMeetings(int[] s, int[] f) 
    {
        List<List<Integer>> data = new ArrayList<>();

        for(int i = 0 ; i < s.length ; i++)
        {
            List<Integer> temp = new ArrayList<>();
            temp.add(s[i]);
            temp.add(f[i]);
            temp.add(i+1);

            data.add(temp);
        }

        data.sort((a,b) -> Integer.compare(a.get(1), b.get(1))); // Sort according to finsh time not duration 

        ArrayList<Integer> result = new ArrayList<>();
        
        result.add(data.get(0).get(2));
        int lastEnding = data.get(0).get(1);
        
        for(int i = 1 ; i < data.size() ; i++)
        {
            int start = data.get(i).get(0);
            int ending = data.get(i).get(1);

            if(start >= lastEnding)
            {
                result.add(data.get(i).get(2));
                lastEnding = ending;
            }
        }
        return result;
        // TC = O(n log n)
        // SC = O(n)
    }
    public static void main(String[] args) 
    {
        int s[] = {1, 3, 0, 5, 8, 5};
        int f[] = {2, 4, 6, 7, 9, 9};

        System.out.println(maxMeetings(s, f));
    }
}
