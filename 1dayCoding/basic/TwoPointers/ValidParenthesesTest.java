import java.util.Stack;

public class ValidParenthesesTest {
    public static void main(String[] args) {
        
    }

}

class ValidParentheses{
    public boolean Operation(String str){
        Stack<Character> stack = new Stack<>();

        for( char c : str.toCharArray())
        {
            if(c == '(')
            {
                stack.push(')');
            }else if(c == '{')
            {
                stack.push('}');
            }else if(c == '[')
            {
                stack.push(']');
            }else if(stack.isEmpty() || stack.pop() != c){
                return false;
            }
        }

        return stack.isEmpty();

    }
}
