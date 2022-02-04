public class AddBinaryTest {

    public static void main(String[] args) {
        String str1 = "11";
        String str2 = "1";

        System.out.println(AddBinary.operation(str1, str2));
    }
}

class AddBinary{
    public static String operation(String str1, String str2)
    {
        StringBuilder sb = new StringBuilder();
        int i = str1.length() - 1, j= str2.length() -1 ,carry = 0;
        while(i >= 0 || j >=0)
        {
            int sum = carry;
            if( j >= 0) sum += str2.charAt(j--) - '0';
            if( i >= 0) sum += str1.charAt(i--) - '0';

            sb.append(sum%2);
            carry = sum / 2;
        }
        if(carry != 0) {
            sb.append(carry);
        }

        return sb.reverse().toString();
    }
}
