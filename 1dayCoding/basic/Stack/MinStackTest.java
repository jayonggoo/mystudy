import java.util.Stack;

class MinStack{

    Stack<Integer> stack;
    int min =0;

    public MinStack(){
        min = Integer.MAX_VALUE;
        stack = new Stack<>();
    }
    public void push(int x)
    {
        if(min  >= x)
        {
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop()
    { 
        if(stack.pop() == min)
        {
            min = stack.pop();
        }
    }

    public int top(){
        System.out.println(stack.peek());
        return stack.peek();
    }

    public int getMin(){
        System.out.println(min);
        return min;
    }
}

public class MinStackTest{
 
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin();   
        minStack.pop();
        minStack.top();
        minStack.getMin();     
    }
}


