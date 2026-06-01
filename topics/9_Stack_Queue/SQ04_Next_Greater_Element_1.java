import java.util.*;

public class SQ04_Next_Greater_Element_1
{
    public static int[] nextGreaterElement_optimal(int[] nums1, int[] nums2)
    {
        Stack<Integer> st = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = nums2.length - 1; i >= 0; i--)
        {
            while (!st.isEmpty() && st.peek() <= nums2[i])
            {
                st.pop();
            }

            map.put(nums2[i], st.isEmpty() ? -1 : st.peek());
            st.push(nums2[i]);
        }

        int[] ans = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++)
        {
            ans[i] = map.get(nums1[i]);
        }

        return ans;
        //TC = O(n1 + n2)
        // SC = O(n1)
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2)
    {
        int[] r = new int[nums1.length];
        int y = 0;
        for (int i = 0; i < nums1.length; i++)
        {
            int x = nums1[i];
            int index = -1;
            r[y] = -1;
            for (int j = 0; j < nums2.length; j++)
            {
                if (nums2[j] == x)
                {
                    index = j;
                    break;
                }
            }
            for (int k = index + 1; k < nums2.length; k++)
            {
                if (nums2[k] > x)
                {
                    r[y] = nums2[k];
                }
                break;
            }
            y++;
        }
        return r;
    }

    public static void main(String[] args)
    {
        int n1[] = { 4, 1, 2 };
        int n2[] = { 1, 3, 4, 2 };

        int result[] = nextGreaterElement_optimal(n1, n2);

        for (int i = 0; i < result.length; i++)
        {
            System.out.println(result[i]);
        }

    }
}
