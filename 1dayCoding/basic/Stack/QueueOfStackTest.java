import java.util.LinkedList;
import java.util.Queue;

public class QueueOfStackTest {
    public static void main(String[] args) {
        MyStack stack  = new MyStack();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.pop());
    }
}


class MyStack{

    Queue<Integer> queue;
    public MyStack()
    {
        queue = new LinkedList<>();
    }

    public void push(int x)
    {
        queue.add(x);
        for(int i = 0 ; i < queue.size() -1 ; i++)
        {
            queue.add(queue.poll());
        }
    }

    public int pop()
    {
        return queue.poll();
    }

    public int top()
    {
        return queue.peek();
    }

    public boolean empty(){
        return queue.isEmpty();
    }
}