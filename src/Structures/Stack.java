package Structures;
public class Stack<T> implements StackInterface<T>
{
    private Node<T> top;

    public Stack()
    {
        top = null;
    }

    public boolean isEmpty()
    {
        return top == null;
    }

    public T peek() throws StackException
    {
        if(top == null) {
            throw new StackException("Stack exception on peek.");
        }

        return top.getItem();
    }

    public T pop() throws StackException
    {
        if(top == null) {
            throw new StackException("Stack exception on pop.");
        }

        T result = top.getItem();
        top = top.getNext();

        return result;
    }

    public void push(T item)
    {
        top = new Node(item, top);
    }

    public void popAll()
    {
        top = null;
    }

    public String toString()
    {
        StringBuilder result = new StringBuilder();
        Node curr = top;

        while(curr != null) {
            result.append(curr.getItem()+" ");
            curr = curr.getNext();
        }

        return result.toString();
    }
}
