import java.util.ArrayList;

public class r4_ASCII
{
    static void ascii(String r ,String s)
    {
        if(s.length() == 0)
        {
            System.out.println(r);
            return;
        }
        char c = s.charAt(0);
        ascii(r + c, s.substring(1));
        ascii(r, s.substring(1));
        ascii( r+ (c + 0), s.substring(1));
    }

    static ArrayList<String>ascii_2(String r ,String s)
    {
        if(s.length() == 0)
        {
            ArrayList<String>list = new ArrayList<>();
            list.add(r);
            return list;
        }
        char c = s.charAt(0);
        ArrayList<String> first =  ascii_2(r+c, s.substring(1));
        ArrayList<String> third = ascii_2(r+(c+0), s.substring(1));
        ArrayList<String> second = ascii_2(r, s.substring(1));

        first.addAll(second);
        first.addAll(third);

        return first;

    }
    public static void main(String[] args)
    {
        ArrayList<String> ans = new ArrayList<>();

        ans = ascii_2("", "abc");    

        System.out.println(ans);

    }
}
