package Structures;
public class Queue<T> implements QueueInterface<T>
{
    protected int front;
    protected int back;
    protected int numItems;
    protected T[] items;

    public Queue()
    {
        front = 0;
        back = 0;
        numItems = 0;
        items = (T[]) new Object[3];
    }

    public boolean isEmpty()
    {
        return numItems == 0;
    }

    public void enqueue(T item)
    {
        if(numItems == items.length) {
            resize();
        }

        items[back] = item;
        back = (back + 1) % items.length;
        numItems++;
    }

    protected void resize()
    {
        T[] temp = (T[]) new Object[items.length << 1];

        for(int i = 0; i < numItems; i++) {
            temp[i] = items[(front + i) % items.length];
        }
		
	items = temp;
	front = 0;
	back = numItems;
    }

    public T dequeue() throws QueueException
    {
        if(numItems == 0) {
            throw new QueueException("QueueException on dequeue.");
        }

        T result = items[front];
        items[front] = null;
        front = (front + 1) % items.length;
        numItems--;

        return result;
    }

    public void dequeueAll()
    {
        front = 0;
        back = 0;
        numItems = 0;
        items = (T[]) new Object[3];
    }

    public T peek() throws QueueException
    {
        if(numItems == 0) {
            throw new QueueException("QueueException on peek.");
        }

        return items[front];
    }

    public String toString()
    {
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < numItems; i++) {
            result.append(items[(front + i) % items.length] + " ");
        }

        return result.toString();
    }
}
