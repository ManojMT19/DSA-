import java.util.ArrayList;
import java.util.List;

public class R_23_Combination_Sum_3
{
    public static void solve(int start , int k , int target,int sum , List<Integer> current , List<List<Integer>> result)
    {
        if(current.size() == k)
        {
            if(sum == target)
            {
                result.add(new ArrayList<>(current));
            }
            return ;
        }

        for(int i = start ; i <= 9 ; i++)
        {
            if(sum + i > target)break;

            current.add(i);
            sum += i;
            solve(i+1, k, target, sum, current, result);
            sum -= i;
            current.remove(current.size()-1);   
        }
    }

    public static List<List<Integer>> combinationSum3(int k, int n) 
    {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        solve(1, k, n, 0, current, ans);

        return ans;
    }

    public static void main(String[] args)
    {
        System.out.println(combinationSum3(3, 9));
    }
}
