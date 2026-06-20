import java.util.HashMap;

public class SW_05_Fruits_Into_Baskets
{
    public static int totalFruit(int[] fruits)
    {
        int maxlength = 0;
        int l = 0;
        int r = 0;
        HashMap <Integer , Integer> map = new HashMap<>();

        while (r < fruits.length) 
        {
            map.put(fruits[r] ,map.getOrDefault(fruits[r], 0)+1); 
            if(map.size() > 2)
            {
                while (map.size() > 2) 
                {
                    map.put( fruits[l] , map.get(fruits[l]) - 1);
                    if(map.get(fruits[l]) == 0)
                    {
                        map.remove(fruits[l]);
                    }
                    l++; 
                    
                }
            }
            maxlength = Math.max(maxlength, r - l + 1);
            r++;
        }
        return maxlength;
    }

    public static void main(String[] args) 
    {
        int fruits[] = {1,1,2,3,2,2};

        System.out.println(totalFruit(fruits));
    }
}
