import java.util.Stack;

public class QueueUsingStack{

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(0);
        myQueue.push(1);
        myQueue.push(2);

        System.out.println(myQueue.pop());
    }

}


class MyQueue{

    Stack<Integer> frontStack;
    Stack<Integer> backStack;

    public MyQueue()
    {
        frontStack = new Stack<>();
        backStack = new Stack<>();
    }

    public void push(int x)
    {
        frontStack.push(x);
    }

    public int pop(){
        peek();
        return backStack.pop();
    }

    public int peek(){
        if(backStack.isEmpty())
        {
            while(!frontStack.isEmpty())
            {
                backStack.push(frontStack.pop());
            }
        }
        return backStack.peek();
    }

    public boolean empty()
    {
        return frontStack.isEmpty() && backStack.isEmpty();
    }
}