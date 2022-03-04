public class CountSegments {

    public static void main(String[] args) {
        String input = "Hello, my name is John";
        System.out.println(operation(input));
    }

    public static int operation(String s)
    {
        int res = 0;
        for(int i = 0 ; i < s.length(); i++)
        {
            if(s.charAt(i) != ' ' && (i == 0 || s.charAt(i - 1) == ' ') )
            {
                res++;
            }
        }
        return res;
    }
}
