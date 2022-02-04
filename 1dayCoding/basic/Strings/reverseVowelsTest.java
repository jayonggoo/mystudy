public class reverseVowelsTest {
    public static void main(String[] args) {
        System.out.println(reverseVowels.operation("hello"));
    }
}

class reverseVowels{
    public static String operation(String s)
    {

        if(s == null || s.length() == 0)
        {
            return s;
        }

        String vowels = "aeiouAEIOU";
        char[] chars = s.toCharArray();
        int start = 0;
        int end = s.length() - 1;

        while(start < end)
        {
            while(start < end && !vowels.contains(chars[start] + ""))
            {
                start++;
            }

            while(start < end && !vowels.contains(chars[end] + ""))
            {
                end--;
            }

            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;

            start++;
            end--;
        }

        return new String(chars);

    }
}