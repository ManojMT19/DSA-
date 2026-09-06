public class R_08_Palindrome
{
    public static boolean palindrome_2(char s[] , int left ,int right)
    {
        if(left >= right)return true;

        if(s[left] != s[right])
        {
            return false;
        }
        return palindrome_2(s, left+1, right-1);
    }
    public static boolean palindrome_1(char s[] , int left ,int right)
    {
        if(left >= right)return true;

        if(s[left] == s[right])
        {
            return palindrome_1(s, left+1, right-1);
        }
        return false;
    }

    public static void main(String[] args)
    {
        // char s[] = {'m','a','n','o','j'};
        char s[] = {'n','a','m','a','n'};
        System.out.println(palindrome_2(s, 0, s.length-1));
        System.out.println(palindrome_1(s, 0, s.length-1));
    }
}
