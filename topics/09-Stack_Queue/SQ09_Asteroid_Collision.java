import java.util.*;

public class SQ09_Asteroid_Collision
{
    public static int[] asteroidCollision2(int[] asteroids)
    {

        Stack<Integer> st = new Stack<>();

        for (int asteroid : asteroids)
        {

            boolean destroyed = false;

            while (!st.isEmpty() && st.peek() > 0 && asteroid < 0)
            {

                if (st.peek() < -asteroid)
                {
                    st.pop();
                } 
                else if (st.peek() == -asteroid)
                {
                    st.pop();
                    destroyed = true;
                    break;
                } else
                {
                    destroyed = true;
                    break;
                }
            }

            if (!destroyed)
            {
                st.push(asteroid);
            }
        }

        int[] res = new int[st.size()];

        for (int i = st.size() - 1; i >= 0; i--)
        {
            res[i] = st.pop();
        }

        return res;
    }

    public static void main(String[] args)
    {

        int[] ast = { -2,-1,1,2};

        int[] res = asteroidCollision2(ast);

        for (int i = 0; i < res.length; i++)
        {
            System.out.println(res[i]);
        }
    }
}
