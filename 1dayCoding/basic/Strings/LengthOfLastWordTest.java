//why build fail?


class Solution1{

    public static int lengthOfLastWord(String str)
    {
        return (str.trim().length() - str.trim().lastIndexOf(" ") - 1);
    }


}

public class LengthOfLastWordTest{

    public static void main(String[] args) {
        int value = Solution1.lengthOfLastWord("Hello World");
        System.out.println(value);
    }
}