public class ReverseStringTest {
    public static void main(String[] args) {

        String s = "hello world";
        System.out.println(ReverseString.operation(s));


    }
}

class ReverseString{
    public static String operation(String s)
    {
        int length = s.length();

        if (length <= 1) return s;


        String left = s.substring(0, length/2);
        String right = s.substring(length/2, s.length());

        return operation(right) + operation(left);
    }
}
